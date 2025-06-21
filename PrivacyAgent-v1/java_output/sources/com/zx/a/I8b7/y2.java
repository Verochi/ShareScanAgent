package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class y2 implements java.lang.Runnable {
    public final /* synthetic */ java.lang.String a;
    public final /* synthetic */ java.lang.String b;
    public final /* synthetic */ java.lang.String c;
    public final /* synthetic */ java.lang.String d;
    public final /* synthetic */ java.lang.String e;
    public final /* synthetic */ java.lang.String f;
    public final /* synthetic */ com.zx.sdk.api.SAIDCallback g;

    public y2(com.zx.a.I8b7.x2 x2Var, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, com.zx.sdk.api.SAIDCallback sAIDCallback) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = sAIDCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.x2.a().a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        } catch (java.lang.Throwable th) {
            com.zx.sdk.api.SAIDCallback sAIDCallback = this.g;
            if (sAIDCallback != null) {
                sAIDCallback.onFailed(10000, th.getMessage());
            }
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.getSAID() failed: "));
        }
    }
}
