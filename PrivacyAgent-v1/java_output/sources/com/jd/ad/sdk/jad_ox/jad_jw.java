package com.jd.ad.sdk.jad_ox;

/* loaded from: classes23.dex */
public class jad_jw extends com.jd.ad.sdk.jad_ox.jad_jt<android.graphics.PointF> {
    public final android.graphics.PointF jad_iv;
    public final float[] jad_jw;
    public final android.graphics.PathMeasure jad_kx;
    public com.jd.ad.sdk.jad_ox.jad_iv jad_ly;

    public jad_jw(java.util.List<? extends com.jd.ad.sdk.jad_yh.jad_an<android.graphics.PointF>> list) {
        super(list);
        this.jad_iv = new android.graphics.PointF();
        this.jad_jw = new float[2];
        this.jad_kx = new android.graphics.PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public java.lang.Object jad_an(com.jd.ad.sdk.jad_yh.jad_an jad_anVar, float f) {
        android.graphics.PointF pointF;
        com.jd.ad.sdk.jad_ox.jad_iv jad_ivVar = (com.jd.ad.sdk.jad_ox.jad_iv) jad_anVar;
        android.graphics.Path path = jad_ivVar.jad_qd;
        if (path == null) {
            return (android.graphics.PointF) jad_anVar.jad_bo;
        }
        com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar = this.jad_er;
        if (jad_cpVar != 0 && (pointF = (android.graphics.PointF) jad_cpVar.jad_an(jad_ivVar.jad_jt, jad_ivVar.jad_hu.floatValue(), (android.graphics.PointF) jad_ivVar.jad_bo, (android.graphics.PointF) jad_ivVar.jad_cp, jad_dq(), f, this.jad_dq)) != null) {
            return pointF;
        }
        if (this.jad_ly != jad_ivVar) {
            this.jad_kx.setPath(path, false);
            this.jad_ly = jad_ivVar;
        }
        android.graphics.PathMeasure pathMeasure = this.jad_kx;
        pathMeasure.getPosTan(pathMeasure.getLength() * f, this.jad_jw, null);
        android.graphics.PointF pointF2 = this.jad_iv;
        float[] fArr = this.jad_jw;
        pointF2.set(fArr[0], fArr[1]);
        return this.jad_iv;
    }
}
