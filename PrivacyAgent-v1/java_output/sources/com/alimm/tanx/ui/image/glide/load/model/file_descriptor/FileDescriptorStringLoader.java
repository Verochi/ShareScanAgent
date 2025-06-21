package com.alimm.tanx.ui.image.glide.load.model.file_descriptor;

/* loaded from: classes.dex */
public class FileDescriptorStringLoader extends com.alimm.tanx.ui.image.glide.load.model.StringLoader<android.os.ParcelFileDescriptor> implements com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorModelLoader<java.lang.String> {

    public static class Factory implements com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<java.lang.String, android.os.ParcelFileDescriptor> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<java.lang.String, android.os.ParcelFileDescriptor> build(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory genericLoaderFactory) {
            return new com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorStringLoader((com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, android.os.ParcelFileDescriptor>) genericLoaderFactory.buildModelLoader(android.net.Uri.class, android.os.ParcelFileDescriptor.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public FileDescriptorStringLoader(android.content.Context context) {
        super(com.alimm.tanx.ui.image.glide.Glide.buildFileDescriptorModelLoader(android.net.Uri.class, context));
    }

    public FileDescriptorStringLoader(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, android.os.ParcelFileDescriptor> modelLoader) {
        super(modelLoader);
    }
}
