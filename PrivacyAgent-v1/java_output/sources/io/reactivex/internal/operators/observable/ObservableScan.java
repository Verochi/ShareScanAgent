package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableScan<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.functions.BiFunction<T, T, T> n;

    public static final class ScanObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public final io.reactivex.functions.BiFunction<T, T, T> t;
        public io.reactivex.disposables.Disposable u;
        public T v;
        public boolean w;

        public ScanObserver(io.reactivex.Observer<? super T> observer, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
            this.n = observer;
            this.t = biFunction;
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

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.w) {
                return;
            }
            io.reactivex.Observer<? super T> observer = this.n;
            T t2 = this.v;
            if (t2 == null) {
                this.v = t;
                observer.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t2, t), "The value returned by the accumulator is null");
                this.v = r4;
                observer.onNext(r4);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.u.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableScan(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.n = biFunction;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableScan.ScanObserver(observer, this.n));
    }
}
