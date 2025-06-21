package com.bun.miitmdid.c.h;

/* loaded from: classes.dex */
public class a {
    private static android.net.Uri a = android.net.Uri.parse("content://cn.nubia.identity/identity");

    public static java.lang.String a(android.content.Context context) {
        try {
            int i = android.os.Build.VERSION.SDK_INT;
            android.content.ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(a);
            android.os.Bundle call = acquireUnstableContentProviderClient.call("getOAID", null, null);
            if (i >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                java.lang.String string = call.getString("id");
                com.bun.lib.a.b("NubiaLog", "succeed:" + string);
                return string;
            }
            java.lang.String string2 = call.getString("message");
            com.bun.lib.a.b("NubiaLog", "failed:" + string2);
            return string2;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            int i = android.os.Build.VERSION.SDK_INT;
            android.content.ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(a);
            android.os.Bundle call = acquireUnstableContentProviderClient.call("getAAID", str, null);
            if (i >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                java.lang.String string = call.getString("id");
                com.bun.lib.a.b("NubiaLog", "succeed:" + string);
                return string;
            }
            java.lang.String string2 = call.getString("message");
            com.bun.lib.a.b("NubiaLog", "failed:" + string2);
            return string2;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str) {
        try {
            int i = android.os.Build.VERSION.SDK_INT;
            android.content.ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(a);
            android.os.Bundle call = acquireUnstableContentProviderClient.call("getVAID", str, null);
            if (i >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                java.lang.String string = call.getString("id");
                com.bun.lib.a.b("NubiaLog", "succeed:" + string);
                return string;
            }
            java.lang.String string2 = call.getString("message");
            com.bun.lib.a.b("NubiaLog", "failed:" + string2);
            return string2;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean b(android.content.Context context) {
        try {
            int i = android.os.Build.VERSION.SDK_INT;
            android.content.ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(a);
            android.os.Bundle call = acquireUnstableContentProviderClient.call("isSupport", null, null);
            if (i >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                com.bun.lib.a.b("NubiaLog", "succeed");
                return call.getBoolean("issupport", true);
            }
            com.bun.lib.a.b("NubiaLog", "failed:" + call.getString("message"));
            return false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
