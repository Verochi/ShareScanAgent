package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class Utils {
    private static final java.lang.String TAG = "Utils";

    public static long getCurrentTime(boolean z) {
        return z ? android.os.SystemClock.elapsedRealtime() : java.lang.System.currentTimeMillis();
    }

    public static boolean is64Bit(android.content.Context context) {
        boolean is64Bit;
        boolean z = false;
        if (context == null) {
            com.huawei.hms.framework.common.Logger.e(TAG, "Null context, please check it.");
            return false;
        }
        android.content.Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            is64Bit = android.os.Process.is64Bit();
            return is64Bit;
        }
        try {
            return applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).nativeLibraryDir.contains("64");
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.hms.framework.common.Logger.e(TAG, "Get application info failed: name not found, try to get baseContext.");
            if (context instanceof android.content.ContextWrapper) {
                android.content.Context baseContext = ((android.content.ContextWrapper) context).getBaseContext();
                z = true;
                if (baseContext == null) {
                    com.huawei.hms.framework.common.Logger.w(TAG, "Get baseContext failed: null. Return default: is64-bit.");
                    return true;
                }
                try {
                    z = baseContext.getPackageManager().getApplicationInfo(baseContext.getPackageName(), 128).nativeLibraryDir.contains("64");
                } catch (android.content.pm.PackageManager.NameNotFoundException unused2) {
                    com.huawei.hms.framework.common.Logger.e(TAG, "Get baseContext application info failed: name not found");
                }
            }
            return z;
        }
    }
}
