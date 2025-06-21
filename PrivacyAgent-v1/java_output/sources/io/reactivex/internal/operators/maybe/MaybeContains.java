package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeContains<T> extends io.reactivex.Single<java.lang.Boolean> implements io.reactivex.internal.fuseable.HasUpstreamMaybeSource<T> {
    public final io.reactivex.MaybeSource<T> n;
    public final java.lang.Object t;

    public static final class ContainsMaybeObserver implements io.reactivex.MaybeObserver<java.lang.Object>, io.reactivex.disposables.Disposable {
        public final io.reactivex.SingleObserver<? super java.lang.Boolean> n;
        public final java.lang.Object t;
        public io.reactivex.disposables.Disposable u;

        public ContainsMaybeObserver(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver, java.lang.Object obj) {
            this.n = singleObserver;
            this.t = obj;
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
            this.n.onSuccess(java.lang.Boolean.FALSE);
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
        public void onSuccess(java.lang.Object obj) {
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onSuccess(java.lang.Boolean.valueOf(io.reactivex.internal.functions.ObjectHelper.equals(obj, this.t)));
        }
    }

    public MaybeContains(io.reactivex.MaybeSource<T> maybeSource, java.lang.Object obj) {
        this.n = maybeSource;
        this.t = obj;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public io.reactivex.MaybeSource<T> source() {
        return this.n;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.maybe.MaybeContains.ContainsMaybeObserver(singleObserver, this.t));
    }
}
