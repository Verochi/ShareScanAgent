package com.jd.ad.sdk.jad_rc;

/* loaded from: classes23.dex */
public class jad_er implements com.jd.ad.sdk.jad_qb.jad_na<java.net.URL, java.io.InputStream> {
    public final com.jd.ad.sdk.jad_qb.jad_na<com.jd.ad.sdk.jad_qb.jad_jt, java.io.InputStream> jad_an;

    public static class jad_an implements com.jd.ad.sdk.jad_qb.jad_ob<java.net.URL, java.io.InputStream> {
        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<java.net.URL, java.io.InputStream> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_rc.jad_er(jad_reVar.jad_an(com.jd.ad.sdk.jad_qb.jad_jt.class, java.io.InputStream.class));
        }
    }

    public jad_er(com.jd.ad.sdk.jad_qb.jad_na<com.jd.ad.sdk.jad_qb.jad_jt, java.io.InputStream> jad_naVar) {
        this.jad_an = jad_naVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an<java.io.InputStream> jad_an(@androidx.annotation.NonNull java.net.URL url, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return this.jad_an.jad_an(new com.jd.ad.sdk.jad_qb.jad_jt(url, com.jd.ad.sdk.jad_qb.jad_hu.jad_an), i, i2, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@androidx.annotation.NonNull java.net.URL url) {
        return true;
    }
}
