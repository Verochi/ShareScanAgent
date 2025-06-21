package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableInterval extends io.reactivex.Flowable<java.lang.Long> {
    public final io.reactivex.Scheduler t;
    public final long u;
    public final long v;
    public final java.util.concurrent.TimeUnit w;

    public static final class IntervalSubscriber extends java.util.concurrent.atomic.AtomicLong implements org.reactivestreams.Subscription, java.lang.Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        long count;
        final org.reactivestreams.Subscriber<? super java.lang.Long> downstream;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> resource = new java.util.concurrent.atomic.AtomicReference<>();

        public IntervalSubscriber(org.reactivestreams.Subscriber<? super java.lang.Long> subscriber) {
            this.downstream = subscriber;
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
            if (this.resource.get() != io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
                if (get() != 0) {
                    org.reactivestreams.Subscriber<? super java.lang.Long> subscriber = this.downstream;
                    long j = this.count;
                    this.count = j + 1;
                    subscriber.onNext(java.lang.Long.valueOf(j));
                    io.reactivex.internal.util.BackpressureHelper.produced(this, 1L);
                    return;
                }
                this.downstream.onError(new io.reactivex.exceptions.MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
                io.reactivex.internal.disposables.DisposableHelper.dispose(this.resource);
            }
        }

        public void setResource(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this.resource, disposable);
        }
    }

    public FlowableInterval(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        this.u = j;
        this.v = j2;
        this.w = timeUnit;
        this.t = scheduler;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super java.lang.Long> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableInterval.IntervalSubscriber intervalSubscriber = new io.reactivex.internal.operators.flowable.FlowableInterval.IntervalSubscriber(subscriber);
        subscriber.onSubscribe(intervalSubscriber);
        io.reactivex.Scheduler scheduler = this.t;
        if (!(scheduler instanceof io.reactivex.internal.schedulers.TrampolineScheduler)) {
            intervalSubscriber.setResource(scheduler.schedulePeriodicallyDirect(intervalSubscriber, this.u, this.v, this.w));
            return;
        }
        io.reactivex.Scheduler.Worker createWorker = scheduler.createWorker();
        intervalSubscriber.setResource(createWorker);
        createWorker.schedulePeriodically(intervalSubscriber, this.u, this.v, this.w);
    }
}
