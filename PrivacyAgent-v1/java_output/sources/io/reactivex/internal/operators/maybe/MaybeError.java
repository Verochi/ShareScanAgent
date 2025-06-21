package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeError<T> extends io.reactivex.Maybe<T> {
    public final java.lang.Throwable n;

    public MaybeError(java.lang.Throwable th) {
        this.n = th;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(io.reactivex.disposables.Disposables.disposed());
        maybeObserver.onError(this.n);
    }
}
