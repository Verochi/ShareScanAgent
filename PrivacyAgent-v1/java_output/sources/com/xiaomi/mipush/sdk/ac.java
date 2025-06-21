package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
class ac implements java.lang.Runnable {
    final /* synthetic */ com.xiaomi.mipush.sdk.NotificationClickedActivity a;

    public ac(com.xiaomi.mipush.sdk.NotificationClickedActivity notificationClickedActivity) {
        this.a = notificationClickedActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.channel.commonutils.logger.b.f("clicked activity finish by timeout.");
        this.a.finish();
    }
}
