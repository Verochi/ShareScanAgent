package com.anythink.core.common.a;

/* loaded from: classes12.dex */
public class c {
    private static volatile com.anythink.core.common.a.c b;
    final java.lang.String a = com.anythink.core.common.a.c.class.getName();
    private com.anythink.core.common.c.f c;
    private com.anythink.core.common.c.e d;

    /* renamed from: com.anythink.core.common.a.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.j a;

        public AnonymousClass1(com.anythink.core.common.f.j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.a.g gVar = new com.anythink.core.common.a.g();
            gVar.a = this.a.Z();
            gVar.b = this.a.aa();
            gVar.c = this.a.ab();
            gVar.d = 0;
            com.anythink.core.common.a.c.this.c.a(gVar);
        }
    }

    /* renamed from: com.anythink.core.common.a.c$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.j a;

        public AnonymousClass2(com.anythink.core.common.f.j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.a.g gVar = new com.anythink.core.common.a.g();
            gVar.a = this.a.Z();
            gVar.b = this.a.aa();
            gVar.c = this.a.ab();
            gVar.d = 1;
            com.anythink.core.common.a.c.this.c.b(gVar);
        }
    }

    /* renamed from: com.anythink.core.common.a.c$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.a.c.this.c.c();
        }
    }

    /* renamed from: com.anythink.core.common.a.c$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.j a;

        public AnonymousClass4(com.anythink.core.common.f.j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.aa();
            com.anythink.core.common.a.f fVar = new com.anythink.core.common.a.f();
            fVar.a = this.a.Z();
            fVar.b = this.a.aa();
            fVar.c = this.a.E();
            com.anythink.core.common.a.c.this.d.a(fVar);
        }
    }

    private c() {
        if (com.anythink.core.common.b.o.a().f() != null) {
            this.c = com.anythink.core.common.c.f.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f()));
            this.d = com.anythink.core.common.c.e.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f()));
        }
    }

    public static com.anythink.core.common.a.c a() {
        if (b == null) {
            synchronized (com.anythink.core.common.a.c.class) {
                if (b == null) {
                    b = new com.anythink.core.common.a.c();
                }
            }
        }
        return b;
    }

    public final java.util.List<com.anythink.core.common.a.e> a(int i) {
        return this.c.a(i);
    }

    public final void a(com.anythink.core.common.f.j jVar) {
        jVar.aa();
        com.anythink.core.common.b.o.a();
        com.anythink.core.common.b.o.c(new com.anythink.core.common.a.c.AnonymousClass1(jVar));
    }

    public final java.util.List<com.anythink.core.common.a.e> b(int i) {
        return this.d.a(i);
    }

    public final void b() {
        com.anythink.core.common.b.o.a();
        com.anythink.core.common.b.o.c(new com.anythink.core.common.a.c.AnonymousClass3());
    }

    public final void b(com.anythink.core.common.f.j jVar) {
        jVar.aa();
        com.anythink.core.common.b.o.a();
        com.anythink.core.common.b.o.c(new com.anythink.core.common.a.c.AnonymousClass2(jVar));
    }

    public final void c(com.anythink.core.common.f.j jVar) {
        if (jVar.ac() != 1) {
            jVar.ac();
        } else if (jVar.G() != 1 && jVar.G() != 4) {
            jVar.G();
        } else {
            com.anythink.core.common.b.o.a();
            com.anythink.core.common.b.o.c(new com.anythink.core.common.a.c.AnonymousClass4(jVar));
        }
    }
}
