package com.efs.sdk.fluttersdk;

/* loaded from: classes22.dex */
public class FlutterManager {
    public static final java.lang.String TAG = "FlutterManager";
    private static com.efs.sdk.base.EfsReporter a = null;
    private static com.efs.sdk.fluttersdk.FlutterConfigManager b = null;
    private static android.content.Context c = null;
    public static boolean isDebug = true;

    public static java.util.Map<java.lang.String, java.lang.Object> getCloudConfig() {
        com.efs.sdk.fluttersdk.FlutterConfigManager flutterConfigManager = b;
        if (flutterConfigManager != null) {
            return flutterConfigManager.getCloudConfig();
        }
        return null;
    }

    public static com.efs.sdk.fluttersdk.FlutterConfigManager getFlutterConfigManager() {
        return b;
    }

    public static long getLongValue(java.lang.String str) {
        android.content.Context context = c;
        if (context == null) {
            com.efs.sdk.base.core.util.Log.e(TAG, "Flutter Manager not init!");
            return 0L;
        }
        try {
            return context.getSharedPreferences("efs_flutter_bridge", 0).getLong(str, 0L);
        } catch (java.lang.Throwable unused) {
            return 0L;
        }
    }

    public static java.util.Map<java.lang.String, java.lang.Object> getNativeParams() {
        com.efs.sdk.fluttersdk.FlutterConfigManager flutterConfigManager = b;
        if (flutterConfigManager != null) {
            return flutterConfigManager.getNativeParams();
        }
        return null;
    }

    public static com.efs.sdk.base.EfsReporter getReporter() {
        return a;
    }

    public static void init(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            com.efs.sdk.base.core.util.Log.e(TAG, "init Flutter manager error! parameter is null!");
            return;
        }
        c = context;
        a = efsReporter;
        b = new com.efs.sdk.fluttersdk.FlutterConfigManager(context, efsReporter);
    }

    public static boolean putLongValue(java.lang.String str, long j) {
        android.content.Context context = c;
        if (context == null) {
            com.efs.sdk.base.core.util.Log.e(TAG, "Flutter Manager not init!");
            return false;
        }
        try {
            android.content.SharedPreferences.Editor edit = context.getSharedPreferences("efs_flutter_bridge", 0).edit();
            edit.putLong(str, j);
            edit.apply();
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
