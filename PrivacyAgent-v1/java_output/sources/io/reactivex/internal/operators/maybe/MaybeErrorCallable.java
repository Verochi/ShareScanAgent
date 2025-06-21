package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeErrorCallable<T> extends io.reactivex.Maybe<T> {
    public final java.util.concurrent.Callable<? extends java.lang.Throwable> n;

    public MaybeErrorCallable(java.util.concurrent.Callable<? extends java.lang.Throwable> callable) {
        this.n = callable;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(io.reactivex.disposables.Disposables.disposed());
        try {
            th = (java.lang.Throwable) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (java.lang.Throwable th) {
            th = th;
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
        }
        maybeObserver.onError(th);
    }
}
