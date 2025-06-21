package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: classes.dex */
class EngineJob implements com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable.EngineRunnableManager {
    private static final com.alimm.tanx.ui.image.glide.load.engine.EngineJob.EngineResourceFactory DEFAULT_FACTORY = new com.alimm.tanx.ui.image.glide.load.engine.EngineJob.EngineResourceFactory();
    private static final android.os.Handler MAIN_THREAD_HANDLER = new android.os.Handler(android.os.Looper.getMainLooper(), new com.alimm.tanx.ui.image.glide.load.engine.EngineJob.MainThreadCallback(null));
    private static final int MSG_COMPLETE = 1;
    private static final int MSG_EXCEPTION = 2;
    private final java.util.List<com.alimm.tanx.ui.image.glide.request.ResourceCallback> cbs;
    private final java.util.concurrent.ExecutorService diskCacheService;
    private com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> engineResource;
    private final com.alimm.tanx.ui.image.glide.load.engine.EngineJob.EngineResourceFactory engineResourceFactory;
    private com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable engineRunnable;
    private java.lang.Exception exception;
    private volatile java.util.concurrent.Future<?> future;
    private boolean hasException;
    private boolean hasResource;
    private java.util.Set<com.alimm.tanx.ui.image.glide.request.ResourceCallback> ignoredCallbacks;
    private final boolean isCacheable;
    private boolean isCancelled;
    private final com.alimm.tanx.ui.image.glide.load.Key key;
    private final com.alimm.tanx.ui.image.glide.load.engine.EngineJobListener listener;
    private com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource;
    private final java.util.concurrent.ExecutorService sourceService;

    public static class EngineResourceFactory {
        public <R> com.alimm.tanx.ui.image.glide.load.engine.EngineResource<R> build(com.alimm.tanx.ui.image.glide.load.engine.Resource<R> resource, boolean z) {
            return new com.alimm.tanx.ui.image.glide.load.engine.EngineResource<>(resource, z);
        }
    }

    public static class MainThreadCallback implements android.os.Handler.Callback {
        private MainThreadCallback() {
        }

        public /* synthetic */ MainThreadCallback(com.alimm.tanx.ui.image.glide.load.engine.EngineJob.AnonymousClass1 anonymousClass1) {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (1 != i && 2 != i) {
                return false;
            }
            com.alimm.tanx.ui.image.glide.load.engine.EngineJob engineJob = (com.alimm.tanx.ui.image.glide.load.engine.EngineJob) message.obj;
            if (1 == i) {
                engineJob.handleResultOnMainThread();
            } else {
                engineJob.handleExceptionOnMainThread();
            }
            return true;
        }
    }

    public EngineJob(com.alimm.tanx.ui.image.glide.load.Key key, java.util.concurrent.ExecutorService executorService, java.util.concurrent.ExecutorService executorService2, boolean z, com.alimm.tanx.ui.image.glide.load.engine.EngineJobListener engineJobListener) {
        this(key, executorService, executorService2, z, engineJobListener, DEFAULT_FACTORY);
    }

    public EngineJob(com.alimm.tanx.ui.image.glide.load.Key key, java.util.concurrent.ExecutorService executorService, java.util.concurrent.ExecutorService executorService2, boolean z, com.alimm.tanx.ui.image.glide.load.engine.EngineJobListener engineJobListener, com.alimm.tanx.ui.image.glide.load.engine.EngineJob.EngineResourceFactory engineResourceFactory) {
        this.cbs = new java.util.ArrayList();
        this.key = key;
        this.diskCacheService = executorService;
        this.sourceService = executorService2;
        this.isCacheable = z;
        this.listener = engineJobListener;
        this.engineResourceFactory = engineResourceFactory;
    }

    private void addIgnoredCallback(com.alimm.tanx.ui.image.glide.request.ResourceCallback resourceCallback) {
        if (this.ignoredCallbacks == null) {
            this.ignoredCallbacks = new java.util.HashSet();
        }
        this.ignoredCallbacks.add(resourceCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleExceptionOnMainThread() {
        if (this.isCancelled) {
            return;
        }
        if (this.cbs.isEmpty()) {
            throw new java.lang.IllegalStateException("Received an exception without any callbacks to notify");
        }
        this.hasException = true;
        this.listener.onEngineJobComplete(this.key, null);
        for (com.alimm.tanx.ui.image.glide.request.ResourceCallback resourceCallback : this.cbs) {
            if (!isInIgnoredCallbacks(resourceCallback)) {
                resourceCallback.onException(this.exception);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResultOnMainThread() {
        if (this.isCancelled) {
            this.resource.recycle();
            return;
        }
        if (this.cbs.isEmpty()) {
            throw new java.lang.IllegalStateException("Received a resource without any callbacks to notify");
        }
        com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> build = this.engineResourceFactory.build(this.resource, this.isCacheable);
        this.engineResource = build;
        this.hasResource = true;
        build.acquire();
        this.listener.onEngineJobComplete(this.key, this.engineResource);
        for (com.alimm.tanx.ui.image.glide.request.ResourceCallback resourceCallback : this.cbs) {
            if (!isInIgnoredCallbacks(resourceCallback)) {
                this.engineResource.acquire();
                resourceCallback.onResourceReady(this.engineResource);
            }
        }
        this.engineResource.release();
    }

    private boolean isInIgnoredCallbacks(com.alimm.tanx.ui.image.glide.request.ResourceCallback resourceCallback) {
        java.util.Set<com.alimm.tanx.ui.image.glide.request.ResourceCallback> set = this.ignoredCallbacks;
        return set != null && set.contains(resourceCallback);
    }

    public void addCallback(com.alimm.tanx.ui.image.glide.request.ResourceCallback resourceCallback) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        if (this.hasResource) {
            resourceCallback.onResourceReady(this.engineResource);
        } else if (this.hasException) {
            resourceCallback.onException(this.exception);
        } else {
            this.cbs.add(resourceCallback);
        }
    }

    public void cancel() {
        if (this.hasException || this.hasResource || this.isCancelled) {
            return;
        }
        this.engineRunnable.cancel();
        java.util.concurrent.Future<?> future = this.future;
        if (future != null) {
            future.cancel(true);
        }
        this.isCancelled = true;
        this.listener.onEngineJobCancelled(this, this.key);
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.ResourceCallback
    public void onException(java.lang.Exception exc) {
        this.exception = exc;
        MAIN_THREAD_HANDLER.obtainMessage(2, this).sendToTarget();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.ResourceCallback
    public void onResourceReady(com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource) {
        this.resource = resource;
        MAIN_THREAD_HANDLER.obtainMessage(1, this).sendToTarget();
    }

    public void removeCallback(com.alimm.tanx.ui.image.glide.request.ResourceCallback resourceCallback) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        if (this.hasResource || this.hasException) {
            addIgnoredCallback(resourceCallback);
            return;
        }
        this.cbs.remove(resourceCallback);
        if (this.cbs.isEmpty()) {
            cancel();
        }
    }

    public void start(com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable engineRunnable) {
        this.engineRunnable = engineRunnable;
        this.future = this.diskCacheService.submit(engineRunnable);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable.EngineRunnableManager
    public void submitForSource(com.alimm.tanx.ui.image.glide.load.engine.EngineRunnable engineRunnable) {
        this.future = this.sourceService.submit(engineRunnable);
    }
}
