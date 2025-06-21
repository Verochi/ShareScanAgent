package com.jd.ad.sdk.jad_ve;

/* loaded from: classes23.dex */
public class jad_jt implements com.jd.ad.sdk.jad_ve.jad_mx<java.lang.Integer> {
    public static final com.jd.ad.sdk.jad_ve.jad_jt jad_an = new com.jd.ad.sdk.jad_ve.jad_jt();

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public java.lang.Integer jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        boolean z = jad_cpVar.jad_mz() == 1;
        if (z) {
            jad_cpVar.jad_bo();
        }
        double jad_iv = jad_cpVar.jad_iv();
        double jad_iv2 = jad_cpVar.jad_iv();
        double jad_iv3 = jad_cpVar.jad_iv();
        double jad_iv4 = jad_cpVar.jad_mz() == 7 ? jad_cpVar.jad_iv() : 1.0d;
        if (z) {
            jad_cpVar.jad_dq();
        }
        if (jad_iv <= 1.0d && jad_iv2 <= 1.0d && jad_iv3 <= 1.0d) {
            jad_iv *= 255.0d;
            jad_iv2 *= 255.0d;
            jad_iv3 *= 255.0d;
            if (jad_iv4 <= 1.0d) {
                jad_iv4 *= 255.0d;
            }
        }
        return java.lang.Integer.valueOf(android.graphics.Color.argb((int) jad_iv4, (int) jad_iv, (int) jad_iv2, (int) jad_iv3));
    }
}
