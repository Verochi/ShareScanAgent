package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public final class MediaStoreFileLoader implements com.bumptech.glide.load.model.ModelLoader<android.net.Uri, java.io.File> {
    private final android.content.Context context;

    public static final class Factory implements com.bumptech.glide.load.model.ModelLoaderFactory<android.net.Uri, java.io.File> {
        private final android.content.Context context;

        public Factory(android.content.Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<android.net.Uri, java.io.File> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.MediaStoreFileLoader(this.context);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class FilePathFetcher implements com.bumptech.glide.load.data.DataFetcher<java.io.File> {
        private static final java.lang.String[] PROJECTION = {"_data"};
        private final android.content.Context context;
        private final android.net.Uri uri;

        public FilePathFetcher(android.content.Context context, android.net.Uri uri) {
            this.context = context;
            this.uri = uri;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public java.lang.Class<java.io.File> getDataClass() {
            return java.io.File.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.DataSource getDataSource() {
            return com.bumptech.glide.load.DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super java.io.File> dataCallback) {
            android.database.Cursor query = this.context.getContentResolver().query(this.uri, PROJECTION, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (!android.text.TextUtils.isEmpty(r0)) {
                dataCallback.onDataReady(new java.io.File(r0));
                return;
            }
            dataCallback.onLoadFailed(new java.io.FileNotFoundException("Failed to find file path for: " + this.uri));
        }
    }

    public MediaStoreFileLoader(android.content.Context context) {
        this.context = context;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<java.io.File> buildLoadData(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(new com.bumptech.glide.signature.ObjectKey(uri), new com.bumptech.glide.load.model.MediaStoreFileLoader.FilePathFetcher(this.context, uri));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull android.net.Uri uri) {
        return com.bumptech.glide.load.data.mediastore.MediaStoreUtil.isMediaStoreUri(uri);
    }
}
