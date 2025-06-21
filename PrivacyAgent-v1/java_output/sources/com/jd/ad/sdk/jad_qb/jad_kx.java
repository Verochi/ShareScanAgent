package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public final class jad_kx implements com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, java.io.File> {
    public final android.content.Context jad_an;

    public static final class jad_an implements com.jd.ad.sdk.jad_qb.jad_ob<android.net.Uri, java.io.File> {
        public final android.content.Context jad_an;

        public jad_an(android.content.Context context) {
            this.jad_an = context;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, java.io.File> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_kx(this.jad_an);
        }
    }

    public static class jad_bo implements com.jd.ad.sdk.jad_kv.jad_dq<java.io.File> {
        public static final java.lang.String[] jad_cp = {"_data"};
        public final android.content.Context jad_an;
        public final android.net.Uri jad_bo;

        public jad_bo(android.content.Context context, android.net.Uri uri) {
            this.jad_an = context;
            this.jad_bo = uri;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public java.lang.Class<java.io.File> jad_an() {
            return java.io.File.class;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super java.io.File> jad_anVar) {
            android.database.Cursor query = this.jad_an.getContentResolver().query(this.jad_bo, jad_cp, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (!android.text.TextUtils.isEmpty(r0)) {
                jad_anVar.jad_an((com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super java.io.File>) new java.io.File(r0));
                return;
            }
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Failed to find file path for: ");
            jad_an.append(this.jad_bo);
            jad_anVar.jad_an((java.lang.Exception) new java.io.FileNotFoundException(jad_an.toString()));
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
        }
    }

    public jad_kx(android.content.Context context) {
        this.jad_an = context;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an<java.io.File> jad_an(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        android.net.Uri uri2 = uri;
        return new com.jd.ad.sdk.jad_qb.jad_na.jad_an<>(new com.jd.ad.sdk.jad_hq.jad_bo(uri2), java.util.Collections.emptyList(), new com.jd.ad.sdk.jad_qb.jad_kx.jad_bo(this.jad_an, uri2));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(@androidx.annotation.NonNull android.net.Uri uri) {
        return com.jd.ad.sdk.jad_lw.jad_bo.jad_an(uri);
    }
}
