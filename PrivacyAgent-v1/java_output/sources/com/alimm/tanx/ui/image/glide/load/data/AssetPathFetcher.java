package com.alimm.tanx.ui.image.glide.load.data;

/* loaded from: classes.dex */
public abstract class AssetPathFetcher<T> implements com.alimm.tanx.ui.image.glide.load.data.DataFetcher<T> {
    private static final java.lang.String TAG = "AssetUriFetcher";
    private final android.content.res.AssetManager assetManager;
    private final java.lang.String assetPath;
    private T data;

    public AssetPathFetcher(android.content.res.AssetManager assetManager, java.lang.String str) {
        this.assetManager = assetManager;
        this.assetPath = str;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
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

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public java.lang.String getId() {
        return this.assetPath;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public T loadData(com.alimm.tanx.ui.image.glide.Priority priority) throws java.lang.Exception {
        T loadResource = loadResource(this.assetManager, this.assetPath);
        this.data = loadResource;
        return loadResource;
    }

    public abstract T loadResource(android.content.res.AssetManager assetManager, java.lang.String str) throws java.io.IOException;
}
