package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public final class jad_dq implements com.jd.ad.sdk.jad_ju.jad_hu {
    public final com.jd.ad.sdk.jad_ju.jad_hu jad_bo;
    public final com.jd.ad.sdk.jad_ju.jad_hu jad_cp;

    public jad_dq(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, com.jd.ad.sdk.jad_ju.jad_hu jad_huVar2) {
        this.jad_bo = jad_huVar;
        this.jad_cp = jad_huVar2;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.jd.ad.sdk.jad_mx.jad_dq)) {
            return false;
        }
        com.jd.ad.sdk.jad_mx.jad_dq jad_dqVar = (com.jd.ad.sdk.jad_mx.jad_dq) obj;
        return this.jad_bo.equals(jad_dqVar.jad_bo) && this.jad_cp.equals(jad_dqVar.jad_cp);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        return this.jad_cp.hashCode() + (this.jad_bo.hashCode() * 31);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        this.jad_bo.jad_an(messageDigest);
        this.jad_cp.jad_an(messageDigest);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("DataCacheKey{sourceKey=");
        jad_an.append(this.jad_bo);
        jad_an.append(", signature=");
        jad_an.append(this.jad_cp);
        jad_an.append('}');
        return jad_an.toString();
    }
}
