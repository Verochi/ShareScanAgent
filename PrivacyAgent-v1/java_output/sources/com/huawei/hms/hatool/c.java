package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public abstract class c {
    public static void a(java.lang.String str, java.lang.String str2, long j) {
        com.huawei.hms.hatool.k h = h(str, str2);
        if (h != null) {
            h.a(j);
        }
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        if (h != null) {
            return h.a();
        }
        return true;
    }

    public static int b(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        if (h != null) {
            return h.d();
        }
        return 7;
    }

    public static boolean c(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        if (h != null) {
            return h.g();
        }
        return true;
    }

    public static java.lang.String d(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        return h != null ? h.f() : "";
    }

    public static boolean e(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        if (h != null) {
            return h.i();
        }
        return false;
    }

    public static java.lang.String f(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        return h != null ? h.h() : "";
    }

    public static java.lang.String g(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        return h != null ? h.n() : "";
    }

    public static com.huawei.hms.hatool.k h(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.m a = com.huawei.hms.hatool.i.c().a(str);
        if (a == null) {
            return null;
        }
        if (!"alltype".equals(str2)) {
            return a.a(str2);
        }
        com.huawei.hms.hatool.k a2 = a.a("oper");
        return a2 == null ? a.a("maint") : a2;
    }

    public static java.util.Map<java.lang.String, java.lang.String> i(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        if (h != null) {
            return h.k();
        }
        return null;
    }

    public static long j(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        if (h != null) {
            return h.l();
        }
        return 0L;
    }

    public static int k(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        if (h != null) {
            return h.b();
        }
        return 10;
    }

    public static java.lang.String l(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        return h != null ? h.o() : "";
    }

    public static java.lang.String m(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        return h != null ? h.q() : "";
    }

    public static java.lang.String n(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        return h != null ? h.m() : "";
    }

    public static java.lang.String o(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.k h = h(str, str2);
        return h != null ? h.p() : "";
    }
}
