package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: classes.dex */
public class Engine implements com.alimm.tanx.ui.image.glide.load.engine.EngineJobListener, com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache.ResourceRemovedListener, com.alimm.tanx.ui.image.glide.load.engine.EngineResource.ResourceListener {
    private static final java.lang.String TAG = "Engine";
    private final java.util.Map<com.alimm.tanx.ui.image.glide.load.Key, java.lang.ref.WeakReference<com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?>>> activeResources;
    private final com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache cache;
    private final com.alimm.tanx.ui.image.glide.load.engine.Engine.LazyDiskCacheProvider diskCacheProvider;
    private final com.alimm.tanx.ui.image.glide.load.engine.Engine.EngineJobFactory engineJobFactory;
    private final java.util.Map<com.alimm.tanx.ui.image.glide.load.Key, com.alimm.tanx.ui.image.glide.load.engine.EngineJob> jobs;
    private final com.alimm.tanx.ui.image.glide.load.engine.EngineKeyFactory keyFactory;
    private final com.alimm.tanx.ui.image.glide.load.engine.ResourceRecycler resourceRecycler;
    private java.lang.ref.ReferenceQueue<com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?>> resourceReferenceQueue;

    public static class EngineJobFactory {
        private final java.util.concurrent.ExecutorService diskCacheService;
        private final com.alimm.tanx.ui.image.glide.load.engine.EngineJobListener listener;
        private final java.util.concurrent.ExecutorService sourceService;

        public EngineJobFactory(java.util.concurrent.ExecutorService executorService, java.util.concurrent.ExecutorService executorService2, com.alimm.tanx.ui.image.glide.load.engine.EngineJobListener engineJobListener) {
            this.diskCacheService = executorService;
            this.sourceService = executorService2;
            this.listener = engineJobListener;
        }

        public com.alimm.tanx.ui.image.glide.load.engine.EngineJob build(com.alimm.tanx.ui.image.glide.load.Key key, boolean z) {
            return new com.alimm.tanx.ui.image.glide.load.engine.EngineJob(key, this.diskCacheService, this.sourceService, z, this.listener);
        }
    }

    public static class LazyDiskCacheProvider implements com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.DiskCacheProvider {
        private volatile com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache diskCache;
        private final com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory factory;

        public LazyDiskCacheProvider(com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory factory) {
            this.factory = factory;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.DiskCacheProvider
        public com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache getDiskCache() {
            if (this.diskCache == null) {
                synchronized (this) {
                    if (this.diskCache == null) {
                        this.diskCache = this.factory.build();
                    }
                    if (this.diskCache == null) {
                        this.diskCache = new com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheAdapter();
                    }
                }
            }
            return this.diskCache;
        }
    }

    public static class LoadStatus {
        private final com.alimm.tanx.ui.image.glide.request.ResourceCallback cb;
        private final com.alimm.tanx.ui.image.glide.load.engine.EngineJob engineJob;

        public LoadStatus(com.alimm.tanx.ui.image.glide.request.ResourceCallback resourceCallback, com.alimm.tanx.ui.image.glide.load.engine.EngineJob engineJob) {
            this.cb = resourceCallback;
            this.engineJob = engineJob;
        }

        public void cancel() {
            this.engineJob.removeCallback(this.cb);
        }
    }

    public static class RefQueueIdleHandler implements android.os.MessageQueue.IdleHandler {
        private final java.util.Map<com.alimm.tanx.ui.image.glide.load.Key, java.lang.ref.WeakReference<com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?>>> activeResources;
        private final java.lang.ref.ReferenceQueue<com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?>> queue;

        public RefQueueIdleHandler(java.util.Map<com.alimm.tanx.ui.image.glide.load.Key, java.lang.ref.WeakReference<com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?>>> map, java.lang.ref.ReferenceQueue<com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?>> referenceQueue) {
            this.activeResources = map;
            this.queue = referenceQueue;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            com.alimm.tanx.ui.image.glide.load.engine.Engine.ResourceWeakReference resourceWeakReference = (com.alimm.tanx.ui.image.glide.load.engine.Engine.ResourceWeakReference) this.queue.poll();
            if (resourceWeakReference == null) {
                return true;
            }
            this.activeResources.remove(resourceWeakReference.key);
            return true;
        }
    }

    public static class ResourceWeakReference extends java.lang.ref.WeakReference<com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?>> {
        private final com.alimm.tanx.ui.image.glide.load.Key key;

        public ResourceWeakReference(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> engineResource, java.lang.ref.ReferenceQueue<? super com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?>> referenceQueue) {
            super(engineResource, referenceQueue);
            this.key = key;
        }
    }

    public Engine(com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache memoryCache, com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory factory, java.util.concurrent.ExecutorService executorService, java.util.concurrent.ExecutorService executorService2) {
        this(memoryCache, factory, executorService, executorService2, null, null, null, null, null);
    }

    public Engine(com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache memoryCache, com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory factory, java.util.concurrent.ExecutorService executorService, java.util.concurrent.ExecutorService executorService2, java.util.Map<com.alimm.tanx.ui.image.glide.load.Key, com.alimm.tanx.ui.image.glide.load.engine.EngineJob> map, com.alimm.tanx.ui.image.glide.load.engine.EngineKeyFactory engineKeyFactory, java.util.Map<com.alimm.tanx.ui.image.glide.load.Key, java.lang.ref.WeakReference<com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?>>> map2, com.alimm.tanx.ui.image.glide.load.engine.Engine.EngineJobFactory engineJobFactory, com.alimm.tanx.ui.image.glide.load.engine.ResourceRecycler resourceRecycler) {
        this.cache = memoryCache;
        this.diskCacheProvider = new com.alimm.tanx.ui.image.glide.load.engine.Engine.LazyDiskCacheProvider(factory);
        this.activeResources = map2 == null ? new java.util.HashMap<>() : map2;
        this.keyFactory = engineKeyFactory == null ? new com.alimm.tanx.ui.image.glide.load.engine.EngineKeyFactory() : engineKeyFactory;
        this.jobs = map == null ? new java.util.HashMap<>() : map;
        this.engineJobFactory = engineJobFactory == null ? new com.alimm.tanx.ui.image.glide.load.engine.Engine.EngineJobFactory(executorService, executorService2, this) : engineJobFactory;
        this.resourceRecycler = resourceRecycler == null ? new com.alimm.tanx.ui.image.glide.load.engine.ResourceRecycler() : resourceRecycler;
        memoryCache.setResourceRemovedListener(this);
    }

    private com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> getEngineResourceFromCache(com.alimm.tanx.ui.image.glide.load.Key key) {
        com.alimm.tanx.ui.image.glide.load.engine.Resource<?> remove = this.cache.remove(key);
        if (remove == null) {
            return null;
        }
        return remove instanceof com.alimm.tanx.ui.image.glide.load.engine.EngineResource ? (com.alimm.tanx.ui.image.glide.load.engine.EngineResource) remove : new com.alimm.tanx.ui.image.glide.load.engine.EngineResource<>(remove, true);
    }

    private java.lang.ref.ReferenceQueue<com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?>> getReferenceQueue() {
        if (this.resourceReferenceQueue == null) {
            this.resourceReferenceQueue = new java.lang.ref.ReferenceQueue<>();
            android.os.Looper.myQueue().addIdleHandler(new com.alimm.tanx.ui.image.glide.load.engine.Engine.RefQueueIdleHandler(this.activeResources, this.resourceReferenceQueue));
        }
        return this.resourceReferenceQueue;
    }

    private com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> loadFromActiveResources(com.alimm.tanx.ui.image.glide.load.Key key, boolean z) {
        com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> engineResource = null;
        if (!z) {
            return null;
        }
        java.lang.ref.WeakReference<com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?>> weakReference = this.activeResources.get(key);
        if (weakReference != null) {
            engineResource = weakReference.get();
            if (engineResource != null) {
                engineResource.acquire();
            } else {
                this.activeResources.remove(key);
            }
        }
        return engineResource;
    }

    private com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> loadFromCache(com.alimm.tanx.ui.image.glide.load.Key key, boolean z) {
        if (!z) {
            return null;
        }
        com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> engineResourceFromCache = getEngineResourceFromCache(key);
        if (engineResourceFromCache != null) {
            engineResourceFromCache.acquire();
            this.activeResources.put(key, new com.alimm.tanx.ui.image.glide.load.engine.Engine.ResourceWeakReference(key, engineResourceFromCache, getReferenceQueue()));
        }
        return engineResourceFromCache;
    }

    private static void logWithTimeAndKey(java.lang.String str, long j, com.alimm.tanx.ui.image.glide.load.Key key) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.alimm.tanx.ui.image.glide.util.LogTime.getElapsedMillis(j));
        sb.append("ms, key: ");
        sb.append(key);
    }

    public void clearDiskCache() {
        this.diskCacheProvider.getDiskCache().clear();
    }

    public <T, Z, R> com.alimm.tanx.ui.image.glide.load.engine.Engine.LoadStatus load(com.alimm.tanx.ui.image.glide.load.Key key, int i, int i2, com.alimm.tanx.ui.image.glide.load.data.DataFetcher<T> dataFetcher, com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<T, Z> dataLoadProvider, com.alimm.tanx.ui.image.glide.load.Transformation<Z> transformation, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> resourceTranscoder, com.alimm.tanx.ui.image.glide.Priority priority, boolean z, com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy diskCacheStrategy, com.alimm.tanx.ui.image.glide.request.ResourceCallback resourceCallback) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        long logTime = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        com.alimm.tanx.ui.image.glide.load.engine.EngineKey buildKey = this.keyFactory.buildKey(dataFetcher.getId(), key, i, i2, dataLoadProvider.getCacheDecoder(), dataLoadProvider.getSourceDecoder(), transformation, dataLoadProvider.getEncoder(), resourceTranscoder, dataLoadProvider.getSourceEncoder());
        com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> loadFromCache = loadFromCache(buildKey, z);
        if (loadFromCache != null) {
            resourceCallback.onResourceReady(loadFromCache);
            if (android.util.Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Loaded resource from cache", logTime, buildKey);
            }
            return null;
        }
        com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> loadFromActiveResources = loadFromActiveResources(buildKey, z);
        if (loadFromActiveResources != null) {
            resourceCallback.onResourceReady(loadFromActiveResources);
            if (android.util.Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Loaded resource from active resources", logTime, buildKey);
            }
            return null;
        }
        com.alimm.tanx.ui.image.glide.load.engine.EngineJob engineJob = this.jobs.get(buildKey);
        if (engineJob != null) {
            engineJob.addCallback(resourceCallback);
            if (android.util.Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Added to existing load", logTime, buildKey);
            }
            return new com.alimm.tanx.ui.image.glide.load.engine.Engine.LoadStatus(resourceCallback, engineJob);
        }
        com.alimm.tanx.ui.image.glide.load.engine.EngineJob build = this.engineJobFactory.build(buildKey, z);
        com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable engineRunnable = new com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable(build, new com.alimm.tanx.ui.image.glide.load.engine.DecodeJob(buildKey, i, i2, dataFetcher, dataLoadProvider, transformation, resourceTranscoder, this.diskCacheProvider, diskCacheStrategy, priority), priority);
        this.jobs.put(buildKey, build);
        build.addCallback(resourceCallback);
        build.start(engineRunnable);
        if (android.util.Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Started new load", logTime, buildKey);
        }
        return new com.alimm.tanx.ui.image.glide.load.engine.Engine.LoadStatus(resourceCallback, build);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.EngineJobListener
    public void onEngineJobCancelled(com.alimm.tanx.ui.image.glide.load.engine.EngineJob engineJob, com.alimm.tanx.ui.image.glide.load.Key key) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        if (engineJob.equals(this.jobs.get(key))) {
            this.jobs.remove(key);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.EngineJobListener
    public void onEngineJobComplete(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> engineResource) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        if (engineResource != null) {
            engineResource.setResourceListener(key, this);
            if (engineResource.isCacheable()) {
                this.activeResources.put(key, new com.alimm.tanx.ui.image.glide.load.engine.Engine.ResourceWeakReference(key, engineResource, getReferenceQueue()));
            }
        }
        this.jobs.remove(key);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.EngineResource.ResourceListener
    public void onResourceReleased(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.engine.EngineResource engineResource) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        this.activeResources.remove(key);
        if (engineResource.isCacheable()) {
            this.cache.put(key, engineResource);
        } else {
            this.resourceRecycler.recycle(engineResource);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void onResourceRemoved(com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        this.resourceRecycler.recycle(resource);
    }

    public void release(com.alimm.tanx.ui.image.glide.load.engine.Resource resource) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        if (!(resource instanceof com.alimm.tanx.ui.image.glide.load.engine.EngineResource)) {
            throw new java.lang.IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((com.alimm.tanx.ui.image.glide.load.engine.EngineResource) resource).release();
    }
}
