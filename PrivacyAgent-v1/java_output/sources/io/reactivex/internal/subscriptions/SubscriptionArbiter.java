package io.reactivex.internal.subscriptions;

/* loaded from: classes13.dex */
public class SubscriptionArbiter extends java.util.concurrent.atomic.AtomicInteger implements org.reactivestreams.Subscription {
    private static final long serialVersionUID = -2189523197179400958L;
    org.reactivestreams.Subscription actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    long requested;
    protected boolean unbounded;
    final java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> missedSubscription = new java.util.concurrent.atomic.AtomicReference<>();
    final java.util.concurrent.atomic.AtomicLong missedRequested = new java.util.concurrent.atomic.AtomicLong();
    final java.util.concurrent.atomic.AtomicLong missedProduced = new java.util.concurrent.atomic.AtomicLong();

    public SubscriptionArbiter(boolean z) {
        this.cancelOnReplace = z;
    }

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        drain();
    }

    final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    final void drainLoop() {
        int i = 1;
        long j = 0;
        org.reactivestreams.Subscription subscription = null;
        do {
            org.reactivestreams.Subscription subscription2 = this.missedSubscription.get();
            if (subscription2 != null) {
                subscription2 = this.missedSubscription.getAndSet(null);
            }
            long j2 = this.missedRequested.get();
            if (j2 != 0) {
                j2 = this.missedRequested.getAndSet(0L);
            }
            long j3 = this.missedProduced.get();
            if (j3 != 0) {
                j3 = this.missedProduced.getAndSet(0L);
            }
            org.reactivestreams.Subscription subscription3 = this.actual;
            if (this.cancelled) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.actual = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j4 = this.requested;
                if (j4 != Long.MAX_VALUE) {
                    j4 = io.reactivex.internal.util.BackpressureHelper.addCap(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        j4 -= j3;
                        if (j4 < 0) {
                            io.reactivex.internal.subscriptions.SubscriptionHelper.reportMoreProduced(j4);
                            j4 = 0;
                        }
                    }
                    this.requested = j4;
                }
                if (subscription2 != null) {
                    if (subscription3 != null && this.cancelOnReplace) {
                        subscription3.cancel();
                    }
                    this.actual = subscription2;
                    if (j4 != 0) {
                        j = io.reactivex.internal.util.BackpressureHelper.addCap(j, j4);
                        subscription = subscription2;
                    }
                } else if (subscription3 != null && j2 != 0) {
                    j = io.reactivex.internal.util.BackpressureHelper.addCap(j, j2);
                    subscription = subscription3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            subscription.request(j);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j) {
        if (this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            io.reactivex.internal.util.BackpressureHelper.add(this.missedProduced, j);
            drain();
            return;
        }
        long j2 = this.requested;
        if (j2 != Long.MAX_VALUE) {
            long j3 = j2 - j;
            if (j3 < 0) {
                io.reactivex.internal.subscriptions.SubscriptionHelper.reportMoreProduced(j3);
                j3 = 0;
            }
            this.requested = j3;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        drainLoop();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (!io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j) || this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            io.reactivex.internal.util.BackpressureHelper.add(this.missedRequested, j);
            drain();
            return;
        }
        long j2 = this.requested;
        if (j2 != Long.MAX_VALUE) {
            long addCap = io.reactivex.internal.util.BackpressureHelper.addCap(j2, j);
            this.requested = addCap;
            if (addCap == Long.MAX_VALUE) {
                this.unbounded = true;
            }
        }
        org.reactivestreams.Subscription subscription = this.actual;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (subscription != null) {
            subscription.request(j);
        }
    }

    public final void setSubscription(org.reactivestreams.Subscription subscription) {
        if (this.cancelled) {
            subscription.cancel();
            return;
        }
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(subscription, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            org.reactivestreams.Subscription andSet = this.missedSubscription.getAndSet(subscription);
            if (andSet != null && this.cancelOnReplace) {
                andSet.cancel();
            }
            drain();
            return;
        }
        org.reactivestreams.Subscription subscription2 = this.actual;
        if (subscription2 != null && this.cancelOnReplace) {
            subscription2.cancel();
        }
        this.actual = subscription;
        long j = this.requested;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (j != 0) {
            subscription.request(j);
        }
    }
}
