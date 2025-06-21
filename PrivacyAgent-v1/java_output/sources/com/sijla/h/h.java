package com.sijla.h;

/* loaded from: classes19.dex */
public final class h {
    private static java.lang.String a = "QLOG";

    static {
        java.lang.System.getProperty("line.separator");
    }

    private static java.lang.String a(java.lang.StackTraceElement stackTraceElement) {
        java.lang.String className = stackTraceElement.getClassName();
        java.lang.String format = java.lang.String.format("%s.%s(Line:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), java.lang.Integer.valueOf(stackTraceElement.getLineNumber()));
        if (android.text.TextUtils.isEmpty(a)) {
            return format;
        }
        return a + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + format;
    }

    public static void a() {
        a(d());
    }

    public static void b() {
        a(d());
    }

    public static void c() {
    }

    private static java.lang.StackTraceElement d() {
        return java.lang.Thread.currentThread().getStackTrace()[5];
    }
}
