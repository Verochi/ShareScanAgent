package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableSamplePublisher<T> extends io.reactivex.Flowable<T> {
    public final org.reactivestreams.Publisher<T> t;
    public final org.reactivestreams.Publisher<?> u;
    public final boolean v;

    public static final class SampleMainEmitLast<T> extends io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final java.util.concurrent.atomic.AtomicInteger wip;

        public SampleMainEmitLast(org.reactivestreams.Subscriber<? super T> subscriber, org.reactivestreams.Publisher<?> publisher) {
            super(subscriber, publisher);
            this.wip = new java.util.concurrent.atomic.AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        public void completion() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        public void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.downstream.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(org.reactivestreams.Subscriber<? super T> subscriber, org.reactivestreams.Publisher<?> publisher) {
            super(subscriber, publisher);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        public void completion() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        public void run() {
            emit();
        }
    }

    public static abstract class SamplePublisherSubscriber<T> extends java.util.concurrent.atomic.AtomicReference<T> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = -3517602651313910099L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        final org.reactivestreams.Publisher<?> sampler;
        org.reactivestreams.Subscription upstream;
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> other = new java.util.concurrent.atomic.AtomicReference<>();

        public SamplePublisherSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, org.reactivestreams.Publisher<?> publisher) {
            this.downstream = subscriber;
            this.sampler = publisher;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.other);
            this.upstream.cancel();
        }

        public void complete() {
            this.upstream.cancel();
            completion();
        }

        public abstract void completion();

        public void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(andSet);
                    io.reactivex.internal.util.BackpressureHelper.produced(this.requested, 1L);
                } else {
                    cancel();
                    this.downstream.onError(new io.reactivex.exceptions.MissingBackpressureException("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        public void error(java.lang.Throwable th) {
            this.upstream.cancel();
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.other);
            completion();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.other);
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplerSubscriber(this));
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(this.requested, j);
            }
        }

        public abstract void run();

        public void setOther(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this.other, subscription, Long.MAX_VALUE);
        }
    }

    public static final class SamplerSubscriber<T> implements io.reactivex.FlowableSubscriber<java.lang.Object> {
        public final io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber<T> n;

        public SamplerSubscriber(io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber<T> samplePublisherSubscriber) {
            this.n = samplePublisherSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.n.complete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.n.error(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.lang.Object obj) {
            this.n.run();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            this.n.setOther(subscription);
        }
    }

    public FlowableSamplePublisher(org.reactivestreams.Publisher<T> publisher, org.reactivestreams.Publisher<?> publisher2, boolean z) {
        this.t = publisher;
        this.u = publisher2;
        this.v = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.subscribers.SerializedSubscriber serializedSubscriber = new io.reactivex.subscribers.SerializedSubscriber(subscriber);
        if (this.v) {
            this.t.subscribe(new io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SampleMainEmitLast(serializedSubscriber, this.u));
        } else {
            this.t.subscribe(new io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SampleMainNoLast(serializedSubscriber, this.u));
        }
    }
}
