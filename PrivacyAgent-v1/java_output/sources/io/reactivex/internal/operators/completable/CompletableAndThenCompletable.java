package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableAndThenCompletable extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;
    public final io.reactivex.CompletableSource t;

    public static final class NextObserver implements io.reactivex.CompletableObserver {
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> n;
        public final io.reactivex.CompletableObserver t;

        public NextObserver(java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference, io.reactivex.CompletableObserver completableObserver) {
            this.n = atomicReference;
            this.t = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.t.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            this.t.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.replace(this.n, disposable);
        }
    }

    public static final class SourceObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -4101678820158072998L;
        final io.reactivex.CompletableObserver actualObserver;
        final io.reactivex.CompletableSource next;

        public SourceObserver(io.reactivex.CompletableObserver completableObserver, io.reactivex.CompletableSource completableSource) {
            this.actualObserver = completableObserver;
            this.next = completableSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.next.subscribe(new io.reactivex.internal.operators.completable.CompletableAndThenCompletable.NextObserver(this, this.actualObserver));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            this.actualObserver.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable)) {
                this.actualObserver.onSubscribe(this);
            }
        }
    }

    public CompletableAndThenCompletable(io.reactivex.CompletableSource completableSource, io.reactivex.CompletableSource completableSource2) {
        this.n = completableSource;
        this.t = completableSource2;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableAndThenCompletable.SourceObserver(completableObserver, this.t));
    }
}
