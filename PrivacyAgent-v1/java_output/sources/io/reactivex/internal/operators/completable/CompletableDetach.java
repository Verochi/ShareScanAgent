package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableDetach extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;

    public static final class DetachCompletableObserver implements io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable {
        public io.reactivex.CompletableObserver n;
        public io.reactivex.disposables.Disposable t;

        public DetachCompletableObserver(io.reactivex.CompletableObserver completableObserver) {
            this.n = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.n = null;
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
            io.reactivex.CompletableObserver completableObserver = this.n;
            if (completableObserver != null) {
                this.n = null;
                completableObserver.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            this.t = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            io.reactivex.CompletableObserver completableObserver = this.n;
            if (completableObserver != null) {
                this.n = null;
                completableObserver.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public CompletableDetach(io.reactivex.CompletableSource completableSource) {
        this.n = completableSource;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableDetach.DetachCompletableObserver(completableObserver));
    }
}
