package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableToList<T, U extends java.util.Collection<? super T>> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, U> {
    public final java.util.concurrent.Callable<U> t;

    public static final class ToListSubscriber<T, U extends java.util.Collection<? super T>> extends io.reactivex.internal.subscriptions.DeferredScalarSubscription<U> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = -8134157938864266736L;
        org.reactivestreams.Subscription upstream;

        /* JADX WARN: Multi-variable type inference failed */
        public ToListSubscriber(org.reactivestreams.Subscriber<? super U> subscriber, U u) {
            super(subscriber);
            this.value = u;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            complete(this.value);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.value = null;
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            java.util.Collection collection = (java.util.Collection) this.value;
            if (collection != null) {
                collection.add(t);
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

    public FlowableToList(io.reactivex.Flowable<T> flowable, java.util.concurrent.Callable<U> callable) {
        super(flowable);
        this.t = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super U> subscriber) {
        try {
            this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableToList.ToListSubscriber(subscriber, (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
        }
    }
}
