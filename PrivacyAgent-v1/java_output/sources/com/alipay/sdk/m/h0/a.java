package com.alipay.sdk.m.h0;

/* loaded from: classes.dex */
public class a {
    public static java.lang.String a(android.content.Context context) {
        if (com.alipay.sdk.m.a.a.b.a) {
            return com.alipay.sdk.m.a.a.c.b.a.a(context.getApplicationContext(), "AUID");
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }

    public static boolean a() {
        if (com.alipay.sdk.m.a.a.b.a) {
            return com.alipay.sdk.m.a.a.b.b;
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }

    public static java.lang.String b(android.content.Context context) {
        if (com.alipay.sdk.m.a.a.b.a) {
            return com.alipay.sdk.m.a.a.c.b.a.a(context.getApplicationContext(), "OUID");
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }

    public static java.lang.String c(android.content.Context context) {
        if (com.alipay.sdk.m.a.a.b.a) {
            return com.alipay.sdk.m.a.a.c.b.a.a(context.getApplicationContext(), "GUID");
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }

    public static java.lang.String d(android.content.Context context) {
        if (com.alipay.sdk.m.a.a.b.a) {
            return com.alipay.sdk.m.a.a.c.b.a.a(context.getApplicationContext(), "DUID");
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }

    public static void e(android.content.Context context) {
        com.alipay.sdk.m.a.a.b.b = com.alipay.sdk.m.a.a.c.b.a.a(context.getApplicationContext());
        com.alipay.sdk.m.a.a.b.a = true;
    }
}
