package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableFromUnsafeSource<T> extends io.reactivex.Observable<T> {
    public final io.reactivex.ObservableSource<T> n;

    public ObservableFromUnsafeSource(io.reactivex.ObservableSource<T> observableSource) {
        this.n = observableSource;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.n.subscribe(observer);
    }
}
