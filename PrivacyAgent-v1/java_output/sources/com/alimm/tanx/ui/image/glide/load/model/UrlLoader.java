package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public class UrlLoader<T> implements com.alimm.tanx.ui.image.glide.load.model.ModelLoader<java.net.URL, T> {
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, T> glideUrlLoader;

    public UrlLoader(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, T> modelLoader) {
        this.glideUrlLoader = modelLoader;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<T> getResourceFetcher(java.net.URL url, int i, int i2) {
        return this.glideUrlLoader.getResourceFetcher(new com.alimm.tanx.ui.image.glide.load.model.GlideUrl(url), i, i2);
    }
}
