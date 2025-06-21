package com.alipay.sdk.m.g0;

/* loaded from: classes.dex */
public class b implements com.alipay.sdk.m.g0.a {
    public static com.alipay.sdk.m.g0.a a;
    public static com.alipay.sdk.m.d0.a b;

    public static com.alipay.sdk.m.g0.a a(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return null;
        }
        if (a == null) {
            b = com.alipay.sdk.m.d0.d.a(context, str);
            a = new com.alipay.sdk.m.g0.b();
        }
        return a;
    }

    @Override // com.alipay.sdk.m.g0.a
    public com.alipay.sdk.m.f0.c a(com.alipay.sdk.m.f0.d dVar) {
        return com.alipay.sdk.m.f0.b.a(b.a(com.alipay.sdk.m.f0.b.a(dVar)));
    }

    @Override // com.alipay.sdk.m.g0.a
    public boolean logCollect(java.lang.String str) {
        return b.logCollect(str);
    }
}
