package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableJust<T> extends io.reactivex.Observable<T> implements io.reactivex.internal.fuseable.ScalarCallable<T> {
    public final T n;

    public ObservableJust(T t) {
        this.n = t;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return this.n;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.operators.observable.ObservableScalarXMap.ScalarDisposable scalarDisposable = new io.reactivex.internal.operators.observable.ObservableScalarXMap.ScalarDisposable(observer, this.n);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
