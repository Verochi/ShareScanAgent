package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_xk<Data> implements com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, Data> {
    public static final java.util.Set<java.lang.String> jad_bo = java.util.Collections.unmodifiableSet(new java.util.HashSet(java.util.Arrays.asList(com.alipay.sdk.m.l.a.q, "https")));
    public final com.jd.ad.sdk.jad_qb.jad_na<com.jd.ad.sdk.jad_qb.jad_jt, Data> jad_an;

    public static class jad_an implements com.jd.ad.sdk.jad_qb.jad_ob<android.net.Uri, java.io.InputStream> {
        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, java.io.InputStream> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_xk(jad_reVar.jad_an(com.jd.ad.sdk.jad_qb.jad_jt.class, java.io.InputStream.class));
        }
    }

    public jad_xk(com.jd.ad.sdk.jad_qb.jad_na<com.jd.ad.sdk.jad_qb.jad_jt, Data> jad_naVar) {
        this.jad_an = jad_naVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_an(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return this.jad_an.jad_an(new com.jd.ad.sdk.jad_qb.jad_jt(uri.toString(), com.jd.ad.sdk.jad_qb.jad_hu.jad_an), i, i2, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(@androidx.annotation.NonNull android.net.Uri uri) {
        return jad_bo.contains(uri.getScheme());
    }
}
