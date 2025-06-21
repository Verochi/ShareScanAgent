package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableAutoConnect<T> extends io.reactivex.Observable<T> {
    public final io.reactivex.observables.ConnectableObservable<? extends T> n;
    public final int t;
    public final io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> u;
    public final java.util.concurrent.atomic.AtomicInteger v = new java.util.concurrent.atomic.AtomicInteger();

    public ObservableAutoConnect(io.reactivex.observables.ConnectableObservable<? extends T> connectableObservable, int i, io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        this.n = connectableObservable;
        this.t = i;
        this.u = consumer;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.n.subscribe((io.reactivex.Observer<? super java.lang.Object>) observer);
        if (this.v.incrementAndGet() == this.t) {
            this.n.connect(this.u);
        }
    }
}
