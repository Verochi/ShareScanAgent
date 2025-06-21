package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
class DateStrings {
    private DateStrings() {
    }

    public static androidx.core.util.Pair<java.lang.String, java.lang.String> getDateRangeString(@androidx.annotation.Nullable java.lang.Long l, @androidx.annotation.Nullable java.lang.Long l2) {
        return getDateRangeString(l, l2, null);
    }

    public static androidx.core.util.Pair<java.lang.String, java.lang.String> getDateRangeString(@androidx.annotation.Nullable java.lang.Long l, @androidx.annotation.Nullable java.lang.Long l2, @androidx.annotation.Nullable java.text.SimpleDateFormat simpleDateFormat) {
        if (l == null && l2 == null) {
            return androidx.core.util.Pair.create(null, null);
        }
        if (l == null) {
            return androidx.core.util.Pair.create(null, getDateString(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return androidx.core.util.Pair.create(getDateString(l.longValue(), simpleDateFormat), null);
        }
        java.util.Calendar todayCalendar = com.google.android.material.datepicker.UtcDates.getTodayCalendar();
        java.util.Calendar utcCalendar = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l.longValue());
        java.util.Calendar utcCalendar2 = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return androidx.core.util.Pair.create(simpleDateFormat.format(new java.util.Date(l.longValue())), simpleDateFormat.format(new java.util.Date(l2.longValue())));
        }
        return utcCalendar.get(1) == utcCalendar2.get(1) ? utcCalendar.get(1) == todayCalendar.get(1) ? androidx.core.util.Pair.create(getMonthDay(l.longValue(), java.util.Locale.getDefault()), getMonthDay(l2.longValue(), java.util.Locale.getDefault())) : androidx.core.util.Pair.create(getMonthDay(l.longValue(), java.util.Locale.getDefault()), getYearMonthDay(l2.longValue(), java.util.Locale.getDefault())) : androidx.core.util.Pair.create(getYearMonthDay(l.longValue(), java.util.Locale.getDefault()), getYearMonthDay(l2.longValue(), java.util.Locale.getDefault()));
    }

    public static java.lang.String getDateString(long j) {
        return getDateString(j, null);
    }

    public static java.lang.String getDateString(long j, @androidx.annotation.Nullable java.text.SimpleDateFormat simpleDateFormat) {
        java.util.Calendar todayCalendar = com.google.android.material.datepicker.UtcDates.getTodayCalendar();
        java.util.Calendar utcCalendar = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return simpleDateFormat != null ? simpleDateFormat.format(new java.util.Date(j)) : todayCalendar.get(1) == utcCalendar.get(1) ? getMonthDay(j) : getYearMonthDay(j);
    }

    public static java.lang.String getMonthDay(long j) {
        return getMonthDay(j, java.util.Locale.getDefault());
    }

    public static java.lang.String getMonthDay(long j, java.util.Locale locale) {
        java.lang.String format;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return com.google.android.material.datepicker.UtcDates.getMediumNoYear(locale).format(new java.util.Date(j));
        }
        format = com.google.android.material.datepicker.UtcDates.getAbbrMonthDayFormat(locale).format(new java.util.Date(j));
        return format;
    }

    public static java.lang.String getMonthDayOfWeekDay(long j) {
        return getMonthDayOfWeekDay(j, java.util.Locale.getDefault());
    }

    public static java.lang.String getMonthDayOfWeekDay(long j, java.util.Locale locale) {
        java.lang.String format;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return com.google.android.material.datepicker.UtcDates.getFullFormat(locale).format(new java.util.Date(j));
        }
        format = com.google.android.material.datepicker.UtcDates.getAbbrMonthWeekdayDayFormat(locale).format(new java.util.Date(j));
        return format;
    }

    public static java.lang.String getYearMonth(android.content.Context context, long j) {
        return android.text.format.DateUtils.formatDateTime(context, j - java.util.TimeZone.getDefault().getOffset(j), 36);
    }

    public static java.lang.String getYearMonthDay(long j) {
        return getYearMonthDay(j, java.util.Locale.getDefault());
    }

    public static java.lang.String getYearMonthDay(long j, java.util.Locale locale) {
        java.lang.String format;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return com.google.android.material.datepicker.UtcDates.getMediumFormat(locale).format(new java.util.Date(j));
        }
        format = com.google.android.material.datepicker.UtcDates.getYearAbbrMonthDayFormat(locale).format(new java.util.Date(j));
        return format;
    }

    public static java.lang.String getYearMonthDayOfWeekDay(long j) {
        return getYearMonthDayOfWeekDay(j, java.util.Locale.getDefault());
    }

    public static java.lang.String getYearMonthDayOfWeekDay(long j, java.util.Locale locale) {
        java.lang.String format;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return com.google.android.material.datepicker.UtcDates.getFullFormat(locale).format(new java.util.Date(j));
        }
        format = com.google.android.material.datepicker.UtcDates.getYearAbbrMonthWeekdayDayFormat(locale).format(new java.util.Date(j));
        return format;
    }
}
