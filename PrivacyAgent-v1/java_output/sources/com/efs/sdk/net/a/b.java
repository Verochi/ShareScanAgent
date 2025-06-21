package com.efs.sdk.net.a;

/* loaded from: classes22.dex */
public class b {
    private static final java.lang.String a = "com.efs.sdk.net.a.b";
    private static volatile java.util.concurrent.ScheduledThreadPoolExecutor b;
    private static java.util.concurrent.ThreadFactory c = new com.efs.sdk.net.a.b.AnonymousClass1();

    /* renamed from: com.efs.sdk.net.a.b$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        private java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("NetThreadPoolExecutor" + this.a.addAndGet(1));
            return thread;
        }
    }

    private static java.util.concurrent.ScheduledThreadPoolExecutor a() {
        if (b == null) {
            synchronized (com.efs.sdk.net.a.b.class) {
                if (b == null) {
                    b = new java.util.concurrent.ScheduledThreadPoolExecutor(4, c);
                }
            }
        }
        return b;
    }

    public static void a(java.lang.Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
