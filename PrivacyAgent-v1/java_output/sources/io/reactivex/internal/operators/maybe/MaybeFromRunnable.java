package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeFromRunnable<T> extends io.reactivex.Maybe<T> implements java.util.concurrent.Callable<T> {
    public final java.lang.Runnable n;

    public MaybeFromRunnable(java.lang.Runnable runnable) {
        this.n = runnable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws java.lang.Exception {
        this.n.run();
        return null;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        io.reactivex.disposables.Disposable empty = io.reactivex.disposables.Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (empty.isDisposed()) {
            return;
        }
        try {
            this.n.run();
            if (empty.isDisposed()) {
                return;
            }
            maybeObserver.onComplete();
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            if (empty.isDisposed()) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                maybeObserver.onError(th);
            }
        }
    }
}
