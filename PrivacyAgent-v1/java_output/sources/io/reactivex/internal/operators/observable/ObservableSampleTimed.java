package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableSampleTimed<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final long n;
    public final java.util.concurrent.TimeUnit t;
    public final io.reactivex.Scheduler u;
    public final boolean v;

    public static final class SampleTimedEmitLast<T> extends io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final java.util.concurrent.atomic.AtomicInteger wip;

        public SampleTimedEmitLast(io.reactivex.Observer<? super T> observer, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            super(observer, j, timeUnit, scheduler);
            this.wip = new java.util.concurrent.atomic.AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        public void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }
    }

    public static final class SampleTimedNoLast<T> extends io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public SampleTimedNoLast(io.reactivex.Observer<? super T> observer, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            super(observer, j, timeUnit, scheduler);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        public void complete() {
            this.downstream.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    public static abstract class SampleTimedObserver<T> extends java.util.concurrent.atomic.AtomicReference<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable, java.lang.Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final io.reactivex.Observer<? super T> downstream;
        final long period;
        final io.reactivex.Scheduler scheduler;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> timer = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.TimeUnit unit;
        io.reactivex.disposables.Disposable upstream;

        public SampleTimedObserver(io.reactivex.Observer<? super T> observer, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.downstream = observer;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        public void cancelTimer() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.timer);
        }

        public abstract void complete();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancelTimer();
            this.upstream.dispose();
        }

        public void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            cancelTimer();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                io.reactivex.Scheduler scheduler = this.scheduler;
                long j = this.period;
                io.reactivex.internal.disposables.DisposableHelper.replace(this.timer, scheduler.schedulePeriodicallyDirect(this, j, j, this.unit));
            }
        }
    }

    public ObservableSampleTimed(io.reactivex.ObservableSource<T> observableSource, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        super(observableSource);
        this.n = j;
        this.t = timeUnit;
        this.u = scheduler;
        this.v = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.observers.SerializedObserver serializedObserver = new io.reactivex.observers.SerializedObserver(observer);
        if (this.v) {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedEmitLast(serializedObserver, this.n, this.t, this.u));
        } else {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedNoLast(serializedObserver, this.n, this.t, this.u));
        }
    }
}
