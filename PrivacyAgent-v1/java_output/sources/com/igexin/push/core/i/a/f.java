package com.igexin.push.core.i.a;

/* loaded from: classes23.dex */
public final class f extends com.igexin.push.core.i.a.b<com.igexin.push.core.i.a.e> {
    public f(com.igexin.push.core.i.a.e eVar) {
        super(eVar);
    }

    @Override // com.igexin.push.core.i.a.b, com.igexin.push.core.i.a.l
    public final void b() {
        ((com.igexin.push.core.i.a.e) this.a).a().prepareToDraw();
    }

    @Override // com.igexin.push.core.i.a.m
    public final java.lang.Class<com.igexin.push.core.i.a.e> d() {
        return com.igexin.push.core.i.a.e.class;
    }

    @Override // com.igexin.push.core.i.a.m
    public final int e() {
        com.igexin.push.core.i.a.h hVar = ((com.igexin.push.core.i.a.e) this.a).c.a;
        return hVar.a.m() + hVar.j;
    }

    @Override // com.igexin.push.core.i.a.m
    public final void f() {
        ((com.igexin.push.core.i.a.e) this.a).stop();
        com.igexin.push.core.i.a.e eVar = (com.igexin.push.core.i.a.e) this.a;
        eVar.e = true;
        com.igexin.push.core.i.a.h hVar = eVar.c.a;
        hVar.b.clear();
        hVar.b();
        hVar.c = false;
        if (hVar.e != null) {
            hVar.e = null;
        }
        if (hVar.g != null) {
            hVar.g = null;
        }
        if (hVar.i != null) {
            hVar.i = null;
        }
        hVar.a.o();
        hVar.f = true;
    }
}
