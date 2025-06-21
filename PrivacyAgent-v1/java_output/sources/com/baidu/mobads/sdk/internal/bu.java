package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class bu {
    public static final java.lang.String a = "PackageUtils";

    public static boolean a(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return str.equals(applicationInfo.packageName);
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean b(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return false;
        }
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
            intent.addFlags(268435456);
            return packageManager.queryIntentActivities(intent, 65536).size() > 0;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
