package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleFromPublisher<T> extends io.reactivex.Single<T> {
    public final org.reactivestreams.Publisher<? extends T> n;

    public static final class ToSingleObserver<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super T> n;
        public org.reactivestreams.Subscription t;
        public T u;
        public boolean v;
        public volatile boolean w;

        public ToSingleObserver(io.reactivex.SingleObserver<? super T> singleObserver) {
            this.n = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.w = true;
            this.t.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.v) {
                return;
            }
            this.v = true;
            T t = this.u;
            this.u = null;
            if (t == null) {
                this.n.onError(new java.util.NoSuchElementException("The source Publisher is empty"));
            } else {
                this.n.onSuccess(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (this.v) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.v = true;
            this.u = null;
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.v) {
                return;
            }
            if (this.u == null) {
                this.u = t;
                return;
            }
            this.t.cancel();
            this.v = true;
            this.u = null;
            this.n.onError(new java.lang.IndexOutOfBoundsException("Too many elements in the Publisher"));
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

    public SingleFromPublisher(org.reactivestreams.Publisher<? extends T> publisher) {
        this.n = publisher;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleFromPublisher.ToSingleObserver(singleObserver));
    }
}
