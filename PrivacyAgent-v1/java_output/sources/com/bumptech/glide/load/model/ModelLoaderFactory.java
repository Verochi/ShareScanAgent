package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public interface ModelLoaderFactory<T, Y> {
    @androidx.annotation.NonNull
    com.bumptech.glide.load.model.ModelLoader<T, Y> build(@androidx.annotation.NonNull com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory);

    void teardown();
}
