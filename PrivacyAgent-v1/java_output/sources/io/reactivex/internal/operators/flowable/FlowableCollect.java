package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableCollect<T, U> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, U> {
    public final java.util.concurrent.Callable<? extends U> t;
    public final io.reactivex.functions.BiConsumer<? super U, ? super T> u;

    public static final class CollectSubscriber<T, U> extends io.reactivex.internal.subscriptions.DeferredScalarSubscription<U> implements io.reactivex.FlowableSubscriber<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        final io.reactivex.functions.BiConsumer<? super U, ? super T> collector;
        boolean done;
        final U u;
        org.reactivestreams.Subscription upstream;

        public CollectSubscriber(org.reactivestreams.Subscriber<? super U> subscriber, U u, io.reactivex.functions.BiConsumer<? super U, ? super T> biConsumer) {
            super(subscriber);
            this.collector = biConsumer;
            this.u = u;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            complete(this.u);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.collector.accept(this.u, t);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCollect(io.reactivex.Flowable<T> flowable, java.util.concurrent.Callable<? extends U> callable, io.reactivex.functions.BiConsumer<? super U, ? super T> biConsumer) {
        super(flowable);
        this.t = callable;
        this.u = biConsumer;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super U> subscriber) {
        try {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableCollect.CollectSubscriber(subscriber, io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The initial value supplied is null"), this.u));
        } catch (java.lang.Throwable th) {
            io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
        }
    }
}
