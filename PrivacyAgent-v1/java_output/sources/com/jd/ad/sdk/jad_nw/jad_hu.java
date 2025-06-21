package com.jd.ad.sdk.jad_nw;

/* loaded from: classes23.dex */
public class jad_hu implements com.jd.ad.sdk.jad_nw.jad_er, com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an, com.jd.ad.sdk.jad_nw.jad_kx {

    @androidx.annotation.NonNull
    public final java.lang.String jad_an;
    public final boolean jad_bo;
    public final com.jd.ad.sdk.jad_tc.jad_an jad_cp;
    public final androidx.collection.LongSparseArray<android.graphics.LinearGradient> jad_dq = new androidx.collection.LongSparseArray<>();
    public final androidx.collection.LongSparseArray<android.graphics.RadialGradient> jad_er = new androidx.collection.LongSparseArray<>();
    public final android.graphics.Path jad_fs;
    public final android.graphics.RectF jad_hu;
    public final java.util.List<com.jd.ad.sdk.jad_nw.jad_mz> jad_iv;
    public final android.graphics.Paint jad_jt;
    public final int jad_jw;
    public final com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_sb.jad_dq, com.jd.ad.sdk.jad_sb.jad_dq> jad_kx;
    public final com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_ly;
    public final com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_mz;
    public final com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_na;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<android.graphics.ColorFilter, android.graphics.ColorFilter> jad_ob;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_qd jad_pc;
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_qd;
    public final int jad_re;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_sf;
    public float jad_tg;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_cp jad_uh;

    public jad_hu(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_er jad_erVar) {
        android.graphics.Path path = new android.graphics.Path();
        this.jad_fs = path;
        this.jad_jt = new com.jd.ad.sdk.jad_mv.jad_an(1);
        this.jad_hu = new android.graphics.RectF();
        this.jad_iv = new java.util.ArrayList();
        this.jad_tg = 0.0f;
        this.jad_cp = jad_anVar;
        this.jad_an = jad_erVar.jad_er();
        this.jad_bo = jad_erVar.jad_hu();
        this.jad_qd = jad_mzVar;
        this.jad_jw = jad_erVar.jad_dq();
        path.setFillType(jad_erVar.jad_bo());
        this.jad_re = (int) (jad_mzVar.jad_dq().jad_an() / 32.0f);
        com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_sb.jad_dq, com.jd.ad.sdk.jad_sb.jad_dq> jad_an = jad_erVar.jad_cp().jad_an();
        this.jad_kx = jad_an;
        jad_an.jad_an(this);
        jad_anVar.jad_an(jad_an);
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_an2 = jad_erVar.jad_fs().jad_an();
        this.jad_ly = jad_an2;
        jad_an2.jad_an(this);
        jad_anVar.jad_an(jad_an2);
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_an3 = jad_erVar.jad_jt().jad_an();
        this.jad_mz = jad_an3;
        jad_an3.jad_an(this);
        jad_anVar.jad_an(jad_an3);
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_an4 = jad_erVar.jad_an().jad_an();
        this.jad_na = jad_an4;
        jad_an4.jad_an(this);
        jad_anVar.jad_an(jad_an4);
        if (jad_anVar.jad_er() != null) {
            com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an5 = jad_anVar.jad_er().jad_an().jad_an();
            this.jad_sf = jad_an5;
            jad_an5.jad_an(this);
            jad_anVar.jad_an(this.jad_sf);
        }
        if (jad_anVar.jad_fs() != null) {
            this.jad_uh = new com.jd.ad.sdk.jad_ox.jad_cp(this, jad_anVar, jad_anVar.jad_fs());
        }
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an
    public void jad_an() {
        this.jad_qd.invalidateSelf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        android.graphics.RadialGradient radialGradient;
        if (this.jad_bo) {
            return;
        }
        this.jad_fs.reset();
        for (int i2 = 0; i2 < this.jad_iv.size(); i2++) {
            this.jad_fs.addPath(this.jad_iv.get(i2).jad_bo(), matrix);
        }
        this.jad_fs.computeBounds(this.jad_hu, false);
        if (this.jad_jw == 1) {
            long jad_dq = jad_dq();
            radialGradient = this.jad_dq.get(jad_dq);
            if (radialGradient == null) {
                android.graphics.PointF jad_fs = this.jad_mz.jad_fs();
                android.graphics.PointF jad_fs2 = this.jad_na.jad_fs();
                com.jd.ad.sdk.jad_sb.jad_dq jad_fs3 = this.jad_kx.jad_fs();
                android.graphics.LinearGradient linearGradient = new android.graphics.LinearGradient(jad_fs.x, jad_fs.y, jad_fs2.x, jad_fs2.y, jad_an(jad_fs3.jad_bo), jad_fs3.jad_an, android.graphics.Shader.TileMode.CLAMP);
                this.jad_dq.put(jad_dq, linearGradient);
                radialGradient = linearGradient;
            }
        } else {
            long jad_dq2 = jad_dq();
            radialGradient = this.jad_er.get(jad_dq2);
            if (radialGradient == null) {
                android.graphics.PointF jad_fs4 = this.jad_mz.jad_fs();
                android.graphics.PointF jad_fs5 = this.jad_na.jad_fs();
                com.jd.ad.sdk.jad_sb.jad_dq jad_fs6 = this.jad_kx.jad_fs();
                int[] jad_an = jad_an(jad_fs6.jad_bo);
                float[] fArr = jad_fs6.jad_an;
                float f = jad_fs4.x;
                float f2 = jad_fs4.y;
                float hypot = (float) java.lang.Math.hypot(jad_fs5.x - f, jad_fs5.y - f2);
                radialGradient = new android.graphics.RadialGradient(f, f2, hypot <= 0.0f ? 0.001f : hypot, jad_an, fArr, android.graphics.Shader.TileMode.CLAMP);
                this.jad_er.put(jad_dq2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.jad_jt.setShader(radialGradient);
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.ColorFilter, android.graphics.ColorFilter> jad_anVar = this.jad_ob;
        if (jad_anVar != null) {
            this.jad_jt.setColorFilter(jad_anVar.jad_fs());
        }
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar2 = this.jad_sf;
        if (jad_anVar2 != null) {
            float floatValue = jad_anVar2.jad_fs().floatValue();
            if (floatValue == 0.0f) {
                this.jad_jt.setMaskFilter(null);
            } else if (floatValue != this.jad_tg) {
                this.jad_jt.setMaskFilter(new android.graphics.BlurMaskFilter(floatValue, android.graphics.BlurMaskFilter.Blur.NORMAL));
            }
            this.jad_tg = floatValue;
        }
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar = this.jad_uh;
        if (jad_cpVar != null) {
            jad_cpVar.jad_an(this.jad_jt);
        }
        android.graphics.Paint paint = this.jad_jt;
        android.graphics.PointF pointF = com.jd.ad.sdk.jad_xg.jad_jt.jad_an;
        paint.setAlpha(java.lang.Math.max(0, java.lang.Math.min(255, (int) ((((i / 255.0f) * this.jad_ly.jad_fs().intValue()) / 100.0f) * 255.0f))));
        canvas.drawPath(this.jad_fs, this.jad_jt);
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("GradientFillContent#draw");
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        this.jad_fs.reset();
        for (int i = 0; i < this.jad_iv.size(); i++) {
            this.jad_fs.addPath(this.jad_iv.get(i).jad_bo(), matrix);
        }
        this.jad_fs.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, java.util.List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_erVar, i, list, jad_erVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, @androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar2;
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar3;
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar4;
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar5;
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar6;
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_dq) {
            this.jad_ly.jad_er = jad_cpVar;
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_mx) {
            com.jd.ad.sdk.jad_ox.jad_an<android.graphics.ColorFilter, android.graphics.ColorFilter> jad_anVar = this.jad_ob;
            if (jad_anVar != null) {
                this.jad_cp.jad_uh.remove(jad_anVar);
            }
            if (jad_cpVar == 0) {
                this.jad_ob = null;
                return;
            }
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            this.jad_ob = jad_qdVar;
            jad_qdVar.jad_an.add(this);
            this.jad_cp.jad_an(this.jad_ob);
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_ny) {
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar2 = this.jad_pc;
            if (jad_qdVar2 != null) {
                this.jad_cp.jad_uh.remove(jad_qdVar2);
            }
            if (jad_cpVar == 0) {
                this.jad_pc = null;
                return;
            }
            this.jad_dq.clear();
            this.jad_er.clear();
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar3 = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            this.jad_pc = jad_qdVar3;
            jad_qdVar3.jad_an.add(this);
            this.jad_cp.jad_an(this.jad_pc);
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_jw) {
            com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar2 = this.jad_sf;
            if (jad_anVar2 != null) {
                jad_anVar2.jad_er = jad_cpVar;
                return;
            }
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar4 = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            this.jad_sf = jad_qdVar4;
            jad_qdVar4.jad_an.add(this);
            this.jad_cp.jad_an(this.jad_sf);
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_er && (jad_cpVar6 = this.jad_uh) != null) {
            jad_cpVar6.jad_bo.jad_er = jad_cpVar;
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_it && (jad_cpVar5 = this.jad_uh) != null) {
            jad_cpVar5.jad_an((com.jd.ad.sdk.jad_yh.jad_cp<java.lang.Float>) jad_cpVar);
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_ju && (jad_cpVar4 = this.jad_uh) != null) {
            jad_cpVar4.jad_dq.jad_er = jad_cpVar;
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_kv && (jad_cpVar3 = this.jad_uh) != null) {
            jad_cpVar3.jad_er.jad_er = jad_cpVar;
        } else {
            if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_lw || (jad_cpVar2 = this.jad_uh) == null) {
                return;
            }
            jad_cpVar2.jad_fs.jad_er = jad_cpVar;
        }
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(java.util.List<com.jd.ad.sdk.jad_nw.jad_cp> list, java.util.List<com.jd.ad.sdk.jad_nw.jad_cp> list2) {
        for (int i = 0; i < list2.size(); i++) {
            com.jd.ad.sdk.jad_nw.jad_cp jad_cpVar = list2.get(i);
            if (jad_cpVar instanceof com.jd.ad.sdk.jad_nw.jad_mz) {
                this.jad_iv.add((com.jd.ad.sdk.jad_nw.jad_mz) jad_cpVar);
            }
        }
    }

    public final int[] jad_an(int[] iArr) {
        com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar = this.jad_pc;
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
        return this.jad_an;
    }

    public final int jad_dq() {
        int round = java.lang.Math.round(this.jad_mz.jad_dq * this.jad_re);
        int round2 = java.lang.Math.round(this.jad_na.jad_dq * this.jad_re);
        int round3 = java.lang.Math.round(this.jad_kx.jad_dq * this.jad_re);
        int i = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }
}
