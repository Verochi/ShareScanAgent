package com.loc;

/* loaded from: classes23.dex */
public final class el {
    public static void a(java.lang.Throwable th) {
        if (com.loc.ea.a) {
            b(th);
        }
    }

    private static java.lang.String b(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        for (java.lang.Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof java.net.UnknownHostException) {
                return "";
            }
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }
}
