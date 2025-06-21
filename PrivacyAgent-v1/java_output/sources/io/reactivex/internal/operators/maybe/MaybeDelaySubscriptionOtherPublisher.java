package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, T> {
    public final org.reactivestreams.Publisher<U> n;

    public static final class DelayMaybeObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.MaybeObserver<T> {
        private static final long serialVersionUID = 706635022205076709L;
        final io.reactivex.MaybeObserver<? super T> downstream;

        public DelayMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver) {
            this.downstream = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public static final class OtherSubscriber<T> implements io.reactivex.FlowableSubscriber<java.lang.Object>, io.reactivex.disposables.Disposable {
        public final io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher.DelayMaybeObserver<T> n;
        public io.reactivex.MaybeSource<T> t;
        public org.reactivestreams.Subscription u;

        public OtherSubscriber(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.MaybeSource<T> maybeSource) {
            this.n = new io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher.DelayMaybeObserver<>(maybeObserver);
            this.t = maybeSource;
        }

        public void a() {
            io.reactivex.MaybeSource<T> maybeSource = this.t;
            this.t = null;
            maybeSource.subscribe(this.n);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.cancel();
            this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.n);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.n.get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            org.reactivestreams.Subscription subscription = this.u;
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.u = subscriptionHelper;
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            org.reactivestreams.Subscription subscription = this.u;
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.u = subscriptionHelper;
                this.n.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.lang.Object obj) {
            org.reactivestreams.Subscription subscription = this.u;
            io.reactivex.internal.subscriptions.SubscriptionHelper subscriptionHelper = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                this.u = subscriptionHelper;
                a();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.u, subscription)) {
                this.u = subscription;
                this.n.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public MaybeDelaySubscriptionOtherPublisher(io.reactivex.MaybeSource<T> maybeSource, org.reactivestreams.Publisher<U> publisher) {
        super(maybeSource);
        this.n = publisher;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher.OtherSubscriber(maybeObserver, this.source));
    }
}
