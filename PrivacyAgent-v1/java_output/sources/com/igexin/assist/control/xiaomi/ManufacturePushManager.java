package com.igexin.assist.control.xiaomi;

/* loaded from: classes22.dex */
public class ManufacturePushManager implements com.igexin.assist.control.AbstractPushManager {
    private static final java.lang.String PACKAGE_XIAOMI = "com.xiaomi.xmsf";
    public static final java.lang.String PLUGIN_VERSION = "3.1.0";
    public static final java.lang.String TAG = "Assist_XM";
    public static final java.lang.String XIAOMI_VERSION = "4.9.0";
    private java.lang.String appId;
    private java.lang.String appKey;
    private android.content.Context context;

    public ManufacturePushManager(android.content.Context context) {
        this.appId = "";
        this.appKey = "";
        try {
            this.context = context;
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            java.lang.String str = (java.lang.String) applicationInfo.metaData.get(com.igexin.assist.sdk.AssistPushConsts.MIPUSH_APPID);
            this.appId = str;
            this.appId = str.replace(com.igexin.assist.sdk.AssistPushConsts.XM_PREFIX, "");
            java.lang.String str2 = (java.lang.String) applicationInfo.metaData.get(com.igexin.assist.sdk.AssistPushConsts.MIPUSH_APPKEY);
            this.appKey = str2;
            this.appKey = str2.replace(com.igexin.assist.sdk.AssistPushConsts.XM_PREFIX, "");
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getBrandCode() {
        return "3";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getToken(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return com.xiaomi.mipush.sdk.MiPushClient.getRegId(context);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        android.content.pm.PackageInfo packageInfo;
        try {
            if (!com.igexin.assist.control.xiaomi.XmSystemUtils.isBrandXiaoMi() || (packageInfo = this.context.getPackageManager().getPackageInfo(PACKAGE_XIAOMI, 0)) == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (java.lang.Throwable th) {
            new java.lang.StringBuilder("support error is : ").append(th.toString());
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(android.content.Context context) {
        try {
            if (!android.text.TextUtils.isEmpty(this.appId) && !android.text.TextUtils.isEmpty(this.appKey) && context != null) {
                new java.lang.StringBuilder("Register mipush, pkg = ").append(context.getPackageName());
                if (isSupport()) {
                    com.xiaomi.mipush.sdk.MiPushClient.registerPush(context, this.appId, this.appKey);
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(android.content.Context context, int i, int i2) {
        if (i2 == 0) {
            turnOnPush(context);
            return;
        }
        int i3 = (i + i2) % 24;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("getui setSilentTime");
        sb.append(i);
        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        sb.append(i2);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("mipush setAcceptTime");
        sb2.append(i3);
        sb2.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        sb2.append(i);
        com.xiaomi.mipush.sdk.MiPushClient.setAcceptTime(context, i3, 0, i, 0, null);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(android.content.Context context) {
        if (context == null) {
            return;
        }
        com.xiaomi.mipush.sdk.MiPushClient.pausePush(context, this.appId);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(android.content.Context context) {
        if (context == null) {
            return;
        }
        com.xiaomi.mipush.sdk.MiPushClient.resumePush(context, this.appId);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(android.content.Context context) {
        if (context == null) {
            return;
        }
        try {
            com.xiaomi.mipush.sdk.MiPushClient.unregisterPush(context);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
