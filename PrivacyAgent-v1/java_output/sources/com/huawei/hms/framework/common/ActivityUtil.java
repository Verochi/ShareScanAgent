package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class ActivityUtil {
    private static final java.lang.String TAG = "ActivityUtil";

    public static android.app.PendingIntent getActivities(android.content.Context context, int i, android.content.Intent[] intentArr, int i2) {
        if (context == null) {
            com.huawei.hms.framework.common.Logger.w(TAG, com.anythink.expressad.foundation.g.b.b.a);
            return null;
        }
        try {
            return android.app.PendingIntent.getActivities(context, i, intentArr, i2);
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
            return null;
        }
    }

    public static boolean isForeground(android.content.Context context) {
        android.app.ActivityManager activityManager;
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> list;
        if (context == null || (activityManager = (android.app.ActivityManager) com.huawei.hms.framework.common.ContextCompat.getSystemService(context, "activity")) == null) {
            return false;
        }
        try {
            list = activityManager.getRunningAppProcesses();
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.w(TAG, "activityManager getRunningAppProcesses occur exception: ", e);
            list = null;
        }
        if (list == null) {
            return false;
        }
        for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            java.lang.String str = runningAppProcessInfo.processName;
            if (str != null && str.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                com.huawei.hms.framework.common.Logger.v(TAG, "isForeground true");
                return true;
            }
        }
        return false;
    }
}
