package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableLastSingle<T> extends io.reactivex.Single<T> {
    public final org.reactivestreams.Publisher<T> n;
    public final T t;

    public static final class LastSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super T> n;
        public final T t;
        public org.reactivestreams.Subscription u;
        public T v;

        public LastSubscriber(io.reactivex.SingleObserver<? super T> singleObserver, T t) {
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
            this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            T t = this.v;
            if (t != null) {
                this.v = null;
                this.n.onSuccess(t);
                return;
            }
            T t2 = this.t;
            if (t2 != null) {
                this.n.onSuccess(t2);
            } else {
                this.n.onError(new java.util.NoSuchElementException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.v = null;
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.v = t;
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

    public FlowableLastSingle(org.reactivestreams.Publisher<T> publisher, T t) {
        this.n = publisher;
        this.t = t;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.flowable.FlowableLastSingle.LastSubscriber(singleObserver, this.t));
    }
}
