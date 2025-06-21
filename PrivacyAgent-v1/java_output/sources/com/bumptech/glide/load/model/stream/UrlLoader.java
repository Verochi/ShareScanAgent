package com.bumptech.glide.load.model.stream;

/* loaded from: classes.dex */
public class UrlLoader implements com.bumptech.glide.load.model.ModelLoader<java.net.URL, java.io.InputStream> {
    private final com.bumptech.glide.load.model.ModelLoader<com.bumptech.glide.load.model.GlideUrl, java.io.InputStream> glideUrlLoader;

    public static class StreamFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.net.URL, java.io.InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<java.net.URL, java.io.InputStream> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.stream.UrlLoader(multiModelLoaderFactory.build(com.bumptech.glide.load.model.GlideUrl.class, java.io.InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public UrlLoader(com.bumptech.glide.load.model.ModelLoader<com.bumptech.glide.load.model.GlideUrl, java.io.InputStream> modelLoader) {
        this.glideUrlLoader = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<java.io.InputStream> buildLoadData(@androidx.annotation.NonNull java.net.URL url, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return this.glideUrlLoader.buildLoadData(new com.bumptech.glide.load.model.GlideUrl(url), i, i2, options);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull java.net.URL url) {
        return true;
    }
}
