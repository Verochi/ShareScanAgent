package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
class EngineResource<Z> implements com.bumptech.glide.load.engine.Resource<Z> {
    private int acquired;
    private final boolean isMemoryCacheable;
    private final boolean isRecyclable;
    private boolean isRecycled;
    private final com.bumptech.glide.load.Key key;
    private final com.bumptech.glide.load.engine.EngineResource.ResourceListener listener;
    private final com.bumptech.glide.load.engine.Resource<Z> resource;

    public interface ResourceListener {
        void onResourceReleased(com.bumptech.glide.load.Key key, com.bumptech.glide.load.engine.EngineResource<?> engineResource);
    }

    public EngineResource(com.bumptech.glide.load.engine.Resource<Z> resource, boolean z, boolean z2, com.bumptech.glide.load.Key key, com.bumptech.glide.load.engine.EngineResource.ResourceListener resourceListener) {
        this.resource = (com.bumptech.glide.load.engine.Resource) com.bumptech.glide.util.Preconditions.checkNotNull(resource);
        this.isMemoryCacheable = z;
        this.isRecyclable = z2;
        this.key = key;
        this.listener = (com.bumptech.glide.load.engine.EngineResource.ResourceListener) com.bumptech.glide.util.Preconditions.checkNotNull(resourceListener);
    }

    public synchronized void acquire() {
        if (this.isRecycled) {
            throw new java.lang.IllegalStateException("Cannot acquire a recycled resource");
        }
        this.acquired++;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public Z get() {
        return this.resource.get();
    }

    public com.bumptech.glide.load.engine.Resource<Z> getResource() {
        return this.resource;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public java.lang.Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.resource.getSize();
    }

    public boolean isMemoryCacheable() {
        return this.isMemoryCacheable;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        if (this.acquired > 0) {
            throw new java.lang.IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.isRecycled) {
            throw new java.lang.IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.isRecycled = true;
        if (this.isRecyclable) {
            this.resource.recycle();
        }
    }

    public void release() {
        boolean z;
        synchronized (this) {
            int i = this.acquired;
            if (i <= 0) {
                throw new java.lang.IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.acquired = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.listener.onResourceReleased(this.key, this);
        }
    }

    public synchronized java.lang.String toString() {
        return "EngineResource{isMemoryCacheable=" + this.isMemoryCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';
    }
}
