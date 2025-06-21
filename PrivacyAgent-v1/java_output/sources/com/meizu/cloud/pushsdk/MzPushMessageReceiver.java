package com.meizu.cloud.pushsdk;

/* loaded from: classes23.dex */
public abstract class MzPushMessageReceiver extends android.content.BroadcastReceiver {
    private static final java.lang.String TAG = "MzPushMessageReceiver";
    private static boolean bInitLog;

    /* renamed from: com.meizu.cloud.pushsdk.MzPushMessageReceiver$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ android.content.Intent b;

        public AnonymousClass1(android.content.Context context, android.content.Intent intent) {
            this.a = context;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!com.meizu.cloud.pushsdk.MzPushMessageReceiver.bInitLog) {
                boolean unused = com.meizu.cloud.pushsdk.MzPushMessageReceiver.bInitLog = true;
                com.meizu.cloud.pushinternal.DebugLogger.init(this.a);
            }
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onHandleIntent(this.a, this.b);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.MzPushMessageReceiver$2, reason: invalid class name */
    public class AnonymousClass2 extends com.meizu.cloud.pushsdk.handler.a {
        public AnonymousClass2() {
        }

        @Override // com.meizu.cloud.pushsdk.handler.a
        public void a(android.content.Context context, android.content.Intent intent) {
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "onMessage Flyme3 " + intent);
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onMessage(context, intent);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "onNotificationClicked title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onNotificationClicked(context, mzPushMessage);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus) {
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "onPushStatus " + pushSwitchStatus);
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onPushStatus(context, pushSwitchStatus);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus) {
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "onRegisterStatus " + registerStatus);
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onRegisterStatus(context, registerStatus);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus) {
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "onSubAliasStatus " + subAliasStatus);
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onSubAliasStatus(context, subAliasStatus);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus) {
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "onSubTagsStatus " + subTagsStatus);
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onSubTagsStatus(context, subTagsStatus);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus) {
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "onUnRegisterStatus " + unRegisterStatus);
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onUnRegisterStatus(context, unRegisterStatus);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, java.lang.String str) {
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "onRegister " + str);
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onRegister(context, str);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onMessage(context, str, str2);
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "receive message " + str + " platformExtra " + str2);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(android.content.Context context, boolean z) {
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "onUnRegister " + z);
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onUnRegister(context, z);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onUpdateNotificationBuilder(pushNotificationBuilder);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void b(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "onNotificationArrived title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onNotificationArrived(context, mzPushMessage);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void b(android.content.Context context, java.lang.String str) {
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onMessage(context, str);
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "receive message " + str);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void c(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "onNotificationDeleted title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onNotificationDeleted(context, mzPushMessage);
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void c(android.content.Context context, java.lang.String str) {
            com.meizu.cloud.pushinternal.DebugLogger.i(com.meizu.cloud.pushsdk.MzPushMessageReceiver.TAG, "onNotifyMessageArrived " + str);
            com.meizu.cloud.pushsdk.MzPushMessageReceiver.this.onNotifyMessageArrived(context, str);
        }
    }

    private com.meizu.cloud.pushsdk.handler.a getAbstractAppLogicListener() {
        return new com.meizu.cloud.pushsdk.MzPushMessageReceiver.AnonymousClass2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHandleIntent(android.content.Context context, android.content.Intent intent) {
        com.meizu.cloud.pushsdk.b.a(context).a(TAG, getAbstractAppLogicListener()).a(intent);
    }

    public void onMessage(android.content.Context context, android.content.Intent intent) {
    }

    public void onMessage(android.content.Context context, java.lang.String str) {
    }

    public void onMessage(android.content.Context context, java.lang.String str, java.lang.String str2) {
    }

    public void onNotificationArrived(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
    }

    public void onNotificationClicked(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
    }

    public void onNotificationDeleted(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage) {
    }

    public void onNotifyMessageArrived(android.content.Context context, java.lang.String str) {
    }

    public abstract void onPushStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus);

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.meizu.cloud.pushsdk.b.c.b.a().execute(new com.meizu.cloud.pushsdk.MzPushMessageReceiver.AnonymousClass1(context.getApplicationContext(), intent));
    }

    @java.lang.Deprecated
    public void onRegister(android.content.Context context, java.lang.String str) {
    }

    public abstract void onRegisterStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus);

    public abstract void onSubAliasStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus);

    public abstract void onSubTagsStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus);

    @java.lang.Deprecated
    public void onUnRegister(android.content.Context context, boolean z) {
    }

    public abstract void onUnRegisterStatus(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus);

    public void onUpdateNotificationBuilder(com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
        pushNotificationBuilder.setStatusBarIcon(com.meizu.cloud.pushinternal.R.drawable.stat_sys_third_app_notify);
    }
}
