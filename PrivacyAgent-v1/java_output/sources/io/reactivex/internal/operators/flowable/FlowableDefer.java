package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableDefer<T> extends io.reactivex.Flowable<T> {
    public final java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<? extends T>> t;

    public FlowableDefer(java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<? extends T>> callable) {
        this.t = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        try {
            ((org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The publisher supplied is null")).subscribe(subscriber);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
        }
    }
}
