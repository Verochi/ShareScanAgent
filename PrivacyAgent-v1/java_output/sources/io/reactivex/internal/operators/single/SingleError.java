package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleError<T> extends io.reactivex.Single<T> {
    public final java.util.concurrent.Callable<? extends java.lang.Throwable> n;

    public SingleError(java.util.concurrent.Callable<? extends java.lang.Throwable> callable) {
        this.n = callable;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        try {
            th = (java.lang.Throwable) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (java.lang.Throwable th) {
            th = th;
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
        }
        io.reactivex.internal.disposables.EmptyDisposable.error(th, singleObserver);
    }
}
