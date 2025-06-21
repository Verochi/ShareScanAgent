package com.alimm.tanx.ui.image.glide.load.model.stream;

/* loaded from: classes.dex */
public class StreamUrlLoader extends com.alimm.tanx.ui.image.glide.load.model.UrlLoader<java.io.InputStream> {

    public static class Factory implements com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<java.net.URL, java.io.InputStream> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<java.net.URL, java.io.InputStream> build(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory genericLoaderFactory) {
            return new com.alimm.tanx.ui.image.glide.load.model.stream.StreamUrlLoader(genericLoaderFactory.buildModelLoader(com.alimm.tanx.ui.image.glide.load.model.GlideUrl.class, java.io.InputStream.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamUrlLoader(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, java.io.InputStream> modelLoader) {
        super(modelLoader);
    }
}
