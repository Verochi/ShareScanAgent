package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableJust<T> extends io.reactivex.Flowable<T> implements io.reactivex.internal.fuseable.ScalarCallable<T> {
    public final T t;

    public FlowableJust(T t) {
        this.t = t;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return this.t;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(new io.reactivex.internal.subscriptions.ScalarSubscription(subscriber, this.t));
    }
}
