package com.xiaomi.push.service;

import com.xiaomi.push.service.c.g;

/* loaded from: classes19.dex */
final class bv extends android.database.ContentObserver {
    final /* synthetic */ com.xiaomi.push.service.c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(com.xiaomi.push.service.c cVar, android.os.Handler handler) {
        super(handler);
        this.a = cVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        boolean h;
        super.onChange(z);
        h = this.a.h();
        com.xiaomi.channel.commonutils.logger.b.a("SuperPowerMode:".concat(java.lang.String.valueOf(h)));
        this.a.k();
        if (!h) {
            this.a.b(true);
        } else {
            com.xiaomi.push.service.c cVar = this.a;
            cVar.a(cVar.new g(24), 0L);
        }
    }
}
