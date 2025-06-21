package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public final class ResumeSingleObserver<T> implements io.reactivex.SingleObserver<T> {
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> n;
    public final io.reactivex.SingleObserver<? super T> t;

    public ResumeSingleObserver(java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference, io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n = atomicReference;
        this.t = singleObserver;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(java.lang.Throwable th) {
        this.t.onError(th);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        io.reactivex.internal.disposables.DisposableHelper.replace(this.n, disposable);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        this.t.onSuccess(t);
    }
}
