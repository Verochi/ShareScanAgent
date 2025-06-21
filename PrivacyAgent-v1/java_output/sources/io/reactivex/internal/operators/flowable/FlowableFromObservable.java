package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableFromObservable<T> extends io.reactivex.Flowable<T> {
    public final io.reactivex.Observable<T> t;

    public static final class SubscriberObserver<T> implements io.reactivex.Observer<T>, org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super T> n;
        public io.reactivex.disposables.Disposable t;

        public SubscriberObserver(org.reactivestreams.Subscriber<? super T> subscriber) {
            this.n = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.t.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.n.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.t = disposable;
            this.n.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
        }
    }

    public FlowableFromObservable(io.reactivex.Observable<T> observable) {
        this.t = observable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.t.subscribe(new io.reactivex.internal.operators.flowable.FlowableFromObservable.SubscriberObserver(subscriber));
    }
}
