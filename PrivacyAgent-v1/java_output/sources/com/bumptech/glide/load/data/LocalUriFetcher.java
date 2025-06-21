package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public abstract class LocalUriFetcher<T> implements com.bumptech.glide.load.data.DataFetcher<T> {
    private static final java.lang.String TAG = "LocalUriFetcher";
    private final android.content.ContentResolver contentResolver;
    private T data;
    private final android.net.Uri uri;

    public LocalUriFetcher(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        this.contentResolver = contentResolver;
        this.uri = uri;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T t = this.data;
        if (t != null) {
            try {
                close(t);
            } catch (java.io.IOException unused) {
            }
        }
    }

    public abstract void close(T t) throws java.io.IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.DataSource getDataSource() {
        return com.bumptech.glide.load.DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T loadResource = loadResource(this.uri, this.contentResolver);
            this.data = loadResource;
            dataCallback.onDataReady(loadResource);
        } catch (java.io.FileNotFoundException e) {
            dataCallback.onLoadFailed(e);
        }
    }

    public abstract T loadResource(android.net.Uri uri, android.content.ContentResolver contentResolver) throws java.io.FileNotFoundException;
}
