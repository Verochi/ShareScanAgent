package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class j extends com.xiaomi.push.service.c.j {
    final /* synthetic */ com.xiaomi.push.hk a;
    final /* synthetic */ com.xiaomi.push.hh b;
    final /* synthetic */ com.xiaomi.push.service.c c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(com.xiaomi.push.hk hkVar, com.xiaomi.push.hh hhVar, com.xiaomi.push.service.c cVar) {
        super(4);
        this.a = hkVar;
        this.b = hhVar;
        this.c = cVar;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        try {
            com.xiaomi.push.hc hcVar = new com.xiaomi.push.hc();
            hcVar.e = com.xiaomi.push.gu.CancelPushMessageACK.ah;
            com.xiaomi.push.hk hkVar = this.a;
            hcVar.c = hkVar.c;
            hcVar.b = hkVar.b;
            hcVar.d = hkVar.d;
            hcVar.i = hkVar.i;
            hcVar.a();
            hcVar.g = "success clear push message.";
            com.xiaomi.push.hh hhVar = this.b;
            com.xiaomi.push.service.l.a(this.c, com.xiaomi.push.service.l.a(hhVar.f, hhVar.e, hcVar, com.xiaomi.push.gk.Notification, false));
        } catch (com.xiaomi.push.fh e) {
            com.xiaomi.channel.commonutils.logger.b.d("clear push message. ".concat(java.lang.String.valueOf(e)));
            this.c.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "send ack message for clear push message.";
    }
}
