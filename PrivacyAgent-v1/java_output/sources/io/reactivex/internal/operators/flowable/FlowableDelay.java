package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableDelay<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final long t;
    public final java.util.concurrent.TimeUnit u;
    public final io.reactivex.Scheduler v;
    public final boolean w;

    public static final class DelaySubscriber<T> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        public final org.reactivestreams.Subscriber<? super T> n;
        public final long t;
        public final java.util.concurrent.TimeUnit u;
        public final io.reactivex.Scheduler.Worker v;
        public final boolean w;
        public org.reactivestreams.Subscription x;

        public final class OnComplete implements java.lang.Runnable {
            public OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    io.reactivex.internal.operators.flowable.FlowableDelay.DelaySubscriber.this.n.onComplete();
                } finally {
                    io.reactivex.internal.operators.flowable.FlowableDelay.DelaySubscriber.this.v.dispose();
                }
            }
        }

        public final class OnError implements java.lang.Runnable {
            public final java.lang.Throwable n;

            public OnError(java.lang.Throwable th) {
                this.n = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    io.reactivex.internal.operators.flowable.FlowableDelay.DelaySubscriber.this.n.onError(this.n);
                } finally {
                    io.reactivex.internal.operators.flowable.FlowableDelay.DelaySubscriber.this.v.dispose();
                }
            }
        }

        public final class OnNext implements java.lang.Runnable {
            public final T n;

            public OnNext(T t) {
                this.n = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                io.reactivex.internal.operators.flowable.FlowableDelay.DelaySubscriber.this.n.onNext(this.n);
            }
        }

        public DelaySubscriber(org.reactivestreams.Subscriber<? super T> subscriber, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler.Worker worker, boolean z) {
            this.n = subscriber;
            this.t = j;
            this.u = timeUnit;
            this.v = worker;
            this.w = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.x.cancel();
            this.v.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.v.schedule(new io.reactivex.internal.operators.flowable.FlowableDelay.DelaySubscriber.OnComplete(), this.t, this.u);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.v.schedule(new io.reactivex.internal.operators.flowable.FlowableDelay.DelaySubscriber.OnError(th), this.w ? this.t : 0L, this.u);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.v.schedule(new io.reactivex.internal.operators.flowable.FlowableDelay.DelaySubscriber.OnNext(t), this.t, this.u);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.x, subscription)) {
                this.x = subscription;
                this.n.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.x.request(j);
        }
    }

    public FlowableDelay(io.reactivex.Flowable<T> flowable, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        super(flowable);
        this.t = j;
        this.u = timeUnit;
        this.v = scheduler;
        this.w = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableDelay.DelaySubscriber(this.w ? subscriber : new io.reactivex.subscribers.SerializedSubscriber(subscriber), this.t, this.u, this.v.createWorker(), this.w));
    }
}
