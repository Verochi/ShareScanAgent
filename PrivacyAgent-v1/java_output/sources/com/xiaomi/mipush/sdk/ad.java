package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
class ad extends android.content.BroadcastReceiver {
    final /* synthetic */ com.xiaomi.mipush.sdk.NotificationClickedActivity a;

    public ad(com.xiaomi.mipush.sdk.NotificationClickedActivity notificationClickedActivity) {
        this.a = notificationClickedActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.xiaomi.channel.commonutils.logger.b.b("clicked activity finish by normal.");
        this.a.finish();
    }
}
