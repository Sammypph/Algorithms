package Util;

import java.time.*;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oakinrele on Mar, 2020
 */
public class TimeHelper {
    public TimeHelper() {
    }

    public static LocalDateTime fromMillisToLDT(Long millis) {
        return millis == null ? null : LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
    }

    public static LocalDate fromMillisToLD(Long millis) {
        return millis == null ? null : LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault()).toLocalDate();
    }

    public static List<LocalDate> allDays(LocalDate startDate, LocalDate endDate) throws IllegalArgumentException {
        if (startDate.compareTo(endDate) > 0) {
            throw new IllegalArgumentException("start date should not come after end date");
        } else {
            List<LocalDate> allDays = new ArrayList();

            for(LocalDate date = startDate; date.compareTo(endDate) <= 0; date = date.plusDays(1L)) {
                allDays.add(date);
            }

            return allDays;
        }
    }

    public static Long fromLDTtoMillis(LocalDateTime localDateTime) {
        return localDateTime == null ? null : localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static class TemporalAdjusters {
        public TemporalAdjusters() {
        }

        public static TemporalAdjuster firstDayOfPreviousQuarter() {
            return (temporal) -> {
                int currentQuarter = YearMonth.from(temporal).get(IsoFields.QUARTER_OF_YEAR);
                if (currentQuarter == 1) {
                    return LocalDate.from(temporal).minusYears(1L).withMonth(Month.OCTOBER.getValue()).with(java.time.temporal.TemporalAdjusters.firstDayOfMonth());
                } else if (currentQuarter == 2) {
                    return LocalDate.from(temporal).withMonth(Month.JANUARY.getValue()).with(java.time.temporal.TemporalAdjusters.firstDayOfMonth());
                } else {
                    return currentQuarter == 3 ? LocalDate.from(temporal).withMonth(Month.APRIL.getValue()).with(java.time.temporal.TemporalAdjusters.firstDayOfMonth()) : LocalDate.from(temporal).withMonth(Month.JULY.getValue()).with(java.time.temporal.TemporalAdjusters.firstDayOfMonth());
                }
            };
        }

        public static TemporalAdjuster lastDayOfPreviousQuarter() {
            return (temporal) -> {
                int currentQuarter = YearMonth.from(temporal).get(IsoFields.QUARTER_OF_YEAR);
                if (currentQuarter == 1) {
                    return LocalDate.from(temporal).minusYears(1L).withMonth(Month.DECEMBER.getValue()).with(java.time.temporal.TemporalAdjusters.lastDayOfMonth());
                } else if (currentQuarter == 2) {
                    return LocalDate.from(temporal).withMonth(Month.MARCH.getValue()).with(java.time.temporal.TemporalAdjusters.lastDayOfMonth());
                } else {
                    return currentQuarter == 3 ? LocalDate.from(temporal).withMonth(Month.JUNE.getValue()).with(java.time.temporal.TemporalAdjusters.lastDayOfMonth()) : LocalDate.from(temporal).withMonth(Month.SEPTEMBER.getValue()).with(java.time.temporal.TemporalAdjusters.lastDayOfMonth());
                }
            };
        }
    }
}
