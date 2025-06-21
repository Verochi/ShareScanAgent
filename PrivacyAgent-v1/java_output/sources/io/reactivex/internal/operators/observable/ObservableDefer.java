package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableDefer<T> extends io.reactivex.Observable<T> {
    public final java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<? extends T>> n;

    public ObservableDefer(java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<? extends T>> callable) {
        this.n = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        try {
            ((io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "null ObservableSource supplied")).subscribe(observer);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
        }
    }
}
