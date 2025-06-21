package com.igexin.assist.control.meizu;

/* loaded from: classes22.dex */
public class ManufacturePushManager implements com.igexin.assist.control.AbstractPushManager {
    public static final java.lang.String PLUGIN_VERSION = "3.2.0";
    public static final java.lang.String TAG = "Assist_MZ";
    private java.lang.String appId;
    private java.lang.String appKey;
    private android.content.Context context;

    public ManufacturePushManager(android.content.Context context) {
        this.appId = "";
        this.appKey = "";
        java.lang.String str = com.meizu.cloud.pushsdk.PushManager.TAG;
        try {
            try {
                for (java.lang.reflect.Field field : com.meizu.cloud.pushsdk.PushManager.class.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isFinal(field.getModifiers()) && "TAG".equals(field.getName())) {
                        str = (java.lang.String) field.get(null);
                    }
                }
            } catch (java.lang.Exception unused) {
            }
            "meizu plugin version = 3.2.0, meizu sdk version = ".concat(java.lang.String.valueOf(str));
            this.context = context;
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            java.lang.String str2 = (java.lang.String) applicationInfo.metaData.get(com.igexin.assist.sdk.AssistPushConsts.MEIZUPUSH_APPID);
            this.appId = str2;
            this.appId = str2.replace(com.igexin.assist.sdk.AssistPushConsts.MZ_PREFIX, "");
            java.lang.String str3 = (java.lang.String) applicationInfo.metaData.get(com.igexin.assist.sdk.AssistPushConsts.MEIZUPUSH_APPKEY);
            this.appKey = str3;
            this.appKey = str3.replace(com.igexin.assist.sdk.AssistPushConsts.MZ_PREFIX, "");
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private static boolean isBrandMeizu() {
        boolean z;
        try {
            java.lang.String a = com.igexin.assist.control.meizu.i.a("ro.meizu.product.model");
            "brand = ".concat(java.lang.String.valueOf(a));
            if (android.text.TextUtils.isEmpty(a)) {
                java.lang.String str = android.os.Build.BRAND;
                if (!com.igexin.assist.util.AssistUtils.BRAND_MZ.equalsIgnoreCase(str) && !"22c4185e".equalsIgnoreCase(str)) {
                    z = false;
                    "is mz:".concat(java.lang.String.valueOf(z));
                    return z;
                }
            }
            z = true;
            "is mz:".concat(java.lang.String.valueOf(z));
            return z;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getBrandCode() {
        return "4";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getToken(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return com.meizu.cloud.pushsdk.PushManager.getPushId(context);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        try {
            return isBrandMeizu();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(android.content.Context context) {
        try {
            if (!android.text.TextUtils.isEmpty(this.appId) && !android.text.TextUtils.isEmpty(this.appKey) && context != null) {
                new java.lang.StringBuilder("Register meizupush, pkg = ").append(context.getPackageName());
                if (isSupport()) {
                    com.meizu.cloud.pushsdk.PushManager.register(context, this.appId, this.appKey);
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(android.content.Context context, int i, int i2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(android.content.Context context) {
        if (context == null) {
            return;
        }
        java.lang.String pushId = com.meizu.cloud.pushsdk.PushManager.getPushId(context);
        if (android.text.TextUtils.isEmpty(this.appId) || android.text.TextUtils.isEmpty(this.appKey) || android.text.TextUtils.isEmpty(pushId)) {
            return;
        }
        com.meizu.cloud.pushsdk.PushManager.switchPush(context, this.appId, this.appKey, pushId, false);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(android.content.Context context) {
        if (context == null) {
            return;
        }
        java.lang.String pushId = com.meizu.cloud.pushsdk.PushManager.getPushId(context);
        if (android.text.TextUtils.isEmpty(this.appId) || android.text.TextUtils.isEmpty(this.appKey) || android.text.TextUtils.isEmpty(pushId)) {
            return;
        }
        com.meizu.cloud.pushsdk.PushManager.switchPush(context, this.appId, this.appKey, pushId, true);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(android.content.Context context) {
        try {
            if (!android.text.TextUtils.isEmpty(this.appId) && !android.text.TextUtils.isEmpty(this.appKey)) {
                com.meizu.cloud.pushsdk.PushManager.unRegister(context, this.appId, this.appKey);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
