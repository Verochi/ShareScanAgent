package io.reactivex.internal.subscribers;

/* loaded from: classes13.dex */
public final class FutureSubscriber<T> extends java.util.concurrent.CountDownLatch implements io.reactivex.FlowableSubscriber<T>, java.util.concurrent.Future<T>, org.reactivestreams.Subscription {
    public T n;
    public java.lang.Throwable t;
    public final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> u;

    public FutureSubscriber() {
        super(1);
        this.u = new java.util.concurrent.atomic.AtomicReference<>();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        org.reactivestreams.Subscription subscription;
        io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper;
        do {
            subscription = this.u.get();
            if (subscription == this || subscription == (subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED)) {
                return false;
            }
        } while (!defpackage.xv0.a(this.u, subscription, subscriptionHelper));
        if (subscription != null) {
            subscription.cancel();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        if (getCount() != 0) {
            io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
            await();
        }
        if (isCancelled()) {
            throw new java.util.concurrent.CancellationException();
        }
        java.lang.Throwable th = this.t;
        if (th == null) {
            return this.n;
        }
        throw new java.util.concurrent.ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public T get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        if (getCount() != 0) {
            io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
            if (!await(j, timeUnit)) {
                throw new java.util.concurrent.TimeoutException(io.reactivex.internal.util.ExceptionHelper.timeoutMessage(j, timeUnit));
            }
        }
        if (isCancelled()) {
            throw new java.util.concurrent.CancellationException();
        }
        java.lang.Throwable th = this.t;
        if (th == null) {
            return this.n;
        }
        throw new java.util.concurrent.ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.u.get() == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        org.reactivestreams.Subscription subscription;
        if (this.n == null) {
            onError(new java.util.NoSuchElementException("The source is empty"));
            return;
        }
        do {
            subscription = this.u.get();
            if (subscription == this || subscription == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
                return;
            }
        } while (!defpackage.xv0.a(this.u, subscription, this));
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        org.reactivestreams.Subscription subscription;
        do {
            subscription = this.u.get();
            if (subscription == this || subscription == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.t = th;
        } while (!defpackage.xv0.a(this.u, subscription, this));
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.n == null) {
            this.n = t;
        } else {
            this.u.get().cancel();
            onError(new java.lang.IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this.u, subscription, Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }
}
