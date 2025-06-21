package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableDoOnLifecycle<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> n;
    public final io.reactivex.functions.Action t;

    public ObservableDoOnLifecycle(io.reactivex.Observable<T> observable, io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer, io.reactivex.functions.Action action) {
        super(observable);
        this.n = consumer;
        this.t = action;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.observers.DisposableLambdaObserver(observer, this.n, this.t));
    }
}
