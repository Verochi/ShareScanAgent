package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableIntervalRange extends io.reactivex.Observable<java.lang.Long> {
    public final io.reactivex.Scheduler n;
    public final long t;
    public final long u;
    public final long v;
    public final long w;
    public final java.util.concurrent.TimeUnit x;

    public static final class IntervalRangeObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.disposables.Disposable, java.lang.Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        long count;
        final io.reactivex.Observer<? super java.lang.Long> downstream;
        final long end;

        public IntervalRangeObserver(io.reactivex.Observer<? super java.lang.Long> observer, long j, long j2) {
            this.downstream = observer;
            this.count = j;
            this.end = j2;
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
            long j = this.count;
            this.downstream.onNext(java.lang.Long.valueOf(j));
            if (j != this.end) {
                this.count = j + 1;
            } else {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this);
                this.downstream.onComplete();
            }
        }

        public void setResource(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableIntervalRange(long j, long j2, long j3, long j4, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        this.v = j3;
        this.w = j4;
        this.x = timeUnit;
        this.n = scheduler;
        this.t = j;
        this.u = j2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super java.lang.Long> observer) {
        io.reactivex.internal.operators.observable.ObservableIntervalRange.IntervalRangeObserver intervalRangeObserver = new io.reactivex.internal.operators.observable.ObservableIntervalRange.IntervalRangeObserver(observer, this.t, this.u);
        observer.onSubscribe(intervalRangeObserver);
        io.reactivex.Scheduler scheduler = this.n;
        if (!(scheduler instanceof io.reactivex.internal.schedulers.TrampolineScheduler)) {
            intervalRangeObserver.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeObserver, this.v, this.w, this.x));
            return;
        }
        io.reactivex.Scheduler.Worker createWorker = scheduler.createWorker();
        intervalRangeObserver.setResource(createWorker);
        createWorker.schedulePeriodically(intervalRangeObserver, this.v, this.w, this.x);
    }
}
