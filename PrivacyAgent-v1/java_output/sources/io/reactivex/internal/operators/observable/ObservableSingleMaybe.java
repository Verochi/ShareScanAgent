package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableSingleMaybe<T> extends io.reactivex.Maybe<T> {
    public final io.reactivex.ObservableSource<T> n;

    public static final class SingleElementObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public io.reactivex.disposables.Disposable t;
        public T u;
        public boolean v;

        public SingleElementObserver(io.reactivex.MaybeObserver<? super T> maybeObserver) {
            this.n = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.t.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.v) {
                return;
            }
            this.v = true;
            T t = this.u;
            this.u = null;
            if (t == null) {
                this.n.onComplete();
            } else {
                this.n.onSuccess(t);
            }
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
            if (this.u == null) {
                this.u = t;
                return;
            }
            this.v = true;
            this.t.dispose();
            this.n.onError(new java.lang.IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableSingleMaybe(io.reactivex.ObservableSource<T> observableSource) {
        this.n = observableSource;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableSingleMaybe.SingleElementObserver(maybeObserver));
    }
}
