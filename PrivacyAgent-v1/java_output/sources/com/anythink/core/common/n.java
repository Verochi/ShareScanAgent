package com.anythink.core.common;

/* loaded from: classes12.dex */
public final class n {
    java.lang.String a;
    java.lang.String b;
    private java.util.List<com.anythink.core.common.b.b> e;
    private final java.lang.String c = com.anythink.core.common.n.class.getSimpleName();
    private final java.lang.Object d = new java.lang.Object();
    private com.anythink.core.common.b.b f = new com.anythink.core.common.n.AnonymousClass1();

    /* renamed from: com.anythink.core.common.n$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.b.b {
        public AnonymousClass1() {
        }

        @Override // com.anythink.core.common.b.b
        public final void onAdLoadFail(com.anythink.core.api.AdError adError) {
            synchronized (com.anythink.core.common.n.this.d) {
                java.util.Iterator it = com.anythink.core.common.n.this.e.iterator();
                while (it.hasNext()) {
                    com.anythink.core.common.b.b bVar = (com.anythink.core.common.b.b) it.next();
                    if (bVar != null) {
                        com.anythink.core.common.n nVar = com.anythink.core.common.n.this;
                        com.anythink.core.common.o.o.a(nVar.a, java.lang.String.valueOf(nVar.b), com.anythink.core.common.b.h.m.D, com.anythink.core.common.b.h.m.m, "[listener:" + bVar.toString() + "]");
                        bVar.onAdLoadFail(adError);
                        it.remove();
                    }
                }
            }
        }

        @Override // com.anythink.core.common.b.b
        public final void onAdLoaded() {
            synchronized (com.anythink.core.common.n.this.d) {
                if (com.anythink.core.common.n.this.e != null) {
                    java.util.Iterator it = com.anythink.core.common.n.this.e.iterator();
                    while (it.hasNext()) {
                        com.anythink.core.common.b.b bVar = (com.anythink.core.common.b.b) it.next();
                        if (bVar != null) {
                            com.anythink.core.common.n nVar = com.anythink.core.common.n.this;
                            com.anythink.core.common.o.o.a(nVar.a, java.lang.String.valueOf(nVar.b), com.anythink.core.common.b.h.m.D, com.anythink.core.common.b.h.m.l, "[listener:" + bVar.toString() + "]");
                            bVar.onAdLoaded();
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.anythink.core.common.n$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.v a;
        final /* synthetic */ com.anythink.core.common.f b;

        public AnonymousClass2(com.anythink.core.common.f.v vVar, com.anythink.core.common.f fVar) {
            this.a = vVar;
            this.b = fVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.f.v b = this.a.b();
            b.d = 8;
            b.f = null;
            b.e = null;
            com.anythink.core.common.f fVar = this.b;
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            com.anythink.core.common.n nVar = com.anythink.core.common.n.this;
            fVar.a(f, nVar.b, nVar.a, b, (com.anythink.core.common.b.b) null);
        }
    }

    private void a(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    private boolean a(com.anythink.core.common.f fVar) {
        com.anythink.core.d.e a = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(this.a);
        return a != null && a.f() == 1 && fVar.c() < a.g();
    }

    public final void a(int i, com.anythink.core.common.f.v vVar, com.anythink.core.common.f.az azVar) {
        com.anythink.core.common.j.d dVar;
        com.anythink.core.d.e a;
        java.lang.String str = vVar.a;
        if (azVar != null) {
            azVar.toString();
        }
        com.anythink.core.common.f a2 = com.anythink.core.common.u.a().a(this.a, java.lang.String.valueOf(this.b));
        if (azVar != null && (a = azVar.a()) != null) {
            if (a.f() != 1) {
                azVar.toString();
                a2.a(new com.anythink.core.common.f.aw(java.lang.System.currentTimeMillis(), azVar.n()), a);
            } else if (i == 1) {
                azVar.toString();
                a2.a(new com.anythink.core.common.f.aw(java.lang.System.currentTimeMillis(), azVar.n()), a);
            }
        }
        a2.d();
        com.anythink.core.d.e a3 = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(this.a);
        boolean z = a3 != null && a3.f() == 1 && a2.c() < a3.g();
        this.f.onAdLoaded();
        if (vVar.d != 9 && i != 3 && z) {
            azVar.toString();
            com.anythink.core.common.f.v b = vVar.b();
            b.d = 9;
            b.f = null;
            b.e = null;
            a2.a(com.anythink.core.common.b.o.a().f(), this.b, this.a, b, (com.anythink.core.common.b.b) null);
        }
        if (i != 1 || (dVar = a2.k) == null) {
            return;
        }
        dVar.b();
    }

    public final void a(int i, com.anythink.core.common.f.v vVar, com.anythink.core.common.f.az azVar, com.anythink.core.api.AdError adError) {
        com.anythink.core.common.f a = com.anythink.core.common.u.a().a(this.a, java.lang.String.valueOf(this.b));
        java.lang.String str = vVar.a;
        if (azVar != null) {
            azVar.toString();
        }
        if (azVar == null || i != 2 || !azVar.b()) {
            if (azVar != null) {
                azVar.toString();
            }
            if (i != 3 && a != null) {
                a.e();
            }
            this.f.onAdLoadFail(adError);
        } else if (a != null && !com.anythink.core.common.u.a().e(this.a)) {
            azVar.toString();
            com.anythink.core.common.b.o.a();
            com.anythink.core.common.b.o.b(new com.anythink.core.common.n.AnonymousClass2(vVar, a), azVar.c());
        }
        if (a != null) {
            a.a(adError);
        }
    }

    public final void a(com.anythink.core.common.b.b bVar) {
        synchronized (this.d) {
            if (this.e == null) {
                this.e = new java.util.ArrayList();
            }
            if (bVar == null) {
                return;
            }
            java.util.Iterator<com.anythink.core.common.b.b> it = this.e.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next() == bVar) {
                    z = true;
                }
            }
            if (!z) {
                this.e.add(bVar);
            }
        }
    }

    public final void b(com.anythink.core.common.b.b bVar) {
        synchronized (this.d) {
            java.util.List<com.anythink.core.common.b.b> list = this.e;
            if (list == null) {
                return;
            }
            list.remove(bVar);
        }
    }
}
