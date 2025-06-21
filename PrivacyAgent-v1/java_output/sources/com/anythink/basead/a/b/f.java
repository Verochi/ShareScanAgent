package com.anythink.basead.a.b;

/* loaded from: classes12.dex */
public class f {
    final java.lang.String a = com.anythink.basead.a.b.f.class.getSimpleName();
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private int e;
    private com.anythink.core.common.f.l f;
    private com.anythink.core.common.f.n g;
    private com.anythink.core.common.res.a.a h;

    /* renamed from: com.anythink.basead.a.b.f$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.core.common.res.a.a.AbstractC0171a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.core.common.res.a.a.AbstractC0171a
        public final void a(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.a.a.AbstractC0171a
        public final boolean a(int i, long j, long j2) {
            if (i < com.anythink.basead.a.b.f.this.g.W()) {
                return false;
            }
            com.anythink.basead.a.b.d.a().a(com.anythink.basead.a.b.f.this.b, i);
            return true;
        }
    }

    /* renamed from: com.anythink.basead.a.b.f$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.core.common.res.a.a.b {
        final /* synthetic */ com.anythink.core.common.f.l a;

        public AnonymousClass2(com.anythink.core.common.f.l lVar) {
            this.a = lVar;
        }

        @Override // com.anythink.core.common.res.a.a.b
        public final void a(long j, long j2, long j3, long j4, long j5) {
            com.anythink.basead.a.a.a(30, this.a, new com.anythink.basead.c.i("", ""));
            com.anythink.core.common.n.c.a(com.anythink.basead.a.b.f.this.c, com.anythink.basead.a.b.f.this.d, com.anythink.basead.a.b.f.this.b, "1", j, (java.lang.String) null, j2, j3, com.anythink.basead.a.b.f.this.e, j5 - j4);
        }

        @Override // com.anythink.core.common.res.a.a.b
        public final void a(java.lang.String str, java.lang.String str2, long j, long j2, long j3, long j4) {
            com.anythink.core.common.n.c.a(com.anythink.basead.a.b.f.this.c, com.anythink.basead.a.b.f.this.d, com.anythink.basead.a.b.f.this.b, "0", j, str2, j2, 0L, com.anythink.basead.a.b.f.this.e, j4 - j3);
            com.anythink.basead.a.b.d.a().a(com.anythink.basead.a.b.f.this.b, com.anythink.basead.c.f.a(str, str2));
        }
    }

    public f(java.lang.String str, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.n nVar) {
        this.b = lVar.A();
        this.f = lVar;
        this.g = nVar;
        this.c = str;
        this.d = lVar.s();
        this.e = lVar.d();
        com.anythink.core.common.res.a.a a = com.anythink.core.common.res.a.c.a().a(this.b);
        this.h = a;
        a.a(new com.anythink.core.common.res.a.b(this.g.W(), this.g.Y()));
        this.h.a(new com.anythink.basead.a.b.f.AnonymousClass1());
        this.h.k = new com.anythink.basead.a.b.f.AnonymousClass2(lVar);
    }

    public final void a() {
        this.h.e();
    }

    public final void b() {
        int b = com.anythink.core.common.a.k.a().b(this.b);
        this.g.X();
        if (b == 100) {
            return;
        }
        this.h.f();
    }
}
