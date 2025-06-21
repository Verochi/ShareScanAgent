package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableSingleSingle<T> extends io.reactivex.Single<T> {
    public final io.reactivex.ObservableSource<? extends T> n;
    public final T t;

    public static final class SingleElementObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super T> n;
        public final T t;
        public io.reactivex.disposables.Disposable u;
        public T v;
        public boolean w;

        public SingleElementObserver(io.reactivex.SingleObserver<? super T> singleObserver, T t) {
            this.n = singleObserver;
            this.t = t;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.w) {
                return;
            }
            this.w = true;
            T t = this.v;
            this.v = null;
            if (t == null) {
                t = this.t;
            }
            if (t != null) {
                this.n.onSuccess(t);
            } else {
                this.n.onError(new java.util.NoSuchElementException());
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.w) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.w = true;
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.w) {
                return;
            }
            if (this.v == null) {
                this.v = t;
                return;
            }
            this.w = true;
            this.u.dispose();
            this.n.onError(new java.lang.IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableSingleSingle(io.reactivex.ObservableSource<? extends T> observableSource, T t) {
        this.n = observableSource;
        this.t = t;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableSingleSingle.SingleElementObserver(singleObserver, this.t));
    }
}
