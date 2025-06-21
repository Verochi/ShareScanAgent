package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class av {
    private static final java.lang.String a = "UMExecutor";
    private static volatile java.util.concurrent.ScheduledThreadPoolExecutor b;
    private static final java.util.concurrent.ThreadFactory c = new com.umeng.analytics.pro.av.AnonymousClass1();

    /* renamed from: com.umeng.analytics.pro.av$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        private final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "ccg-" + this.a.incrementAndGet());
        }
    }

    private static java.util.concurrent.ScheduledThreadPoolExecutor a() {
        if (b == null) {
            synchronized (com.umeng.analytics.pro.av.class) {
                if (b == null) {
                    b = new java.util.concurrent.ScheduledThreadPoolExecutor(java.lang.Math.max(2, java.lang.Math.min(java.lang.Runtime.getRuntime().availableProcessors(), 4)), c);
                    b.setKeepAliveTime(3L, java.util.concurrent.TimeUnit.SECONDS);
                    b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return b;
    }

    public static void a(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j, timeUnit);
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "schedule error:" + th.getMessage());
        }
    }
}
