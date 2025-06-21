package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableTimeInterval<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, io.reactivex.schedulers.Timed<T>> {
    public final io.reactivex.Scheduler t;
    public final java.util.concurrent.TimeUnit u;

    public static final class TimeIntervalSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super io.reactivex.schedulers.Timed<T>> n;
        public final java.util.concurrent.TimeUnit t;
        public final io.reactivex.Scheduler u;
        public org.reactivestreams.Subscription v;
        public long w;

        public TimeIntervalSubscriber(org.reactivestreams.Subscriber<? super io.reactivex.schedulers.Timed<T>> subscriber, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.n = subscriber;
            this.u = scheduler;
            this.t = timeUnit;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.v.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long now = this.u.now(this.t);
            long j = this.w;
            this.w = now;
            this.n.onNext(new io.reactivex.schedulers.Timed(t, now - j, this.t));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.v, subscription)) {
                this.w = this.u.now(this.t);
                this.v = subscription;
                this.n.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.v.request(j);
        }
    }

    public FlowableTimeInterval(io.reactivex.Flowable<T> flowable, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        super(flowable);
        this.t = scheduler;
        this.u = timeUnit;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super io.reactivex.schedulers.Timed<T>> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableTimeInterval.TimeIntervalSubscriber(subscriber, this.u, this.t));
    }
}
