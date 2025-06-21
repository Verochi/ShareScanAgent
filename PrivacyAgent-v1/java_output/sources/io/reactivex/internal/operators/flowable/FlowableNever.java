package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableNever extends io.reactivex.Flowable<java.lang.Object> {
    public static final io.reactivex.Flowable<java.lang.Object> INSTANCE = new io.reactivex.internal.operators.flowable.FlowableNever();

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super java.lang.Object> subscriber) {
        subscriber.onSubscribe(io.reactivex.internal.subscriptions.EmptySubscription.INSTANCE);
    }
}
