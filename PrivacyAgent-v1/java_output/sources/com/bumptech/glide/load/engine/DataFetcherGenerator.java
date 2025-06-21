package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
interface DataFetcherGenerator {

    public interface FetcherReadyCallback {
        void onDataFetcherFailed(com.bumptech.glide.load.Key key, java.lang.Exception exc, com.bumptech.glide.load.data.DataFetcher<?> dataFetcher, com.bumptech.glide.load.DataSource dataSource);

        void onDataFetcherReady(com.bumptech.glide.load.Key key, @androidx.annotation.Nullable java.lang.Object obj, com.bumptech.glide.load.data.DataFetcher<?> dataFetcher, com.bumptech.glide.load.DataSource dataSource, com.bumptech.glide.load.Key key2);

        void reschedule();
    }

    void cancel();

    boolean startNext();
}
