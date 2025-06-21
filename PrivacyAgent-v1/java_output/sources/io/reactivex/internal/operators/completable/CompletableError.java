package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableError extends io.reactivex.Completable {
    public final java.lang.Throwable n;

    public CompletableError(java.lang.Throwable th) {
        this.n = th;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.internal.disposables.EmptyDisposable.error(this.n, completableObserver);
    }
}
