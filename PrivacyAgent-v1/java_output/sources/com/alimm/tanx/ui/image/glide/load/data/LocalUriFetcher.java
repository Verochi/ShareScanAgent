package com.alimm.tanx.ui.image.glide.load.data;

/* loaded from: classes.dex */
public abstract class LocalUriFetcher<T> implements com.alimm.tanx.ui.image.glide.load.data.DataFetcher<T> {
    private static final java.lang.String TAG = "LocalUriFetcher";
    private final android.content.Context context;
    private T data;
    private final android.net.Uri uri;

    public LocalUriFetcher(android.content.Context context, android.net.Uri uri) {
        this.context = context.getApplicationContext();
        this.uri = uri;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
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

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public java.lang.String getId() {
        return this.uri.toString();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public final T loadData(com.alimm.tanx.ui.image.glide.Priority priority) throws java.lang.Exception {
        T loadResource = loadResource(this.uri, this.context.getContentResolver());
        this.data = loadResource;
        return loadResource;
    }

    public abstract T loadResource(android.net.Uri uri, android.content.ContentResolver contentResolver) throws java.io.FileNotFoundException;
}
