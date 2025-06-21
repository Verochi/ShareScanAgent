package com.alimm.tanx.ui.image.glide.load.model.stream;

/* loaded from: classes.dex */
public class HttpUrlGlideUrlLoader implements com.alimm.tanx.ui.image.glide.load.model.stream.StreamModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl> {
    private final com.alimm.tanx.ui.image.glide.load.model.ModelCache<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, com.alimm.tanx.ui.image.glide.load.model.GlideUrl> modelCache;

    public static class Factory implements com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, java.io.InputStream> {
        private final com.alimm.tanx.ui.image.glide.load.model.ModelCache<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, com.alimm.tanx.ui.image.glide.load.model.GlideUrl> modelCache = new com.alimm.tanx.ui.image.glide.load.model.ModelCache<>(500);

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, java.io.InputStream> build(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory genericLoaderFactory) {
            return new com.alimm.tanx.ui.image.glide.load.model.stream.HttpUrlGlideUrlLoader(this.modelCache);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public HttpUrlGlideUrlLoader() {
        this(null);
    }

    public HttpUrlGlideUrlLoader(com.alimm.tanx.ui.image.glide.load.model.ModelCache<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, com.alimm.tanx.ui.image.glide.load.model.GlideUrl> modelCache) {
        this.modelCache = modelCache;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> getResourceFetcher(com.alimm.tanx.ui.image.glide.load.model.GlideUrl glideUrl, int i, int i2) {
        com.alimm.tanx.ui.image.glide.load.model.ModelCache<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, com.alimm.tanx.ui.image.glide.load.model.GlideUrl> modelCache = this.modelCache;
        if (modelCache != null) {
            com.alimm.tanx.ui.image.glide.load.model.GlideUrl glideUrl2 = modelCache.get(glideUrl, 0, 0);
            if (glideUrl2 == null) {
                this.modelCache.put(glideUrl, 0, 0, glideUrl);
            } else {
                glideUrl = glideUrl2;
            }
        }
        return new com.alimm.tanx.ui.image.glide.load.data.HttpUrlFetcher(glideUrl);
    }
}
