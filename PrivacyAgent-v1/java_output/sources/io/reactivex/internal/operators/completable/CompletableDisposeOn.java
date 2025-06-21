package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableDisposeOn extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;
    public final io.reactivex.Scheduler t;

    public static final class DisposeOnObserver implements io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable, java.lang.Runnable {
        public final io.reactivex.CompletableObserver n;
        public final io.reactivex.Scheduler t;
        public io.reactivex.disposables.Disposable u;
        public volatile boolean v;

        public DisposeOnObserver(io.reactivex.CompletableObserver completableObserver, io.reactivex.Scheduler scheduler) {
            this.n = completableObserver;
            this.t = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.v = true;
            this.t.scheduleDirect(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.v;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.v) {
                return;
            }
            this.n.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            if (this.v) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.u.dispose();
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }
    }

    public CompletableDisposeOn(io.reactivex.CompletableSource completableSource, io.reactivex.Scheduler scheduler) {
        this.n = completableSource;
        this.t = scheduler;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableDisposeOn.DisposeOnObserver(completableObserver, this.t));
    }
}
