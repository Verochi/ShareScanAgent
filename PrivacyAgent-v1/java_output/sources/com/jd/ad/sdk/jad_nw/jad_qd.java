package com.jd.ad.sdk.jad_nw;

/* loaded from: classes23.dex */
public class jad_qd implements com.jd.ad.sdk.jad_nw.jad_mz, com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an {
    public final java.lang.String jad_bo;
    public final boolean jad_cp;
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_dq;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, android.graphics.Path> jad_er;
    public boolean jad_fs;
    public final android.graphics.Path jad_an = new android.graphics.Path();
    public final com.jd.ad.sdk.jad_nw.jad_bo jad_jt = new com.jd.ad.sdk.jad_nw.jad_bo();

    public jad_qd(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_qd jad_qdVar) {
        this.jad_bo = jad_qdVar.jad_an();
        this.jad_cp = jad_qdVar.jad_cp();
        this.jad_dq = jad_mzVar;
        com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_sb.jad_na, android.graphics.Path> jad_an = jad_qdVar.jad_bo().jad_an();
        this.jad_er = jad_an;
        jad_anVar.jad_an(jad_an);
        jad_an.jad_an(this);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an
    public void jad_an() {
        this.jad_fs = false;
        this.jad_dq.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(java.util.List<com.jd.ad.sdk.jad_nw.jad_cp> list, java.util.List<com.jd.ad.sdk.jad_nw.jad_cp> list2) {
        for (int i = 0; i < list.size(); i++) {
            com.jd.ad.sdk.jad_nw.jad_cp jad_cpVar = list.get(i);
            if (jad_cpVar instanceof com.jd.ad.sdk.jad_nw.jad_sf) {
                com.jd.ad.sdk.jad_nw.jad_sf jad_sfVar = (com.jd.ad.sdk.jad_nw.jad_sf) jad_cpVar;
                if (jad_sfVar.jad_dq == 1) {
                    this.jad_jt.jad_an.add(jad_sfVar);
                    jad_sfVar.jad_cp.add(this);
                }
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_mz
    public android.graphics.Path jad_bo() {
        if (this.jad_fs) {
            return this.jad_an;
        }
        this.jad_an.reset();
        if (!this.jad_cp) {
            android.graphics.Path jad_fs = this.jad_er.jad_fs();
            if (jad_fs == null) {
                return this.jad_an;
            }
            this.jad_an.set(jad_fs);
            this.jad_an.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            this.jad_jt.jad_an(this.jad_an);
        }
        this.jad_fs = true;
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public java.lang.String jad_cp() {
        return this.jad_bo;
    }
}
