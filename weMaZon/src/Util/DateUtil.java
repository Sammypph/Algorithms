package Util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class DateUtil {
    public static final int SECONDS_PER_MINUTE = 60;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int HOURS_PER_DAY = 24;
    public static final int SECONDS_PER_DAY = 86400;
    private static final int BAD_DATE = -1;
    public static final long DAY_MILLISECONDS = 86400000L;
    private static final Pattern TIME_SEPARATOR_PATTERN = Pattern.compile(":");
    private static final Pattern date_ptrn1 = Pattern.compile("^\\[\\$\\-.*?\\]");
    private static final Pattern date_ptrn2 = Pattern.compile("^\\[[a-zA-Z]+\\]");
    private static final Pattern date_ptrn3a = Pattern.compile("[yYmMdDhHsS]");
    private static final Pattern date_ptrn3b = Pattern.compile("^[\\[\\]yYmMdDhHsS\\-T/,. :\"\\\\]+0*[ampAMP/]*$");
    private static final Pattern date_ptrn4 = Pattern.compile("^\\[([hH]+|[mM]+|[sS]+)\\]");
    private static ThreadLocal<Integer> lastFormatIndex = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return -1;
        }
    };
    private static ThreadLocal<String> lastFormatString = new ThreadLocal();
    private static ThreadLocal<Boolean> lastCachedResult = new ThreadLocal();

    protected DateUtil() {
    }

    public static double getExcelDate(Date date) {
        return getExcelDate(date, false);
    }

    public static double getExcelDate(Date date, boolean use1904windowing) {
        Calendar calStart = LocaleUtil.getLocaleCalendar();
        calStart.setTime(date);
        return internalGetExcelDate(calStart, use1904windowing);
    }

    public static double getExcelDate(Calendar date, boolean use1904windowing) {
        return internalGetExcelDate((Calendar)date.clone(), use1904windowing);
    }

    private static double internalGetExcelDate(Calendar date, boolean use1904windowing) {
        if (!use1904windowing && date.get(1) < 1900 || use1904windowing && date.get(1) < 1904) {
            return -1.0D;
        } else {
            double fraction = (double)(((date.get(11) * 60 + date.get(12)) * 60 + date.get(13)) * 1000 + date.get(14)) / 8.64E7D;
            Calendar calStart = dayStart(date);
            double value = fraction + (double)absoluteDay(calStart, use1904windowing);
            if (!use1904windowing && value >= 60.0D) {
                ++value;
            } else if (use1904windowing) {
                --value;
            }

            return value;
        }
    }

    public static Date getJavaDate(double date, TimeZone tz) {
        return getJavaDate(date, false, tz, false);
    }

    public static Date getJavaDate(double date) {
        return getJavaDate(date, false, (TimeZone)null, false);
    }

    public static Date getJavaDate(double date, boolean use1904windowing, TimeZone tz) {
        return getJavaDate(date, use1904windowing, tz, false);
    }

    public static Date getJavaDate(double date, boolean use1904windowing, TimeZone tz, boolean roundSeconds) {
        Calendar calendar = getJavaCalendar(date, use1904windowing, tz, roundSeconds);
        return calendar == null ? null : calendar.getTime();
    }

    public static Date getJavaDate(double date, boolean use1904windowing) {
        return getJavaDate(date, use1904windowing, (TimeZone)null, false);
    }

    public static void setCalendar(Calendar calendar, int wholeDays, int millisecondsInDay, boolean use1904windowing, boolean roundSeconds) {
        int startYear = 1900;
        int dayAdjust = -1;
        if (use1904windowing) {
            startYear = 1904;
            dayAdjust = 1;
        } else if (wholeDays < 61) {
            dayAdjust = 0;
        }

        calendar.set(startYear, 0, wholeDays + dayAdjust, 0, 0, 0);
        calendar.set(14, millisecondsInDay);
        if (calendar.get(14) == 0) {
            calendar.clear(14);
        }

        if (roundSeconds) {
            calendar.add(14, 500);
            calendar.clear(14);
        }

    }

    public static Calendar getJavaCalendar(double date) {
        return getJavaCalendar(date, false, (TimeZone)null, false);
    }

    public static Calendar getJavaCalendar(double date, boolean use1904windowing) {
        return getJavaCalendar(date, use1904windowing, (TimeZone)null, false);
    }

    public static Calendar getJavaCalendarUTC(double date, boolean use1904windowing) {
        return getJavaCalendar(date, use1904windowing, LocaleUtil.TIMEZONE_UTC, false);
    }

    public static Calendar getJavaCalendar(double date, boolean use1904windowing, TimeZone timeZone) {
        return getJavaCalendar(date, use1904windowing, timeZone, false);
    }

    public static Calendar getJavaCalendar(double date, boolean use1904windowing, TimeZone timeZone, boolean roundSeconds) {
        if (!isValidExcelDate(date)) {
            return null;
        } else {
            int wholeDays = (int)Math.floor(date);
            int millisecondsInDay = (int)((date - (double)wholeDays) * 8.64E7D + 0.5D);
            Calendar calendar;
            if (timeZone != null) {
                calendar = LocaleUtil.getLocaleCalendar(timeZone);
            } else {
                calendar = LocaleUtil.getLocaleCalendar();
            }

            setCalendar(calendar, wholeDays, millisecondsInDay, use1904windowing, roundSeconds);
            return calendar;
        }
    }

    private static boolean isCached(String formatString, int formatIndex) {
        String cachedFormatString = (String)lastFormatString.get();
        return cachedFormatString != null && formatIndex == (Integer)lastFormatIndex.get() && formatString.equals(cachedFormatString);
    }

    private static void cache(String formatString, int formatIndex, boolean cached) {
        lastFormatIndex.set(formatIndex);
        lastFormatString.set(formatString);
        lastCachedResult.set(cached);
    }

    public static boolean isADateFormat(int formatIndex, String formatString) {
        if (isInternalDateFormat(formatIndex)) {
            cache(formatString, formatIndex, true);
            return true;
        } else if (formatString != null && formatString.length() != 0) {
            if (isCached(formatString, formatIndex)) {
                return (Boolean)lastCachedResult.get();
            } else {
                String fs = formatString;
                int length = formatString.length();
                StringBuilder sb = new StringBuilder(length);

                int separatorIndex;
                for(separatorIndex = 0; separatorIndex < length; ++separatorIndex) {
                    char c = fs.charAt(separatorIndex);
                    if (separatorIndex < length - 1) {
                        char nc = fs.charAt(separatorIndex + 1);
                        if (c == '\\') {
                            switch(nc) {
                                case ' ':
                                case ',':
                                case '-':
                                case '.':
                                case '\\':
                                    continue;
                            }
                        } else if (c == ';' && nc == '@') {
                            ++separatorIndex;
                            continue;
                        }
                    }

                    sb.append(c);
                }

                fs = sb.toString();
                if (date_ptrn4.matcher(fs).matches()) {
                    cache(formatString, formatIndex, true);
                    return true;
                } else {
                    fs = date_ptrn1.matcher(fs).replaceAll("");
                    fs = date_ptrn2.matcher(fs).replaceAll("");
                    separatorIndex = fs.indexOf(59);
                    if (0 < separatorIndex && separatorIndex < fs.length() - 1) {
                        fs = fs.substring(0, separatorIndex);
                    }

                    if (!date_ptrn3a.matcher(fs).find()) {
                        return false;
                    } else {
                        boolean result = date_ptrn3b.matcher(fs).matches();
                        cache(formatString, formatIndex, result);
                        return result;
                    }
                }
            }
        } else {
            return false;
        }
    }

    public static boolean isInternalDateFormat(int format) {
        switch(format) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 45:
            case 46:
            case 47:
                return true;
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            default:
                return false;
        }
    }

//    public static boolean isCellDateFormatted(Cell cell) {
//        if (cell == null) {
//            return false;
//        } else {
//            boolean bDate = false;
//            double d = cell.getNumericCellValue();
//            if (isValidExcelDate(d)) {
//                CellStyle style = cell.getCellStyle();
//                if (style == null) {
//                    return false;
//                }
//
//                int i = style.getDataFormat();
//                String f = style.getDataFormatString();
//                bDate = isADateFormat(i, f);
//            }
//
//            return bDate;
//        }
//    }
//
//    public static boolean isCellInternalDateFormatted(Cell cell) {
//        if (cell == null) {
//            return false;
//        } else {
//            boolean bDate = false;
//            double d = cell.getNumericCellValue();
//            if (isValidExcelDate(d)) {
//                CellStyle style = cell.getCellStyle();
//                int i = style.getDataFormat();
//                bDate = isInternalDateFormat(i);
//            }
//
//            return bDate;
//        }
//    }

    public static boolean isValidExcelDate(double value) {
        return value > -4.9E-324D;
    }

    protected static int absoluteDay(Calendar cal, boolean use1904windowing) {
        return cal.get(6) + daysInPriorYears(cal.get(1), use1904windowing);
    }

    private static int daysInPriorYears(int yr, boolean use1904windowing) {
        if ((use1904windowing || yr >= 1900) && (!use1904windowing || yr >= 1904)) {
            int yr1 = yr - 1;
            int leapDays = yr1 / 4 - yr1 / 100 + yr1 / 400 - 460;
            return 365 * (yr - (use1904windowing ? 1904 : 1900)) + leapDays;
        } else {
            throw new IllegalArgumentException("'year' must be 1900 or greater");
        }
    }

    private static Calendar dayStart(Calendar cal) {
        cal.get(11);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        cal.get(11);
        return cal;
    }

    public static double convertTime(String timeStr) {
        try {
            return convertTimeInternal(timeStr);
        } catch (DateUtil.FormatException var3) {
            String msg = "Bad time format '" + timeStr + "' expected 'HH:MM' or 'HH:MM:SS' - " + var3.getMessage();
            throw new IllegalArgumentException(msg);
        }
    }

    private static double convertTimeInternal(String timeStr) throws DateUtil.FormatException {
        int len = timeStr.length();
        if (len >= 4 && len <= 8) {
            String[] parts = TIME_SEPARATOR_PATTERN.split(timeStr);
            String secStr;
            switch(parts.length) {
                case 2:
                    secStr = "00";
                    break;
                case 3:
                    secStr = parts[2];
                    break;
                default:
                    throw new DateUtil.FormatException("Expected 2 or 3 fields but got (" + parts.length + ")");
            }

            String hourStr = parts[0];
            String minStr = parts[1];
            int hours = parseInt(hourStr, "hour", 24);
            int minutes = parseInt(minStr, "minute", 60);
            int seconds = parseInt(secStr, "second", 60);
            double totalSeconds = (double)(seconds + (minutes + hours * 60) * 60);
            return totalSeconds / 86400.0D;
        } else {
            throw new DateUtil.FormatException("Bad length");
        }
    }

    public static Date parseYYYYMMDDDate(String dateStr) {
        try {
            return parseYYYYMMDDDateInternal(dateStr);
        } catch (DateUtil.FormatException var3) {
            String msg = "Bad time format " + dateStr + " expected 'YYYY/MM/DD' - " + var3.getMessage();
            throw new IllegalArgumentException(msg);
        }
    }

    private static Date parseYYYYMMDDDateInternal(String timeStr) throws DateUtil.FormatException {
        if (timeStr.length() != 10) {
            throw new DateUtil.FormatException("Bad length");
        } else {
            String yearStr = timeStr.substring(0, 4);
            String monthStr = timeStr.substring(5, 7);
            String dayStr = timeStr.substring(8, 10);
            int year = parseInt(yearStr, "year", -32768, 32767);
            int month = parseInt(monthStr, "month", 1, 12);
            int day = parseInt(dayStr, "day", 1, 31);
            Calendar cal = LocaleUtil.getLocaleCalendar(year, month - 1, day);
            return cal.getTime();
        }
    }

    private static int parseInt(String strVal, String fieldName, int rangeMax) throws DateUtil.FormatException {
        return parseInt(strVal, fieldName, 0, rangeMax - 1);
    }

    private static int parseInt(String strVal, String fieldName, int lowerLimit, int upperLimit) throws DateUtil.FormatException {
        int result;
        try {
            result = Integer.parseInt(strVal);
        } catch (NumberFormatException var6) {
            throw new DateUtil.FormatException("Bad int format '" + strVal + "' for " + fieldName + " field");
        }

        if (result >= lowerLimit && result <= upperLimit) {
            return result;
        } else {
            throw new DateUtil.FormatException(fieldName + " value (" + result + ") is outside the allowable range(0.." + upperLimit + ")");
        }
    }

    private static final class FormatException extends Exception {
        public FormatException(String msg) {
            super(msg);
        }
    }
}
