package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableReduceWithSingle<T, R> extends io.reactivex.Single<R> {
    public final org.reactivestreams.Publisher<T> n;
    public final java.util.concurrent.Callable<R> t;
    public final io.reactivex.functions.BiFunction<R, ? super T, R> u;

    public FlowableReduceWithSingle(org.reactivestreams.Publisher<T> publisher, java.util.concurrent.Callable<R> callable, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        this.n = publisher;
        this.t = callable;
        this.u = biFunction;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super R> singleObserver) {
        try {
            this.n.subscribe(new io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.u, io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The seedSupplier returned a null value")));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, singleObserver);
        }
    }
}
