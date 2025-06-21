package com.jd.ad.sdk.jad_nw;

/* loaded from: classes23.dex */
public class jad_na implements com.jd.ad.sdk.jad_nw.jad_mz, com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an, com.jd.ad.sdk.jad_nw.jad_kx {
    public final java.lang.String jad_bo;
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_cp;
    public final int jad_dq;
    public final boolean jad_er;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_fs;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_hu;

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_iv;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, android.graphics.PointF> jad_jt;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_jw;

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_kx;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_ly;
    public boolean jad_na;
    public final android.graphics.Path jad_an = new android.graphics.Path();
    public final com.jd.ad.sdk.jad_nw.jad_bo jad_mz = new com.jd.ad.sdk.jad_nw.jad_bo();

    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(2).length];
            jad_an = iArr;
            try {
                iArr[0] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                jad_an[1] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public jad_na(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_kx jad_kxVar) {
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar2;
        this.jad_cp = jad_mzVar;
        this.jad_bo = jad_kxVar.jad_cp();
        int jad_iv = jad_kxVar.jad_iv();
        this.jad_dq = jad_iv;
        this.jad_er = jad_kxVar.jad_jw();
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an2 = jad_kxVar.jad_fs().jad_an();
        this.jad_fs = jad_an2;
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_an3 = jad_kxVar.jad_jt().jad_an();
        this.jad_jt = jad_an3;
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an4 = jad_kxVar.jad_hu().jad_an();
        this.jad_hu = jad_an4;
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an5 = jad_kxVar.jad_dq().jad_an();
        this.jad_jw = jad_an5;
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an6 = jad_kxVar.jad_er().jad_an();
        this.jad_ly = jad_an6;
        if (jad_iv == 1) {
            this.jad_iv = jad_kxVar.jad_an().jad_an();
            jad_anVar2 = jad_kxVar.jad_bo().jad_an();
        } else {
            jad_anVar2 = null;
            this.jad_iv = null;
        }
        this.jad_kx = jad_anVar2;
        jad_anVar.jad_an(jad_an2);
        jad_anVar.jad_an(jad_an3);
        jad_anVar.jad_an(jad_an4);
        jad_anVar.jad_an(jad_an5);
        jad_anVar.jad_an(jad_an6);
        if (jad_iv == 1) {
            jad_anVar.jad_an(this.jad_iv);
            jad_anVar.jad_an(this.jad_kx);
        }
        jad_an2.jad_an(this);
        jad_an3.jad_an(this);
        jad_an4.jad_an(this);
        jad_an5.jad_an(this);
        jad_an6.jad_an(this);
        if (jad_iv == 1) {
            this.jad_iv.jad_an(this);
            this.jad_kx.jad_an(this);
        }
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an
    public void jad_an() {
        this.jad_na = false;
        this.jad_cp.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, java.util.List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_erVar, i, list, jad_erVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, @androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ox.jad_an jad_anVar;
        com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_anVar2;
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_wj) {
            jad_anVar = this.jad_fs;
        } else if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_xk) {
            jad_anVar = this.jad_hu;
        } else {
            if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_na) {
                if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_yl || (jad_anVar2 = this.jad_iv) == null) {
                    if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_zm) {
                        jad_anVar = this.jad_jw;
                    } else if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_cn || (jad_anVar2 = this.jad_kx) == null) {
                        if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_do) {
                            return;
                        } else {
                            jad_anVar = this.jad_ly;
                        }
                    }
                }
                jad_anVar2.jad_er = jad_cpVar;
                return;
            }
            jad_anVar = this.jad_jt;
        }
        jad_anVar.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(java.util.List<com.jd.ad.sdk.jad_nw.jad_cp> list, java.util.List<com.jd.ad.sdk.jad_nw.jad_cp> list2) {
        for (int i = 0; i < list.size(); i++) {
            com.jd.ad.sdk.jad_nw.jad_cp jad_cpVar = list.get(i);
            if (jad_cpVar instanceof com.jd.ad.sdk.jad_nw.jad_sf) {
                com.jd.ad.sdk.jad_nw.jad_sf jad_sfVar = (com.jd.ad.sdk.jad_nw.jad_sf) jad_cpVar;
                if (jad_sfVar.jad_dq == 1) {
                    this.jad_mz.jad_an.add(jad_sfVar);
                    jad_sfVar.jad_cp.add(this);
                }
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_mz
    public android.graphics.Path jad_bo() {
        float sin;
        float f;
        double d;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        double d2;
        float f7;
        float f8;
        float f9;
        float f10;
        int i;
        double d3;
        if (this.jad_na) {
            return this.jad_an;
        }
        this.jad_an.reset();
        if (this.jad_er) {
            this.jad_na = true;
            return this.jad_an;
        }
        int i2 = com.jd.ad.sdk.jad_nw.jad_na.jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(this.jad_dq)];
        float f11 = 0.0f;
        if (i2 == 1) {
            float floatValue = this.jad_fs.jad_fs().floatValue();
            double radians = java.lang.Math.toRadians((this.jad_hu != null ? r2.jad_fs().floatValue() : 0.0d) - 90.0d);
            double d4 = floatValue;
            float f12 = (float) (6.283185307179586d / d4);
            float f13 = f12 / 2.0f;
            float f14 = floatValue - ((int) floatValue);
            if (f14 != 0.0f) {
                radians += (1.0f - f14) * f13;
            }
            float floatValue2 = this.jad_jw.jad_fs().floatValue();
            float floatValue3 = this.jad_iv.jad_fs().floatValue();
            com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_anVar = this.jad_kx;
            float floatValue4 = jad_anVar != null ? jad_anVar.jad_fs().floatValue() / 100.0f : 0.0f;
            com.jd.ad.sdk.jad_ox.jad_an<?, java.lang.Float> jad_anVar2 = this.jad_ly;
            float floatValue5 = jad_anVar2 != null ? jad_anVar2.jad_fs().floatValue() / 100.0f : 0.0f;
            if (f14 != 0.0f) {
                float f15 = ((floatValue2 - floatValue3) * f14) + floatValue3;
                double d5 = f15;
                f3 = f15;
                f2 = (float) (java.lang.Math.cos(radians) * d5);
                float sin2 = (float) (d5 * java.lang.Math.sin(radians));
                this.jad_an.moveTo(f2, sin2);
                d = radians + ((f12 * f14) / 2.0f);
                f = f13;
                sin = sin2;
            } else {
                double d6 = floatValue2;
                float cos = (float) (java.lang.Math.cos(radians) * d6);
                sin = (float) (d6 * java.lang.Math.sin(radians));
                this.jad_an.moveTo(cos, sin);
                f = f13;
                d = radians + f;
                f2 = cos;
                f3 = 0.0f;
            }
            double ceil = java.lang.Math.ceil(d4) * 2.0d;
            float f16 = f2;
            int i3 = 0;
            boolean z = false;
            while (true) {
                double d7 = i3;
                if (d7 >= ceil) {
                    break;
                }
                float f17 = z ? floatValue2 : floatValue3;
                if (f3 == 0.0f || d7 != ceil - 2.0d) {
                    f4 = f12;
                    f5 = f;
                } else {
                    f4 = f12;
                    f5 = (f12 * f14) / 2.0f;
                }
                if (f3 == 0.0f || d7 != ceil - 1.0d) {
                    f6 = f;
                    d2 = d7;
                    f7 = f17;
                } else {
                    f6 = f;
                    d2 = d7;
                    f7 = f3;
                }
                double d8 = f7;
                double d9 = ceil;
                float cos2 = (float) (java.lang.Math.cos(d) * d8);
                float sin3 = (float) (java.lang.Math.sin(d) * d8);
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.jad_an.lineTo(cos2, sin3);
                    f8 = floatValue2;
                    f9 = floatValue5;
                    f10 = floatValue4;
                } else {
                    f8 = floatValue2;
                    double atan2 = (float) (java.lang.Math.atan2(sin, f16) - 1.5707963267948966d);
                    float cos3 = (float) java.lang.Math.cos(atan2);
                    float sin4 = (float) java.lang.Math.sin(atan2);
                    f9 = floatValue5;
                    f10 = floatValue4;
                    double atan22 = (float) (java.lang.Math.atan2(sin3, cos2) - 1.5707963267948966d);
                    float cos4 = (float) java.lang.Math.cos(atan22);
                    float sin5 = (float) java.lang.Math.sin(atan22);
                    float f18 = z ? f10 : f9;
                    float f19 = z ? f9 : f10;
                    float f20 = (z ? floatValue3 : f8) * f18 * 0.47829f;
                    float f21 = cos3 * f20;
                    float f22 = f20 * sin4;
                    float f23 = (z ? f8 : floatValue3) * f19 * 0.47829f;
                    float f24 = cos4 * f23;
                    float f25 = f23 * sin5;
                    if (f14 != 0.0f) {
                        if (i3 == 0) {
                            f21 *= f14;
                            f22 *= f14;
                        } else if (d2 == d9 - 1.0d) {
                            f24 *= f14;
                            f25 *= f14;
                        }
                    }
                    this.jad_an.cubicTo(f16 - f21, sin - f22, cos2 + f24, sin3 + f25, cos2, sin3);
                }
                d += f5;
                z = !z;
                i3++;
                f16 = cos2;
                sin = sin3;
                floatValue2 = f8;
                f12 = f4;
                f = f6;
                floatValue4 = f10;
                floatValue5 = f9;
                ceil = d9;
            }
            android.graphics.PointF jad_fs = this.jad_jt.jad_fs();
            this.jad_an.offset(jad_fs.x, jad_fs.y);
            this.jad_an.close();
        } else if (i2 == 2) {
            int floor = (int) java.lang.Math.floor(this.jad_fs.jad_fs().floatValue());
            double radians2 = java.lang.Math.toRadians((this.jad_hu != null ? r14.jad_fs().floatValue() : 0.0d) - 90.0d);
            double d10 = floor;
            float floatValue6 = this.jad_ly.jad_fs().floatValue() / 100.0f;
            float floatValue7 = this.jad_jw.jad_fs().floatValue();
            double d11 = floatValue7;
            float cos5 = (float) (java.lang.Math.cos(radians2) * d11);
            float sin6 = (float) (java.lang.Math.sin(radians2) * d11);
            this.jad_an.moveTo(cos5, sin6);
            double d12 = (float) (6.283185307179586d / d10);
            double d13 = radians2 + d12;
            double ceil2 = java.lang.Math.ceil(d10);
            float f26 = cos5;
            int i4 = 0;
            while (i4 < ceil2) {
                float cos6 = (float) (java.lang.Math.cos(d13) * d11);
                double d14 = ceil2;
                float sin7 = (float) (java.lang.Math.sin(d13) * d11);
                if (floatValue6 != f11) {
                    d3 = d11;
                    double atan23 = (float) (java.lang.Math.atan2(sin6, f26) - 1.5707963267948966d);
                    float cos7 = (float) java.lang.Math.cos(atan23);
                    float sin8 = (float) java.lang.Math.sin(atan23);
                    i = i4;
                    double atan24 = (float) (java.lang.Math.atan2(sin7, cos6) - 1.5707963267948966d);
                    float f27 = floatValue7 * floatValue6 * 0.25f;
                    this.jad_an.cubicTo(f26 - (cos7 * f27), sin6 - (sin8 * f27), cos6 + (((float) java.lang.Math.cos(atan24)) * f27), sin7 + (f27 * ((float) java.lang.Math.sin(atan24))), cos6, sin7);
                } else {
                    i = i4;
                    d3 = d11;
                    this.jad_an.lineTo(cos6, sin7);
                }
                d13 += d12;
                i4 = i + 1;
                f26 = cos6;
                sin6 = sin7;
                ceil2 = d14;
                d11 = d3;
                f11 = 0.0f;
            }
            android.graphics.PointF jad_fs2 = this.jad_jt.jad_fs();
            this.jad_an.offset(jad_fs2.x, jad_fs2.y);
            this.jad_an.close();
        }
        this.jad_an.close();
        this.jad_mz.jad_an(this.jad_an);
        this.jad_na = true;
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public java.lang.String jad_cp() {
        return this.jad_bo;
    }
}
