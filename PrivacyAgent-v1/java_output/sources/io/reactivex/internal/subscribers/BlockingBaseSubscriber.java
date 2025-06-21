package io.reactivex.internal.subscribers;

/* loaded from: classes13.dex */
public abstract class BlockingBaseSubscriber<T> extends java.util.concurrent.CountDownLatch implements io.reactivex.FlowableSubscriber<T> {
    public T n;
    public java.lang.Throwable t;
    public org.reactivestreams.Subscription u;
    public volatile boolean v;

    public BlockingBaseSubscriber() {
        super(1);
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
                await();
            } catch (java.lang.InterruptedException e) {
                org.reactivestreams.Subscription subscription = this.u;
                this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
                if (subscription != null) {
                    subscription.cancel();
                }
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
            }
        }
        java.lang.Throwable th = this.t;
        if (th == null) {
            return this.n;
        }
        throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.u, subscription)) {
            this.u = subscription;
            if (this.v) {
                return;
            }
            subscription.request(Long.MAX_VALUE);
            if (this.v) {
                this.u = io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED;
                subscription.cancel();
            }
        }
    }
}
