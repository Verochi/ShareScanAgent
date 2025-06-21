package com.tramini.plugin.a.h;

/* loaded from: classes19.dex */
public final class h {
    public static boolean a(android.content.Context context) {
        try {
            return b(context);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private static boolean b(android.content.Context context) {
        try {
            java.lang.String property = java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_HOST);
            java.lang.String property2 = java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_PORT);
            if (property2 == null) {
                property2 = "-1";
            }
            return (android.text.TextUtils.isEmpty(property) || java.lang.Integer.parseInt(property2) == -1) ? false : true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
