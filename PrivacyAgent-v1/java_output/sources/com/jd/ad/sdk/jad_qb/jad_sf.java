package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_sf<Data> implements com.jd.ad.sdk.jad_qb.jad_na<java.lang.Integer, Data> {
    public final com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, Data> jad_an;
    public final android.content.res.Resources jad_bo;

    public static final class jad_an implements com.jd.ad.sdk.jad_qb.jad_ob<java.lang.Integer, android.content.res.AssetFileDescriptor> {
        public final android.content.res.Resources jad_an;

        public jad_an(android.content.res.Resources resources) {
            this.jad_an = resources;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public com.jd.ad.sdk.jad_qb.jad_na<java.lang.Integer, android.content.res.AssetFileDescriptor> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_sf(this.jad_an, jad_reVar.jad_an(android.net.Uri.class, android.content.res.AssetFileDescriptor.class));
        }
    }

    public static class jad_bo implements com.jd.ad.sdk.jad_qb.jad_ob<java.lang.Integer, android.os.ParcelFileDescriptor> {
        public final android.content.res.Resources jad_an;

        public jad_bo(android.content.res.Resources resources) {
            this.jad_an = resources;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<java.lang.Integer, android.os.ParcelFileDescriptor> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_sf(this.jad_an, jad_reVar.jad_an(android.net.Uri.class, android.os.ParcelFileDescriptor.class));
        }
    }

    public static class jad_cp implements com.jd.ad.sdk.jad_qb.jad_ob<java.lang.Integer, java.io.InputStream> {
        public final android.content.res.Resources jad_an;

        public jad_cp(android.content.res.Resources resources) {
            this.jad_an = resources;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<java.lang.Integer, java.io.InputStream> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_sf(this.jad_an, jad_reVar.jad_an(android.net.Uri.class, java.io.InputStream.class));
        }
    }

    public static class jad_dq implements com.jd.ad.sdk.jad_qb.jad_ob<java.lang.Integer, android.net.Uri> {
        public final android.content.res.Resources jad_an;

        public jad_dq(android.content.res.Resources resources) {
            this.jad_an = resources;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<java.lang.Integer, android.net.Uri> jad_an(com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_sf(this.jad_an, com.jd.ad.sdk.jad_qb.jad_vi.jad_an);
        }
    }

    public jad_sf(android.content.res.Resources resources, com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, Data> jad_naVar) {
        this.jad_bo = resources;
        this.jad_an = jad_naVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_an(@androidx.annotation.NonNull java.lang.Integer num, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        android.net.Uri uri;
        java.lang.Integer num2 = num;
        try {
            uri = android.net.Uri.parse("android.resource://" + this.jad_bo.getResourcePackageName(num2.intValue()) + '/' + this.jad_bo.getResourceTypeName(num2.intValue()) + '/' + this.jad_bo.getResourceEntryName(num2.intValue()));
        } catch (android.content.res.Resources.NotFoundException e) {
            if (android.util.Log.isLoggable("ResourceLoader", 5)) {
                com.jd.ad.sdk.logger.Logger.w("ResourceLoader", "Received invalid resource id: " + num2, e);
            }
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        return this.jad_an.jad_an(uri, i, i2, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@androidx.annotation.NonNull java.lang.Integer num) {
        return true;
    }
}
