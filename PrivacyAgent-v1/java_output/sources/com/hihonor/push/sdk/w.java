package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public final class w {
    public static final com.hihonor.push.sdk.w c = new com.hihonor.push.sdk.w();
    public static final int d;
    public static final int e;
    public static final int f;
    public final java.util.concurrent.Executor a = new com.hihonor.push.sdk.w.c(null);
    public final java.util.concurrent.Executor b = new com.hihonor.push.sdk.w.b();

    public static final class b implements java.util.concurrent.Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(java.lang.Runnable runnable) {
            runnable.run();
        }
    }

    public static class c implements java.util.concurrent.Executor {
        public c() {
        }

        public /* synthetic */ c(com.hihonor.push.sdk.w.a aVar) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(java.lang.Runnable runnable) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = java.lang.Runtime.getRuntime().availableProcessors();
        d = availableProcessors;
        e = availableProcessors + 1;
        f = (availableProcessors * 2) + 1;
    }

    public static java.util.concurrent.ExecutorService a() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(e, f, 1L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static java.util.concurrent.Executor b() {
        return c.b;
    }

    public static java.util.concurrent.Executor c() {
        return c.a;
    }
}
