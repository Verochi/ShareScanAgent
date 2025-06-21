package com.meizu.cloud.pushsdk.notification;

/* loaded from: classes23.dex */
public class PushNotificationBuilder {
    private java.lang.String appLabel;
    private android.graphics.Bitmap appLargeIcon;
    private java.lang.String clickPackageName;
    private android.content.Context context;
    private int mLargeIcon;
    private int mNotificationDefaults;
    private int mNotificationFlags;
    private java.lang.String mNotificationSound;
    private int mStatusBarIcon;
    private long[] mVibratePattern;

    public PushNotificationBuilder() {
    }

    public PushNotificationBuilder(android.content.Context context) {
        this.context = context;
    }

    public java.lang.String getAppLabel() {
        return this.appLabel;
    }

    public android.graphics.Bitmap getAppLargeIcon() {
        return this.appLargeIcon;
    }

    public java.lang.String getClickPackageName() {
        return this.clickPackageName;
    }

    public android.content.Context getContext() {
        return this.context;
    }

    public int getLargeIcon() {
        return this.mLargeIcon;
    }

    public int getNotificationDefaults() {
        return this.mNotificationDefaults;
    }

    public int getNotificationFlags() {
        return this.mNotificationFlags;
    }

    public java.lang.String getNotificationSound() {
        return this.mNotificationSound;
    }

    public int getStatusBarIcon() {
        return this.mStatusBarIcon;
    }

    public long[] getVibratePattern() {
        return this.mVibratePattern;
    }

    public void setAppLabel(java.lang.String str) {
        this.appLabel = str;
    }

    public void setAppLargeIcon(android.graphics.Bitmap bitmap) {
        this.appLargeIcon = bitmap;
    }

    public void setClickPackageName(java.lang.String str) {
        this.clickPackageName = str;
    }

    public void setContext(android.content.Context context) {
        this.context = context;
    }

    public void setLargeIcon(int i) {
        this.mLargeIcon = i;
    }

    public void setNotificationDefaults(int i) {
        this.mNotificationDefaults = i;
    }

    public void setNotificationFlags(int i) {
        this.mNotificationFlags = i;
    }

    public void setNotificationSound(java.lang.String str) {
        this.mNotificationSound = str;
    }

    public void setStatusBarIcon(int i) {
        this.mStatusBarIcon = i;
    }

    public void setVibratePattern(long[] jArr) {
        this.mVibratePattern = jArr;
    }
}
