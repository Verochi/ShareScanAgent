package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableInterval extends io.reactivex.Observable<java.lang.Long> {
    public final io.reactivex.Scheduler n;
    public final long t;
    public final long u;
    public final java.util.concurrent.TimeUnit v;

    public static final class IntervalObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.disposables.Disposable, java.lang.Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        long count;
        final io.reactivex.Observer<? super java.lang.Long> downstream;

        public IntervalObserver(io.reactivex.Observer<? super java.lang.Long> observer) {
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
            if (get() != io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
                io.reactivex.Observer<? super java.lang.Long> observer = this.downstream;
                long j = this.count;
                this.count = 1 + j;
                observer.onNext(java.lang.Long.valueOf(j));
            }
        }

        public void setResource(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableInterval(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        this.t = j;
        this.u = j2;
        this.v = timeUnit;
        this.n = scheduler;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super java.lang.Long> observer) {
        io.reactivex.internal.operators.observable.ObservableInterval.IntervalObserver intervalObserver = new io.reactivex.internal.operators.observable.ObservableInterval.IntervalObserver(observer);
        observer.onSubscribe(intervalObserver);
        io.reactivex.Scheduler scheduler = this.n;
        if (!(scheduler instanceof io.reactivex.internal.schedulers.TrampolineScheduler)) {
            intervalObserver.setResource(scheduler.schedulePeriodicallyDirect(intervalObserver, this.t, this.u, this.v));
            return;
        }
        io.reactivex.Scheduler.Worker createWorker = scheduler.createWorker();
        intervalObserver.setResource(createWorker);
        createWorker.schedulePeriodically(intervalObserver, this.t, this.u, this.v);
    }
}
