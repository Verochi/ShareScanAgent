package com.heytap.mcssdk.utils;

/* loaded from: classes22.dex */
public class d {
    public static final java.lang.String a = "mcssdk---";
    private static java.lang.String b = "MCS";
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = true;
    private static boolean f = true;
    private static boolean g = true;
    private static java.lang.String h = "-->";
    private static boolean i = true;

    public static java.lang.String a() {
        return b;
    }

    public static void a(java.lang.Exception exc) {
        if (!g || exc == null) {
            return;
        }
        exc.getMessage();
    }

    public static void a(java.lang.String str) {
        if (c && i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(b);
            sb.append(h);
            sb.append(str);
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        if (c && i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(b);
            sb.append(h);
            sb.append(str2);
        }
    }

    public static void a(java.lang.String str, java.lang.Throwable th) {
        if (g) {
            th.toString();
        }
    }

    public static void a(boolean z) {
        c = z;
    }

    public static void b(java.lang.String str) {
        if (e && i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(b);
            sb.append(h);
            sb.append(str);
        }
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        if (e && i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(b);
            sb.append(h);
            sb.append(str2);
        }
    }

    public static void b(boolean z) {
        e = z;
    }

    public static boolean b() {
        return c;
    }

    public static void c(java.lang.String str) {
        if (d && i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(b);
            sb.append(h);
            sb.append(str);
        }
    }

    public static void c(java.lang.String str, java.lang.String str2) {
        if (d && i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(b);
            sb.append(h);
            sb.append(str2);
        }
    }

    public static void c(boolean z) {
        d = z;
    }

    public static boolean c() {
        return e;
    }

    public static void d(java.lang.String str) {
        if (f && i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(b);
            sb.append(h);
            sb.append(str);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (f && i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(b);
            sb.append(h);
            sb.append(str2);
        }
    }

    public static void d(boolean z) {
        f = z;
    }

    public static boolean d() {
        return d;
    }

    public static void e(java.lang.String str) {
        if (g && i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(b);
            sb.append(h);
            sb.append(str);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        if (g && i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(b);
            sb.append(h);
            sb.append(str2);
        }
    }

    public static void e(boolean z) {
        g = z;
    }

    public static boolean e() {
        return f;
    }

    public static void f(java.lang.String str) {
        b = str;
    }

    public static void f(boolean z) {
        i = z;
        boolean z2 = z;
        c = z2;
        e = z2;
        d = z2;
        f = z2;
        g = z2;
    }

    public static boolean f() {
        return g;
    }

    public static void g(java.lang.String str) {
        h = str;
    }

    public static boolean g() {
        return i;
    }

    public static java.lang.String h() {
        return h;
    }
}
