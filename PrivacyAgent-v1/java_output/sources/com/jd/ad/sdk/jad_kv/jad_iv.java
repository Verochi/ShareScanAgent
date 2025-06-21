package com.jd.ad.sdk.jad_kv;

/* loaded from: classes23.dex */
public class jad_iv extends com.jd.ad.sdk.jad_kv.jad_ly<android.os.ParcelFileDescriptor> {
    public jad_iv(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    @androidx.annotation.NonNull
    public java.lang.Class<android.os.ParcelFileDescriptor> jad_an() {
        return android.os.ParcelFileDescriptor.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_ly
    public android.os.ParcelFileDescriptor jad_an(android.net.Uri uri, android.content.ContentResolver contentResolver) {
        android.content.res.AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor.getParcelFileDescriptor();
        }
        throw new java.io.FileNotFoundException("FileDescriptor is null for: " + uri);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_ly
    public void jad_an(android.os.ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }
}
