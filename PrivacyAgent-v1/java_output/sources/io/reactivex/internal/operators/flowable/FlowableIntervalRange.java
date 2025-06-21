package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableIntervalRange extends io.reactivex.Flowable<java.lang.Long> {
    public final io.reactivex.Scheduler t;
    public final long u;
    public final long v;
    public final long w;
    public final long x;
    public final java.util.concurrent.TimeUnit y;

    public static final class IntervalRangeSubscriber extends java.util.concurrent.atomic.AtomicLong implements org.reactivestreams.Subscription, java.lang.Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        long count;
        final org.reactivestreams.Subscriber<? super java.lang.Long> downstream;
        final long end;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> resource = new java.util.concurrent.atomic.AtomicReference<>();

        public IntervalRangeSubscriber(org.reactivestreams.Subscriber<? super java.lang.Long> subscriber, long j, long j2) {
            this.downstream = subscriber;
            this.count = j;
            this.end = j2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.resource);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(this, j);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            io.reactivex.disposables.Disposable disposable = this.resource.get();
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                long j = get();
                if (j == 0) {
                    this.downstream.onError(new io.reactivex.exceptions.MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
                    io.reactivex.internal.disposables.DisposableHelper.dispose(this.resource);
                    return;
                }
                long j2 = this.count;
                this.downstream.onNext(java.lang.Long.valueOf(j2));
                if (j2 == this.end) {
                    if (this.resource.get() != disposableHelper) {
                        this.downstream.onComplete();
                    }
                    io.reactivex.internal.disposables.DisposableHelper.dispose(this.resource);
                } else {
                    this.count = j2 + 1;
                    if (j != Long.MAX_VALUE) {
                        decrementAndGet();
                    }
                }
            }
        }

        public void setResource(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this.resource, disposable);
        }
    }

    public FlowableIntervalRange(long j, long j2, long j3, long j4, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        this.w = j3;
        this.x = j4;
        this.y = timeUnit;
        this.t = scheduler;
        this.u = j;
        this.v = j2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super java.lang.Long> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableIntervalRange.IntervalRangeSubscriber intervalRangeSubscriber = new io.reactivex.internal.operators.flowable.FlowableIntervalRange.IntervalRangeSubscriber(subscriber, this.u, this.v);
        subscriber.onSubscribe(intervalRangeSubscriber);
        io.reactivex.Scheduler scheduler = this.t;
        if (!(scheduler instanceof io.reactivex.internal.schedulers.TrampolineScheduler)) {
            intervalRangeSubscriber.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeSubscriber, this.w, this.x, this.y));
            return;
        }
        io.reactivex.Scheduler.Worker createWorker = scheduler.createWorker();
        intervalRangeSubscriber.setResource(createWorker);
        createWorker.schedulePeriodically(intervalRangeSubscriber, this.w, this.x, this.y);
    }
}
