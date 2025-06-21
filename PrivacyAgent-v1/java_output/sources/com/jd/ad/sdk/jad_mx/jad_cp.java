package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public class jad_cp implements com.jd.ad.sdk.jad_mx.jad_fs, com.jd.ad.sdk.jad_kv.jad_dq.jad_an<java.lang.Object> {
    public final java.util.List<com.jd.ad.sdk.jad_ju.jad_hu> jad_an;
    public final com.jd.ad.sdk.jad_mx.jad_jt<?> jad_bo;
    public final com.jd.ad.sdk.jad_mx.jad_fs.jad_an jad_cp;
    public int jad_dq = -1;
    public com.jd.ad.sdk.jad_ju.jad_hu jad_er;
    public java.util.List<com.jd.ad.sdk.jad_qb.jad_na<java.io.File, ?>> jad_fs;
    public volatile com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_hu;
    public java.io.File jad_iv;
    public int jad_jt;

    public jad_cp(java.util.List<com.jd.ad.sdk.jad_ju.jad_hu> list, com.jd.ad.sdk.jad_mx.jad_jt<?> jad_jtVar, com.jd.ad.sdk.jad_mx.jad_fs.jad_an jad_anVar) {
        this.jad_an = list;
        this.jad_bo = jad_jtVar;
        this.jad_cp = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
    public void jad_an(@androidx.annotation.NonNull java.lang.Exception exc) {
        this.jad_cp.jad_an(this.jad_er, exc, this.jad_hu.jad_cp, com.jd.ad.sdk.jad_ju.jad_an.DATA_DISK_CACHE);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
    public void jad_an(java.lang.Object obj) {
        this.jad_cp.jad_an(this.jad_er, obj, this.jad_hu.jad_cp, com.jd.ad.sdk.jad_ju.jad_an.DATA_DISK_CACHE, this.jad_er);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        r8.jad_hu = null;
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        if (r0 != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        if (r8.jad_jt >= r8.jad_fs.size()) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        if (r3 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        r3 = r8.jad_fs;
        r4 = r8.jad_jt;
        r8.jad_jt = r4 + 1;
        r3 = r3.get(r4);
        r4 = r8.jad_iv;
        r5 = r8.jad_bo;
        r8.jad_hu = r3.jad_an(r4, r5.jad_er, r5.jad_fs, r5.jad_iv);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r8.jad_hu == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r8.jad_bo.jad_cp(r8.jad_hu.jad_cp.jad_an()) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        r8.jad_hu.jad_cp.jad_an(r8.jad_bo.jad_ob, r8);
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0026, code lost:
    
        r3 = false;
     */
    @Override // com.jd.ad.sdk.jad_mx.jad_fs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean jad_an() {
        while (true) {
            java.util.List<com.jd.ad.sdk.jad_qb.jad_na<java.io.File, ?>> list = this.jad_fs;
            if (list != null) {
                if (this.jad_jt < list.size()) {
                    break;
                }
            }
            int i = this.jad_dq + 1;
            this.jad_dq = i;
            if (i >= this.jad_an.size()) {
                return false;
            }
            com.jd.ad.sdk.jad_ju.jad_hu jad_huVar = this.jad_an.get(this.jad_dq);
            com.jd.ad.sdk.jad_mx.jad_jt<?> jad_jtVar = this.jad_bo;
            java.io.File jad_an = jad_jtVar.jad_bo().jad_an(new com.jd.ad.sdk.jad_mx.jad_dq(jad_huVar, jad_jtVar.jad_na));
            this.jad_iv = jad_an;
            if (jad_an != null) {
                this.jad_er = jad_huVar;
                this.jad_fs = this.jad_bo.jad_cp.jad_bo.jad_an((com.jd.ad.sdk.jad_gr.jad_hu) jad_an);
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
