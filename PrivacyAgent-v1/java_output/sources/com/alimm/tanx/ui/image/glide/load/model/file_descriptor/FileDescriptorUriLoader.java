package com.alimm.tanx.ui.image.glide.load.model.file_descriptor;

/* loaded from: classes.dex */
public class FileDescriptorUriLoader extends com.alimm.tanx.ui.image.glide.load.model.UriLoader<android.os.ParcelFileDescriptor> implements com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorModelLoader<android.net.Uri> {

    public static class Factory implements com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<android.net.Uri, android.os.ParcelFileDescriptor> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, android.os.ParcelFileDescriptor> build(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory genericLoaderFactory) {
            return new com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorUriLoader(context, genericLoaderFactory.buildModelLoader(com.alimm.tanx.ui.image.glide.load.model.GlideUrl.class, android.os.ParcelFileDescriptor.class));
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public FileDescriptorUriLoader(android.content.Context context) {
        super(context, com.alimm.tanx.ui.image.glide.Glide.buildFileDescriptorModelLoader(com.alimm.tanx.ui.image.glide.load.model.GlideUrl.class, context));
    }

    public FileDescriptorUriLoader(android.content.Context context, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<com.alimm.tanx.ui.image.glide.load.model.GlideUrl, android.os.ParcelFileDescriptor> modelLoader) {
        super(context, modelLoader);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.UriLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> getAssetPathFetcher(android.content.Context context, java.lang.String str) {
        return new com.alimm.tanx.ui.image.glide.load.data.FileDescriptorAssetPathFetcher(com.alimm.tanx.core.utils.AssetsUtil.getApplicationAssets(context), str);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.UriLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> getLocalUriFetcher(android.content.Context context, android.net.Uri uri) {
        return new com.alimm.tanx.ui.image.glide.load.data.FileDescriptorLocalUriFetcher(context, uri);
    }
}
