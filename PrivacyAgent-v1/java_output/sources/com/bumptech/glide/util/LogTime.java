package com.bumptech.glide.util;

/* loaded from: classes.dex */
public final class LogTime {
    private static final double MILLIS_MULTIPLIER = 1.0d / java.lang.Math.pow(10.0d, 6.0d);

    private LogTime() {
    }

    public static double getElapsedMillis(long j) {
        return (getLogTime() - j) * MILLIS_MULTIPLIER;
    }

    @android.annotation.TargetApi(17)
    public static long getLogTime() {
        return android.os.SystemClock.elapsedRealtimeNanos();
    }
}
