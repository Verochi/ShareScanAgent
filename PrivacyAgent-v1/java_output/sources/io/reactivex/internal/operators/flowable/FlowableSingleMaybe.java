package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableSingleMaybe<T> extends io.reactivex.Maybe<T> implements io.reactivex.internal.fuseable.FuseToFlowable<T> {
    public final io.reactivex.Flowable<T> n;

    public static final class SingleElementSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public org.reactivestreams.Subscription t;
        public boolean u;
        public T v;

        public SingleElementSubscriber(io.reactivex.MaybeObserver<? super T> maybeObserver) {
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
            if (this.u) {
                return;
            }
            this.u = true;
            this.t = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            T t = this.v;
            this.v = null;
            if (t == null) {
                this.n.onComplete();
            } else {
                this.n.onSuccess(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.u) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.u = true;
            this.t = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.u) {
                return;
            }
            if (this.v == null) {
                this.v = t;
                return;
            }
            this.u = true;
            this.t.cancel();
            this.t = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onError(new java.lang.IllegalArgumentException("Sequence contains more than one element!"));
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

    public FlowableSingleMaybe(io.reactivex.Flowable<T> flowable) {
        this.n = flowable;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public io.reactivex.Flowable<T> fuseToFlowable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSingle(this.n, null, false));
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableSingleMaybe.SingleElementSubscriber(maybeObserver));
    }
}
