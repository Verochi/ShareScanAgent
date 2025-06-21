package com.alipay.sdk.m.n0;

/* loaded from: classes.dex */
public class a {
    public static java.lang.String a(android.content.Context context) {
        com.alipay.sdk.m.n0.b b = com.alipay.sdk.m.n0.c.b(context);
        return (b == null || com.alipay.sdk.m.l0.f.m12a(b.c())) ? "ffffffffffffffffffffffff" : b.c();
    }

    public static java.lang.String b(android.content.Context context) {
        java.lang.String a = com.alipay.sdk.m.n0.d.a(context).a();
        return (a == null || com.alipay.sdk.m.l0.f.m12a(a)) ? "ffffffffffffffffffffffff" : a;
    }

    @java.lang.Deprecated
    public static java.lang.String c(android.content.Context context) {
        return a(context);
    }

    @java.lang.Deprecated
    public static java.lang.String d(android.content.Context context) {
        return b(context);
    }
}
