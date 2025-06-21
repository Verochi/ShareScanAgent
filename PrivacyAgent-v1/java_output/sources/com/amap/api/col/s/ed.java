package com.amap.api.col.s;

/* loaded from: classes12.dex */
public abstract class ed {
    protected java.util.concurrent.ThreadPoolExecutor a;
    public java.util.concurrent.ConcurrentHashMap<com.amap.api.col.s.ec, java.util.concurrent.Future<?>> c = new java.util.concurrent.ConcurrentHashMap<>();
    protected com.amap.api.col.s.ec.a b = new com.amap.api.col.s.ed.AnonymousClass1();

    /* renamed from: com.amap.api.col.s.ed$1, reason: invalid class name */
    public class AnonymousClass1 implements com.amap.api.col.s.ec.a {
        public AnonymousClass1() {
        }

        @Override // com.amap.api.col.s.ec.a
        public final void a(com.amap.api.col.s.ec ecVar) {
            com.amap.api.col.s.ed.this.a(ecVar);
        }
    }

    public final synchronized void a(com.amap.api.col.s.ec ecVar) {
        try {
            this.c.remove(ecVar);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final void b(com.amap.api.col.s.ec ecVar) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor;
        if (c(ecVar) || (threadPoolExecutor = this.a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        ecVar.n = this.b;
        try {
            java.util.concurrent.Future<?> submit = this.a.submit(ecVar);
            if (submit == null) {
                return;
            }
            b(ecVar, submit);
        } catch (java.util.concurrent.RejectedExecutionException e) {
            com.amap.api.col.s.cj.c(e, "TPool", "addTask");
        }
    }

    public final synchronized void b(com.amap.api.col.s.ec ecVar, java.util.concurrent.Future<?> future) {
        try {
            this.c.put(ecVar, future);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    public final synchronized boolean c(com.amap.api.col.s.ec ecVar) {
        boolean z;
        try {
            z = this.c.containsKey(ecVar);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "TPool", "contain");
            th.printStackTrace();
            z = false;
        }
        return z;
    }
}
