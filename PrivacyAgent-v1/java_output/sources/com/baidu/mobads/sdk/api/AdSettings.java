package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class AdSettings {
    public static java.lang.String getSDKVersion() {
        return com.baidu.mobads.sdk.internal.cm.c() + "";
    }

    public static void setNotificationChannel(java.lang.String str) {
        com.baidu.mobads.sdk.api.CustomNotification.setNotificationChannel(str);
    }

    public static void setNotificationIcon(@androidx.annotation.DrawableRes int i) {
        com.baidu.mobads.sdk.api.CustomNotification.setNotificationIcon(i);
    }
}
