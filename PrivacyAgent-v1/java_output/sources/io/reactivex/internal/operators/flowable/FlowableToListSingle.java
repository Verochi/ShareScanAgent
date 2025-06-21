package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableToListSingle<T, U extends java.util.Collection<? super T>> extends io.reactivex.Single<U> implements io.reactivex.internal.fuseable.FuseToFlowable<U> {
    public final io.reactivex.Flowable<T> n;
    public final java.util.concurrent.Callable<U> t;

    public static final class ToListSubscriber<T, U extends java.util.Collection<? super T>> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super U> n;
        public org.reactivestreams.Subscription t;
        public U u;

        public ToListSubscriber(io.reactivex.SingleObserver<? super U> singleObserver, U u) {
            this.n = singleObserver;
            this.u = u;
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
            this.n.onSuccess(this.u);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.u = null;
            this.t = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.u.add(t);
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

    public FlowableToListSingle(io.reactivex.Flowable<T> flowable) {
        this(flowable, io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    public FlowableToListSingle(io.reactivex.Flowable<T> flowable, java.util.concurrent.Callable<U> callable) {
        this.n = flowable;
        this.t = callable;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public io.reactivex.Flowable<U> fuseToFlowable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableToList(this.n, this.t));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super U> singleObserver) {
        try {
            this.n.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableToListSingle.ToListSubscriber(singleObserver, (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, singleObserver);
        }
    }
}
