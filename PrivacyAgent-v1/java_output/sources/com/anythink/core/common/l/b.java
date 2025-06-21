package com.anythink.core.common.l;

/* loaded from: classes12.dex */
public class b {
    private static final java.lang.String l = "b";
    java.lang.String a;
    com.anythink.core.common.l.e b;
    int c;
    com.anythink.core.common.l.c d;
    int e;
    boolean f;
    long g;
    java.lang.String h;
    boolean i;
    java.lang.Boolean j;
    com.anythink.core.common.m.b k;

    /* renamed from: com.anythink.core.common.l.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.m.b {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.l.b.this.k();
        }
    }

    /* renamed from: com.anythink.core.common.l.b$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.b.b {
        public AnonymousClass2() {
        }

        @Override // com.anythink.core.common.b.b
        public final void onAdLoadFail(com.anythink.core.api.AdError adError) {
            com.anythink.core.common.l.b.this.a(adError);
        }

        @Override // com.anythink.core.common.b.b
        public final void onAdLoaded() {
            com.anythink.core.common.l.b.this.j();
        }
    }

    public b(java.lang.String str) {
        this.a = str;
        this.h = str + "_" + hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.anythink.core.api.AdError adError) {
        this.b.toString();
        h();
        com.anythink.core.common.l.c cVar = this.d;
        if (cVar != null) {
            cVar.a(this.h, this.b, adError);
        }
    }

    private void a(java.lang.Boolean bool) {
        this.j = bool;
    }

    private java.lang.Boolean f() {
        return this.j;
    }

    private void g() {
        if (this.f && this.g != -1) {
            this.k = new com.anythink.core.common.l.b.AnonymousClass1();
            com.anythink.core.common.m.d.a().a(this.k, this.g, false);
        }
    }

    private void h() {
        if (this.k != null) {
            this.b.toString();
            com.anythink.core.common.m.d.a().b(this.k);
        }
    }

    private com.anythink.core.common.f i() {
        return com.anythink.core.common.f.a(com.anythink.core.common.b.o.a().f(), this.a, java.lang.String.valueOf(this.e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        this.b.toString();
        h();
        com.anythink.core.common.l.c cVar = this.d;
        if (cVar != null) {
            cVar.a(this.h, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() {
        this.b.toString();
        com.anythink.core.common.l.c cVar = this.d;
        if (cVar != null) {
            cVar.b(this.h, this.b);
        }
    }

    public final java.lang.String a() {
        return this.h;
    }

    public final void a(com.anythink.core.common.l.a aVar) {
        com.anythink.core.common.l.e eVar = aVar.a;
        this.b = eVar;
        this.c = aVar.b;
        this.e = eVar.a;
        this.d = aVar.e;
        this.f = aVar.c;
        this.g = aVar.d;
    }

    public final boolean b() {
        return this.j == null || !this.i;
    }

    public final void c() {
        com.anythink.core.common.l.e eVar = this.b;
        if (eVar != null) {
            eVar.toString();
        }
        com.anythink.core.common.f a = com.anythink.core.common.f.a(com.anythink.core.common.b.o.a().f(), this.a, java.lang.String.valueOf(this.e));
        if (this.f && this.g != -1) {
            this.k = new com.anythink.core.common.l.b.AnonymousClass1();
            com.anythink.core.common.m.d.a().a(this.k, this.g, false);
        }
        com.anythink.core.common.f.v vVar = new com.anythink.core.common.f.v();
        vVar.a(com.anythink.core.common.b.o.a().E());
        vVar.d = this.c;
        a.a(com.anythink.core.common.b.o.a().f(), java.lang.String.valueOf(this.e), this.a, vVar, new com.anythink.core.common.l.b.AnonymousClass2());
    }

    public final int d() {
        return this.c;
    }

    public final java.lang.String e() {
        return this.a;
    }
}
