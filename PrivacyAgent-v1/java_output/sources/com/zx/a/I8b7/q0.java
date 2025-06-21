package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class q0 implements com.zx.a.I8b7.l0 {
    public com.zx.a.I8b7.k0 a;
    public java.lang.String b = "";
    public int c = 8;

    public q0(com.zx.a.I8b7.k0 k0Var) {
        this.a = (com.zx.a.I8b7.k0) com.zx.a.I8b7.f2.a(k0Var);
    }

    public static java.lang.String a(java.lang.Throwable th) {
        for (java.lang.Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.PrintWriter printWriter = new java.io.PrintWriter((java.io.OutputStream) byteArrayOutputStream, false);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return byteArrayOutputStream.toString();
    }

    @Override // com.zx.a.I8b7.l0
    public void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        java.lang.String str3;
        java.lang.String str4 = "";
        try {
            java.lang.StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[this.c];
            java.lang.String className = stackTraceElement.getClassName();
            str3 = java.lang.String.format("%s.%s", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName());
        } catch (java.lang.Throwable unused) {
            str3 = "";
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = this.b;
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            str3 = str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3;
        }
        if (th != null && str2 != null) {
            str2 = str2 + " : " + a(th);
        }
        if (th != null && str2 == null) {
            str2 = a(th);
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "Empty/NULL log message";
        }
        java.lang.String trim = str2.trim();
        if (trim.startsWith("{") && trim.endsWith(com.alipay.sdk.m.u.i.d)) {
            try {
                trim = new org.json.JSONObject(trim).toString(2);
            } catch (java.lang.Throwable unused2) {
            }
        }
        if (trim.startsWith("[") && trim.endsWith("]")) {
            try {
                trim = new org.json.JSONArray(trim).toString(2);
            } catch (java.lang.Throwable unused3) {
            }
        }
        try {
            java.lang.StackTraceElement stackTraceElement2 = java.lang.Thread.currentThread().getStackTrace()[this.c];
            java.lang.String className2 = stackTraceElement2.getClassName();
            str4 = java.lang.String.format("(%s:%d)", className2.substring(className2.lastIndexOf(".") + 1) + ".java", java.lang.Integer.valueOf(stackTraceElement2.getLineNumber()));
        } catch (java.lang.Throwable unused4) {
        }
        if (th == null) {
            trim = trim + " " + str4;
        }
        this.a.a(i, str3, trim);
    }
}
