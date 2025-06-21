package com.jd.ad.sdk.fdt.thread;

/* loaded from: classes23.dex */
public final class WorkExecutor {
    private static final java.util.concurrent.ScheduledThreadPoolExecutor POOL;

    static {
        java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new java.util.concurrent.ScheduledThreadPoolExecutor(1);
        POOL = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(30L, java.util.concurrent.TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.setRejectedExecutionHandler(new com.jd.ad.sdk.jad_ep.jad_an("Work"));
    }

    private WorkExecutor() {
    }

    public static java.util.concurrent.ScheduledFuture<?> execute(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        return POOL.schedule(runnable, j, timeUnit);
    }

    public static void execute(java.lang.Runnable runnable) {
        POOL.execute(runnable);
    }

    public static void remove(java.lang.Runnable runnable) {
        POOL.remove(runnable);
    }

    public static java.util.concurrent.ScheduledFuture<?> scheduleDelay(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        return POOL.schedule(runnable, j, timeUnit);
    }

    public static java.util.concurrent.ScheduledFuture<?> scheduleWithFixedDelay(java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        return POOL.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }
}
