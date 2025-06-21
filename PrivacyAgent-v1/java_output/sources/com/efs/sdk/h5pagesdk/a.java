package com.efs.sdk.h5pagesdk;

/* loaded from: classes22.dex */
public class a {
    private static final java.lang.String TAG = "com.efs.sdk.h5pagesdk.a";
    private static volatile java.util.concurrent.ScheduledThreadPoolExecutor i;
    private static java.util.concurrent.ThreadFactory j = new com.efs.sdk.h5pagesdk.a.AnonymousClass1();

    /* renamed from: com.efs.sdk.h5pagesdk.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        private java.util.concurrent.atomic.AtomicInteger k = new java.util.concurrent.atomic.AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("H5ThreadPoolExecutor" + this.k.addAndGet(1));
            return thread;
        }
    }

    private static java.util.concurrent.ScheduledThreadPoolExecutor a() {
        if (i == null) {
            synchronized (com.efs.sdk.h5pagesdk.a.class) {
                if (i == null) {
                    i = new java.util.concurrent.ScheduledThreadPoolExecutor(4, j);
                }
            }
        }
        return i;
    }

    public static void execute(java.lang.Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
