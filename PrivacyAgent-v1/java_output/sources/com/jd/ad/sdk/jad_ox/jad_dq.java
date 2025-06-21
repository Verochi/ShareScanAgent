package com.jd.ad.sdk.jad_ox;

/* loaded from: classes23.dex */
public class jad_dq extends com.jd.ad.sdk.jad_ox.jad_jt<java.lang.Float> {
    public jad_dq(java.util.List<com.jd.ad.sdk.jad_yh.jad_an<java.lang.Float>> list) {
        super(list);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public java.lang.Object jad_an(com.jd.ad.sdk.jad_yh.jad_an jad_anVar, float f) {
        return java.lang.Float.valueOf(jad_bo(jad_anVar, f));
    }

    public float jad_bo(com.jd.ad.sdk.jad_yh.jad_an<java.lang.Float> jad_anVar, float f) {
        java.lang.Float f2;
        if (jad_anVar.jad_bo == null || jad_anVar.jad_cp == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar = this.jad_er;
        if (jad_cpVar != 0 && (f2 = (java.lang.Float) jad_cpVar.jad_an(jad_anVar.jad_jt, jad_anVar.jad_hu.floatValue(), jad_anVar.jad_bo, jad_anVar.jad_cp, f, jad_dq(), this.jad_dq)) != null) {
            return f2.floatValue();
        }
        if (jad_anVar.jad_iv == -3987645.8f) {
            jad_anVar.jad_iv = jad_anVar.jad_bo.floatValue();
        }
        float f3 = jad_anVar.jad_iv;
        if (jad_anVar.jad_jw == -3987645.8f) {
            jad_anVar.jad_jw = jad_anVar.jad_cp.floatValue();
        }
        return com.jd.ad.sdk.jad_xg.jad_jt.jad_an(f3, jad_anVar.jad_jw, f);
    }

    public float jad_hu() {
        return jad_bo(jad_an(), jad_cp());
    }
}
