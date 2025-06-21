package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableFromPublisher<T> extends io.reactivex.Observable<T> {
    public final org.reactivestreams.Publisher<? extends T> n;

    public static final class PublisherSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public org.reactivestreams.Subscription t;

        public PublisherSubscriber(io.reactivex.Observer<? super T> observer) {
            this.n = observer;
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
            this.n.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.n.onNext(t);
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

    public ObservableFromPublisher(org.reactivestreams.Publisher<? extends T> publisher) {
        this.n = publisher;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableFromPublisher.PublisherSubscriber(observer));
    }
}
