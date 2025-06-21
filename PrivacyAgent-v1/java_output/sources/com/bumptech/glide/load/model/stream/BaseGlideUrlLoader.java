package com.bumptech.glide.load.model.stream;

/* loaded from: classes.dex */
public abstract class BaseGlideUrlLoader<Model> implements com.bumptech.glide.load.model.ModelLoader<Model, java.io.InputStream> {
    private final com.bumptech.glide.load.model.ModelLoader<com.bumptech.glide.load.model.GlideUrl, java.io.InputStream> concreteLoader;

    @androidx.annotation.Nullable
    private final com.bumptech.glide.load.model.ModelCache<Model, com.bumptech.glide.load.model.GlideUrl> modelCache;

    public BaseGlideUrlLoader(com.bumptech.glide.load.model.ModelLoader<com.bumptech.glide.load.model.GlideUrl, java.io.InputStream> modelLoader) {
        this(modelLoader, null);
    }

    public BaseGlideUrlLoader(com.bumptech.glide.load.model.ModelLoader<com.bumptech.glide.load.model.GlideUrl, java.io.InputStream> modelLoader, @androidx.annotation.Nullable com.bumptech.glide.load.model.ModelCache<Model, com.bumptech.glide.load.model.GlideUrl> modelCache) {
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache;
    }

    private static java.util.List<com.bumptech.glide.load.Key> getAlternateKeys(java.util.Collection<java.lang.String> collection) {
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        java.util.Iterator<java.lang.String> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.bumptech.glide.load.model.GlideUrl(it.next()));
        }
        return arrayList;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.model.ModelLoader.LoadData<java.io.InputStream> buildLoadData(@androidx.annotation.NonNull Model model, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        com.bumptech.glide.load.model.ModelCache<Model, com.bumptech.glide.load.model.GlideUrl> modelCache = this.modelCache;
        com.bumptech.glide.load.model.GlideUrl glideUrl = modelCache != null ? modelCache.get(model, i, i2) : null;
        if (glideUrl == null) {
            java.lang.String url = getUrl(model, i, i2, options);
            if (android.text.TextUtils.isEmpty(url)) {
                return null;
            }
            com.bumptech.glide.load.model.GlideUrl glideUrl2 = new com.bumptech.glide.load.model.GlideUrl(url, getHeaders(model, i, i2, options));
            com.bumptech.glide.load.model.ModelCache<Model, com.bumptech.glide.load.model.GlideUrl> modelCache2 = this.modelCache;
            if (modelCache2 != null) {
                modelCache2.put(model, i, i2, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        java.util.List<java.lang.String> alternateUrls = getAlternateUrls(model, i, i2, options);
        com.bumptech.glide.load.model.ModelLoader.LoadData<java.io.InputStream> buildLoadData = this.concreteLoader.buildLoadData(glideUrl, i, i2, options);
        return (buildLoadData == null || alternateUrls.isEmpty()) ? buildLoadData : new com.bumptech.glide.load.model.ModelLoader.LoadData<>(buildLoadData.sourceKey, getAlternateKeys(alternateUrls), buildLoadData.fetcher);
    }

    public java.util.List<java.lang.String> getAlternateUrls(Model model, int i, int i2, com.bumptech.glide.load.Options options) {
        return java.util.Collections.emptyList();
    }

    @androidx.annotation.Nullable
    public com.bumptech.glide.load.model.Headers getHeaders(Model model, int i, int i2, com.bumptech.glide.load.Options options) {
        return com.bumptech.glide.load.model.Headers.DEFAULT;
    }

    public abstract java.lang.String getUrl(Model model, int i, int i2, com.bumptech.glide.load.Options options);
}
