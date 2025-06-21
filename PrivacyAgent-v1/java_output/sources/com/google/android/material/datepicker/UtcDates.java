package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
class UtcDates {
    static final java.lang.String UTC = "UTC";
    static java.util.concurrent.atomic.AtomicReference<com.google.android.material.datepicker.TimeSource> timeSourceRef = new java.util.concurrent.atomic.AtomicReference<>();

    private UtcDates() {
    }

    public static long canonicalYearMonthDay(long j) {
        java.util.Calendar utcCalendar = getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return getDayCopy(utcCalendar).getTimeInMillis();
    }

    private static int findCharactersInDateFormatPattern(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, int i, int i2) {
        while (i2 >= 0 && i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            if (str.charAt(i2) == '\'') {
                do {
                    i2 += i;
                    if (i2 >= 0 && i2 < str.length()) {
                    }
                } while (str.charAt(i2) != '\'');
            }
            i2 += i;
        }
        return i2;
    }

    @android.annotation.TargetApi(24)
    public static android.icu.text.DateFormat getAbbrMonthDayFormat(java.util.Locale locale) {
        return getAndroidFormat("MMMd", locale);
    }

    @android.annotation.TargetApi(24)
    public static android.icu.text.DateFormat getAbbrMonthWeekdayDayFormat(java.util.Locale locale) {
        return getAndroidFormat("MMMEd", locale);
    }

    @android.annotation.TargetApi(24)
    private static android.icu.text.DateFormat getAndroidFormat(java.lang.String str, java.util.Locale locale) {
        android.icu.text.DateFormat instanceForSkeleton;
        instanceForSkeleton = android.icu.text.DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(getUtcAndroidTimeZone());
        return instanceForSkeleton;
    }

    public static java.util.Calendar getDayCopy(java.util.Calendar calendar) {
        java.util.Calendar utcCalendarOf = getUtcCalendarOf(calendar);
        java.util.Calendar utcCalendar = getUtcCalendar();
        utcCalendar.set(utcCalendarOf.get(1), utcCalendarOf.get(2), utcCalendarOf.get(5));
        return utcCalendar;
    }

    private static java.text.DateFormat getFormat(int i, java.util.Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i, locale);
        dateInstance.setTimeZone(getTimeZone());
        return dateInstance;
    }

    public static java.text.DateFormat getFullFormat() {
        return getFullFormat(java.util.Locale.getDefault());
    }

    public static java.text.DateFormat getFullFormat(java.util.Locale locale) {
        return getFormat(0, locale);
    }

    public static java.text.DateFormat getMediumFormat() {
        return getMediumFormat(java.util.Locale.getDefault());
    }

    public static java.text.DateFormat getMediumFormat(java.util.Locale locale) {
        return getFormat(2, locale);
    }

    public static java.text.DateFormat getMediumNoYear() {
        return getMediumNoYear(java.util.Locale.getDefault());
    }

    public static java.text.DateFormat getMediumNoYear(java.util.Locale locale) {
        java.text.SimpleDateFormat simpleDateFormat = (java.text.SimpleDateFormat) getMediumFormat(locale);
        simpleDateFormat.applyPattern(removeYearFromDateFormatPattern(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    public static java.text.SimpleDateFormat getSimpleFormat(java.lang.String str) {
        return getSimpleFormat(str, java.util.Locale.getDefault());
    }

    private static java.text.SimpleDateFormat getSimpleFormat(java.lang.String str, java.util.Locale locale) {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(getTimeZone());
        return simpleDateFormat;
    }

    public static java.text.SimpleDateFormat getTextInputFormat() {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(((java.text.SimpleDateFormat) java.text.DateFormat.getDateInstance(3, java.util.Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), java.util.Locale.getDefault());
        simpleDateFormat.setTimeZone(getTimeZone());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    public static java.lang.String getTextInputHint(android.content.res.Resources resources, java.text.SimpleDateFormat simpleDateFormat) {
        java.lang.String localizedPattern = simpleDateFormat.toLocalizedPattern();
        return localizedPattern.replaceAll("d", resources.getString(com.google.android.material.R.string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(com.google.android.material.R.string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(com.google.android.material.R.string.mtrl_picker_text_input_year_abbr));
    }

    public static com.google.android.material.datepicker.TimeSource getTimeSource() {
        com.google.android.material.datepicker.TimeSource timeSource = timeSourceRef.get();
        return timeSource == null ? com.google.android.material.datepicker.TimeSource.system() : timeSource;
    }

    private static java.util.TimeZone getTimeZone() {
        return java.util.TimeZone.getTimeZone(UTC);
    }

    public static java.util.Calendar getTodayCalendar() {
        java.util.Calendar now = getTimeSource().now();
        now.set(11, 0);
        now.set(12, 0);
        now.set(13, 0);
        now.set(14, 0);
        now.setTimeZone(getTimeZone());
        return now;
    }

    @android.annotation.TargetApi(24)
    private static android.icu.util.TimeZone getUtcAndroidTimeZone() {
        android.icu.util.TimeZone timeZone;
        timeZone = android.icu.util.TimeZone.getTimeZone(UTC);
        return timeZone;
    }

    public static java.util.Calendar getUtcCalendar() {
        return getUtcCalendarOf(null);
    }

    public static java.util.Calendar getUtcCalendarOf(@androidx.annotation.Nullable java.util.Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance(getTimeZone());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    @android.annotation.TargetApi(24)
    public static android.icu.text.DateFormat getYearAbbrMonthDayFormat(java.util.Locale locale) {
        return getAndroidFormat("yMMMd", locale);
    }

    @android.annotation.TargetApi(24)
    public static android.icu.text.DateFormat getYearAbbrMonthWeekdayDayFormat(java.util.Locale locale) {
        return getAndroidFormat("yMMMEd", locale);
    }

    @androidx.annotation.NonNull
    private static java.lang.String removeYearFromDateFormatPattern(@androidx.annotation.NonNull java.lang.String str) {
        int findCharactersInDateFormatPattern = findCharactersInDateFormatPattern(str, "yY", 1, 0);
        if (findCharactersInDateFormatPattern >= str.length()) {
            return str;
        }
        java.lang.String str2 = "EMd";
        int findCharactersInDateFormatPattern2 = findCharactersInDateFormatPattern(str, "EMd", 1, findCharactersInDateFormatPattern);
        if (findCharactersInDateFormatPattern2 < str.length()) {
            str2 = "EMd,";
        }
        return str.replace(str.substring(findCharactersInDateFormatPattern(str, str2, -1, findCharactersInDateFormatPattern) + 1, findCharactersInDateFormatPattern2), " ").trim();
    }

    public static void setTimeSource(@androidx.annotation.Nullable com.google.android.material.datepicker.TimeSource timeSource) {
        timeSourceRef.set(timeSource);
    }
}
