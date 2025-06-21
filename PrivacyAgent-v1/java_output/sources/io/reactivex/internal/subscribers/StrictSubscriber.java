package io.reactivex.internal.subscribers;

/* loaded from: classes13.dex */
public class StrictSubscriber<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final org.reactivestreams.Subscriber<? super T> downstream;
    final io.reactivex.internal.util.AtomicThrowable error = new io.reactivex.internal.util.AtomicThrowable();
    final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
    final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> upstream = new java.util.concurrent.atomic.AtomicReference<>();
    final java.util.concurrent.atomic.AtomicBoolean once = new java.util.concurrent.atomic.AtomicBoolean();

    public StrictSubscriber(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.done) {
            return;
        }
        io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this.upstream);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        this.done = true;
        io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        io.reactivex.internal.util.HalfSerializer.onNext(this.downstream, t, this, this.error);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        } else {
            subscription.cancel();
            cancel();
            onError(new java.lang.IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (j > 0) {
            io.reactivex.internal.subscriptions.SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
            return;
        }
        cancel();
        onError(new java.lang.IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
    }
}
