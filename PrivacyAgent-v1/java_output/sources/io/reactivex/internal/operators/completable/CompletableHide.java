package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableHide extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;

    public static final class HideCompletableObserver implements io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable {
        public final io.reactivex.CompletableObserver n;
        public io.reactivex.disposables.Disposable t;

        public HideCompletableObserver(io.reactivex.CompletableObserver completableObserver) {
            this.n = completableObserver;
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
            this.n.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
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

    public CompletableHide(io.reactivex.CompletableSource completableSource) {
        this.n = completableSource;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableHide.HideCompletableObserver(completableObserver));
    }
}
