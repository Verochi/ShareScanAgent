package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
final class ActiveResources {

    @androidx.annotation.VisibleForTesting
    final java.util.Map<com.bumptech.glide.load.Key, com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference> activeEngineResources;

    @androidx.annotation.Nullable
    private volatile com.bumptech.glide.load.engine.ActiveResources.DequeuedResourceCallback cb;
    private final boolean isActiveResourceRetentionAllowed;
    private volatile boolean isShutdown;
    private com.bumptech.glide.load.engine.EngineResource.ResourceListener listener;
    private final java.util.concurrent.Executor monitorClearedResourcesExecutor;
    private final java.lang.ref.ReferenceQueue<com.bumptech.glide.load.engine.EngineResource<?>> resourceReferenceQueue;

    /* renamed from: com.bumptech.glide.load.engine.ActiveResources$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {

        /* renamed from: com.bumptech.glide.load.engine.ActiveResources$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC02521 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Runnable val$r;

            public RunnableC02521(java.lang.Runnable runnable) {
                this.val$r = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.os.Process.setThreadPriority(10);
                this.val$r.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            return new java.lang.Thread(new com.bumptech.glide.load.engine.ActiveResources.AnonymousClass1.RunnableC02521(runnable), "glide-active-resources");
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.ActiveResources$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bumptech.glide.load.engine.ActiveResources.this.cleanReferenceQueue();
        }
    }

    @androidx.annotation.VisibleForTesting
    public interface DequeuedResourceCallback {
        void onResourceDequeued();
    }

    @androidx.annotation.VisibleForTesting
    public static final class ResourceWeakReference extends java.lang.ref.WeakReference<com.bumptech.glide.load.engine.EngineResource<?>> {
        final boolean isCacheable;
        final com.bumptech.glide.load.Key key;

        @androidx.annotation.Nullable
        com.bumptech.glide.load.engine.Resource<?> resource;

        public ResourceWeakReference(@androidx.annotation.NonNull com.bumptech.glide.load.Key key, @androidx.annotation.NonNull com.bumptech.glide.load.engine.EngineResource<?> engineResource, @androidx.annotation.NonNull java.lang.ref.ReferenceQueue<? super com.bumptech.glide.load.engine.EngineResource<?>> referenceQueue, boolean z) {
            super(engineResource, referenceQueue);
            this.key = (com.bumptech.glide.load.Key) com.bumptech.glide.util.Preconditions.checkNotNull(key);
            this.resource = (engineResource.isMemoryCacheable() && z) ? (com.bumptech.glide.load.engine.Resource) com.bumptech.glide.util.Preconditions.checkNotNull(engineResource.getResource()) : null;
            this.isCacheable = engineResource.isMemoryCacheable();
        }

        public void reset() {
            this.resource = null;
            clear();
        }
    }

    public ActiveResources(boolean z) {
        this(z, java.util.concurrent.Executors.newSingleThreadExecutor(new com.bumptech.glide.load.engine.ActiveResources.AnonymousClass1()));
    }

    @androidx.annotation.VisibleForTesting
    public ActiveResources(boolean z, java.util.concurrent.Executor executor) {
        this.activeEngineResources = new java.util.HashMap();
        this.resourceReferenceQueue = new java.lang.ref.ReferenceQueue<>();
        this.isActiveResourceRetentionAllowed = z;
        this.monitorClearedResourcesExecutor = executor;
        executor.execute(new com.bumptech.glide.load.engine.ActiveResources.AnonymousClass2());
    }

    public synchronized void activate(com.bumptech.glide.load.Key key, com.bumptech.glide.load.engine.EngineResource<?> engineResource) {
        com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference put = this.activeEngineResources.put(key, new com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference(key, engineResource, this.resourceReferenceQueue, this.isActiveResourceRetentionAllowed));
        if (put != null) {
            put.reset();
        }
    }

    public void cleanReferenceQueue() {
        while (!this.isShutdown) {
            try {
                cleanupActiveReference((com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference) this.resourceReferenceQueue.remove());
                com.bumptech.glide.load.engine.ActiveResources.DequeuedResourceCallback dequeuedResourceCallback = this.cb;
                if (dequeuedResourceCallback != null) {
                    dequeuedResourceCallback.onResourceDequeued();
                }
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
            }
        }
    }

    public void cleanupActiveReference(@androidx.annotation.NonNull com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference resourceWeakReference) {
        com.bumptech.glide.load.engine.Resource<?> resource;
        synchronized (this) {
            this.activeEngineResources.remove(resourceWeakReference.key);
            if (resourceWeakReference.isCacheable && (resource = resourceWeakReference.resource) != null) {
                this.listener.onResourceReleased(resourceWeakReference.key, new com.bumptech.glide.load.engine.EngineResource<>(resource, true, false, resourceWeakReference.key, this.listener));
            }
        }
    }

    public synchronized void deactivate(com.bumptech.glide.load.Key key) {
        com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference remove = this.activeEngineResources.remove(key);
        if (remove != null) {
            remove.reset();
        }
    }

    @androidx.annotation.Nullable
    public synchronized com.bumptech.glide.load.engine.EngineResource<?> get(com.bumptech.glide.load.Key key) {
        com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference resourceWeakReference = this.activeEngineResources.get(key);
        if (resourceWeakReference == null) {
            return null;
        }
        com.bumptech.glide.load.engine.EngineResource<?> engineResource = resourceWeakReference.get();
        if (engineResource == null) {
            cleanupActiveReference(resourceWeakReference);
        }
        return engineResource;
    }

    @androidx.annotation.VisibleForTesting
    public void setDequeuedResourceCallback(com.bumptech.glide.load.engine.ActiveResources.DequeuedResourceCallback dequeuedResourceCallback) {
        this.cb = dequeuedResourceCallback;
    }

    public void setListener(com.bumptech.glide.load.engine.EngineResource.ResourceListener resourceListener) {
        synchronized (resourceListener) {
            synchronized (this) {
                this.listener = resourceListener;
            }
        }
    }

    @androidx.annotation.VisibleForTesting
    public void shutdown() {
        this.isShutdown = true;
        java.util.concurrent.Executor executor = this.monitorClearedResourcesExecutor;
        if (executor instanceof java.util.concurrent.ExecutorService) {
            com.bumptech.glide.util.Executors.shutdownAndAwaitTermination((java.util.concurrent.ExecutorService) executor);
        }
    }
}
