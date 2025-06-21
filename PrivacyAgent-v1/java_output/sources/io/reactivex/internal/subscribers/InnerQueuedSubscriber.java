package io.reactivex.internal.subscribers;

/* loaded from: classes13.dex */
public final class InnerQueuedSubscriber<T> extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport<T> parent;
    final int prefetch;
    long produced;
    volatile io.reactivex.internal.fuseable.SimpleQueue<T> queue;

    public InnerQueuedSubscriber(io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport<T> innerQueuedSubscriberSupport, int i) {
        this.parent = innerQueuedSubscriberSupport;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof io.reactivex.internal.fuseable.QueueSubscription) {
                io.reactivex.internal.fuseable.QueueSubscription queueSubscription = (io.reactivex.internal.fuseable.QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                    io.reactivex.internal.util.QueueDrainHelper.request(subscription, this.prefetch);
                    return;
                }
            }
            this.queue = io.reactivex.internal.util.QueueDrainHelper.createQueue(this.prefetch);
            io.reactivex.internal.util.QueueDrainHelper.request(subscription, this.prefetch);
        }
    }

    public io.reactivex.internal.fuseable.SimpleQueue<T> queue() {
        return this.queue;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (this.fusionMode != 1) {
            long j2 = this.produced + j;
            if (j2 < this.limit) {
                this.produced = j2;
            } else {
                this.produced = 0L;
                get().request(j2);
            }
        }
    }

    public void requestOne() {
        if (this.fusionMode != 1) {
            long j = this.produced + 1;
            if (j != this.limit) {
                this.produced = j;
            } else {
                this.produced = 0L;
                get().request(j);
            }
        }
    }

    public void setDone() {
        this.done = true;
    }
}
