package com.meizu.cloud.pushsdk.util;

/* loaded from: classes23.dex */
public class MzSystemUtils {
    private static final java.lang.String PUSH_SERVICE_PROCESS_NAME = "mzservice_v1";
    private static final java.lang.String TAG = "MzSystemUtils";
    private static int flymeVersion = -1;
    private static java.lang.String sCharacteristics;

    public static boolean compareVersion(java.lang.String str, java.lang.String str2) {
        java.lang.String[] split = str.split("\\.");
        java.lang.String[] split2 = str2.split("\\.");
        int min = java.lang.Math.min(split.length, split2.length);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            i = split[i2].length() - split2[i2].length();
            if (i != 0 || (i = split[i2].compareTo(split2[i2])) != 0) {
                break;
            }
        }
        if (i == 0) {
            i = split.length - split2.length;
        }
        return i >= 0;
    }

    public static java.lang.String findReceiver(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            try {
                android.content.Intent intent = new android.content.Intent(str);
                intent.setPackage(str2);
                java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    return queryBroadcastReceivers.get(0).activityInfo.name;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int getAppVersionCode(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public static java.lang.String getAppVersionName(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String getAppVersionName(android.content.Context context, java.lang.String str) {
        try {
            java.lang.String str2 = context.getPackageManager().getPackageInfo(str, 0).versionName;
            if (str2 != null) {
                if (str2.length() > 0) {
                    return str2;
                }
            }
            return "";
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "Exception message " + e.getMessage());
            return "";
        }
    }

    public static java.lang.String getCurrentLanguage() {
        try {
            return java.util.Locale.getDefault().getLanguage();
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "getCurrentLanguage error " + e.getMessage());
            return null;
        }
    }

    public static java.lang.String getDocumentsPath(android.content.Context context) {
        java.io.File externalFilesDir = context.getExternalFilesDir(android.os.Environment.DIRECTORY_DOCUMENTS);
        if (externalFilesDir != null) {
            return externalFilesDir.getPath();
        }
        return "/storage/emulated/0/Android/data/" + context.getPackageName() + "/files/Documents";
    }

    public static int getFlymeVersion() {
        int i = flymeVersion;
        if (i > 0) {
            return i;
        }
        try {
            try {
                int parseInt = java.lang.Integer.parseInt(com.meizu.cloud.pushsdk.b.i.a("ro.build.flyme.version"));
                flymeVersion = parseInt;
                return parseInt;
            } catch (java.lang.Exception unused) {
                java.lang.String a = com.meizu.cloud.pushsdk.b.i.a("ro.flyme.version.id");
                if (android.text.TextUtils.isEmpty(a)) {
                    a = com.meizu.cloud.pushsdk.b.i.a("ro.build.display.id");
                }
                int intValue = java.lang.Integer.valueOf(a.replace("Flyme", "").replace(" ", "").substring(0, 1)).intValue();
                flymeVersion = intValue;
                return intValue;
            }
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "getFlymeVersion error " + e.getMessage());
            return -1;
        }
    }

    public static java.lang.String getMzPushServicePackageName(android.content.Context context) {
        java.lang.String packageName = context.getPackageName();
        try {
            java.lang.String str = isWatch() ? com.meizu.cloud.pushsdk.constants.PushConstants.WEARABLE_PUSH_PACKAGE_NAME : com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME;
            java.lang.String servicesByPackageName = getServicesByPackageName(context, str);
            if (!android.text.TextUtils.isEmpty(servicesByPackageName)) {
                if (servicesByPackageName.contains(PUSH_SERVICE_PROCESS_NAME)) {
                    return str;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.meizu.cloud.pushinternal.DebugLogger.i(TAG, "start service package name " + packageName);
        return packageName;
    }

    public static java.lang.String getNetWorkType(android.content.Context context) {
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            android.net.NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null) {
                return "";
            }
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                return type != 1 ? type != 7 ? type != 9 ? "OTHER" : "ETHERNET" : "BLUETOOTH" : "WIFI";
            }
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype != 18) {
                if (subtype == 20) {
                    return "MOBILE_5G";
                }
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "MOBILE_2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "MOBILE_3G";
                    case 13:
                        break;
                    default:
                        return "MOBILE_XG";
                }
            }
            return "MOBILE_4G";
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "Security exception checking connection: " + e.getMessage());
            return "";
        }
    }

    public static java.lang.String getProcessName(android.content.Context context) {
        try {
            int myPid = android.os.Process.myPid();
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getApplicationContext().getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                com.meizu.cloud.pushinternal.DebugLogger.i(TAG, "processName " + runningAppProcessInfo.processName);
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "getProcessName error " + e.getMessage());
            return null;
        }
    }

    private static java.lang.String getServicesByPackageName(android.content.Context context, java.lang.String str) {
        android.content.pm.ServiceInfo[] serviceInfoArr;
        try {
            serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
        } catch (java.lang.Exception unused) {
            serviceInfoArr = null;
        }
        if (serviceInfoArr == null) {
            return null;
        }
        for (android.content.pm.ServiceInfo serviceInfo : serviceInfoArr) {
            if (com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_SERVICE_NAME.equals(serviceInfo.name)) {
                return serviceInfo.processName;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isBrandMeizu(android.content.Context context) {
        boolean z;
        if (android.text.TextUtils.isEmpty(com.meizu.cloud.pushsdk.b.i.a("ro.meizu.product.model")) && android.text.TextUtils.isEmpty(com.meizu.cloud.pushsdk.b.i.a("ro.vendor.meizu.product.model"))) {
            java.lang.String str = android.os.Build.BRAND;
            if (!com.igexin.assist.util.AssistUtils.BRAND_MZ.equalsIgnoreCase(str) && !"魅蓝".equalsIgnoreCase(str) && !"22c4185e".equalsIgnoreCase(str)) {
                z = false;
                if (!z) {
                    com.meizu.cloud.pushsdk.a.a.b(context.getApplicationContext());
                }
                return z;
            }
        }
        z = true;
        if (!z) {
        }
        return z;
    }

    public static boolean isExistReceiver(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        android.content.Intent intent = new android.content.Intent(str2);
        intent.setPackage(str);
        java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        return (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0 || android.text.TextUtils.isEmpty(queryBroadcastReceivers.get(0).activityInfo.name)) ? false : true;
    }

    public static boolean isHuaWei() {
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "huawei eui " + com.meizu.cloud.pushsdk.b.i.a(com.alipay.sdk.m.c.a.a));
        return !android.text.TextUtils.isEmpty(r0);
    }

    public static boolean isIndiaLocal() {
        return "india".equals(com.meizu.cloud.pushsdk.b.i.a("ro.meizu.locale.region"));
    }

    public static boolean isInteractive(android.content.Context context) {
        android.os.PowerManager powerManager = (android.os.PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return true;
        }
        try {
            return powerManager.isInteractive();
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "isScreenOn error " + e.getMessage());
            return true;
        }
    }

    public static boolean isInternational() {
        if (com.meizu.cloud.pushsdk.b.a.a().a) {
            return com.meizu.cloud.pushsdk.b.a.a().b.booleanValue();
        }
        return false;
    }

    public static boolean isMeizu(android.content.Context context) {
        return isBrandMeizu(context);
    }

    public static boolean isMeizuAndFlyme() {
        if (com.meizu.cloud.pushsdk.b.a.b().a) {
            return !r0.b.booleanValue();
        }
        return false;
    }

    public static boolean isOverseas() {
        return isInternational() || isIndiaLocal();
    }

    public static boolean isPackageInstalled(android.content.Context context, java.lang.String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean isRunningProcess(android.content.Context context, java.lang.String str) {
        try {
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            boolean z = false;
            if (activityManager == null) {
                return false;
            }
            java.util.Iterator<android.app.ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
            while (it.hasNext() && !(z = it.next().processName.contains(str))) {
            }
            com.meizu.cloud.pushinternal.DebugLogger.i(TAG, str + " is running " + z);
            return z;
        } catch (java.lang.Exception unused) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "can not get running process info so set running true");
            return true;
        }
    }

    public static boolean isWatch() {
        if (android.text.TextUtils.isEmpty(sCharacteristics)) {
            sCharacteristics = com.meizu.cloud.pushsdk.b.i.a("ro.build.characteristics");
        }
        if (!android.text.TextUtils.isEmpty(sCharacteristics)) {
            return sCharacteristics.contains("watch");
        }
        sCharacteristics = com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE;
        return false;
    }

    public static boolean isXiaoMi() {
        return "Xiaomi".equals(android.os.Build.MODEL) || "Xiaomi".equals(android.os.Build.MANUFACTURER);
    }

    public static void sendMessageFromBroadcast(android.content.Context context, android.content.Intent intent, java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        java.lang.String findReceiver = findReceiver(context, str, str2);
        if (!android.text.TextUtils.isEmpty(findReceiver)) {
            intent.setClassName(str2, findReceiver);
        }
        context.sendBroadcast(intent);
    }
}
