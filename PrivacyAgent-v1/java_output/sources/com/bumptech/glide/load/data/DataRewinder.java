package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public interface DataRewinder<T> {

    public interface Factory<T> {
        @androidx.annotation.NonNull
        com.bumptech.glide.load.data.DataRewinder<T> build(@androidx.annotation.NonNull T t);

        @androidx.annotation.NonNull
        java.lang.Class<T> getDataClass();
    }

    void cleanup();

    @androidx.annotation.NonNull
    T rewindAndGet() throws java.io.IOException;
}
