package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableDefer extends io.reactivex.Completable {
    public final java.util.concurrent.Callable<? extends io.reactivex.CompletableSource> n;

    public CompletableDefer(java.util.concurrent.Callable<? extends io.reactivex.CompletableSource> callable) {
        this.n = callable;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        try {
            ((io.reactivex.CompletableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "The completableSupplier returned a null CompletableSource")).subscribe(completableObserver);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, completableObserver);
        }
    }
}
