package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeDelayOtherPublisher<T, U> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, T> {
    public final org.reactivestreams.Publisher<U> n;

    public static final class DelayMaybeObserver<T, U> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher.OtherSubscriber<T> n;
        public final org.reactivestreams.Publisher<U> t;
        public io.reactivex.disposables.Disposable u;

        public DelayMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, org.reactivestreams.Publisher<U> publisher) {
            this.n = new io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher.OtherSubscriber<>(maybeObserver);
            this.t = publisher;
        }

        public void a() {
            this.t.subscribe(this.n);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.dispose();
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.n);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.n.get() == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            a();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.error = th;
            a();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.value = t;
            a();
        }
    }

    public static final class OtherSubscriber<T> extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<java.lang.Object> {
        private static final long serialVersionUID = -1215060610805418006L;
        final io.reactivex.MaybeObserver<? super T> downstream;
        java.lang.Throwable error;
        T value;

        public OtherSubscriber(io.reactivex.MaybeObserver<? super T> maybeObserver) {
            this.downstream = maybeObserver;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            java.lang.Throwable th = this.error;
            if (th != null) {
                this.downstream.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.downstream.onSuccess(t);
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            java.lang.Throwable th2 = this.error;
            if (th2 == null) {
                this.downstream.onError(th);
            } else {
                this.downstream.onError(new io.reactivex.exceptions.CompositeException(th2, th));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.lang.Object obj) {
            org.reactivestreams.Subscription subscription = get();
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                onComplete();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public MaybeDelayOtherPublisher(io.reactivex.MaybeSource<T> maybeSource, org.reactivestreams.Publisher<U> publisher) {
        super(maybeSource);
        this.n = publisher;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher.DelayMaybeObserver(maybeObserver, this.n));
    }
}
