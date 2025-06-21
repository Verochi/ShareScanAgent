package com.jd.ad.sdk.jad_rc;

/* loaded from: classes23.dex */
public class jad_cp implements com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, java.io.InputStream> {
    public final android.content.Context jad_an;

    public static class jad_an implements com.jd.ad.sdk.jad_qb.jad_ob<android.net.Uri, java.io.InputStream> {
        public final android.content.Context jad_an;

        public jad_an(android.content.Context context) {
            this.jad_an = context;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, java.io.InputStream> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_rc.jad_cp(this.jad_an);
        }
    }

    public jad_cp(android.content.Context context) {
        this.jad_an = context.getApplicationContext();
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an<java.io.InputStream> jad_an(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        android.net.Uri uri2 = uri;
        if (com.jd.ad.sdk.jad_lw.jad_bo.jad_an(i, i2)) {
            java.lang.Long l = (java.lang.Long) jad_jwVar.jad_an(com.jd.ad.sdk.jad_te.jad_xk.jad_dq);
            if (l != null && l.longValue() == -1) {
                com.jd.ad.sdk.jad_hq.jad_bo jad_boVar = new com.jd.ad.sdk.jad_hq.jad_bo(uri2);
                android.content.Context context = this.jad_an;
                return new com.jd.ad.sdk.jad_qb.jad_na.jad_an<>(jad_boVar, java.util.Collections.emptyList(), com.jd.ad.sdk.jad_lw.jad_cp.jad_an(context, uri2, new com.jd.ad.sdk.jad_lw.jad_cp.jad_bo(context.getContentResolver())));
            }
        }
        return null;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(@androidx.annotation.NonNull android.net.Uri uri) {
        return com.jd.ad.sdk.jad_lw.jad_bo.jad_an(uri) && uri.getPathSegments().contains("video");
    }
}
