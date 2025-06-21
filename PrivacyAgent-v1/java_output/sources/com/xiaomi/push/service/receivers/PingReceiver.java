package com.xiaomi.push.service.receivers;

/* loaded from: classes19.dex */
public class PingReceiver extends android.content.BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.xiaomi.channel.commonutils.logger.b.c(intent.getPackage() + " is the package name");
        if (com.xiaomi.push.service.c.c()) {
            return;
        }
        if (!com.xiaomi.push.service.an.p.equals(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.a("cancel the old ping timer");
            com.xiaomi.push.du.a();
        } else if (android.text.TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            com.xiaomi.channel.commonutils.logger.b.c("Ping XMChannelService on timer");
            try {
                android.content.Intent intent2 = new android.content.Intent(context, (java.lang.Class<?>) com.xiaomi.push.service.c.class);
                intent2.putExtra("time_stamp", java.lang.System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                com.xiaomi.push.service.a.a(context).a(intent2);
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
