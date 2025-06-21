package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public abstract class a {
    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.j c = c(str, str2);
        return c != null ? c.a() : "";
    }

    public static boolean b(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.j c = c(str, str2);
        return c != null && c.e();
    }

    public static com.huawei.hms.hatool.j c(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k a;
        com.huawei.hms.hatool.m a2 = com.huawei.hms.hatool.i.c().a(str);
        if (a2 == null || (a = a2.a(str2)) == null) {
            return null;
        }
        return a.j();
    }

    public static java.lang.String d(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.j c = c(str, str2);
        return c != null ? c.b() : "";
    }

    public static boolean e(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.j c = c(str, str2);
        return c != null && c.f();
    }

    public static boolean f(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k a;
        com.huawei.hms.hatool.m a2 = com.huawei.hms.hatool.i.c().a(str);
        if (a2 == null || (a = a2.a(str2)) == null) {
            return false;
        }
        return a.c();
    }

    public static java.lang.String g(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.j c = c(str, str2);
        return c != null ? c.d() : "";
    }

    public static boolean h(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.j c = c(str, str2);
        return c != null && c.g();
    }

    public static boolean i(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k a;
        com.huawei.hms.hatool.m a2 = com.huawei.hms.hatool.i.c().a(str);
        if (a2 == null || (a = a2.a(str2)) == null) {
            return false;
        }
        return a.e();
    }

    public static java.lang.String j(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.j c = c(str, str2);
        return c != null ? c.c() : "";
    }

    public static boolean k(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.j c = c(str, str2);
        return c != null && c.h();
    }
}
