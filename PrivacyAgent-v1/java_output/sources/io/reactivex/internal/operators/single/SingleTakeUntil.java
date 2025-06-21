package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleTakeUntil<T, U> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<T> n;
    public final org.reactivestreams.Publisher<U> t;

    public static final class TakeUntilMainObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.SingleObserver<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -622603812305745221L;
        final io.reactivex.SingleObserver<? super T> downstream;
        final io.reactivex.internal.operators.single.SingleTakeUntil.TakeUntilOtherSubscriber other = new io.reactivex.internal.operators.single.SingleTakeUntil.TakeUntilOtherSubscriber(this);

        public TakeUntilMainObserver(io.reactivex.SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
            this.other.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            this.other.dispose();
            io.reactivex.disposables.Disposable disposable = get();
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || getAndSet(disposableHelper) == disposableHelper) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.other.dispose();
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.downstream.onSuccess(t);
            }
        }

        public void otherError(java.lang.Throwable th) {
            io.reactivex.disposables.Disposable andSet;
            io.reactivex.disposables.Disposable disposable = get();
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (andSet != null) {
                andSet.dispose();
            }
            this.downstream.onError(th);
        }
    }

    public static final class TakeUntilOtherSubscriber extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<java.lang.Object> {
        private static final long serialVersionUID = 5170026210238877381L;
        final io.reactivex.internal.operators.single.SingleTakeUntil.TakeUntilMainObserver<?> parent;

        public TakeUntilOtherSubscriber(io.reactivex.internal.operators.single.SingleTakeUntil.TakeUntilMainObserver<?> takeUntilMainObserver) {
            this.parent = takeUntilMainObserver;
        }

        public void dispose() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            org.reactivestreams.Subscription subscription = get();
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.otherError(new java.util.concurrent.CancellationException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.parent.otherError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.lang.Object obj) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this)) {
                this.parent.otherError(new java.util.concurrent.CancellationException());
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public SingleTakeUntil(io.reactivex.SingleSource<T> singleSource, org.reactivestreams.Publisher<U> publisher) {
        this.n = singleSource;
        this.t = publisher;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        io.reactivex.internal.operators.single.SingleTakeUntil.TakeUntilMainObserver takeUntilMainObserver = new io.reactivex.internal.operators.single.SingleTakeUntil.TakeUntilMainObserver(singleObserver);
        singleObserver.onSubscribe(takeUntilMainObserver);
        this.t.subscribe(takeUntilMainObserver.other);
        this.n.subscribe(takeUntilMainObserver);
    }
}
