package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleLift<T, R> extends io.reactivex.Single<R> {
    public final io.reactivex.SingleSource<T> n;
    public final io.reactivex.SingleOperator<? extends R, ? super T> t;

    public SingleLift(io.reactivex.SingleSource<T> singleSource, io.reactivex.SingleOperator<? extends R, ? super T> singleOperator) {
        this.n = singleSource;
        this.t = singleOperator;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super R> singleObserver) {
        try {
            this.n.subscribe((io.reactivex.SingleObserver) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(singleObserver), "The onLift returned a null SingleObserver"));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, singleObserver);
        }
    }
}
