package com.alipay.sdk.m.j;

/* loaded from: classes.dex */
public class b {
    public static boolean a;
    public static java.lang.String b;

    public static java.lang.String a() {
        com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.CANCELED.b());
        return a(b2.b(), b2.a(), "");
    }

    public static java.lang.String a(int i, java.lang.String str, java.lang.String str2) {
        return "resultStatus={" + i + "};memo={" + str + "};result={" + str2 + com.alipay.sdk.m.u.i.d;
    }

    public static void a(java.lang.String str) {
        b = str;
    }

    public static void a(boolean z) {
        a = z;
    }

    public static java.lang.String b() {
        com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.DOUBLE_REQUEST.b());
        return a(b2.b(), b2.a(), "");
    }

    public static boolean c() {
        return a;
    }

    public static java.lang.String d() {
        return b;
    }

    public static java.lang.String e() {
        com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.PARAMS_ERROR.b());
        return a(b2.b(), b2.a(), "");
    }
}
