package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public class ResourceLoader<Data> implements com.bumptech.glide.load.model.ModelLoader<java.lang.Integer, Data> {
    private static final java.lang.String TAG = "ResourceLoader";
    private final android.content.res.Resources resources;
    private final com.bumptech.glide.load.model.ModelLoader<android.net.Uri, Data> uriLoader;

    public static final class AssetFileDescriptorFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, android.content.res.AssetFileDescriptor> {
        private final android.content.res.Resources resources;

        public AssetFileDescriptorFactory(android.content.res.Resources resources) {
            this.resources = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public com.bumptech.glide.load.model.ModelLoader<java.lang.Integer, android.content.res.AssetFileDescriptor> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.ResourceLoader(this.resources, multiModelLoaderFactory.build(android.net.Uri.class, android.content.res.AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class FileDescriptorFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, android.os.ParcelFileDescriptor> {
        private final android.content.res.Resources resources;

        public FileDescriptorFactory(android.content.res.Resources resources) {
            this.resources = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<java.lang.Integer, android.os.ParcelFileDescriptor> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.ResourceLoader(this.resources, multiModelLoaderFactory.build(android.net.Uri.class, android.os.ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class StreamFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, java.io.InputStream> {
        private final android.content.res.Resources resources;

        public StreamFactory(android.content.res.Resources resources) {
            this.resources = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<java.lang.Integer, java.io.InputStream> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.ResourceLoader(this.resources, multiModelLoaderFactory.build(android.net.Uri.class, java.io.InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class UriFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.Integer, android.net.Uri> {
        private final android.content.res.Resources resources;

        public UriFactory(android.content.res.Resources resources) {
            this.resources = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<java.lang.Integer, android.net.Uri> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.ResourceLoader(this.resources, com.bumptech.glide.load.model.UnitModelLoader.getInstance());
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public ResourceLoader(android.content.res.Resources resources, com.bumptech.glide.load.model.ModelLoader<android.net.Uri, Data> modelLoader) {
        this.resources = resources;
        this.uriLoader = modelLoader;
    }

    @androidx.annotation.Nullable
    private android.net.Uri getResourceUri(java.lang.Integer num) {
        try {
            return android.net.Uri.parse("android.resource://" + this.resources.getResourcePackageName(num.intValue()) + '/' + this.resources.getResourceTypeName(num.intValue()) + '/' + this.resources.getResourceEntryName(num.intValue()));
        } catch (android.content.res.Resources.NotFoundException unused) {
            if (!android.util.Log.isLoggable(TAG, 5)) {
                return null;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Received invalid resource id: ");
            sb.append(num);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<Data> buildLoadData(@androidx.annotation.NonNull java.lang.Integer num, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        android.net.Uri resourceUri = getResourceUri(num);
        if (resourceUri == null) {
            return null;
        }
        return this.uriLoader.buildLoadData(resourceUri, i, i2, options);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull java.lang.Integer num) {
        return true;
    }
}
