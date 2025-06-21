package com.amap.api.col.s;

/* loaded from: classes12.dex */
public class an {
    public static volatile com.amap.api.col.s.an c;
    public java.util.concurrent.BlockingQueue<java.lang.Runnable> a = new java.util.concurrent.LinkedBlockingQueue();
    public java.util.concurrent.ExecutorService b;

    public an() {
        this.b = null;
        int availableProcessors = java.lang.Runtime.getRuntime().availableProcessors();
        this.b = new java.util.concurrent.ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1L, java.util.concurrent.TimeUnit.SECONDS, this.a, new java.util.concurrent.ThreadPoolExecutor.AbortPolicy());
    }

    public static com.amap.api.col.s.an a() {
        if (c == null) {
            synchronized (com.amap.api.col.s.an.class) {
                if (c == null) {
                    c = new com.amap.api.col.s.an();
                }
            }
        }
        return c;
    }

    public static void b() {
        if (c != null) {
            synchronized (com.amap.api.col.s.an.class) {
                if (c != null) {
                    c.b.shutdownNow();
                    c.b = null;
                    c = null;
                }
            }
        }
    }

    public final void a(java.lang.Runnable runnable) {
        java.util.concurrent.ExecutorService executorService = this.b;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
