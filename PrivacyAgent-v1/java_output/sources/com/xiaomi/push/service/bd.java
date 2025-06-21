package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class bd extends com.xiaomi.push.service.c.j {
    private com.xiaomi.push.service.c a;
    private com.xiaomi.push.ek[] b;

    public bd(com.xiaomi.push.service.c cVar, com.xiaomi.push.ek[] ekVarArr) {
        super(4);
        this.a = cVar;
        this.b = ekVarArr;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        try {
            com.xiaomi.push.ek[] ekVarArr = this.b;
            if (ekVarArr != null) {
                com.xiaomi.push.ev evVar = this.a.c;
                if (evVar == null) {
                    throw new com.xiaomi.push.fh("try send msg while connection is null.");
                }
                evVar.a(ekVarArr);
            }
        } catch (com.xiaomi.push.fh e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.a.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "batch send message.";
    }
}
