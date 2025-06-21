package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class s2 implements java.lang.Runnable {
    public final /* synthetic */ java.lang.String a;
    public final /* synthetic */ com.zx.sdk.api.ZXIDListener b;

    public s2(com.zx.a.I8b7.x2 x2Var, java.lang.String str, com.zx.sdk.api.ZXIDListener zXIDListener) {
        this.a = str;
        this.b = zXIDListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.x2.a().a(this.a, this.b);
        } catch (java.lang.Throwable th) {
            com.zx.sdk.api.ZXIDListener zXIDListener = this.b;
            if (zXIDListener != null) {
                zXIDListener.onFailed(10000, th.getMessage());
            }
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.getZXID(zxidListener) failed: "));
        }
    }
}
