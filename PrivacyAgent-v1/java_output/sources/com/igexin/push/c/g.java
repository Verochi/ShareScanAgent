package com.igexin.push.c;

/* loaded from: classes23.dex */
public final class g extends com.igexin.push.c.h implements com.igexin.push.c.i {
    private static com.igexin.push.c.g e;

    private g() {
        super(com.igexin.push.core.e.ap, com.igexin.push.core.e.ar);
        this.d.j = false;
    }

    public static synchronized com.igexin.push.c.g a() {
        com.igexin.push.c.g gVar;
        synchronized (com.igexin.push.c.g.class) {
            if (e == null) {
                e = new com.igexin.push.c.g();
            }
            gVar = e;
        }
        return gVar;
    }

    @Override // com.igexin.push.c.i
    public final void a(int i, com.igexin.push.c.d dVar) {
        com.igexin.push.c.e a;
        if (dVar == null || android.text.TextUtils.isEmpty(dVar.a()) || (a = a(dVar.a())) == null) {
            return;
        }
        a(dVar);
        a.a();
        m();
        if (i == com.igexin.push.c.b.a.a) {
            l();
        }
    }

    @Override // com.igexin.push.c.i
    public final void b() {
    }

    @Override // com.igexin.push.c.h
    public final int c() {
        return com.igexin.push.c.b.EnumC0371b.b;
    }

    @Override // com.igexin.push.c.h
    public final com.igexin.push.c.i d() {
        return this;
    }
}
