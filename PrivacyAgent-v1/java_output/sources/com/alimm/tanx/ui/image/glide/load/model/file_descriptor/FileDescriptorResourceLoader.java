package com.alimm.tanx.ui.image.glide.load.model.file_descriptor;

/* loaded from: classes.dex */
public class FileDescriptorResourceLoader extends com.alimm.tanx.ui.image.glide.load.model.ResourceLoader<android.os.ParcelFileDescriptor> implements com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorModelLoader<java.lang.Integer> {

    public static class Factory implements com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<java.lang.Integer, android.os.ParcelFileDescriptor> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<java.lang.Integer, android.os.ParcelFileDescriptor> build(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory genericLoaderFactory) {
            return new com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorResourceLoader(context, genericLoaderFactory.buildModelLoader(android.net.Uri.class, android.os.ParcelFileDescriptor.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public FileDescriptorResourceLoader(android.content.Context context) {
        this(context, com.alimm.tanx.ui.image.glide.Glide.buildFileDescriptorModelLoader(android.net.Uri.class, context));
    }

    public FileDescriptorResourceLoader(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, android.os.ParcelFileDescriptor> modelLoader) {
        super(context.getResources(), modelLoader);
    }
}
