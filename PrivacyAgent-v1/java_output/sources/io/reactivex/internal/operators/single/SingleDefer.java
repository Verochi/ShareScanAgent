package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleDefer<T> extends io.reactivex.Single<T> {
    public final java.util.concurrent.Callable<? extends io.reactivex.SingleSource<? extends T>> n;

    public SingleDefer(java.util.concurrent.Callable<? extends io.reactivex.SingleSource<? extends T>> callable) {
        this.n = callable;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        try {
            ((io.reactivex.SingleSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "The singleSupplier returned a null SingleSource")).subscribe(singleObserver);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, singleObserver);
        }
    }
}
