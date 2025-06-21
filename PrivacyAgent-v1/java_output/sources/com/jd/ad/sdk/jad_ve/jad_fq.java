package com.jd.ad.sdk.jad_ve;

/* loaded from: classes23.dex */
public class jad_fq implements com.jd.ad.sdk.jad_ve.jad_mx<com.jd.ad.sdk.jad_yh.jad_dq> {
    public static final com.jd.ad.sdk.jad_ve.jad_fq jad_an = new com.jd.ad.sdk.jad_ve.jad_fq();

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public com.jd.ad.sdk.jad_yh.jad_dq jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        boolean z = jad_cpVar.jad_mz() == 1;
        if (z) {
            jad_cpVar.jad_bo();
        }
        float jad_iv = (float) jad_cpVar.jad_iv();
        float jad_iv2 = (float) jad_cpVar.jad_iv();
        while (jad_cpVar.jad_jt()) {
            jad_cpVar.jad_ob();
        }
        if (z) {
            jad_cpVar.jad_dq();
        }
        return new com.jd.ad.sdk.jad_yh.jad_dq((jad_iv / 100.0f) * f, (jad_iv2 / 100.0f) * f);
    }
}
