package com.alipay.sdk.m.c;

/* loaded from: classes.dex */
public class i implements com.alipay.sdk.m.b.b {
    @Override // com.alipay.sdk.m.b.b
    public java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        boolean a = com.alipay.sdk.m.j0.b.a();
        com.alipay.sdk.m.d.a.b("getOAID", "isSupported", java.lang.Boolean.valueOf(a));
        if (a) {
            return com.alipay.sdk.m.j0.b.b(context);
        }
        return null;
    }
}
