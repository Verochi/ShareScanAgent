package com.jd.ad.sdk.jad_nw;

/* loaded from: classes23.dex */
public class jad_iv extends com.jd.ad.sdk.jad_nw.jad_an {
    public final com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_cn;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_qd jad_do;
    public final java.lang.String jad_re;
    public final boolean jad_sf;
    public final androidx.collection.LongSparseArray<android.graphics.LinearGradient> jad_tg;
    public final androidx.collection.LongSparseArray<android.graphics.RadialGradient> jad_uh;
    public final android.graphics.RectF jad_vi;
    public final int jad_wj;
    public final int jad_xk;
    public final com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_sb.jad_dq, com.jd.ad.sdk.jad_sb.jad_dq> jad_yl;
    public final com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_zm;

    public jad_iv(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_fs jad_fsVar) {
        super(jad_mzVar, jad_anVar, com.jd.ad.sdk.jad_sb.jad_sf.jad_an(jad_fsVar.jad_an()), com.jd.ad.sdk.jad_sb.jad_tg.jad_an(jad_fsVar.jad_fs()), jad_fsVar.jad_hu(), jad_fsVar.jad_jw(), jad_fsVar.jad_ly(), jad_fsVar.jad_jt(), jad_fsVar.jad_bo());
        this.jad_tg = new androidx.collection.LongSparseArray<>();
        this.jad_uh = new androidx.collection.LongSparseArray<>();
        this.jad_vi = new android.graphics.RectF();
        this.jad_re = jad_fsVar.jad_iv();
        this.jad_wj = jad_fsVar.jad_er();
        this.jad_sf = jad_fsVar.jad_mz();
        this.jad_xk = (int) (jad_mzVar.jad_dq().jad_an() / 32.0f);
        com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_sb.jad_dq, com.jd.ad.sdk.jad_sb.jad_dq> jad_an = jad_fsVar.jad_dq().jad_an();
        this.jad_yl = jad_an;
        jad_an.jad_an(this);
        jad_anVar.jad_an(jad_an);
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_an2 = jad_fsVar.jad_kx().jad_an();
        this.jad_zm = jad_an2;
        jad_an2.jad_an(this);
        jad_anVar.jad_an(jad_an2);
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_an3 = jad_fsVar.jad_cp().jad_an();
        this.jad_cn = jad_an3;
        jad_an3.jad_an(this);
        jad_anVar.jad_an(jad_an3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_nw.jad_an, com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        android.graphics.RadialGradient radialGradient;
        if (this.jad_sf) {
            return;
        }
        jad_an(this.jad_vi, matrix, false);
        if (this.jad_wj == 1) {
            long jad_dq = jad_dq();
            radialGradient = this.jad_tg.get(jad_dq);
            if (radialGradient == null) {
                android.graphics.PointF jad_fs = this.jad_zm.jad_fs();
                android.graphics.PointF jad_fs2 = this.jad_cn.jad_fs();
                com.jd.ad.sdk.jad_sb.jad_dq jad_fs3 = this.jad_yl.jad_fs();
                radialGradient = new android.graphics.LinearGradient(jad_fs.x, jad_fs.y, jad_fs2.x, jad_fs2.y, jad_an(jad_fs3.jad_bo), jad_fs3.jad_an, android.graphics.Shader.TileMode.CLAMP);
                this.jad_tg.put(jad_dq, radialGradient);
            }
        } else {
            long jad_dq2 = jad_dq();
            radialGradient = this.jad_uh.get(jad_dq2);
            if (radialGradient == null) {
                android.graphics.PointF jad_fs4 = this.jad_zm.jad_fs();
                android.graphics.PointF jad_fs5 = this.jad_cn.jad_fs();
                com.jd.ad.sdk.jad_sb.jad_dq jad_fs6 = this.jad_yl.jad_fs();
                int[] jad_an = jad_an(jad_fs6.jad_bo);
                float[] fArr = jad_fs6.jad_an;
                radialGradient = new android.graphics.RadialGradient(jad_fs4.x, jad_fs4.y, (float) java.lang.Math.hypot(jad_fs5.x - r9, jad_fs5.y - r10), jad_an, fArr, android.graphics.Shader.TileMode.CLAMP);
                this.jad_uh.put(jad_dq2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.jad_iv.setShader(radialGradient);
        super.jad_an(canvas, matrix, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_nw.jad_an, com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, @androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        super.jad_an((com.jd.ad.sdk.jad_nw.jad_iv) t, (com.jd.ad.sdk.jad_yh.jad_cp<com.jd.ad.sdk.jad_nw.jad_iv>) jad_cpVar);
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_ny) {
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar = this.jad_do;
            if (jad_qdVar != null) {
                this.jad_fs.jad_uh.remove(jad_qdVar);
            }
            if (jad_cpVar == null) {
                this.jad_do = null;
                return;
            }
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar2 = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            this.jad_do = jad_qdVar2;
            jad_qdVar2.jad_an.add(this);
            this.jad_fs.jad_an(this.jad_do);
        }
    }

    public final int[] jad_an(int[] iArr) {
        com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar = this.jad_do;
        if (jad_qdVar != null) {
            java.lang.Integer[] numArr = (java.lang.Integer[]) jad_qdVar.jad_fs();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public java.lang.String jad_cp() {
        return this.jad_re;
    }

    public final int jad_dq() {
        int round = java.lang.Math.round(this.jad_zm.jad_dq * this.jad_xk);
        int round2 = java.lang.Math.round(this.jad_cn.jad_dq * this.jad_xk);
        int round3 = java.lang.Math.round(this.jad_yl.jad_dq * this.jad_xk);
        int i = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }
}
