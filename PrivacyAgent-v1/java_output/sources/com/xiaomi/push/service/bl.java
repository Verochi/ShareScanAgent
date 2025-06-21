package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class bl implements java.lang.Runnable {
    final /* synthetic */ com.xiaomi.push.hk a;

    public bl(com.xiaomi.push.hk hkVar) {
        this.a = hkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        android.content.Context context2;
        com.xiaomi.push.hk hkVar = this.a;
        byte[] a = com.xiaomi.push.hv.a(com.xiaomi.push.service.l.a(hkVar.i, hkVar.d, hkVar, com.xiaomi.push.gk.Notification));
        context = com.xiaomi.push.service.bk.c;
        if (!(context instanceof com.xiaomi.push.service.c)) {
            com.xiaomi.channel.commonutils.logger.b.a("UNDatas UploadNotificationDatas failed because not xmsf");
        } else {
            context2 = com.xiaomi.push.service.bk.c;
            ((com.xiaomi.push.service.c) context2).a(this.a.i, a, true);
        }
    }
}
