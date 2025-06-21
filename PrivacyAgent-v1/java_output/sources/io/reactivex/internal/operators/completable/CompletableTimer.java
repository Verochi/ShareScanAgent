package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableTimer extends io.reactivex.Completable {
    public final long n;
    public final java.util.concurrent.TimeUnit t;
    public final io.reactivex.Scheduler u;

    public static final class TimerDisposable extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.disposables.Disposable, java.lang.Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final io.reactivex.CompletableObserver downstream;

        public TimerDisposable(io.reactivex.CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.downstream.onComplete();
        }

        public void setFuture(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.replace(this, disposable);
        }
    }

    public CompletableTimer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        this.n = j;
        this.t = timeUnit;
        this.u = scheduler;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.internal.operators.completable.CompletableTimer.TimerDisposable timerDisposable = new io.reactivex.internal.operators.completable.CompletableTimer.TimerDisposable(completableObserver);
        completableObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.u.scheduleDirect(timerDisposable, this.n, this.t));
    }
}
