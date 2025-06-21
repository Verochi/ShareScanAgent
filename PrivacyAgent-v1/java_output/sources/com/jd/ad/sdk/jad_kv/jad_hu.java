package com.jd.ad.sdk.jad_kv;

/* loaded from: classes23.dex */
public class jad_hu extends com.jd.ad.sdk.jad_kv.jad_bo<android.content.res.AssetFileDescriptor> {
    public jad_hu(android.content.res.AssetManager assetManager, java.lang.String str) {
        super(assetManager, str);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    @androidx.annotation.NonNull
    public java.lang.Class<android.content.res.AssetFileDescriptor> jad_an() {
        return android.content.res.AssetFileDescriptor.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_bo
    public android.content.res.AssetFileDescriptor jad_an(android.content.res.AssetManager assetManager, java.lang.String str) {
        return assetManager.openFd(str);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_bo
    public void jad_an(android.content.res.AssetFileDescriptor assetFileDescriptor) {
        assetFileDescriptor.close();
    }
}
