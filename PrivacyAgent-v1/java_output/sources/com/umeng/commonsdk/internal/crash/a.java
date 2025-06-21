package com.umeng.commonsdk.internal.crash;

/* loaded from: classes19.dex */
public class a {
    public static java.lang.String a(java.lang.Throwable th) {
        java.lang.String str = null;
        if (th == null) {
            return null;
        }
        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (java.lang.Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            str = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return str;
        } catch (java.lang.Exception unused) {
            return str;
        }
    }
}
