package com.xiaomi.push;

/* loaded from: classes19.dex */
final class ci extends com.xiaomi.push.p.b {
    com.xiaomi.push.p.b a;
    final /* synthetic */ com.xiaomi.push.cg b;

    public ci(com.xiaomi.push.cg cgVar) {
        this.b = cgVar;
    }

    @Override // com.xiaomi.push.p.b
    public final void a() {
        com.xiaomi.push.cg.b bVar = (com.xiaomi.push.cg.b) this.b.a.peek();
        if (bVar == null || !bVar.c()) {
            return;
        }
        if (this.b.a.remove(bVar)) {
            this.a = bVar;
        }
        com.xiaomi.push.p.b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.a();
        }
    }

    @Override // com.xiaomi.push.p.b
    public final void b() {
        com.xiaomi.push.p.b bVar = this.a;
        if (bVar != null) {
            bVar.b();
        }
    }
}
