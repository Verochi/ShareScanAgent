package com.xiaomi.push;

/* loaded from: classes19.dex */
final class ei extends com.xiaomi.push.service.ay.a {
    final /* synthetic */ com.xiaomi.push.eh a;

    public ei(com.xiaomi.push.eh ehVar) {
        this.a = ehVar;
    }

    @Override // com.xiaomi.push.service.ay.a
    public final void a(com.xiaomi.push.cx.b bVar) {
        if (bVar.e) {
            com.xiaomi.push.eh ehVar = com.xiaomi.push.eh.a.a;
            int i = bVar.f;
            if (i > 0) {
                int i2 = i * 1000;
                if (i2 > 604800000) {
                    i2 = 604800000;
                }
                if (ehVar.b == i2 && ehVar.a) {
                    return;
                }
                ehVar.a = true;
                ehVar.c = java.lang.System.currentTimeMillis();
                ehVar.b = i2;
                com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + ehVar.c);
            }
        }
    }
}
