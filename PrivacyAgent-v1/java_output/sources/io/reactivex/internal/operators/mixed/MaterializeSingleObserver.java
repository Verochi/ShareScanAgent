package io.reactivex.internal.operators.mixed;

@io.reactivex.annotations.Experimental
/* loaded from: classes11.dex */
public final class MaterializeSingleObserver<T> implements io.reactivex.SingleObserver<T>, io.reactivex.MaybeObserver<T>, io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable {
    public final io.reactivex.SingleObserver<? super io.reactivex.Notification<T>> n;
    public io.reactivex.disposables.Disposable t;

    public MaterializeSingleObserver(io.reactivex.SingleObserver<? super io.reactivex.Notification<T>> singleObserver) {
        this.n = singleObserver;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.t.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.t.isDisposed();
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        this.n.onSuccess(io.reactivex.Notification.createOnComplete());
    }

    @Override // io.reactivex.SingleObserver
    public void onError(java.lang.Throwable th) {
        this.n.onSuccess(io.reactivex.Notification.createOnError(th));
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
            this.t = disposable;
            this.n.onSubscribe(this);
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        this.n.onSuccess(io.reactivex.Notification.createOnNext(t));
    }
}
