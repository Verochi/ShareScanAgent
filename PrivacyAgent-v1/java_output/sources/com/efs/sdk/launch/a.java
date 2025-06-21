package com.efs.sdk.launch;

/* loaded from: classes22.dex */
public class a {
    private static final java.lang.String a = "com.efs.sdk.launch.a";
    private static volatile java.util.concurrent.ScheduledThreadPoolExecutor b;
    private static java.util.concurrent.ThreadFactory c = new com.efs.sdk.launch.a.AnonymousClass1();

    /* renamed from: com.efs.sdk.launch.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        private java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("LaunchThreadPoolExecutor" + this.a.addAndGet(1));
            return thread;
        }
    }

    private static java.util.concurrent.ScheduledThreadPoolExecutor a() {
        if (b == null) {
            synchronized (com.efs.sdk.launch.a.class) {
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
