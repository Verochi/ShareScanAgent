package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class b3 implements java.lang.Runnable {
    public final /* synthetic */ boolean a;

    public b3(com.zx.a.I8b7.x2 x2Var, boolean z) {
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.l2.a.a.a.b(this.a ? 1 : 0);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXCore setEnable failed: "));
        }
    }
}
