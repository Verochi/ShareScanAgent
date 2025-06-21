package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class bo extends com.xiaomi.push.service.c.j {
    final /* synthetic */ com.xiaomi.push.service.c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(com.xiaomi.push.service.c cVar) {
        super(2);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        if (this.a.c != null) {
            this.a.c.b(15, (java.lang.Exception) null);
            com.xiaomi.push.service.c.f(this.a);
        }
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "disconnect for service destroy.";
    }
}
