package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class p {
    public static final com.vivo.push.util.o a = new com.vivo.push.util.n();
    private static boolean b;
    private static boolean c;

    static {
        b();
    }

    public static int a(java.lang.String str, java.lang.String str2) {
        return a.a(str, str2);
    }

    public static int a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        return a.a(str, str2, th);
    }

    public static int a(java.lang.String str, java.lang.Throwable th) {
        return a.a(str, th);
    }

    public static java.lang.String a(java.lang.Throwable th) {
        return a.a(th);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        a.a(context, str);
    }

    public static void a(boolean z) {
        b();
        c = z;
    }

    public static boolean a() {
        return b && c;
    }

    public static int b(java.lang.String str, java.lang.String str2) {
        return a.b(str, str2);
    }

    public static int b(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        return a.b(str, str2, th);
    }

    private static void b() {
        b = com.vivo.push.util.z.b("persist.sys.log.ctrl", "no").equals("yes");
    }

    public static void b(android.content.Context context, java.lang.String str) {
        a.b(context, str);
    }

    public static int c(java.lang.String str, java.lang.String str2) {
        return a.c(str, str2);
    }

    public static void c(android.content.Context context, java.lang.String str) {
        a.c(context, str);
    }

    public static int d(java.lang.String str, java.lang.String str2) {
        return a.d(str, str2);
    }

    public static int e(java.lang.String str, java.lang.String str2) {
        return a.e(str, str2);
    }
}
