package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public class UIUtil {
    public static android.app.Activity getActiveActivity(android.app.Activity activity, android.content.Context context) {
        if (isBackground(context)) {
            com.huawei.hms.support.log.HMSLog.i("UIUtil", "isBackground" + isBackground(context));
            return null;
        }
        if (activity == null) {
            com.huawei.hms.support.log.HMSLog.i("UIUtil", "activity is null");
            return com.huawei.hms.support.common.ActivityMgr.INST.getCurrentActivity();
        }
        if (!activity.isFinishing()) {
            return activity;
        }
        com.huawei.hms.support.log.HMSLog.i("UIUtil", "activity isFinishing is " + activity.isFinishing());
        return com.huawei.hms.support.common.ActivityMgr.INST.getCurrentActivity();
    }

    public static java.lang.String getProcessName(android.content.Context context, int i) {
        android.app.ActivityManager activityManager;
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && (activityManager = (android.app.ActivityManager) context.getSystemService("activity")) != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == i) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static boolean isActivityFullscreen(android.app.Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public static boolean isBackground(android.content.Context context) {
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return true;
        }
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        android.app.KeyguardManager keyguardManager = (android.app.KeyguardManager) context.getSystemService("keyguard");
        if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return true;
        }
        java.lang.String processName = getProcessName(context, android.os.Process.myPid());
        for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (android.text.TextUtils.equals(runningAppProcessInfo.processName, processName)) {
                com.huawei.hms.support.log.HMSLog.i("UIUtil", "appProcess.importance is " + runningAppProcessInfo.importance);
                boolean z = runningAppProcessInfo.importance == 100;
                boolean isKeyguardLocked = keyguardManager.isKeyguardLocked();
                com.huawei.hms.support.log.HMSLog.i("UIUtil", "isForground is " + z + "***  isLockedState is " + isKeyguardLocked);
                return !z || isKeyguardLocked;
            }
        }
        return true;
    }
}
