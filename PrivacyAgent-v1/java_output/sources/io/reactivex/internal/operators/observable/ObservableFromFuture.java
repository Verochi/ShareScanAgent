package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableFromFuture<T> extends io.reactivex.Observable<T> {
    public final java.util.concurrent.Future<? extends T> n;
    public final long t;
    public final java.util.concurrent.TimeUnit u;

    public ObservableFromFuture(java.util.concurrent.Future<? extends T> future, long j, java.util.concurrent.TimeUnit timeUnit) {
        this.n = future;
        this.t = j;
        this.u = timeUnit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.observers.DeferredScalarDisposable deferredScalarDisposable = new io.reactivex.internal.observers.DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            java.util.concurrent.TimeUnit timeUnit = this.u;
            deferredScalarDisposable.complete(io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit != null ? this.n.get(this.t, timeUnit) : this.n.get(), "Future returned null"));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            if (deferredScalarDisposable.isDisposed()) {
                return;
            }
            observer.onError(th);
        }
    }
}
