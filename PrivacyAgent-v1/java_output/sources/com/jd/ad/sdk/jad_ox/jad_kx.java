package com.jd.ad.sdk.jad_ox;

/* loaded from: classes23.dex */
public class jad_kx extends com.jd.ad.sdk.jad_ox.jad_jt<android.graphics.PointF> {
    public final android.graphics.PointF jad_iv;

    public jad_kx(java.util.List<com.jd.ad.sdk.jad_yh.jad_an<android.graphics.PointF>> list) {
        super(list);
        this.jad_iv = new android.graphics.PointF();
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public java.lang.Object jad_an(com.jd.ad.sdk.jad_yh.jad_an jad_anVar, float f) {
        return jad_an(jad_anVar, f, f, f);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    /* renamed from: jad_bo, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF jad_an(com.jd.ad.sdk.jad_yh.jad_an<android.graphics.PointF> jad_anVar, float f, float f2, float f3) {
        android.graphics.PointF pointF;
        android.graphics.PointF pointF2;
        android.graphics.PointF pointF3 = jad_anVar.jad_bo;
        if (pointF3 == null || (pointF = jad_anVar.jad_cp) == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        android.graphics.PointF pointF4 = pointF3;
        android.graphics.PointF pointF5 = pointF;
        com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar = this.jad_er;
        if (jad_cpVar != 0 && (pointF2 = (android.graphics.PointF) jad_cpVar.jad_an(jad_anVar.jad_jt, jad_anVar.jad_hu.floatValue(), pointF4, pointF5, f, jad_dq(), this.jad_dq)) != null) {
            return pointF2;
        }
        android.graphics.PointF pointF6 = this.jad_iv;
        float f4 = pointF4.x;
        float f5 = ((pointF5.x - f4) * f2) + f4;
        float f6 = pointF4.y;
        pointF6.set(f5, ((pointF5.y - f6) * f3) + f6);
        return this.jad_iv;
    }
}
