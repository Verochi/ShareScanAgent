package com.jd.ad.sdk.jad_kt;

/* loaded from: classes23.dex */
public final class jad_jt {
    @androidx.annotation.NonNull
    public static <T> T jad_an(@androidx.annotation.Nullable T t) {
        t.getClass();
        return t;
    }

    public static java.lang.String jad_an(java.lang.Throwable th) {
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

    public static boolean jad_an(java.lang.CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
