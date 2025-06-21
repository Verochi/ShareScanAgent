package com.meizu.cloud.pushsdk.util;

/* loaded from: classes23.dex */
public class MinSdkChecker {
    public static boolean isSupportBigTextStyleAndAction() {
        return true;
    }

    public static boolean isSupportDeviceDefaultLight() {
        return true;
    }

    public static boolean isSupportKeyguardState() {
        return true;
    }

    public static boolean isSupportNotificationBuild() {
        return true;
    }

    public static boolean isSupportNotificationChannel() {
        return android.os.Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isSupportNotificationSort() {
        return android.os.Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isSupportSendNotification() {
        return true;
    }

    public static boolean isSupportSetDrawableSmallIcon() {
        return android.os.Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportTransmitMessageValue(android.content.Context context, java.lang.String str) {
        return !android.text.TextUtils.isEmpty(com.meizu.cloud.pushsdk.util.MzSystemUtils.findReceiver(context, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_SYSTEM_RECEIVER_ACTION, str));
    }

    public static boolean isSupportVideoNotification() {
        return true;
    }
}
