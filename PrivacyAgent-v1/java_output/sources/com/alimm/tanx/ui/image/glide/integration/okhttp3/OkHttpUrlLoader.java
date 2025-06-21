package com.alimm.tanx.ui.image.glide.integration.okhttp3;

/* loaded from: classes.dex */
public class OkHttpUrlLoader implements com.alimm.tanx.ui.image.glide.load.model.stream.StreamModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl> {
    private final okhttp3.Call.Factory client;

    public static class Factory implements com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, java.io.InputStream> {
        private static volatile okhttp3.Call.Factory internalClient;
        private okhttp3.Call.Factory client;

        public Factory() {
            this(getInternalClient());
        }

        public Factory(okhttp3.Call.Factory factory) {
            this.client = factory;
        }

        private static okhttp3.Call.Factory getInternalClient() {
            if (internalClient == null) {
                synchronized (com.alimm.tanx.ui.image.glide.integration.okhttp3.OkHttpUrlLoader.Factory.class) {
                    if (internalClient == null) {
                        internalClient = new okhttp3.OkHttpClient();
                    }
                }
            }
            return internalClient;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, java.io.InputStream> build(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory genericLoaderFactory) {
            return new com.alimm.tanx.ui.image.glide.integration.okhttp3.OkHttpUrlLoader(this.client);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public OkHttpUrlLoader(okhttp3.Call.Factory factory) {
        this.client = factory;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> getResourceFetcher(com.alimm.tanx.ui.image.glide.load.model.GlideUrl glideUrl, int i, int i2) {
        return new com.alimm.tanx.ui.image.glide.integration.okhttp3.OkHttpStreamFetcher(this.client, glideUrl);
    }
}
