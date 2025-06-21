package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableTakePublisher<T> extends io.reactivex.Flowable<T> {
    public final org.reactivestreams.Publisher<T> t;
    public final long u;

    public FlowableTakePublisher(org.reactivestreams.Publisher<T> publisher, long j) {
        this.t = publisher;
        this.u = j;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.t.subscribe(new io.reactivex.internal.operators.flowable.FlowableTake.TakeSubscriber(subscriber, this.u));
    }
}
