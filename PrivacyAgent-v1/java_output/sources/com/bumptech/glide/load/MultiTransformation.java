package com.bumptech.glide.load;

/* loaded from: classes.dex */
public class MultiTransformation<T> implements com.bumptech.glide.load.Transformation<T> {
    private final java.util.Collection<? extends com.bumptech.glide.load.Transformation<T>> transformations;

    public MultiTransformation(@androidx.annotation.NonNull java.util.Collection<? extends com.bumptech.glide.load.Transformation<T>> collection) {
        if (collection.isEmpty()) {
            throw new java.lang.IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = collection;
    }

    @java.lang.SafeVarargs
    public MultiTransformation(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<T>... transformationArr) {
        if (transformationArr.length == 0) {
            throw new java.lang.IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = java.util.Arrays.asList(transformationArr);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.bumptech.glide.load.MultiTransformation) {
            return this.transformations.equals(((com.bumptech.glide.load.MultiTransformation) obj).transformations);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.transformations.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.engine.Resource<T> transform(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<T> resource, int i, int i2) {
        java.util.Iterator<? extends com.bumptech.glide.load.Transformation<T>> it = this.transformations.iterator();
        com.bumptech.glide.load.engine.Resource<T> resource2 = resource;
        while (it.hasNext()) {
            com.bumptech.glide.load.engine.Resource<T> transform = it.next().transform(context, resource2, i, i2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(transform)) {
                resource2.recycle();
            }
            resource2 = transform;
        }
        return resource2;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        java.util.Iterator<? extends com.bumptech.glide.load.Transformation<T>> it = this.transformations.iterator();
        while (it.hasNext()) {
            it.next().updateDiskCacheKey(messageDigest);
        }
    }
}
