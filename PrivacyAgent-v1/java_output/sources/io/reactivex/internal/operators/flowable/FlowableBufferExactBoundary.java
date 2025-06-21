package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableBufferExactBoundary<T, U extends java.util.Collection<? super T>, B> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, U> {
    public final org.reactivestreams.Publisher<B> t;
    public final java.util.concurrent.Callable<U> u;

    public static final class BufferBoundarySubscriber<T, U extends java.util.Collection<? super T>, B> extends io.reactivex.subscribers.DisposableSubscriber<B> {
        public final io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary.BufferExactBoundarySubscriber<T, U, B> t;

        public BufferBoundarySubscriber(io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary.BufferExactBoundarySubscriber<T, U, B> bufferExactBoundarySubscriber) {
            this.t = bufferExactBoundarySubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.t.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.t.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            this.t.b();
        }
    }

    public static final class BufferExactBoundarySubscriber<T, U extends java.util.Collection<? super T>, B> extends io.reactivex.internal.subscribers.QueueDrainSubscriber<T, U, U> implements org.reactivestreams.Subscription, io.reactivex.disposables.Disposable {
        public final java.util.concurrent.Callable<U> u;
        public final org.reactivestreams.Publisher<B> v;
        public org.reactivestreams.Subscription w;
        public io.reactivex.disposables.Disposable x;
        public U y;

        public BufferExactBoundarySubscriber(org.reactivestreams.Subscriber<? super U> subscriber, java.util.concurrent.Callable<U> callable, org.reactivestreams.Publisher<B> publisher) {
            super(subscriber, new io.reactivex.internal.queue.MpscLinkedQueue());
            this.u = callable;
            this.v = publisher;
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean accept(org.reactivestreams.Subscriber<? super U> subscriber, U u) {
            this.downstream.onNext(u);
            return true;
        }

        public void b() {
            try {
                U u = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.y;
                    if (u2 == null) {
                        return;
                    }
                    this.y = u;
                    fastPathEmitMax(u2, false, this);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.x.dispose();
            this.w.cancel();
            if (enter()) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
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
                try {
                    this.y = (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The buffer supplied is null");
                    io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary.BufferBoundarySubscriber bufferBoundarySubscriber = new io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary.BufferBoundarySubscriber(this);
                    this.x = bufferBoundarySubscriber;
                    this.downstream.onSubscribe(this);
                    if (this.cancelled) {
                        return;
                    }
                    subscription.request(Long.MAX_VALUE);
                    this.v.subscribe(bufferBoundarySubscriber);
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.cancelled = true;
                    subscription.cancel();
                    io.reactivex.internal.subscriptions.EmptySubscription.error(th, this.downstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    public FlowableBufferExactBoundary(io.reactivex.Flowable<T> flowable, org.reactivestreams.Publisher<B> publisher, java.util.concurrent.Callable<U> callable) {
        super(flowable);
        this.t = publisher;
        this.u = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super U> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary.BufferExactBoundarySubscriber(new io.reactivex.subscribers.SerializedSubscriber(subscriber), this.u, this.t));
    }
}
