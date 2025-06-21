package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class cu extends com.xiaomi.push.service.c.j {
    final /* synthetic */ com.xiaomi.push.service.c a;
    final /* synthetic */ com.xiaomi.push.hh b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu(com.xiaomi.push.service.c cVar, com.xiaomi.push.hh hhVar) {
        super(4);
        this.a = cVar;
        this.b = hhVar;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        try {
            com.xiaomi.push.service.c cVar = this.a;
            com.xiaomi.push.hh hhVar = this.b;
            com.xiaomi.push.service.l.a(cVar, com.xiaomi.push.service.l.a(hhVar.f, hhVar.e));
        } catch (com.xiaomi.push.fh e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "send app absent message.";
    }
}
