package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleFromUnsafeSource<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<T> n;

    public SingleFromUnsafeSource(io.reactivex.SingleSource<T> singleSource) {
        this.n = singleSource;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(singleObserver);
    }
}
