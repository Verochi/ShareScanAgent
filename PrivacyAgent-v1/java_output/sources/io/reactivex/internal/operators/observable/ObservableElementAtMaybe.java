package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableElementAtMaybe<T> extends io.reactivex.Maybe<T> implements io.reactivex.internal.fuseable.FuseToObservable<T> {
    public final io.reactivex.ObservableSource<T> n;
    public final long t;

    public static final class ElementAtObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public final long t;
        public io.reactivex.disposables.Disposable u;
        public long v;
        public boolean w;

        public ElementAtObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, long j) {
            this.n = maybeObserver;
            this.t = j;
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

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.w) {
                return;
            }
            long j = this.v;
            if (j != this.t) {
                this.v = j + 1;
                return;
            }
            this.w = true;
            this.u.dispose();
            this.n.onSuccess(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtMaybe(io.reactivex.ObservableSource<T> observableSource, long j) {
        this.n = observableSource;
        this.t = j;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public io.reactivex.Observable<T> fuseToObservable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableElementAt(this.n, this.t, null, false));
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableElementAtMaybe.ElementAtObserver(maybeObserver, this.t));
    }
}
