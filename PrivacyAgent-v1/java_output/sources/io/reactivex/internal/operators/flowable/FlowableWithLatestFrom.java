package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableWithLatestFrom<T, U, R> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, R> {
    public final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> t;
    public final org.reactivestreams.Publisher<? extends U> u;

    public final class FlowableWithLatestSubscriber implements io.reactivex.FlowableSubscriber<U> {
        public final io.reactivex.internal.operators.flowable.FlowableWithLatestFrom.WithLatestFromSubscriber<T, U, R> n;

        public FlowableWithLatestSubscriber(io.reactivex.internal.operators.flowable.FlowableWithLatestFrom.WithLatestFromSubscriber<T, U, R> withLatestFromSubscriber) {
            this.n = withLatestFromSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.n.otherError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u) {
            this.n.lazySet(u);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (this.n.setOther(subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public static final class WithLatestFromSubscriber<T, U, R> extends java.util.concurrent.atomic.AtomicReference<U> implements io.reactivex.internal.fuseable.ConditionalSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = -312246233408980075L;
        final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> combiner;
        final org.reactivestreams.Subscriber<? super R> downstream;
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> upstream = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> other = new java.util.concurrent.atomic.AtomicReference<>();

        public WithLatestFromSubscriber(org.reactivestreams.Subscriber<? super R> subscriber, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.downstream = subscriber;
            this.combiner = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.other);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.other);
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.other);
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.upstream.get().request(1L);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        public void otherError(java.lang.Throwable th) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        public boolean setOther(org.reactivestreams.Subscription subscription) {
            return io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this.other, subscription);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.downstream.onNext(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.combiner.apply(t, u), "The combiner returned a null value"));
                    return true;
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    cancel();
                    this.downstream.onError(th);
                }
            }
            return false;
        }
    }

    public FlowableWithLatestFrom(io.reactivex.Flowable<T> flowable, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, org.reactivestreams.Publisher<? extends U> publisher) {
        super(flowable);
        this.t = biFunction;
        this.u = publisher;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super R> subscriber) {
        io.reactivex.subscribers.SerializedSubscriber serializedSubscriber = new io.reactivex.subscribers.SerializedSubscriber(subscriber);
        io.reactivex.internal.operators.flowable.FlowableWithLatestFrom.WithLatestFromSubscriber withLatestFromSubscriber = new io.reactivex.internal.operators.flowable.FlowableWithLatestFrom.WithLatestFromSubscriber(serializedSubscriber, this.t);
        serializedSubscriber.onSubscribe(withLatestFromSubscriber);
        this.u.subscribe(new io.reactivex.internal.operators.flowable.FlowableWithLatestFrom.FlowableWithLatestSubscriber(withLatestFromSubscriber));
        this.source.subscribe((io.reactivex.FlowableSubscriber) withLatestFromSubscriber);
    }
}
