package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_wj<Data> implements com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, Data> {
    public static final java.util.Set<java.lang.String> jad_bo = java.util.Collections.unmodifiableSet(new java.util.HashSet(java.util.Arrays.asList("file", "android.resource", "content")));
    public final com.jd.ad.sdk.jad_qb.jad_wj.jad_cp<Data> jad_an;

    public static final class jad_an implements com.jd.ad.sdk.jad_qb.jad_ob<android.net.Uri, android.content.res.AssetFileDescriptor>, com.jd.ad.sdk.jad_qb.jad_wj.jad_cp<android.content.res.AssetFileDescriptor> {
        public final android.content.ContentResolver jad_an;

        public jad_an(android.content.ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_wj.jad_cp
        public com.jd.ad.sdk.jad_kv.jad_dq<android.content.res.AssetFileDescriptor> jad_an(android.net.Uri uri) {
            return new com.jd.ad.sdk.jad_kv.jad_an(this.jad_an, uri);
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, android.content.res.AssetFileDescriptor> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_wj(this);
        }
    }

    public static class jad_bo implements com.jd.ad.sdk.jad_qb.jad_ob<android.net.Uri, android.os.ParcelFileDescriptor>, com.jd.ad.sdk.jad_qb.jad_wj.jad_cp<android.os.ParcelFileDescriptor> {
        public final android.content.ContentResolver jad_an;

        public jad_bo(android.content.ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_wj.jad_cp
        public com.jd.ad.sdk.jad_kv.jad_dq<android.os.ParcelFileDescriptor> jad_an(android.net.Uri uri) {
            return new com.jd.ad.sdk.jad_kv.jad_iv(this.jad_an, uri);
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, android.os.ParcelFileDescriptor> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_wj(this);
        }
    }

    public interface jad_cp<Data> {
        com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_an(android.net.Uri uri);
    }

    public static class jad_dq implements com.jd.ad.sdk.jad_qb.jad_ob<android.net.Uri, java.io.InputStream>, com.jd.ad.sdk.jad_qb.jad_wj.jad_cp<java.io.InputStream> {
        public final android.content.ContentResolver jad_an;

        public jad_dq(android.content.ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_wj.jad_cp
        public com.jd.ad.sdk.jad_kv.jad_dq<java.io.InputStream> jad_an(android.net.Uri uri) {
            return new com.jd.ad.sdk.jad_kv.jad_ob(this.jad_an, uri);
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, java.io.InputStream> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_wj(this);
        }
    }

    public jad_wj(com.jd.ad.sdk.jad_qb.jad_wj.jad_cp<Data> jad_cpVar) {
        this.jad_an = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_an(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        android.net.Uri uri2 = uri;
        return new com.jd.ad.sdk.jad_qb.jad_na.jad_an(new com.jd.ad.sdk.jad_hq.jad_bo(uri2), java.util.Collections.emptyList(), this.jad_an.jad_an(uri2));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(@androidx.annotation.NonNull android.net.Uri uri) {
        return jad_bo.contains(uri.getScheme());
    }
}
