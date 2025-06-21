package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableAllSingle<T> extends io.reactivex.Single<java.lang.Boolean> implements io.reactivex.internal.fuseable.FuseToObservable<java.lang.Boolean> {
    public final io.reactivex.ObservableSource<T> n;
    public final io.reactivex.functions.Predicate<? super T> t;

    public static final class AllObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super java.lang.Boolean> n;
        public final io.reactivex.functions.Predicate<? super T> t;
        public io.reactivex.disposables.Disposable u;
        public boolean v;

        public AllObserver(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver, io.reactivex.functions.Predicate<? super T> predicate) {
            this.n = singleObserver;
            this.t = predicate;
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
            if (this.v) {
                return;
            }
            this.v = true;
            this.n.onSuccess(java.lang.Boolean.TRUE);
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.v) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.v = true;
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.v) {
                return;
            }
            try {
                if (this.t.test(t)) {
                    return;
                }
                this.v = true;
                this.u.dispose();
                this.n.onSuccess(java.lang.Boolean.FALSE);
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

    public ObservableAllSingle(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Predicate<? super T> predicate) {
        this.n = observableSource;
        this.t = predicate;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public io.reactivex.Observable<java.lang.Boolean> fuseToObservable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableAll(this.n, this.t));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableAllSingle.AllObserver(singleObserver, this.t));
    }
}
