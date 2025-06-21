package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class PackageUtils {
    private static final java.lang.String TAG = "PackageUtils";

    public static java.lang.String getVersionName(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.huawei.hms.framework.common.Logger.w("PackageUtils", "", e);
            return "";
        }
    }
}
