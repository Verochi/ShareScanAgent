package com.huawei.hmf.tasks.a;

/* loaded from: classes22.dex */
public final class a {
    public static final com.huawei.hmf.tasks.a.a b = new com.huawei.hmf.tasks.a.a();
    public static final int c;
    public static final int d;
    public static final int e;
    public final java.util.concurrent.Executor a = new com.huawei.hmf.tasks.a.a.ExecutorC0360a((byte) 0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a, reason: collision with other inner class name */
    public static class ExecutorC0360a implements java.util.concurrent.Executor {
        public ExecutorC0360a() {
        }

        public /* synthetic */ ExecutorC0360a(byte b) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(java.lang.Runnable runnable) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = java.lang.Runtime.getRuntime().availableProcessors();
        c = availableProcessors;
        d = availableProcessors + 1;
        e = (availableProcessors * 2) + 1;
    }

    public static java.util.concurrent.ExecutorService a() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(d, e, 1L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static java.util.concurrent.Executor b() {
        return b.a;
    }
}
