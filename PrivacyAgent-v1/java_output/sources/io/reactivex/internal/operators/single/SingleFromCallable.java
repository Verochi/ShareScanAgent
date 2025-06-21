package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleFromCallable<T> extends io.reactivex.Single<T> {
    public final java.util.concurrent.Callable<? extends T> n;

    public SingleFromCallable(java.util.concurrent.Callable<? extends T> callable) {
        this.n = callable;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        io.reactivex.disposables.Disposable empty = io.reactivex.disposables.Disposables.empty();
        singleObserver.onSubscribe(empty);
        if (empty.isDisposed()) {
            return;
        }
        try {
            defpackage.a aVar = (java.lang.Object) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.call(), "The callable returned a null value");
            if (empty.isDisposed()) {
                return;
            }
            singleObserver.onSuccess(aVar);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            if (empty.isDisposed()) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                singleObserver.onError(th);
            }
        }
    }
}
