package com.jd.ad.sdk.jad_ju;

/* loaded from: classes23.dex */
public final class jad_jw implements com.jd.ad.sdk.jad_ju.jad_hu {
    public final androidx.collection.ArrayMap<com.jd.ad.sdk.jad_ju.jad_iv<?>, java.lang.Object> jad_bo = new com.jd.ad.sdk.jad_ir.jad_bo();

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.jd.ad.sdk.jad_ju.jad_jw) {
            return this.jad_bo.equals(((com.jd.ad.sdk.jad_ju.jad_jw) obj).jad_bo);
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    @androidx.annotation.Nullable
    public <T> T jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_iv<T> jad_ivVar) {
        return this.jad_bo.containsKey(jad_ivVar) ? (T) this.jad_bo.get(jad_ivVar) : jad_ivVar.jad_an;
    }

    public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        this.jad_bo.putAll((androidx.collection.SimpleArrayMap<? extends com.jd.ad.sdk.jad_ju.jad_iv<?>, ? extends java.lang.Object>) jad_jwVar.jad_bo);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        for (int i = 0; i < this.jad_bo.size(); i++) {
            com.jd.ad.sdk.jad_ju.jad_iv<?> keyAt = this.jad_bo.keyAt(i);
            java.lang.Object valueAt = this.jad_bo.valueAt(i);
            com.jd.ad.sdk.jad_ju.jad_iv.jad_bo<?> jad_boVar = keyAt.jad_bo;
            if (keyAt.jad_dq == null) {
                keyAt.jad_dq = keyAt.jad_cp.getBytes(com.jd.ad.sdk.jad_ju.jad_hu.jad_an);
            }
            jad_boVar.jad_an(keyAt.jad_dq, valueAt, messageDigest);
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Options{values=");
        jad_an.append(this.jad_bo);
        jad_an.append('}');
        return jad_an.toString();
    }
}
