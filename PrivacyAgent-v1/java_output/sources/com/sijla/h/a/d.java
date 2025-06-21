package com.sijla.h.a;

/* loaded from: classes19.dex */
public final class d {
    private static java.lang.String a = "";

    private static java.lang.String a() {
        java.lang.String str;
        try {
            str = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        } catch (java.lang.Throwable unused) {
            str = "/sdcard";
        }
        return str + java.io.File.separator;
    }

    public static java.lang.String a(android.content.Context context) {
        return !android.text.TextUtils.isEmpty(a) ? a : b(context);
    }

    public static java.lang.StringBuilder a(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(a());
        sb.append(str);
        sb.append(java.io.File.separator);
        return sb;
    }

    private static java.lang.String b() {
        com.sijla.h.c.a(".qmt");
        return ".qmt";
    }

    public static java.lang.String b(android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        java.lang.String str = java.io.File.separator;
        sb.append(str);
        sb.append(b());
        sb.append(str);
        return sb.toString();
    }

    public static java.lang.String c(android.content.Context context) {
        return a(context) + "/__anc__";
    }

    public static java.lang.String d(android.content.Context context) {
        return a(context) + "Qt" + java.io.File.separator;
    }

    public static java.lang.String e(android.content.Context context) {
        return a(context) + "QD" + java.io.File.separator;
    }

    public static java.lang.String f(android.content.Context context) {
        return b(context) + "config" + java.io.File.separator;
    }

    public static java.lang.String g(android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(b(context));
        sb.append("truth2");
        java.lang.String str = java.io.File.separator;
        sb.append(str);
        sb.append("data");
        sb.append(str);
        return sb.toString();
    }
}
