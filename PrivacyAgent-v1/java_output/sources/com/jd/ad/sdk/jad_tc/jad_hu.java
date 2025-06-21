package com.jd.ad.sdk.jad_tc;

/* loaded from: classes23.dex */
public class jad_hu extends com.jd.ad.sdk.jad_tc.jad_an {
    public final android.graphics.RectF jad_do;
    public final android.graphics.Paint jad_ep;
    public final float[] jad_fq;
    public final android.graphics.Path jad_gr;
    public final com.jd.ad.sdk.jad_tc.jad_er jad_hs;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<android.graphics.ColorFilter, android.graphics.ColorFilter> jad_it;

    public jad_hu(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_er jad_erVar) {
        super(jad_mzVar, jad_erVar);
        this.jad_do = new android.graphics.RectF();
        com.jd.ad.sdk.jad_mv.jad_an jad_anVar = new com.jd.ad.sdk.jad_mv.jad_an();
        this.jad_ep = jad_anVar;
        this.jad_fq = new float[8];
        this.jad_gr = new android.graphics.Path();
        this.jad_hs = jad_erVar;
        jad_anVar.setAlpha(0);
        jad_anVar.setStyle(android.graphics.Paint.Style.FILL);
        jad_anVar.setColor(jad_erVar.jad_hu());
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an, com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        super.jad_an(rectF, matrix, z);
        android.graphics.RectF rectF2 = this.jad_do;
        com.jd.ad.sdk.jad_tc.jad_er jad_erVar = this.jad_hs;
        rectF2.set(0.0f, 0.0f, jad_erVar.jad_jw, jad_erVar.jad_kx);
        this.jad_mz.mapRect(this.jad_do);
        rectF.set(this.jad_do);
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an, com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, @androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        this.jad_vi.jad_an(t, jad_cpVar);
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_mx) {
            if (jad_cpVar == null) {
                this.jad_it = null;
            } else {
                this.jad_it = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an
    public void jad_bo(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        int alpha = android.graphics.Color.alpha(this.jad_hs.jad_ly);
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((((alpha / 255.0f) * (this.jad_vi.jad_jw == null ? 100 : r1.jad_fs().intValue())) / 100.0f) * (i / 255.0f) * 255.0f);
        this.jad_ep.setAlpha(intValue);
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.ColorFilter, android.graphics.ColorFilter> jad_anVar = this.jad_it;
        if (jad_anVar != null) {
            this.jad_ep.setColorFilter(jad_anVar.jad_fs());
        }
        if (intValue > 0) {
            float[] fArr = this.jad_fq;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            com.jd.ad.sdk.jad_tc.jad_er jad_erVar = this.jad_hs;
            float f = jad_erVar.jad_jw;
            fArr[2] = f;
            fArr[3] = 0.0f;
            fArr[4] = f;
            float f2 = jad_erVar.jad_kx;
            fArr[5] = f2;
            fArr[6] = 0.0f;
            fArr[7] = f2;
            matrix.mapPoints(fArr);
            this.jad_gr.reset();
            android.graphics.Path path = this.jad_gr;
            float[] fArr2 = this.jad_fq;
            path.moveTo(fArr2[0], fArr2[1]);
            android.graphics.Path path2 = this.jad_gr;
            float[] fArr3 = this.jad_fq;
            path2.lineTo(fArr3[2], fArr3[3]);
            android.graphics.Path path3 = this.jad_gr;
            float[] fArr4 = this.jad_fq;
            path3.lineTo(fArr4[4], fArr4[5]);
            android.graphics.Path path4 = this.jad_gr;
            float[] fArr5 = this.jad_fq;
            path4.lineTo(fArr5[6], fArr5[7]);
            android.graphics.Path path5 = this.jad_gr;
            float[] fArr6 = this.jad_fq;
            path5.lineTo(fArr6[0], fArr6[1]);
            this.jad_gr.close();
            canvas.drawPath(this.jad_gr, this.jad_ep);
        }
    }
}
