package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableFromPublisher<T> extends io.reactivex.Flowable<T> {
    public final org.reactivestreams.Publisher<? extends T> t;

    public FlowableFromPublisher(org.reactivestreams.Publisher<? extends T> publisher) {
        this.t = publisher;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.t.subscribe(subscriber);
    }
}
