package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class i extends com.xiaomi.push.service.c.j {
    final /* synthetic */ com.xiaomi.push.service.c a;
    final /* synthetic */ com.xiaomi.push.hh b;
    final /* synthetic */ java.lang.String c;
    final /* synthetic */ java.lang.String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(com.xiaomi.push.service.c cVar, com.xiaomi.push.hh hhVar, java.lang.String str, java.lang.String str2) {
        super(4);
        this.a = cVar;
        this.b = hhVar;
        this.c = str;
        this.d = str2;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        try {
            com.xiaomi.push.hh a = com.xiaomi.push.service.ct.a(this.a, this.b, (java.util.Map<java.lang.String, java.lang.String>) null);
            a.h.a("error", this.c);
            a.h.a("reason", this.d);
            com.xiaomi.push.service.l.a(this.a, a);
        } catch (com.xiaomi.push.fh e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "send wrong message ack for message.";
    }
}
