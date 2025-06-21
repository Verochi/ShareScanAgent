package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableReduceSeedSingle<T, R> extends io.reactivex.Single<R> {
    public final org.reactivestreams.Publisher<T> n;
    public final R t;
    public final io.reactivex.functions.BiFunction<R, ? super T, R> u;

    public static final class ReduceSeedObserver<T, R> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super R> n;
        public final io.reactivex.functions.BiFunction<R, ? super T, R> t;
        public R u;
        public org.reactivestreams.Subscription v;

        public ReduceSeedObserver(io.reactivex.SingleObserver<? super R> singleObserver, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction, R r) {
            this.n = singleObserver;
            this.u = r;
            this.t = biFunction;
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
            R r = this.u;
            if (r != null) {
                this.u = null;
                this.v = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
                this.n.onSuccess(r);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.u == null) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.u = null;
            this.v = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            R r = this.u;
            if (r != null) {
                try {
                    this.u = (R) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(r, t), "The reducer returned a null value");
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.v.cancel();
                    onError(th);
                }
            }
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

    public FlowableReduceSeedSingle(org.reactivestreams.Publisher<T> publisher, R r, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        this.n = publisher;
        this.t = r;
        this.u = biFunction;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super R> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.u, this.t));
    }
}
