package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleJust<T> extends io.reactivex.Single<T> {
    public final T n;

    public SingleJust(T t) {
        this.n = t;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(io.reactivex.disposables.Disposables.disposed());
        singleObserver.onSuccess(this.n);
    }
}
