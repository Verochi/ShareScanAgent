package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public enum EmptyComponent implements io.reactivex.FlowableSubscriber<java.lang.Object>, io.reactivex.Observer<java.lang.Object>, io.reactivex.MaybeObserver<java.lang.Object>, io.reactivex.SingleObserver<java.lang.Object>, io.reactivex.CompletableObserver, org.reactivestreams.Subscription, io.reactivex.disposables.Disposable {
    INSTANCE;

    public static <T> io.reactivex.Observer<T> asObserver() {
        return INSTANCE;
    }

    public static <T> org.reactivestreams.Subscriber<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        io.reactivex.plugins.RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(java.lang.Object obj) {
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        disposable.dispose();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        subscription.cancel();
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(java.lang.Object obj) {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }
}
