package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableLastSingle<T> extends io.reactivex.Single<T> {
    public final io.reactivex.ObservableSource<T> n;
    public final T t;

    public static final class LastObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super T> n;
        public final T t;
        public io.reactivex.disposables.Disposable u;
        public T v;

        public LastObserver(io.reactivex.SingleObserver<? super T> singleObserver, T t) {
            this.n = singleObserver;
            this.t = t;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.dispose();
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            T t = this.v;
            if (t != null) {
                this.v = null;
                this.n.onSuccess(t);
                return;
            }
            T t2 = this.t;
            if (t2 != null) {
                this.n.onSuccess(t2);
            } else {
                this.n.onError(new java.util.NoSuchElementException());
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.v = null;
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.v = t;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableLastSingle(io.reactivex.ObservableSource<T> observableSource, T t) {
        this.n = observableSource;
        this.t = t;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableLastSingle.LastObserver(singleObserver, this.t));
    }
}
