package com.bytedance.android.openliveplugin.process;

/* loaded from: classes.dex */
public class LiveProcessUtils {
    private static java.lang.String currentProcessName;

    public static java.lang.String getCurrentProcessName(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }
        java.lang.String currentProcessNameByApplication = getCurrentProcessNameByApplication();
        currentProcessName = currentProcessNameByApplication;
        if (!android.text.TextUtils.isEmpty(currentProcessNameByApplication)) {
            return currentProcessName;
        }
        java.lang.String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
        currentProcessName = currentProcessNameByActivityThread;
        if (!android.text.TextUtils.isEmpty(currentProcessNameByActivityThread)) {
            return currentProcessName;
        }
        java.lang.String currentProcessNameByActivityManager = getCurrentProcessNameByActivityManager(context);
        currentProcessName = currentProcessNameByActivityManager;
        return currentProcessNameByActivityManager;
    }

    private static java.lang.String getCurrentProcessNameByActivityManager(android.content.Context context) {
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int myPid = android.os.Process.myPid();
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    private static java.lang.String getCurrentProcessNameByActivityThread() {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.app.ActivityThread", false, android.app.Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            java.lang.Object invoke = declaredMethod.invoke(null, new java.lang.Object[0]);
            if (invoke instanceof java.lang.String) {
                return (java.lang.String) invoke;
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static java.lang.String getCurrentProcessNameByApplication() {
        java.lang.String processName;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            processName = android.app.Application.getProcessName();
            return processName;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.Boolean inLiveProcess(android.content.Context context) {
        return (context == null || context.getApplicationContext() == null) ? java.lang.Boolean.FALSE : java.lang.Boolean.valueOf(getCurrentProcessName(context).endsWith(":bytelive"));
    }

    public static boolean isMainProcess(android.content.Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return false;
        }
        return android.text.TextUtils.equals(context.getApplicationContext().getPackageName(), getCurrentProcessName(context));
    }
}
