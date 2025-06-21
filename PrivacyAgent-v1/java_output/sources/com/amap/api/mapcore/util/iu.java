package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class iu {
    private static long a(long j) {
        return j - b(j);
    }

    public static long a(long j, long j2) {
        try {
            return java.lang.Math.abs(j - j2) > 31536000000L ? b(j, j2) : j;
        } catch (java.lang.Throwable unused) {
            return j;
        }
    }

    private static long b(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(new java.util.Date(j));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static long b(long j, long j2) {
        long b = b(j2) + a(j);
        long abs = java.lang.Math.abs(b - j2);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(new java.util.Date(b));
        int i = calendar.get(11);
        if (i == 23 && abs >= 82800000) {
            b -= 86400000;
        }
        return (i != 0 || abs < 82800000) ? b : b + 86400000;
    }
}
