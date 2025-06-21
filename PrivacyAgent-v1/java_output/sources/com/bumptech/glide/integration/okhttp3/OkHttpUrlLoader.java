package com.bumptech.glide.integration.okhttp3;

/* loaded from: classes.dex */
public class OkHttpUrlLoader implements com.bumptech.glide.load.model.ModelLoader<com.bumptech.glide.load.model.GlideUrl, java.io.InputStream> {
    private final okhttp3.Call.Factory client;

    public static class Factory implements com.bumptech.glide.load.model.ModelLoaderFactory<com.bumptech.glide.load.model.GlideUrl, java.io.InputStream> {
        private static volatile okhttp3.Call.Factory internalClient;
        private final okhttp3.Call.Factory client;

        public Factory() {
            this(getInternalClient());
        }

        public Factory(@androidx.annotation.NonNull okhttp3.Call.Factory factory) {
            this.client = factory;
        }

        private static okhttp3.Call.Factory getInternalClient() {
            if (internalClient == null) {
                synchronized (com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader.Factory.class) {
                    if (internalClient == null) {
                        internalClient = new okhttp3.OkHttpClient();
                    }
                }
            }
            return internalClient;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<com.bumptech.glide.load.model.GlideUrl, java.io.InputStream> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader(this.client);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public OkHttpUrlLoader(@androidx.annotation.NonNull okhttp3.Call.Factory factory) {
        this.client = factory;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<java.io.InputStream> buildLoadData(@androidx.annotation.NonNull com.bumptech.glide.load.model.GlideUrl glideUrl, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(glideUrl, new com.bumptech.glide.integration.okhttp3.OkHttpStreamFetcher(this.client, glideUrl));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull com.bumptech.glide.load.model.GlideUrl glideUrl) {
        return true;
    }
}
