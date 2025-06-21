package io.reactivex.internal.subscriptions;

/* loaded from: classes13.dex */
public enum EmptySubscription implements io.reactivex.internal.fuseable.QueueSubscription<java.lang.Object> {
    INSTANCE;

    public static void complete(org.reactivestreams.Subscriber<?> subscriber) {
        subscriber.onSubscribe(INSTANCE);
        subscriber.onComplete();
    }

    public static void error(java.lang.Throwable th, org.reactivestreams.Subscriber<?> subscriber) {
        subscriber.onSubscribe(INSTANCE);
        subscriber.onError(th);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(java.lang.Object obj, java.lang.Object obj2) {
        throw new java.lang.UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @io.reactivex.annotations.Nullable
    public java.lang.Object poll() {
        return null;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j);
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return "EmptySubscription";
    }
}
