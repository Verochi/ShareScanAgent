package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public interface ModelLoader<Model, Data> {

    public static class LoadData<Data> {
        public final java.util.List<com.bumptech.glide.load.Key> alternateKeys;
        public final com.bumptech.glide.load.data.DataFetcher<Data> fetcher;
        public final com.bumptech.glide.load.Key sourceKey;

        public LoadData(@androidx.annotation.NonNull com.bumptech.glide.load.Key key, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher<Data> dataFetcher) {
            this(key, java.util.Collections.emptyList(), dataFetcher);
        }

        public LoadData(@androidx.annotation.NonNull com.bumptech.glide.load.Key key, @androidx.annotation.NonNull java.util.List<com.bumptech.glide.load.Key> list, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher<Data> dataFetcher) {
            this.sourceKey = (com.bumptech.glide.load.Key) com.bumptech.glide.util.Preconditions.checkNotNull(key);
            this.alternateKeys = (java.util.List) com.bumptech.glide.util.Preconditions.checkNotNull(list);
            this.fetcher = (com.bumptech.glide.load.data.DataFetcher) com.bumptech.glide.util.Preconditions.checkNotNull(dataFetcher);
        }
    }

    @androidx.annotation.Nullable
    com.bumptech.glide.load.model.ModelLoader.LoadData<Data> buildLoadData(@androidx.annotation.NonNull Model model, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options);

    boolean handles(@androidx.annotation.NonNull Model model);
}
