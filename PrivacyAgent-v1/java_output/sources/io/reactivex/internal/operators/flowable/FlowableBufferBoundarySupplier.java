package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableBufferBoundarySupplier<T, U extends java.util.Collection<? super T>, B> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, U> {
    public final java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<B>> t;
    public final java.util.concurrent.Callable<U> u;

    public static final class BufferBoundarySubscriber<T, U extends java.util.Collection<? super T>, B> extends io.reactivex.subscribers.DisposableSubscriber<B> {
        public final io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber<T, U, B> t;
        public boolean u;

        public BufferBoundarySubscriber(io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber<T, U, B> bufferBoundarySupplierSubscriber) {
            this.t = bufferBoundarySupplierSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.u) {
                return;
            }
            this.u = true;
            this.t.c();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.u) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.u = true;
                this.t.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            if (this.u) {
                return;
            }
            this.u = true;
            cancel();
            this.t.c();
        }
    }

    public static final class BufferBoundarySupplierSubscriber<T, U extends java.util.Collection<? super T>, B> extends io.reactivex.internal.subscribers.QueueDrainSubscriber<T, U, U> implements org.reactivestreams.Subscription, io.reactivex.disposables.Disposable {
        public final java.util.concurrent.Callable<U> u;
        public final java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<B>> v;
        public org.reactivestreams.Subscription w;
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> x;
        public U y;

        public BufferBoundarySupplierSubscriber(org.reactivestreams.Subscriber<? super U> subscriber, java.util.concurrent.Callable<U> callable, java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<B>> callable2) {
            super(subscriber, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.x = new java.util.concurrent.atomic.AtomicReference<>();
            this.u = callable;
            this.v = callable2;
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean accept(org.reactivestreams.Subscriber<? super U> subscriber, U u) {
            this.downstream.onNext(u);
            return true;
        }

        public void b() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.x);
        }

        public void c() {
            try {
                U u = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The buffer supplied is null");
                try {
                    org.reactivestreams.Publisher publisher = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.v.call(), "The boundary publisher supplied is null");
                    io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier.BufferBoundarySubscriber bufferBoundarySubscriber = new io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier.BufferBoundarySubscriber(this);
                    if (io.reactivex.internal.disposables.DisposableHelper.replace(this.x, bufferBoundarySubscriber)) {
                        synchronized (this) {
                            U u2 = this.y;
                            if (u2 == null) {
                                return;
                            }
                            this.y = u;
                            publisher.subscribe(bufferBoundarySubscriber);
                            fastPathEmitMax(u2, false, this);
                        }
                    }
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.cancelled = true;
                    this.w.cancel();
                    this.downstream.onError(th);
                }
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                cancel();
                this.downstream.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.w.cancel();
            b();
            if (enter()) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.w.cancel();
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.x.get() == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            synchronized (this) {
                U u = this.y;
                if (u == null) {
                    return;
                }
                this.y = null;
                this.queue.offer(u);
                this.done = true;
                if (enter()) {
                    io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            cancel();
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U u = this.y;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.w, subscription)) {
                this.w = subscription;
                org.reactivestreams.Subscriber<? super V> subscriber = this.downstream;
                try {
                    this.y = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The buffer supplied is null");
                    try {
                        org.reactivestreams.Publisher publisher = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.v.call(), "The boundary publisher supplied is null");
                        io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier.BufferBoundarySubscriber bufferBoundarySubscriber = new io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier.BufferBoundarySubscriber(this);
                        this.x.set(bufferBoundarySubscriber);
                        subscriber.onSubscribe(this);
                        if (this.cancelled) {
                            return;
                        }
                        subscription.request(Long.MAX_VALUE);
                        publisher.subscribe(bufferBoundarySubscriber);
                    } catch (java.lang.Throwable th) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                        this.cancelled = true;
                        subscription.cancel();
                        io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
                    }
                } catch (java.lang.Throwable th2) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                    this.cancelled = true;
                    subscription.cancel();
                    io.reactivex.internal.subscriptions.EmptySubscription.error(th2, subscriber);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    public FlowableBufferBoundarySupplier(io.reactivex.Flowable<T> flowable, java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<B>> callable, java.util.concurrent.Callable<U> callable2) {
        super(flowable);
        this.t = callable;
        this.u = callable2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super U> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber(new io.reactivex.subscribers.SerializedSubscriber(subscriber), this.u, this.t));
    }
}
