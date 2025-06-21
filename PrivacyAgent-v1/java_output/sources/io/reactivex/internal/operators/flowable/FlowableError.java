package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableError<T> extends io.reactivex.Flowable<T> {
    public final java.util.concurrent.Callable<? extends java.lang.Throwable> t;

    public FlowableError(java.util.concurrent.Callable<? extends java.lang.Throwable> callable) {
        this.t = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        try {
            th = (java.lang.Throwable) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (java.lang.Throwable th) {
            th = th;
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
        }
        io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
    }
}
