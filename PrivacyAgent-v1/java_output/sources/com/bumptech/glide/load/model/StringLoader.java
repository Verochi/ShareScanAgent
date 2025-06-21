package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public class StringLoader<Data> implements com.bumptech.glide.load.model.ModelLoader<java.lang.String, Data> {
    private final com.bumptech.glide.load.model.ModelLoader<android.net.Uri, Data> uriLoader;

    public static final class AssetFileDescriptorFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.String, android.content.res.AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public com.bumptech.glide.load.model.ModelLoader<java.lang.String, android.content.res.AssetFileDescriptor> build(@androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.StringLoader(multiModelLoaderFactory.build(android.net.Uri.class, android.content.res.AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class FileDescriptorFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.String, android.os.ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<java.lang.String, android.os.ParcelFileDescriptor> build(@androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.StringLoader(multiModelLoaderFactory.build(android.net.Uri.class, android.os.ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class StreamFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<java.lang.String, java.io.InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<java.lang.String, java.io.InputStream> build(@androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.StringLoader(multiModelLoaderFactory.build(android.net.Uri.class, java.io.InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StringLoader(com.bumptech.glide.load.model.ModelLoader<android.net.Uri, Data> modelLoader) {
        this.uriLoader = modelLoader;
    }

    @androidx.annotation.Nullable
    private static android.net.Uri parseUri(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return toFileUri(str);
        }
        android.net.Uri parse = android.net.Uri.parse(str);
        return parse.getScheme() == null ? toFileUri(str) : parse;
    }

    private static android.net.Uri toFileUri(java.lang.String str) {
        return android.net.Uri.fromFile(new java.io.File(str));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<Data> buildLoadData(@androidx.annotation.NonNull java.lang.String str, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        android.net.Uri parseUri = parseUri(str);
        if (parseUri == null || !this.uriLoader.handles(parseUri)) {
            return null;
        }
        return this.uriLoader.buildLoadData(parseUri, i, i2, options);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull java.lang.String str) {
        return true;
    }
}
