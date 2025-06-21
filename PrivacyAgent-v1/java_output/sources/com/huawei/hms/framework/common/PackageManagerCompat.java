package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class PackageManagerCompat {
    private static final java.lang.String TAG = "PackageUtils";
    private static final java.lang.String VERSION = "5.0.10.302";
    private static java.lang.String sAppVersion = "";

    public static java.lang.String getAppPackageName(android.content.Context context) {
        if (com.huawei.hms.framework.common.ContextHolder.getAppContext() != null) {
            context = com.huawei.hms.framework.common.ContextHolder.getAppContext();
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 16384).packageName;
        } catch (android.content.pm.PackageManager.NameNotFoundException | java.lang.RuntimeException unused) {
            com.huawei.hms.framework.common.Logger.w("PackageUtils", "Failed to get Package managers Package Info");
            return "";
        }
    }

    public static java.lang.String getAppVersion(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(sAppVersion)) {
            return sAppVersion;
        }
        if (com.huawei.hms.framework.common.ContextHolder.getAppContext() != null) {
            context = com.huawei.hms.framework.common.ContextHolder.getAppContext();
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return sAppVersion;
        }
        try {
            sAppVersion = java.lang.String.valueOf(packageManager.getPackageInfo(context.getPackageName(), 16384).versionCode);
        } catch (android.content.pm.PackageManager.NameNotFoundException | java.lang.RuntimeException unused) {
            com.huawei.hms.framework.common.Logger.w("PackageUtils", "Failed to get Package managers Package Info");
        }
        return sAppVersion;
    }

    private static android.os.Bundle getBundleFromApp(android.content.Context context) {
        android.content.pm.PackageManager packageManager;
        android.os.Bundle bundle = android.os.Bundle.EMPTY;
        if (com.huawei.hms.framework.common.ContextHolder.getAppContext() != null) {
            context = com.huawei.hms.framework.common.ContextHolder.getAppContext();
        }
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return bundle;
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return bundle;
            }
            android.os.Bundle bundle2 = applicationInfo.metaData;
            return bundle2 != null ? bundle2 : bundle;
        } catch (android.content.pm.PackageManager.NameNotFoundException | java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.w("PackageUtils", "NameNotFoundException:", e);
            return bundle;
        }
    }

    private static android.os.Bundle getBundleFromKit(android.content.Context context) {
        if (com.huawei.hms.framework.common.ContextHolder.getKitContext() != null) {
            context = com.huawei.hms.framework.common.ContextHolder.getKitContext();
        }
        if (context == null) {
            com.huawei.hms.framework.common.Logger.v("PackageUtils", "the kitContext is null");
            return android.os.Bundle.EMPTY;
        }
        if (context.getApplicationInfo() == null) {
            com.huawei.hms.framework.common.Logger.v("PackageUtils", "the kit applicationInfo is null");
            return android.os.Bundle.EMPTY;
        }
        android.os.Bundle bundle = context.getApplicationInfo().metaData;
        return bundle == null ? android.os.Bundle.EMPTY : bundle;
    }

    private static android.os.Bundle getBundleFromKitOrAPP(android.content.Context context) {
        android.os.Bundle bundleFromKit = getBundleFromKit(context);
        return (bundleFromKit == null || bundleFromKit.isEmpty()) ? getBundleFromApp(context) : bundleFromKit;
    }

    public static java.lang.String getMetaDataFromApp(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.os.Bundle bundleFromApp = getBundleFromApp(context);
        return bundleFromApp != null ? bundleFromApp.getString(str, str2) : str2;
    }

    public static java.lang.String getMetaDataFromKit(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            android.os.Bundle bundleFromKit = getBundleFromKit(context);
            return bundleFromKit == null ? str2 : bundleFromKit.getString(str, str2);
        } catch (java.lang.RuntimeException unused) {
            com.huawei.hms.framework.common.Logger.v("PackageUtils", "the kit metaData is runtimeException");
            return str2;
        }
    }

    public static java.lang.String getMetaDataFromKitOrApp(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return getBundleFromKitOrAPP(context).getString(str, str2);
    }

    public static java.util.Map<java.lang.String, java.lang.String> getMetaDataMapFromKitOrApp(android.content.Context context, java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        android.os.Bundle bundleFromKitOrAPP = getBundleFromKitOrAPP(context);
        for (java.lang.String str2 : getBundleFromKitOrAPP(context).keySet()) {
            if (str2.startsWith(str)) {
                java.lang.String string = bundleFromKitOrAPP.getString(str2);
                if (!android.text.TextUtils.isEmpty(string)) {
                    hashMap.put(str2.substring(str.length()), string);
                }
            }
        }
        return hashMap;
    }
}
