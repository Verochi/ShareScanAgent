package com.jd.ad.sdk.jad_kv;

/* loaded from: classes23.dex */
public class jad_na extends com.jd.ad.sdk.jad_kv.jad_bo<java.io.InputStream> {
    public jad_na(android.content.res.AssetManager assetManager, java.lang.String str) {
        super(assetManager, str);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    @androidx.annotation.NonNull
    public java.lang.Class<java.io.InputStream> jad_an() {
        return java.io.InputStream.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_bo
    public java.io.InputStream jad_an(android.content.res.AssetManager assetManager, java.lang.String str) {
        return assetManager.open(str);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_bo
    public void jad_an(java.io.InputStream inputStream) {
        inputStream.close();
    }
}
