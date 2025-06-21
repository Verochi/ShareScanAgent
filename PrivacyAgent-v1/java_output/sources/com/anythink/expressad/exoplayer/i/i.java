package com.anythink.expressad.exoplayer.i;

/* loaded from: classes12.dex */
public final class i {
    public final int a;
    public final com.anythink.expressad.exoplayer.aa[] b;
    public final com.anythink.expressad.exoplayer.i.g c;
    public final java.lang.Object d;

    public i(com.anythink.expressad.exoplayer.aa[] aaVarArr, com.anythink.expressad.exoplayer.i.f[] fVarArr, java.lang.Object obj) {
        this.b = aaVarArr;
        this.c = new com.anythink.expressad.exoplayer.i.g(fVarArr);
        this.d = obj;
        this.a = aaVarArr.length;
    }

    public final boolean a(int i) {
        return this.b[i] != null;
    }

    public final boolean a(com.anythink.expressad.exoplayer.i.i iVar) {
        if (iVar == null || iVar.c.a != this.c.a) {
            return false;
        }
        for (int i = 0; i < this.c.a; i++) {
            if (!a(iVar, i)) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(com.anythink.expressad.exoplayer.i.i iVar, int i) {
        return iVar != null && com.anythink.expressad.exoplayer.k.af.a(this.b[i], iVar.b[i]) && com.anythink.expressad.exoplayer.k.af.a(this.c.a(i), iVar.c.a(i));
    }
}
