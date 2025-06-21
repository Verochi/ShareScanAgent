package com.loc;

/* loaded from: classes23.dex */
public abstract class cv {
    protected java.util.concurrent.ThreadPoolExecutor a;
    private java.util.concurrent.ConcurrentHashMap<com.loc.cu, java.util.concurrent.Future<?>> c = new java.util.concurrent.ConcurrentHashMap<>();
    protected com.loc.cu.a b = new com.loc.cv.AnonymousClass1();

    /* renamed from: com.loc.cv$1, reason: invalid class name */
    public class AnonymousClass1 implements com.loc.cu.a {
        public AnonymousClass1() {
        }

        @Override // com.loc.cu.a
        public final void a(com.loc.cu cuVar) {
            com.loc.cv.this.a(cuVar);
        }
    }

    private synchronized void a(com.loc.cu cuVar, java.util.concurrent.Future<?> future) {
        try {
            this.c.put(cuVar, future);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized boolean c(com.loc.cu cuVar) {
        boolean z;
        try {
            z = this.c.containsKey(cuVar);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "TPool", "contain");
            th.printStackTrace();
            z = false;
        }
        return z;
    }

    public final synchronized void a(com.loc.cu cuVar) {
        try {
            this.c.remove(cuVar);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final java.util.concurrent.Executor b() {
        return this.a;
    }

    public final void b(com.loc.cu cuVar) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor;
        if (c(cuVar) || (threadPoolExecutor = this.a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        cuVar.e = this.b;
        try {
            java.util.concurrent.Future<?> submit = this.a.submit(cuVar);
            if (submit == null) {
                return;
            }
            a(cuVar, submit);
        } catch (java.util.concurrent.RejectedExecutionException e) {
            com.loc.aw.b(e, "TPool", "addTask");
        }
    }
}
