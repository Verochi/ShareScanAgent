package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableMapPublisher<T, U> extends io.reactivex.Flowable<U> {
    public final org.reactivestreams.Publisher<T> t;
    public final io.reactivex.functions.Function<? super T, ? extends U> u;

    public FlowableMapPublisher(org.reactivestreams.Publisher<T> publisher, io.reactivex.functions.Function<? super T, ? extends U> function) {
        this.t = publisher;
        this.u = function;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super U> subscriber) {
        this.t.subscribe(new io.reactivex.internal.operators.flowable.FlowableMap.MapSubscriber(subscriber, this.u));
    }
}
