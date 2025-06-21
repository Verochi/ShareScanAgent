package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeToSingle<T> extends io.reactivex.Single<T> implements io.reactivex.internal.fuseable.HasUpstreamMaybeSource<T> {
    public final io.reactivex.MaybeSource<T> n;
    public final T t;

    public static final class ToSingleMaybeSubscriber<T> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super T> n;
        public final T t;
        public io.reactivex.disposables.Disposable u;

        public ToSingleMaybeSubscriber(io.reactivex.SingleObserver<? super T> singleObserver, T t) {
            this.n = singleObserver;
            this.t = t;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.dispose();
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            T t = this.t;
            if (t != null) {
                this.n.onSuccess(t);
            } else {
                this.n.onError(new java.util.NoSuchElementException("The MaybeSource is empty"));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onSuccess(t);
        }
    }

    public MaybeToSingle(io.reactivex.MaybeSource<T> maybeSource, T t) {
        this.n = maybeSource;
        this.t = t;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public io.reactivex.MaybeSource<T> source() {
        return this.n;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.maybe.MaybeToSingle.ToSingleMaybeSubscriber(singleObserver, this.t));
    }
}
