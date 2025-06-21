package com.anythink.expressad.mbbanner.a.c;

/* loaded from: classes12.dex */
public class e implements com.anythink.expressad.mbbanner.a.c.c {
    private static final java.lang.String a = "e";
    private com.anythink.expressad.mbbanner.a.c.c b;
    private com.anythink.expressad.d.c c;
    private boolean d = false;

    public e(com.anythink.expressad.mbbanner.a.c.c cVar, com.anythink.expressad.d.c cVar2) {
        this.c = cVar2;
        this.b = cVar;
    }

    private static boolean a(com.anythink.expressad.d.c cVar, boolean z) {
        if (z || cVar == null || cVar.a() == 1.0d) {
            return false;
        }
        return new java.util.Random().nextDouble() > cVar.a();
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a() {
        com.anythink.expressad.mbbanner.a.c.c cVar = this.b;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.mbbanner.a.c.c cVar2 = this.b;
        if (cVar2 == null || this.d) {
            return;
        }
        cVar2.a(cVar);
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
        com.anythink.expressad.mbbanner.a.c.c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(cVar, this.d);
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(java.lang.String str) {
        com.anythink.expressad.mbbanner.a.c.c cVar = this.b;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    com.anythink.expressad.d.c cVar = this.c;
                    boolean z = false;
                    if (!list.get(0).A() && cVar != null && cVar.a() != 1.0d) {
                        if (new java.util.Random().nextDouble() > cVar.a()) {
                            z = true;
                        }
                    }
                    this.d = z;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        com.anythink.expressad.mbbanner.a.c.c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(list);
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void a(boolean z) {
        com.anythink.expressad.mbbanner.a.c.c cVar = this.b;
        if (cVar != null) {
            cVar.a(z);
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void b() {
        com.anythink.expressad.mbbanner.a.c.c cVar = this.b;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void c() {
        com.anythink.expressad.mbbanner.a.c.c cVar = this.b;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.anythink.expressad.mbbanner.a.c.c
    public final void d() {
        com.anythink.expressad.mbbanner.a.c.c cVar = this.b;
        if (cVar != null) {
            cVar.d();
        }
    }
}
