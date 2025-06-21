package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableReduceSeedSingle<T, R> extends io.reactivex.Single<R> {
    public final io.reactivex.ObservableSource<T> n;
    public final R t;
    public final io.reactivex.functions.BiFunction<R, ? super T, R> u;

    public static final class ReduceSeedObserver<T, R> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super R> n;
        public final io.reactivex.functions.BiFunction<R, ? super T, R> t;
        public R u;
        public io.reactivex.disposables.Disposable v;

        public ReduceSeedObserver(io.reactivex.SingleObserver<? super R> singleObserver, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction, R r) {
            this.n = singleObserver;
            this.u = r;
            this.t = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.v.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            R r = this.u;
            if (r != null) {
                this.u = null;
                this.n.onSuccess(r);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.u == null) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.u = null;
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            R r = this.u;
            if (r != null) {
                try {
                    this.u = (R) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(r, t), "The reducer returned a null value");
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.v.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.v, disposable)) {
                this.v = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableReduceSeedSingle(io.reactivex.ObservableSource<T> observableSource, R r, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        this.n = observableSource;
        this.t = r;
        this.u = biFunction;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super R> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.u, this.t));
    }
}
