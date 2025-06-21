package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public abstract class AssetPathFetcher<T> implements com.bumptech.glide.load.data.DataFetcher<T> {
    private static final java.lang.String TAG = "AssetPathFetcher";
    private final android.content.res.AssetManager assetManager;
    private final java.lang.String assetPath;
    private T data;

    public AssetPathFetcher(android.content.res.AssetManager assetManager, java.lang.String str) {
        this.assetManager = assetManager;
        this.assetPath = str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T t = this.data;
        if (t == null) {
            return;
        }
        try {
            close(t);
        } catch (java.io.IOException unused) {
        }
    }

    public abstract void close(T t) throws java.io.IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.DataSource getDataSource() {
        return com.bumptech.glide.load.DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T loadResource = loadResource(this.assetManager, this.assetPath);
            this.data = loadResource;
            dataCallback.onDataReady(loadResource);
        } catch (java.io.IOException e) {
            dataCallback.onLoadFailed(e);
        }
    }

    public abstract T loadResource(android.content.res.AssetManager assetManager, java.lang.String str) throws java.io.IOException;
}
