package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableRetryWhen<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super io.reactivex.Flowable<java.lang.Throwable>, ? extends org.reactivestreams.Publisher<?>> t;

    public static final class RetryWhenSubscriber<T> extends io.reactivex.internal.operators.flowable.FlowableRepeatWhen.WhenSourceSubscriber<T, java.lang.Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        public RetryWhenSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.processors.FlowableProcessor<java.lang.Throwable> flowableProcessor, org.reactivestreams.Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.receiver.cancel();
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            again(th);
        }
    }

    public FlowableRetryWhen(io.reactivex.Flowable<T> flowable, io.reactivex.functions.Function<? super io.reactivex.Flowable<java.lang.Throwable>, ? extends org.reactivestreams.Publisher<?>> function) {
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
            io.reactivex.internal.operators.flowable.FlowableRetryWhen.RetryWhenSubscriber retryWhenSubscriber = new io.reactivex.internal.operators.flowable.FlowableRetryWhen.RetryWhenSubscriber(serializedSubscriber, serialized, whenReceiver);
            whenReceiver.subscriber = retryWhenSubscriber;
            subscriber.onSubscribe(retryWhenSubscriber);
            publisher.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
        }
    }
}
