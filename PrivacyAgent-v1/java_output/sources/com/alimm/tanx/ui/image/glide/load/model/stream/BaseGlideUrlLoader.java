package com.alimm.tanx.ui.image.glide.load.model.stream;

/* loaded from: classes.dex */
public abstract class BaseGlideUrlLoader<T> implements com.alimm.tanx.ui.image.glide.load.model.stream.StreamModelLoader<T> {
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, java.io.InputStream> concreteLoader;
    private final com.alimm.tanx.ui.image.glide.load.model.ModelCache<T, com.alimm.tanx.ui.image.glide.load.model.GlideUrl> modelCache;

    public BaseGlideUrlLoader(android.content.Context context) {
        this(context, (com.alimm.tanx.ui.image.glide.load.model.ModelCache) null);
    }

    public BaseGlideUrlLoader(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.ModelCache<T, com.alimm.tanx.ui.image.glide.load.model.GlideUrl> modelCache) {
        this((com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, java.io.InputStream>) com.alimm.tanx.ui.image.glide.Glide.buildModelLoader(com.alimm.tanx.ui.image.glide.load.model.GlideUrl.class, java.io.InputStream.class, context), modelCache);
    }

    public BaseGlideUrlLoader(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, java.io.InputStream> modelLoader) {
        this.concreteLoader = modelLoader;
        this.modelCache = null;
    }

    public BaseGlideUrlLoader(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, java.io.InputStream> modelLoader, com.alimm.tanx.ui.image.glide.load.model.ModelCache<T, com.alimm.tanx.ui.image.glide.load.model.GlideUrl> modelCache) {
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache;
    }

    public com.alimm.tanx.ui.image.glide.load.model.Headers getHeaders(T t, int i, int i2) {
        return com.alimm.tanx.ui.image.glide.load.model.Headers.DEFAULT;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> getResourceFetcher(T t, int i, int i2) {
        com.alimm.tanx.ui.image.glide.load.model.ModelCache<T, com.alimm.tanx.ui.image.glide.load.model.GlideUrl> modelCache = this.modelCache;
        com.alimm.tanx.ui.image.glide.load.model.GlideUrl glideUrl = modelCache != null ? modelCache.get(t, i, i2) : null;
        if (glideUrl == null) {
            java.lang.String url = getUrl(t, i, i2);
            if (android.text.TextUtils.isEmpty(url)) {
                return null;
            }
            com.alimm.tanx.ui.image.glide.load.model.GlideUrl glideUrl2 = new com.alimm.tanx.ui.image.glide.load.model.GlideUrl(url, getHeaders(t, i, i2));
            com.alimm.tanx.ui.image.glide.load.model.ModelCache<T, com.alimm.tanx.ui.image.glide.load.model.GlideUrl> modelCache2 = this.modelCache;
            if (modelCache2 != null) {
                modelCache2.put(t, i, i2, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        return this.concreteLoader.getResourceFetcher(glideUrl, i, i2);
    }

    public abstract java.lang.String getUrl(T t, int i, int i2);
}
