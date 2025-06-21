package com.anythink.expressad.video.signal.a;

/* loaded from: classes12.dex */
public class c implements com.anythink.expressad.video.signal.c {
    protected static final java.lang.String d = "DefaultJSCommon";
    protected java.lang.String n;
    protected com.anythink.expressad.videocommon.e.d o;
    protected com.anythink.expressad.videocommon.c.c p;
    protected com.anythink.expressad.a.a q;
    protected boolean e = false;
    protected boolean f = false;
    protected int g = 0;
    protected int h = 0;
    protected int i = 0;
    protected int j = 0;
    protected int k = 0;
    protected int l = 1;
    protected int m = -1;
    public com.anythink.expressad.video.signal.c.a r = new com.anythink.expressad.video.signal.a.c.a();

    /* renamed from: s, reason: collision with root package name */
    protected int f278s = 2;

    public static class a implements com.anythink.expressad.video.signal.c.a {
        @Override // com.anythink.expressad.video.signal.c.a
        public void a(int i, java.lang.String str) {
        }

        @Override // com.anythink.expressad.out.p.c
        public void a(com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
            java.util.Objects.toString(cVar);
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar) {
            java.util.Objects.toString(jVar);
        }

        @Override // com.anythink.expressad.out.p.c
        public void a(com.anythink.expressad.out.j jVar, java.lang.String str) {
            java.util.Objects.toString(jVar);
        }

        @Override // com.anythink.expressad.out.p.c
        public final boolean a() {
            return false;
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b() {
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar) {
            java.util.Objects.toString(jVar);
        }

        @Override // com.anythink.expressad.out.p.c
        public void b(com.anythink.expressad.out.j jVar, java.lang.String str) {
            java.util.Objects.toString(jVar);
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public void c() {
        }

        @Override // com.anythink.expressad.out.p.c
        public final void c(com.anythink.expressad.out.j jVar) {
            java.util.Objects.toString(jVar);
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public void d() {
        }

        @Override // com.anythink.expressad.out.p.c
        public final void d(com.anythink.expressad.out.j jVar) {
            java.util.Objects.toString(jVar);
        }
    }

    public static class b implements com.anythink.expressad.video.signal.c.a {
        private com.anythink.expressad.video.signal.c a;
        private com.anythink.expressad.video.signal.c.a b;

        public b(com.anythink.expressad.video.signal.c cVar, com.anythink.expressad.video.signal.c.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public final void a(int i, java.lang.String str) {
            com.anythink.expressad.video.signal.c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(i, str);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
            com.anythink.expressad.video.signal.c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(cVar, str);
            }
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
            com.anythink.expressad.video.signal.c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(cVar, z);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar) {
            com.anythink.expressad.video.signal.c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(jVar);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar, java.lang.String str) {
            com.anythink.expressad.video.signal.c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(jVar, str);
            }
            com.anythink.expressad.video.signal.c cVar = this.a;
            if (cVar != null) {
                cVar.j();
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final boolean a() {
            com.anythink.expressad.video.signal.c.a aVar = this.b;
            return aVar != null && aVar.a();
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b() {
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar) {
            com.anythink.expressad.video.signal.c.a aVar = this.b;
            if (aVar != null) {
                aVar.b(jVar);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar, java.lang.String str) {
            com.anythink.expressad.video.signal.c.a aVar = this.b;
            if (aVar != null) {
                aVar.b(jVar, str);
            }
            com.anythink.expressad.video.signal.c cVar = this.a;
            if (cVar != null) {
                cVar.j();
            }
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public final void c() {
            com.anythink.expressad.video.signal.c.a aVar = this.b;
            if (aVar != null) {
                aVar.c();
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void c(com.anythink.expressad.out.j jVar) {
            com.anythink.expressad.video.signal.c.a aVar = this.b;
            if (aVar != null) {
                aVar.c(jVar);
            }
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public final void d() {
            com.anythink.expressad.video.signal.c.a aVar = this.b;
            if (aVar != null) {
                aVar.d();
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void d(com.anythink.expressad.out.j jVar) {
            com.anythink.expressad.video.signal.c.a aVar = this.b;
            if (aVar != null) {
                aVar.d(jVar);
            }
        }
    }

    private void a(com.anythink.expressad.videocommon.c.c cVar) {
        this.p = cVar;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(int i) {
        this.f278s = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public void a(int i, java.lang.String str) {
    }

    @Override // com.anythink.expressad.video.signal.c
    public void a(android.app.Activity activity) {
    }

    @Override // com.anythink.expressad.video.signal.c
    public void a(android.content.Context context) {
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(com.anythink.expressad.video.signal.c.a aVar) {
        java.util.Objects.toString(aVar);
        this.r = aVar;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(com.anythink.expressad.videocommon.e.d dVar) {
        java.util.Objects.toString(dVar);
        this.o = dVar;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(java.lang.String str) {
        this.n = str;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(boolean z) {
        this.f = z;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final boolean a() {
        return this.f;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int b() {
        if (this.h == 0 && this.f) {
            this.h = 1;
        }
        return this.h;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void b(int i) {
        this.h = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public void b(java.lang.String str) {
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int c() {
        if (this.g == 0 && this.f) {
            this.g = 1;
        }
        return this.g;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void c(int i) {
        this.g = i;
    }

    @Override // com.anythink.expressad.video.signal.d
    public void click(int i, java.lang.String str) {
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int d() {
        if (this.i == 0 && this.f) {
            this.i = 1;
        }
        return this.i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void d(int i) {
        this.i = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int e() {
        return this.j;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void e(int i) {
        this.j = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int f() {
        return this.k;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void f(int i) {
        this.k = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void g(int i) {
        this.m = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final boolean g() {
        return this.e;
    }

    @Override // com.anythink.expressad.video.signal.c
    public java.lang.String h(int i) {
        return "{}";
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void h() {
        this.e = true;
    }

    @Override // com.anythink.expressad.video.signal.d
    public void handlerH5Exception(int i, java.lang.String str) {
    }

    @Override // com.anythink.expressad.video.signal.c
    public java.lang.String i() {
        return "{}";
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void i(int i) {
        this.l = i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public void j() {
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void k() {
        com.anythink.expressad.a.a aVar = this.q;
        if (aVar != null) {
            aVar.a();
            this.q.a((com.anythink.expressad.out.p.c) null);
            this.q.b();
        }
    }

    @Override // com.anythink.expressad.video.signal.c
    public void l() {
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int m() {
        return this.m;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int n() {
        return this.l;
    }

    @Override // com.anythink.expressad.video.signal.c
    public java.lang.String o() {
        return null;
    }
}
