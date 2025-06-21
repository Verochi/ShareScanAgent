package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public abstract class RunnableFutureTask<R, E extends java.lang.Exception> implements java.util.concurrent.RunnableFuture<R> {
    public final com.google.android.exoplayer2.util.ConditionVariable n = new com.google.android.exoplayer2.util.ConditionVariable();
    public final com.google.android.exoplayer2.util.ConditionVariable t = new com.google.android.exoplayer2.util.ConditionVariable();
    public final java.lang.Object u = new java.lang.Object();

    @androidx.annotation.Nullable
    public java.lang.Exception v;

    @androidx.annotation.Nullable
    public R w;

    @androidx.annotation.Nullable
    public java.lang.Thread x;
    public boolean y;

    @com.google.android.exoplayer2.util.UnknownNull
    public final R a() throws java.util.concurrent.ExecutionException {
        if (this.y) {
            throw new java.util.concurrent.CancellationException();
        }
        if (this.v == null) {
            return this.w;
        }
        throw new java.util.concurrent.ExecutionException(this.v);
    }

    public final void blockUntilFinished() {
        this.t.blockUninterruptible();
    }

    public final void blockUntilStarted() {
        this.n.blockUninterruptible();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        synchronized (this.u) {
            if (!this.y && !this.t.isOpen()) {
                this.y = true;
                cancelWork();
                java.lang.Thread thread = this.x;
                if (thread == null) {
                    this.n.open();
                    this.t.open();
                } else if (z) {
                    thread.interrupt();
                }
                return true;
            }
            return false;
        }
    }

    public void cancelWork() {
    }

    @com.google.android.exoplayer2.util.UnknownNull
    public abstract R doWork() throws java.lang.Exception;

    @Override // java.util.concurrent.Future
    @com.google.android.exoplayer2.util.UnknownNull
    public final R get() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        this.t.block();
        return a();
    }

    @Override // java.util.concurrent.Future
    @com.google.android.exoplayer2.util.UnknownNull
    public final R get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        if (this.t.block(java.util.concurrent.TimeUnit.MILLISECONDS.convert(j, timeUnit))) {
            return a();
        }
        throw new java.util.concurrent.TimeoutException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.y;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.t.isOpen();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        synchronized (this.u) {
            if (this.y) {
                return;
            }
            this.x = java.lang.Thread.currentThread();
            this.n.open();
            try {
                try {
                    this.w = doWork();
                    synchronized (this.u) {
                        this.t.open();
                        this.x = null;
                        java.lang.Thread.interrupted();
                    }
                } catch (java.lang.Exception e) {
                    this.v = e;
                    synchronized (this.u) {
                        this.t.open();
                        this.x = null;
                        java.lang.Thread.interrupted();
                    }
                }
            } catch (java.lang.Throwable th) {
                synchronized (this.u) {
                    this.t.open();
                    this.x = null;
                    java.lang.Thread.interrupted();
                    throw th;
                }
            }
        }
    }
}
