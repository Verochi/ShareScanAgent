package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableToListSingle<T, U extends java.util.Collection<? super T>> extends io.reactivex.Single<U> implements io.reactivex.internal.fuseable.FuseToObservable<U> {
    public final io.reactivex.ObservableSource<T> n;
    public final java.util.concurrent.Callable<U> t;

    public static final class ToListObserver<T, U extends java.util.Collection<? super T>> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super U> n;
        public U t;
        public io.reactivex.disposables.Disposable u;

        public ToListObserver(io.reactivex.SingleObserver<? super U> singleObserver, U u) {
            this.n = singleObserver;
            this.t = u;
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
            U u = this.t;
            this.t = null;
            this.n.onSuccess(u);
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.t = null;
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.t.add(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableToListSingle(io.reactivex.ObservableSource<T> observableSource, int i) {
        this.n = observableSource;
        this.t = io.reactivex.internal.functions.Functions.createArrayList(i);
    }

    public ObservableToListSingle(io.reactivex.ObservableSource<T> observableSource, java.util.concurrent.Callable<U> callable) {
        this.n = observableSource;
        this.t = callable;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public io.reactivex.Observable<U> fuseToObservable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableToList(this.n, this.t));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super U> singleObserver) {
        try {
            this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableToListSingle.ToListObserver(singleObserver, (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, singleObserver);
        }
    }
}
