package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class AppInfoUtils {
    private static java.lang.String mAppVersionName;
    private static android.os.Bundle mConfigBundle;

    public static android.os.Bundle getAppInfoBundle(android.content.Context context) {
        if (mConfigBundle == null) {
            try {
                android.content.pm.ApplicationInfo applicationInfo = context.getApplicationContext().getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null) {
                    mConfigBundle = applicationInfo.metaData;
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
        android.os.Bundle bundle = mConfigBundle;
        return bundle == null ? new android.os.Bundle() : bundle;
    }

    public static java.lang.CharSequence getAppName(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationInfo(context.getPackageName(), 128).loadLabel(packageManager);
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.AppInfoUtils", th.getMessage());
            return "";
        }
    }

    public static java.lang.String getAppVersionName(android.content.Context context) {
        if (context == null) {
            return "";
        }
        if (!android.text.TextUtils.isEmpty(mAppVersionName)) {
            return mAppVersionName;
        }
        try {
            mAppVersionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return mAppVersionName;
    }

    private static java.lang.String getCurrentProcessName() {
        java.lang.String processName;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                processName = android.app.Application.getProcessName();
                return processName;
            }
            java.lang.String currentProcessNameByCmd = getCurrentProcessNameByCmd();
            return android.text.TextUtils.isEmpty(currentProcessNameByCmd) ? getCurrentProcessNameByAT() : currentProcessNameByCmd;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    private static java.lang.String getCurrentProcessNameByAT() {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.app.ActivityThread", false, android.app.Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            java.lang.Object invoke = declaredMethod.invoke(null, new java.lang.Object[0]);
            if (invoke instanceof java.lang.String) {
                return (java.lang.String) invoke;
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.String getCurrentProcessNameByCmd() {
        java.io.FileInputStream fileInputStream;
        byte[] bArr;
        int i;
        try {
            try {
                fileInputStream = new java.io.FileInputStream("/proc/self/cmdline");
                try {
                    bArr = new byte[256];
                    i = 0;
                    while (true) {
                        int read = fileInputStream.read();
                        if (read <= 0 || i >= 256) {
                            break;
                        }
                        bArr[i] = (byte) read;
                        i++;
                    }
                } catch (java.lang.Throwable unused) {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                }
            } catch (java.lang.Throwable unused2) {
                fileInputStream = null;
            }
        } catch (java.io.IOException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (i <= 0) {
            fileInputStream.close();
            return null;
        }
        java.lang.String str = new java.lang.String(bArr, 0, i, "UTF-8");
        try {
            fileInputStream.close();
        } catch (java.io.IOException e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
        return str;
    }

    public static java.lang.String getMainProcessName(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getApplicationContext().getApplicationInfo().processName;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    public static java.lang.String getProcessName(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getApplicationInfo().processName;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    public static boolean isMainProcess(android.content.Context context, android.os.Bundle bundle) {
        if (context == null) {
            return false;
        }
        java.lang.String mainProcessName = getMainProcessName(context);
        if (android.text.TextUtils.isEmpty(mainProcessName) && bundle != null) {
            mainProcessName = bundle.getString("com.sensorsdata.analytics.android.MainProcessName");
        }
        if (android.text.TextUtils.isEmpty(mainProcessName)) {
            return true;
        }
        java.lang.String currentProcessName = getCurrentProcessName();
        return android.text.TextUtils.isEmpty(currentProcessName) || mainProcessName.equals(currentProcessName);
    }

    public static boolean isTaskExecuteThread() {
        return android.text.TextUtils.equals(com.sensorsdata.analytics.android.sdk.core.tasks.ThreadNameConstants.THREAD_TASK_EXECUTE, java.lang.Thread.currentThread().getName());
    }
}
