package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableCollectSingle<T, U> extends io.reactivex.Single<U> implements io.reactivex.internal.fuseable.FuseToObservable<U> {
    public final io.reactivex.ObservableSource<T> n;
    public final java.util.concurrent.Callable<? extends U> t;
    public final io.reactivex.functions.BiConsumer<? super U, ? super T> u;

    public static final class CollectObserver<T, U> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super U> n;
        public final io.reactivex.functions.BiConsumer<? super U, ? super T> t;
        public final U u;
        public io.reactivex.disposables.Disposable v;
        public boolean w;

        public CollectObserver(io.reactivex.SingleObserver<? super U> singleObserver, U u, io.reactivex.functions.BiConsumer<? super U, ? super T> biConsumer) {
            this.n = singleObserver;
            this.t = biConsumer;
            this.u = u;
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
            this.n.onSuccess(this.u);
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
                this.t.accept(this.u, t);
            } catch (java.lang.Throwable th) {
                this.v.dispose();
                onError(th);
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

    public ObservableCollectSingle(io.reactivex.ObservableSource<T> observableSource, java.util.concurrent.Callable<? extends U> callable, io.reactivex.functions.BiConsumer<? super U, ? super T> biConsumer) {
        this.n = observableSource;
        this.t = callable;
        this.u = biConsumer;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public io.reactivex.Observable<U> fuseToObservable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableCollect(this.n, this.t, this.u));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super U> singleObserver) {
        try {
            this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableCollectSingle.CollectObserver(singleObserver, io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The initialSupplier returned a null value"), this.u));
        } catch (java.lang.Throwable th) {
            io.reactivex.internal.disposables.EmptyDisposable.error(th, singleObserver);
        }
    }
}
