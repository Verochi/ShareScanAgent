package com.igexin.assist.control.oppo;

/* loaded from: classes22.dex */
public class ManufacturePushManager implements com.heytap.msp.push.callback.ICallBackResultService, com.igexin.assist.control.AbstractPushManager {
    public static final java.lang.String PLUGIN_VERSION = "3.1.0";
    public static final java.lang.String TAG = "Assist_OP";
    private java.lang.String appKey;
    private java.lang.String appSecret;
    private android.content.Context context;

    public ManufacturePushManager(android.content.Context context) {
        this.appKey = "";
        this.appSecret = "";
        try {
            this.context = context;
            new java.lang.StringBuilder("oppo plugin version = 3.1.0, oppo sdk version = ").append(com.heytap.msp.push.HeytapPushManager.getSDKVersionName());
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            java.lang.String str = (java.lang.String) applicationInfo.metaData.get(com.igexin.assist.sdk.AssistPushConsts.OPPOPUSH_APPKEY);
            this.appKey = str;
            this.appKey = str.replace(com.igexin.assist.sdk.AssistPushConsts.OPPO_PREFIX, "");
            java.lang.String str2 = (java.lang.String) applicationInfo.metaData.get(com.igexin.assist.sdk.AssistPushConsts.OPPOPUSH_APPSECRET);
            this.appSecret = str2;
            this.appSecret = str2.replace(com.igexin.assist.sdk.AssistPushConsts.OPPO_PREFIX, "");
            createNotificationChannel(context);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static boolean checkOppoDevice(android.content.Context context) {
        try {
            com.heytap.msp.push.HeytapPushManager.init(context, false);
            return com.heytap.msp.push.HeytapPushManager.isSupportPush(context);
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    private void createNotificationChannel(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return;
        }
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
        java.lang.Class<?> cls = java.lang.Class.forName("android.app.NotificationChannel");
        java.lang.reflect.Constructor<?> constructor = cls.getConstructor(java.lang.String.class, java.lang.CharSequence.class, java.lang.Integer.TYPE);
        if (constructor == null || ((android.os.Parcelable) android.app.NotificationManager.class.getMethod("getNotificationChannel", java.lang.String.class).invoke(notificationManager, "Default")) != null) {
            return;
        }
        android.app.NotificationManager.class.getMethod("createNotificationChannel", cls).invoke(notificationManager, (android.os.Parcelable) constructor.newInstance("Default", "Default", 3));
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getBrandCode() {
        return "4";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getToken(android.content.Context context) {
        return com.heytap.msp.push.HeytapPushManager.getRegisterID();
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        android.content.Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            com.heytap.msp.push.HeytapPushManager.init(context, false);
            boolean isSupportPush = com.heytap.msp.push.HeytapPushManager.isSupportPush(this.context);
            "is oppo:".concat(java.lang.String.valueOf(isSupportPush));
            return isSupportPush;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onError(int i, java.lang.String str) {
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onGetNotificationStatus(int i, int i2) {
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onGetPushStatus(int i, int i2) {
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onRegister(int i, java.lang.String str) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("onToken :");
            sb.append(str);
            sb.append(", code = ");
            sb.append(i);
            if (this.context == null || i != 0 || android.text.TextUtils.isEmpty(str) || str.equalsIgnoreCase("InvalidAppKey")) {
                return;
            }
            com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(this.context, "token", com.igexin.assist.sdk.AssistPushConsts.OPPO_PREFIX.concat(str)));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onSetPushTime(int i, java.lang.String str) {
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onUnRegister(int i) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(android.content.Context context) {
        try {
            this.context = context;
            if (!android.text.TextUtils.isEmpty(this.appKey) && !android.text.TextUtils.isEmpty(this.appSecret)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("Register oppo push, pkg = ");
                sb.append(context.getPackageName());
                sb.append(", appKey = ");
                sb.append(this.appKey);
                sb.append(", appSecret = ");
                sb.append(this.appSecret);
                if (isSupport()) {
                    com.heytap.msp.push.HeytapPushManager.register(context, this.appKey, this.appSecret, this);
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
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("oppo push setAcceptTime");
        sb2.append(i3);
        sb2.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        sb2.append(i);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i4 = 0; i4 < 7; i4++) {
            arrayList.add(java.lang.Integer.valueOf(i4));
        }
        com.heytap.msp.push.HeytapPushManager.setPushTime(arrayList, i3, 0, i, 0);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(android.content.Context context) {
        try {
            com.heytap.msp.push.HeytapPushManager.pausePush();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(android.content.Context context) {
        try {
            com.heytap.msp.push.HeytapPushManager.resumePush();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(android.content.Context context) {
        try {
            com.heytap.msp.push.HeytapPushManager.unRegister();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
