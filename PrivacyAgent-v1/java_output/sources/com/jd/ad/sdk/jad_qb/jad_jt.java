package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_jt implements com.jd.ad.sdk.jad_ju.jad_hu {
    public final com.jd.ad.sdk.jad_qb.jad_hu jad_bo;

    @androidx.annotation.Nullable
    public final java.net.URL jad_cp;

    @androidx.annotation.Nullable
    public final java.lang.String jad_dq;

    @androidx.annotation.Nullable
    public java.lang.String jad_er;

    @androidx.annotation.Nullable
    public java.net.URL jad_fs;
    public int jad_hu;

    @androidx.annotation.Nullable
    public volatile byte[] jad_jt;

    public jad_jt(java.lang.String str, com.jd.ad.sdk.jad_qb.jad_hu jad_huVar) {
        this.jad_cp = null;
        this.jad_dq = com.jd.ad.sdk.jad_ir.jad_kx.jad_an(str);
        this.jad_bo = (com.jd.ad.sdk.jad_qb.jad_hu) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_huVar);
    }

    public jad_jt(java.net.URL url, com.jd.ad.sdk.jad_qb.jad_hu jad_huVar) {
        this.jad_cp = (java.net.URL) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(url);
        this.jad_dq = null;
        this.jad_bo = (com.jd.ad.sdk.jad_qb.jad_hu) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_huVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.jd.ad.sdk.jad_qb.jad_jt)) {
            return false;
        }
        com.jd.ad.sdk.jad_qb.jad_jt jad_jtVar = (com.jd.ad.sdk.jad_qb.jad_jt) obj;
        return jad_an().equals(jad_jtVar.jad_an()) && this.jad_bo.equals(jad_jtVar.jad_bo);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        if (this.jad_hu == 0) {
            int hashCode = jad_an().hashCode();
            this.jad_hu = hashCode;
            this.jad_hu = this.jad_bo.hashCode() + (hashCode * 31);
        }
        return this.jad_hu;
    }

    public java.lang.String jad_an() {
        java.lang.String str = this.jad_dq;
        return str != null ? str : ((java.net.URL) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_cp)).toString();
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        if (this.jad_jt == null) {
            this.jad_jt = jad_an().getBytes(com.jd.ad.sdk.jad_ju.jad_hu.jad_an);
        }
        messageDigest.update(this.jad_jt);
    }

    public java.net.URL jad_bo() {
        if (this.jad_fs == null) {
            if (android.text.TextUtils.isEmpty(this.jad_er)) {
                java.lang.String str = this.jad_dq;
                if (android.text.TextUtils.isEmpty(str)) {
                    str = ((java.net.URL) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_cp)).toString();
                }
                this.jad_er = android.net.Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.jad_fs = new java.net.URL(this.jad_er);
        }
        return this.jad_fs;
    }

    public java.lang.String toString() {
        return jad_an();
    }
}
