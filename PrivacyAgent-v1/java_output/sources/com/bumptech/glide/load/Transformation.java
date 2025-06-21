package com.bumptech.glide.load;

/* loaded from: classes.dex */
public interface Transformation<T> extends com.bumptech.glide.load.Key {
    @androidx.annotation.NonNull
    com.bumptech.glide.load.engine.Resource<T> transform(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<T> resource, int i, int i2);
}
