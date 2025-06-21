package com.umeng.innner.umcrash;

/* loaded from: classes19.dex */
public class UMCrashThreadPoolExecutorFactory {
    private static final java.lang.String TAG = "com.umeng.innner.umcrash.UMCrashThreadPoolExecutorFactory";
    private static java.util.concurrent.ThreadFactory threadFactory = new com.umeng.innner.umcrash.UMCrashThreadPoolExecutorFactory.AnonymousClass1();
    private static volatile java.util.concurrent.ScheduledThreadPoolExecutor threadPoolExecutor;

    /* renamed from: com.umeng.innner.umcrash.UMCrashThreadPoolExecutorFactory$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        private java.util.concurrent.atomic.AtomicInteger count = new java.util.concurrent.atomic.AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("UMCrashThreadPoolExecutor" + this.count.addAndGet(1));
            return thread;
        }
    }

    public static void execute(java.lang.Runnable runnable) {
        try {
            getScheduledExecutor().execute(runnable);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private static java.util.concurrent.ScheduledThreadPoolExecutor getScheduledExecutor() {
        if (threadPoolExecutor == null) {
            synchronized (com.umeng.innner.umcrash.UMCrashThreadPoolExecutorFactory.class) {
                if (threadPoolExecutor == null) {
                    threadPoolExecutor = new java.util.concurrent.ScheduledThreadPoolExecutor(2, threadFactory);
                }
            }
        }
        return threadPoolExecutor;
    }

    public static void schedule(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        try {
            getScheduledExecutor().schedule(runnable, j, timeUnit);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
