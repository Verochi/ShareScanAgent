package com.anythink.expressad.advanced.d;

/* loaded from: classes12.dex */
public final class b implements com.anythink.expressad.advanced.b.a {
    private com.anythink.expressad.out.o a;
    private com.anythink.expressad.advanced.d.c b;

    public b(com.anythink.expressad.advanced.d.c cVar) {
        this.b = cVar;
    }

    private static void a() {
    }

    private void b() {
        if (this.a != null) {
            this.a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.anythink.expressad.advanced.b.a
    public final void a(com.anythink.expressad.foundation.d.c cVar, int i) {
        com.anythink.expressad.advanced.d.c cVar2;
        com.anythink.expressad.advanced.d.c cVar3 = this.b;
        if (cVar3 == null || !cVar3.a() || cVar == null) {
            return;
        }
        com.anythink.expressad.out.o oVar = this.a;
        if (oVar != null && this.b != null) {
            oVar.a();
        }
        this.b.b();
        new java.util.ArrayList().add(cVar);
        if (i != 2 || (cVar2 = this.b) == null) {
            return;
        }
        cVar2.a(cVar, true);
    }

    public final void a(com.anythink.expressad.out.o oVar) {
        this.a = oVar;
    }

    @Override // com.anythink.expressad.advanced.b.a
    public final void a(java.lang.String str, int i) {
        com.anythink.expressad.advanced.d.c cVar = this.b;
        if (cVar == null || !cVar.a()) {
            return;
        }
        com.anythink.expressad.out.o oVar = this.a;
        if (oVar != null) {
            oVar.a(str);
        }
        this.b.b();
    }
}
