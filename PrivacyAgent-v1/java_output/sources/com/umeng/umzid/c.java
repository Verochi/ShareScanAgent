package com.umeng.umzid;

/* loaded from: classes19.dex */
public class c {
    public static volatile java.util.concurrent.ScheduledThreadPoolExecutor a;
    public static java.util.concurrent.ThreadFactory b = new com.umeng.umzid.c.a();

    public class a implements java.util.concurrent.ThreadFactory {
        public java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("ZIDThreadPoolExecutor" + this.a.addAndGet(1));
            return thread;
        }
    }

    public static java.util.concurrent.ScheduledThreadPoolExecutor a() {
        if (a == null) {
            synchronized (com.umeng.umzid.c.class) {
                if (a == null) {
                    a = new java.util.concurrent.ScheduledThreadPoolExecutor(java.lang.Runtime.getRuntime().availableProcessors() * 4, b);
                }
            }
        }
        return a;
    }

    public static void a(java.lang.Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (java.lang.Throwable unused) {
        }
    }
}
