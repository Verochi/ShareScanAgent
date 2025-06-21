package com.alipay.sdk.m.c;

/* loaded from: classes.dex */
public class h implements com.alipay.sdk.m.b.b {
    @Override // com.alipay.sdk.m.b.b
    public java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        boolean c = com.alipay.sdk.m.p0.e.c(context);
        com.alipay.sdk.m.d.a.b("getOAID", "isSupported", java.lang.Boolean.valueOf(c));
        if (c) {
            return com.alipay.sdk.m.p0.e.a(context);
        }
        return null;
    }
}
