package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class g1 extends java.util.TimerTask {
    public final /* synthetic */ long a;
    public final /* synthetic */ com.zx.a.I8b7.h1 b;

    public class a implements java.lang.Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.zx.a.I8b7.g1 g1Var = com.zx.a.I8b7.g1.this;
                com.zx.a.I8b7.h1.a(g1Var.b, g1Var.a);
                com.zx.a.I8b7.h1.a(com.zx.a.I8b7.g1.this.b);
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.r2.a(th);
            }
        }
    }

    public g1(com.zx.a.I8b7.h1 h1Var, long j) {
        this.b = h1Var;
        this.a = j;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.v3.f.a.e.execute(new com.zx.a.I8b7.g1.a());
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
    }
}
