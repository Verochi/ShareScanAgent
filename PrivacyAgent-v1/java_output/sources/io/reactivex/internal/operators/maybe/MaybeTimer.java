package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeTimer extends io.reactivex.Maybe<java.lang.Long> {
    public final long n;
    public final java.util.concurrent.TimeUnit t;
    public final io.reactivex.Scheduler u;

    public static final class TimerDisposable extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.disposables.Disposable, java.lang.Runnable {
        private static final long serialVersionUID = 2875964065294031672L;
        final io.reactivex.MaybeObserver<? super java.lang.Long> downstream;

        public TimerDisposable(io.reactivex.MaybeObserver<? super java.lang.Long> maybeObserver) {
            this.downstream = maybeObserver;
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

    public MaybeTimer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        this.n = j;
        this.t = timeUnit;
        this.u = scheduler;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super java.lang.Long> maybeObserver) {
        io.reactivex.internal.operators.maybe.MaybeTimer.TimerDisposable timerDisposable = new io.reactivex.internal.operators.maybe.MaybeTimer.TimerDisposable(maybeObserver);
        maybeObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.u.scheduleDirect(timerDisposable, this.n, this.t));
    }
}
