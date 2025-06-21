package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableAllSingle<T> extends io.reactivex.Single<java.lang.Boolean> implements io.reactivex.internal.fuseable.FuseToFlowable<java.lang.Boolean> {
    public final io.reactivex.Flowable<T> n;
    public final io.reactivex.functions.Predicate<? super T> t;

    public static final class AllSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super java.lang.Boolean> n;
        public final io.reactivex.functions.Predicate<? super T> t;
        public org.reactivestreams.Subscription u;
        public boolean v;

        public AllSubscriber(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver, io.reactivex.functions.Predicate<? super T> predicate) {
            this.n = singleObserver;
            this.t = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.cancel();
            this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.v) {
                return;
            }
            this.v = true;
            this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onSuccess(java.lang.Boolean.TRUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.v) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.v = true;
            this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.v) {
                return;
            }
            try {
                if (this.t.test(t)) {
                    return;
                }
                this.v = true;
                this.u.cancel();
                this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
                this.n.onSuccess(java.lang.Boolean.FALSE);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.u.cancel();
                this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.u, subscription)) {
                this.u = subscription;
                this.n.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableAllSingle(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Predicate<? super T> predicate) {
        this.n = flowable;
        this.t = predicate;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public io.reactivex.Flowable<java.lang.Boolean> fuseToFlowable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableAll(this.n, this.t));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver) {
        this.n.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableAllSingle.AllSubscriber(singleObserver, this.t));
    }
}
