package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
final class n implements com.sijla.h.b.a {
    private /* synthetic */ com.sijla.mla.a.j a;
    private /* synthetic */ boolean b;
    private /* synthetic */ com.sijla.mla.a.b.m.a c;

    public n(com.sijla.mla.a.b.m.a aVar, com.sijla.mla.a.j jVar, boolean z) {
        this.c = aVar;
        this.a = jVar;
        this.b = z;
    }

    @Override // com.sijla.h.b.a
    public final boolean a(java.io.File file) {
        com.sijla.mla.a.r b = this.a.b(com.sijla.mla.a.r.h("preVisitDirectory"), new com.sijla.mla.g(file));
        return !this.b || b == null || b.i();
    }

    @Override // com.sijla.h.b.a
    public final boolean b(java.io.File file) {
        com.sijla.mla.a.r b = this.a.b(com.sijla.mla.a.r.h("visitFile"), new com.sijla.mla.g(file));
        return !this.b || b == null || b.i();
    }

    @Override // com.sijla.h.b.a
    public final void c(java.io.File file) {
        this.a.b(com.sijla.mla.a.r.h("postVisitDirectory"), new com.sijla.mla.g(file));
    }
}
