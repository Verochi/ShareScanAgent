package com.bun.lib;

/* loaded from: classes.dex */
public class a {
    private static com.bun.lib.a b;
    private int a = -1;

    private a() {
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        a();
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        a();
    }

    public static void a(boolean z) {
        b().a = z ? 1 : 0;
    }

    public static boolean a() {
        return b().a == 1;
    }

    public static com.bun.lib.a b() {
        if (b == null) {
            synchronized (com.bun.lib.a.class) {
                if (b == null) {
                    b = new com.bun.lib.a();
                }
            }
        }
        return b;
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        a();
    }

    public static void b(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        a();
    }
}
