package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public final class SubscriberCompletableObserver<T> implements io.reactivex.CompletableObserver, org.reactivestreams.Subscription {
    public final org.reactivestreams.Subscriber<? super T> n;
    public io.reactivex.disposables.Disposable t;

    public SubscriberCompletableObserver(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.n = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.t.dispose();
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        this.n.onComplete();
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(java.lang.Throwable th) {
        this.n.onError(th);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
            this.t = disposable;
            this.n.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }
}
