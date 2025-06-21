package com.anythink.basead.e;

/* loaded from: classes12.dex */
public abstract class e implements com.anythink.basead.e.a {
    com.anythink.core.common.f.l a;
    com.anythink.core.common.f.h b;

    public e(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.h hVar) {
        this.a = lVar;
        this.b = hVar;
    }

    private void a() {
        com.anythink.core.common.f.l lVar = this.a;
        if (lVar instanceof com.anythink.core.common.f.j) {
            com.anythink.core.common.f.j jVar = (com.anythink.core.common.f.j) lVar;
            if (jVar.c() == 1) {
                com.anythink.core.common.a.c.a().b(jVar);
            }
        }
    }

    @Override // com.anythink.basead.e.a
    public void onAdClick(com.anythink.basead.e.i iVar) {
        com.anythink.core.common.f.h hVar = this.b;
        if (hVar != null) {
            hVar.B(iVar.a);
            this.b.C(iVar.b);
        }
    }

    @Override // com.anythink.basead.e.a
    public void onAdShow(com.anythink.basead.e.i iVar) {
        com.anythink.core.common.f.l lVar = this.a;
        if (lVar instanceof com.anythink.core.common.f.j) {
            com.anythink.core.common.f.j jVar = (com.anythink.core.common.f.j) lVar;
            if (jVar.c() == 1) {
                com.anythink.core.common.a.c.a().b(jVar);
            }
        }
    }

    public void updateTrackingInfo(com.anythink.core.common.f.h hVar) {
        this.b = hVar;
    }
}
