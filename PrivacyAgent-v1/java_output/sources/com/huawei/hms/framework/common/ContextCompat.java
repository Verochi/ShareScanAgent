package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class ContextCompat {
    private static final java.lang.String TAG = "ContextCompat";

    public static boolean checkSelfPermission(android.content.Context context, java.lang.String str) {
        if (context == null || str == null) {
            com.huawei.hms.framework.common.Logger.w(TAG, "param is null");
            return false;
        }
        try {
            return context.checkPermission(str, android.os.Process.myPid(), android.os.Process.myUid()) == 0;
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
            return false;
        }
    }

    public static android.content.Context getProtectedStorageContext(android.content.Context context) {
        android.content.Context createDeviceProtectedStorageContext;
        if (context == null) {
            com.huawei.hms.framework.common.Logger.w(TAG, com.anythink.expressad.foundation.g.b.b.a);
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return context;
        }
        createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        return createDeviceProtectedStorageContext;
    }

    public static java.lang.Object getSystemService(android.content.Context context, java.lang.String str) {
        if (context == null) {
            com.huawei.hms.framework.common.Logger.w(TAG, com.anythink.expressad.foundation.g.b.b.a);
            return null;
        }
        try {
            return context.getSystemService(str);
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "SystemServer error:", e);
            return null;
        }
    }

    public static android.content.Intent registerReceiver(android.content.Context context, android.content.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        if (context == null) {
            com.huawei.hms.framework.common.Logger.w(TAG, com.anythink.expressad.foundation.g.b.b.a);
            return null;
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
            return null;
        }
    }

    public static android.content.Intent registerReceiver(android.content.Context context, android.content.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter, java.lang.String str, android.os.Handler handler) {
        if (context == null) {
            com.huawei.hms.framework.common.Logger.w(TAG, com.anythink.expressad.foundation.g.b.b.a);
            return null;
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
            return null;
        }
    }

    public static android.content.ComponentName startService(android.content.Context context, android.content.Intent intent) {
        if (context == null) {
            com.huawei.hms.framework.common.Logger.w(TAG, com.anythink.expressad.foundation.g.b.b.a);
            return null;
        }
        try {
            return context.startService(intent);
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "SystemServer error:", e);
            return null;
        }
    }

    public static void unregisterReceiver(android.content.Context context, android.content.BroadcastReceiver broadcastReceiver) {
        if (context == null) {
            com.huawei.hms.framework.common.Logger.w(TAG, com.anythink.expressad.foundation.g.b.b.a);
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "SystemServer error:", e);
        }
    }
}
