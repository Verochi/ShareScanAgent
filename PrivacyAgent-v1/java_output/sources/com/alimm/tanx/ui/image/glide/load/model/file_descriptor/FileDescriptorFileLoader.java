package com.alimm.tanx.ui.image.glide.load.model.file_descriptor;

/* loaded from: classes.dex */
public class FileDescriptorFileLoader extends com.alimm.tanx.ui.image.glide.load.model.FileLoader<android.os.ParcelFileDescriptor> implements com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorModelLoader<java.io.File> {

    public static class Factory implements com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<java.io.File, android.os.ParcelFileDescriptor> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<java.io.File, android.os.ParcelFileDescriptor> build(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory genericLoaderFactory) {
            return new com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorFileLoader((com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, android.os.ParcelFileDescriptor>) genericLoaderFactory.buildModelLoader(android.net.Uri.class, android.os.ParcelFileDescriptor.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public FileDescriptorFileLoader(android.content.Context context) {
        super(com.alimm.tanx.ui.image.glide.Glide.buildFileDescriptorModelLoader(android.net.Uri.class, context));
    }

    public FileDescriptorFileLoader(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, android.os.ParcelFileDescriptor> modelLoader) {
        super(modelLoader);
    }
}
