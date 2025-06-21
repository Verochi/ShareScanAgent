package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class bu extends com.amap.api.mapcore.util.bo {
    public bu(com.amap.api.mapcore.util.al alVar) {
        super(0, alVar);
    }

    @Override // com.amap.api.mapcore.util.bp
    public final void a(int i) {
        b(this.b.b(i));
        com.amap.api.mapcore.util.al alVar = this.b;
        alVar.a(alVar.b(i));
        this.b.c().h();
    }

    @Override // com.amap.api.mapcore.util.bp
    public final void e() {
        b(this.b.d);
        com.amap.api.mapcore.util.al alVar = this.b;
        alVar.a(alVar.d);
        this.b.c().h();
    }

    @Override // com.amap.api.mapcore.util.bp
    public final void g() {
        b(this.b.e);
        com.amap.api.mapcore.util.al alVar = this.b;
        alVar.a(alVar.e);
        this.b.c().h();
    }

    @Override // com.amap.api.mapcore.util.bt
    public final void h() {
        this.b.d();
    }
}
