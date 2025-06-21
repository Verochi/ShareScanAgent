package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeDefer<T> extends io.reactivex.Maybe<T> {
    public final java.util.concurrent.Callable<? extends io.reactivex.MaybeSource<? extends T>> n;

    public MaybeDefer(java.util.concurrent.Callable<? extends io.reactivex.MaybeSource<? extends T>> callable) {
        this.n = callable;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        try {
            ((io.reactivex.MaybeSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "The maybeSupplier returned a null MaybeSource")).subscribe(maybeObserver);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, maybeObserver);
        }
    }
}
