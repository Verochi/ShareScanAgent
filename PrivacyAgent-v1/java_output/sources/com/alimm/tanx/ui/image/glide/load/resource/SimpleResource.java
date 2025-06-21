package com.alimm.tanx.ui.image.glide.load.resource;

/* loaded from: classes.dex */
public class SimpleResource<T> implements com.alimm.tanx.ui.image.glide.load.engine.Resource<T> {
    protected final T data;

    public SimpleResource(T t) {
        if (t == null) {
            throw new java.lang.NullPointerException("Data must not be null");
        }
        this.data = t;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public final T get() {
        return this.data;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public final int getSize() {
        return 1;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
    }
}
