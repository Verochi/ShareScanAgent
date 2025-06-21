package com.getui.gtc.base.log.c;

/* loaded from: classes22.dex */
public final class b implements com.getui.gtc.base.log.ILogFormatter {
    public java.lang.String a;
    public int b;
    private com.getui.gtc.base.log.ILogDestination c;

    public b() {
        this(new com.getui.gtc.base.log.b.b());
    }

    public b(com.getui.gtc.base.log.ILogDestination iLogDestination) {
        this.a = "";
        this.b = 8;
        this.c = (com.getui.gtc.base.log.ILogDestination) com.getui.gtc.base.log.e.a.a(iLogDestination);
    }

    private java.lang.String a() {
        try {
            java.lang.StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[this.b];
            java.lang.String className = stackTraceElement.getClassName();
            return java.lang.String.format("%s.%s", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName());
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private java.lang.String a(java.lang.String str, java.lang.Throwable th) {
        if (th != null && str != null) {
            str = str + " : " + a(th);
        }
        if (th != null && str == null) {
            str = a(th);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = "Empty/NULL log message";
        }
        java.lang.String trim = str.trim();
        if (trim.startsWith("{") && trim.endsWith(com.alipay.sdk.m.u.i.d)) {
            try {
                trim = new org.json.JSONObject(trim).toString(2);
            } catch (java.lang.Throwable unused) {
            }
        }
        if (trim.startsWith("[") && trim.endsWith("]")) {
            try {
                trim = new org.json.JSONArray(trim).toString(2);
            } catch (java.lang.Throwable unused2) {
            }
        }
        java.lang.String b = b();
        if (th != null) {
            return trim;
        }
        return trim + " " + b;
    }

    private static java.lang.String a(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        for (java.lang.Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.PrintWriter printWriter = new java.io.PrintWriter((java.io.OutputStream) byteArrayOutputStream, false);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return byteArrayOutputStream.toString();
    }

    private java.lang.String b() {
        try {
            java.lang.StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[this.b];
            java.lang.String className = stackTraceElement.getClassName();
            return java.lang.String.format("(%s:%d)", className.substring(className.lastIndexOf(".") + 1) + ".java", java.lang.Integer.valueOf(stackTraceElement.getLineNumber()));
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    @Override // com.getui.gtc.base.log.ILogFormatter
    public final void log(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        java.lang.String a = a();
        if (android.text.TextUtils.isEmpty(str)) {
            str = this.a;
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            a = str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + a;
        }
        this.c.log(i, a, a(str2, th));
    }
}
