package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeIsEmpty<T> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, java.lang.Boolean> {

    public static final class IsEmptyMaybeObserver<T> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super java.lang.Boolean> n;
        public io.reactivex.disposables.Disposable t;

        public IsEmptyMaybeObserver(io.reactivex.MaybeObserver<? super java.lang.Boolean> maybeObserver) {
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

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.n.onSuccess(java.lang.Boolean.TRUE);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
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
            this.n.onSuccess(java.lang.Boolean.FALSE);
        }
    }

    public MaybeIsEmpty(io.reactivex.MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super java.lang.Boolean> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeIsEmpty.IsEmptyMaybeObserver(maybeObserver));
    }
}
