package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class bx extends com.amap.api.mapcore.util.bp {
    public bx(com.amap.api.mapcore.util.al alVar) {
        super(1, alVar);
    }

    @Override // com.amap.api.mapcore.util.bp
    public final void a(int i) {
        b(this.b.h);
        com.amap.api.mapcore.util.al alVar = this.b;
        alVar.a(alVar.h);
        this.b.c().h();
    }

    @Override // com.amap.api.mapcore.util.bp
    public final void c() {
        this.b.d();
    }

    @Override // com.amap.api.mapcore.util.bp
    public final void g() {
        b(this.b.f);
        com.amap.api.mapcore.util.al alVar = this.b;
        alVar.a(alVar.f);
        this.b.c().h();
    }

    @Override // com.amap.api.mapcore.util.bt
    public final void h() {
        this.b.setCompleteCode(0);
        this.b.d();
    }
}
