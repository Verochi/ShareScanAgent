package com.jd.ad.sdk.jad_ve;

/* loaded from: classes23.dex */
public class jad_zm implements com.jd.ad.sdk.jad_ve.jad_mx<android.graphics.PointF> {
    public static final com.jd.ad.sdk.jad_ve.jad_zm jad_an = new com.jd.ad.sdk.jad_ve.jad_zm();

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public android.graphics.PointF jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        int jad_mz = jad_cpVar.jad_mz();
        if (jad_mz == 1 || jad_mz == 3) {
            return com.jd.ad.sdk.jad_ve.jad_sf.jad_an(jad_cpVar, f);
        }
        if (jad_mz == 7) {
            android.graphics.PointF pointF = new android.graphics.PointF(((float) jad_cpVar.jad_iv()) * f, ((float) jad_cpVar.jad_iv()) * f);
            while (jad_cpVar.jad_jt()) {
                jad_cpVar.jad_ob();
            }
            return pointF;
        }
        throw new java.lang.IllegalArgumentException("Cannot convert json to point. Next token is " + com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz));
    }
}
