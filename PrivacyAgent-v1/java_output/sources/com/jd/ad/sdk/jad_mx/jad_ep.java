package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public class jad_ep implements com.jd.ad.sdk.jad_mx.jad_fs, com.jd.ad.sdk.jad_mx.jad_fs.jad_an {
    public final com.jd.ad.sdk.jad_mx.jad_jt<?> jad_an;
    public final com.jd.ad.sdk.jad_mx.jad_fs.jad_an jad_bo;
    public volatile int jad_cp;
    public volatile com.jd.ad.sdk.jad_mx.jad_cp jad_dq;
    public volatile java.lang.Object jad_er;
    public volatile com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_fs;
    public volatile com.jd.ad.sdk.jad_mx.jad_dq jad_jt;

    public jad_ep(com.jd.ad.sdk.jad_mx.jad_jt<?> jad_jtVar, com.jd.ad.sdk.jad_mx.jad_fs.jad_an jad_anVar) {
        this.jad_an = jad_jtVar;
        this.jad_bo = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs.jad_an
    public void jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, java.lang.Exception exc, com.jd.ad.sdk.jad_kv.jad_dq<?> jad_dqVar, com.jd.ad.sdk.jad_ju.jad_an jad_anVar) {
        this.jad_bo.jad_an(jad_huVar, exc, jad_dqVar, this.jad_fs.jad_cp.jad_dq());
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs.jad_an
    public void jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, java.lang.Object obj, com.jd.ad.sdk.jad_kv.jad_dq<?> jad_dqVar, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, com.jd.ad.sdk.jad_ju.jad_hu jad_huVar2) {
        this.jad_bo.jad_an(jad_huVar, obj, jad_dqVar, this.jad_fs.jad_cp.jad_dq(), jad_huVar);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs
    public boolean jad_an() {
        if (this.jad_er != null) {
            java.lang.Object obj = this.jad_er;
            this.jad_er = null;
            try {
                if (!jad_an(obj)) {
                    return true;
                }
            } catch (java.io.IOException e) {
                if (android.util.Log.isLoggable("SourceGenerator", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("SourceGenerator", "Failed to properly rewind or write data to cache", e);
                }
            }
        }
        if (this.jad_dq != null && this.jad_dq.jad_an()) {
            return true;
        }
        this.jad_dq = null;
        this.jad_fs = null;
        boolean z = false;
        while (!z) {
            if (!(this.jad_cp < this.jad_an.jad_cp().size())) {
                break;
            }
            java.util.List<com.jd.ad.sdk.jad_qb.jad_na.jad_an<?>> jad_cp = this.jad_an.jad_cp();
            int i = this.jad_cp;
            this.jad_cp = i + 1;
            this.jad_fs = jad_cp.get(i);
            if (this.jad_fs != null && (this.jad_an.jad_pc.jad_an(this.jad_fs.jad_cp.jad_dq()) || this.jad_an.jad_cp(this.jad_fs.jad_cp.jad_an()))) {
                this.jad_fs.jad_cp.jad_an(this.jad_an.jad_ob, new com.jd.ad.sdk.jad_mx.jad_do(this, this.jad_fs));
                z = true;
            }
        }
        return z;
    }

    public final boolean jad_an(java.lang.Object obj) {
        long jad_an = com.jd.ad.sdk.jad_ir.jad_jt.jad_an();
        boolean z = false;
        try {
            com.jd.ad.sdk.jad_kv.jad_er jad_bo = this.jad_an.jad_cp.jad_bo.jad_bo(obj);
            java.lang.Object jad_an2 = jad_bo.jad_an();
            com.jd.ad.sdk.jad_ju.jad_dq<X> jad_an3 = this.jad_an.jad_an((com.jd.ad.sdk.jad_mx.jad_jt<?>) jad_an2);
            com.jd.ad.sdk.jad_mx.jad_er jad_erVar = new com.jd.ad.sdk.jad_mx.jad_er(jad_an3, jad_an2, this.jad_an.jad_iv);
            com.jd.ad.sdk.jad_ju.jad_hu jad_huVar = this.jad_fs.jad_an;
            com.jd.ad.sdk.jad_mx.jad_jt<?> jad_jtVar = this.jad_an;
            com.jd.ad.sdk.jad_mx.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_mx.jad_dq(jad_huVar, jad_jtVar.jad_na);
            com.jd.ad.sdk.jad_oz.jad_an jad_bo2 = jad_jtVar.jad_bo();
            jad_bo2.jad_an(jad_dqVar, jad_erVar);
            if (android.util.Log.isLoggable("SourceGenerator", 2)) {
                com.jd.ad.sdk.logger.Logger.v("SourceGenerator", "Finished encoding source to cache, key: " + jad_dqVar + ", data: " + obj + ", encoder: " + jad_an3 + ", duration: " + com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jad_an));
            }
            if (jad_bo2.jad_an(jad_dqVar) != null) {
                this.jad_jt = jad_dqVar;
                this.jad_dq = new com.jd.ad.sdk.jad_mx.jad_cp(java.util.Collections.singletonList(this.jad_fs.jad_an), this.jad_an, this);
                this.jad_fs.jad_cp.jad_bo();
                return true;
            }
            if (android.util.Log.isLoggable("SourceGenerator", 3)) {
                com.jd.ad.sdk.logger.Logger.d("SourceGenerator", "Attempt to write: " + this.jad_jt + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.jad_bo.jad_an(this.jad_fs.jad_an, jad_bo.jad_an(), this.jad_fs.jad_cp, this.jad_fs.jad_cp.jad_dq(), this.jad_fs.jad_an);
                return false;
            } catch (java.lang.Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    this.jad_fs.jad_cp.jad_bo();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs.jad_an
    public void jad_bo() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs
    public void jad_cp() {
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar = this.jad_fs;
        if (jad_anVar != null) {
            jad_anVar.jad_cp.jad_cp();
        }
    }
}
