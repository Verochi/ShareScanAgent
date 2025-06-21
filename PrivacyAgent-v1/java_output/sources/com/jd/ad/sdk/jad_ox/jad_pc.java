package com.jd.ad.sdk.jad_ox;

/* loaded from: classes23.dex */
public class jad_pc {
    public final android.graphics.Matrix jad_an = new android.graphics.Matrix();
    public final android.graphics.Matrix jad_bo;
    public final android.graphics.Matrix jad_cp;
    public final android.graphics.Matrix jad_dq;
    public final float[] jad_er;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_fs;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_yh.jad_dq, com.jd.ad.sdk.jad_yh.jad_dq> jad_hu;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_iv;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<?, android.graphics.PointF> jad_jt;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_jw;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_dq jad_kx;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_dq jad_ly;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_mz;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_na;

    public jad_pc(com.jd.ad.sdk.jad_ra.jad_ly jad_lyVar) {
        this.jad_fs = jad_lyVar.jad_bo() == null ? null : jad_lyVar.jad_bo().jad_an();
        this.jad_jt = jad_lyVar.jad_er() == null ? null : jad_lyVar.jad_er().jad_an();
        this.jad_hu = jad_lyVar.jad_jt() == null ? null : jad_lyVar.jad_jt().jad_an();
        this.jad_iv = jad_lyVar.jad_fs() == null ? null : jad_lyVar.jad_fs().jad_an();
        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar = jad_lyVar.jad_hu() == null ? null : (com.jd.ad.sdk.jad_ox.jad_dq) jad_lyVar.jad_hu().jad_an();
        this.jad_kx = jad_dqVar;
        if (jad_dqVar != null) {
            this.jad_bo = new android.graphics.Matrix();
            this.jad_cp = new android.graphics.Matrix();
            this.jad_dq = new android.graphics.Matrix();
            this.jad_er = new float[9];
        } else {
            this.jad_bo = null;
            this.jad_cp = null;
            this.jad_dq = null;
            this.jad_er = null;
        }
        this.jad_ly = jad_lyVar.jad_iv() == null ? null : (com.jd.ad.sdk.jad_ox.jad_dq) jad_lyVar.jad_iv().jad_an();
        if (jad_lyVar.jad_dq() != null) {
            this.jad_jw = jad_lyVar.jad_dq().jad_an();
        }
        if (jad_lyVar.jad_jw() != null) {
            this.jad_mz = jad_lyVar.jad_jw().jad_an();
        } else {
            this.jad_mz = null;
        }
        if (jad_lyVar.jad_cp() != null) {
            this.jad_na = jad_lyVar.jad_cp().jad_an();
        } else {
            this.jad_na = null;
        }
    }

    public android.graphics.Matrix jad_an(float f) {
        com.jd.ad.sdk.jad_ox.jad_an<?, android.graphics.PointF> jad_anVar = this.jad_jt;
        android.graphics.PointF jad_fs = jad_anVar == null ? null : jad_anVar.jad_fs();
        com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_yh.jad_dq, com.jd.ad.sdk.jad_yh.jad_dq> jad_anVar2 = this.jad_hu;
        com.jd.ad.sdk.jad_yh.jad_dq jad_fs2 = jad_anVar2 == null ? null : jad_anVar2.jad_fs();
        this.jad_an.reset();
        if (jad_fs != null) {
            this.jad_an.preTranslate(jad_fs.x * f, jad_fs.y * f);
        }
        if (jad_fs2 != null) {
            double d = f;
            this.jad_an.preScale((float) java.lang.Math.pow(jad_fs2.jad_an, d), (float) java.lang.Math.pow(jad_fs2.jad_bo, d));
        }
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar3 = this.jad_iv;
        if (jad_anVar3 != null) {
            float floatValue = jad_anVar3.jad_fs().floatValue();
            com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_anVar4 = this.jad_fs;
            android.graphics.PointF jad_fs3 = jad_anVar4 != null ? jad_anVar4.jad_fs() : null;
            this.jad_an.preRotate(floatValue * f, jad_fs3 == null ? 0.0f : jad_fs3.x, jad_fs3 != null ? jad_fs3.y : 0.0f);
        }
        return this.jad_an;
    }

    public final void jad_an() {
        for (int i = 0; i < 9; i++) {
            this.jad_er[i] = 0.0f;
        }
    }

    public void jad_an(com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an interfaceC0397jad_an) {
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_anVar = this.jad_jw;
        if (jad_anVar != null) {
            jad_anVar.jad_an.add(interfaceC0397jad_an);
        }
        com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_anVar2 = this.jad_mz;
        if (jad_anVar2 != null) {
            jad_anVar2.jad_an.add(interfaceC0397jad_an);
        }
        com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_anVar3 = this.jad_na;
        if (jad_anVar3 != null) {
            jad_anVar3.jad_an.add(interfaceC0397jad_an);
        }
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_anVar4 = this.jad_fs;
        if (jad_anVar4 != null) {
            jad_anVar4.jad_an.add(interfaceC0397jad_an);
        }
        com.jd.ad.sdk.jad_ox.jad_an<?, android.graphics.PointF> jad_anVar5 = this.jad_jt;
        if (jad_anVar5 != null) {
            jad_anVar5.jad_an.add(interfaceC0397jad_an);
        }
        com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_yh.jad_dq, com.jd.ad.sdk.jad_yh.jad_dq> jad_anVar6 = this.jad_hu;
        if (jad_anVar6 != null) {
            jad_anVar6.jad_an.add(interfaceC0397jad_an);
        }
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar7 = this.jad_iv;
        if (jad_anVar7 != null) {
            jad_anVar7.jad_an.add(interfaceC0397jad_an);
        }
        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar = this.jad_kx;
        if (jad_dqVar != null) {
            jad_dqVar.jad_an.add(interfaceC0397jad_an);
        }
        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar2 = this.jad_ly;
        if (jad_dqVar2 != null) {
            jad_dqVar2.jad_an.add(interfaceC0397jad_an);
        }
    }

    public void jad_an(com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        jad_anVar.jad_an(this.jad_jw);
        jad_anVar.jad_an(this.jad_mz);
        jad_anVar.jad_an(this.jad_na);
        jad_anVar.jad_an(this.jad_fs);
        jad_anVar.jad_an(this.jad_jt);
        jad_anVar.jad_an(this.jad_hu);
        jad_anVar.jad_an(this.jad_iv);
        jad_anVar.jad_an(this.jad_kx);
        jad_anVar.jad_an(this.jad_ly);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> boolean jad_an(T t, @androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar;
        com.jd.ad.sdk.jad_ox.jad_an jad_anVar;
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_fs) {
            jad_anVar = this.jad_fs;
            if (jad_anVar == null) {
                this.jad_fs = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, new android.graphics.PointF());
                return true;
            }
        } else if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_jt) {
            jad_anVar = this.jad_jt;
            if (jad_anVar == null) {
                this.jad_jt = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, new android.graphics.PointF());
                return true;
            }
        } else {
            if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_hu) {
                com.jd.ad.sdk.jad_ox.jad_an<?, android.graphics.PointF> jad_anVar2 = this.jad_jt;
                if (jad_anVar2 instanceof com.jd.ad.sdk.jad_ox.jad_na) {
                    ((com.jd.ad.sdk.jad_ox.jad_na) jad_anVar2).jad_mz = jad_cpVar;
                    return true;
                }
            }
            if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_iv) {
                com.jd.ad.sdk.jad_ox.jad_an<?, android.graphics.PointF> jad_anVar3 = this.jad_jt;
                if (jad_anVar3 instanceof com.jd.ad.sdk.jad_ox.jad_na) {
                    ((com.jd.ad.sdk.jad_ox.jad_na) jad_anVar3).jad_na = jad_cpVar;
                    return true;
                }
            }
            if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_ob) {
                jad_anVar = this.jad_hu;
                if (jad_anVar == null) {
                    this.jad_hu = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, new com.jd.ad.sdk.jad_yh.jad_dq());
                    return true;
                }
            } else if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_pc) {
                jad_anVar = this.jad_iv;
                if (jad_anVar == null) {
                    this.jad_iv = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, java.lang.Float.valueOf(0.0f));
                    return true;
                }
            } else if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_cp) {
                jad_anVar = this.jad_jw;
                if (jad_anVar == null) {
                    this.jad_jw = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, 100);
                    return true;
                }
            } else if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_ep) {
                jad_anVar = this.jad_mz;
                if (jad_anVar == null) {
                    this.jad_mz = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, java.lang.Float.valueOf(100.0f));
                    return true;
                }
            } else {
                if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_fq) {
                    if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_qd) {
                        if (this.jad_kx == null) {
                            this.jad_kx = new com.jd.ad.sdk.jad_ox.jad_dq(java.util.Collections.singletonList(new com.jd.ad.sdk.jad_yh.jad_an(java.lang.Float.valueOf(0.0f))));
                        }
                        jad_dqVar = this.jad_kx;
                    } else {
                        if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_re) {
                            return false;
                        }
                        if (this.jad_ly == null) {
                            this.jad_ly = new com.jd.ad.sdk.jad_ox.jad_dq(java.util.Collections.singletonList(new com.jd.ad.sdk.jad_yh.jad_an(java.lang.Float.valueOf(0.0f))));
                        }
                        jad_dqVar = this.jad_ly;
                    }
                    jad_dqVar.jad_er = jad_cpVar;
                    return true;
                }
                jad_anVar = this.jad_na;
                if (jad_anVar == null) {
                    this.jad_na = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, java.lang.Float.valueOf(100.0f));
                    return true;
                }
            }
        }
        jad_anVar.jad_er = jad_cpVar;
        return true;
    }

    public android.graphics.Matrix jad_bo() {
        this.jad_an.reset();
        com.jd.ad.sdk.jad_ox.jad_an<?, android.graphics.PointF> jad_anVar = this.jad_jt;
        if (jad_anVar != null) {
            android.graphics.PointF jad_fs = jad_anVar.jad_fs();
            float f = jad_fs.x;
            if (f != 0.0f || jad_fs.y != 0.0f) {
                this.jad_an.preTranslate(f, jad_fs.y);
            }
        }
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar2 = this.jad_iv;
        if (jad_anVar2 != null) {
            float floatValue = jad_anVar2 instanceof com.jd.ad.sdk.jad_ox.jad_qd ? jad_anVar2.jad_fs().floatValue() : ((com.jd.ad.sdk.jad_ox.jad_dq) jad_anVar2).jad_hu();
            if (floatValue != 0.0f) {
                this.jad_an.preRotate(floatValue);
            }
        }
        if (this.jad_kx != null) {
            float cos = this.jad_ly == null ? 0.0f : (float) java.lang.Math.cos(java.lang.Math.toRadians((-r3.jad_hu()) + 90.0f));
            float sin = this.jad_ly == null ? 1.0f : (float) java.lang.Math.sin(java.lang.Math.toRadians((-r5.jad_hu()) + 90.0f));
            float tan = (float) java.lang.Math.tan(java.lang.Math.toRadians(r0.jad_hu()));
            jad_an();
            float[] fArr = this.jad_er;
            fArr[0] = cos;
            fArr[1] = sin;
            float f2 = -sin;
            fArr[3] = f2;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.jad_bo.setValues(fArr);
            jad_an();
            float[] fArr2 = this.jad_er;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.jad_cp.setValues(fArr2);
            jad_an();
            float[] fArr3 = this.jad_er;
            fArr3[0] = cos;
            fArr3[1] = f2;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.jad_dq.setValues(fArr3);
            this.jad_cp.preConcat(this.jad_bo);
            this.jad_dq.preConcat(this.jad_cp);
            this.jad_an.preConcat(this.jad_dq);
        }
        com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_yh.jad_dq, com.jd.ad.sdk.jad_yh.jad_dq> jad_anVar3 = this.jad_hu;
        if (jad_anVar3 != null) {
            com.jd.ad.sdk.jad_yh.jad_dq jad_fs2 = jad_anVar3.jad_fs();
            float f3 = jad_fs2.jad_an;
            if (f3 != 1.0f || jad_fs2.jad_bo != 1.0f) {
                this.jad_an.preScale(f3, jad_fs2.jad_bo);
            }
        }
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_anVar4 = this.jad_fs;
        if (jad_anVar4 != null) {
            android.graphics.PointF jad_fs3 = jad_anVar4.jad_fs();
            float f4 = jad_fs3.x;
            if (f4 != 0.0f || jad_fs3.y != 0.0f) {
                this.jad_an.preTranslate(-f4, -jad_fs3.y);
            }
        }
        return this.jad_an;
    }
}
