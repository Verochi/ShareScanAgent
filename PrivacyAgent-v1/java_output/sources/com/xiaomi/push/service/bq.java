package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class bq implements java.lang.Runnable {
    final /* synthetic */ com.xiaomi.push.service.c a;

    public bq(com.xiaomi.push.service.c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.xiaomi.push.service.c.k(this.a);
        try {
            com.xiaomi.channel.commonutils.logger.b.a("try to trigger the wifi digest broadcast.");
            java.lang.Object systemService = this.a.getApplicationContext().getSystemService("MiuiWifiService");
            if (systemService != null) {
                com.xiaomi.push.aj.b(systemService, "sendCurrentWifiDigestInfo", new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
