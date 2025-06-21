package com.igexin.assist.control.huawei;

/* loaded from: classes22.dex */
public class ManufacturePushManager implements com.igexin.assist.control.AbstractPushManager {
    private static final java.lang.String PACKAGE_HUAWEI = "com.huawei.hwid";
    public static final java.lang.String PLUGIN_VERSION = "3.1.0";
    public static final java.lang.String TAG = "Assist_HW";
    private java.lang.String appId;
    private android.content.Context context;
    private final java.lang.Object object = new java.lang.Object();
    private java.lang.String token = "";
    public static final java.lang.String HUAWEI = "Huawei".toLowerCase();
    public static final java.lang.String HONOR = com.igexin.assist.util.AssistUtils.BRAND_HON.toLowerCase();

    /* renamed from: com.igexin.assist.control.huawei.ManufacturePushManager$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass1(android.content.Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                synchronized (com.igexin.assist.control.huawei.ManufacturePushManager.this.object) {
                    if (android.text.TextUtils.isEmpty(com.igexin.assist.control.huawei.ManufacturePushManager.this.appId)) {
                        com.igexin.assist.control.huawei.ManufacturePushManager.this.appId = com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(this.val$context).getString("client/app_id");
                    }
                }
                com.igexin.assist.control.huawei.ManufacturePushManager.this.token = com.huawei.hms.aaid.HmsInstanceId.getInstance(this.val$context).getToken(com.igexin.assist.control.huawei.ManufacturePushManager.this.appId, com.huawei.hms.push.HmsMessaging.DEFAULT_TOKEN_SCOPE);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("get hms token:");
                sb.append(com.igexin.assist.control.huawei.ManufacturePushManager.this.token);
                if (android.text.TextUtils.isEmpty(com.igexin.assist.control.huawei.ManufacturePushManager.this.token)) {
                    return;
                }
                com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(this.val$context, "token", com.igexin.assist.sdk.AssistPushConsts.HW_PREFIX + com.igexin.assist.control.huawei.ManufacturePushManager.this.token));
            } catch (java.lang.Throwable th) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("get hms token failed:");
                sb2.append(th.getMessage());
            }
        }
    }

    /* renamed from: com.igexin.assist.control.huawei.ManufacturePushManager$2, reason: invalid class name */
    public class AnonymousClass2 extends java.lang.Thread {
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass2(android.content.Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                com.huawei.hms.aaid.HmsInstanceId.getInstance(this.val$context).deleteToken(com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(this.val$context).getString("client/app_id"), com.huawei.hms.push.HmsMessaging.DEFAULT_TOKEN_SCOPE);
            } catch (java.lang.Throwable th) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("deleteToken failed.");
                sb.append(th);
            }
        }
    }

    /* renamed from: com.igexin.assist.control.huawei.ManufacturePushManager$3, reason: invalid class name */
    public class AnonymousClass3 implements com.huawei.hmf.tasks.OnCompleteListener<java.lang.Void> {
        public AnonymousClass3() {
        }

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(com.huawei.hmf.tasks.Task<java.lang.Void> task) {
            if (task.isSuccessful()) {
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("turnOnPush failed: ret=");
            sb.append(task.getException().getMessage());
        }
    }

    /* renamed from: com.igexin.assist.control.huawei.ManufacturePushManager$4, reason: invalid class name */
    public class AnonymousClass4 implements com.huawei.hmf.tasks.OnCompleteListener<java.lang.Void> {
        public AnonymousClass4() {
        }

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(com.huawei.hmf.tasks.Task<java.lang.Void> task) {
            if (task.isSuccessful()) {
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("turnOffPush failed: ret=");
            sb.append(task.getException().getMessage());
        }
    }

    public ManufacturePushManager(android.content.Context context) {
        try {
            this.context = context;
            java.lang.String str = (java.lang.String) context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("com.huawei.hms.client.service.name:push");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("huawei plugin version = 3.1.0, huawei sdk version = ");
            sb.append(str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[1]);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getBrandCode() {
        return "2";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getToken(android.content.Context context) {
        return this.token;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        try {
            android.content.pm.PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            int parseInt = java.lang.Integer.parseInt((java.lang.String) cls.getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(cls, "ro.build.hw_emui_api_level"));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("pkgInfo.versionCode ");
            sb.append(packageInfo.versionCode);
            sb.append(" apiVersionCode = ");
            sb.append(parseInt);
            return packageInfo.versionCode >= 30000000 && parseInt > 9;
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("check hw device error = ");
            sb2.append(th);
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Register hmspush, pkg = ");
        sb.append(context.getPackageName());
        if (isSupport()) {
            new com.igexin.assist.control.huawei.ManufacturePushManager.AnonymousClass1(context).start();
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(android.content.Context context, int i, int i2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(android.content.Context context) {
        com.huawei.hms.push.HmsMessaging.getInstance(context).turnOffPush().addOnCompleteListener(new com.igexin.assist.control.huawei.ManufacturePushManager.AnonymousClass4());
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(android.content.Context context) {
        com.huawei.hms.push.HmsMessaging.getInstance(context).turnOnPush().addOnCompleteListener(new com.igexin.assist.control.huawei.ManufacturePushManager.AnonymousClass3());
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(android.content.Context context) {
        new com.igexin.assist.control.huawei.ManufacturePushManager.AnonymousClass2(context).start();
    }
}
