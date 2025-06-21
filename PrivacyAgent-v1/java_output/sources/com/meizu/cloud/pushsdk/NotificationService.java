package com.meizu.cloud.pushsdk;

/* loaded from: classes23.dex */
public class NotificationService extends android.app.IntentService {
    public NotificationService() {
        super("NotificationService");
    }

    public NotificationService(java.lang.String str) {
        super(str);
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        android.content.Intent intent = new android.content.Intent(str2);
        intent.setPackage(str);
        java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            return null;
        }
        return queryBroadcastReceivers.get(0).activityInfo.name;
    }

    public void a(android.content.Intent intent) {
        java.lang.String a = a(getPackageName(), intent.getAction());
        if (android.text.TextUtils.isEmpty(a)) {
            com.meizu.cloud.pushsdk.util.d.a(this, intent, "reflectReceiver sendbroadcast", 2005);
            com.meizu.cloud.pushinternal.DebugLogger.i("NotificationService", " reflectReceiver error: receiver for: " + intent.getAction() + " not found, package: " + getPackageName());
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
            return;
        }
        try {
            com.meizu.cloud.pushsdk.util.d.a(this, intent, "reflectReceiver startservice", 2003);
            intent.setClassName(getPackageName(), a);
            com.meizu.cloud.pushsdk.b.b.d a2 = com.meizu.cloud.pushsdk.b.b.a.a(a).a((java.lang.Class<?>[]) null).a(null);
            if (!a2.a || a2.b == 0) {
                return;
            }
            com.meizu.cloud.pushinternal.DebugLogger.i("NotificationService", "Reflect MzPushReceiver true");
            com.meizu.cloud.pushsdk.b.b.a.a(a2.b).a("onReceive", android.content.Context.class, android.content.Intent.class).a(a2.b, getApplicationContext(), intent);
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.i("NotificationService", "reflect e: " + e);
            com.meizu.cloud.pushsdk.util.d.a(this, intent, e.getMessage(), 2004);
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        com.meizu.cloud.pushinternal.DebugLogger.i("NotificationService", "NotificationService destroy");
        super.onDestroy();
    }

    @Override // android.app.IntentService
    public void onHandleIntent(android.content.Intent intent) {
        boolean z;
        android.os.Process.setThreadPriority(10);
        if (intent == null) {
            return;
        }
        try {
            com.meizu.cloud.pushinternal.DebugLogger.i("NotificationService", "onHandleIntent action " + intent.getAction());
            intent.getStringExtra("method");
            java.lang.String stringExtra = intent.getStringExtra("command_type");
            if (!com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && !com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_REGISTER_ACTION.equals(intent.getAction()) && !com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION.equals(intent.getAction())) {
                z = false;
                com.meizu.cloud.pushinternal.DebugLogger.d("NotificationService", "-- command_type -- " + stringExtra + " legalAction " + z);
                if (android.text.TextUtils.isEmpty(stringExtra) && "reflect_receiver".equals(stringExtra) && z) {
                    java.lang.String stringExtra2 = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_CONTROL_MESSAGE);
                    com.meizu.cloud.pushinternal.DebugLogger.i("NotificationService", "control message is " + stringExtra2);
                    if (!android.text.TextUtils.isEmpty(stringExtra2)) {
                        com.meizu.cloud.pushsdk.d.a.a(this, new com.meizu.cloud.pushsdk.handler.a.c.b(stringExtra2, null, null).b().c());
                    }
                    a(intent);
                    return;
                }
                return;
            }
            z = true;
            com.meizu.cloud.pushinternal.DebugLogger.d("NotificationService", "-- command_type -- " + stringExtra + " legalAction " + z);
            if (android.text.TextUtils.isEmpty(stringExtra)) {
            }
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("NotificationService", "onHandleIntent error " + e.getMessage());
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(android.content.Intent intent) {
        return super.onUnbind(intent);
    }
}
