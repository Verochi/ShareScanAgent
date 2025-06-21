package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public class FileLoader<T> implements com.alimm.tanx.ui.image.glide.load.model.ModelLoader<java.io.File, T> {
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, T> uriLoader;

    public FileLoader(com.alimm.tanx.ui.image.glide.load.model.ModelLoader<android.net.Uri, T> modelLoader) {
        this.uriLoader = modelLoader;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public com.alimm.tanx.ui.image.glide.load.data.DataFetcher<T> getResourceFetcher(java.io.File file, int i, int i2) {
        return this.uriLoader.getResourceFetcher(android.net.Uri.fromFile(file), i, i2);
    }
}
