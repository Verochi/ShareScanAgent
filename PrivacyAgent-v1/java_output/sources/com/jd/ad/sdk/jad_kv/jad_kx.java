package com.jd.ad.sdk.jad_kv;

/* loaded from: classes23.dex */
public final class jad_kx implements com.jd.ad.sdk.jad_kv.jad_er<java.io.InputStream> {
    public final com.jd.ad.sdk.jad_te.jad_sf jad_an;

    public static final class jad_an implements com.jd.ad.sdk.jad_kv.jad_er.jad_an<java.io.InputStream> {
        public final com.jd.ad.sdk.jad_ny.jad_bo jad_an;

        public jad_an(com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
            this.jad_an = jad_boVar;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_kv.jad_er<java.io.InputStream> jad_an(java.io.InputStream inputStream) {
            return new com.jd.ad.sdk.jad_kv.jad_kx(inputStream, this.jad_an);
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        @androidx.annotation.NonNull
        public java.lang.Class<java.io.InputStream> jad_an() {
            return java.io.InputStream.class;
        }
    }

    public jad_kx(java.io.InputStream inputStream, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        com.jd.ad.sdk.jad_te.jad_sf jad_sfVar = new com.jd.ad.sdk.jad_te.jad_sf(inputStream, jad_boVar);
        this.jad_an = jad_sfVar;
        jad_sfVar.mark(5242880);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    public void jad_bo() {
        this.jad_an.jad_bo();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    @androidx.annotation.NonNull
    /* renamed from: jad_cp, reason: merged with bridge method [inline-methods] */
    public java.io.InputStream jad_an() {
        this.jad_an.reset();
        return this.jad_an;
    }
}
