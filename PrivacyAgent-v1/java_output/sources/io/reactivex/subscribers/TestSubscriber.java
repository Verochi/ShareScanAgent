package io.reactivex.subscribers;

/* loaded from: classes14.dex */
public class TestSubscriber<T> extends io.reactivex.observers.BaseTestConsumer<T, io.reactivex.subscribers.TestSubscriber<T>> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
    public final org.reactivestreams.Subscriber<? super T> n;
    public volatile boolean t;
    public final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> u;
    public final java.util.concurrent.atomic.AtomicLong v;
    public io.reactivex.internal.fuseable.QueueSubscription<T> w;

    public enum EmptySubscriber implements io.reactivex.FlowableSubscriber<java.lang.Object> {
        INSTANCE;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.lang.Object obj) {
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
        }
    }

    public TestSubscriber() {
        this(io.reactivex.subscribers.TestSubscriber.EmptySubscriber.INSTANCE, Long.MAX_VALUE);
    }

    public TestSubscriber(long j) {
        this(io.reactivex.subscribers.TestSubscriber.EmptySubscriber.INSTANCE, j);
    }

    public TestSubscriber(org.reactivestreams.Subscriber<? super T> subscriber) {
        this(subscriber, Long.MAX_VALUE);
    }

    public TestSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Negative initial request not allowed");
        }
        this.n = subscriber;
        this.u = new java.util.concurrent.atomic.AtomicReference<>();
        this.v = new java.util.concurrent.atomic.AtomicLong(j);
    }

    public static <T> io.reactivex.subscribers.TestSubscriber<T> create() {
        return new io.reactivex.subscribers.TestSubscriber<>();
    }

    public static <T> io.reactivex.subscribers.TestSubscriber<T> create(long j) {
        return new io.reactivex.subscribers.TestSubscriber<>(j);
    }

    public static <T> io.reactivex.subscribers.TestSubscriber<T> create(org.reactivestreams.Subscriber<? super T> subscriber) {
        return new io.reactivex.subscribers.TestSubscriber<>(subscriber);
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public final io.reactivex.subscribers.TestSubscriber<T> assertNotSubscribed() {
        if (this.u.get() != null) {
            throw fail("Subscribed!");
        }
        if (this.errors.isEmpty()) {
            return this;
        }
        throw fail("Not subscribed but errors found");
    }

    public final io.reactivex.subscribers.TestSubscriber<T> assertOf(io.reactivex.functions.Consumer<? super io.reactivex.subscribers.TestSubscriber<T>> consumer) {
        try {
            consumer.accept(this);
            return this;
        } catch (java.lang.Throwable th) {
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public final io.reactivex.subscribers.TestSubscriber<T> assertSubscribed() {
        if (this.u.get() != null) {
            return this;
        }
        throw fail("Not subscribed!");
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.t) {
            return;
        }
        this.t = true;
        io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.u);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        cancel();
    }

    public final boolean hasSubscription() {
        return this.u.get() != null;
    }

    public final boolean isCancelled() {
        return this.t;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.t;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.u.get() == null) {
                this.errors.add(new java.lang.IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = java.lang.Thread.currentThread();
            this.completions++;
            this.n.onComplete();
        } finally {
            this.done.countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.u.get() == null) {
                this.errors.add(new java.lang.NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = java.lang.Thread.currentThread();
            this.errors.add(th);
            if (th == null) {
                this.errors.add(new java.lang.IllegalStateException("onError received a null Throwable"));
            }
            this.n.onError(th);
        } finally {
            this.done.countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.u.get() == null) {
                this.errors.add(new java.lang.IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.lastThread = java.lang.Thread.currentThread();
        if (this.establishedFusionMode != 2) {
            this.values.add(t);
            if (t == null) {
                this.errors.add(new java.lang.NullPointerException("onNext received a null value"));
            }
            this.n.onNext(t);
            return;
        }
        while (true) {
            try {
                T poll = this.w.poll();
                if (poll == null) {
                    return;
                } else {
                    this.values.add(poll);
                }
            } catch (java.lang.Throwable th) {
                this.errors.add(th);
                this.w.cancel();
                return;
            }
        }
    }

    public void onStart() {
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        this.lastThread = java.lang.Thread.currentThread();
        if (subscription == null) {
            this.errors.add(new java.lang.NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!defpackage.xv0.a(this.u, null, subscription)) {
            subscription.cancel();
            if (this.u.get() != io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
                this.errors.add(new java.lang.IllegalStateException("onSubscribe received multiple subscriptions: " + subscription));
                return;
            }
            return;
        }
        int i = this.initialFusionMode;
        if (i != 0 && (subscription instanceof io.reactivex.internal.fuseable.QueueSubscription)) {
            io.reactivex.internal.fuseable.QueueSubscription<T> queueSubscription = (io.reactivex.internal.fuseable.QueueSubscription) subscription;
            this.w = queueSubscription;
            int requestFusion = queueSubscription.requestFusion(i);
            this.establishedFusionMode = requestFusion;
            if (requestFusion == 1) {
                this.checkSubscriptionOnce = true;
                this.lastThread = java.lang.Thread.currentThread();
                while (true) {
                    try {
                        T poll = this.w.poll();
                        if (poll == null) {
                            this.completions++;
                            return;
                        }
                        this.values.add(poll);
                    } catch (java.lang.Throwable th) {
                        this.errors.add(th);
                        return;
                    }
                }
            }
        }
        this.n.onSubscribe(subscription);
        long andSet = this.v.getAndSet(0L);
        if (andSet != 0) {
            subscription.request(andSet);
        }
        onStart();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        io.reactivex.internal.subscriptions.SubscriptionHelper.deferredRequest(this.u, this.v, j);
    }

    public final io.reactivex.subscribers.TestSubscriber<T> requestMore(long j) {
        request(j);
        return this;
    }
}
