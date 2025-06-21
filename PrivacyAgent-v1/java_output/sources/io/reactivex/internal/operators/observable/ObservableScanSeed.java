package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableScanSeed<T, R> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, R> {
    public final io.reactivex.functions.BiFunction<R, ? super T, R> n;
    public final java.util.concurrent.Callable<R> t;

    public static final class ScanSeedObserver<T, R> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super R> n;
        public final io.reactivex.functions.BiFunction<R, ? super T, R> t;
        public R u;
        public io.reactivex.disposables.Disposable v;
        public boolean w;

        public ScanSeedObserver(io.reactivex.Observer<? super R> observer, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction, R r) {
            this.n = observer;
            this.t = biFunction;
            this.u = r;
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
            if (this.w) {
                return;
            }
            this.w = true;
            this.n.onComplete();
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
            try {
                R r = (R) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(this.u, t), "The accumulator returned a null value");
                this.u = r;
                this.n.onNext(r);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.v.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.v, disposable)) {
                this.v = disposable;
                this.n.onSubscribe(this);
                this.n.onNext(this.u);
            }
        }
    }

    public ObservableScanSeed(io.reactivex.ObservableSource<T> observableSource, java.util.concurrent.Callable<R> callable, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        super(observableSource);
        this.n = biFunction;
        this.t = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        try {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableScanSeed.ScanSeedObserver(observer, this.n, io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The seed supplied is null")));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
        }
    }
}
