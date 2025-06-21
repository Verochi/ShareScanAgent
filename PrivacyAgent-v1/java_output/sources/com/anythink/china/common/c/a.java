package com.anythink.china.common.c;

/* loaded from: classes12.dex */
public final class a {
    public static java.lang.String a(android.content.Context context, java.io.File file) {
        if (context != null && file != null) {
            try {
                return context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1).packageName;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        if (context != null && !android.text.TextUtils.isEmpty(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    private static void b(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean b(android.content.Context context, java.io.File file) {
        if (context != null && file != null) {
            java.lang.String a = a(context, file);
            if (!android.text.TextUtils.isEmpty(a)) {
                return a(context, a);
            }
        }
        return false;
    }
}
