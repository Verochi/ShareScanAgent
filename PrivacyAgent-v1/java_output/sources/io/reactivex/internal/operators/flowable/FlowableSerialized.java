package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableSerialized<T> extends io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream<T, T> {
    public FlowableSerialized(io.reactivex.Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.source.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.subscribers.SerializedSubscriber(subscriber));
    }
}
