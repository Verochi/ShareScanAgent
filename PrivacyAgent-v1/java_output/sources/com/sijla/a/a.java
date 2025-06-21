package com.sijla.a;

/* loaded from: classes19.dex */
public final class a {
    private static java.util.concurrent.ScheduledThreadPoolExecutor a;

    static {
        java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new java.util.concurrent.ScheduledThreadPoolExecutor(2);
        a = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setMaximumPoolSize(3);
    }

    public static void a(java.lang.Runnable runnable) {
        a(runnable, 0L);
    }

    public static void a(java.lang.Runnable runnable, long j) {
        java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = a;
        if (scheduledThreadPoolExecutor == null) {
            if (j > 0) {
                runnable = new com.sijla.a.b(j, runnable);
            }
            new java.lang.Thread(runnable).start();
        } else if (j > 0) {
            scheduledThreadPoolExecutor.schedule(runnable, j, java.util.concurrent.TimeUnit.MILLISECONDS);
        } else {
            scheduledThreadPoolExecutor.submit(runnable);
        }
    }
}
