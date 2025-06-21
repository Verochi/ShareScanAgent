package com.jd.ad.sdk.jad_hq;

/* loaded from: classes23.dex */
public final class jad_bo implements com.jd.ad.sdk.jad_ju.jad_hu {
    public final java.lang.Object jad_bo;

    public jad_bo(@androidx.annotation.NonNull java.lang.Object obj) {
        this.jad_bo = com.jd.ad.sdk.jad_ir.jad_kx.jad_an(obj);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.jd.ad.sdk.jad_hq.jad_bo) {
            return this.jad_bo.equals(((com.jd.ad.sdk.jad_hq.jad_bo) obj).jad_bo);
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        messageDigest.update(this.jad_bo.toString().getBytes(com.jd.ad.sdk.jad_ju.jad_hu.jad_an));
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("ObjectKey{object=");
        jad_an.append(this.jad_bo);
        jad_an.append('}');
        return jad_an.toString();
    }
}
