package com.huawei.hms.stats;

/* loaded from: classes22.dex */
public class a {
    public static int a;
    public static final java.lang.Object b = new java.lang.Object();

    public static boolean a(android.content.Context context) {
        android.os.Bundle bundle;
        if (context == null) {
            com.huawei.hms.support.log.HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, context is null.");
            return false;
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                android.content.pm.ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getBoolean("com.huawei.hms.client.bireport.setting");
                }
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                com.huawei.hms.support.log.HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
            } catch (java.lang.RuntimeException e) {
                com.huawei.hms.support.log.HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.", e);
            }
        }
        com.huawei.hms.support.log.HMSLog.i("AnalyticsSwitchHolder", "In getBiIsReportSetting, configuration not found for bi report setting.");
        return false;
    }

    public static boolean b(android.content.Context context) {
        android.os.Bundle bundle;
        if (context == null) {
            com.huawei.hms.support.log.HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, context is null.");
            return false;
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                android.content.pm.ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getBoolean("com.huawei.hms.client.bi.setting");
                }
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                com.huawei.hms.support.log.HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.");
            } catch (java.lang.RuntimeException e) {
                com.huawei.hms.support.log.HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.", e);
            }
        }
        com.huawei.hms.support.log.HMSLog.i("AnalyticsSwitchHolder", "In getBiSetting, configuration not found for bisetting.");
        return false;
    }

    public static boolean c(android.content.Context context) {
        synchronized (b) {
            boolean z = true;
            if (a == 0) {
                if (context == null) {
                    return true;
                }
                if (a(context)) {
                    com.huawei.hms.support.log.HMSLog.i("AnalyticsSwitchHolder", "Builder->biReportSetting :true");
                    a = 1;
                } else if (b(context)) {
                    com.huawei.hms.support.log.HMSLog.i("AnalyticsSwitchHolder", "Builder->biSetting :true");
                    a = 2;
                } else if ("CN".equalsIgnoreCase(com.huawei.hms.framework.network.grs.GrsApp.getInstance().getIssueCountryCode(context))) {
                    a = 1;
                } else {
                    com.huawei.hms.support.log.HMSLog.i("AnalyticsSwitchHolder", "not ChinaROM");
                    try {
                        int i = android.provider.Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
                        com.huawei.hms.support.log.HMSLog.i("AnalyticsSwitchHolder", "hw_app_analytics_state value is " + i);
                        if (i == 1) {
                            a = 1;
                        } else {
                            a = 2;
                        }
                    } catch (android.provider.Settings.SettingNotFoundException unused) {
                        com.huawei.hms.support.log.HMSLog.i("AnalyticsSwitchHolder", "Get OOBE failed");
                        a = 2;
                    }
                }
            }
            if (a == 1) {
                z = false;
            }
            return z;
        }
    }
}
