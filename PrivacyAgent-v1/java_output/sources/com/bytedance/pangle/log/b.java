package com.bytedance.pangle.log;

/* loaded from: classes12.dex */
public final class b {
    public static java.lang.String a(java.lang.Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static java.lang.String a(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static int b(java.lang.Object obj) {
        if (obj == null) {
            return -1;
        }
        return com.bytedance.pangle.util.k.a(obj.toString());
    }
}
