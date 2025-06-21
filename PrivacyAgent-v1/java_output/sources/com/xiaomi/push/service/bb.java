package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class bb implements java.lang.Runnable {
    final /* synthetic */ com.xiaomi.push.service.ba a;

    public bb(com.xiaomi.push.service.ba baVar) {
        this.a = baVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.util.concurrent.ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.a.e;
            java.util.Iterator it = concurrentHashMap.values().iterator();
            while (it.hasNext()) {
                ((com.xiaomi.push.service.ba.a) it.next()).run();
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("Sync job exception :" + e.getMessage());
        }
        com.xiaomi.push.service.ba.b(this.a);
    }
}
