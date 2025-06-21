package com.alimm.tanx.ui.image.glide.request;

/* loaded from: classes.dex */
public class RequestFutureTarget<T, R> implements com.alimm.tanx.ui.image.glide.request.FutureTarget<R>, java.lang.Runnable {
    private static final com.alimm.tanx.ui.image.glide.request.RequestFutureTarget.Waiter DEFAULT_WAITER = new com.alimm.tanx.ui.image.glide.request.RequestFutureTarget.Waiter();
    private final boolean assertBackgroundThread;
    private java.lang.Exception exception;
    private boolean exceptionReceived;
    private final int height;
    private boolean isCancelled;
    private final android.os.Handler mainHandler;
    private com.alimm.tanx.ui.image.glide.request.Request request;
    private R resource;
    private boolean resultReceived;
    private final com.alimm.tanx.ui.image.glide.request.RequestFutureTarget.Waiter waiter;
    private final int width;

    public static class Waiter {
        public void notifyAll(java.lang.Object obj) {
            obj.notifyAll();
        }

        public void waitForTimeout(java.lang.Object obj, long j) throws java.lang.InterruptedException {
            obj.wait(j);
        }
    }

    public RequestFutureTarget(android.os.Handler handler, int i, int i2) {
        this(handler, i, i2, true, DEFAULT_WAITER);
    }

    public RequestFutureTarget(android.os.Handler handler, int i, int i2, boolean z, com.alimm.tanx.ui.image.glide.request.RequestFutureTarget.Waiter waiter) {
        this.mainHandler = handler;
        this.width = i;
        this.height = i2;
        this.assertBackgroundThread = z;
        this.waiter = waiter;
    }

    private synchronized R doGet(java.lang.Long l) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        if (this.assertBackgroundThread) {
            com.alimm.tanx.ui.image.glide.util.Util.assertBackgroundThread();
        }
        if (this.isCancelled) {
            throw new java.util.concurrent.CancellationException();
        }
        if (this.exceptionReceived) {
            throw new java.util.concurrent.ExecutionException(this.exception);
        }
        if (this.resultReceived) {
            return this.resource;
        }
        if (l == null) {
            this.waiter.waitForTimeout(this, 0L);
        } else if (l.longValue() > 0) {
            this.waiter.waitForTimeout(this, l.longValue());
        }
        if (java.lang.Thread.interrupted()) {
            throw new java.lang.InterruptedException();
        }
        if (this.exceptionReceived) {
            throw new java.util.concurrent.ExecutionException(this.exception);
        }
        if (this.isCancelled) {
            throw new java.util.concurrent.CancellationException();
        }
        if (!this.resultReceived) {
            throw new java.util.concurrent.TimeoutException();
        }
        return this.resource;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.isCancelled) {
            return true;
        }
        boolean z2 = !isDone();
        if (z2) {
            this.isCancelled = true;
            if (z) {
                clear();
            }
            this.waiter.notifyAll(this);
        }
        return z2;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.FutureTarget
    public void clear() {
        this.mainHandler.post(this);
    }

    @Override // java.util.concurrent.Future
    public R get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        try {
            return doGet(null);
        } catch (java.util.concurrent.TimeoutException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public R get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        return doGet(java.lang.Long.valueOf(timeUnit.toMillis(j)));
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public com.alimm.tanx.ui.image.glide.request.Request getRequest() {
        return this.request;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void getSize(com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.isCancelled) {
            z = this.resultReceived;
        }
        return z;
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadCleared(android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public synchronized void onLoadFailed(java.lang.Exception exc, android.graphics.drawable.Drawable drawable) {
        this.exceptionReceived = true;
        this.exception = exc;
        this.waiter.notifyAll(this);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadStarted(android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public synchronized void onResourceReady(R r, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super R> glideAnimation) {
        this.resultReceived = true;
        this.resource = r;
        this.waiter.notifyAll(this);
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alimm.tanx.ui.image.glide.request.Request request = this.request;
        if (request != null) {
            request.clear();
            cancel(false);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void setRequest(com.alimm.tanx.ui.image.glide.request.Request request) {
        this.request = request;
    }
}
