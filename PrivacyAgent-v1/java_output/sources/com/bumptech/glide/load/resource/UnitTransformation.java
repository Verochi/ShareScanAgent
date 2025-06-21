package com.bumptech.glide.load.resource;

/* loaded from: classes.dex */
public final class UnitTransformation<T> implements com.bumptech.glide.load.Transformation<T> {
    private static final com.bumptech.glide.load.Transformation<?> TRANSFORMATION = new com.bumptech.glide.load.resource.UnitTransformation();

    private UnitTransformation() {
    }

    @androidx.annotation.NonNull
    public static <T> com.bumptech.glide.load.resource.UnitTransformation<T> get() {
        return (com.bumptech.glide.load.resource.UnitTransformation) TRANSFORMATION;
    }

    @Override // com.bumptech.glide.load.Transformation
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.engine.Resource<T> transform(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<T> resource, int i, int i2) {
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
    }
}
