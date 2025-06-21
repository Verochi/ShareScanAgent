package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class ae {
    public static long a(long j, long j2) {
        return java.lang.Math.abs(j - j2) / 86400000;
    }

    public static java.util.Calendar a(long j, java.lang.String str) {
        java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        int parseInt = java.lang.Integer.parseInt(split[0]);
        int parseInt2 = java.lang.Integer.parseInt(split[1]);
        int parseInt3 = java.lang.Integer.parseInt(split[2]);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, parseInt);
        calendar.set(12, parseInt2);
        calendar.set(13, parseInt3);
        calendar.set(14, 0);
        return calendar;
    }

    public static boolean a(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(7);
        return i == 1 || i == 7;
    }

    private static boolean a(long j, java.lang.String str, java.lang.String str2) {
        java.util.Calendar a = a(j, str);
        java.util.Calendar a2 = a(j, str2);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return a2.before(a) ? calendar.after(a) || calendar.before(a2) : calendar.after(a) && calendar.before(a2);
    }

    private static boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.TimeZone timeZone = java.util.TimeZone.getTimeZone(str);
        java.util.TimeZone timeZone2 = java.util.TimeZone.getTimeZone(str2);
        java.util.TimeZone timeZone3 = java.util.TimeZone.getTimeZone(str3);
        int rawOffset = timeZone.getRawOffset();
        int rawOffset2 = timeZone2.getRawOffset();
        int rawOffset3 = timeZone3.getRawOffset();
        if (rawOffset2 > rawOffset3) {
            rawOffset3 = rawOffset2;
            rawOffset2 = rawOffset3;
        }
        return rawOffset >= rawOffset2 && rawOffset <= rawOffset3;
    }

    private static boolean a(java.util.TimeZone timeZone, java.util.TimeZone timeZone2, java.util.TimeZone timeZone3) {
        int rawOffset = timeZone.getRawOffset();
        int rawOffset2 = timeZone2.getRawOffset();
        int rawOffset3 = timeZone3.getRawOffset();
        if (rawOffset2 > rawOffset3) {
            rawOffset3 = rawOffset2;
            rawOffset2 = rawOffset3;
        }
        return rawOffset >= rawOffset2 && rawOffset <= rawOffset3;
    }

    private static long b(long j, long j2) {
        return a(b(j).getTime(), b(j2).getTime());
    }

    private static java.util.Date b(long j) {
        java.util.Date date = new java.util.Date(j);
        return new java.util.Date(date.getYear(), date.getMonth(), date.getDate());
    }
}
