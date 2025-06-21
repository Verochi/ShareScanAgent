package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeIsEmptySingle<T> extends io.reactivex.Single<java.lang.Boolean> implements io.reactivex.internal.fuseable.HasUpstreamMaybeSource<T>, io.reactivex.internal.fuseable.FuseToMaybe<java.lang.Boolean> {
    public final io.reactivex.MaybeSource<T> n;

    public static final class IsEmptyMaybeObserver<T> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super java.lang.Boolean> n;
        public io.reactivex.disposables.Disposable t;

        public IsEmptyMaybeObserver(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver) {
            this.n = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.t.dispose();
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onSuccess(java.lang.Boolean.TRUE);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onSuccess(java.lang.Boolean.FALSE);
        }
    }

    public MaybeIsEmptySingle(io.reactivex.MaybeSource<T> maybeSource) {
        this.n = maybeSource;
    }

    @Override // io.reactivex.internal.fuseable.FuseToMaybe
    public io.reactivex.Maybe<java.lang.Boolean> fuseToMaybe() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeIsEmpty(this.n));
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public io.reactivex.MaybeSource<T> source() {
        return this.n;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.maybe.MaybeIsEmptySingle.IsEmptyMaybeObserver(singleObserver));
    }
}
