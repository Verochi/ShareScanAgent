package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class am extends com.xiaomi.push.service.c.j {
    final /* synthetic */ com.xiaomi.push.service.aj.b.c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(com.xiaomi.push.service.aj.b.c cVar) {
        super(0);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        com.xiaomi.push.service.aj a = com.xiaomi.push.service.aj.a();
        com.xiaomi.push.service.aj.b bVar = this.a.a;
        if (a.b(bVar.h, bVar.b).r == null) {
            com.xiaomi.push.service.aj.b.c cVar = this.a;
            com.xiaomi.push.service.c cVar2 = com.xiaomi.push.service.aj.b.this.p;
            com.xiaomi.push.service.aj.b bVar2 = cVar.a;
            cVar2.a(bVar2.h, bVar2.b, 2, null, null);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "check peer job";
    }
}
