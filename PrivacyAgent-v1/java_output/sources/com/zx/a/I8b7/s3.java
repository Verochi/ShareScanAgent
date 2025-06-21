package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class s3 implements java.lang.Runnable {
    public final /* synthetic */ android.content.Context a;
    public final /* synthetic */ com.zx.a.I8b7.t3 b;

    public s3(com.zx.a.I8b7.t3 t3Var, android.content.Context context) {
        this.b = t3Var;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.m3.a(this.a);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXCore init failed: "));
            this.b.b.set(false);
        }
    }
}
