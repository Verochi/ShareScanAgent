package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableRepeatWhen<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super io.reactivex.Flowable<java.lang.Object>, ? extends org.reactivestreams.Publisher<?>> t;

    public static final class RepeatWhenSubscriber<T> extends io.reactivex.internal.operators.flowable.FlowableRepeatWhen.WhenSourceSubscriber<T, java.lang.Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        public RepeatWhenSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.processors.FlowableProcessor<java.lang.Object> flowableProcessor, org.reactivestreams.Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            again(0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.receiver.cancel();
            this.downstream.onError(th);
        }
    }

    public static final class WhenReceiver<T, U> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<java.lang.Object>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = 2827772011130406689L;
        final org.reactivestreams.Publisher<T> source;
        io.reactivex.internal.operators.flowable.FlowableRepeatWhen.WhenSourceSubscriber<T, U> subscriber;
        final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> upstream = new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();

        public WhenReceiver(org.reactivestreams.Publisher<T> publisher) {
            this.source = publisher;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.subscriber.cancel();
            this.subscriber.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(java.lang.Object obj) {
            if (getAndIncrement() == 0) {
                while (this.upstream.get() != io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED) {
                    this.source.subscribe(this.subscriber);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }
    }

    public static abstract class WhenSourceSubscriber<T, U> extends io.reactivex.internal.subscriptions.SubscriptionArbiter implements io.reactivex.FlowableSubscriber<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        protected final org.reactivestreams.Subscriber<? super T> downstream;
        protected final io.reactivex.processors.FlowableProcessor<U> processor;
        private long produced;
        protected final org.reactivestreams.Subscription receiver;

        public WhenSourceSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.processors.FlowableProcessor<U> flowableProcessor, org.reactivestreams.Subscription subscription) {
            super(false);
            this.downstream = subscriber;
            this.processor = flowableProcessor;
            this.receiver = subscription;
        }

        public final void again(U u) {
            setSubscription(io.reactivex.internal.subscriptions.EmptySubscription.INSTANCE);
            long j = this.produced;
            if (j != 0) {
                this.produced = 0L;
                produced(j);
            }
            this.receiver.request(1L);
            this.processor.onNext(u);
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public final void cancel() {
            super.cancel();
            this.receiver.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(org.reactivestreams.Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableRepeatWhen(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super io.reactivex.Flowable<java.lang.Object>, ? extends org.reactivestreams.Publisher<?>> function) {
        super(flowable);
        this.t = function;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.subscribers.SerializedSubscriber serializedSubscriber = new io.reactivex.subscribers.SerializedSubscriber(subscriber);
        io.reactivex.processors.FlowableProcessor<T> serialized = io.reactivex.processors.UnicastProcessor.create(8).toSerialized();
        try {
            org.reactivestreams.Publisher publisher = (org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(serialized), "handler returned a null Publisher");
            io.reactivex.internal.operators.flowable.FlowableRepeatWhen.WhenReceiver whenReceiver = new io.reactivex.internal.operators.flowable.FlowableRepeatWhen.WhenReceiver(this.source);
            io.reactivex.internal.operators.flowable.FlowableRepeatWhen.RepeatWhenSubscriber repeatWhenSubscriber = new io.reactivex.internal.operators.flowable.FlowableRepeatWhen.RepeatWhenSubscriber(serializedSubscriber, serialized, whenReceiver);
            whenReceiver.subscriber = repeatWhenSubscriber;
            subscriber.onSubscribe(repeatWhenSubscriber);
            publisher.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
        }
    }
}
