package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableError<T> extends io.reactivex.Observable<T> {
    public final java.util.concurrent.Callable<? extends java.lang.Throwable> n;

    public ObservableError(java.util.concurrent.Callable<? extends java.lang.Throwable> callable) {
        this.n = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        try {
            th = (java.lang.Throwable) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (java.lang.Throwable th) {
            th = th;
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
        }
        io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
    }
}
