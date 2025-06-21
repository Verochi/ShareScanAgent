package com.loc;

/* loaded from: classes23.dex */
public abstract class cu implements java.lang.Runnable {
    com.loc.cu.a e;

    public interface a {
        void a(com.loc.cu cuVar);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        com.loc.cu.a aVar;
        try {
            if (java.lang.Thread.interrupted()) {
                return;
            }
            a();
            if (java.lang.Thread.interrupted() || (aVar = this.e) == null) {
                return;
            }
            aVar.a(this);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
