package com.anythink.basead.a.b;

/* loaded from: classes12.dex */
final class e extends com.anythink.core.common.res.image.b {
    private java.lang.String a;
    private boolean b;
    private boolean j;
    private java.lang.String k;
    private int l;
    private com.anythink.core.common.f.l m;

    public e(java.lang.String str, boolean z, com.anythink.core.common.f.l lVar, java.lang.String str2) {
        super(str2);
        this.m = lVar;
        this.a = str;
        this.b = z;
        this.j = android.text.TextUtils.equals(lVar.A(), str2);
        this.k = lVar.s();
        this.l = lVar.d();
    }

    @Override // com.anythink.core.common.res.image.b
    public final java.util.Map<java.lang.String, java.lang.String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    public final void a(com.anythink.core.common.o.b.d dVar) {
        if (this.b) {
            com.anythink.core.common.o.b.b.a().a(dVar, 5);
        } else {
            com.anythink.core.common.o.b.b.a().a(dVar, 4);
        }
    }

    @Override // com.anythink.core.common.res.image.b
    public final void a(java.lang.String str, java.lang.String str2) {
        if (this.j) {
            com.anythink.core.common.n.c.a(this.a, this.k, this.c, "0", this.i, str2, this.e, 0L, this.l, this.h - this.f);
        }
        com.anythink.basead.a.b.d.a().a(this.c, com.anythink.basead.c.f.a(str, str2));
    }

    @Override // com.anythink.core.common.res.image.b
    public final boolean a(java.io.InputStream inputStream) {
        com.anythink.basead.a.e.a();
        return com.anythink.basead.a.e.a(this.c, inputStream);
    }

    @Override // com.anythink.core.common.res.image.b
    public final void b() {
    }

    @Override // com.anythink.core.common.res.image.b
    public final void c() {
        if (this.j) {
            com.anythink.basead.a.a.a(30, this.m, new com.anythink.basead.c.i("", ""));
            com.anythink.core.common.n.c.a(this.a, this.k, this.c, "1", this.i, (java.lang.String) null, this.e, this.g, this.l, this.h - this.f);
        }
        com.anythink.basead.a.b.d.a().a(this.c, 100);
    }
}
