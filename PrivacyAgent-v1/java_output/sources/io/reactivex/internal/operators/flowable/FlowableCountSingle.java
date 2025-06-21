package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableCountSingle<T> extends io.reactivex.Single<java.lang.Long> implements io.reactivex.internal.fuseable.FuseToFlowable<java.lang.Long> {
    public final io.reactivex.Flowable<T> n;

    public static final class CountSubscriber implements io.reactivex.FlowableSubscriber<java.lang.Object>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super java.lang.Long> n;
        public org.reactivestreams.Subscription t;
        public long u;

        public CountSubscriber(io.reactivex.SingleObserver<? super java.lang.Long> singleObserver) {
            this.n = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.t.cancel();
            this.t = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.t = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onSuccess(java.lang.Long.valueOf(this.u));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.t = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.lang.Object obj) {
            this.u++;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.t, subscription)) {
                this.t = subscription;
                this.n.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCountSingle(io.reactivex.Flowable<T> flowable) {
        this.n = flowable;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public io.reactivex.Flowable<java.lang.Long> fuseToFlowable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableCount(this.n));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super java.lang.Long> singleObserver) {
        this.n.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableCountSingle.CountSubscriber(singleObserver));
    }
}
