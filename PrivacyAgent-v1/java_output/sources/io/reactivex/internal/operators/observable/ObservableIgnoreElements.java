package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableIgnoreElements<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {

    public static final class IgnoreObservable<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public io.reactivex.disposables.Disposable t;

        public IgnoreObservable(io.reactivex.Observer<? super T> observer) {
            this.n = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.t.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.t = disposable;
            this.n.onSubscribe(this);
        }
    }

    public ObservableIgnoreElements(io.reactivex.ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableIgnoreElements.IgnoreObservable(observer));
    }
}
