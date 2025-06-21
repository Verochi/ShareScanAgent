package com.getui.gtc.extension.distribution.gbd.n.d.e;

/* loaded from: classes22.dex */
public final class e {
    private com.getui.gtc.extension.distribution.gbd.n.d.e.f a;

    public e(com.getui.gtc.extension.distribution.gbd.n.d.e.f fVar) {
        this.a = fVar;
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        int i = 0;
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar2 = iVar;
        while (iVar2 != null) {
            this.a.a(iVar2, i);
            if (java.util.Collections.unmodifiableList(iVar2.e).size() > 0) {
                iVar2 = iVar2.q();
                i++;
            } else {
                while (iVar2.u() == null && i > 0) {
                    this.a.b(iVar2, i);
                    iVar2 = iVar2.o();
                    i--;
                }
                this.a.b(iVar2, i);
                if (iVar2 == iVar) {
                    return;
                } else {
                    iVar2 = iVar2.u();
                }
            }
        }
    }
}
