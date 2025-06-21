package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableFromRunnable extends io.reactivex.Completable {
    public final java.lang.Runnable n;

    public CompletableFromRunnable(java.lang.Runnable runnable) {
        this.n = runnable;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.disposables.Disposable empty = io.reactivex.disposables.Disposables.empty();
        completableObserver.onSubscribe(empty);
        try {
            this.n.run();
            if (empty.isDisposed()) {
                return;
            }
            completableObserver.onComplete();
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            if (empty.isDisposed()) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                completableObserver.onError(th);
            }
        }
    }
}
