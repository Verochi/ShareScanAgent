package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class aw extends com.xiaomi.push.service.c.j {
    private com.xiaomi.push.service.c a;
    private com.xiaomi.push.ek b;

    public aw(com.xiaomi.push.service.c cVar, com.xiaomi.push.ek ekVar) {
        super(4);
        this.a = cVar;
        this.b = ekVar;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        try {
            com.xiaomi.push.ek ekVar = this.b;
            if (ekVar != null) {
                com.xiaomi.push.ev evVar = this.a.c;
                if (evVar == null) {
                    throw new com.xiaomi.push.fh("try send msg while connection is null.");
                }
                evVar.b(ekVar);
                if (this.b.e == null || !com.xiaomi.push.gj.a(this.a)) {
                    return;
                }
                this.b.e.h = java.lang.System.currentTimeMillis();
                com.xiaomi.push.service.bc.a("category_coord_up", "coord_up", "com.xiaomi.xmsf", this.b.e);
            }
        } catch (com.xiaomi.push.fh e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "send a message.";
    }
}
