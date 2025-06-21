package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeCount<T> extends io.reactivex.Single<java.lang.Long> implements io.reactivex.internal.fuseable.HasUpstreamMaybeSource<T> {
    public final io.reactivex.MaybeSource<T> n;

    public static final class CountMaybeObserver implements io.reactivex.MaybeObserver<java.lang.Object>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super java.lang.Long> n;
        public io.reactivex.disposables.Disposable t;

        public CountMaybeObserver(io.reactivex.SingleObserver<? super java.lang.Long> singleObserver) {
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
            this.n.onSuccess(0L);
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
        public void onSuccess(java.lang.Object obj) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onSuccess(1L);
        }
    }

    public MaybeCount(io.reactivex.MaybeSource<T> maybeSource) {
        this.n = maybeSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public io.reactivex.MaybeSource<T> source() {
        return this.n;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super java.lang.Long> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.maybe.MaybeCount.CountMaybeObserver(singleObserver));
    }
}
