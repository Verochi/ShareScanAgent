package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
class SourceGenerator implements com.bumptech.glide.load.engine.DataFetcherGenerator, com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback {
    private static final java.lang.String TAG = "SourceGenerator";
    private final com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback cb;
    private java.lang.Object dataToCache;
    private final com.bumptech.glide.load.engine.DecodeHelper<?> helper;
    private volatile com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData;
    private int loadDataListIndex;
    private com.bumptech.glide.load.engine.DataCacheKey originalKey;
    private com.bumptech.glide.load.engine.DataCacheGenerator sourceCacheGenerator;

    /* renamed from: com.bumptech.glide.load.engine.SourceGenerator$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.load.data.DataFetcher.DataCallback<java.lang.Object> {
        final /* synthetic */ com.bumptech.glide.load.model.ModelLoader.LoadData val$toStart;

        public AnonymousClass1(com.bumptech.glide.load.model.ModelLoader.LoadData loadData) {
            this.val$toStart = loadData;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onDataReady(@androidx.annotation.Nullable java.lang.Object obj) {
            if (com.bumptech.glide.load.engine.SourceGenerator.this.isCurrentRequest(this.val$toStart)) {
                com.bumptech.glide.load.engine.SourceGenerator.this.onDataReadyInternal(this.val$toStart, obj);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onLoadFailed(@androidx.annotation.NonNull java.lang.Exception exc) {
            if (com.bumptech.glide.load.engine.SourceGenerator.this.isCurrentRequest(this.val$toStart)) {
                com.bumptech.glide.load.engine.SourceGenerator.this.onLoadFailedInternal(this.val$toStart, exc);
            }
        }
    }

    public SourceGenerator(com.bumptech.glide.load.engine.DecodeHelper<?> decodeHelper, com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    private void cacheData(java.lang.Object obj) {
        long logTime = com.bumptech.glide.util.LogTime.getLogTime();
        try {
            com.bumptech.glide.load.Encoder<X> sourceEncoder = this.helper.getSourceEncoder(obj);
            com.bumptech.glide.load.engine.DataCacheWriter dataCacheWriter = new com.bumptech.glide.load.engine.DataCacheWriter(sourceEncoder, obj, this.helper.getOptions());
            this.originalKey = new com.bumptech.glide.load.engine.DataCacheKey(this.loadData.sourceKey, this.helper.getSignature());
            this.helper.getDiskCache().put(this.originalKey, dataCacheWriter);
            if (android.util.Log.isLoggable(TAG, 2)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Finished encoding source to cache, key: ");
                sb.append(this.originalKey);
                sb.append(", data: ");
                sb.append(obj);
                sb.append(", encoder: ");
                sb.append(sourceEncoder);
                sb.append(", duration: ");
                sb.append(com.bumptech.glide.util.LogTime.getElapsedMillis(logTime));
            }
            this.loadData.fetcher.cleanup();
            this.sourceCacheGenerator = new com.bumptech.glide.load.engine.DataCacheGenerator(java.util.Collections.singletonList(this.loadData.sourceKey), this.helper, this);
        } catch (java.lang.Throwable th) {
            this.loadData.fetcher.cleanup();
            throw th;
        }
    }

    private boolean hasNextModelLoader() {
        return this.loadDataListIndex < this.helper.getLoadData().size();
    }

    private void startNextLoad(com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData) {
        this.loadData.fetcher.loadData(this.helper.getPriority(), new com.bumptech.glide.load.engine.SourceGenerator.AnonymousClass1(loadData));
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData = this.loadData;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    public boolean isCurrentRequest(com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData) {
        com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData2 = this.loadData;
        return loadData2 != null && loadData2 == loadData;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(com.bumptech.glide.load.Key key, java.lang.Exception exc, com.bumptech.glide.load.data.DataFetcher<?> dataFetcher, com.bumptech.glide.load.DataSource dataSource) {
        this.cb.onDataFetcherFailed(key, exc, dataFetcher, this.loadData.fetcher.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(com.bumptech.glide.load.Key key, java.lang.Object obj, com.bumptech.glide.load.data.DataFetcher<?> dataFetcher, com.bumptech.glide.load.DataSource dataSource, com.bumptech.glide.load.Key key2) {
        this.cb.onDataFetcherReady(key, obj, dataFetcher, this.loadData.fetcher.getDataSource(), key);
    }

    public void onDataReadyInternal(com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData, java.lang.Object obj) {
        com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy = this.helper.getDiskCacheStrategy();
        if (obj != null && diskCacheStrategy.isDataCacheable(loadData.fetcher.getDataSource())) {
            this.dataToCache = obj;
            this.cb.reschedule();
        } else {
            com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.cb;
            com.bumptech.glide.load.Key key = loadData.sourceKey;
            com.bumptech.glide.load.data.DataFetcher<?> dataFetcher = loadData.fetcher;
            fetcherReadyCallback.onDataFetcherReady(key, obj, dataFetcher, dataFetcher.getDataSource(), this.originalKey);
        }
    }

    public void onLoadFailedInternal(com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData, @androidx.annotation.NonNull java.lang.Exception exc) {
        com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.cb;
        com.bumptech.glide.load.engine.DataCacheKey dataCacheKey = this.originalKey;
        com.bumptech.glide.load.data.DataFetcher<?> dataFetcher = loadData.fetcher;
        fetcherReadyCallback.onDataFetcherFailed(dataCacheKey, exc, dataFetcher, dataFetcher.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        java.lang.Object obj = this.dataToCache;
        if (obj != null) {
            this.dataToCache = null;
            cacheData(obj);
        }
        com.bumptech.glide.load.engine.DataCacheGenerator dataCacheGenerator = this.sourceCacheGenerator;
        if (dataCacheGenerator != null && dataCacheGenerator.startNext()) {
            return true;
        }
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean z = false;
        while (!z && hasNextModelLoader()) {
            java.util.List<com.bumptech.glide.load.model.ModelLoader.LoadData<?>> loadData = this.helper.getLoadData();
            int i = this.loadDataListIndex;
            this.loadDataListIndex = i + 1;
            this.loadData = loadData.get(i);
            if (this.loadData != null && (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) || this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()))) {
                startNextLoad(this.loadData);
                z = true;
            }
        }
        return z;
    }
}
