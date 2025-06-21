package com.anythink.splashad.a;

/* loaded from: classes12.dex */
public final class e implements com.anythink.core.common.j.e {
    com.anythink.splashad.a.f a;

    @Override // com.anythink.core.common.j.e
    public final com.anythink.core.common.f.b a(java.lang.String str, boolean z, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.common.f.c cVar) {
        com.anythink.core.common.f.b bVar;
        com.anythink.splashad.a.f fVar = this.a;
        com.anythink.core.common.f.b bVar2 = (fVar == null || (bVar = fVar.d) == null || bVar.c() > 0) ? null : fVar.d;
        if (bVar2 == null) {
            return null;
        }
        com.anythink.core.common.f.h h = bVar2.h();
        if (z) {
            com.anythink.core.common.n.c.a(h.ad(), str, true, -1, (com.anythink.core.d.e) null, bVar2, "", "", map, cVar);
        }
        return bVar2;
    }

    @Override // com.anythink.core.common.j.e
    public final void a(com.anythink.core.common.f.b bVar) {
        com.anythink.splashad.a.f fVar = this.a;
        if (fVar == null || fVar.d != bVar) {
            return;
        }
        fVar.d = null;
    }

    @Override // com.anythink.core.common.j.e
    public final boolean a() {
        com.anythink.splashad.a.f fVar = this.a;
        return fVar != null && fVar.a();
    }

    @Override // com.anythink.core.common.j.e
    public final boolean a(android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.common.f.v vVar, com.anythink.core.common.n nVar) {
        com.anythink.splashad.a.f fVar = new com.anythink.splashad.a.f(context);
        this.a = fVar;
        fVar.a(vVar.a(), str, str2, vVar, nVar);
        return true;
    }

    @Override // com.anythink.core.common.j.e
    public final boolean b() {
        com.anythink.splashad.a.f fVar = this.a;
        return (fVar == null || android.text.TextUtils.isEmpty(fVar.e)) ? false : true;
    }
}
