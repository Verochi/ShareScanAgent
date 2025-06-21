package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class ManifestUtils {
    public static java.lang.String getChannelNo(android.content.Context context, java.lang.String str) {
        return getMetaData(context, str);
    }

    public static java.lang.String getMetaData(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        try {
            str2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str2 = "";
        }
        return com.aliyun.common.utils.StringUtils.isEmpty(str2) ? "" : str2;
    }

    public static int getVersionCode(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static java.lang.String getVersionName(android.content.Context context) {
        java.lang.String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str = "";
        }
        return com.aliyun.common.utils.StringUtils.isEmpty(str) ? "" : str;
    }
}
