package com.igexin.push.g.b;

/* loaded from: classes23.dex */
public class a extends com.igexin.push.g.b.f {
    private static volatile com.igexin.push.g.b.a b;
    private java.util.List<com.igexin.push.g.b.c> a;

    private a() {
        super(60000L, (byte) 0);
        this.p = true;
        this.a = new java.util.ArrayList();
    }

    public static com.igexin.push.g.b.a g() {
        if (b == null) {
            synchronized (com.igexin.push.g.b.a.class) {
                if (b == null) {
                    b = new com.igexin.push.g.b.a();
                }
            }
        }
        return b;
    }

    private void i() {
        a(360000L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public final boolean a(com.igexin.push.g.b.c cVar) {
        java.util.List<com.igexin.push.g.b.c> list = this.a;
        return (list == null || list.contains(cVar) || !this.a.add(cVar)) ? false : true;
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 0;
    }

    @Override // com.igexin.push.g.b.f
    public final void h() {
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.k();
        for (com.igexin.push.g.b.c cVar : this.a) {
            if (cVar.c()) {
                cVar.b();
                cVar.a(java.lang.System.currentTimeMillis());
            }
        }
        a(360000L, java.util.concurrent.TimeUnit.MILLISECONDS);
        com.igexin.c.a.b.e.a().a((java.lang.Object) this);
    }
}
