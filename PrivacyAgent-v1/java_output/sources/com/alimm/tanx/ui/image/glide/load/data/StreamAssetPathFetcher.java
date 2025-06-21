package com.alimm.tanx.ui.image.glide.load.data;

/* loaded from: classes.dex */
public class StreamAssetPathFetcher extends com.alimm.tanx.ui.image.glide.load.data.AssetPathFetcher<java.io.InputStream> {
    public StreamAssetPathFetcher(android.content.res.AssetManager assetManager, java.lang.String str) {
        super(assetManager, str);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.AssetPathFetcher
    public void close(java.io.InputStream inputStream) throws java.io.IOException {
        inputStream.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.data.AssetPathFetcher
    public java.io.InputStream loadResource(android.content.res.AssetManager assetManager, java.lang.String str) throws java.io.IOException {
        return assetManager.open(str);
    }
}
