package com.igexin.assist.control.honor;

/* loaded from: classes22.dex */
public class ManufacturePushManager implements com.igexin.assist.control.AbstractPushManager {
    public static final java.lang.String PLUGIN_VERSION = "3.2.0";
    public static final java.lang.String TAG = "Assist_Honor";
    private android.content.Context context;
    private final java.lang.Object object = new java.lang.Object();
    private java.lang.String token = "";

    /* renamed from: com.igexin.assist.control.honor.ManufacturePushManager$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        public AnonymousClass1() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                com.igexin.assist.control.honor.ManufacturePushManager manufacturePushManager = com.igexin.assist.control.honor.ManufacturePushManager.this;
                manufacturePushManager.token = com.hihonor.push.sdk.HonorInstanceId.getInstance(manufacturePushManager.context).getPushToken();
                new java.lang.StringBuilder("get honor token:").append(com.igexin.assist.control.honor.ManufacturePushManager.this.token);
                if (android.text.TextUtils.isEmpty(com.igexin.assist.control.honor.ManufacturePushManager.this.token)) {
                    return;
                }
                com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(com.igexin.assist.control.honor.ManufacturePushManager.this.context, "token", com.igexin.assist.sdk.AssistPushConsts.HONOR_PREFIX + com.igexin.assist.control.honor.ManufacturePushManager.this.token));
            } catch (java.lang.Throwable th) {
                new java.lang.StringBuilder("get honor token failed:").append(th.getMessage());
            }
        }
    }

    /* renamed from: com.igexin.assist.control.honor.ManufacturePushManager$2, reason: invalid class name */
    public class AnonymousClass2 extends java.lang.Thread {
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass2(android.content.Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                com.hihonor.push.sdk.HonorInstanceId.getInstance(this.val$context).deletePushToken();
            } catch (java.lang.Throwable th) {
                "deleteToken failed.".concat(java.lang.String.valueOf(th));
            }
        }
    }

    /* renamed from: com.igexin.assist.control.honor.ManufacturePushManager$3, reason: invalid class name */
    public class AnonymousClass3 implements com.hihonor.push.sdk.tasks.OnCompleteListener<java.lang.Void> {
        public AnonymousClass3() {
        }

        @Override // com.hihonor.push.sdk.tasks.OnCompleteListener
        public void onComplete(com.hihonor.push.sdk.tasks.Task<java.lang.Void> task) {
            if (task.isSuccessful()) {
                return;
            }
            new java.lang.StringBuilder("turnOnPush failed: ret=").append(task.getException().getMessage());
        }
    }

    /* renamed from: com.igexin.assist.control.honor.ManufacturePushManager$4, reason: invalid class name */
    public class AnonymousClass4 implements com.hihonor.push.sdk.tasks.OnCompleteListener<java.lang.Void> {
        public AnonymousClass4() {
        }

        @Override // com.hihonor.push.sdk.tasks.OnCompleteListener
        public void onComplete(com.hihonor.push.sdk.tasks.Task<java.lang.Void> task) {
            if (task.isSuccessful()) {
                return;
            }
            new java.lang.StringBuilder("turnOffPush failed: ret=").append(task.getException().getMessage());
        }
    }

    public ManufacturePushManager(android.content.Context context) {
        try {
            this.context = context;
            "honor plugin version = 3.2.0, honor sdk version = ".concat(java.lang.String.valueOf((java.lang.String) context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("com.hihonor.push.sdk_version")));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getBrandCode() {
        return "7";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getToken(android.content.Context context) {
        return this.token;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        int i;
        try {
            i = com.hihonor.push.sdk.ipc.HonorApiAvailability.isHonorMobileServicesAvailable(this.context);
        } catch (java.lang.Throwable th) {
            "honor check support failed.".concat(java.lang.String.valueOf(th));
            i = -1;
        }
        return i == 0;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(android.content.Context context) {
        new java.lang.StringBuilder("Register honorpush, pkg = ").append(this.context.getPackageName());
        if (isSupport()) {
            new com.igexin.assist.control.honor.ManufacturePushManager.AnonymousClass1().start();
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(android.content.Context context, int i, int i2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(android.content.Context context) {
        com.hihonor.push.sdk.HonorMessaging.getInstance(context).turnOffPush().addOnCompleteListener(new com.igexin.assist.control.honor.ManufacturePushManager.AnonymousClass4());
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(android.content.Context context) {
        com.hihonor.push.sdk.HonorMessaging.getInstance(context).turnOnPush().addOnCompleteListener(new com.igexin.assist.control.honor.ManufacturePushManager.AnonymousClass3());
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(android.content.Context context) {
        new com.igexin.assist.control.honor.ManufacturePushManager.AnonymousClass2(context).start();
    }
}
