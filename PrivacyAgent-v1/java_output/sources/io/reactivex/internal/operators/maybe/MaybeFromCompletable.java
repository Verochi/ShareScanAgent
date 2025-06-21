package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeFromCompletable<T> extends io.reactivex.Maybe<T> implements io.reactivex.internal.fuseable.HasUpstreamCompletableSource {
    public final io.reactivex.CompletableSource n;

    public static final class FromCompletableObserver<T> implements io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public io.reactivex.disposables.Disposable t;

        public FromCompletableObserver(io.reactivex.MaybeObserver<? super T> maybeObserver) {
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

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public MaybeFromCompletable(io.reactivex.CompletableSource completableSource) {
        this.n = completableSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamCompletableSource
    public io.reactivex.CompletableSource source() {
        return this.n;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.maybe.MaybeFromCompletable.FromCompletableObserver(maybeObserver));
    }
}
