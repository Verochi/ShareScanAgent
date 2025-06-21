package com.jd.ad.sdk.jad_ox;

/* loaded from: classes23.dex */
public class jad_iv extends com.jd.ad.sdk.jad_yh.jad_an<android.graphics.PointF> {

    @androidx.annotation.Nullable
    public android.graphics.Path jad_qd;
    public final com.jd.ad.sdk.jad_yh.jad_an<android.graphics.PointF> jad_re;

    public jad_iv(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar, com.jd.ad.sdk.jad_yh.jad_an<android.graphics.PointF> jad_anVar) {
        super(jad_jtVar, jad_anVar.jad_bo, jad_anVar.jad_cp, jad_anVar.jad_dq, jad_anVar.jad_er, jad_anVar.jad_fs, jad_anVar.jad_jt, jad_anVar.jad_hu);
        this.jad_re = jad_anVar;
        jad_dq();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void jad_dq() {
        boolean z;
        T t;
        T t2;
        T t3;
        T t4 = this.jad_cp;
        if (t4 != 0 && (t3 = this.jad_bo) != 0) {
            android.graphics.PointF pointF = (android.graphics.PointF) t4;
            if (((android.graphics.PointF) t3).equals(pointF.x, pointF.y)) {
                z = true;
                t = this.jad_bo;
                if (t != 0 || (t2 = this.jad_cp) == 0 || z) {
                    return;
                }
                android.graphics.PointF pointF2 = (android.graphics.PointF) t;
                android.graphics.PointF pointF3 = (android.graphics.PointF) t2;
                com.jd.ad.sdk.jad_yh.jad_an<android.graphics.PointF> jad_anVar = this.jad_re;
                android.graphics.PointF pointF4 = jad_anVar.jad_ob;
                android.graphics.PointF pointF5 = jad_anVar.jad_pc;
                java.lang.ThreadLocal<android.graphics.PathMeasure> threadLocal = com.jd.ad.sdk.jad_xg.jad_hu.jad_an;
                android.graphics.Path path = new android.graphics.Path();
                path.moveTo(pointF2.x, pointF2.y);
                if (pointF4 == null || pointF5 == null || (pointF4.length() == 0.0f && pointF5.length() == 0.0f)) {
                    path.lineTo(pointF3.x, pointF3.y);
                } else {
                    float f = pointF4.x + pointF2.x;
                    float f2 = pointF2.y + pointF4.y;
                    float f3 = pointF3.x;
                    float f4 = f3 + pointF5.x;
                    float f5 = pointF3.y;
                    path.cubicTo(f, f2, f4, f5 + pointF5.y, f3, f5);
                }
                this.jad_qd = path;
                return;
            }
        }
        z = false;
        t = this.jad_bo;
        if (t != 0) {
        }
    }
}
