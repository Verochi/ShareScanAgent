package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleTimer extends io.reactivex.Single<java.lang.Long> {
    public final long n;
    public final java.util.concurrent.TimeUnit t;
    public final io.reactivex.Scheduler u;

    public static final class TimerDisposable extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.disposables.Disposable, java.lang.Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        final io.reactivex.SingleObserver<? super java.lang.Long> downstream;

        public TimerDisposable(io.reactivex.SingleObserver<? super java.lang.Long> singleObserver) {
            this.downstream = singleObserver;
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
            this.downstream.onSuccess(0L);
        }

        public void setFuture(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.replace(this, disposable);
        }
    }

    public SingleTimer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        this.n = j;
        this.t = timeUnit;
        this.u = scheduler;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super java.lang.Long> singleObserver) {
        io.reactivex.internal.operators.single.SingleTimer.TimerDisposable timerDisposable = new io.reactivex.internal.operators.single.SingleTimer.TimerDisposable(singleObserver);
        singleObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.u.scheduleDirect(timerDisposable, this.n, this.t));
    }
}
