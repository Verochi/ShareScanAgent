package com.sensorsdata.sf.core.utils;

/* loaded from: classes19.dex */
public class VersionUtils {
    static final java.lang.String REQUIRED_SA_VERSION = "6.2.4";
    private static final java.lang.String TAG = "VersionUtils";

    public static boolean checkSAVersion() {
        try {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI sharedInstance = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance();
            java.lang.reflect.Field declaredField = sharedInstance.getClass().getDeclaredField("VERSION");
            declaredField.setAccessible(true);
            java.lang.String str = (java.lang.String) declaredField.get(sharedInstance);
            if (!android.text.TextUtils.isEmpty(str)) {
                if (!isVersionValid(str.contains(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? str.substring(0, str.indexOf(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) : str, "6.2.4")) {
                    com.sensorsdata.sf.core.utils.SFLog.e(TAG, "当前神策 Android 埋点 SDK 版本 " + str + " 过低，请升级至 6.2.4 及其以上版本后进行使用");
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return false;
        }
    }

    public static boolean isVersionValid(java.lang.String str, java.lang.String str2) {
        if (str.equals(str2)) {
            return true;
        }
        java.lang.String[] split = str.split("\\.");
        java.lang.String[] split2 = str2.split("\\.");
        for (int i = 0; i < split2.length; i++) {
            int parseInt = java.lang.Integer.parseInt(split[i]);
            int parseInt2 = java.lang.Integer.parseInt(split2[i]);
            if (parseInt != parseInt2) {
                return parseInt > parseInt2;
            }
        }
        return false;
    }
}
