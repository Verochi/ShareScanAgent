package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public class AssetUriLoader<Data> implements com.bumptech.glide.load.model.ModelLoader<android.net.Uri, Data> {
    private static final java.lang.String ASSET_PATH_SEGMENT = "android_asset";
    private static final java.lang.String ASSET_PREFIX = "file:///android_asset/";
    private static final int ASSET_PREFIX_LENGTH = 22;
    private final android.content.res.AssetManager assetManager;
    private final com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory<Data> factory;

    public interface AssetFetcherFactory<Data> {
        com.bumptech.glide.load.data.DataFetcher<Data> buildFetcher(android.content.res.AssetManager assetManager, java.lang.String str);
    }

    public static class FileDescriptorFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<android.net.Uri, android.os.ParcelFileDescriptor>, com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory<android.os.ParcelFileDescriptor> {
        private final android.content.res.AssetManager assetManager;

        public FileDescriptorFactory(android.content.res.AssetManager assetManager) {
            this.assetManager = assetManager;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<android.net.Uri, android.os.ParcelFileDescriptor> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.AssetUriLoader(this.assetManager, this);
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory
        public com.bumptech.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> buildFetcher(android.content.res.AssetManager assetManager, java.lang.String str) {
            return new com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class StreamFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<android.net.Uri, java.io.InputStream>, com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory<java.io.InputStream> {
        private final android.content.res.AssetManager assetManager;

        public StreamFactory(android.content.res.AssetManager assetManager) {
            this.assetManager = assetManager;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.AssetUriLoader(this.assetManager, this);
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory
        public com.bumptech.glide.load.data.DataFetcher<java.io.InputStream> buildFetcher(android.content.res.AssetManager assetManager, java.lang.String str) {
            return new com.bumptech.glide.load.data.StreamAssetPathFetcher(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public AssetUriLoader(android.content.res.AssetManager assetManager, com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory<Data> assetFetcherFactory) {
        this.assetManager = assetManager;
        this.factory = assetFetcherFactory;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<Data> buildLoadData(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(new com.bumptech.glide.signature.ObjectKey(uri), this.factory.buildFetcher(this.assetManager, uri.toString().substring(ASSET_PREFIX_LENGTH)));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull android.net.Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && ASSET_PATH_SEGMENT.equals(uri.getPathSegments().get(0));
    }
}
