package com.jd.ad.sdk.jad_kv;

/* loaded from: classes23.dex */
public final class jad_an extends com.jd.ad.sdk.jad_kv.jad_ly<android.content.res.AssetFileDescriptor> {
    public jad_an(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    @androidx.annotation.NonNull
    public java.lang.Class<android.content.res.AssetFileDescriptor> jad_an() {
        return android.content.res.AssetFileDescriptor.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_ly
    public android.content.res.AssetFileDescriptor jad_an(android.net.Uri uri, android.content.ContentResolver contentResolver) {
        android.content.res.AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor;
        }
        throw new java.io.FileNotFoundException("FileDescriptor is null for: " + uri);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_ly
    public void jad_an(android.content.res.AssetFileDescriptor assetFileDescriptor) {
        assetFileDescriptor.close();
    }
}
