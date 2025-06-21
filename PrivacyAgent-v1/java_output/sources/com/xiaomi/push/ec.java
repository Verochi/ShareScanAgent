package com.xiaomi.push;

/* loaded from: classes19.dex */
final class ec implements com.xiaomi.push.service.aj.b.a {
    com.xiaomi.push.service.c a;
    com.xiaomi.push.service.aj.b b;
    com.xiaomi.push.ev c;
    int e;
    boolean f = false;
    com.xiaomi.push.service.aj.c d = com.xiaomi.push.service.aj.c.binding;

    public ec(com.xiaomi.push.service.c cVar, com.xiaomi.push.service.aj.b bVar) {
        this.a = cVar;
        this.b = bVar;
    }

    @Override // com.xiaomi.push.service.aj.b.a
    public final void a(com.xiaomi.push.service.aj.c cVar, com.xiaomi.push.service.aj.c cVar2, int i) {
        if (!this.f && cVar == com.xiaomi.push.service.aj.c.binding) {
            this.d = cVar2;
            this.e = i;
            this.f = true;
        }
        this.a.a(new com.xiaomi.push.ed(this), 0L);
    }
}
