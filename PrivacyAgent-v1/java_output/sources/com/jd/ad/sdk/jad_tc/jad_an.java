package com.jd.ad.sdk.jad_tc;

/* loaded from: classes23.dex */
public abstract class jad_an implements com.jd.ad.sdk.jad_nw.jad_er, com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an, com.jd.ad.sdk.jad_qz.jad_fs {

    @androidx.annotation.Nullable
    public android.graphics.BlurMaskFilter jad_cn;
    public final android.graphics.Paint jad_fs;
    public final android.graphics.RectF jad_hu;
    public final android.graphics.RectF jad_iv;
    public final android.graphics.Paint jad_jt;
    public final android.graphics.RectF jad_jw;
    public final android.graphics.RectF jad_kx;
    public final java.lang.String jad_ly;
    public final android.graphics.Matrix jad_mz;
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_na;
    public final com.jd.ad.sdk.jad_tc.jad_er jad_ob;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_hu jad_pc;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_dq jad_qd;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_tc.jad_an jad_re;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_tc.jad_an jad_sf;
    public java.util.List<com.jd.ad.sdk.jad_tc.jad_an> jad_tg;
    public final java.util.List<com.jd.ad.sdk.jad_ox.jad_an<?, ?>> jad_uh;
    public final com.jd.ad.sdk.jad_ox.jad_pc jad_vi;
    public boolean jad_wj;
    public boolean jad_xk;

    @androidx.annotation.Nullable
    public android.graphics.Paint jad_yl;
    public float jad_zm;
    public final android.graphics.Path jad_an = new android.graphics.Path();
    public final android.graphics.Matrix jad_bo = new android.graphics.Matrix();
    public final android.graphics.Paint jad_cp = new com.jd.ad.sdk.jad_mv.jad_an(1);
    public final android.graphics.Paint jad_dq = new com.jd.ad.sdk.jad_mv.jad_an(1, android.graphics.PorterDuff.Mode.DST_IN);
    public final android.graphics.Paint jad_er = new com.jd.ad.sdk.jad_mv.jad_an(1, android.graphics.PorterDuff.Mode.DST_OUT);

    public jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_er jad_erVar) {
        com.jd.ad.sdk.jad_mv.jad_an jad_anVar = new com.jd.ad.sdk.jad_mv.jad_an(1);
        this.jad_fs = jad_anVar;
        this.jad_jt = new com.jd.ad.sdk.jad_mv.jad_an(android.graphics.PorterDuff.Mode.CLEAR);
        this.jad_hu = new android.graphics.RectF();
        this.jad_iv = new android.graphics.RectF();
        this.jad_jw = new android.graphics.RectF();
        this.jad_kx = new android.graphics.RectF();
        this.jad_mz = new android.graphics.Matrix();
        this.jad_uh = new java.util.ArrayList();
        this.jad_wj = true;
        this.jad_zm = 0.0f;
        this.jad_na = jad_mzVar;
        this.jad_ob = jad_erVar;
        this.jad_ly = jad_erVar.jad_er() + "#draw";
        jad_anVar.setXfermode(jad_erVar.jad_dq() == 3 ? new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT) : new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
        com.jd.ad.sdk.jad_ox.jad_pc jad_an = jad_erVar.jad_ly().jad_an();
        this.jad_vi = jad_an;
        jad_an.jad_an((com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an) this);
        if (jad_erVar.jad_cp() != null && !jad_erVar.jad_cp().isEmpty()) {
            com.jd.ad.sdk.jad_ox.jad_hu jad_huVar = new com.jd.ad.sdk.jad_ox.jad_hu(jad_erVar.jad_cp());
            this.jad_pc = jad_huVar;
            java.util.Iterator<com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_sb.jad_na, android.graphics.Path>> it = jad_huVar.jad_an().iterator();
            while (it.hasNext()) {
                it.next().jad_an(this);
            }
            for (com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_anVar2 : this.jad_pc.jad_bo()) {
                jad_an(jad_anVar2);
                jad_anVar2.jad_an(this);
            }
        }
        jad_kx();
    }

    @androidx.annotation.Nullable
    public static com.jd.ad.sdk.jad_tc.jad_an jad_an(com.jd.ad.sdk.jad_tc.jad_bo jad_boVar, com.jd.ad.sdk.jad_tc.jad_er jad_erVar, com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        int jad_an = com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_erVar.jad_er);
        if (jad_an == 0) {
            return new com.jd.ad.sdk.jad_tc.jad_bo(jad_mzVar, jad_erVar, jad_jtVar.jad_cp.get(jad_erVar.jad_jt), jad_jtVar);
        }
        if (jad_an == 1) {
            return new com.jd.ad.sdk.jad_tc.jad_hu(jad_mzVar, jad_erVar);
        }
        if (jad_an == 2) {
            return new com.jd.ad.sdk.jad_tc.jad_cp(jad_mzVar, jad_erVar);
        }
        if (jad_an == 3) {
            return new com.jd.ad.sdk.jad_tc.jad_fs(jad_mzVar, jad_erVar);
        }
        if (jad_an == 4) {
            return new com.jd.ad.sdk.jad_tc.jad_jt(jad_mzVar, jad_erVar, jad_boVar);
        }
        if (jad_an == 5) {
            return new com.jd.ad.sdk.jad_tc.jad_iv(jad_mzVar, jad_erVar);
        }
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Unknown layer type ");
        jad_an2.append(com.jd.ad.sdk.jad_tc.jad_dq.jad_an(jad_erVar.jad_er));
        com.jd.ad.sdk.jad_xg.jad_dq.jad_an(jad_an2.toString());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void jad_jw() {
        jad_bo(this.jad_qd.jad_hu() == 1.0f);
    }

    public android.graphics.BlurMaskFilter jad_an(float f) {
        if (this.jad_zm == f) {
            return this.jad_cn;
        }
        android.graphics.BlurMaskFilter blurMaskFilter = new android.graphics.BlurMaskFilter(f / 2.0f, android.graphics.BlurMaskFilter.Blur.NORMAL);
        this.jad_cn = blurMaskFilter;
        this.jad_zm = f;
        return blurMaskFilter;
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an
    public void jad_an() {
        this.jad_na.invalidateSelf();
    }

    public final void jad_an(android.graphics.Canvas canvas) {
        android.graphics.RectF rectF = this.jad_hu;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.jad_jt);
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#clearLayer");
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03b9 A[SYNTHETIC] */
    @Override // com.jd.ad.sdk.jad_nw.jad_er
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void jad_an(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        float f;
        android.graphics.Paint paint;
        boolean z;
        java.lang.String str = this.jad_ly;
        if (!this.jad_wj || this.jad_ob.jad_vi) {
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an(str);
            return;
        }
        jad_dq();
        this.jad_bo.reset();
        this.jad_bo.set(matrix);
        int i2 = 1;
        for (int size = this.jad_tg.size() - 1; size >= 0; size--) {
            this.jad_bo.preConcat(this.jad_tg.get(size).jad_vi.jad_bo());
        }
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#parentMatrix");
        int intValue = (int) ((((i / 255.0f) * (this.jad_vi.jad_jw == null ? 100 : r3.jad_fs().intValue())) / 100.0f) * 255.0f);
        if (!jad_iv() && !jad_hu()) {
            this.jad_bo.preConcat(this.jad_vi.jad_bo());
            jad_bo(canvas, this.jad_bo, intValue);
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#drawLayer");
            jad_bo(com.jd.ad.sdk.jad_lu.jad_dq.jad_an(this.jad_ly));
            return;
        }
        boolean z2 = false;
        jad_an(this.jad_hu, this.jad_bo, false);
        android.graphics.RectF rectF = this.jad_hu;
        int i3 = 3;
        if (jad_iv() && this.jad_ob.jad_uh != 3) {
            this.jad_jw.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.jad_re.jad_an(this.jad_jw, matrix, true);
            if (!rectF.intersect(this.jad_jw)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        this.jad_bo.preConcat(this.jad_vi.jad_bo());
        android.graphics.RectF rectF2 = this.jad_hu;
        android.graphics.Matrix matrix2 = this.jad_bo;
        this.jad_iv.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i4 = 2;
        if (jad_hu()) {
            int size2 = this.jad_pc.jad_cp.size();
            int i5 = 0;
            while (true) {
                if (i5 < size2) {
                    com.jd.ad.sdk.jad_sb.jad_jt jad_jtVar = this.jad_pc.jad_cp.get(i5);
                    android.graphics.Path jad_fs = this.jad_pc.jad_an.get(i5).jad_fs();
                    if (jad_fs != null) {
                        this.jad_an.set(jad_fs);
                        this.jad_an.transform(matrix2);
                        int jad_an = com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_jtVar.jad_an);
                        if (jad_an != 0) {
                            if (jad_an == 1) {
                                break;
                            }
                            if (jad_an != i4) {
                                if (jad_an == i3) {
                                    break;
                                }
                                this.jad_an.computeBounds(this.jad_kx, z2);
                                android.graphics.RectF rectF3 = this.jad_iv;
                                if (i5 != 0) {
                                    rectF3.set(this.jad_kx);
                                } else {
                                    rectF3.set(java.lang.Math.min(rectF3.left, this.jad_kx.left), java.lang.Math.min(this.jad_iv.top, this.jad_kx.top), java.lang.Math.max(this.jad_iv.right, this.jad_kx.right), java.lang.Math.max(this.jad_iv.bottom, this.jad_kx.bottom));
                                }
                            }
                        }
                        if (jad_jtVar.jad_dq) {
                            break;
                        }
                        this.jad_an.computeBounds(this.jad_kx, z2);
                        android.graphics.RectF rectF32 = this.jad_iv;
                        if (i5 != 0) {
                        }
                    }
                    i5++;
                    z2 = false;
                    i3 = 3;
                    i4 = 2;
                } else if (!rectF2.intersect(this.jad_iv)) {
                    f = 0.0f;
                    rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
        }
        f = 0.0f;
        if (!this.jad_hu.intersect(f, f, canvas.getWidth(), canvas.getHeight())) {
            this.jad_hu.set(f, f, f, f);
        }
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#computeBounds");
        if (this.jad_hu.width() >= 1.0f && this.jad_hu.height() >= 1.0f) {
            this.jad_cp.setAlpha(255);
            com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_cp, 31);
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#saveLayer");
            jad_an(canvas);
            jad_bo(canvas, this.jad_bo, intValue);
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#drawLayer");
            if (jad_hu()) {
                android.graphics.Matrix matrix3 = this.jad_bo;
                com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_dq, 19);
                if (android.os.Build.VERSION.SDK_INT < 28) {
                    jad_an(canvas);
                }
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#saveLayer");
                int i6 = 0;
                while (i6 < this.jad_pc.jad_cp.size()) {
                    com.jd.ad.sdk.jad_sb.jad_jt jad_jtVar2 = this.jad_pc.jad_cp.get(i6);
                    com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_sb.jad_na, android.graphics.Path> jad_anVar = this.jad_pc.jad_an.get(i6);
                    com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_anVar2 = this.jad_pc.jad_bo.get(i6);
                    int jad_an2 = com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_jtVar2.jad_an);
                    if (jad_an2 != 0) {
                        if (jad_an2 == i2) {
                            if (i6 == 0) {
                                this.jad_cp.setColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
                                this.jad_cp.setAlpha(255);
                                canvas.drawRect(this.jad_hu, this.jad_cp);
                            }
                            if (jad_jtVar2.jad_dq) {
                                com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_er, 31);
                                canvas.drawRect(this.jad_hu, this.jad_cp);
                                this.jad_er.setAlpha((int) (jad_anVar2.jad_fs().intValue() * 2.55f));
                                this.jad_an.set(jad_anVar.jad_fs());
                                this.jad_an.transform(matrix3);
                                canvas.drawPath(this.jad_an, this.jad_er);
                                canvas.restore();
                            } else {
                                this.jad_an.set(jad_anVar.jad_fs());
                                this.jad_an.transform(matrix3);
                                canvas.drawPath(this.jad_an, this.jad_er);
                            }
                        } else if (jad_an2 != 2) {
                            if (jad_an2 == 3) {
                                if (!this.jad_pc.jad_an.isEmpty()) {
                                    for (int i7 = 0; i7 < this.jad_pc.jad_cp.size(); i7++) {
                                        if (this.jad_pc.jad_cp.get(i7).jad_an == 4) {
                                        }
                                    }
                                    z = true;
                                    if (!z) {
                                        this.jad_cp.setAlpha(255);
                                        canvas.drawRect(this.jad_hu, this.jad_cp);
                                    }
                                }
                                z = false;
                                if (!z) {
                                }
                            }
                        } else if (jad_jtVar2.jad_dq) {
                            com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_dq, 31);
                            canvas.drawRect(this.jad_hu, this.jad_cp);
                            this.jad_er.setAlpha((int) (jad_anVar2.jad_fs().intValue() * 2.55f));
                            this.jad_an.set(jad_anVar.jad_fs());
                            this.jad_an.transform(matrix3);
                            canvas.drawPath(this.jad_an, this.jad_er);
                            canvas.restore();
                        } else {
                            com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_dq, 31);
                            this.jad_an.set(jad_anVar.jad_fs());
                            this.jad_an.transform(matrix3);
                            this.jad_cp.setAlpha((int) (jad_anVar2.jad_fs().intValue() * 2.55f));
                            canvas.drawPath(this.jad_an, this.jad_cp);
                            canvas.restore();
                        }
                    } else if (jad_jtVar2.jad_dq) {
                        com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_cp, 31);
                        canvas.drawRect(this.jad_hu, this.jad_cp);
                        this.jad_an.set(jad_anVar.jad_fs());
                        this.jad_an.transform(matrix3);
                        this.jad_cp.setAlpha((int) (jad_anVar2.jad_fs().intValue() * 2.55f));
                        canvas.drawPath(this.jad_an, this.jad_er);
                        canvas.restore();
                    } else {
                        this.jad_an.set(jad_anVar.jad_fs());
                        this.jad_an.transform(matrix3);
                        this.jad_cp.setAlpha((int) (jad_anVar2.jad_fs().intValue() * 2.55f));
                        canvas.drawPath(this.jad_an, this.jad_cp);
                    }
                    i6++;
                    i2 = 1;
                }
                canvas.restore();
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#restoreLayer");
            }
            if (jad_iv()) {
                com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_fs, 19);
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#saveLayer");
                jad_an(canvas);
                this.jad_re.jad_an(canvas, matrix, intValue);
                canvas.restore();
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#restoreLayer");
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#drawMatte");
            }
            canvas.restore();
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#restoreLayer");
        }
        if (this.jad_xk && (paint = this.jad_yl) != null) {
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            this.jad_yl.setColor(-251901);
            this.jad_yl.setStrokeWidth(4.0f);
            canvas.drawRect(this.jad_hu, this.jad_yl);
            this.jad_yl.setStyle(android.graphics.Paint.Style.FILL);
            this.jad_yl.setColor(1357638635);
            canvas.drawRect(this.jad_hu, this.jad_yl);
        }
        jad_bo(com.jd.ad.sdk.jad_lu.jad_dq.jad_an(this.jad_ly));
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    @androidx.annotation.CallSuper
    public void jad_an(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        this.jad_hu.set(0.0f, 0.0f, 0.0f, 0.0f);
        jad_dq();
        this.jad_mz.set(matrix);
        if (z) {
            java.util.List<com.jd.ad.sdk.jad_tc.jad_an> list = this.jad_tg;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.jad_mz.preConcat(this.jad_tg.get(size).jad_vi.jad_bo());
                }
            } else {
                com.jd.ad.sdk.jad_tc.jad_an jad_anVar = this.jad_sf;
                if (jad_anVar != null) {
                    this.jad_mz.preConcat(jad_anVar.jad_vi.jad_bo());
                }
            }
        }
        this.jad_mz.preConcat(this.jad_vi.jad_bo());
    }

    public void jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_ox.jad_an<?, ?> jad_anVar) {
        if (jad_anVar == null) {
            return;
        }
        this.jad_uh.add(jad_anVar);
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, java.util.List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_tc.jad_an jad_anVar = this.jad_re;
        if (jad_anVar != null) {
            com.jd.ad.sdk.jad_qz.jad_er jad_an = jad_erVar2.jad_an(jad_anVar.jad_ob.jad_cp);
            if (jad_erVar.jad_an(this.jad_re.jad_ob.jad_cp, i)) {
                list.add(jad_an.jad_an(this.jad_re));
            }
            if (jad_erVar.jad_dq(this.jad_ob.jad_cp, i)) {
                this.jad_re.jad_bo(jad_erVar, jad_erVar.jad_bo(this.jad_re.jad_ob.jad_cp, i) + i, list, jad_an);
            }
        }
        if (jad_erVar.jad_cp(this.jad_ob.jad_cp, i)) {
            if (!"__container".equals(this.jad_ob.jad_cp)) {
                jad_erVar2 = jad_erVar2.jad_an(this.jad_ob.jad_cp);
                if (jad_erVar.jad_an(this.jad_ob.jad_cp, i)) {
                    list.add(jad_erVar2.jad_an(this));
                }
            }
            if (jad_erVar.jad_dq(this.jad_ob.jad_cp, i)) {
                jad_bo(jad_erVar, jad_erVar.jad_bo(this.jad_ob.jad_cp, i) + i, list, jad_erVar2);
            }
        }
    }

    public void jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        this.jad_re = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    @androidx.annotation.CallSuper
    public <T> void jad_an(T t, @androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        this.jad_vi.jad_an(t, jad_cpVar);
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(java.util.List<com.jd.ad.sdk.jad_nw.jad_cp> list, java.util.List<com.jd.ad.sdk.jad_nw.jad_cp> list2) {
    }

    public void jad_an(boolean z) {
        if (z && this.jad_yl == null) {
            this.jad_yl = new com.jd.ad.sdk.jad_mv.jad_an();
        }
        this.jad_xk = z;
    }

    public final void jad_bo(float f) {
        com.jd.ad.sdk.jad_lu.jad_vi jad_viVar = this.jad_na.jad_bo.jad_an;
        java.lang.String str = this.jad_ob.jad_cp;
        if (jad_viVar.jad_an) {
            com.jd.ad.sdk.jad_xg.jad_fs jad_fsVar = jad_viVar.jad_cp.get(str);
            if (jad_fsVar == null) {
                jad_fsVar = new com.jd.ad.sdk.jad_xg.jad_fs();
                jad_viVar.jad_cp.put(str, jad_fsVar);
            }
            float f2 = jad_fsVar.jad_an + f;
            jad_fsVar.jad_an = f2;
            int i = jad_fsVar.jad_bo + 1;
            jad_fsVar.jad_bo = i;
            if (i == Integer.MAX_VALUE) {
                jad_fsVar.jad_an = f2 / 2.0f;
                jad_fsVar.jad_bo = i / 2;
            }
            if (str.equals("__container")) {
                java.util.Iterator<com.jd.ad.sdk.jad_lu.jad_vi.jad_an> it = jad_viVar.jad_bo.iterator();
                while (it.hasNext()) {
                    it.next().jad_an(f);
                }
            }
        }
    }

    public abstract void jad_bo(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i);

    public void jad_bo(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, java.util.List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
    }

    public void jad_bo(@androidx.annotation.Nullable com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        this.jad_sf = jad_anVar;
    }

    public final void jad_bo(boolean z) {
        if (z != this.jad_wj) {
            this.jad_wj = z;
            this.jad_na.invalidateSelf();
        }
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public java.lang.String jad_cp() {
        return this.jad_ob.jad_cp;
    }

    public void jad_cp(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        com.jd.ad.sdk.jad_ox.jad_pc jad_pcVar = this.jad_vi;
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_anVar = jad_pcVar.jad_jw;
        if (jad_anVar != null) {
            jad_anVar.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_anVar2 = jad_pcVar.jad_mz;
        if (jad_anVar2 != null) {
            jad_anVar2.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_anVar3 = jad_pcVar.jad_na;
        if (jad_anVar3 != null) {
            jad_anVar3.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_anVar4 = jad_pcVar.jad_fs;
        if (jad_anVar4 != null) {
            jad_anVar4.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_an<?, android.graphics.PointF> jad_anVar5 = jad_pcVar.jad_jt;
        if (jad_anVar5 != null) {
            jad_anVar5.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_yh.jad_dq, com.jd.ad.sdk.jad_yh.jad_dq> jad_anVar6 = jad_pcVar.jad_hu;
        if (jad_anVar6 != null) {
            jad_anVar6.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar7 = jad_pcVar.jad_iv;
        if (jad_anVar7 != null) {
            jad_anVar7.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar = jad_pcVar.jad_kx;
        if (jad_dqVar != null) {
            jad_dqVar.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar2 = jad_pcVar.jad_ly;
        if (jad_dqVar2 != null) {
            jad_dqVar2.jad_an(f);
        }
        if (this.jad_pc != null) {
            for (int i = 0; i < this.jad_pc.jad_an.size(); i++) {
                this.jad_pc.jad_an.get(i).jad_an(f);
            }
        }
        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar3 = this.jad_qd;
        if (jad_dqVar3 != null) {
            jad_dqVar3.jad_an(f);
        }
        com.jd.ad.sdk.jad_tc.jad_an jad_anVar8 = this.jad_re;
        if (jad_anVar8 != null) {
            jad_anVar8.jad_cp(f);
        }
        for (int i2 = 0; i2 < this.jad_uh.size(); i2++) {
            this.jad_uh.get(i2).jad_an(f);
        }
    }

    public final void jad_dq() {
        if (this.jad_tg != null) {
            return;
        }
        if (this.jad_sf == null) {
            this.jad_tg = java.util.Collections.emptyList();
            return;
        }
        this.jad_tg = new java.util.ArrayList();
        for (com.jd.ad.sdk.jad_tc.jad_an jad_anVar = this.jad_sf; jad_anVar != null; jad_anVar = jad_anVar.jad_sf) {
            this.jad_tg.add(jad_anVar);
        }
    }

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_sb.jad_an jad_er() {
        return this.jad_ob.jad_wj;
    }

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ve.jad_jw jad_fs() {
        return this.jad_ob.jad_xk;
    }

    public boolean jad_hu() {
        com.jd.ad.sdk.jad_ox.jad_hu jad_huVar = this.jad_pc;
        return (jad_huVar == null || jad_huVar.jad_an.isEmpty()) ? false : true;
    }

    public boolean jad_iv() {
        return this.jad_re != null;
    }

    public com.jd.ad.sdk.jad_tc.jad_er jad_jt() {
        return this.jad_ob;
    }

    public final void jad_kx() {
        if (this.jad_ob.jad_tg.isEmpty()) {
            jad_bo(true);
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_ox.jad_dq(this.jad_ob.jad_tg);
        this.jad_qd = jad_dqVar;
        jad_dqVar.jad_bo = true;
        jad_dqVar.jad_an.add(new defpackage.er3(this));
        jad_bo(this.jad_qd.jad_fs().floatValue() == 1.0f);
        jad_an(this.jad_qd);
    }
}
