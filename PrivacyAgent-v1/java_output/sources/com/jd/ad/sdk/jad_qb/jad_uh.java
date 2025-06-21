package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_uh<Data> implements com.jd.ad.sdk.jad_qb.jad_na<java.lang.String, Data> {
    public final com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, Data> jad_an;

    public static final class jad_an implements com.jd.ad.sdk.jad_qb.jad_ob<java.lang.String, android.content.res.AssetFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public com.jd.ad.sdk.jad_qb.jad_na<java.lang.String, android.content.res.AssetFileDescriptor> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_uh(jad_reVar.jad_an(android.net.Uri.class, android.content.res.AssetFileDescriptor.class));
        }
    }

    public static class jad_bo implements com.jd.ad.sdk.jad_qb.jad_ob<java.lang.String, android.os.ParcelFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<java.lang.String, android.os.ParcelFileDescriptor> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_uh(jad_reVar.jad_an(android.net.Uri.class, android.os.ParcelFileDescriptor.class));
        }
    }

    public static class jad_cp implements com.jd.ad.sdk.jad_qb.jad_ob<java.lang.String, java.io.InputStream> {
        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_qb.jad_na<java.lang.String, java.io.InputStream> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_uh(jad_reVar.jad_an(android.net.Uri.class, java.io.InputStream.class));
        }
    }

    public jad_uh(com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, Data> jad_naVar) {
        this.jad_an = jad_naVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
    
        if (r0.getScheme() == null) goto L10;
     */
    @Override // com.jd.ad.sdk.jad_qb.jad_na
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_an(@androidx.annotation.NonNull java.lang.String str, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        android.net.Uri fromFile;
        java.lang.String str2 = str;
        if (android.text.TextUtils.isEmpty(str2)) {
            fromFile = null;
        } else {
            if (str2.charAt(0) != '/') {
                fromFile = android.net.Uri.parse(str2);
            }
            fromFile = android.net.Uri.fromFile(new java.io.File(str2));
        }
        if (fromFile == null || !this.jad_an.jad_an(fromFile)) {
            return null;
        }
        return this.jad_an.jad_an(fromFile, i, i2, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@androidx.annotation.NonNull java.lang.String str) {
        return true;
    }
}
