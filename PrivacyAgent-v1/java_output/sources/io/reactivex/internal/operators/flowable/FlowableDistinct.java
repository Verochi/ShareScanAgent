package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableDistinct<T, K> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super T, K> t;
    public final java.util.concurrent.Callable<? extends java.util.Collection<? super K>> u;

    public static final class DistinctSubscriber<T, K> extends io.reactivex.internal.subscribers.BasicFuseableSubscriber<T, T> {
        public final java.util.Collection<? super K> n;
        public final io.reactivex.functions.Function<? super T, K> t;

        public DistinctSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.functions.Function<? super T, K> function, java.util.Collection<? super K> collection) {
            super(subscriber);
            this.t = function;
            this.n = collection;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.n.clear();
            super.clear();
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.n.clear();
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.n.clear();
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(null);
                return;
            }
            try {
                if (this.n.add(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t), "The keySelector returned a null key"))) {
                    this.downstream.onNext(t);
                } else {
                    this.upstream.request(1L);
                }
            } catch (java.lang.Throwable th) {
                fail(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() throws java.lang.Exception {
            T poll;
            while (true) {
                poll = this.qs.poll();
                if (poll == null || this.n.add((java.lang.Object) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(poll), "The keySelector returned a null key"))) {
                    break;
                }
                if (this.sourceMode == 2) {
                    this.upstream.request(1L);
                }
            }
            return poll;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public FlowableDistinct(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super T, K> function, java.util.concurrent.Callable<? extends java.util.Collection<? super K>> callable) {
        super(flowable);
        this.t = function;
        this.u = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        try {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableDistinct.DistinctSubscriber(subscriber, this.t, (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.u.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
        }
    }
}
