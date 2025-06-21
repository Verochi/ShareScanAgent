package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class f {
    public static boolean a;
    public static boolean b;
    private static boolean c;
    private static boolean d;
    private static boolean e;
    private static boolean f;
    private static boolean g;
    private static boolean h;

    private f() {
    }

    private static void a(java.lang.String str, java.lang.String str2) {
    }

    private static void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    private static void a(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (d) {
            try {
                java.lang.String.format(str2, objArr);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void a(java.lang.String str, java.lang.Throwable th) {
    }

    private static void b(java.lang.String str, java.lang.String str2) {
    }

    private static void b(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    private static void b(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (g) {
            try {
                java.lang.String.format(str2, objArr);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void c(java.lang.String str, java.lang.String str2) {
    }

    private static void c(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    private static void d(java.lang.String str, java.lang.String str2) {
    }

    private static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    private static void e(java.lang.String str, java.lang.String str2) {
    }

    private static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    private static void f(java.lang.String str, java.lang.String str2) {
        if (e) {
            int length = 2001 - str.length();
            while (str2.length() > length) {
                str2.substring(0, length);
                str2 = str2.substring(length);
            }
        }
    }
}
