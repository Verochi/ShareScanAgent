package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableErrorSupplier extends io.reactivex.Completable {
    public final java.util.concurrent.Callable<? extends java.lang.Throwable> n;

    public CompletableErrorSupplier(java.util.concurrent.Callable<? extends java.lang.Throwable> callable) {
        this.n = callable;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        try {
            th = (java.lang.Throwable) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "The error returned is null");
        } catch (java.lang.Throwable th) {
            th = th;
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
        }
        io.reactivex.internal.disposables.EmptyDisposable.error(th, completableObserver);
    }
}
