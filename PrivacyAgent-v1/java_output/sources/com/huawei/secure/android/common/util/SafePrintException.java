package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public abstract class SafePrintException {
    public static boolean a(java.lang.String str) {
        java.lang.String[] strArr = {"java.io.FileNotFoundException", "java.util.jar.JarException", "java.util.MissingResourceException", "java.security.acl.NotOwnerException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.net.BindException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.sql.SQLException"};
        for (int i = 0; i < 10; i++) {
            if (str.contains(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    public static java.lang.String getStackTrace(java.lang.String str, java.lang.Throwable th) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!android.text.TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        sb.append("Exception: ");
        sb.append(th.getClass().getName());
        sb.append('\n');
        if (!a(th.getClass().getCanonicalName())) {
            java.lang.StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null) {
                sb.append("Stack trace is NULL!");
                sb.append('\n');
            } else {
                for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement.toString());
                    sb.append('\n');
                }
            }
        }
        return sb.toString();
    }

    public static void print(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (th == null) {
            return;
        }
        getStackTrace(str2, th);
    }
}
