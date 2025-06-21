package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class y {
    public static com.huawei.hms.hatool.z a = new com.huawei.hms.hatool.z();

    public static void a(int i) {
        a.a(i);
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        if (!a() || str == null || str2 == null) {
            return;
        }
        a.b(3, str, str2);
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (!c() || str == null || str2 == null) {
            return;
        }
        a.b(4, str, java.lang.String.format(str2, objArr));
    }

    public static boolean a() {
        return a.b(3);
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        if (!b() || str == null || str2 == null) {
            return;
        }
        a.b(6, str, str2);
    }

    public static void b(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        d(str, java.lang.String.format(str2, objArr));
    }

    public static boolean b() {
        return a.b(6);
    }

    public static void c(java.lang.String str, java.lang.String str2) {
        if (!c() || str == null || str2 == null) {
            return;
        }
        a.b(4, str, str2);
    }

    public static boolean c() {
        return a.b(4);
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return;
        }
        a.b(4, str, str2);
    }

    public static boolean d() {
        return a.b(5);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return;
        }
        a.b(5, str, str2);
    }

    public static void f(java.lang.String str, java.lang.String str2) {
        if (!d() || str == null || str2 == null) {
            return;
        }
        a.b(5, str, str2);
    }
}
