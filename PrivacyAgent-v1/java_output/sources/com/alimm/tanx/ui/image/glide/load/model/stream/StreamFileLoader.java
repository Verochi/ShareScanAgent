package com.alimm.tanx.ui.image.glide.load.model.stream;

/* loaded from: classes.dex */
public class StreamFileLoader extends com.alimm.tanx.ui.image.glide.load.model.FileLoader<java.io.InputStream> implements com.alimm.tanx.ui.image.glide.load.model.stream.StreamModelLoader<java.io.File> {

    public static class Factory implements com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<java.io.File, java.io.InputStream> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<java.io.File, java.io.InputStream> build(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory genericLoaderFactory) {
            return new com.alimm.tanx.ui.image.glide.load.model.stream.StreamFileLoader((com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream>) genericLoaderFactory.buildModelLoader(android.net.Uri.class, java.io.InputStream.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamFileLoader(android.content.Context context) {
        super(com.alimm.tanx.ui.image.glide.Glide.buildStreamModelLoader(android.net.Uri.class, context));
    }

    public StreamFileLoader(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream> modelLoader) {
        super(modelLoader);
    }
}
