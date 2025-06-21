package com.jd.ad.sdk.jad_ox;

/* loaded from: classes23.dex */
public class jad_bo extends com.jd.ad.sdk.jad_ox.jad_jt<java.lang.Integer> {
    public jad_bo(java.util.List<com.jd.ad.sdk.jad_yh.jad_an<java.lang.Integer>> list) {
        super(list);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public java.lang.Object jad_an(com.jd.ad.sdk.jad_yh.jad_an jad_anVar, float f) {
        return java.lang.Integer.valueOf(jad_bo(jad_anVar, f));
    }

    public int jad_bo(com.jd.ad.sdk.jad_yh.jad_an<java.lang.Integer> jad_anVar, float f) {
        java.lang.Integer num;
        if (jad_anVar.jad_bo == null || jad_anVar.jad_cp == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar = this.jad_er;
        if (jad_cpVar != 0 && (num = (java.lang.Integer) jad_cpVar.jad_an(jad_anVar.jad_jt, jad_anVar.jad_hu.floatValue(), jad_anVar.jad_bo, jad_anVar.jad_cp, f, jad_dq(), this.jad_dq)) != null) {
            return num.intValue();
        }
        android.graphics.PointF pointF = com.jd.ad.sdk.jad_xg.jad_jt.jad_an;
        return com.jd.ad.sdk.jad_xg.jad_bo.jad_an(java.lang.Math.max(0.0f, java.lang.Math.min(1.0f, f)), jad_anVar.jad_bo.intValue(), jad_anVar.jad_cp.intValue());
    }
}
