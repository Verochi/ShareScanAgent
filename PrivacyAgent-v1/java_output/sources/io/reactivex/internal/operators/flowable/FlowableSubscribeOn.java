package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableSubscribeOn<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.Scheduler t;
    public final boolean u;

    public static final class SubscribeOnSubscriber<T> extends java.util.concurrent.atomic.AtomicReference<java.lang.Thread> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription, java.lang.Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        final boolean nonScheduledRequests;
        org.reactivestreams.Publisher<T> source;
        final io.reactivex.Scheduler.Worker worker;
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> upstream = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();

        public static final class Request implements java.lang.Runnable {
            public final org.reactivestreams.Subscription n;
            public final long t;

            public Request(org.reactivestreams.Subscription subscription, long j) {
                this.n = subscription;
                this.t = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.n.request(this.t);
            }
        }

        public SubscribeOnSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.Scheduler.Worker worker, org.reactivestreams.Publisher<T> publisher, boolean z) {
            this.downstream = subscriber;
            this.worker = worker;
            this.source = publisher;
            this.nonScheduledRequests = !z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this.upstream, subscription)) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    requestUpstream(andSet, subscription);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                org.reactivestreams.Subscription subscription = this.upstream.get();
                if (subscription != null) {
                    requestUpstream(j, subscription);
                    return;
                }
                io.reactivex.internal.util.BackpressureHelper.add(this.requested, j);
                org.reactivestreams.Subscription subscription2 = this.upstream.get();
                if (subscription2 != null) {
                    long andSet = this.requested.getAndSet(0L);
                    if (andSet != 0) {
                        requestUpstream(andSet, subscription2);
                    }
                }
            }
        }

        public void requestUpstream(long j, org.reactivestreams.Subscription subscription) {
            if (this.nonScheduledRequests || java.lang.Thread.currentThread() == get()) {
                subscription.request(j);
            } else {
                this.worker.schedule(new io.reactivex.internal.operators.flowable.FlowableSubscribeOn.SubscribeOnSubscriber.Request(subscription, j));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(java.lang.Thread.currentThread());
            org.reactivestreams.Publisher<T> publisher = this.source;
            this.source = null;
            publisher.subscribe(this);
        }
    }

    public FlowableSubscribeOn(io.reactivex.Flowable<T> flowable, io.reactivex.Scheduler scheduler, boolean z) {
        super(flowable);
        this.t = scheduler;
        this.u = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.Scheduler.Worker createWorker = this.t.createWorker();
        io.reactivex.internal.operators.flowable.FlowableSubscribeOn.SubscribeOnSubscriber subscribeOnSubscriber = new io.reactivex.internal.operators.flowable.FlowableSubscribeOn.SubscribeOnSubscriber(subscriber, createWorker, this.source, this.u);
        subscriber.onSubscribe(subscribeOnSubscriber);
        createWorker.schedule(subscribeOnSubscriber);
    }
}
