package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public abstract class PushMessageReceiver extends android.content.BroadcastReceiver {
    public void onCommandResult(android.content.Context context, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
    }

    public void onNotificationMessageArrived(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
    }

    public void onNotificationMessageClicked(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        if (intent != null) {
            com.xiaomi.channel.commonutils.logger.b.f("[CRcv] receive a msg broadcast: " + intent.getAction());
        }
        com.xiaomi.mipush.sdk.MessageHandleService.addJob(context.getApplicationContext(), new com.xiaomi.mipush.sdk.MessageHandleService.a(intent, this));
        try {
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (intExtra == 2000) {
                com.xiaomi.push.dp.a(context.getApplicationContext()).a(context.getPackageName(), intent, 2003);
            } else if (intExtra == 6000) {
                com.xiaomi.push.dp.a(context.getApplicationContext()).a(context.getPackageName(), intent, com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED);
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error in PushMessageReceiver. ".concat(java.lang.String.valueOf(e)));
        }
    }

    @java.lang.Deprecated
    public void onReceiveMessage(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
    }

    public void onReceivePassThroughMessage(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
    }

    public void onReceiveRegisterResult(android.content.Context context, com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage) {
    }

    public void onRequirePermissions(android.content.Context context, java.lang.String[] strArr) {
    }
}
