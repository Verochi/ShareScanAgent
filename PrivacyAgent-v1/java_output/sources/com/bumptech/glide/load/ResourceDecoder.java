package com.bumptech.glide.load;

/* loaded from: classes.dex */
public interface ResourceDecoder<T, Z> {
    @androidx.annotation.Nullable
    com.bumptech.glide.load.engine.Resource<Z> decode(@androidx.annotation.NonNull T t, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException;

    boolean handles(@androidx.annotation.NonNull T t, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException;
}
