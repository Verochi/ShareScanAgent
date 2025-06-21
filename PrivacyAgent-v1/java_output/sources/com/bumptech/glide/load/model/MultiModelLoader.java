package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
class MultiModelLoader<Model, Data> implements com.bumptech.glide.load.model.ModelLoader<Model, Data> {
    private final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> exceptionListPool;
    private final java.util.List<com.bumptech.glide.load.model.ModelLoader<Model, Data>> modelLoaders;

    public static class MultiFetcher<Data> implements com.bumptech.glide.load.data.DataFetcher<Data>, com.bumptech.glide.load.data.DataFetcher.DataCallback<Data> {
        private com.bumptech.glide.load.data.DataFetcher.DataCallback<? super Data> callback;
        private int currentIndex;

        @androidx.annotation.Nullable
        private java.util.List<java.lang.Throwable> exceptions;
        private final java.util.List<com.bumptech.glide.load.data.DataFetcher<Data>> fetchers;
        private boolean isCancelled;
        private com.bumptech.glide.Priority priority;
        private final androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> throwableListPool;

        public MultiFetcher(@androidx.annotation.NonNull java.util.List<com.bumptech.glide.load.data.DataFetcher<Data>> list, @androidx.annotation.NonNull androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool) {
            this.throwableListPool = pool;
            com.bumptech.glide.util.Preconditions.checkNotEmpty(list);
            this.fetchers = list;
            this.currentIndex = 0;
        }

        private void startNextOrFail() {
            if (this.isCancelled) {
                return;
            }
            if (this.currentIndex < this.fetchers.size() - 1) {
                this.currentIndex++;
                loadData(this.priority, this.callback);
            } else {
                com.bumptech.glide.util.Preconditions.checkNotNull(this.exceptions);
                this.callback.onLoadFailed(new com.bumptech.glide.load.engine.GlideException("Fetch failed", new java.util.ArrayList(this.exceptions)));
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.isCancelled = true;
            java.util.Iterator<com.bumptech.glide.load.data.DataFetcher<Data>> it = this.fetchers.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            java.util.List<java.lang.Throwable> list = this.exceptions;
            if (list != null) {
                this.throwableListPool.release(list);
            }
            this.exceptions = null;
            java.util.Iterator<com.bumptech.glide.load.data.DataFetcher<Data>> it = this.fetchers.iterator();
            while (it.hasNext()) {
                it.next().cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public java.lang.Class<Data> getDataClass() {
            return this.fetchers.get(0).getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.DataSource getDataSource() {
            return this.fetchers.get(0).getDataSource();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super Data> dataCallback) {
            this.priority = priority;
            this.callback = dataCallback;
            this.exceptions = this.throwableListPool.acquire();
            this.fetchers.get(this.currentIndex).loadData(priority, this);
            if (this.isCancelled) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onDataReady(@androidx.annotation.Nullable Data data) {
            if (data != null) {
                this.callback.onDataReady(data);
            } else {
                startNextOrFail();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onLoadFailed(@androidx.annotation.NonNull java.lang.Exception exc) {
            ((java.util.List) com.bumptech.glide.util.Preconditions.checkNotNull(this.exceptions)).add(exc);
            startNextOrFail();
        }
    }

    public MultiModelLoader(@androidx.annotation.NonNull java.util.List<com.bumptech.glide.load.model.ModelLoader<Model, Data>> list, @androidx.annotation.NonNull androidx.core.util.Pools.Pool<java.util.List<java.lang.Throwable>> pool) {
        this.modelLoaders = list;
        this.exceptionListPool = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<Data> buildLoadData(@androidx.annotation.NonNull Model model, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        com.bumptech.glide.load.model.ModelLoader.LoadData<Data> buildLoadData;
        int size = this.modelLoaders.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        com.bumptech.glide.load.Key key = null;
        for (int i3 = 0; i3 < size; i3++) {
            com.bumptech.glide.load.model.ModelLoader<Model, Data> modelLoader = this.modelLoaders.get(i3);
            if (modelLoader.handles(model) && (buildLoadData = modelLoader.buildLoadData(model, i, i2, options)) != null) {
                key = buildLoadData.sourceKey;
                arrayList.add(buildLoadData.fetcher);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(key, new com.bumptech.glide.load.model.MultiModelLoader.MultiFetcher(arrayList, this.exceptionListPool));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull Model model) {
        java.util.Iterator<com.bumptech.glide.load.model.ModelLoader<Model, Data>> it = this.modelLoaders.iterator();
        while (it.hasNext()) {
            if (it.next().handles(model)) {
                return true;
            }
        }
        return false;
    }

    public java.lang.String toString() {
        return "MultiModelLoader{modelLoaders=" + java.util.Arrays.toString(this.modelLoaders.toArray()) + '}';
    }
}
