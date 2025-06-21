package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
class EngineJob<R> implements com.bumptech.glide.load.engine.DecodeJob.Callback<R>, com.bumptech.glide.util.pool.FactoryPools.Poolable {
    private static final com.bumptech.glide.load.engine.EngineJob.EngineResourceFactory DEFAULT_FACTORY = new com.bumptech.glide.load.engine.EngineJob.EngineResourceFactory();
    private final com.bumptech.glide.load.engine.executor.GlideExecutor animationExecutor;
    final com.bumptech.glide.load.engine.EngineJob.ResourceCallbacksAndExecutors cbs;
    com.bumptech.glide.load.DataSource dataSource;
    private com.bumptech.glide.load.engine.DecodeJob<R> decodeJob;
    private final com.bumptech.glide.load.engine.executor.GlideExecutor diskCacheExecutor;
    private final com.bumptech.glide.load.engine.EngineJobListener engineJobListener;
    com.bumptech.glide.load.engine.EngineResource<?> engineResource;
    private final com.bumptech.glide.load.engine.EngineJob.EngineResourceFactory engineResourceFactory;
    com.bumptech.glide.load.engine.GlideException exception;
    private boolean hasLoadFailed;
    private boolean hasResource;
    private boolean isCacheable;
    private volatile boolean isCancelled;
    private com.bumptech.glide.load.Key key;
    private boolean onlyRetrieveFromCache;
    private final java.util.concurrent.atomic.AtomicInteger pendingCallbacks;
    private final androidx.core.util.Pools.Pool<com.bumptech.glide.load.engine.EngineJob<?>> pool;
    private com.bumptech.glide.load.engine.Resource<?> resource;
    private final com.bumptech.glide.load.engine.EngineResource.ResourceListener resourceListener;
    private final com.bumptech.glide.load.engine.executor.GlideExecutor sourceExecutor;
    private final com.bumptech.glide.load.engine.executor.GlideExecutor sourceUnlimitedExecutor;
    private final com.bumptech.glide.util.pool.StateVerifier stateVerifier;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorPool;

    public class CallLoadFailed implements java.lang.Runnable {
        private final com.bumptech.glide.request.ResourceCallback cb;

        public CallLoadFailed(com.bumptech.glide.request.ResourceCallback resourceCallback) {
            this.cb = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.cb.getLock()) {
                synchronized (com.bumptech.glide.load.engine.EngineJob.this) {
                    if (com.bumptech.glide.load.engine.EngineJob.this.cbs.contains(this.cb)) {
                        com.bumptech.glide.load.engine.EngineJob.this.callCallbackOnLoadFailed(this.cb);
                    }
                    com.bumptech.glide.load.engine.EngineJob.this.decrementPendingCallbacks();
                }
            }
        }
    }

    public class CallResourceReady implements java.lang.Runnable {
        private final com.bumptech.glide.request.ResourceCallback cb;

        public CallResourceReady(com.bumptech.glide.request.ResourceCallback resourceCallback) {
            this.cb = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.cb.getLock()) {
                synchronized (com.bumptech.glide.load.engine.EngineJob.this) {
                    if (com.bumptech.glide.load.engine.EngineJob.this.cbs.contains(this.cb)) {
                        com.bumptech.glide.load.engine.EngineJob.this.engineResource.acquire();
                        com.bumptech.glide.load.engine.EngineJob.this.callCallbackOnResourceReady(this.cb);
                        com.bumptech.glide.load.engine.EngineJob.this.removeCallback(this.cb);
                    }
                    com.bumptech.glide.load.engine.EngineJob.this.decrementPendingCallbacks();
                }
            }
        }
    }

    @androidx.annotation.VisibleForTesting
    public static class EngineResourceFactory {
        public <R> com.bumptech.glide.load.engine.EngineResource<R> build(com.bumptech.glide.load.engine.Resource<R> resource, boolean z, com.bumptech.glide.load.Key key, com.bumptech.glide.load.engine.EngineResource.ResourceListener resourceListener) {
            return new com.bumptech.glide.load.engine.EngineResource<>(resource, z, true, key, resourceListener);
        }
    }

    public static final class ResourceCallbackAndExecutor {
        final com.bumptech.glide.request.ResourceCallback cb;
        final java.util.concurrent.Executor executor;

        public ResourceCallbackAndExecutor(com.bumptech.glide.request.ResourceCallback resourceCallback, java.util.concurrent.Executor executor) {
            this.cb = resourceCallback;
            this.executor = executor;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) {
                return this.cb.equals(((com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) obj).cb);
            }
            return false;
        }

        public int hashCode() {
            return this.cb.hashCode();
        }
    }

    public static final class ResourceCallbacksAndExecutors implements java.lang.Iterable<com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor> {
        private final java.util.List<com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor> callbacksAndExecutors;

        public ResourceCallbacksAndExecutors() {
            this(new java.util.ArrayList(2));
        }

        public ResourceCallbacksAndExecutors(java.util.List<com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor> list) {
            this.callbacksAndExecutors = list;
        }

        private static com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor defaultCallbackAndExecutor(com.bumptech.glide.request.ResourceCallback resourceCallback) {
            return new com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor(resourceCallback, com.bumptech.glide.util.Executors.directExecutor());
        }

        public void add(com.bumptech.glide.request.ResourceCallback resourceCallback, java.util.concurrent.Executor executor) {
            this.callbacksAndExecutors.add(new com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor(resourceCallback, executor));
        }

        public void clear() {
            this.callbacksAndExecutors.clear();
        }

        public boolean contains(com.bumptech.glide.request.ResourceCallback resourceCallback) {
            return this.callbacksAndExecutors.contains(defaultCallbackAndExecutor(resourceCallback));
        }

        public com.bumptech.glide.load.engine.EngineJob.ResourceCallbacksAndExecutors copy() {
            return new com.bumptech.glide.load.engine.EngineJob.ResourceCallbacksAndExecutors(new java.util.ArrayList(this.callbacksAndExecutors));
        }

        public boolean isEmpty() {
            return this.callbacksAndExecutors.isEmpty();
        }

        @Override // java.lang.Iterable
        @androidx.annotation.NonNull
        public java.util.Iterator<com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor> iterator() {
            return this.callbacksAndExecutors.iterator();
        }

        public void remove(com.bumptech.glide.request.ResourceCallback resourceCallback) {
            this.callbacksAndExecutors.remove(defaultCallbackAndExecutor(resourceCallback));
        }

        public int size() {
            return this.callbacksAndExecutors.size();
        }
    }

    public EngineJob(com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor2, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor3, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor4, com.bumptech.glide.load.engine.EngineJobListener engineJobListener, com.bumptech.glide.load.engine.EngineResource.ResourceListener resourceListener, androidx.core.util.Pools.Pool<com.bumptech.glide.load.engine.EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pool, DEFAULT_FACTORY);
    }

    @androidx.annotation.VisibleForTesting
    public EngineJob(com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor2, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor3, com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor4, com.bumptech.glide.load.engine.EngineJobListener engineJobListener, com.bumptech.glide.load.engine.EngineResource.ResourceListener resourceListener, androidx.core.util.Pools.Pool<com.bumptech.glide.load.engine.EngineJob<?>> pool, com.bumptech.glide.load.engine.EngineJob.EngineResourceFactory engineResourceFactory) {
        this.cbs = new com.bumptech.glide.load.engine.EngineJob.ResourceCallbacksAndExecutors();
        this.stateVerifier = com.bumptech.glide.util.pool.StateVerifier.newInstance();
        this.pendingCallbacks = new java.util.concurrent.atomic.AtomicInteger();
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.engineJobListener = engineJobListener;
        this.resourceListener = resourceListener;
        this.pool = pool;
        this.engineResourceFactory = engineResourceFactory;
    }

    private com.bumptech.glide.load.engine.executor.GlideExecutor getActiveSourceExecutor() {
        return this.useUnlimitedSourceGeneratorPool ? this.sourceUnlimitedExecutor : this.useAnimationPool ? this.animationExecutor : this.sourceExecutor;
    }

    private boolean isDone() {
        return this.hasLoadFailed || this.hasResource || this.isCancelled;
    }

    private synchronized void release() {
        if (this.key == null) {
            throw new java.lang.IllegalArgumentException();
        }
        this.cbs.clear();
        this.key = null;
        this.engineResource = null;
        this.resource = null;
        this.hasLoadFailed = false;
        this.isCancelled = false;
        this.hasResource = false;
        this.decodeJob.release(false);
        this.decodeJob = null;
        this.exception = null;
        this.dataSource = null;
        this.pool.release(this);
    }

    public synchronized void addCallback(com.bumptech.glide.request.ResourceCallback resourceCallback, java.util.concurrent.Executor executor) {
        this.stateVerifier.throwIfRecycled();
        this.cbs.add(resourceCallback, executor);
        boolean z = true;
        if (this.hasResource) {
            incrementPendingCallbacks(1);
            executor.execute(new com.bumptech.glide.load.engine.EngineJob.CallResourceReady(resourceCallback));
        } else if (this.hasLoadFailed) {
            incrementPendingCallbacks(1);
            executor.execute(new com.bumptech.glide.load.engine.EngineJob.CallLoadFailed(resourceCallback));
        } else {
            if (this.isCancelled) {
                z = false;
            }
            com.bumptech.glide.util.Preconditions.checkArgument(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    @androidx.annotation.GuardedBy("this")
    public void callCallbackOnLoadFailed(com.bumptech.glide.request.ResourceCallback resourceCallback) {
        try {
            resourceCallback.onLoadFailed(this.exception);
        } catch (java.lang.Throwable th) {
            throw new com.bumptech.glide.load.engine.CallbackException(th);
        }
    }

    @androidx.annotation.GuardedBy("this")
    public void callCallbackOnResourceReady(com.bumptech.glide.request.ResourceCallback resourceCallback) {
        try {
            resourceCallback.onResourceReady(this.engineResource, this.dataSource);
        } catch (java.lang.Throwable th) {
            throw new com.bumptech.glide.load.engine.CallbackException(th);
        }
    }

    public void cancel() {
        if (isDone()) {
            return;
        }
        this.isCancelled = true;
        this.decodeJob.cancel();
        this.engineJobListener.onEngineJobCancelled(this, this.key);
    }

    public void decrementPendingCallbacks() {
        com.bumptech.glide.load.engine.EngineResource<?> engineResource;
        synchronized (this) {
            this.stateVerifier.throwIfRecycled();
            com.bumptech.glide.util.Preconditions.checkArgument(isDone(), "Not yet complete!");
            int decrementAndGet = this.pendingCallbacks.decrementAndGet();
            com.bumptech.glide.util.Preconditions.checkArgument(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                engineResource = this.engineResource;
                release();
            } else {
                engineResource = null;
            }
        }
        if (engineResource != null) {
            engineResource.release();
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @androidx.annotation.NonNull
    public com.bumptech.glide.util.pool.StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public synchronized void incrementPendingCallbacks(int i) {
        com.bumptech.glide.load.engine.EngineResource<?> engineResource;
        com.bumptech.glide.util.Preconditions.checkArgument(isDone(), "Not yet complete!");
        if (this.pendingCallbacks.getAndAdd(i) == 0 && (engineResource = this.engineResource) != null) {
            engineResource.acquire();
        }
    }

    @androidx.annotation.VisibleForTesting
    public synchronized com.bumptech.glide.load.engine.EngineJob<R> init(com.bumptech.glide.load.Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        this.key = key;
        this.isCacheable = z;
        this.useUnlimitedSourceGeneratorPool = z2;
        this.useAnimationPool = z3;
        this.onlyRetrieveFromCache = z4;
        return this;
    }

    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    public void notifyCallbacksOfException() {
        synchronized (this) {
            this.stateVerifier.throwIfRecycled();
            if (this.isCancelled) {
                release();
                return;
            }
            if (this.cbs.isEmpty()) {
                throw new java.lang.IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.hasLoadFailed) {
                throw new java.lang.IllegalStateException("Already failed once");
            }
            this.hasLoadFailed = true;
            com.bumptech.glide.load.Key key = this.key;
            com.bumptech.glide.load.engine.EngineJob.ResourceCallbacksAndExecutors copy = this.cbs.copy();
            incrementPendingCallbacks(copy.size() + 1);
            this.engineJobListener.onEngineJobComplete(this, key, null);
            java.util.Iterator<com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor> it = copy.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor next = it.next();
                next.executor.execute(new com.bumptech.glide.load.engine.EngineJob.CallLoadFailed(next.cb));
            }
            decrementPendingCallbacks();
        }
    }

    public void notifyCallbacksOfResult() {
        synchronized (this) {
            this.stateVerifier.throwIfRecycled();
            if (this.isCancelled) {
                this.resource.recycle();
                release();
                return;
            }
            if (this.cbs.isEmpty()) {
                throw new java.lang.IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.hasResource) {
                throw new java.lang.IllegalStateException("Already have resource");
            }
            this.engineResource = this.engineResourceFactory.build(this.resource, this.isCacheable, this.key, this.resourceListener);
            this.hasResource = true;
            com.bumptech.glide.load.engine.EngineJob.ResourceCallbacksAndExecutors copy = this.cbs.copy();
            incrementPendingCallbacks(copy.size() + 1);
            this.engineJobListener.onEngineJobComplete(this, this.key, this.engineResource);
            java.util.Iterator<com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor> it = copy.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor next = it.next();
                next.executor.execute(new com.bumptech.glide.load.engine.EngineJob.CallResourceReady(next.cb));
            }
            decrementPendingCallbacks();
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onLoadFailed(com.bumptech.glide.load.engine.GlideException glideException) {
        synchronized (this) {
            this.exception = glideException;
        }
        notifyCallbacksOfException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onResourceReady(com.bumptech.glide.load.engine.Resource<R> resource, com.bumptech.glide.load.DataSource dataSource) {
        synchronized (this) {
            this.resource = resource;
            this.dataSource = dataSource;
        }
        notifyCallbacksOfResult();
    }

    public boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public synchronized void removeCallback(com.bumptech.glide.request.ResourceCallback resourceCallback) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        this.cbs.remove(resourceCallback);
        if (this.cbs.isEmpty()) {
            cancel();
            if (!this.hasResource && !this.hasLoadFailed) {
                z = false;
                if (z && this.pendingCallbacks.get() == 0) {
                    release();
                }
            }
            z = true;
            if (z) {
                release();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void reschedule(com.bumptech.glide.load.engine.DecodeJob<?> decodeJob) {
        getActiveSourceExecutor().execute(decodeJob);
    }

    public synchronized void start(com.bumptech.glide.load.engine.DecodeJob<R> decodeJob) {
        this.decodeJob = decodeJob;
        (decodeJob.willDecodeFromCache() ? this.diskCacheExecutor : getActiveSourceExecutor()).execute(decodeJob);
    }
}
