package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableFromFuture<T> extends io.reactivex.Flowable<T> {
    public final java.util.concurrent.Future<? extends T> t;
    public final long u;
    public final java.util.concurrent.TimeUnit v;

    public FlowableFromFuture(java.util.concurrent.Future<? extends T> future, long j, java.util.concurrent.TimeUnit timeUnit) {
        this.t = future;
        this.u = j;
        this.v = timeUnit;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.subscriptions.DeferredScalarSubscription deferredScalarSubscription = new io.reactivex.internal.subscriptions.DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            java.util.concurrent.TimeUnit timeUnit = this.v;
            T t = timeUnit != null ? this.t.get(this.u, timeUnit) : this.t.get();
            if (t == null) {
                subscriber.onError(new java.lang.NullPointerException("The future returned null"));
            } else {
                deferredScalarSubscription.complete(t);
            }
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            if (deferredScalarSubscription.isCancelled()) {
                return;
            }
            subscriber.onError(th);
        }
    }
}
