package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableTimer extends io.reactivex.Observable<java.lang.Long> {
    public final io.reactivex.Scheduler n;
    public final long t;
    public final java.util.concurrent.TimeUnit u;

    public static final class TimerObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.disposables.Disposable, java.lang.Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final io.reactivex.Observer<? super java.lang.Long> downstream;

        public TimerObserver(io.reactivex.Observer<? super java.lang.Long> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed()) {
                return;
            }
            this.downstream.onNext(0L);
            lazySet(io.reactivex.internal.disposables.EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
        }

        public void setResource(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.trySet(this, disposable);
        }
    }

    public ObservableTimer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        this.t = j;
        this.u = timeUnit;
        this.n = scheduler;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super java.lang.Long> observer) {
        io.reactivex.internal.operators.observable.ObservableTimer.TimerObserver timerObserver = new io.reactivex.internal.operators.observable.ObservableTimer.TimerObserver(observer);
        observer.onSubscribe(timerObserver);
        timerObserver.setResource(this.n.scheduleDirect(timerObserver, this.t, this.u));
    }
}
