package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_an<Data> implements com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, Data> {
    public final android.content.res.AssetManager jad_an;
    public final com.jd.ad.sdk.jad_qb.jad_an.InterfaceC0403jad_an<Data> jad_bo;

    /* renamed from: com.jd.ad.sdk.jad_qb.jad_an$jad_an, reason: collision with other inner class name */
    public interface InterfaceC0403jad_an<Data> {
        com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_an(android.content.res.AssetManager assetManager, java.lang.String str);
    }

    public static class jad_bo implements com.jd.ad.sdk.jad_qb.jad_ob<android.net.Uri, android.content.res.AssetFileDescriptor>, com.jd.ad.sdk.jad_qb.jad_an.InterfaceC0403jad_an<android.content.res.AssetFileDescriptor> {
        public final android.content.res.AssetManager jad_an;

        public jad_bo(android.content.res.AssetManager assetManager) {
            this.jad_an = assetManager;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_an.InterfaceC0403jad_an
        public com.jd.ad.sdk.jad_kv.jad_dq<android.content.res.AssetFileDescriptor> jad_an(android.content.res.AssetManager assetManager, java.lang.String str) {
            return new com.jd.ad.sdk.jad_kv.jad_hu(assetManager, str);
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, android.content.res.AssetFileDescriptor> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_an(this.jad_an, this);
        }
    }

    public static class jad_cp implements com.jd.ad.sdk.jad_qb.jad_ob<android.net.Uri, java.io.InputStream>, com.jd.ad.sdk.jad_qb.jad_an.InterfaceC0403jad_an<java.io.InputStream> {
        public final android.content.res.AssetManager jad_an;

        public jad_cp(android.content.res.AssetManager assetManager) {
            this.jad_an = assetManager;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_an.InterfaceC0403jad_an
        public com.jd.ad.sdk.jad_kv.jad_dq<java.io.InputStream> jad_an(android.content.res.AssetManager assetManager, java.lang.String str) {
            return new com.jd.ad.sdk.jad_kv.jad_na(assetManager, str);
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, java.io.InputStream> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_an(this.jad_an, this);
        }
    }

    public jad_an(android.content.res.AssetManager assetManager, com.jd.ad.sdk.jad_qb.jad_an.InterfaceC0403jad_an<Data> interfaceC0403jad_an) {
        this.jad_an = assetManager;
        this.jad_bo = interfaceC0403jad_an;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_an(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        android.net.Uri uri2 = uri;
        java.lang.String substring = uri2.toString().substring(22);
        return new com.jd.ad.sdk.jad_qb.jad_na.jad_an(new com.jd.ad.sdk.jad_hq.jad_bo(uri2), java.util.Collections.emptyList(), this.jad_bo.jad_an(this.jad_an, substring));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(@androidx.annotation.NonNull android.net.Uri uri) {
        android.net.Uri uri2 = uri;
        return "file".equals(uri2.getScheme()) && !uri2.getPathSegments().isEmpty() && "android_asset".equals(uri2.getPathSegments().get(0));
    }
}
