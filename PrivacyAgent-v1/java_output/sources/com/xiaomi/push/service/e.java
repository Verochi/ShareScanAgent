package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class e extends com.xiaomi.push.service.c.j {
    final /* synthetic */ com.xiaomi.push.service.c a;
    final /* synthetic */ com.xiaomi.push.hh b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(com.xiaomi.push.service.c cVar, com.xiaomi.push.hh hhVar) {
        super(4);
        this.a = cVar;
        this.b = hhVar;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        try {
            if (com.xiaomi.push.iu.a(this.a)) {
                try {
                    com.xiaomi.push.hh hhVar = this.b;
                    com.xiaomi.push.service.k.a aVar = com.xiaomi.push.service.k.a;
                    r1 = (aVar == null || hhVar == null) ? null : aVar.b();
                    com.xiaomi.channel.commonutils.logger.b.a("pepa listener or container is null");
                } catch (java.lang.Throwable unused) {
                }
            }
            com.xiaomi.push.service.l.a(this.a, com.xiaomi.push.service.ct.a(this.a, this.b, r1));
        } catch (com.xiaomi.push.fh e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "send ack message for message.";
    }
}
