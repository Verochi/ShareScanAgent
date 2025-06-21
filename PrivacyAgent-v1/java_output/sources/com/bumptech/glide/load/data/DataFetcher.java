package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public interface DataFetcher<T> {

    public interface DataCallback<T> {
        void onDataReady(@androidx.annotation.Nullable T t);

        void onLoadFailed(@androidx.annotation.NonNull java.lang.Exception exc);
    }

    void cancel();

    void cleanup();

    @androidx.annotation.NonNull
    java.lang.Class<T> getDataClass();

    @androidx.annotation.NonNull
    com.bumptech.glide.load.DataSource getDataSource();

    void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super T> dataCallback);
}
