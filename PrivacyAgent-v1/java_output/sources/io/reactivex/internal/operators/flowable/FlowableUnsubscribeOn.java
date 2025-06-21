package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableUnsubscribeOn<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public final io.reactivex.Scheduler t;

    public static final class UnsubscribeSubscriber<T> extends java.util.concurrent.atomic.AtomicBoolean implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = 1015244841293359600L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        final io.reactivex.Scheduler scheduler;
        org.reactivestreams.Subscription upstream;

        public final class Cancellation implements java.lang.Runnable {
            public Cancellation() {
            }

            @Override // java.lang.Runnable
            public void run() {
                io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn.UnsubscribeSubscriber.this.upstream.cancel();
            }
        }

        public UnsubscribeSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.Scheduler scheduler) {
            this.downstream = subscriber;
            this.scheduler = scheduler;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.scheduler.scheduleDirect(new io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn.UnsubscribeSubscriber.Cancellation());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (get()) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.upstream.request(j);
        }
    }

    public FlowableUnsubscribeOn(io.reactivex.Flowable<T> flowable, io.reactivex.Scheduler scheduler) {
        super(flowable);
        this.t = scheduler;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn.UnsubscribeSubscriber(subscriber, this.t));
    }
}
