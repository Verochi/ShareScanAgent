package com.aliyun.common.media;

/* loaded from: classes.dex */
public class TimeUnitUtil {
    private static int U2MS = 1000;
    private static int U2US = 1000000;
    private static float US2S = 1.0f / 1000000;
    private static float MS2S = 1.0f / 1000;

    private static float fromNanos(long j, java.util.concurrent.TimeUnit timeUnit) {
        return j / timeUnit.toNanos(1L);
    }

    public static float microToSecond(long j) {
        return j * US2S;
    }

    public static long microsToMills(float f) {
        return (long) (f / 1000.0f);
    }

    public static long millToMicros(float f) {
        return (long) (f * 1000.0f);
    }

    public static float millisToSecond(long j) {
        return j * MS2S;
    }

    public static long millisecondsToNanos(float f) {
        return toNanos(f, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public static float nanosToMilliseconds(long j) {
        return fromNanos(j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public static float nanosToSeconds(long j) {
        return fromNanos(j, java.util.concurrent.TimeUnit.SECONDS);
    }

    public static long secondsToMicros(float f) {
        return toMicros(f, java.util.concurrent.TimeUnit.SECONDS);
    }

    public static long secondsToMillis(float f) {
        return toMillis(f, java.util.concurrent.TimeUnit.SECONDS);
    }

    public static long secondsToNanos(float f) {
        return toNanos(f, java.util.concurrent.TimeUnit.SECONDS);
    }

    private static long toMicros(float f, java.util.concurrent.TimeUnit timeUnit) {
        return (long) (timeUnit.toMicros(1L) * f);
    }

    private static long toMillis(float f, java.util.concurrent.TimeUnit timeUnit) {
        return (long) (timeUnit.toMillis(1L) * f);
    }

    private static long toNanos(float f, java.util.concurrent.TimeUnit timeUnit) {
        return (long) (timeUnit.toNanos(1L) * f);
    }
}
