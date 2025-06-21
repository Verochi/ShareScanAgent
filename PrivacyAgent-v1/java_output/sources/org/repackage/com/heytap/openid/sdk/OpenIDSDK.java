package org.repackage.com.heytap.openid.sdk;

/* loaded from: classes26.dex */
public class OpenIDSDK {
    public static void a(android.content.Context context) {
        org.repackage.a.a.a.a.a.b = org.repackage.a.a.a.a.c.a.a.a(context.getApplicationContext());
        org.repackage.a.a.a.a.a.a = true;
    }

    public static boolean a() {
        if (org.repackage.a.a.a.a.a.a) {
            return org.repackage.a.a.a.a.a.b;
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }

    public static java.lang.String b(android.content.Context context) {
        if (org.repackage.a.a.a.a.a.a) {
            return org.repackage.a.a.a.a.c.a.a.a(context.getApplicationContext(), "GUID");
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }

    public static java.lang.String c(android.content.Context context) {
        if (org.repackage.a.a.a.a.a.a) {
            return org.repackage.a.a.a.a.c.a.a.a(context.getApplicationContext(), "OUID");
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }

    public static java.lang.String d(android.content.Context context) {
        if (org.repackage.a.a.a.a.a.a) {
            return org.repackage.a.a.a.a.c.a.a.a(context.getApplicationContext(), "DUID");
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }

    public static java.lang.String e(android.content.Context context) {
        if (org.repackage.a.a.a.a.a.a) {
            return org.repackage.a.a.a.a.c.a.a.a(context.getApplicationContext(), "AUID");
        }
        throw new java.lang.RuntimeException("SDK Need Init First!");
    }
}
