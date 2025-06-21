package com.alimm.tanx.ui.image.glide.load.model.stream;

/* loaded from: classes.dex */
public class MediaStoreStreamLoader implements com.alimm.tanx.ui.image.glide.load.model.stream.StreamModelLoader<android.net.Uri> {
    private final android.content.Context context;
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream> uriLoader;

    public MediaStoreStreamLoader(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream> modelLoader) {
        this.context = context;
        this.uriLoader = modelLoader;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> getResourceFetcher(android.net.Uri uri, int i, int i2) {
        return new com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher(this.context, uri, this.uriLoader.getResourceFetcher(uri, i, i2), i, i2);
    }
}
