package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class c3 implements java.lang.Runnable {
    public final /* synthetic */ boolean a;

    public c3(com.zx.a.I8b7.x2 x2Var, boolean z) {
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.u3 u3Var = com.zx.a.I8b7.l2.a.a.a;
            boolean z = this.a;
            u3Var.getClass();
            if (z != com.zx.a.I8b7.m3.f490s) {
                com.zx.a.I8b7.m3.f490s = z ? 1 : 0;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.zx.a.I8b7.m3.f490s);
                u3Var.a(20, sb.toString(), false);
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.allowPermissionDialog failed: "));
        }
    }
}
