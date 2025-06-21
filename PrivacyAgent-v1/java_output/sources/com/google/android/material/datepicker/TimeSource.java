package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
class TimeSource {
    private static final com.google.android.material.datepicker.TimeSource SYSTEM_TIME_SOURCE = new com.google.android.material.datepicker.TimeSource(null, null);

    @androidx.annotation.Nullable
    private final java.lang.Long fixedTimeMs;

    @androidx.annotation.Nullable
    private final java.util.TimeZone fixedTimeZone;

    private TimeSource(@androidx.annotation.Nullable java.lang.Long l, @androidx.annotation.Nullable java.util.TimeZone timeZone) {
        this.fixedTimeMs = l;
        this.fixedTimeZone = timeZone;
    }

    public static com.google.android.material.datepicker.TimeSource fixed(long j) {
        return new com.google.android.material.datepicker.TimeSource(java.lang.Long.valueOf(j), null);
    }

    public static com.google.android.material.datepicker.TimeSource fixed(long j, @androidx.annotation.Nullable java.util.TimeZone timeZone) {
        return new com.google.android.material.datepicker.TimeSource(java.lang.Long.valueOf(j), timeZone);
    }

    public static com.google.android.material.datepicker.TimeSource system() {
        return SYSTEM_TIME_SOURCE;
    }

    public java.util.Calendar now() {
        return now(this.fixedTimeZone);
    }

    public java.util.Calendar now(@androidx.annotation.Nullable java.util.TimeZone timeZone) {
        java.util.Calendar calendar = timeZone == null ? java.util.Calendar.getInstance() : java.util.Calendar.getInstance(timeZone);
        java.lang.Long l = this.fixedTimeMs;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }
}
