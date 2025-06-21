package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public class Util {
    private static final java.lang.String AVAILABLE_LOADED = "availableLoaded";
    private static final java.lang.Object LOCK_OBJECT = new java.lang.Object();
    private static final java.lang.String META_HMSVERSION_NAME = "com.huawei.hms.version";
    private static final java.lang.String SERVICE_ACTION = "com.huawei.hms.core.internal";
    private static final java.lang.String TAG = "Util";
    private static boolean availableInit;
    private static boolean isAvailableAvailable;
    private static java.lang.String serviceAction;

    public static int compareHmsVersion(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (com.huawei.hms.utils.StringUtil.checkVersion(str) && com.huawei.hms.utils.StringUtil.checkVersion(str2)) {
            java.lang.String[] split = str.split("\\.");
            java.lang.String[] split2 = str2.split("\\.");
            if (2 < split.length && 2 < split2.length) {
                if (java.lang.Integer.parseInt(split[0]) > java.lang.Integer.parseInt(split2[0])) {
                    return 1;
                }
                if (java.lang.Integer.parseInt(split[0]) < java.lang.Integer.parseInt(split2[0])) {
                    return -1;
                }
                if (java.lang.Integer.parseInt(split[1]) > java.lang.Integer.parseInt(split2[1])) {
                    return 1;
                }
                if (java.lang.Integer.parseInt(split[1]) < java.lang.Integer.parseInt(split2[1])) {
                    return -1;
                }
                if (java.lang.Integer.parseInt(split[2]) > java.lang.Integer.parseInt(split2[2])) {
                    return 1;
                }
                if (java.lang.Integer.parseInt(split[2]) < java.lang.Integer.parseInt(split2[2])) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static android.app.Activity getActiveActivity(android.app.Activity activity, android.content.Context context) {
        return com.huawei.hms.utils.UIUtil.getActiveActivity(activity, context);
    }

    public static java.lang.String getAppId(android.content.Context context) {
        return com.huawei.hms.common.util.AGCUtils.getAppId(context);
    }

    public static java.lang.String getAppName(android.content.Context context, java.lang.String str) {
        if (context == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "In getAppName, context is null.");
            return "";
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "In getAppName, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            java.lang.CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128));
            return applicationLabel == null ? "" : applicationLabel.toString();
        } catch (android.content.res.Resources.NotFoundException | android.util.AndroidException unused) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "In getAppName, Failed to get app name.");
            return "";
        }
    }

    public static java.lang.String getCpId(android.content.Context context) {
        return com.huawei.hms.common.util.AGCUtils.getCpId(context);
    }

    public static int getHmsVersion(android.content.Context context) {
        android.os.Bundle bundle;
        java.lang.Object obj;
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "In getHmsVersion, Failed to get 'PackageManager' instance.");
            return 0;
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get(META_HMSVERSION_NAME)) != null) {
                java.lang.String valueOf = java.lang.String.valueOf(obj);
                if (!android.text.TextUtils.isEmpty(valueOf)) {
                    return com.huawei.hms.utils.StringUtil.convertVersion2Integer(valueOf);
                }
            }
            com.huawei.hms.support.log.HMSLog.i(TAG, "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
            return 0;
        } catch (android.util.AndroidException unused) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
            return 0;
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "In getHmsVersion, Failed to read meta data for the HMS VERSION.", e);
            return 0;
        }
    }

    public static java.lang.String getNetType(android.content.Context context) {
        return com.huawei.hms.android.SystemUtils.getNetType(context);
    }

    public static java.lang.String getProcessName(android.content.Context context, int i) {
        return com.huawei.hms.utils.UIUtil.getProcessName(context, i);
    }

    @java.lang.Deprecated
    public static java.lang.String getProductCountry() {
        int lastIndexOf;
        java.lang.String systemProperties = getSystemProperties("ro.product.locale.region", "");
        if (!android.text.TextUtils.isEmpty(systemProperties)) {
            return systemProperties;
        }
        java.lang.String systemProperties2 = getSystemProperties("ro.product.locale", "");
        if (!android.text.TextUtils.isEmpty(systemProperties2) && (lastIndexOf = systemProperties2.lastIndexOf(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != -1) {
            return systemProperties2.substring(lastIndexOf + 1);
        }
        java.lang.String localCountry = com.huawei.hms.android.SystemUtils.getLocalCountry();
        return !android.text.TextUtils.isEmpty(localCountry) ? localCountry : "";
    }

    public static java.lang.String getServiceActionMetadata(android.content.Context context) {
        java.lang.String str = serviceAction;
        if (str != null) {
            return str;
        }
        android.content.Intent intent = new android.content.Intent("com.huawei.hms.core.internal");
        intent.setPackage(context.getPackageName());
        if (context.getPackageManager().resolveService(intent, 128) != null) {
            serviceAction = "com.huawei.hms.core.internal";
            return "com.huawei.hms.core.internal";
        }
        serviceAction = "";
        return "";
    }

    public static java.lang.String getSystemProperties(java.lang.String str, java.lang.String str2) {
        return com.huawei.hms.android.SystemUtils.getSystemProperties(str, str2);
    }

    public static android.app.Activity getValidActivity(android.app.Activity activity, android.app.Activity activity2) {
        if (activity != null && !activity.isFinishing()) {
            return activity;
        }
        if (activity2 == null || activity2.isFinishing()) {
            return null;
        }
        return activity2;
    }

    public static boolean isAvailableLibExist(android.content.Context context) {
        boolean z;
        android.os.Bundle bundle;
        java.lang.Object obj;
        synchronized (LOCK_OBJECT) {
            if (!availableInit) {
                android.content.pm.PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    com.huawei.hms.support.log.HMSLog.e(TAG, "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                } else {
                    try {
                        android.content.pm.ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get(AVAILABLE_LOADED)) != null && java.lang.String.valueOf(obj).equalsIgnoreCase("yes")) {
                            com.huawei.hms.support.log.HMSLog.i(TAG, "available exist: true");
                        }
                    } catch (android.util.AndroidException unused) {
                        com.huawei.hms.support.log.HMSLog.e(TAG, "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");
                    } catch (java.lang.RuntimeException e) {
                        com.huawei.hms.support.log.HMSLog.e(TAG, "In isAvailableLibExist, Failed to read meta data for the availableLoaded.", e);
                    }
                    z = false;
                    isAvailableAvailable = z;
                    availableInit = true;
                }
                z = true;
                isAvailableAvailable = z;
                availableInit = true;
            }
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "available exist: " + isAvailableAvailable);
        return isAvailableAvailable;
    }

    public static boolean isChinaROM() {
        return com.huawei.hms.android.SystemUtils.isChinaROM();
    }

    public static boolean isEMUI() {
        return com.huawei.hms.android.SystemUtils.isEMUI();
    }

    public static void unBindServiceCatchException(android.content.Context context, android.content.ServiceConnection serviceConnection) {
        try {
            com.huawei.hms.support.log.HMSLog.i(TAG, "Trying to unbind service from " + serviceConnection);
            context.unbindService(serviceConnection);
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "On unBindServiceException:" + e.getMessage());
        }
    }
}
