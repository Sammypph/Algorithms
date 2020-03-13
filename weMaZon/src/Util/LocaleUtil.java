package Util;

import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by oakinrele on Mar, 2020
 */
public final class LocaleUtil {
    public static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
    public static final Charset CHARSET_1252 = Charset.forName("CP1252");
    private static final ThreadLocal<TimeZone> userTimeZone = new ThreadLocal();
    private static final ThreadLocal<Locale> userLocale = new ThreadLocal();

    private LocaleUtil() {
    }

    public static void setUserTimeZone(TimeZone timezone) {
        userTimeZone.set(timezone);
    }

    //@SuppressForbidden("implementation around default locales in POI")
    public static TimeZone getUserTimeZone() {
        TimeZone timeZone = (TimeZone) userTimeZone.get();
        return timeZone != null ? timeZone : TimeZone.getDefault();
    }

    public static void resetUserTimeZone() {
        userTimeZone.remove();
    }

    public static void setUserLocale(Locale locale) {
        userLocale.set(locale);
    }

    //@SuppressForbidden("implementation around default locales in POI")
    public static Locale getUserLocale() {
        Locale locale = (Locale) userLocale.get();
        return locale != null ? locale : Locale.getDefault();
    }

    public static void resetUserLocale() {
        userLocale.remove();
    }

    public static Calendar getLocaleCalendar() {
        return getLocaleCalendar(getUserTimeZone());
    }

    public static Calendar getLocaleCalendar(int year, int month, int day) {
        return getLocaleCalendar(year, month, day, 0, 0, 0);
    }

    public static Calendar getLocaleCalendar(int year, int month, int day, int hour, int minute, int second) {
        Calendar cal = getLocaleCalendar();
        cal.set(year, month, day, hour, minute, second);
        cal.clear(14);
        return cal;
    }

    public static Calendar getLocaleCalendar(TimeZone timeZone) {
        return Calendar.getInstance(timeZone, getUserLocale());
    }
}
