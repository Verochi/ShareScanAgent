package com.igexin.assist.control.vivo;

/* loaded from: classes22.dex */
public class ManufacturePushManager implements com.igexin.assist.control.AbstractPushManager {
    public static final java.lang.String PLUGIN_VERSION = "3.1.0";
    public static final java.lang.String TAG = "Assist_VV";
    private static final java.lang.String VIVO_VERSION = "sdk_version_vivo";
    private android.content.Context context;
    private java.lang.String mSdkSwitchPath;
    public static final java.lang.String VIVO = "Vivo".toLowerCase();
    private static final java.lang.String phoneBrand = android.os.Build.BRAND;

    /* renamed from: com.igexin.assist.control.vivo.ManufacturePushManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.vivo.push.IPushActionListener {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ boolean val$isForce;

        public AnonymousClass1(android.content.Context context, boolean z) {
            this.val$context = context;
            this.val$isForce = z;
        }

        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i) {
            "turnOnPush finish, state = ".concat(java.lang.String.valueOf(i));
            if (i == 0) {
                java.lang.String regId = com.vivo.push.PushClient.getInstance(this.val$context).getRegId();
                "turnOnPush token = ".concat(java.lang.String.valueOf(regId));
                if (this.val$context == null || android.text.TextUtils.isEmpty(regId)) {
                    return;
                }
                com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(this.val$context, "token", com.igexin.assist.sdk.AssistPushConsts.VIVO_PREFIX.concat(java.lang.String.valueOf(regId)));
                if (this.val$isForce) {
                    com.igexin.assist.control.vivo.ManufacturePushManager.this.addVivoMessageBeanExtra(messageBean);
                }
                com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
            }
        }
    }

    /* renamed from: com.igexin.assist.control.vivo.ManufacturePushManager$2, reason: invalid class name */
    public class AnonymousClass2 implements com.vivo.push.IPushActionListener {
        public AnonymousClass2() {
        }

        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i) {
            "turnOffPush finish, state = ".concat(java.lang.String.valueOf(i));
        }
    }

    public ManufacturePushManager(android.content.Context context) {
        try {
            this.context = context;
            new java.lang.StringBuilder("vivo plugin version = 3.1.0, vivo sdk version = ").append(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(VIVO_VERSION));
            this.mSdkSwitchPath = context.getFilesDir().getPath() + "/init.pid";
            com.vivo.push.PushClient.getInstance(context).initialize();
            com.vivo.push.PushClient.getInstance(context).checkManifest();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVivoMessageBeanExtra(com.igexin.assist.MessageBean messageBean) {
        try {
            java.lang.reflect.Field declaredField = com.igexin.assist.MessageBean.class.getDeclaredField("extra");
            declaredField.setAccessible(true);
            ((android.os.Bundle) declaredField.get(messageBean)).putBoolean("isForce", true);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean isSdkInit() {
        if (this.mSdkSwitchPath != null) {
            return new java.io.File(this.mSdkSwitchPath).exists();
        }
        return false;
    }

    private void turnOnPush(android.content.Context context, boolean z) {
        try {
            com.vivo.push.PushClient.getInstance(context).turnOnPush(new com.igexin.assist.control.vivo.ManufacturePushManager.AnonymousClass1(context, z));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getBrandCode() {
        return "6";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public java.lang.String getToken(android.content.Context context) {
        return com.vivo.push.PushClient.getInstance(context).getRegId();
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        try {
            if (!android.text.TextUtils.equals(VIVO, phoneBrand.toLowerCase())) {
                return false;
            }
            boolean isSupport = com.vivo.push.PushClient.getInstance(this.context).isSupport();
            "the vivo system push support = ".concat(java.lang.String.valueOf(isSupport));
            return isSupport;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(android.content.Context context) {
        try {
            new java.lang.StringBuilder("Register vivo push, pkg = ").append(context.getPackageName());
            if (!com.igexin.sdk.PushManager.getInstance().isPushTurnedOn(context) && isSdkInit()) {
                return;
            }
            if (isSupport()) {
                turnOnPush(context, false);
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
        try {
            com.vivo.push.PushClient.getInstance(context).turnOffPush(new com.igexin.assist.control.vivo.ManufacturePushManager.AnonymousClass2());
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(android.content.Context context) {
        turnOnPush(context, true);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(android.content.Context context) {
        try {
            turnOffPush(context);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
