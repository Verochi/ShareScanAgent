package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeFromFuture<T> extends io.reactivex.Maybe<T> {
    public final java.util.concurrent.Future<? extends T> n;
    public final long t;
    public final java.util.concurrent.TimeUnit u;

    public MaybeFromFuture(java.util.concurrent.Future<? extends T> future, long j, java.util.concurrent.TimeUnit timeUnit) {
        this.n = future;
        this.t = j;
        this.u = timeUnit;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        io.reactivex.disposables.Disposable empty = io.reactivex.disposables.Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (empty.isDisposed()) {
            return;
        }
        try {
            long j = this.t;
            T t = j <= 0 ? this.n.get() : this.n.get(j, this.u);
            if (empty.isDisposed()) {
                return;
            }
            if (t == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(t);
            }
        } catch (java.lang.Throwable th) {
            th = th;
            if (th instanceof java.util.concurrent.ExecutionException) {
                th = th.getCause();
            }
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            if (empty.isDisposed()) {
                return;
            }
            maybeObserver.onError(th);
        }
    }
}
