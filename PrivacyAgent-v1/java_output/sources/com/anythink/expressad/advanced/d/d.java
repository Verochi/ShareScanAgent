package com.anythink.expressad.advanced.d;

/* loaded from: classes12.dex */
public final class d implements com.anythink.expressad.advanced.b.b {
    private static final java.lang.String a = "NativeAdvancedShowListenerImpl";
    private com.anythink.expressad.out.o b;
    private com.anythink.expressad.foundation.d.c c;
    private boolean d;
    private com.anythink.expressad.advanced.d.c e;

    public d(com.anythink.expressad.advanced.d.c cVar, com.anythink.expressad.out.o oVar, double d, com.anythink.expressad.foundation.d.c cVar2) {
        this.e = cVar;
        this.b = oVar;
        this.c = cVar2;
        this.d = a(d, cVar2);
    }

    private static boolean a(double d, com.anythink.expressad.foundation.d.c cVar) {
        try {
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a c = com.anythink.expressad.d.b.c();
            long l = c.l() * 1000;
            long x = c.x() * 1000;
            if (cVar != null) {
                if (cVar.a(x, l)) {
                    cVar.e(1);
                    return true;
                }
                cVar.e(0);
            }
        } catch (java.lang.Exception unused) {
        }
        return (cVar == null || cVar.A() || d == 1.0d || new java.util.Random().nextDouble() <= d) ? false : true;
    }

    private void g() {
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void a() {
        com.anythink.expressad.advanced.d.c cVar = this.e;
        if (cVar != null) {
            cVar.d = true;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("load_to=0&allow_skip=");
        stringBuffer.append(this.e.d());
        stringBuffer.append("&");
        com.anythink.expressad.out.o oVar = this.b;
        if (oVar == null || this.d) {
            return;
        }
        oVar.b();
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.out.o oVar = this.b;
        if (oVar == null || this.d) {
            return;
        }
        oVar.a(cVar);
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void b() {
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void c() {
        com.anythink.expressad.out.o oVar = this.b;
        if (oVar != null) {
            oVar.f();
            com.anythink.expressad.advanced.d.c cVar = this.e;
            if (cVar != null) {
                cVar.d = false;
            }
        }
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void d() {
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void e() {
    }

    @Override // com.anythink.expressad.advanced.b.b
    public final void f() {
    }
}
