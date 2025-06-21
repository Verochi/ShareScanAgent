package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class ik {
    protected java.util.concurrent.ThreadPoolExecutor a;
    private java.util.concurrent.ConcurrentHashMap<com.amap.api.mapcore.util.ij, java.util.concurrent.Future<?>> c = new java.util.concurrent.ConcurrentHashMap<>();
    protected com.amap.api.mapcore.util.ij.a b = new com.amap.api.mapcore.util.ik.AnonymousClass1();

    /* renamed from: com.amap.api.mapcore.util.ik$1, reason: invalid class name */
    public class AnonymousClass1 implements com.amap.api.mapcore.util.ij.a {
        public AnonymousClass1() {
        }

        @Override // com.amap.api.mapcore.util.ij.a
        public final void a(com.amap.api.mapcore.util.ij ijVar) {
            com.amap.api.mapcore.util.ik.this.a(ijVar, false);
        }

        @Override // com.amap.api.mapcore.util.ij.a
        public final void b(com.amap.api.mapcore.util.ij ijVar) {
            com.amap.api.mapcore.util.ik.this.a(ijVar, true);
        }
    }

    private synchronized void a(com.amap.api.mapcore.util.ij ijVar, java.util.concurrent.Future<?> future) {
        try {
            this.c.put(ijVar, future);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized boolean b(com.amap.api.mapcore.util.ij ijVar) {
        boolean z;
        try {
            z = this.c.containsKey(ijVar);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "TPool", "contain");
            th.printStackTrace();
            z = false;
        }
        return z;
    }

    public final void a(long j, java.util.concurrent.TimeUnit timeUnit) {
        try {
            java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = this.a;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.awaitTermination(j, timeUnit);
            }
        } catch (java.lang.InterruptedException unused) {
        }
    }

    public final void a(com.amap.api.mapcore.util.ij ijVar) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor;
        if (b(ijVar) || (threadPoolExecutor = this.a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        ijVar.f = this.b;
        try {
            java.util.concurrent.Future<?> submit = this.a.submit(ijVar);
            if (submit == null) {
                return;
            }
            a(ijVar, submit);
        } catch (java.util.concurrent.RejectedExecutionException e) {
            com.amap.api.mapcore.util.gd.c(e, "TPool", "addTask");
        }
    }

    public final synchronized void a(com.amap.api.mapcore.util.ij ijVar, boolean z) {
        try {
            java.util.concurrent.Future<?> remove = this.c.remove(ijVar);
            if (z && remove != null) {
                remove.cancel(true);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final void d() {
        try {
            java.util.Iterator<java.util.Map.Entry<com.amap.api.mapcore.util.ij, java.util.concurrent.Future<?>>> it = this.c.entrySet().iterator();
            while (it.hasNext()) {
                java.util.concurrent.Future<?> future = this.c.get(it.next().getKey());
                if (future != null) {
                    try {
                        future.cancel(true);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.c.clear();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "TPool", "destroy");
            th.printStackTrace();
        }
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = this.a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }
}
