package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableElementAtSingle<T> extends io.reactivex.Single<T> implements io.reactivex.internal.fuseable.FuseToFlowable<T> {
    public final io.reactivex.Flowable<T> n;
    public final long t;
    public final T u;

    public static final class ElementAtSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super T> n;
        public final long t;
        public final T u;
        public org.reactivestreams.Subscription v;
        public long w;
        public boolean x;

        public ElementAtSubscriber(io.reactivex.SingleObserver<? super T> singleObserver, long j, T t) {
            this.n = singleObserver;
            this.t = j;
            this.u = t;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.v.cancel();
            this.v = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.v == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.v = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (this.x) {
                return;
            }
            this.x = true;
            T t = this.u;
            if (t != null) {
                this.n.onSuccess(t);
            } else {
                this.n.onError(new java.util.NoSuchElementException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.x) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.x = true;
            this.v = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.x) {
                return;
            }
            long j = this.w;
            if (j != this.t) {
                this.w = j + 1;
                return;
            }
            this.x = true;
            this.v.cancel();
            this.v = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onSuccess(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.v, subscription)) {
                this.v = subscription;
                this.n.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableElementAtSingle(io.reactivex.Flowable<T> flowable, long j, T t) {
        this.n = flowable;
        this.t = j;
        this.u = t;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public io.reactivex.Flowable<T> fuseToFlowable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableElementAt(this.n, this.t, this.u, true));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableElementAtSingle.ElementAtSubscriber(singleObserver, this.t, this.u));
    }
}
