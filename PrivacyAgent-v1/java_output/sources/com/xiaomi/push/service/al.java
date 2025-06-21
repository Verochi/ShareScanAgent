package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class al extends com.xiaomi.push.service.c.j {
    final /* synthetic */ com.xiaomi.push.service.aj.b.c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(com.xiaomi.push.service.aj.b.c cVar) {
        super(0);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        com.xiaomi.push.service.aj.b.c cVar = this.a;
        if (cVar.b == cVar.a.r) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.a.a.h);
            this.a.a.r = null;
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "clear peer job";
    }
}
