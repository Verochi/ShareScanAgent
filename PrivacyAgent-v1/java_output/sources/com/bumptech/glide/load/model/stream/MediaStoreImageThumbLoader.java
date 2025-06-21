package com.bumptech.glide.load.model.stream;

/* loaded from: classes.dex */
public class MediaStoreImageThumbLoader implements com.bumptech.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream> {
    private final android.content.Context context;

    public static class Factory implements com.bumptech.glide.load.model.ModelLoaderFactory<android.net.Uri, java.io.InputStream> {
        private final android.content.Context context;

        public Factory(android.content.Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader(this.context);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public MediaStoreImageThumbLoader(android.content.Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<java.io.InputStream> buildLoadData(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        if (com.bumptech.glide.load.data.mediastore.MediaStoreUtil.isThumbnailSize(i, i2)) {
            return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(new com.bumptech.glide.signature.ObjectKey(uri), com.bumptech.glide.load.data.mediastore.ThumbFetcher.buildImageFetcher(this.context, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull android.net.Uri uri) {
        return com.bumptech.glide.load.data.mediastore.MediaStoreUtil.isMediaStoreImageUri(uri);
    }
}
