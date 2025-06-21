package com.bumptech.glide.load.resource;

/* loaded from: classes.dex */
public class SimpleResource<T> implements com.bumptech.glide.load.engine.Resource<T> {
    protected final T data;

    public SimpleResource(@androidx.annotation.NonNull T t) {
        this.data = (T) com.bumptech.glide.util.Preconditions.checkNotNull(t);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public final T get() {
        return this.data;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public java.lang.Class<T> getResourceClass() {
        return (java.lang.Class<T>) this.data.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }
}
