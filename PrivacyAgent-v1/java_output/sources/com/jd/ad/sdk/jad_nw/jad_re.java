package com.jd.ad.sdk.jad_nw;

/* loaded from: classes23.dex */
public class jad_re extends com.jd.ad.sdk.jad_nw.jad_an {
    public final com.jd.ad.sdk.jad_tc.jad_an jad_re;
    public final java.lang.String jad_sf;
    public final boolean jad_tg;
    public final com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_uh;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<android.graphics.ColorFilter, android.graphics.ColorFilter> jad_vi;

    public jad_re(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_re jad_reVar) {
        super(jad_mzVar, jad_anVar, com.jd.ad.sdk.jad_sb.jad_sf.jad_an(jad_reVar.jad_an()), com.jd.ad.sdk.jad_sb.jad_tg.jad_an(jad_reVar.jad_dq()), jad_reVar.jad_fs(), jad_reVar.jad_hu(), jad_reVar.jad_iv(), jad_reVar.jad_er(), jad_reVar.jad_cp());
        this.jad_re = jad_anVar;
        this.jad_sf = jad_reVar.jad_jt();
        this.jad_tg = jad_reVar.jad_jw();
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_an = jad_reVar.jad_bo().jad_an();
        this.jad_uh = jad_an;
        jad_an.jad_an(this);
        jad_anVar.jad_an(jad_an);
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_an, com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        if (this.jad_tg) {
            return;
        }
        android.graphics.Paint paint = this.jad_iv;
        com.jd.ad.sdk.jad_ox.jad_bo jad_boVar = (com.jd.ad.sdk.jad_ox.jad_bo) this.jad_uh;
        paint.setColor(jad_boVar.jad_bo(jad_boVar.jad_an(), jad_boVar.jad_cp()));
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.ColorFilter, android.graphics.ColorFilter> jad_anVar = this.jad_vi;
        if (jad_anVar != null) {
            this.jad_iv.setColorFilter(jad_anVar.jad_fs());
        }
        super.jad_an(canvas, matrix, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_nw.jad_an, com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, @androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        super.jad_an((com.jd.ad.sdk.jad_nw.jad_re) t, (com.jd.ad.sdk.jad_yh.jad_cp<com.jd.ad.sdk.jad_nw.jad_re>) jad_cpVar);
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_bo) {
            this.jad_uh.jad_er = jad_cpVar;
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_mx) {
            com.jd.ad.sdk.jad_ox.jad_an<android.graphics.ColorFilter, android.graphics.ColorFilter> jad_anVar = this.jad_vi;
            if (jad_anVar != null) {
                this.jad_re.jad_uh.remove(jad_anVar);
            }
            if (jad_cpVar == 0) {
                this.jad_vi = null;
                return;
            }
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            this.jad_vi = jad_qdVar;
            jad_qdVar.jad_an.add(this);
            this.jad_re.jad_an(this.jad_uh);
        }
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public java.lang.String jad_cp() {
        return this.jad_sf;
    }
}
