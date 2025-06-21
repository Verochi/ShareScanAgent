package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public class UnitModelLoader<Model> implements com.bumptech.glide.load.model.ModelLoader<Model, Model> {
    private static final com.bumptech.glide.load.model.UnitModelLoader<?> INSTANCE = new com.bumptech.glide.load.model.UnitModelLoader<>();

    public static class Factory<Model> implements com.bumptech.glide.load.model.ModelLoaderFactory<Model, Model> {
        private static final com.bumptech.glide.load.model.UnitModelLoader.Factory<?> FACTORY = new com.bumptech.glide.load.model.UnitModelLoader.Factory<>();

        @java.lang.Deprecated
        public Factory() {
        }

        public static <T> com.bumptech.glide.load.model.UnitModelLoader.Factory<T> getInstance() {
            return (com.bumptech.glide.load.model.UnitModelLoader.Factory<T>) FACTORY;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.model.ModelLoader<Model, Model> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory) {
            return com.bumptech.glide.load.model.UnitModelLoader.getInstance();
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class UnitFetcher<Model> implements com.bumptech.glide.load.data.DataFetcher<Model> {
        private final Model resource;

        public UnitFetcher(Model model) {
            this.resource = model;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public java.lang.Class<Model> getDataClass() {
            return (java.lang.Class<Model>) this.resource.getClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.DataSource getDataSource() {
            return com.bumptech.glide.load.DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super Model> dataCallback) {
            dataCallback.onDataReady(this.resource);
        }
    }

    @java.lang.Deprecated
    public UnitModelLoader() {
    }

    public static <T> com.bumptech.glide.load.model.UnitModelLoader<T> getInstance() {
        return (com.bumptech.glide.load.model.UnitModelLoader<T>) INSTANCE;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public com.bumptech.glide.load.model.ModelLoader.LoadData<Model> buildLoadData(@androidx.annotation.NonNull Model model, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return new com.bumptech.glide.load.model.ModelLoader.LoadData<>(new com.bumptech.glide.signature.ObjectKey(model), new com.bumptech.glide.load.model.UnitModelLoader.UnitFetcher(model));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@androidx.annotation.NonNull Model model) {
        return true;
    }
}
