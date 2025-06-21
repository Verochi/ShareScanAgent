package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableLastMaybe<T> extends io.reactivex.Maybe<T> {
    public final io.reactivex.ObservableSource<T> n;

    public static final class LastObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public io.reactivex.disposables.Disposable t;
        public T u;

        public LastObserver(io.reactivex.MaybeObserver<? super T> maybeObserver) {
            this.n = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.t.dispose();
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            T t = this.u;
            if (t == null) {
                this.n.onComplete();
            } else {
                this.u = null;
                this.n.onSuccess(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.u = null;
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.u = t;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableLastMaybe(io.reactivex.ObservableSource<T> observableSource) {
        this.n = observableSource;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableLastMaybe.LastObserver(maybeObserver));
    }
}
