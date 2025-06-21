package com.heytap.mcssdk.utils;

/* loaded from: classes22.dex */
public class Utils {
    public static java.lang.String getString(int[] iArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i : iArr) {
            sb.append((char) i);
        }
        return sb.toString();
    }

    public static int getVersionCode(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.b("getVersionCode--Exception:" + e.getMessage());
            return 0;
        }
    }

    public static int getVersionCode(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.b("getVersionCode--Exception:" + e.getMessage());
            return 0;
        }
    }

    public static java.lang.String getVersionName(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.b("getVersionName--Exception:" + e.getMessage());
            return "0";
        }
    }

    public static java.lang.String getVersionName(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.b("getVersionName--Exception:" + e.getMessage());
            return null;
        }
    }

    public static boolean isExistPackage(android.content.Context context, java.lang.String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.heytap.mcssdk.utils.d.e("isExistPackage NameNotFoundException:" + e.getMessage());
            return false;
        }
    }

    public static boolean isSupportPush(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.pm.ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.heytap.mcssdk.utils.d.e("isSupportPush NameNotFoundException:" + e.getMessage());
            applicationInfo = null;
        }
        return applicationInfo != null && applicationInfo.metaData.getBoolean(str2, false);
    }

    public static boolean isSupportPushByClient(android.content.Context context) {
        return com.heytap.mcssdk.PushService.getInstance().isSupportPushByClient(context);
    }

    public static int parseInt(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                return java.lang.Integer.parseInt(str);
            } catch (java.lang.NumberFormatException e) {
                com.heytap.mcssdk.utils.d.e("parseInt--NumberFormatException" + e.getMessage());
            }
        }
        return -1;
    }
}
