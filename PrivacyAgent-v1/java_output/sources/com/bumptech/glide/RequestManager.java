package com.bumptech.glide;

/* loaded from: classes.dex */
public class RequestManager implements android.content.ComponentCallbacks2, com.bumptech.glide.manager.LifecycleListener, com.bumptech.glide.ModelTypes<com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable>> {
    private static final com.bumptech.glide.request.RequestOptions DECODE_TYPE_BITMAP = com.bumptech.glide.request.RequestOptions.decodeTypeOf(android.graphics.Bitmap.class).lock();
    private static final com.bumptech.glide.request.RequestOptions DECODE_TYPE_GIF = com.bumptech.glide.request.RequestOptions.decodeTypeOf(com.bumptech.glide.load.resource.gif.GifDrawable.class).lock();
    private static final com.bumptech.glide.request.RequestOptions DOWNLOAD_ONLY_OPTIONS = com.bumptech.glide.request.RequestOptions.diskCacheStrategyOf(com.bumptech.glide.load.engine.DiskCacheStrategy.DATA).priority(com.bumptech.glide.Priority.LOW).skipMemoryCache(true);
    private final java.lang.Runnable addSelfToLifecycle;
    private final com.bumptech.glide.manager.ConnectivityMonitor connectivityMonitor;
    protected final android.content.Context context;
    private final java.util.concurrent.CopyOnWriteArrayList<com.bumptech.glide.request.RequestListener<java.lang.Object>> defaultRequestListeners;
    protected final com.bumptech.glide.Glide glide;
    final com.bumptech.glide.manager.Lifecycle lifecycle;
    private final android.os.Handler mainHandler;
    private boolean pauseAllRequestsOnTrimMemoryModerate;

    @androidx.annotation.GuardedBy("this")
    private com.bumptech.glide.request.RequestOptions requestOptions;

    @androidx.annotation.GuardedBy("this")
    private final com.bumptech.glide.manager.RequestTracker requestTracker;

    @androidx.annotation.GuardedBy("this")
    private final com.bumptech.glide.manager.TargetTracker targetTracker;

    @androidx.annotation.GuardedBy("this")
    private final com.bumptech.glide.manager.RequestManagerTreeNode treeNode;

    /* renamed from: com.bumptech.glide.RequestManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bumptech.glide.RequestManager requestManager = com.bumptech.glide.RequestManager.this;
            requestManager.lifecycle.addListener(requestManager);
        }
    }

    public static class ClearTarget extends com.bumptech.glide.request.target.CustomViewTarget<android.view.View, java.lang.Object> {
        public ClearTarget(@androidx.annotation.NonNull android.view.View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable com.bumptech.glide.request.transition.Transition<? super java.lang.Object> transition) {
        }
    }

    public class RequestManagerConnectivityListener implements com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener {

        @androidx.annotation.GuardedBy("RequestManager.this")
        private final com.bumptech.glide.manager.RequestTracker requestTracker;

        public RequestManagerConnectivityListener(@androidx.annotation.NonNull com.bumptech.glide.manager.RequestTracker requestTracker) {
            this.requestTracker = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z) {
            if (z) {
                synchronized (com.bumptech.glide.RequestManager.this) {
                    this.requestTracker.restartRequests();
                }
            }
        }
    }

    public RequestManager(@androidx.annotation.NonNull com.bumptech.glide.Glide glide, @androidx.annotation.NonNull com.bumptech.glide.manager.Lifecycle lifecycle, @androidx.annotation.NonNull com.bumptech.glide.manager.RequestManagerTreeNode requestManagerTreeNode, @androidx.annotation.NonNull android.content.Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new com.bumptech.glide.manager.RequestTracker(), glide.getConnectivityMonitorFactory(), context);
    }

    public RequestManager(com.bumptech.glide.Glide glide, com.bumptech.glide.manager.Lifecycle lifecycle, com.bumptech.glide.manager.RequestManagerTreeNode requestManagerTreeNode, com.bumptech.glide.manager.RequestTracker requestTracker, com.bumptech.glide.manager.ConnectivityMonitorFactory connectivityMonitorFactory, android.content.Context context) {
        this.targetTracker = new com.bumptech.glide.manager.TargetTracker();
        com.bumptech.glide.RequestManager.AnonymousClass1 anonymousClass1 = new com.bumptech.glide.RequestManager.AnonymousClass1();
        this.addSelfToLifecycle = anonymousClass1;
        android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
        this.mainHandler = handler;
        this.glide = glide;
        this.lifecycle = lifecycle;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker;
        this.context = context;
        com.bumptech.glide.manager.ConnectivityMonitor build = connectivityMonitorFactory.build(context.getApplicationContext(), new com.bumptech.glide.RequestManager.RequestManagerConnectivityListener(requestTracker));
        this.connectivityMonitor = build;
        if (com.bumptech.glide.util.Util.isOnBackgroundThread()) {
            handler.post(anonymousClass1);
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(build);
        this.defaultRequestListeners = new java.util.concurrent.CopyOnWriteArrayList<>(glide.getGlideContext().getDefaultRequestListeners());
        setRequestOptions(glide.getGlideContext().getDefaultRequestOptions());
        glide.registerRequestManager(this);
    }

    private void untrackOrDelegate(@androidx.annotation.NonNull com.bumptech.glide.request.target.Target<?> target) {
        boolean untrack = untrack(target);
        com.bumptech.glide.request.Request request = target.getRequest();
        if (untrack || this.glide.removeFromManagers(target) || request == null) {
            return;
        }
        target.setRequest(null);
        request.clear();
    }

    private synchronized void updateRequestOptions(@androidx.annotation.NonNull com.bumptech.glide.request.RequestOptions requestOptions) {
        this.requestOptions = this.requestOptions.apply(requestOptions);
    }

    public com.bumptech.glide.RequestManager addDefaultRequestListener(com.bumptech.glide.request.RequestListener<java.lang.Object> requestListener) {
        this.defaultRequestListeners.add(requestListener);
        return this;
    }

    @androidx.annotation.NonNull
    public synchronized com.bumptech.glide.RequestManager applyDefaultRequestOptions(@androidx.annotation.NonNull com.bumptech.glide.request.RequestOptions requestOptions) {
        updateRequestOptions(requestOptions);
        return this;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public <ResourceType> com.bumptech.glide.RequestBuilder<ResourceType> as(@androidx.annotation.NonNull java.lang.Class<ResourceType> cls) {
        return new com.bumptech.glide.RequestBuilder<>(this.glide, this, cls, this.context);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<android.graphics.Bitmap> asBitmap() {
        return as(android.graphics.Bitmap.class).apply((com.bumptech.glide.request.BaseRequestOptions<?>) DECODE_TYPE_BITMAP);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> asDrawable() {
        return as(android.graphics.drawable.Drawable.class);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<java.io.File> asFile() {
        return as(java.io.File.class).apply((com.bumptech.glide.request.BaseRequestOptions<?>) com.bumptech.glide.request.RequestOptions.skipMemoryCacheOf(true));
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<com.bumptech.glide.load.resource.gif.GifDrawable> asGif() {
        return as(com.bumptech.glide.load.resource.gif.GifDrawable.class).apply((com.bumptech.glide.request.BaseRequestOptions<?>) DECODE_TYPE_GIF);
    }

    public void clear(@androidx.annotation.NonNull android.view.View view) {
        clear(new com.bumptech.glide.RequestManager.ClearTarget(view));
    }

    public void clear(@androidx.annotation.Nullable com.bumptech.glide.request.target.Target<?> target) {
        if (target == null) {
            return;
        }
        untrackOrDelegate(target);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<java.io.File> download(@androidx.annotation.Nullable java.lang.Object obj) {
        return downloadOnly().load(obj);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<java.io.File> downloadOnly() {
        return as(java.io.File.class).apply((com.bumptech.glide.request.BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    public java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public synchronized com.bumptech.glide.request.RequestOptions getDefaultRequestOptions() {
        return this.requestOptions;
    }

    @androidx.annotation.NonNull
    public <T> com.bumptech.glide.TransitionOptions<?, T> getDefaultTransitionOptions(java.lang.Class<T> cls) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(cls);
    }

    public synchronized boolean isPaused() {
        return this.requestTracker.isPaused();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(@androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        return asDrawable().load(bitmap);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        return asDrawable().load(drawable);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(@androidx.annotation.Nullable android.net.Uri uri) {
        return asDrawable().load(uri);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(@androidx.annotation.Nullable java.io.File file) {
        return asDrawable().load(file);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(@androidx.annotation.Nullable @androidx.annotation.DrawableRes @androidx.annotation.RawRes java.lang.Integer num) {
        return asDrawable().load(num);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(@androidx.annotation.Nullable java.lang.Object obj) {
        return asDrawable().load(obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(@androidx.annotation.Nullable java.lang.String str) {
        return asDrawable().load(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.CheckResult
    @java.lang.Deprecated
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(@androidx.annotation.Nullable java.net.URL url) {
        return asDrawable().load(url);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(@androidx.annotation.Nullable byte[] bArr) {
        return asDrawable().load(bArr);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onDestroy() {
        this.targetTracker.onDestroy();
        java.util.Iterator<com.bumptech.glide.request.target.Target<?>> it = this.targetTracker.getAll().iterator();
        while (it.hasNext()) {
            clear(it.next());
        }
        this.targetTracker.clear();
        this.requestTracker.clearRequests();
        this.lifecycle.removeListener(this);
        this.lifecycle.removeListener(this.connectivityMonitor);
        this.mainHandler.removeCallbacks(this.addSelfToLifecycle);
        this.glide.unregisterRequestManager(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStart() {
        resumeRequests();
        this.targetTracker.onStart();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStop() {
        pauseRequests();
        this.targetTracker.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.pauseAllRequestsOnTrimMemoryModerate) {
            pauseAllRequestsRecursive();
        }
    }

    public synchronized void pauseAllRequests() {
        this.requestTracker.pauseAllRequests();
    }

    public synchronized void pauseAllRequestsRecursive() {
        pauseAllRequests();
        java.util.Iterator<com.bumptech.glide.RequestManager> it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().pauseAllRequests();
        }
    }

    public synchronized void pauseRequests() {
        this.requestTracker.pauseRequests();
    }

    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        java.util.Iterator<com.bumptech.glide.RequestManager> it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().pauseRequests();
        }
    }

    public synchronized void resumeRequests() {
        this.requestTracker.resumeRequests();
    }

    public synchronized void resumeRequestsRecursive() {
        com.bumptech.glide.util.Util.assertMainThread();
        resumeRequests();
        java.util.Iterator<com.bumptech.glide.RequestManager> it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().resumeRequests();
        }
    }

    @androidx.annotation.NonNull
    public synchronized com.bumptech.glide.RequestManager setDefaultRequestOptions(@androidx.annotation.NonNull com.bumptech.glide.request.RequestOptions requestOptions) {
        setRequestOptions(requestOptions);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        this.pauseAllRequestsOnTrimMemoryModerate = z;
    }

    public synchronized void setRequestOptions(@androidx.annotation.NonNull com.bumptech.glide.request.RequestOptions requestOptions) {
        this.requestOptions = requestOptions.mo46clone().autoClone();
    }

    public synchronized java.lang.String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + com.alipay.sdk.m.u.i.d;
    }

    public synchronized void track(@androidx.annotation.NonNull com.bumptech.glide.request.target.Target<?> target, @androidx.annotation.NonNull com.bumptech.glide.request.Request request) {
        this.targetTracker.track(target);
        this.requestTracker.runRequest(request);
    }

    public synchronized boolean untrack(@androidx.annotation.NonNull com.bumptech.glide.request.target.Target<?> target) {
        com.bumptech.glide.request.Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.requestTracker.clearAndRemove(request)) {
            return false;
        }
        this.targetTracker.untrack(target);
        target.setRequest(null);
        return true;
    }
}
