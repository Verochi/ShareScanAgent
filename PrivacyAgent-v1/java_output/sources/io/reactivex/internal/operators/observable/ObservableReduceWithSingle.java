package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableReduceWithSingle<T, R> extends io.reactivex.Single<R> {
    public final io.reactivex.ObservableSource<T> n;
    public final java.util.concurrent.Callable<R> t;
    public final io.reactivex.functions.BiFunction<R, ? super T, R> u;

    public ObservableReduceWithSingle(io.reactivex.ObservableSource<T> observableSource, java.util.concurrent.Callable<R> callable, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        this.n = observableSource;
        this.t = callable;
        this.u = biFunction;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super R> singleObserver) {
        try {
            this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.u, io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The seedSupplier returned a null value")));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, singleObserver);
        }
    }
}
