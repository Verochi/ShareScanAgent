package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableWithLatestFromMany<T, R> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, R> {

    @io.reactivex.annotations.Nullable
    public final org.reactivestreams.Publisher<?>[] t;

    @io.reactivex.annotations.Nullable
    public final java.lang.Iterable<? extends org.reactivestreams.Publisher<?>> u;
    public final io.reactivex.functions.Function<? super java.lang.Object[], R> v;

    public final class SingletonArrayFunc implements io.reactivex.functions.Function<T, R> {
        public SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) throws java.lang.Exception {
            return (R) io.reactivex.internal.functions.ObjectHelper.requireNonNull(io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.this.v.apply(new java.lang.Object[]{t}), "The combiner returned a null value");
        }
    }

    public static final class WithLatestFromSubscriber<T, R> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.internal.fuseable.ConditionalSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = 1577321883966341961L;
        final io.reactivex.functions.Function<? super java.lang.Object[], R> combiner;
        volatile boolean done;
        final org.reactivestreams.Subscriber<? super R> downstream;
        final io.reactivex.internal.util.AtomicThrowable error;
        final java.util.concurrent.atomic.AtomicLong requested;
        final io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.WithLatestInnerSubscriber[] subscribers;
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> upstream;
        final java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> values;

        public WithLatestFromSubscriber(org.reactivestreams.Subscriber<? super R> subscriber, io.reactivex.functions.Function<? super java.lang.Object[], R> function, int i) {
            this.downstream = subscriber;
            this.combiner = function;
            io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = new io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.WithLatestInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                withLatestInnerSubscriberArr[i2] = new io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.WithLatestInnerSubscriber(this, i2);
            }
            this.subscribers = withLatestInnerSubscriberArr;
            this.values = new java.util.concurrent.atomic.AtomicReferenceArray<>(i);
            this.upstream = new java.util.concurrent.atomic.AtomicReference<>();
            this.requested = new java.util.concurrent.atomic.AtomicLong();
            this.error = new io.reactivex.internal.util.AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
            for (io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.WithLatestInnerSubscriber withLatestInnerSubscriber : this.subscribers) {
                withLatestInnerSubscriber.dispose();
            }
        }

        public void cancelAllBut(int i) {
            io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < withLatestInnerSubscriberArr.length; i2++) {
                if (i2 != i) {
                    withLatestInnerSubscriberArr[i2].dispose();
                }
            }
        }

        public void innerComplete(int i, boolean z) {
            if (z) {
                return;
            }
            this.done = true;
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
            cancelAllBut(i);
            io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        public void innerError(int i, java.lang.Throwable th) {
            this.done = true;
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
            cancelAllBut(i);
            io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        public void innerNext(int i, java.lang.Object obj) {
            this.values.set(i, obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t) || this.done) {
                return;
            }
            this.upstream.get().request(1L);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        public void subscribe(org.reactivestreams.Publisher<?>[] publisherArr, int i) {
            io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
            java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> atomicReference = this.upstream;
            for (int i2 = 0; i2 < i && atomicReference.get() != io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED; i2++) {
                publisherArr[i2].subscribe(withLatestInnerSubscriberArr[i2]);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            java.util.concurrent.atomic.AtomicReferenceArray<java.lang.Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            java.lang.Object[] objArr = new java.lang.Object[length + 1];
            objArr[0] = t;
            int i = 0;
            while (i < length) {
                java.lang.Object obj = atomicReferenceArray.get(i);
                if (obj == null) {
                    return false;
                }
                i++;
                objArr[i] = obj;
            }
            try {
                io.reactivex.internal.util.HalfSerializer.onNext(this.downstream, io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.combiner.apply(objArr), "The combiner returned a null value"), this, this.error);
                return true;
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                cancel();
                onError(th);
                return false;
            }
        }
    }

    public static final class WithLatestInnerSubscriber extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<java.lang.Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.WithLatestFromSubscriber<?, ?> parent;

        public WithLatestInnerSubscriber(io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.WithLatestFromSubscriber<?, ?> withLatestFromSubscriber, int i) {
            this.parent = withLatestFromSubscriber;
            this.index = i;
        }

        public void dispose() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.lang.Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableWithLatestFromMany(@io.reactivex.annotations.NonNull io.reactivex.Flowable<T> flowable, @io.reactivex.annotations.NonNull java.lang.Iterable<? extends org.reactivestreams.Publisher<?>> iterable, @io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super java.lang.Object[], R> function) {
        super(flowable);
        this.t = null;
        this.u = iterable;
        this.v = function;
    }

    public FlowableWithLatestFromMany(@io.reactivex.annotations.NonNull io.reactivex.Flowable<T> flowable, @io.reactivex.annotations.NonNull org.reactivestreams.Publisher<?>[] publisherArr, io.reactivex.functions.Function<? super java.lang.Object[], R> function) {
        super(flowable);
        this.t = publisherArr;
        this.u = null;
        this.v = function;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super R> subscriber) {
        int length;
        org.reactivestreams.Publisher<?>[] publisherArr = this.t;
        if (publisherArr == null) {
            publisherArr = new org.reactivestreams.Publisher[8];
            try {
                length = 0;
                for (org.reactivestreams.Publisher<?> publisher : this.u) {
                    if (length == publisherArr.length) {
                        publisherArr = (org.reactivestreams.Publisher[]) java.util.Arrays.copyOf(publisherArr, (length >> 1) + length);
                    }
                    int i = length + 1;
                    publisherArr[length] = publisher;
                    length = i;
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        if (length == 0) {
            new io.reactivex.internal.operators.flowable.FlowableMap(this.source, new io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.SingletonArrayFunc()).subscribeActual(subscriber);
            return;
        }
        io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.WithLatestFromSubscriber withLatestFromSubscriber = new io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.WithLatestFromSubscriber(subscriber, this.v, length);
        subscriber.onSubscribe(withLatestFromSubscriber);
        withLatestFromSubscriber.subscribe(publisherArr, length);
        this.source.subscribe((io.reactivex.FlowableSubscriber) withLatestFromSubscriber);
    }
}
