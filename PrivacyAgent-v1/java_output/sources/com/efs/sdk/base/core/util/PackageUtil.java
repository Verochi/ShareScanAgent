package com.efs.sdk.base.core.util;

/* loaded from: classes22.dex */
public class PackageUtil {
    public static java.lang.String getAppVersionCode(android.content.Context context) {
        try {
            return java.lang.String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.w("efs.util.pkg", "get version name error", th);
            return "unknown";
        }
    }

    public static java.lang.String getAppVersionName(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.w("efs.util.pkg", "get version name error", th);
            return "unknown";
        }
    }

    public static java.lang.String getPackageName(android.content.Context context) {
        return context.getPackageName();
    }
}
