package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableFromCallable<T> extends io.reactivex.Observable<T> implements java.util.concurrent.Callable<T> {
    public final java.util.concurrent.Callable<? extends T> n;

    public ObservableFromCallable(java.util.concurrent.Callable<? extends T> callable) {
        this.n = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws java.lang.Exception {
        return (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "The callable returned a null value");
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
            deferredScalarDisposable.complete(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "Callable returned null"));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            if (deferredScalarDisposable.isDisposed()) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                observer.onError(th);
            }
        }
    }
}
