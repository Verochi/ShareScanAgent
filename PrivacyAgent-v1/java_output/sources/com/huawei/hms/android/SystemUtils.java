package com.huawei.hms.android;

/* loaded from: classes22.dex */
public class SystemUtils {
    public static java.lang.String a() {
        return getSystemProperties("ro.product.locale", "");
    }

    public static java.lang.String b() {
        return getSystemProperties("ro.product.locale.region", "");
    }

    public static java.lang.String getLocalCountry() {
        java.util.Locale locale = java.util.Locale.getDefault();
        return locale != null ? locale.getCountry() : "";
    }

    public static java.lang.String getNetType(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        android.net.NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? "" : activeNetworkInfo.getTypeName();
    }

    public static java.lang.String getSystemProperties(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return (java.lang.String) cls.getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls, str, str2);
        } catch (java.lang.ClassCastException | java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            com.huawei.hms.support.log.HMSLog.e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + str);
            return str2;
        }
    }

    public static boolean isChinaROM() {
        java.lang.String b = b();
        if (!android.text.TextUtils.isEmpty(b)) {
            return com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(b);
        }
        java.lang.String a = a();
        if (!android.text.TextUtils.isEmpty(a)) {
            return a.toLowerCase(java.util.Locale.US).contains(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION);
        }
        java.lang.String localCountry = getLocalCountry();
        if (android.text.TextUtils.isEmpty(localCountry)) {
            return false;
        }
        return com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(localCountry);
    }

    public static boolean isEMUI() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("is Emui :");
        int i = com.huawei.hms.android.HwBuildEx.VERSION.EMUI_SDK_INT;
        sb.append(i);
        com.huawei.hms.support.log.HMSLog.i("SystemUtils", sb.toString());
        return i > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isSystemApp(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.huawei.hms.support.log.HMSLog.e("SystemUtils", "isSystemApp Exception: " + e);
            packageInfo = null;
            if (packageInfo == null) {
            }
        } catch (java.lang.RuntimeException e2) {
            com.huawei.hms.support.log.HMSLog.e("SystemUtils", "isSystemApp RuntimeException:" + e2);
            packageInfo = null;
            if (packageInfo == null) {
            }
        }
        return packageInfo == null && (packageInfo.applicationInfo.flags & 1) > 0;
    }

    public static boolean isTVDevice() {
        return getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase("tv");
    }
}
