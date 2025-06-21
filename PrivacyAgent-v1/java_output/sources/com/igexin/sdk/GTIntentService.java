package com.igexin.sdk;

/* loaded from: classes23.dex */
public class GTIntentService extends android.app.Service {
    private static final int REMOTE_CLINET_RECEIVED = 2;
    private static final int REMOTE_MSG_RECEIVED = 1;
    public static final java.lang.String TAG = "intentSer";
    private final android.os.Messenger client = new android.os.Messenger(new com.igexin.sdk.GTIntentService.a(this));

    public static final class a extends android.os.Handler {
        java.lang.ref.WeakReference<com.igexin.sdk.GTIntentService> a;

        public a(com.igexin.sdk.GTIntentService gTIntentService) {
            super(android.os.Looper.getMainLooper());
            this.a = new java.lang.ref.WeakReference<>(gTIntentService);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            if (message == null) {
                return;
            }
            java.lang.ref.WeakReference<com.igexin.sdk.GTIntentService> weakReference = this.a;
            if (weakReference == null || weakReference.get() == null) {
                com.igexin.c.a.c.a.e.a(com.igexin.sdk.GTIntentService.TAG, "intent service is null");
                com.igexin.c.a.c.a.c.a().a("intent service is null");
                return;
            }
            com.igexin.sdk.GTIntentService gTIntentService = this.a.get();
            if (message.what == 1) {
                java.lang.Object obj = message.obj;
                if (obj instanceof android.content.Intent) {
                    gTIntentService.processOnHandleIntent(gTIntentService, (android.content.Intent) obj);
                } else {
                    com.igexin.c.a.c.a.e.a(com.igexin.sdk.GTIntentService.TAG, "receive bad msg");
                }
            }
            super.handleMessage(message);
        }
    }

    public void areNotificationsEnabled(android.content.Context context, boolean z) {
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return this.client.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            com.getui.gtc.base.GtcProvider.setContext(getApplicationContext());
        } catch (java.lang.Throwable unused) {
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    public void onNotificationMessageArrived(android.content.Context context, com.igexin.sdk.message.GTNotificationMessage gTNotificationMessage) {
    }

    public void onNotificationMessageClicked(android.content.Context context, com.igexin.sdk.message.GTNotificationMessage gTNotificationMessage) {
    }

    public void onPopupMessageClicked(android.content.Context context, com.igexin.sdk.message.GTPopupMessage gTPopupMessage) {
    }

    public void onPopupMessageShow(android.content.Context context, com.igexin.sdk.message.GTPopupMessage gTPopupMessage) {
    }

    public void onReceiveClientId(android.content.Context context, java.lang.String str) {
    }

    public void onReceiveCommandResult(android.content.Context context, com.igexin.sdk.message.GTCmdMessage gTCmdMessage) {
    }

    public void onReceiveDeviceToken(android.content.Context context, java.lang.String str) {
    }

    public void onReceiveMessageData(android.content.Context context, com.igexin.sdk.message.GTTransmitMessage gTTransmitMessage) {
    }

    public void onReceiveOnlineState(android.content.Context context, boolean z) {
    }

    public void onReceiveServicePid(android.content.Context context, int i) {
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        processOnHandleIntent(this, intent);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(android.content.Intent intent) {
        com.igexin.c.a.c.a.b(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    public void processOnHandleIntent(android.content.Context context, android.content.Intent intent) {
        if (intent == null || context == null) {
            com.igexin.c.a.c.a.e.a(TAG, "onHandleIntent() context or intent is null");
            return;
        }
        try {
            android.os.Bundle extras = intent.getExtras();
            if (extras != null && extras.get("action") != null && (extras.get("action") instanceof java.lang.Integer)) {
                int i = extras.getInt("action");
                com.igexin.c.a.c.a.b(TAG, "onHandleIntent() action = ".concat(java.lang.String.valueOf(i)));
                android.content.Context applicationContext = context.getApplicationContext();
                if (i == 10001) {
                    onReceiveMessageData(applicationContext, (com.igexin.sdk.message.GTTransmitMessage) intent.getSerializableExtra(com.igexin.sdk.PushConsts.KEY_MESSAGE_DATA));
                    com.igexin.c.a.c.a.c.a().a("onHandleIntent() = received msg data ");
                    return;
                }
                if (i == 10002) {
                    onReceiveClientId(applicationContext, extras.getString(com.igexin.sdk.PushConsts.KEY_CLIENT_ID));
                    com.igexin.c.a.c.a.c.a().a("onHandleIntent() = received client id ");
                    return;
                }
                if (i == 10007) {
                    onReceiveOnlineState(applicationContext, extras.getBoolean(com.igexin.sdk.PushConsts.KEY_ONLINE_STATE));
                    return;
                }
                if (i == 10008) {
                    onReceiveServicePid(applicationContext, extras.getInt("pid"));
                    com.igexin.c.a.c.a.c.a().a("onHandleIntent() = get sdk service pid ");
                    return;
                }
                switch (i) {
                    case 10010:
                        onReceiveCommandResult(applicationContext, (com.igexin.sdk.message.GTCmdMessage) intent.getSerializableExtra(com.igexin.sdk.PushConsts.KEY_CMD_MSG));
                        com.igexin.c.a.c.a.c.a().a("onHandleIntent() = " + intent.getSerializableExtra(com.igexin.sdk.PushConsts.KEY_CMD_MSG).getClass().getSimpleName());
                        break;
                    case 10011:
                        onNotificationMessageArrived(applicationContext, (com.igexin.sdk.message.GTNotificationMessage) intent.getSerializableExtra("notification_arrived"));
                        com.igexin.c.a.c.a.c.a().a("onHandleIntent() = notification arrived ");
                        break;
                    case 10012:
                        onNotificationMessageClicked(applicationContext, (com.igexin.sdk.message.GTNotificationMessage) intent.getSerializableExtra(com.igexin.sdk.PushConsts.KEY_NOTIFICATION_CLICKED));
                        com.igexin.c.a.c.a.c.a().a("onHandleIntent() notification clicked ");
                        break;
                    case 10013:
                        onReceiveDeviceToken(applicationContext, extras.getString(com.igexin.sdk.PushConsts.KEY_DEVICE_TOKEN));
                        com.igexin.c.a.c.a.c.a().a("onHandleIntent() = received device token ");
                        break;
                    case com.igexin.sdk.PushConsts.ACTION_NOTIFICATION_ENABLE /* 10014 */:
                        areNotificationsEnabled(applicationContext, com.igexin.push.h.c.b(applicationContext));
                        com.igexin.c.a.c.a.c.a().a("onHandleIntent() areNotificationsEnabled");
                        break;
                    case com.igexin.sdk.PushConsts.ACTION_POPUP_SHOW /* 10015 */:
                        onPopupMessageShow(applicationContext, (com.igexin.sdk.message.GTPopupMessage) extras.getSerializable(com.igexin.sdk.PushConsts.KEY_POPUP_SHOW));
                        com.igexin.c.a.c.a.c.a().a("onHandleIntent() onPopupMessageShow");
                        break;
                    case com.igexin.sdk.PushConsts.ACTION_POPUP_CLICKED /* 10016 */:
                        onPopupMessageClicked(applicationContext, (com.igexin.sdk.message.GTPopupMessage) extras.getSerializable(com.igexin.sdk.PushConsts.KEY_POPUP_CLICKED));
                        com.igexin.c.a.c.a.c.a().a("onHandleIntent() onPopupMessageClicked");
                        break;
                }
                return;
            }
            com.igexin.c.a.c.a.b(TAG, "onHandleIntent, receive intent error");
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }
}
