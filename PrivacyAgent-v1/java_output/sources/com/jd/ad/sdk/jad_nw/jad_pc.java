package com.jd.ad.sdk.jad_nw;

/* loaded from: classes23.dex */
public class jad_pc implements com.jd.ad.sdk.jad_nw.jad_er, com.jd.ad.sdk.jad_nw.jad_mz, com.jd.ad.sdk.jad_nw.jad_jw, com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an, com.jd.ad.sdk.jad_nw.jad_kx {
    public final android.graphics.Matrix jad_an = new android.graphics.Matrix();
    public final android.graphics.Path jad_bo = new android.graphics.Path();
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_cp;
    public final com.jd.ad.sdk.jad_tc.jad_an jad_dq;
    public final java.lang.String jad_er;
    public final boolean jad_fs;
    public final com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_hu;
    public final com.jd.ad.sdk.jad_ox.jad_pc jad_iv;
    public final com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_jt;
    public com.jd.ad.sdk.jad_nw.jad_dq jad_jw;

    public jad_pc(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_mz jad_mzVar2) {
        this.jad_cp = jad_mzVar;
        this.jad_dq = jad_anVar;
        this.jad_er = jad_mzVar2.jad_bo();
        this.jad_fs = jad_mzVar2.jad_er();
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an = jad_mzVar2.jad_an().jad_an();
        this.jad_jt = jad_an;
        jad_anVar.jad_an(jad_an);
        jad_an.jad_an(this);
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an2 = jad_mzVar2.jad_cp().jad_an();
        this.jad_hu = jad_an2;
        jad_anVar.jad_an(jad_an2);
        jad_an2.jad_an(this);
        com.jd.ad.sdk.jad_ox.jad_pc jad_an3 = jad_mzVar2.jad_dq().jad_an();
        this.jad_iv = jad_an3;
        jad_an3.jad_an(jad_anVar);
        jad_an3.jad_an(this);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an
    public void jad_an() {
        this.jad_cp.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        float floatValue = this.jad_jt.jad_fs().floatValue();
        float floatValue2 = this.jad_hu.jad_fs().floatValue();
        float floatValue3 = this.jad_iv.jad_mz.jad_fs().floatValue() / 100.0f;
        float floatValue4 = this.jad_iv.jad_na.jad_fs().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.jad_an.set(matrix);
            float f = i2;
            this.jad_an.preConcat(this.jad_iv.jad_an(f + floatValue2));
            this.jad_jw.jad_an(canvas, this.jad_an, (int) (com.jd.ad.sdk.jad_xg.jad_jt.jad_an(floatValue3, floatValue4, f / floatValue) * i));
        }
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        this.jad_jw.jad_an(rectF, matrix, z);
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, java.util.List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_erVar, i, list, jad_erVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, @androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_anVar;
        if (this.jad_iv.jad_an(t, jad_cpVar)) {
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_uh) {
            jad_anVar = this.jad_jt;
        } else if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_vi) {
            return;
        } else {
            jad_anVar = this.jad_hu;
        }
        jad_anVar.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(java.util.List<com.jd.ad.sdk.jad_nw.jad_cp> list, java.util.List<com.jd.ad.sdk.jad_nw.jad_cp> list2) {
        this.jad_jw.jad_an(list, list2);
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_jw
    public void jad_an(java.util.ListIterator<com.jd.ad.sdk.jad_nw.jad_cp> listIterator) {
        if (this.jad_jw != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        java.util.Collections.reverse(arrayList);
        this.jad_jw = new com.jd.ad.sdk.jad_nw.jad_dq(this.jad_cp, this.jad_dq, "Repeater", this.jad_fs, arrayList, null);
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_mz
    public android.graphics.Path jad_bo() {
        android.graphics.Path jad_bo = this.jad_jw.jad_bo();
        this.jad_bo.reset();
        float floatValue = this.jad_jt.jad_fs().floatValue();
        float floatValue2 = this.jad_hu.jad_fs().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.jad_an.set(this.jad_iv.jad_an(i + floatValue2));
            this.jad_bo.addPath(jad_bo, this.jad_an);
        }
        return this.jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public java.lang.String jad_cp() {
        return this.jad_er;
    }
}
