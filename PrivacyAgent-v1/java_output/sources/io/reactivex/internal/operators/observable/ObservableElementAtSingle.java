package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableElementAtSingle<T> extends io.reactivex.Single<T> implements io.reactivex.internal.fuseable.FuseToObservable<T> {
    public final io.reactivex.ObservableSource<T> n;
    public final long t;
    public final T u;

    public static final class ElementAtObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super T> n;
        public final long t;
        public final T u;
        public io.reactivex.disposables.Disposable v;
        public long w;
        public boolean x;

        public ElementAtObserver(io.reactivex.SingleObserver<? super T> singleObserver, long j, T t) {
            this.n = singleObserver;
            this.t = j;
            this.u = t;
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
            if (this.x) {
                return;
            }
            this.x = true;
            T t = this.u;
            if (t != null) {
                this.n.onSuccess(t);
            } else {
                this.n.onError(new java.util.NoSuchElementException());
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.x) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.x = true;
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.x) {
                return;
            }
            long j = this.w;
            if (j != this.t) {
                this.w = j + 1;
                return;
            }
            this.x = true;
            this.v.dispose();
            this.n.onSuccess(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.v, disposable)) {
                this.v = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtSingle(io.reactivex.ObservableSource<T> observableSource, long j, T t) {
        this.n = observableSource;
        this.t = j;
        this.u = t;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public io.reactivex.Observable<T> fuseToObservable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableElementAt(this.n, this.t, this.u, true));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableElementAtSingle.ElementAtObserver(singleObserver, this.t, this.u));
    }
}
