package com.getui.gtc.base.log.c;

/* loaded from: classes22.dex */
public final class a implements com.getui.gtc.base.log.ILogFormatter {
    private final com.getui.gtc.base.log.ILogDestination c;
    private java.lang.String e;
    private final java.text.SimpleDateFormat d = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault());
    public java.lang.String a = "";
    public int b = 8;

    public a(com.getui.gtc.base.log.ILogDestination iLogDestination) {
        this.e = "";
        this.c = (com.getui.gtc.base.log.ILogDestination) com.getui.gtc.base.log.e.a.a(iLogDestination);
        this.e = com.getui.gtc.base.util.CommonUtil.getProcessName();
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
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.d.format(new java.util.Date()));
        sb.append(" ");
        sb.append(android.os.Process.myPid());
        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        sb.append(this.e);
        sb.append(" ");
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "?" : androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST : androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST : "I" : "D" : androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        java.lang.String a = a();
        java.lang.String str3 = android.text.TextUtils.isEmpty(str) ? this.a : str;
        if (!android.text.TextUtils.isEmpty(str3)) {
            a = str3 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + a;
        }
        sb.append(a);
        sb.append(": ");
        sb.append(a(str2, th));
        java.lang.String sb2 = sb.toString();
        if (!sb2.endsWith("\n")) {
            sb2 = sb2 + "\n";
        }
        this.c.log(i, str, sb2);
    }
}
