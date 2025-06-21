package com.bumptech.glide.load.model.stream;

@androidx.annotation.RequiresApi(29)
/* loaded from: classes.dex */
public final class QMediaStoreUriLoader<DataT> implements com.bumptech.glide.load.model.ModelLoader<android.net.Uri, DataT> {
    private final android.content.Context context;
    private final java.lang.Class<DataT> dataClass;
    private final com.bumptech.glide.load.model.ModelLoader<java.io.File, DataT> fileDelegate;
    private final com.bumptech.glide.load.model.ModelLoader<android.net.Uri, DataT> uriDelegate;

    public static abstract class Factory<DataT> implements com.bumptech.glide.load.model.ModelLoaderFactory<android.net.Uri, DataT> {
        private final android.content.Context context;
        private final java.lang.Class<DataT> dataClass;

        public Factory(android.content.Context context, java.lang.Class<DataT> cls) {
            this.context = context;
            this.dataClass = cls;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public final com.bumptech.glide.load.model.ModelLoader<android.net.Uri, DataT> build(@androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return new com.bumptech.glide.load.model.stream.QMediaStoreUriLoader(this.context, multiModelLoaderFactory.build(java.io.File.class, this.dataClass), multiModelLoaderFactory.build(android.net.Uri.class, this.dataClass), this.dataClass);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }
    }

    @androidx.annotation.RequiresApi(29)
    public static final class FileDescriptorFactory extends com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.Factory<android.os.ParcelFileDescriptor> {
        public FileDescriptorFactory(android.content.Context context) {
            super(context, android.os.ParcelFileDescriptor.class);
        }
    }

    @androidx.annotation.RequiresApi(29)
    public static final class InputStreamFactory extends com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.Factory<java.io.InputStream> {
        public InputStreamFactory(android.content.Context context) {
            super(context, java.io.InputStream.class);
        }
    }

    public static final class QMediaStoreUriFetcher<DataT> implements com.bumptech.glide.load.data.DataFetcher<DataT> {
        private static final java.lang.String[] PROJECTION = {"_data"};
        private final android.content.Context context;
        private final java.lang.Class<DataT> dataClass;

        @androidx.annotation.Nullable
        private volatile com.bumptech.glide.load.data.DataFetcher<DataT> delegate;
        private final com.bumptech.glide.load.model.ModelLoader<java.io.File, DataT> fileDelegate;
        private final int height;
        private volatile boolean isCancelled;
        private final com.bumptech.glide.load.Options options;
        private final android.net.Uri uri;
        private final com.bumptech.glide.load.model.ModelLoader<android.net.Uri, DataT> uriDelegate;
        private final int width;

        public QMediaStoreUriFetcher(android.content.Context context, com.bumptech.glide.load.model.ModelLoader<java.io.File, DataT> modelLoader, com.bumptech.glide.load.model.ModelLoader<android.net.Uri, DataT> modelLoader2, android.net.Uri uri, int i, int i2, com.bumptech.glide.load.Options options, java.lang.Class<DataT> cls) {
            this.context = context.getApplicationContext();
            this.fileDelegate = modelLoader;
            this.uriDelegate = modelLoader2;
            this.uri = uri;
            this.width = i;
            this.height = i2;
            this.options = options;
            this.dataClass = cls;
        }

        @androidx.annotation.Nullable
        private com.bumptech.glide.load.model.ModelLoader.LoadData<DataT> buildDelegateData() throws java.io.FileNotFoundException {
            boolean isExternalStorageLegacy;
            isExternalStorageLegacy = android.os.Environment.isExternalStorageLegacy();
            if (isExternalStorageLegacy) {
                return this.fileDelegate.buildLoadData(queryForFilePath(this.uri), this.width, this.height, this.options);
            }
            return this.uriDelegate.buildLoadData(isAccessMediaLocationGranted() ? android.provider.MediaStore.setRequireOriginal(this.uri) : this.uri, this.width, this.height, this.options);
        }

        @androidx.annotation.Nullable
        private com.bumptech.glide.load.data.DataFetcher<DataT> buildDelegateFetcher() throws java.io.FileNotFoundException {
            com.bumptech.glide.load.model.ModelLoader.LoadData<DataT> buildDelegateData = buildDelegateData();
            if (buildDelegateData != null) {
                return buildDelegateData.fetcher;
            }
            return null;
        }

        private boolean isAccessMediaLocationGranted() {
            int checkSelfPermission;
            checkSelfPermission = this.context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION");
            return checkSelfPermission == 0;
        }

        @androidx.annotation.NonNull
        private java.io.File queryForFilePath(android.net.Uri uri) throws java.io.FileNotFoundException {
            android.database.Cursor cursor = null;
            try {
                android.database.Cursor query = this.context.getContentResolver().query(uri, PROJECTION, null, null, null);
                if (query == null || !query.moveToFirst()) {
                    throw new java.io.FileNotFoundException("Failed to media store entry for: " + uri);
                }
                java.lang.String string = query.getString(query.getColumnIndexOrThrow("_data"));
                if (!android.text.TextUtils.isEmpty(string)) {
                    java.io.File file = new java.io.File(string);
                    query.close();
                    return file;
                }
                throw new java.io.FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (java.lang.Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.isCancelled = true;
            com.bumptech.glide.load.data.DataFetcher<DataT> dataFetcher = this.delegate;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            com.bumptech.glide.load.data.DataFetcher<DataT> dataFetcher = this.delegate;
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public java.lang.Class<DataT> getDataClass() {
            return this.dataClass;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.DataSource getDataSource() {
            return com.bumptech.glide.load.DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super DataT> dataCallback) {
            try {
                com.bumptech.glide.load.data.DataFetcher<DataT> buildDelegateFetcher = buildDelegateFetcher();
                if (buildDelegateFetcher == null) {
                    dataCallback.onLoadFailed(new java.lang.IllegalArgumentException("Failed to build fetcher for: " + this.uri));
                    return;
                }
                this.delegate = buildDelegateFetcher;
                if (this.isCancelled) {
                    cancel();
                } else {
                    buildDelegateFetcher.loadData(priority, dataCallback);
                }
            } catch (java.io.FileNotFoundException e) {
                dataCallback.onLoadFailed(e);
            }
        }
    }

    public QMediaStoreUriLoader(android.content.Context context, com.bumptech.glide.load.model.ModelLoader<java.io.File, DataT> modelLoader, com.bumptech.glide.load.model.ModelLoader<android.net.Uri, DataT> modelLoader2, java.lang.Class<DataT> cls) {
        this.context = context.getApplicationContext();
        this.fileDelegate = modelLoader;
        this.uriDelegate = modelLoader2;
        this.dataClass = cls;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<DataT> buildLoadData(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(new com.bumptech.glide.signature.ObjectKey(uri), new com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.QMediaStoreUriFetcher(this.context, this.fileDelegate, this.uriDelegate, uri, i, i2, options, this.dataClass));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull android.net.Uri uri) {
        return android.os.Build.VERSION.SDK_INT >= 29 && com.bumptech.glide.load.data.mediastore.MediaStoreUtil.isMediaStoreUri(uri);
    }
}
