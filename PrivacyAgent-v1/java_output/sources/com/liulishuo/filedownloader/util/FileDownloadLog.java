package com.liulishuo.filedownloader.util;

/* loaded from: classes23.dex */
public class FileDownloadLog {
    public static boolean NEED_LOG;

    public static java.lang.String a(java.lang.Object obj) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("FileDownloader.");
        sb.append((obj instanceof java.lang.Class ? (java.lang.Class) obj : obj.getClass()).getSimpleName());
        return sb.toString();
    }

    public static void b(int i, java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        c(i, obj, null, str, objArr);
    }

    public static void c(int i, java.lang.Object obj, java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        if ((i >= 5) || NEED_LOG) {
            android.util.Log.println(i, a(obj), com.liulishuo.filedownloader.util.FileDownloadUtils.formatString(str, objArr));
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    public static void d(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        b(3, obj, str, objArr);
    }

    public static void e(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        b(6, obj, str, objArr);
    }

    public static void e(java.lang.Object obj, java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        c(6, obj, th, str, objArr);
    }

    public static void i(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        b(4, obj, str, objArr);
    }

    public static void v(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        b(2, obj, str, objArr);
    }

    public static void w(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        b(5, obj, str, objArr);
    }
}
