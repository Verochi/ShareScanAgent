package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableTimeout extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;
    public final long t;
    public final java.util.concurrent.TimeUnit u;
    public final io.reactivex.Scheduler v;
    public final io.reactivex.CompletableSource w;

    public final class DisposeTask implements java.lang.Runnable {
        public final java.util.concurrent.atomic.AtomicBoolean n;
        public final io.reactivex.disposables.CompositeDisposable t;
        public final io.reactivex.CompletableObserver u;

        public final class DisposeObserver implements io.reactivex.CompletableObserver {
            public DisposeObserver() {
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                io.reactivex.internal.operators.completable.CompletableTimeout.DisposeTask.this.t.dispose();
                io.reactivex.internal.operators.completable.CompletableTimeout.DisposeTask.this.u.onComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(java.lang.Throwable th) {
                io.reactivex.internal.operators.completable.CompletableTimeout.DisposeTask.this.t.dispose();
                io.reactivex.internal.operators.completable.CompletableTimeout.DisposeTask.this.u.onError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.operators.completable.CompletableTimeout.DisposeTask.this.t.add(disposable);
            }
        }

        public DisposeTask(java.util.concurrent.atomic.AtomicBoolean atomicBoolean, io.reactivex.disposables.CompositeDisposable compositeDisposable, io.reactivex.CompletableObserver completableObserver) {
            this.n = atomicBoolean;
            this.t = compositeDisposable;
            this.u = completableObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.n.compareAndSet(false, true)) {
                this.t.clear();
                io.reactivex.CompletableSource completableSource = io.reactivex.internal.operators.completable.CompletableTimeout.this.w;
                if (completableSource != null) {
                    completableSource.subscribe(new io.reactivex.internal.operators.completable.CompletableTimeout.DisposeTask.DisposeObserver());
                    return;
                }
                io.reactivex.CompletableObserver completableObserver = this.u;
                io.reactivex.internal.operators.completable.CompletableTimeout completableTimeout = io.reactivex.internal.operators.completable.CompletableTimeout.this;
                completableObserver.onError(new java.util.concurrent.TimeoutException(io.reactivex.internal.util.ExceptionHelper.timeoutMessage(completableTimeout.t, completableTimeout.u)));
            }
        }
    }

    public static final class TimeOutObserver implements io.reactivex.CompletableObserver {
        public final io.reactivex.disposables.CompositeDisposable n;
        public final java.util.concurrent.atomic.AtomicBoolean t;
        public final io.reactivex.CompletableObserver u;

        public TimeOutObserver(io.reactivex.disposables.CompositeDisposable compositeDisposable, java.util.concurrent.atomic.AtomicBoolean atomicBoolean, io.reactivex.CompletableObserver completableObserver) {
            this.n = compositeDisposable;
            this.t = atomicBoolean;
            this.u = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.t.compareAndSet(false, true)) {
                this.n.dispose();
                this.u.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            if (!this.t.compareAndSet(false, true)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.n.dispose();
                this.u.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.add(disposable);
        }
    }

    public CompletableTimeout(io.reactivex.CompletableSource completableSource, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, io.reactivex.CompletableSource completableSource2) {
        this.n = completableSource;
        this.t = j;
        this.u = timeUnit;
        this.v = scheduler;
        this.w = completableSource2;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.disposables.CompositeDisposable compositeDisposable = new io.reactivex.disposables.CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean();
        compositeDisposable.add(this.v.scheduleDirect(new io.reactivex.internal.operators.completable.CompletableTimeout.DisposeTask(atomicBoolean, compositeDisposable, completableObserver), this.t, this.u));
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableTimeout.TimeOutObserver(compositeDisposable, atomicBoolean, completableObserver));
    }
}
