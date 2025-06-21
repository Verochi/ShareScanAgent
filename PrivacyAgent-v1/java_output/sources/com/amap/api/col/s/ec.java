package com.amap.api.col.s;

/* loaded from: classes12.dex */
public abstract class ec implements java.lang.Runnable {
    public com.amap.api.col.s.ec.a n;

    public interface a {
        void a(com.amap.api.col.s.ec ecVar);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        com.amap.api.col.s.ec.a aVar;
        try {
            if (java.lang.Thread.interrupted()) {
                return;
            }
            a();
            if (java.lang.Thread.interrupted() || (aVar = this.n) == null) {
                return;
            }
            aVar.a(this);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
