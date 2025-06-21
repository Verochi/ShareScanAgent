package com.xiaomi.push.service.receivers;

/* loaded from: classes19.dex */
public class NetworkStatusReceiver extends android.content.BroadcastReceiver {
    private static boolean a;
    private boolean b = true;

    public NetworkStatusReceiver() {
    }

    public NetworkStatusReceiver(java.lang.Object obj) {
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.content.Context context) {
        if (!com.xiaomi.mipush.sdk.ao.a(context).m119a() && com.xiaomi.mipush.sdk.b.m126a(context).m135c() && !com.xiaomi.mipush.sdk.b.m126a(context).m138f()) {
            try {
                android.content.Intent intent = new android.content.Intent();
                intent.setComponent(new android.content.ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                com.xiaomi.push.service.a.a(context).a(intent);
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        com.xiaomi.push.gc.a(context);
        if (com.xiaomi.push.ai.a(context) && com.xiaomi.mipush.sdk.ao.a(context).m122b()) {
            com.xiaomi.mipush.sdk.ao.a(context).m123c();
        }
        if (com.xiaomi.push.ai.a(context)) {
            if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(context).a(com.xiaomi.mipush.sdk.au.DISABLE_PUSH))) {
                com.xiaomi.mipush.sdk.MiPushClient.disablePush(context);
            }
            if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(context).a(com.xiaomi.mipush.sdk.au.ENABLE_PUSH))) {
                com.xiaomi.mipush.sdk.MiPushClient.enablePush(context);
            }
            if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(context).a(com.xiaomi.mipush.sdk.au.UPLOAD_HUAWEI_TOKEN))) {
                com.xiaomi.mipush.sdk.MiPushClient.syncAssemblePushToken(context);
            }
            if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(context).a(com.xiaomi.mipush.sdk.au.UPLOAD_FCM_TOKEN))) {
                com.xiaomi.mipush.sdk.MiPushClient.syncAssembleFCMPushToken(context);
            }
            if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(context).a(com.xiaomi.mipush.sdk.au.UPLOAD_COS_TOKEN))) {
                com.xiaomi.mipush.sdk.MiPushClient.syncAssembleCOSPushToken(context);
            }
            if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(context).a(com.xiaomi.mipush.sdk.au.UPLOAD_FTOS_TOKEN))) {
                com.xiaomi.mipush.sdk.MiPushClient.syncAssembleFTOSPushToken(context);
            }
            if (com.xiaomi.mipush.sdk.HWPushHelper.needConnect() && com.xiaomi.mipush.sdk.HWPushHelper.shouldTryConnect(context)) {
                com.xiaomi.mipush.sdk.HWPushHelper.setConnectTime(context);
                com.xiaomi.mipush.sdk.HWPushHelper.registerHuaWeiAssemblePush(context);
            }
            com.xiaomi.mipush.sdk.COSPushHelper.doInNetworkChange(context);
            com.xiaomi.mipush.sdk.FTOSPushHelper.doInNetworkChange(context);
        }
    }

    public static boolean a() {
        return a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        if (this.b) {
            return;
        }
        com.xiaomi.push.iw.a().post(new com.xiaomi.push.service.receivers.a(this, context));
    }
}
