package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public class e {
    public static com.alipay.sdk.interior.Log.ISdkLogCallback a = null;
    public static final java.lang.String b = "alipaysdk";

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return java.lang.String.format("[%s][%s]", str, str2);
    }

    public static void a(com.alipay.sdk.interior.Log.ISdkLogCallback iSdkLogCallback) {
        a = iSdkLogCallback;
    }

    public static void a(java.lang.String str) {
        try {
            com.alipay.sdk.interior.Log.ISdkLogCallback iSdkLogCallback = a;
            if (iSdkLogCallback != null) {
                iSdkLogCallback.onLogLine(java.lang.String.format("[AlipaySDK] %s %s", new java.text.SimpleDateFormat("hh:mm:ss.SSS", java.util.Locale.getDefault()).format(new java.util.Date()), str));
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        a(a(str, str2) + " " + b(th));
    }

    public static void a(java.lang.Throwable th) {
        if (th == null) {
            return;
        }
        try {
            a(b(th));
        } catch (java.lang.Throwable unused) {
        }
    }

    public static java.lang.String b(java.lang.Throwable th) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        a(a(str, str2));
    }

    public static void c(java.lang.String str, java.lang.String str2) {
        a(a(str, str2));
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        a(a(str, str2));
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        a(a(str, str2));
    }
}
