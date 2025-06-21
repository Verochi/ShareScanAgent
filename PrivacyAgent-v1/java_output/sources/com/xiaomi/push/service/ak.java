package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class ak implements com.xiaomi.push.service.aj.b.a {
    final /* synthetic */ com.xiaomi.push.service.aj.b a;

    public ak(com.xiaomi.push.service.aj.b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.service.aj.b.a
    public final void a(com.xiaomi.push.service.aj.c cVar, com.xiaomi.push.service.aj.c cVar2, int i) {
        if (cVar2 == com.xiaomi.push.service.aj.c.binding) {
            com.xiaomi.push.service.aj.b bVar = this.a;
            bVar.p.a(bVar.t, 60000L);
        } else {
            com.xiaomi.push.service.aj.b bVar2 = this.a;
            bVar2.p.a(bVar2.t);
        }
    }
}
