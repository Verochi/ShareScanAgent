package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
final class LockedResource<Z> implements com.bumptech.glide.load.engine.Resource<Z>, com.bumptech.glide.util.pool.FactoryPools.Poolable {
    private static final androidx.core.util.Pools.Pool<com.bumptech.glide.load.engine.LockedResource<?>> POOL = com.bumptech.glide.util.pool.FactoryPools.threadSafe(20, new com.bumptech.glide.load.engine.LockedResource.AnonymousClass1());
    private boolean isLocked;
    private boolean isRecycled;
    private final com.bumptech.glide.util.pool.StateVerifier stateVerifier = com.bumptech.glide.util.pool.StateVerifier.newInstance();
    private com.bumptech.glide.load.engine.Resource<Z> toWrap;

    /* renamed from: com.bumptech.glide.load.engine.LockedResource$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.util.pool.FactoryPools.Factory<com.bumptech.glide.load.engine.LockedResource<?>> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public com.bumptech.glide.load.engine.LockedResource<?> create() {
            return new com.bumptech.glide.load.engine.LockedResource<>();
        }
    }

    private void init(com.bumptech.glide.load.engine.Resource<Z> resource) {
        this.isRecycled = false;
        this.isLocked = true;
        this.toWrap = resource;
    }

    @androidx.annotation.NonNull
    public static <Z> com.bumptech.glide.load.engine.LockedResource<Z> obtain(com.bumptech.glide.load.engine.Resource<Z> resource) {
        com.bumptech.glide.load.engine.LockedResource<Z> lockedResource = (com.bumptech.glide.load.engine.LockedResource) com.bumptech.glide.util.Preconditions.checkNotNull(POOL.acquire());
        lockedResource.init(resource);
        return lockedResource;
    }

    private void release() {
        this.toWrap = null;
        POOL.release(this);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public Z get() {
        return this.toWrap.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public java.lang.Class<Z> getResourceClass() {
        return this.toWrap.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.toWrap.getSize();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @androidx.annotation.NonNull
    public com.bumptech.glide.util.pool.StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        this.stateVerifier.throwIfRecycled();
        this.isRecycled = true;
        if (!this.isLocked) {
            this.toWrap.recycle();
            release();
        }
    }

    public synchronized void unlock() {
        this.stateVerifier.throwIfRecycled();
        if (!this.isLocked) {
            throw new java.lang.IllegalStateException("Already unlocked");
        }
        this.isLocked = false;
        if (this.isRecycled) {
            recycle();
        }
    }
}
