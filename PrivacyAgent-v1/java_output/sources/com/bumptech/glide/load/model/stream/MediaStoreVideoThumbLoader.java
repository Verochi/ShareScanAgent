package com.bumptech.glide.load.model.stream;

/* loaded from: classes.dex */
public class MediaStoreVideoThumbLoader implements com.bumptech.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream> {
    private final android.content.Context context;

    public static class Factory implements com.bumptech.glide.load.model.ModelLoaderFactory<android.net.Uri, java.io.InputStream> {
        private final android.content.Context context;

        public Factory(android.content.Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader(this.context);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public MediaStoreVideoThumbLoader(android.content.Context context) {
        this.context = context.getApplicationContext();
    }

    private boolean isRequestingDefaultFrame(com.bumptech.glide.load.Options options) {
        java.lang.Long l = (java.lang.Long) options.get(com.bumptech.glide.load.resource.bitmap.VideoDecoder.TARGET_FRAME);
        return l != null && l.longValue() == -1;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.model.ModelLoader.LoadData<java.io.InputStream> buildLoadData(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        if (com.bumptech.glide.load.data.mediastore.MediaStoreUtil.isThumbnailSize(i, i2) && isRequestingDefaultFrame(options)) {
            return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(new com.bumptech.glide.signature.ObjectKey(uri), com.bumptech.glide.load.data.mediastore.ThumbFetcher.buildVideoFetcher(this.context, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull android.net.Uri uri) {
        return com.bumptech.glide.load.data.mediastore.MediaStoreUtil.isMediaStoreVideoUri(uri);
    }
}
