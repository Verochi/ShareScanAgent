package com.jd.ad.sdk.jad_xi;

/* loaded from: classes23.dex */
public class jad_er extends com.jd.ad.sdk.jad_vg.jad_cp<com.jd.ad.sdk.jad_xi.jad_cp> {
    public jad_er(com.jd.ad.sdk.jad_xi.jad_cp jad_cpVar) {
        super(jad_cpVar);
    }

    @Override // com.jd.ad.sdk.jad_vg.jad_cp, com.jd.ad.sdk.jad_mx.jad_tg
    public void jad_an() {
        ((com.jd.ad.sdk.jad_xi.jad_cp) this.jad_an).jad_bo().prepareToDraw();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public int jad_bo() {
        com.jd.ad.sdk.jad_xi.jad_jt jad_jtVar = ((com.jd.ad.sdk.jad_xi.jad_cp) this.jad_an).jad_an.jad_an;
        return jad_jtVar.jad_an.jad_cp() + jad_jtVar.jad_ob;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @androidx.annotation.NonNull
    public java.lang.Class<com.jd.ad.sdk.jad_xi.jad_cp> jad_cp() {
        return com.jd.ad.sdk.jad_xi.jad_cp.class;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public void jad_dq() {
        ((com.jd.ad.sdk.jad_xi.jad_cp) this.jad_an).stop();
        com.jd.ad.sdk.jad_xi.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_xi.jad_cp) this.jad_an;
        jad_cpVar.jad_dq = true;
        com.jd.ad.sdk.jad_xi.jad_jt jad_jtVar = jad_cpVar.jad_an.jad_an;
        jad_jtVar.jad_cp.clear();
        android.graphics.Bitmap bitmap = jad_jtVar.jad_ly;
        if (bitmap != null) {
            jad_jtVar.jad_er.jad_an(bitmap);
            jad_jtVar.jad_ly = null;
        }
        jad_jtVar.jad_fs = false;
        com.jd.ad.sdk.jad_xi.jad_jt.jad_an jad_anVar = jad_jtVar.jad_iv;
        if (jad_anVar != null) {
            jad_jtVar.jad_dq.jad_an(jad_anVar);
            jad_jtVar.jad_iv = null;
        }
        com.jd.ad.sdk.jad_xi.jad_jt.jad_an jad_anVar2 = jad_jtVar.jad_kx;
        if (jad_anVar2 != null) {
            jad_jtVar.jad_dq.jad_an(jad_anVar2);
            jad_jtVar.jad_kx = null;
        }
        com.jd.ad.sdk.jad_xi.jad_jt.jad_an jad_anVar3 = jad_jtVar.jad_na;
        if (jad_anVar3 != null) {
            jad_jtVar.jad_dq.jad_an(jad_anVar3);
            jad_jtVar.jad_na = null;
        }
        jad_jtVar.jad_an.clear();
        jad_jtVar.jad_jw = true;
    }
}
