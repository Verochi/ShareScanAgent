package com.jd.ad.sdk.jad_tc;

/* loaded from: classes23.dex */
public class jad_iv extends com.jd.ad.sdk.jad_tc.jad_an {
    public final java.lang.StringBuilder jad_do;
    public final android.graphics.RectF jad_ep;
    public final android.graphics.Matrix jad_fq;
    public final android.graphics.Paint jad_gr;
    public final android.graphics.Paint jad_hs;
    public final java.util.Map<com.jd.ad.sdk.jad_qz.jad_dq, java.util.List<com.jd.ad.sdk.jad_nw.jad_dq>> jad_it;
    public final androidx.collection.LongSparseArray<java.lang.String> jad_ju;
    public final com.jd.ad.sdk.jad_ox.jad_ob jad_kv;
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_lw;
    public final com.jd.ad.sdk.jad_lu.jad_jt jad_mx;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_ny;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_oz;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_pa;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_qb;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_rc;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_sd;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_te;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_uf;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_vg;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<android.graphics.Typeface, android.graphics.Typeface> jad_wh;

    public class jad_an extends android.graphics.Paint {
        public jad_an(com.jd.ad.sdk.jad_tc.jad_iv jad_ivVar, int i) {
            super(i);
            setStyle(android.graphics.Paint.Style.FILL);
        }
    }

    public class jad_bo extends android.graphics.Paint {
        public jad_bo(com.jd.ad.sdk.jad_tc.jad_iv jad_ivVar, int i) {
            super(i);
            setStyle(android.graphics.Paint.Style.STROKE);
        }
    }

    public static /* synthetic */ class jad_cp {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3).length];
            jad_an = iArr;
            try {
                iArr[0] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                jad_an[1] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                jad_an[2] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public jad_iv(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_er jad_erVar) {
        super(jad_mzVar, jad_erVar);
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2;
        com.jd.ad.sdk.jad_ra.jad_an jad_anVar;
        com.jd.ad.sdk.jad_ra.jad_an jad_anVar2;
        this.jad_do = new java.lang.StringBuilder(2);
        this.jad_ep = new android.graphics.RectF();
        this.jad_fq = new android.graphics.Matrix();
        this.jad_gr = new com.jd.ad.sdk.jad_tc.jad_iv.jad_an(this, 1);
        this.jad_hs = new com.jd.ad.sdk.jad_tc.jad_iv.jad_bo(this, 1);
        this.jad_it = new java.util.HashMap();
        this.jad_ju = new androidx.collection.LongSparseArray<>();
        this.jad_lw = jad_mzVar;
        this.jad_mx = jad_erVar.jad_an();
        com.jd.ad.sdk.jad_ox.jad_ob jad_dq = jad_erVar.jad_iv().jad_dq();
        this.jad_kv = jad_dq;
        jad_dq.jad_an(this);
        jad_an(jad_dq);
        com.jd.ad.sdk.jad_ra.jad_kx jad_jw = jad_erVar.jad_jw();
        if (jad_jw != null && (jad_anVar2 = jad_jw.jad_an) != null) {
            com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_an2 = jad_anVar2.jad_an();
            this.jad_ny = jad_an2;
            jad_an2.jad_an(this);
            jad_an(this.jad_ny);
        }
        if (jad_jw != null && (jad_anVar = jad_jw.jad_bo) != null) {
            com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_an3 = jad_anVar.jad_an();
            this.jad_pa = jad_an3;
            jad_an3.jad_an(this);
            jad_an(this.jad_pa);
        }
        if (jad_jw != null && (jad_boVar2 = jad_jw.jad_cp) != null) {
            com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an4 = jad_boVar2.jad_an();
            this.jad_rc = jad_an4;
            jad_an4.jad_an(this);
            jad_an(this.jad_rc);
        }
        if (jad_jw == null || (jad_boVar = jad_jw.jad_dq) == null) {
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an5 = jad_boVar.jad_an();
        this.jad_te = jad_an5;
        jad_an5.jad_an(this);
        jad_an(this.jad_te);
    }

    public final void jad_an(int i, android.graphics.Canvas canvas, float f) {
        float f2;
        int[] iArr = com.jd.ad.sdk.jad_tc.jad_iv.jad_cp.jad_an;
        if (i == 0) {
            throw null;
        }
        int i2 = iArr[i - 1];
        if (i2 == 2) {
            f2 = -f;
        } else if (i2 != 3) {
            return;
        } else {
            f2 = (-f) / 2.0f;
        }
        canvas.translate(f2, 0.0f);
    }

    public final void jad_an(android.graphics.Path path, android.graphics.Paint paint, android.graphics.Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == android.graphics.Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an, com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        super.jad_an(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.jad_mx.jad_jw.width(), this.jad_mx.jad_jw.height());
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an, com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, @androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        this.jad_vi.jad_an(t, jad_cpVar);
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_an) {
            com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_anVar = this.jad_oz;
            if (jad_anVar != null) {
                this.jad_uh.remove(jad_anVar);
            }
            if (jad_cpVar == null) {
                this.jad_oz = null;
                return;
            }
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            this.jad_oz = jad_qdVar;
            jad_qdVar.jad_an.add(this);
            jad_an(this.jad_oz);
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_bo) {
            com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_anVar2 = this.jad_qb;
            if (jad_anVar2 != null) {
                this.jad_uh.remove(jad_anVar2);
            }
            if (jad_cpVar == null) {
                this.jad_qb = null;
                return;
            }
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar2 = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            this.jad_qb = jad_qdVar2;
            jad_qdVar2.jad_an.add(this);
            jad_an(this.jad_qb);
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_sf) {
            com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar3 = this.jad_sd;
            if (jad_anVar3 != null) {
                this.jad_uh.remove(jad_anVar3);
            }
            if (jad_cpVar == null) {
                this.jad_sd = null;
                return;
            }
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar3 = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            this.jad_sd = jad_qdVar3;
            jad_qdVar3.jad_an.add(this);
            jad_an(this.jad_sd);
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_tg) {
            com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar4 = this.jad_uf;
            if (jad_anVar4 != null) {
                this.jad_uh.remove(jad_anVar4);
            }
            if (jad_cpVar == null) {
                this.jad_uf = null;
                return;
            }
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar4 = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            this.jad_uf = jad_qdVar4;
            jad_qdVar4.jad_an.add(this);
            jad_an(this.jad_uf);
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_hs) {
            com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar5 = this.jad_vg;
            if (jad_anVar5 != null) {
                this.jad_uh.remove(jad_anVar5);
            }
            if (jad_cpVar == null) {
                this.jad_vg = null;
                return;
            }
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar5 = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            this.jad_vg = jad_qdVar5;
            jad_qdVar5.jad_an.add(this);
            jad_an(this.jad_vg);
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_oz) {
            com.jd.ad.sdk.jad_ox.jad_an<android.graphics.Typeface, android.graphics.Typeface> jad_anVar6 = this.jad_wh;
            if (jad_anVar6 != null) {
                this.jad_uh.remove(jad_anVar6);
            }
            if (jad_cpVar == null) {
                this.jad_wh = null;
                return;
            }
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar6 = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            this.jad_wh = jad_qdVar6;
            jad_qdVar6.jad_an.add(this);
            jad_an(this.jad_wh);
        }
    }

    public final void jad_an(java.lang.String str, android.graphics.Paint paint, android.graphics.Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == android.graphics.Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x049f  */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v30, types: [T, java.lang.String] */
    @Override // com.jd.ad.sdk.jad_tc.jad_an
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void jad_bo(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        com.jd.ad.sdk.jad_py.jad_an jad_anVar;
        android.graphics.Typeface typeface;
        java.util.List list;
        int i2;
        java.lang.String sb;
        android.graphics.Paint paint;
        long j;
        java.util.List list2;
        int i3;
        java.util.List<com.jd.ad.sdk.jad_nw.jad_dq> list3;
        java.lang.String str;
        android.graphics.Paint paint2;
        com.jd.ad.sdk.jad_qz.jad_cp jad_cpVar;
        java.lang.String str2;
        canvas.save();
        int i4 = 1;
        if (!(this.jad_lw.jad_bo.jad_jt.size() > 0)) {
            canvas.concat(matrix);
        }
        com.jd.ad.sdk.jad_qz.jad_bo jad_fs = this.jad_kv.jad_fs();
        com.jd.ad.sdk.jad_qz.jad_cp jad_cpVar2 = this.jad_mx.jad_er.get(jad_fs.jad_bo);
        if (jad_cpVar2 == null) {
            canvas.restore();
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_anVar2 = this.jad_oz;
        if (jad_anVar2 == null && (jad_anVar2 = this.jad_ny) == null) {
            this.jad_gr.setColor(jad_fs.jad_hu);
        } else {
            this.jad_gr.setColor(jad_anVar2.jad_fs().intValue());
        }
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_anVar3 = this.jad_qb;
        if (jad_anVar3 == null && (jad_anVar3 = this.jad_pa) == null) {
            this.jad_hs.setColor(jad_fs.jad_iv);
        } else {
            this.jad_hs.setColor(jad_anVar3.jad_fs().intValue());
        }
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_anVar4 = this.jad_vi.jad_jw;
        int intValue = ((jad_anVar4 == null ? 100 : jad_anVar4.jad_fs().intValue()) * 255) / 100;
        this.jad_gr.setAlpha(intValue);
        this.jad_hs.setAlpha(intValue);
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar5 = this.jad_sd;
        if (jad_anVar5 == null && (jad_anVar5 = this.jad_rc) == null) {
            this.jad_hs.setStrokeWidth(com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * jad_fs.jad_jw * com.jd.ad.sdk.jad_xg.jad_hu.jad_an(matrix));
        } else {
            this.jad_hs.setStrokeWidth(jad_anVar5.jad_fs().floatValue());
        }
        if (this.jad_lw.jad_bo.jad_jt.size() > 0) {
            com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar6 = this.jad_vg;
            float floatValue = (jad_anVar6 != null ? jad_anVar6.jad_fs().floatValue() : jad_fs.jad_cp) / 100.0f;
            float jad_an2 = com.jd.ad.sdk.jad_xg.jad_hu.jad_an(matrix);
            java.lang.String str3 = jad_fs.jad_an;
            float jad_an3 = com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * jad_fs.jad_fs;
            java.util.List asList = java.util.Arrays.asList(str3.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
            int size = asList.size();
            int i5 = 0;
            while (i5 < size) {
                java.lang.String str4 = (java.lang.String) asList.get(i5);
                float f = 0.0f;
                int i6 = 0;
                while (i6 < str4.length()) {
                    com.jd.ad.sdk.jad_qz.jad_dq jad_dqVar = this.jad_mx.jad_jt.get(com.jd.ad.sdk.jad_qz.jad_dq.jad_an(str4.charAt(i6), jad_cpVar2.jad_an, jad_cpVar2.jad_cp));
                    if (jad_dqVar == null) {
                        jad_cpVar = jad_cpVar2;
                        str2 = str4;
                    } else {
                        jad_cpVar = jad_cpVar2;
                        str2 = str4;
                        f = (float) ((jad_dqVar.jad_cp * floatValue * com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * jad_an2) + f);
                    }
                    i6++;
                    str4 = str2;
                    jad_cpVar2 = jad_cpVar;
                }
                com.jd.ad.sdk.jad_qz.jad_cp jad_cpVar3 = jad_cpVar2;
                java.lang.String str5 = str4;
                canvas.save();
                jad_an(jad_fs.jad_dq, canvas, f);
                canvas.translate(0.0f, (i5 * jad_an3) - (((size - 1) * jad_an3) / 2.0f));
                int i7 = 0;
                while (i7 < str5.length()) {
                    java.lang.String str6 = str5;
                    com.jd.ad.sdk.jad_qz.jad_cp jad_cpVar4 = jad_cpVar3;
                    com.jd.ad.sdk.jad_qz.jad_dq jad_dqVar2 = this.jad_mx.jad_jt.get(com.jd.ad.sdk.jad_qz.jad_dq.jad_an(str6.charAt(i7), jad_cpVar4.jad_an, jad_cpVar4.jad_cp));
                    if (jad_dqVar2 == null) {
                        list2 = asList;
                        i3 = size;
                        str = str6;
                    } else {
                        if (this.jad_it.containsKey(jad_dqVar2)) {
                            list3 = this.jad_it.get(jad_dqVar2);
                            list2 = asList;
                            i3 = size;
                        } else {
                            java.util.List<com.jd.ad.sdk.jad_sb.jad_pc> list4 = jad_dqVar2.jad_an;
                            int size2 = list4.size();
                            java.util.ArrayList arrayList = new java.util.ArrayList(size2);
                            list2 = asList;
                            int i8 = 0;
                            while (i8 < size2) {
                                arrayList.add(new com.jd.ad.sdk.jad_nw.jad_dq(this.jad_lw, this, list4.get(i8)));
                                i8++;
                                size = size;
                                list4 = list4;
                                size2 = size2;
                            }
                            i3 = size;
                            this.jad_it.put(jad_dqVar2, arrayList);
                            list3 = arrayList;
                        }
                        int i9 = 0;
                        while (i9 < list3.size()) {
                            android.graphics.Path jad_bo2 = list3.get(i9).jad_bo();
                            jad_bo2.computeBounds(this.jad_ep, false);
                            this.jad_fq.set(matrix);
                            java.util.List<com.jd.ad.sdk.jad_nw.jad_dq> list5 = list3;
                            java.lang.String str7 = str6;
                            this.jad_fq.preTranslate(0.0f, (-jad_fs.jad_jt) * com.jd.ad.sdk.jad_xg.jad_hu.jad_an());
                            this.jad_fq.preScale(floatValue, floatValue);
                            jad_bo2.transform(this.jad_fq);
                            if (jad_fs.jad_kx) {
                                jad_an(jad_bo2, this.jad_gr, canvas);
                                paint2 = this.jad_hs;
                            } else {
                                jad_an(jad_bo2, this.jad_hs, canvas);
                                paint2 = this.jad_gr;
                            }
                            jad_an(jad_bo2, paint2, canvas);
                            i9++;
                            list3 = list5;
                            str6 = str7;
                        }
                        str = str6;
                        float jad_an4 = com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * ((float) jad_dqVar2.jad_cp) * floatValue * jad_an2;
                        float f2 = jad_fs.jad_er / 10.0f;
                        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar7 = this.jad_uf;
                        if (jad_anVar7 != null || (jad_anVar7 = this.jad_te) != null) {
                            f2 += jad_anVar7.jad_fs().floatValue();
                        }
                        canvas.translate((f2 * jad_an2) + jad_an4, 0.0f);
                    }
                    i7++;
                    asList = list2;
                    size = i3;
                    str5 = str;
                    jad_cpVar3 = jad_cpVar4;
                }
                canvas.restore();
                i5++;
                jad_cpVar2 = jad_cpVar3;
            }
        } else {
            com.jd.ad.sdk.jad_ox.jad_an<android.graphics.Typeface, android.graphics.Typeface> jad_anVar8 = this.jad_wh;
            if (jad_anVar8 == null || (typeface = jad_anVar8.jad_fs()) == null) {
                com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_lw;
                ?? r5 = jad_cpVar2.jad_an;
                ?? r6 = jad_cpVar2.jad_cp;
                if (jad_mzVar.getCallback() == null) {
                    jad_anVar = null;
                } else {
                    if (jad_mzVar.jad_ly == null) {
                        jad_mzVar.jad_ly = new com.jd.ad.sdk.jad_py.jad_an(jad_mzVar.getCallback(), jad_mzVar.jad_mz);
                    }
                    jad_anVar = jad_mzVar.jad_ly;
                }
                if (jad_anVar != null) {
                    com.jd.ad.sdk.jad_qz.jad_iv<java.lang.String> jad_ivVar = jad_anVar.jad_an;
                    jad_ivVar.jad_an = r5;
                    jad_ivVar.jad_bo = r6;
                    android.graphics.Typeface typeface2 = jad_anVar.jad_bo.get(jad_ivVar);
                    if (typeface2 == null) {
                        typeface2 = jad_anVar.jad_cp.get(r5);
                        if (typeface2 == null) {
                            typeface2 = jad_anVar.jad_er != null ? android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, 0) : null;
                            if (typeface2 == null) {
                                typeface2 = android.graphics.Typeface.createFromAsset(jad_anVar.jad_dq, "fonts/" + ((java.lang.String) r5) + jad_anVar.jad_fs);
                            }
                            jad_anVar.jad_cp.put(r5, typeface2);
                        }
                        boolean contains = r6.contains("Italic");
                        boolean contains2 = r6.contains("Bold");
                        int i10 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
                        if (typeface2.getStyle() != i10) {
                            typeface2 = android.graphics.Typeface.create(typeface2, i10);
                        }
                        jad_anVar.jad_bo.put(jad_anVar.jad_an, typeface2);
                    }
                    typeface = typeface2;
                } else {
                    typeface = null;
                }
                if (typeface == null) {
                    typeface = null;
                }
            }
            if (typeface != null) {
                java.lang.String str8 = jad_fs.jad_an;
                this.jad_lw.getClass();
                this.jad_gr.setTypeface(typeface);
                com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar9 = this.jad_vg;
                float floatValue2 = jad_anVar9 != null ? jad_anVar9.jad_fs().floatValue() : jad_fs.jad_cp;
                this.jad_gr.setTextSize(com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * floatValue2);
                this.jad_hs.setTypeface(this.jad_gr.getTypeface());
                this.jad_hs.setTextSize(this.jad_gr.getTextSize());
                float jad_an5 = com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * jad_fs.jad_fs;
                float f3 = jad_fs.jad_er / 10.0f;
                com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar10 = this.jad_uf;
                if (jad_anVar10 != null || (jad_anVar10 = this.jad_te) != null) {
                    f3 += jad_anVar10.jad_fs().floatValue();
                }
                float jad_an6 = ((com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * f3) * floatValue2) / 100.0f;
                java.util.List asList2 = java.util.Arrays.asList(str8.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
                int size3 = asList2.size();
                int i11 = 0;
                while (i11 < size3) {
                    java.lang.String str9 = (java.lang.String) asList2.get(i11);
                    float length = ((str9.length() - i4) * jad_an6) + this.jad_hs.measureText(str9);
                    canvas.save();
                    jad_an(jad_fs.jad_dq, canvas, length);
                    canvas.translate(0.0f, (i11 * jad_an5) - (((size3 - 1) * jad_an5) / 2.0f));
                    int i12 = 0;
                    while (i12 < str9.length()) {
                        int codePointAt = str9.codePointAt(i12);
                        int charCount = java.lang.Character.charCount(codePointAt) + i12;
                        while (charCount < str9.length()) {
                            int codePointAt2 = str9.codePointAt(charCount);
                            if (java.lang.Character.getType(codePointAt2) == 16 || java.lang.Character.getType(codePointAt2) == 27 || java.lang.Character.getType(codePointAt2) == 6 || java.lang.Character.getType(codePointAt2) == 28 || java.lang.Character.getType(codePointAt2) == 19) {
                                charCount += java.lang.Character.charCount(codePointAt2);
                                codePointAt = (codePointAt * 31) + codePointAt2;
                            }
                        }
                        try {
                            list = asList2;
                            i2 = size3;
                            j = codePointAt;
                        } catch (java.lang.Exception unused) {
                            list = asList2;
                            i2 = size3;
                        }
                        if (this.jad_ju.indexOfKey(j) >= 0) {
                            sb = this.jad_ju.get(j);
                            i12 += sb.length();
                            if (jad_fs.jad_kx) {
                                jad_an(sb, this.jad_hs, canvas);
                                paint = this.jad_gr;
                            } else {
                                jad_an(sb, this.jad_gr, canvas);
                                paint = this.jad_hs;
                            }
                            jad_an(sb, paint, canvas);
                            canvas.translate(this.jad_gr.measureText(sb) + jad_an6, 0.0f);
                            asList2 = list;
                            size3 = i2;
                        }
                        this.jad_do.setLength(0);
                        int i13 = i12;
                        while (i13 < charCount) {
                            int codePointAt3 = str9.codePointAt(i13);
                            this.jad_do.appendCodePoint(codePointAt3);
                            i13 += java.lang.Character.charCount(codePointAt3);
                        }
                        sb = this.jad_do.toString();
                        this.jad_ju.put(codePointAt, sb);
                        i12 += sb.length();
                        if (jad_fs.jad_kx) {
                        }
                        jad_an(sb, paint, canvas);
                        canvas.translate(this.jad_gr.measureText(sb) + jad_an6, 0.0f);
                        asList2 = list;
                        size3 = i2;
                    }
                    canvas.restore();
                    i11++;
                    asList2 = asList2;
                    size3 = size3;
                    i4 = 1;
                }
            }
        }
        canvas.restore();
    }
}
