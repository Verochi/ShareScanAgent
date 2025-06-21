package com.efs.sdk.base.core.util;

/* loaded from: classes22.dex */
public class a {
    private static java.lang.String a = "efs";
    private static java.io.File b;

    public static java.io.File a(android.content.Context context) {
        java.io.File dir = context.getDir(a, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public static java.io.File a(android.content.Context context, java.lang.String str) {
        return new java.io.File(j(context, str), "efs_cst");
    }

    public static void a(java.lang.String str) {
        a = str;
    }

    public static java.io.File b(android.content.Context context, java.lang.String str) {
        return new java.io.File(j(context, str), "efs_config");
    }

    public static java.io.File c(android.content.Context context, java.lang.String str) {
        return new java.io.File(j(context, str), "efs_flow");
    }

    public static java.io.File d(android.content.Context context, java.lang.String str) {
        java.io.File file = new java.io.File(j(context, str), "ready");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static java.io.File e(android.content.Context context, java.lang.String str) {
        java.io.File file = new java.io.File(j(context, str), "ready_codelog");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static java.io.File f(android.content.Context context, java.lang.String str) {
        java.io.File file = new java.io.File(d(context, str), java.lang.String.valueOf(com.efs.sdk.base.core.util.ProcessUtil.myPid()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static java.io.File g(android.content.Context context, java.lang.String str) {
        java.io.File file = new java.io.File(e(context, str), java.lang.String.valueOf(com.efs.sdk.base.core.util.ProcessUtil.myPid()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static java.io.File h(android.content.Context context, java.lang.String str) {
        java.io.File file = new java.io.File(j(context, str), "upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static java.io.File i(android.content.Context context, java.lang.String str) {
        java.io.File file = new java.io.File(j(context, str), "upload_codelog");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static java.io.File j(android.content.Context context, java.lang.String str) {
        if (b == null) {
            synchronized (com.efs.sdk.base.core.util.a.class) {
                if (b == null) {
                    b = a(context);
                }
            }
        }
        java.io.File file = new java.io.File(b, str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
