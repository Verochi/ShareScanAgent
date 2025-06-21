package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class PowerUtils {
    private static final java.lang.String TAG = "PowerUtils";

    public static final class PowerMode {
        static int POWER_MODE_DEFAULT_RETURN_VALUE = 0;
        static int POWER_SAVER_MODE = 4;
        static java.lang.String SMART_MODE_STATUS = "SmartModeStatus";
    }

    public static boolean isAppIdleMode(android.content.Context context) {
        android.app.usage.UsageStatsManager usageStatsManager;
        boolean isAppInactive;
        if (context == null) {
            com.huawei.hms.framework.common.Logger.i(TAG, "isAppIdleMode Context is null!");
            return false;
        }
        java.lang.String packageName = context.getPackageName();
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 22) {
            java.lang.Object systemService = context.getSystemService("usagestats");
            if (!(systemService instanceof android.app.usage.UsageStatsManager)) {
                return false;
            }
            usageStatsManager = (android.app.usage.UsageStatsManager) systemService;
        } else {
            usageStatsManager = null;
        }
        if (usageStatsManager == null) {
            com.huawei.hms.framework.common.Logger.i(TAG, "isAppIdleMode statsManager is null!");
            return false;
        }
        if (i < 23) {
            return false;
        }
        isAppInactive = usageStatsManager.isAppInactive(packageName);
        return isAppInactive;
    }

    public static boolean isDozeIdleMode(android.content.Context context) {
        boolean isDeviceIdleMode;
        if (context == null) {
            com.huawei.hms.framework.common.Logger.i(TAG, "isDozeIdleMode Context is null!");
            return false;
        }
        java.lang.Object systemService = com.huawei.hms.framework.common.ContextCompat.getSystemService(context, "power");
        android.os.PowerManager powerManager = systemService instanceof android.os.PowerManager ? (android.os.PowerManager) systemService : null;
        if (powerManager == null) {
            com.huawei.hms.framework.common.Logger.i(TAG, "isDozeIdleMode powerManager is null!");
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT < 23) {
            com.huawei.hms.framework.common.Logger.i(TAG, "isDozeIdleMode is version control state!");
            return false;
        }
        try {
            isDeviceIdleMode = powerManager.isDeviceIdleMode();
            return isDeviceIdleMode;
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
            return false;
        }
    }

    public static boolean isInteractive(android.content.Context context) {
        if (context != null) {
            java.lang.Object systemService = com.huawei.hms.framework.common.ContextCompat.getSystemService(context, "power");
            if (systemService instanceof android.os.PowerManager) {
                try {
                    return ((android.os.PowerManager) systemService).isInteractive();
                } catch (java.lang.RuntimeException e) {
                    com.huawei.hms.framework.common.Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName() + e.getMessage());
                }
            }
        }
        return false;
    }

    public static boolean isWhilteList(android.content.Context context) {
        boolean isIgnoringBatteryOptimizations;
        if (context != null) {
            java.lang.Object systemService = com.huawei.hms.framework.common.ContextCompat.getSystemService(context, "power");
            android.os.PowerManager powerManager = systemService instanceof android.os.PowerManager ? (android.os.PowerManager) systemService : null;
            java.lang.String packageName = context.getPackageName();
            if (powerManager != null && android.os.Build.VERSION.SDK_INT >= 23) {
                try {
                    isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(packageName);
                    return isIgnoringBatteryOptimizations;
                } catch (java.lang.RuntimeException e) {
                    com.huawei.hms.framework.common.Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
                }
            }
        }
        return false;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static int readDataSaverMode(android.content.Context context) {
        int restrictBackgroundStatus;
        if (context == null) {
            com.huawei.hms.framework.common.Logger.i(TAG, "readDataSaverMode manager is null!");
            return 0;
        }
        java.lang.Object systemService = context.getSystemService("connectivity");
        android.net.ConnectivityManager connectivityManager = systemService instanceof android.net.ConnectivityManager ? (android.net.ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            com.huawei.hms.framework.common.Logger.i(TAG, "readDataSaverMode Context is null!");
            return 0;
        }
        int i = android.os.Build.VERSION.SDK_INT;
        if (com.huawei.hms.framework.common.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return 0;
        }
        if (!connectivityManager.isActiveNetworkMetered()) {
            com.huawei.hms.framework.common.Logger.v(TAG, "ConnectType is not Mobile Network!");
            return 0;
        }
        if (i < 24) {
            return 0;
        }
        restrictBackgroundStatus = connectivityManager.getRestrictBackgroundStatus();
        return restrictBackgroundStatus;
    }

    public static int readPowerSaverMode(android.content.Context context) {
        if (context == null) {
            com.huawei.hms.framework.common.Logger.i(TAG, "readPowerSaverMode Context is null!");
            return 0;
        }
        int systemInt = com.huawei.hms.framework.common.SettingUtil.getSystemInt(context.getContentResolver(), com.huawei.hms.framework.common.PowerUtils.PowerMode.SMART_MODE_STATUS, com.huawei.hms.framework.common.PowerUtils.PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE);
        if (systemInt != com.huawei.hms.framework.common.PowerUtils.PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE) {
            return systemInt;
        }
        java.lang.Object systemService = com.huawei.hms.framework.common.ContextCompat.getSystemService(context, "power");
        android.os.PowerManager powerManager = systemService instanceof android.os.PowerManager ? (android.os.PowerManager) systemService : null;
        if (powerManager == null) {
            return systemInt;
        }
        try {
            return powerManager.isPowerSaveMode() ? com.huawei.hms.framework.common.PowerUtils.PowerMode.POWER_SAVER_MODE : com.huawei.hms.framework.common.PowerUtils.PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE;
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
            return systemInt;
        }
    }
}
