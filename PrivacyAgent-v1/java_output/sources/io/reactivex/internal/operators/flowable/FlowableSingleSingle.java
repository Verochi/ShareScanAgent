package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableSingleSingle<T> extends io.reactivex.Single<T> implements io.reactivex.internal.fuseable.FuseToFlowable<T> {
    public final io.reactivex.Flowable<T> n;
    public final T t;

    public static final class SingleElementSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super T> n;
        public final T t;
        public org.reactivestreams.Subscription u;
        public boolean v;
        public T w;

        public SingleElementSubscriber(io.reactivex.SingleObserver<? super T> singleObserver, T t) {
            this.n = singleObserver;
            this.t = t;
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
            T t = this.w;
            this.w = null;
            if (t == null) {
                t = this.t;
            }
            if (t != null) {
                this.n.onSuccess(t);
            } else {
                this.n.onError(new java.util.NoSuchElementException());
            }
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
            if (this.w == null) {
                this.w = t;
                return;
            }
            this.v = true;
            this.u.cancel();
            this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onError(new java.lang.IllegalArgumentException("Sequence contains more than one element!"));
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

    public FlowableSingleSingle(io.reactivex.Flowable<T> flowable, T t) {
        this.n = flowable;
        this.t = t;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public io.reactivex.Flowable<T> fuseToFlowable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSingle(this.n, this.t, true));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableSingleSingle.SingleElementSubscriber(singleObserver, this.t));
    }
}
