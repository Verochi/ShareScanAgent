package com.alimm.tanx.ui.image.glide.load.model.stream;

/* loaded from: classes.dex */
public class StreamResourceLoader extends com.alimm.tanx.ui.image.glide.load.model.ResourceLoader<java.io.InputStream> implements com.alimm.tanx.ui.image.glide.load.model.stream.StreamModelLoader<java.lang.Integer> {

    public static class Factory implements com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<java.lang.Integer, java.io.InputStream> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<java.lang.Integer, java.io.InputStream> build(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory genericLoaderFactory) {
            return new com.alimm.tanx.ui.image.glide.load.model.stream.StreamResourceLoader(context, genericLoaderFactory.buildModelLoader(android.net.Uri.class, java.io.InputStream.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamResourceLoader(android.content.Context context) {
        this(context, com.alimm.tanx.ui.image.glide.Glide.buildStreamModelLoader(android.net.Uri.class, context));
    }

    public StreamResourceLoader(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream> modelLoader) {
        super(context.getResources(), modelLoader);
    }
}
