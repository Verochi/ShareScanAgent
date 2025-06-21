package com.jd.ad.sdk.jad_zk;

/* loaded from: classes23.dex */
public class jad_an implements com.jd.ad.sdk.jad_zk.jad_ly {
    public final java.util.Set<com.jd.ad.sdk.jad_zk.jad_mz> jad_an = java.util.Collections.newSetFromMap(new java.util.WeakHashMap());
    public boolean jad_bo;
    public boolean jad_cp;

    public void jad_an() {
        this.jad_cp = true;
        java.util.Iterator it = ((java.util.ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an)).iterator();
        while (it.hasNext()) {
            ((com.jd.ad.sdk.jad_zk.jad_mz) it.next()).jad_dq();
        }
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_ly
    public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_zk.jad_mz jad_mzVar) {
        this.jad_an.remove(jad_mzVar);
    }

    public void jad_bo() {
        this.jad_bo = true;
        java.util.Iterator it = ((java.util.ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an)).iterator();
        while (it.hasNext()) {
            ((com.jd.ad.sdk.jad_zk.jad_mz) it.next()).jad_cp();
        }
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_ly
    public void jad_bo(@androidx.annotation.NonNull com.jd.ad.sdk.jad_zk.jad_mz jad_mzVar) {
        this.jad_an.add(jad_mzVar);
        if (this.jad_cp) {
            jad_mzVar.jad_dq();
        } else if (this.jad_bo) {
            jad_mzVar.jad_cp();
        } else {
            jad_mzVar.jad_an();
        }
    }

    public void jad_cp() {
        this.jad_bo = false;
        java.util.Iterator it = ((java.util.ArrayList) com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an)).iterator();
        while (it.hasNext()) {
            ((com.jd.ad.sdk.jad_zk.jad_mz) it.next()).jad_an();
        }
    }
}
