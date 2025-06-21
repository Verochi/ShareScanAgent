package io.reactivex.internal.subscribers;

/* loaded from: classes13.dex */
public final class BlockingSubscriber<T> extends java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
    public static final java.lang.Object TERMINATED = new java.lang.Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final java.util.Queue<java.lang.Object> queue;

    public BlockingSubscriber(java.util.Queue<java.lang.Object> queue) {
        this.queue = queue;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        return get() == io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.queue.offer(io.reactivex.internal.util.NotificationLite.complete());
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        this.queue.offer(io.reactivex.internal.util.NotificationLite.error(th));
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.queue.offer(io.reactivex.internal.util.NotificationLite.next(t));
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (io.reactivex.internal.subscriptions.SubscriptionHelper.setOnce(this, subscription)) {
            this.queue.offer(io.reactivex.internal.util.NotificationLite.subscription(this));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        get().request(j);
    }
}
