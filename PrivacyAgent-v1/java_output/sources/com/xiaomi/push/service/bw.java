package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class bw extends com.xiaomi.push.service.c.j {
    final /* synthetic */ com.xiaomi.push.service.c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(com.xiaomi.push.service.c cVar) {
        super(11);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        com.xiaomi.push.service.c cVar = this.a;
        com.xiaomi.push.service.co a = com.xiaomi.push.service.cp.a(cVar.getApplicationContext());
        if (a != null) {
            com.xiaomi.push.service.aj.b a2 = com.xiaomi.push.service.cp.a(cVar.getApplicationContext()).a(cVar);
            com.xiaomi.channel.commonutils.logger.b.a("prepare account. " + a2.a);
            com.xiaomi.push.service.l.a(cVar, a2);
            com.xiaomi.push.service.aj.a().a(a2);
            com.xiaomi.push.service.ba.a(cVar).a(new com.xiaomi.push.service.m("GAID", cVar, a));
            com.xiaomi.push.service.ba.a(cVar).a(new com.xiaomi.push.service.n("MSAID", cVar, a));
        }
        if (com.xiaomi.push.ai.a(this.a)) {
            this.a.b(true);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "prepare the mi push account.";
    }
}
