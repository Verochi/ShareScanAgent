package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableLastMaybe<T> extends io.reactivex.Maybe<T> {
    public final org.reactivestreams.Publisher<T> n;

    public static final class LastSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public org.reactivestreams.Subscription t;
        public T u;

        public LastSubscriber(io.reactivex.MaybeObserver<? super T> maybeObserver) {
            this.n = maybeObserver;
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
            T t = this.u;
            if (t == null) {
                this.n.onComplete();
            } else {
                this.u = null;
                this.n.onSuccess(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.t = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.u = null;
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.u = t;
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

    public FlowableLastMaybe(org.reactivestreams.Publisher<T> publisher) {
        this.n = publisher;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.flowable.FlowableLastMaybe.LastSubscriber(maybeObserver));
    }
}
