package com.anythink.expressad.mbbanner.b;

/* loaded from: classes12.dex */
public final class a {
    private static java.lang.String b = "BannerController";
    com.anythink.expressad.out.i a;
    private java.lang.String c;
    private java.lang.String d;
    private boolean e;
    private int f;
    private com.anythink.expressad.out.TemplateBannerView g;
    private int h;
    private int i;
    private int j;
    private com.anythink.expressad.out.h l;
    private com.anythink.expressad.foundation.d.d m;
    private com.anythink.expressad.mbbanner.a.d.c n;
    private com.anythink.expressad.d.c o;
    private boolean p;
    private boolean q;
    private boolean r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f250s;
    private boolean t;
    private int k = -1;
    private com.anythink.expressad.mbbanner.a.c.c u = new com.anythink.expressad.mbbanner.b.a.AnonymousClass1();
    private com.anythink.expressad.mbbanner.a.c.b v = new com.anythink.expressad.mbbanner.b.a.AnonymousClass2();

    /* renamed from: com.anythink.expressad.mbbanner.b.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.mbbanner.a.c.c {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a() {
            if (com.anythink.expressad.mbbanner.b.a.this.l != null) {
                com.anythink.expressad.out.h unused = com.anythink.expressad.mbbanner.b.a.this.l;
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            if (com.anythink.expressad.mbbanner.b.a.this.l != null) {
                com.anythink.expressad.mbbanner.b.a.this.l.a(cVar);
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
            if (com.anythink.expressad.mbbanner.b.a.this.l == null || z) {
                return;
            }
            com.anythink.expressad.mbbanner.b.a.this.l.b();
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(java.lang.String str) {
            com.anythink.expressad.mbbanner.b.a.this.a(str);
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
            if (com.anythink.expressad.mbbanner.b.a.this.l != null) {
                com.anythink.expressad.mbbanner.b.a.this.l.a();
            }
            java.lang.String unused = com.anythink.expressad.mbbanner.b.a.b;
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void a(boolean z) {
            if (z) {
                com.anythink.expressad.mbbanner.a.d.a a = com.anythink.expressad.mbbanner.a.d.a.a();
                java.lang.String unused = com.anythink.expressad.mbbanner.b.a.this.d;
                a.a(2, com.anythink.expressad.mbbanner.b.a.this.c);
                return;
            }
            com.anythink.expressad.mbbanner.a.d.a a2 = com.anythink.expressad.mbbanner.a.d.a.a();
            java.lang.String unused2 = com.anythink.expressad.mbbanner.b.a.this.d;
            java.lang.String str = com.anythink.expressad.mbbanner.b.a.this.c;
            new com.anythink.expressad.mbbanner.a.b.d(com.anythink.expressad.mbbanner.b.a.this.i + "x" + com.anythink.expressad.mbbanner.b.a.this.h, com.anythink.expressad.mbbanner.b.a.this.j * 1000);
            com.anythink.expressad.mbbanner.a.c.b unused3 = com.anythink.expressad.mbbanner.b.a.this.v;
            a2.a(3, str);
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void b() {
            if (com.anythink.expressad.mbbanner.b.a.this.l != null) {
                com.anythink.expressad.out.h unused = com.anythink.expressad.mbbanner.b.a.this.l;
                com.anythink.expressad.mbbanner.b.a.this.t = true;
                com.anythink.expressad.mbbanner.a.d.a a = com.anythink.expressad.mbbanner.a.d.a.a();
                java.lang.String unused2 = com.anythink.expressad.mbbanner.b.a.this.d;
                a.a(2, com.anythink.expressad.mbbanner.b.a.this.c);
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void c() {
            if (com.anythink.expressad.mbbanner.b.a.this.l != null) {
                com.anythink.expressad.out.h unused = com.anythink.expressad.mbbanner.b.a.this.l;
                com.anythink.expressad.mbbanner.b.a.this.t = false;
                com.anythink.expressad.mbbanner.a.d.a a = com.anythink.expressad.mbbanner.a.d.a.a();
                java.lang.String unused2 = com.anythink.expressad.mbbanner.b.a.this.d;
                java.lang.String str = com.anythink.expressad.mbbanner.b.a.this.c;
                new com.anythink.expressad.mbbanner.a.b.d(com.anythink.expressad.mbbanner.b.a.this.i + "x" + com.anythink.expressad.mbbanner.b.a.this.h, com.anythink.expressad.mbbanner.b.a.this.j * 1000);
                com.anythink.expressad.mbbanner.a.c.b unused3 = com.anythink.expressad.mbbanner.b.a.this.v;
                a.a(3, str);
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.c
        public final void d() {
            if (com.anythink.expressad.mbbanner.b.a.this.l != null) {
                com.anythink.expressad.mbbanner.b.a.this.l.f();
            }
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.b.a$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.mbbanner.a.c.b {
        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.mbbanner.a.c.b
        public final void a() {
            com.anythink.expressad.foundation.d.d unused = com.anythink.expressad.mbbanner.b.a.this.m;
            if (com.anythink.expressad.mbbanner.b.a.this.g != null) {
                try {
                    com.anythink.expressad.mbbanner.b.a.this.f250s = true;
                    com.anythink.expressad.mbbanner.b.a.this.h();
                } catch (java.lang.Throwable th) {
                    com.anythink.expressad.mbbanner.b.a.this.f250s = false;
                    if (com.anythink.expressad.mbbanner.b.a.this.l != null) {
                        com.anythink.expressad.mbbanner.b.a.this.l.a("startShowBanner fail:" + th.getMessage());
                    }
                    java.lang.String unused2 = com.anythink.expressad.mbbanner.b.a.b;
                    th.getMessage();
                }
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.b
        public final void a(com.anythink.expressad.foundation.d.d dVar) {
            com.anythink.expressad.mbbanner.b.a.this.m = dVar;
        }

        @Override // com.anythink.expressad.mbbanner.a.c.b
        public final void a(java.lang.String str) {
            if (com.anythink.expressad.mbbanner.b.a.this.l != null) {
                com.anythink.expressad.mbbanner.b.a.this.l.a(str);
            }
            java.lang.String unused = com.anythink.expressad.mbbanner.b.a.b;
        }

        @Override // com.anythink.expressad.mbbanner.a.c.b
        public final void b() {
            if (com.anythink.expressad.mbbanner.b.a.this.l != null) {
                com.anythink.expressad.mbbanner.b.a.this.l.a(com.anythink.expressad.mbbanner.a.a.c);
            }
            java.lang.String unused = com.anythink.expressad.mbbanner.b.a.b;
        }
    }

    public a(com.anythink.expressad.out.TemplateBannerView templateBannerView, com.anythink.expressad.out.i iVar, java.lang.String str, java.lang.String str2) {
        this.g = templateBannerView;
        if (iVar != null) {
            this.h = iVar.a();
            this.i = iVar.b();
        }
        this.a = iVar;
        this.c = str2;
        this.d = str;
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.c c = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.c);
        this.o = c;
        if (c == null) {
            this.o = com.anythink.expressad.d.c.c(this.c);
        }
        if (this.k == -1) {
            int b2 = this.o.b();
            if (b2 > 0) {
                if (b2 < 10) {
                    b2 = 10;
                } else if (b2 > 180) {
                    b2 = 180;
                }
            }
            this.j = b2;
        }
        if (this.f == 0) {
            boolean z = this.o.d() == 1;
            this.e = z;
            com.anythink.expressad.mbbanner.a.d.c cVar = this.n;
            if (cVar != null) {
                cVar.a(z);
            }
        }
    }

    private static int a(int i) {
        if (i <= 0) {
            return i;
        }
        if (i < 10) {
            return 10;
        }
        if (i > 180) {
            return 180;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str) {
        com.anythink.expressad.out.h hVar = this.l;
        if (hVar != null) {
            hVar.a(str);
        }
    }

    private void f() {
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.c c = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.c);
        this.o = c;
        if (c == null) {
            this.o = com.anythink.expressad.d.c.c(this.c);
        }
        if (this.k == -1) {
            int b2 = this.o.b();
            if (b2 > 0) {
                if (b2 < 10) {
                    b2 = 10;
                } else if (b2 > 180) {
                    b2 = 180;
                }
            }
            this.j = b2;
        }
        if (this.f == 0) {
            boolean z = this.o.d() == 1;
            this.e = z;
            com.anythink.expressad.mbbanner.a.d.c cVar = this.n;
            if (cVar != null) {
                cVar.a(z);
            }
        }
    }

    private void g() {
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.c c = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.c);
        this.o = c;
        if (c == null) {
            this.o = com.anythink.expressad.d.c.c(this.c);
        }
        if (this.k == -1) {
            int b2 = this.o.b();
            if (b2 > 0) {
                if (b2 < 10) {
                    b2 = 10;
                } else if (b2 > 180) {
                    b2 = 180;
                }
            }
            this.j = b2;
        }
        if (this.f == 0) {
            boolean z = this.o.d() == 1;
            this.e = z;
            com.anythink.expressad.mbbanner.a.d.c cVar = this.n;
            if (cVar != null) {
                cVar.a(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.r || !this.f250s) {
            return;
        }
        if (this.m != null) {
            if (this.n == null) {
                this.n = new com.anythink.expressad.mbbanner.a.d.c(this.g, this.u, this.d, this.c, this.e, this.o);
            }
            this.n.a(this.a);
            this.n.b(this.p);
            this.n.c(this.q);
            this.n.a(this.e, this.f);
            this.n.a(this.m);
        } else {
            a(com.anythink.expressad.mbbanner.a.a.h);
        }
        this.f250s = false;
    }

    private static boolean i() {
        return true;
    }

    private static void j() {
    }

    private void k() {
        com.anythink.expressad.out.TemplateBannerView templateBannerView = this.g;
        if (templateBannerView != null) {
            if (!this.p || !this.q || this.t || com.anythink.expressad.foundation.h.y.a(templateBannerView)) {
                com.anythink.expressad.mbbanner.a.d.a.a().a(2, this.c);
            } else {
                com.anythink.expressad.mbbanner.a.d.a a = com.anythink.expressad.mbbanner.a.d.a.a();
                java.lang.String str = this.c;
                new com.anythink.expressad.mbbanner.a.b.d(this.i + "x" + this.h, this.j * 1000);
                a.a(3, str);
            }
            if (this.p) {
                return;
            }
            com.anythink.expressad.mbbanner.a.d.a.a().a(4, this.c);
            com.anythink.expressad.mbbanner.a.d.a.a().a(this.c);
        }
    }

    private void l() {
        k();
        com.anythink.expressad.mbbanner.a.d.c cVar = this.n;
        if (cVar != null) {
            cVar.b(this.p);
            this.n.c(this.q);
        }
    }

    public final java.lang.String a() {
        com.anythink.expressad.foundation.d.d dVar = this.m;
        return (dVar == null || dVar.f() == null) ? "" : this.m.f();
    }

    public final void a(int i, int i2, int i3, int i4) {
        com.anythink.expressad.mbbanner.a.d.c cVar = this.n;
        if (cVar != null) {
            cVar.a(i, i2, i3, i4);
        }
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        this.m = dVar;
        com.anythink.expressad.mbbanner.a.d.a.a().a(this.c, dVar, this.v);
    }

    public final void a(com.anythink.expressad.out.h hVar) {
        this.l = hVar;
    }

    public final void a(com.anythink.expressad.out.i iVar) {
        if (iVar != null) {
            this.h = iVar.a();
            this.i = iVar.b();
        }
    }

    public final void a(boolean z) {
        this.e = z;
        this.f = z ? 1 : 2;
    }

    public final void b() {
        this.r = true;
        if (this.l != null) {
            this.l = null;
        }
        if (this.v != null) {
            this.v = null;
        }
        if (this.u != null) {
            this.u = null;
        }
        if (this.g != null) {
            this.g = null;
        }
        com.anythink.expressad.mbbanner.a.d.a.a().a(4, this.c);
        com.anythink.expressad.mbbanner.a.d.a.a().a(this.c);
        com.anythink.expressad.mbbanner.a.d.a.a().b();
        com.anythink.expressad.mbbanner.a.d.c cVar = this.n;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void b(boolean z) {
        this.p = z;
        l();
        h();
    }

    public final void c() {
        com.anythink.expressad.mbbanner.a.d.a a = com.anythink.expressad.mbbanner.a.d.a.a();
        java.lang.String str = this.c;
        new com.anythink.expressad.mbbanner.a.b.d(this.i + "x" + this.h, this.j * 1000);
        a.a(4, str);
    }

    public final void c(boolean z) {
        this.q = z;
        l();
    }

    public final void d() {
        com.anythink.expressad.mbbanner.a.d.a a = com.anythink.expressad.mbbanner.a.d.a.a();
        java.lang.String str = this.c;
        new com.anythink.expressad.mbbanner.a.b.d(this.i + "x" + this.h, this.j * 1000);
        a.a(3, str);
    }
}
