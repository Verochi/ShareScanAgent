package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableCountSingle<T> extends io.reactivex.Single<java.lang.Long> implements io.reactivex.internal.fuseable.FuseToObservable<java.lang.Long> {
    public final io.reactivex.ObservableSource<T> n;

    public static final class CountObserver implements io.reactivex.Observer<java.lang.Object>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super java.lang.Long> n;
        public io.reactivex.disposables.Disposable t;
        public long u;

        public CountObserver(io.reactivex.SingleObserver<? super java.lang.Long> singleObserver) {
            this.n = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.t.dispose();
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onSuccess(java.lang.Long.valueOf(this.u));
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
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

    public ObservableCountSingle(io.reactivex.ObservableSource<T> observableSource) {
        this.n = observableSource;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public io.reactivex.Observable<java.lang.Long> fuseToObservable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableCount(this.n));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super java.lang.Long> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableCountSingle.CountObserver(singleObserver));
    }
}
