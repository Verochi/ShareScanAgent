package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class o {
    public static boolean a = true;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = true;
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = false;
    private static final java.lang.String i = "anythink_";

    static {
        if (com.anythink.expressad.a.a) {
            return;
        }
        a = false;
        b = false;
        c = false;
        d = false;
        e = false;
        f = false;
        g = false;
        h = false;
    }

    private o() {
    }

    private static java.lang.String a(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) ? i.concat(java.lang.String.valueOf(str)) : str;
    }

    private static void a(android.content.Context context, java.lang.String str) {
        if (f) {
            android.widget.Toast.makeText(context, str, 1).show();
        }
    }

    private static void a(java.lang.String str, java.lang.String str2) {
        if (!a || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    private static void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (!a || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    private static void a(java.lang.String str, java.lang.Throwable th) {
        if (!d || th == null) {
            return;
        }
        a(str);
    }

    private static void b(java.lang.String str, java.lang.String str2) {
        if (!b || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    private static void b(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (!b || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    private static void c(java.lang.String str, java.lang.String str2) {
        if (!c || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    private static void c(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (!c || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    private static void d(java.lang.String str, java.lang.String str2) {
        if (!d || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    private static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (!d || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    private static void e(java.lang.String str, java.lang.String str2) {
        if (!e || str2 == null) {
            return;
        }
        a(str);
    }

    private static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (!e || str2 == null) {
            return;
        }
        a(str);
    }
}
