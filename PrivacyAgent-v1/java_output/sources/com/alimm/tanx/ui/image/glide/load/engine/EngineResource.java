package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: classes.dex */
class EngineResource<Z> implements com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> {
    private int acquired;
    private final boolean isCacheable;
    private boolean isRecycled;
    private com.alimm.tanx.ui.image.glide.load.Key key;
    private com.alimm.tanx.ui.image.glide.load.engine.EngineResource.ResourceListener listener;
    private final com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> resource;

    public interface ResourceListener {
        void onResourceReleased(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> engineResource);
    }

    public EngineResource(com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> resource, boolean z) {
        if (resource == null) {
            throw new java.lang.NullPointerException("Wrapped resource must not be null");
        }
        this.resource = resource;
        this.isCacheable = z;
    }

    public void acquire() {
        if (this.isRecycled) {
            throw new java.lang.IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!android.os.Looper.getMainLooper().equals(android.os.Looper.myLooper())) {
            throw new java.lang.IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.acquired++;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public Z get() {
        return this.resource.get();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return this.resource.getSize();
    }

    public boolean isCacheable() {
        return this.isCacheable;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
        if (this.acquired > 0) {
            throw new java.lang.IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.isRecycled) {
            throw new java.lang.IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.isRecycled = true;
        this.resource.recycle();
    }

    public void release() {
        if (this.acquired <= 0) {
            throw new java.lang.IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!android.os.Looper.getMainLooper().equals(android.os.Looper.myLooper())) {
            throw new java.lang.IllegalThreadStateException("Must call release on the main thread");
        }
        int i = this.acquired - 1;
        this.acquired = i;
        if (i == 0) {
            this.listener.onResourceReleased(this.key, this);
        }
    }

    public void setResourceListener(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.engine.EngineResource.ResourceListener resourceListener) {
        this.key = key;
        this.listener = resourceListener;
    }
}
