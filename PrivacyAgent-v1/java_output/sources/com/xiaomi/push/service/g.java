package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class g extends com.xiaomi.push.service.c.j {
    final /* synthetic */ com.xiaomi.push.service.c a;
    final /* synthetic */ com.xiaomi.push.hh b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(com.xiaomi.push.service.c cVar, com.xiaomi.push.hh hhVar) {
        super(4);
        this.a = cVar;
        this.b = hhVar;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        try {
            com.xiaomi.push.hh a = com.xiaomi.push.service.ct.a(this.a, this.b, (java.util.Map<java.lang.String, java.lang.String>) null);
            a.h.a("miui_message_unrecognized", "1");
            com.xiaomi.push.service.l.a(this.a, a);
        } catch (com.xiaomi.push.fh e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "send ack message for unrecognized new miui message.";
    }
}
