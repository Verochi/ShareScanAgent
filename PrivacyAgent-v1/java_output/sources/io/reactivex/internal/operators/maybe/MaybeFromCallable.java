package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeFromCallable<T> extends io.reactivex.Maybe<T> implements java.util.concurrent.Callable<T> {
    public final java.util.concurrent.Callable<? extends T> n;

    public MaybeFromCallable(java.util.concurrent.Callable<? extends T> callable) {
        this.n = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws java.lang.Exception {
        return this.n.call();
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        io.reactivex.disposables.Disposable empty = io.reactivex.disposables.Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (empty.isDisposed()) {
            return;
        }
        try {
            T call = this.n.call();
            if (empty.isDisposed()) {
                return;
            }
            if (call == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(call);
            }
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
