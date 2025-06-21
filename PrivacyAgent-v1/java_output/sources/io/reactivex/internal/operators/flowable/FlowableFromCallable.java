package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableFromCallable<T> extends io.reactivex.Flowable<T> implements java.util.concurrent.Callable<T> {
    public final java.util.concurrent.Callable<? extends T> t;

    public FlowableFromCallable(java.util.concurrent.Callable<? extends T> callable) {
        this.t = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws java.lang.Exception {
        return (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.subscriptions.DeferredScalarSubscription deferredScalarSubscription = new io.reactivex.internal.subscriptions.DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            deferredScalarSubscription.complete(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The callable returned a null value"));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            if (deferredScalarSubscription.isCancelled()) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                subscriber.onError(th);
            }
        }
    }
}
