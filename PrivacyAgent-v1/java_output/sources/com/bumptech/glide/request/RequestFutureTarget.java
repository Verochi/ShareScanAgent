package com.bumptech.glide.request;

/* loaded from: classes.dex */
public class RequestFutureTarget<R> implements com.bumptech.glide.request.FutureTarget<R>, com.bumptech.glide.request.RequestListener<R> {
    private static final com.bumptech.glide.request.RequestFutureTarget.Waiter DEFAULT_WAITER = new com.bumptech.glide.request.RequestFutureTarget.Waiter();
    private final boolean assertBackgroundThread;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("this")
    private com.bumptech.glide.load.engine.GlideException exception;
    private final int height;

    @androidx.annotation.GuardedBy("this")
    private boolean isCancelled;

    @androidx.annotation.GuardedBy("this")
    private boolean loadFailed;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("this")
    private com.bumptech.glide.request.Request request;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("this")
    private R resource;

    @androidx.annotation.GuardedBy("this")
    private boolean resultReceived;
    private final com.bumptech.glide.request.RequestFutureTarget.Waiter waiter;
    private final int width;

    @androidx.annotation.VisibleForTesting
    public static class Waiter {
        public void notifyAll(java.lang.Object obj) {
            obj.notifyAll();
        }

        public void waitForTimeout(java.lang.Object obj, long j) throws java.lang.InterruptedException {
            obj.wait(j);
        }
    }

    public RequestFutureTarget(int i, int i2) {
        this(i, i2, true, DEFAULT_WAITER);
    }

    public RequestFutureTarget(int i, int i2, boolean z, com.bumptech.glide.request.RequestFutureTarget.Waiter waiter) {
        this.width = i;
        this.height = i2;
        this.assertBackgroundThread = z;
        this.waiter = waiter;
    }

    private synchronized R doGet(java.lang.Long l) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        if (this.assertBackgroundThread && !isDone()) {
            com.bumptech.glide.util.Util.assertBackgroundThread();
        }
        if (this.isCancelled) {
            throw new java.util.concurrent.CancellationException();
        }
        if (this.loadFailed) {
            throw new java.util.concurrent.ExecutionException(this.exception);
        }
        if (this.resultReceived) {
            return this.resource;
        }
        if (l == null) {
            this.waiter.waitForTimeout(this, 0L);
        } else if (l.longValue() > 0) {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            long longValue = l.longValue() + currentTimeMillis;
            while (!isDone() && currentTimeMillis < longValue) {
                this.waiter.waitForTimeout(this, longValue - currentTimeMillis);
                currentTimeMillis = java.lang.System.currentTimeMillis();
            }
        }
        if (java.lang.Thread.interrupted()) {
            throw new java.lang.InterruptedException();
        }
        if (this.loadFailed) {
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
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.isCancelled = true;
            this.waiter.notifyAll(this);
            com.bumptech.glide.request.Request request = null;
            if (z) {
                com.bumptech.glide.request.Request request2 = this.request;
                this.request = null;
                request = request2;
            }
            if (request != null) {
                request.clear();
            }
            return true;
        }
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
    public R get(long j, @androidx.annotation.NonNull java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        return doGet(java.lang.Long.valueOf(timeUnit.toMillis(j)));
    }

    @Override // com.bumptech.glide.request.target.Target
    @androidx.annotation.Nullable
    public synchronized com.bumptech.glide.request.Request getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.isCancelled && !this.resultReceived) {
            z = this.loadFailed;
        }
        return z;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onLoadFailed(@androidx.annotation.Nullable com.bumptech.glide.load.engine.GlideException glideException, java.lang.Object obj, com.bumptech.glide.request.target.Target<R> target, boolean z) {
        this.loadFailed = true;
        this.exception = glideException;
        this.waiter.notifyAll(this);
        return false;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(@androidx.annotation.NonNull R r, @androidx.annotation.Nullable com.bumptech.glide.request.transition.Transition<? super R> transition) {
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onResourceReady(R r, java.lang.Object obj, com.bumptech.glide.request.target.Target<R> target, com.bumptech.glide.load.DataSource dataSource, boolean z) {
        this.resultReceived = true;
        this.resource = r;
        this.waiter.notifyAll(this);
        return false;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@androidx.annotation.NonNull com.bumptech.glide.request.target.SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void setRequest(@androidx.annotation.Nullable com.bumptech.glide.request.Request request) {
        this.request = request;
    }
}
