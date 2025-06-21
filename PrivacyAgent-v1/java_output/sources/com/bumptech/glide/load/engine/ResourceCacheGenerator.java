package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
class ResourceCacheGenerator implements com.bumptech.glide.load.engine.DataFetcherGenerator, com.bumptech.glide.load.data.DataFetcher.DataCallback<java.lang.Object> {
    private java.io.File cacheFile;
    private final com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback cb;
    private com.bumptech.glide.load.engine.ResourceCacheKey currentKey;
    private final com.bumptech.glide.load.engine.DecodeHelper<?> helper;
    private volatile com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private java.util.List<com.bumptech.glide.load.model.ModelLoader<java.io.File, ?>> modelLoaders;
    private int resourceClassIndex = -1;
    private int sourceIdIndex;
    private com.bumptech.glide.load.Key sourceKey;

    public ResourceCacheGenerator(com.bumptech.glide.load.engine.DecodeHelper<?> decodeHelper, com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    private boolean hasNextModelLoader() {
        return this.modelLoaderIndex < this.modelLoaders.size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        com.bumptech.glide.load.model.ModelLoader.LoadData<?> loadData = this.loadData;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(java.lang.Object obj) {
        this.cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE, this.currentKey);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@androidx.annotation.NonNull java.lang.Exception exc) {
        this.cb.onDataFetcherFailed(this.currentKey, exc, this.loadData.fetcher, com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        java.util.List<com.bumptech.glide.load.Key> cacheKeys = this.helper.getCacheKeys();
        boolean z = false;
        if (cacheKeys.isEmpty()) {
            return false;
        }
        java.util.List<java.lang.Class<?>> registeredResourceClasses = this.helper.getRegisteredResourceClasses();
        if (registeredResourceClasses.isEmpty()) {
            if (java.io.File.class.equals(this.helper.getTranscodeClass())) {
                return false;
            }
            throw new java.lang.IllegalStateException("Failed to find any load path from " + this.helper.getModelClass() + " to " + this.helper.getTranscodeClass());
        }
        while (true) {
            if (this.modelLoaders != null && hasNextModelLoader()) {
                this.loadData = null;
                while (!z && hasNextModelLoader()) {
                    java.util.List<com.bumptech.glide.load.model.ModelLoader<java.io.File, ?>> list = this.modelLoaders;
                    int i = this.modelLoaderIndex;
                    this.modelLoaderIndex = i + 1;
                    this.loadData = list.get(i).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
                    if (this.loadData != null && this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) {
                        this.loadData.fetcher.loadData(this.helper.getPriority(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.resourceClassIndex + 1;
            this.resourceClassIndex = i2;
            if (i2 >= registeredResourceClasses.size()) {
                int i3 = this.sourceIdIndex + 1;
                this.sourceIdIndex = i3;
                if (i3 >= cacheKeys.size()) {
                    return false;
                }
                this.resourceClassIndex = 0;
            }
            com.bumptech.glide.load.Key key = cacheKeys.get(this.sourceIdIndex);
            java.lang.Class<?> cls = registeredResourceClasses.get(this.resourceClassIndex);
            this.currentKey = new com.bumptech.glide.load.engine.ResourceCacheKey(this.helper.getArrayPool(), key, this.helper.getSignature(), this.helper.getWidth(), this.helper.getHeight(), this.helper.getTransformation(cls), cls, this.helper.getOptions());
            java.io.File file = this.helper.getDiskCache().get(this.currentKey);
            this.cacheFile = file;
            if (file != null) {
                this.sourceKey = key;
                this.modelLoaders = this.helper.getModelLoaders(file);
                this.modelLoaderIndex = 0;
            }
        }
    }
}
