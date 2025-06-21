package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableObserveOn extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;
    public final io.reactivex.Scheduler t;

    public static final class ObserveOnCompletableObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable, java.lang.Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final io.reactivex.CompletableObserver downstream;
        java.lang.Throwable error;
        final io.reactivex.Scheduler scheduler;

        public ObserveOnCompletableObserver(io.reactivex.CompletableObserver completableObserver, io.reactivex.Scheduler scheduler) {
            this.downstream = completableObserver;
            this.scheduler = scheduler;
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
            io.reactivex.internal.disposables.DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            this.error = th;
            io.reactivex.internal.disposables.DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Throwable th = this.error;
            if (th == null) {
                this.downstream.onComplete();
            } else {
                this.error = null;
                this.downstream.onError(th);
            }
        }
    }

    public CompletableObserveOn(io.reactivex.CompletableSource completableSource, io.reactivex.Scheduler scheduler) {
        this.n = completableSource;
        this.t = scheduler;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableObserveOn.ObserveOnCompletableObserver(completableObserver, this.t));
    }
}
