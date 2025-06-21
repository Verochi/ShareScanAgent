package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableCount<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, java.lang.Long> {

    public static final class CountObserver implements io.reactivex.Observer<java.lang.Object>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super java.lang.Long> n;
        public io.reactivex.disposables.Disposable t;
        public long u;

        public CountObserver(io.reactivex.Observer<? super java.lang.Long> observer) {
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
            this.n.onNext(java.lang.Long.valueOf(this.u));
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(java.lang.Object obj) {
            this.u++;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableCount(io.reactivex.ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super java.lang.Long> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableCount.CountObserver(observer));
    }
}
