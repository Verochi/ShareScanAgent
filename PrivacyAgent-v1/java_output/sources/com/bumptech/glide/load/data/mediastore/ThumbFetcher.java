package com.bumptech.glide.load.data.mediastore;

/* loaded from: classes.dex */
public class ThumbFetcher implements com.bumptech.glide.load.data.DataFetcher<java.io.InputStream> {
    private static final java.lang.String TAG = "MediaStoreThumbFetcher";
    private java.io.InputStream inputStream;
    private final android.net.Uri mediaStoreImageUri;
    private final com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener opener;

    public static class ImageThumbnailQuery implements com.bumptech.glide.load.data.mediastore.ThumbnailQuery {
        private static final java.lang.String[] PATH_PROJECTION = {"_data"};
        private static final java.lang.String PATH_SELECTION = "kind = 1 AND image_id = ?";
        private final android.content.ContentResolver contentResolver;

        public ImageThumbnailQuery(android.content.ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public android.database.Cursor query(android.net.Uri uri) {
            return this.contentResolver.query(android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new java.lang.String[]{uri.getLastPathSegment()}, null);
        }
    }

    public static class VideoThumbnailQuery implements com.bumptech.glide.load.data.mediastore.ThumbnailQuery {
        private static final java.lang.String[] PATH_PROJECTION = {"_data"};
        private static final java.lang.String PATH_SELECTION = "kind = 1 AND video_id = ?";
        private final android.content.ContentResolver contentResolver;

        public VideoThumbnailQuery(android.content.ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public android.database.Cursor query(android.net.Uri uri) {
            return this.contentResolver.query(android.provider.MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new java.lang.String[]{uri.getLastPathSegment()}, null);
        }
    }

    @androidx.annotation.VisibleForTesting
    public ThumbFetcher(android.net.Uri uri, com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener thumbnailStreamOpener) {
        this.mediaStoreImageUri = uri;
        this.opener = thumbnailStreamOpener;
    }

    private static com.bumptech.glide.load.data.mediastore.ThumbFetcher build(android.content.Context context, android.net.Uri uri, com.bumptech.glide.load.data.mediastore.ThumbnailQuery thumbnailQuery) {
        return new com.bumptech.glide.load.data.mediastore.ThumbFetcher(uri, new com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener(com.bumptech.glide.Glide.get(context).getRegistry().getImageHeaderParsers(), thumbnailQuery, com.bumptech.glide.Glide.get(context).getArrayPool(), context.getContentResolver()));
    }

    public static com.bumptech.glide.load.data.mediastore.ThumbFetcher buildImageFetcher(android.content.Context context, android.net.Uri uri) {
        return build(context, uri, new com.bumptech.glide.load.data.mediastore.ThumbFetcher.ImageThumbnailQuery(context.getContentResolver()));
    }

    public static com.bumptech.glide.load.data.mediastore.ThumbFetcher buildVideoFetcher(android.content.Context context, android.net.Uri uri) {
        return build(context, uri, new com.bumptech.glide.load.data.mediastore.ThumbFetcher.VideoThumbnailQuery(context.getContentResolver()));
    }

    private java.io.InputStream openThumbInputStream() throws java.io.FileNotFoundException {
        java.io.InputStream open = this.opener.open(this.mediaStoreImageUri);
        int orientation = open != null ? this.opener.getOrientation(this.mediaStoreImageUri) : -1;
        return orientation != -1 ? new com.bumptech.glide.load.data.ExifOrientationStream(open, orientation) : open;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        java.io.InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @androidx.annotation.NonNull
    public java.lang.Class<java.io.InputStream> getDataClass() {
        return java.io.InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.DataSource getDataSource() {
        return com.bumptech.glide.load.DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super java.io.InputStream> dataCallback) {
        try {
            java.io.InputStream openThumbInputStream = openThumbInputStream();
            this.inputStream = openThumbInputStream;
            dataCallback.onDataReady(openThumbInputStream);
        } catch (java.io.FileNotFoundException e) {
            dataCallback.onLoadFailed(e);
        }
    }
}
