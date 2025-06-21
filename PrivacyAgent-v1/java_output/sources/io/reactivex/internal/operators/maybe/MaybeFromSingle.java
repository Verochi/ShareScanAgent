package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeFromSingle<T> extends io.reactivex.Maybe<T> implements io.reactivex.internal.fuseable.HasUpstreamSingleSource<T> {
    public final io.reactivex.SingleSource<T> n;

    public static final class FromSingleObserver<T> implements io.reactivex.SingleObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public io.reactivex.disposables.Disposable t;

        public FromSingleObserver(io.reactivex.MaybeObserver<? super T> maybeObserver) {
            this.n = maybeObserver;
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

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onSuccess(t);
        }
    }

    public MaybeFromSingle(io.reactivex.SingleSource<T> singleSource) {
        this.n = singleSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamSingleSource
    public io.reactivex.SingleSource<T> source() {
        return this.n;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.maybe.MaybeFromSingle.FromSingleObserver(maybeObserver));
    }
}
