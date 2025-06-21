package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public class jad_yl implements com.jd.ad.sdk.jad_mx.jad_fs, com.jd.ad.sdk.jad_kv.jad_dq.jad_an<java.lang.Object> {
    public final com.jd.ad.sdk.jad_mx.jad_fs.jad_an jad_an;
    public final com.jd.ad.sdk.jad_mx.jad_jt<?> jad_bo;
    public int jad_cp;
    public int jad_dq = -1;
    public com.jd.ad.sdk.jad_ju.jad_hu jad_er;
    public java.util.List<com.jd.ad.sdk.jad_qb.jad_na<java.io.File, ?>> jad_fs;
    public volatile com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_hu;
    public java.io.File jad_iv;
    public int jad_jt;
    public com.jd.ad.sdk.jad_mx.jad_zm jad_jw;

    public jad_yl(com.jd.ad.sdk.jad_mx.jad_jt<?> jad_jtVar, com.jd.ad.sdk.jad_mx.jad_fs.jad_an jad_anVar) {
        this.jad_bo = jad_jtVar;
        this.jad_an = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
    public void jad_an(@androidx.annotation.NonNull java.lang.Exception exc) {
        this.jad_an.jad_an(this.jad_jw, exc, this.jad_hu.jad_cp, com.jd.ad.sdk.jad_ju.jad_an.RESOURCE_DISK_CACHE);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
    public void jad_an(java.lang.Object obj) {
        this.jad_an.jad_an(this.jad_er, obj, this.jad_hu.jad_cp, com.jd.ad.sdk.jad_ju.jad_an.RESOURCE_DISK_CACHE, this.jad_jw);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs
    public boolean jad_an() {
        java.util.List<com.jd.ad.sdk.jad_ju.jad_hu> jad_an = this.jad_bo.jad_an();
        if (jad_an.isEmpty()) {
            return false;
        }
        java.util.List<java.lang.Class<?>> jad_dq = this.jad_bo.jad_dq();
        if (jad_dq.isEmpty()) {
            if (java.io.File.class.equals(this.jad_bo.jad_kx)) {
                return false;
            }
            throw new java.lang.IllegalStateException("Failed to find any load path from " + this.jad_bo.jad_dq.getClass() + " to " + this.jad_bo.jad_kx);
        }
        while (true) {
            java.util.List<com.jd.ad.sdk.jad_qb.jad_na<java.io.File, ?>> list = this.jad_fs;
            if (list != null) {
                if (this.jad_jt < list.size()) {
                    this.jad_hu = null;
                    boolean z = false;
                    while (!z) {
                        if (!(this.jad_jt < this.jad_fs.size())) {
                            break;
                        }
                        java.util.List<com.jd.ad.sdk.jad_qb.jad_na<java.io.File, ?>> list2 = this.jad_fs;
                        int i = this.jad_jt;
                        this.jad_jt = i + 1;
                        com.jd.ad.sdk.jad_qb.jad_na<java.io.File, ?> jad_naVar = list2.get(i);
                        java.io.File file = this.jad_iv;
                        com.jd.ad.sdk.jad_mx.jad_jt<?> jad_jtVar = this.jad_bo;
                        this.jad_hu = jad_naVar.jad_an(file, jad_jtVar.jad_er, jad_jtVar.jad_fs, jad_jtVar.jad_iv);
                        if (this.jad_hu != null && this.jad_bo.jad_cp(this.jad_hu.jad_cp.jad_an())) {
                            this.jad_hu.jad_cp.jad_an(this.jad_bo.jad_ob, this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
            int i2 = this.jad_dq + 1;
            this.jad_dq = i2;
            if (i2 >= jad_dq.size()) {
                int i3 = this.jad_cp + 1;
                this.jad_cp = i3;
                if (i3 >= jad_an.size()) {
                    return false;
                }
                this.jad_dq = 0;
            }
            com.jd.ad.sdk.jad_ju.jad_hu jad_huVar = jad_an.get(this.jad_cp);
            java.lang.Class<?> cls = jad_dq.get(this.jad_dq);
            com.jd.ad.sdk.jad_ju.jad_na<Z> jad_bo = this.jad_bo.jad_bo(cls);
            com.jd.ad.sdk.jad_mx.jad_jt<?> jad_jtVar2 = this.jad_bo;
            this.jad_jw = new com.jd.ad.sdk.jad_mx.jad_zm(jad_jtVar2.jad_cp.jad_an, jad_huVar, jad_jtVar2.jad_na, jad_jtVar2.jad_er, jad_jtVar2.jad_fs, jad_bo, cls, jad_jtVar2.jad_iv);
            java.io.File jad_an2 = jad_jtVar2.jad_bo().jad_an(this.jad_jw);
            this.jad_iv = jad_an2;
            if (jad_an2 != null) {
                this.jad_er = jad_huVar;
                this.jad_fs = this.jad_bo.jad_cp.jad_bo.jad_an((com.jd.ad.sdk.jad_gr.jad_hu) jad_an2);
                this.jad_jt = 0;
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs
    public void jad_cp() {
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar = this.jad_hu;
        if (jad_anVar != null) {
            jad_anVar.jad_cp.jad_cp();
        }
    }
}
