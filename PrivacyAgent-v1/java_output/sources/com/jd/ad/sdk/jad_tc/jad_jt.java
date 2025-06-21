package com.jd.ad.sdk.jad_tc;

/* loaded from: classes23.dex */
public class jad_jt extends com.jd.ad.sdk.jad_tc.jad_an {
    public final com.jd.ad.sdk.jad_nw.jad_dq jad_do;
    public final com.jd.ad.sdk.jad_tc.jad_bo jad_ep;

    public jad_jt(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_er jad_erVar, com.jd.ad.sdk.jad_tc.jad_bo jad_boVar) {
        super(jad_mzVar, jad_erVar);
        this.jad_ep = jad_boVar;
        com.jd.ad.sdk.jad_nw.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_nw.jad_dq(jad_mzVar, this, new com.jd.ad.sdk.jad_sb.jad_pc("__container", jad_erVar.jad_jt(), false));
        this.jad_do = jad_dqVar;
        jad_dqVar.jad_an(java.util.Collections.emptyList(), java.util.Collections.emptyList());
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an, com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        super.jad_an(rectF, matrix, z);
        this.jad_do.jad_an(rectF, this.jad_mz, z);
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an
    public void jad_bo(@androidx.annotation.NonNull android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        this.jad_do.jad_an(canvas, matrix, i);
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an
    public void jad_bo(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, java.util.List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        this.jad_do.jad_an(jad_erVar, i, list, jad_erVar2);
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an
    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_sb.jad_an jad_er() {
        com.jd.ad.sdk.jad_sb.jad_an jad_anVar = this.jad_ob.jad_wj;
        return jad_anVar != null ? jad_anVar : this.jad_ep.jad_ob.jad_wj;
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an
    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ve.jad_jw jad_fs() {
        com.jd.ad.sdk.jad_ve.jad_jw jad_jwVar = this.jad_ob.jad_xk;
        return jad_jwVar != null ? jad_jwVar : this.jad_ep.jad_ob.jad_xk;
    }
}
