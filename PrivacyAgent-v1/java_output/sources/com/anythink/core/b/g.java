package com.anythink.core.b;

/* loaded from: classes12.dex */
public final class g extends com.anythink.core.b.e {
    public g(com.anythink.core.common.f.a aVar) {
        super(aVar);
    }

    @Override // com.anythink.core.b.e
    public final void a(java.util.List<org.json.JSONObject> list, com.anythink.core.common.h.k kVar) {
        com.anythink.core.b.a.b bVar = new com.anythink.core.b.a.b();
        bVar.f = this.f.n.a().aC();
        com.anythink.core.b.a.a aVar = new com.anythink.core.b.a.a(this.p, this.o, this.n, list, 1, this.f.n.a());
        aVar.a(bVar);
        aVar.a(0, kVar);
    }

    @Override // com.anythink.core.b.e
    public final java.lang.String b() {
        return this.f.p;
    }
}
