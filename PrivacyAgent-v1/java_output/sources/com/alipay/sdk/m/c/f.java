package com.alipay.sdk.m.c;

/* loaded from: classes.dex */
public class f implements com.alipay.sdk.m.b.b {
    public boolean a = false;

    @Override // com.alipay.sdk.m.b.b
    public java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        if (!this.a) {
            com.alipay.sdk.m.h0.a.e(context);
            this.a = true;
        }
        boolean a = com.alipay.sdk.m.h0.a.a();
        com.alipay.sdk.m.d.a.b("getOAID", "isSupported", java.lang.Boolean.valueOf(a));
        if (a) {
            return com.alipay.sdk.m.h0.a.b(context);
        }
        return null;
    }
}
