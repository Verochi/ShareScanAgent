package com.alimm.tanx.ui.image.glide.load.model.stream;

/* loaded from: classes.dex */
public class StreamUriLoader extends com.alimm.tanx.ui.image.glide.load.model.UriLoader<java.io.InputStream> implements com.alimm.tanx.ui.image.glide.load.model.stream.StreamModelLoader<android.net.Uri> {

    public static class Factory implements com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<android.net.Uri, java.io.InputStream> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream> build(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory genericLoaderFactory) {
            return new com.alimm.tanx.ui.image.glide.load.model.stream.StreamUriLoader(context, genericLoaderFactory.buildModelLoader(com.alimm.tanx.ui.image.glide.load.model.GlideUrl.class, java.io.InputStream.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamUriLoader(android.content.Context context) {
        super(context, com.alimm.tanx.ui.image.glide.Glide.buildStreamModelLoader(com.alimm.tanx.ui.image.glide.load.model.GlideUrl.class, context));
    }

    public StreamUriLoader(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, java.io.InputStream> modelLoader) {
        super(context, modelLoader);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.UriLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> getAssetPathFetcher(android.content.Context context, java.lang.String str) {
        return new com.alimm.tanx.ui.image.glide.load.data.StreamAssetPathFetcher(com.alimm.tanx.core.utils.AssetsUtil.getApplicationAssets(context), str);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.UriLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> getLocalUriFetcher(android.content.Context context, android.net.Uri uri) {
        return new com.alimm.tanx.ui.image.glide.load.data.StreamLocalUriFetcher(context, uri);
    }
}
