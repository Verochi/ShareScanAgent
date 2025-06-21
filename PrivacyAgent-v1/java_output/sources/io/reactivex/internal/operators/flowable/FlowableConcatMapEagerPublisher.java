package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableConcatMapEagerPublisher<T, R> extends io.reactivex.Flowable<R> {
    public final org.reactivestreams.Publisher<T> t;
    public final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> u;
    public final int v;
    public final int w;
    public final io.reactivex.internal.util.ErrorMode x;

    public FlowableConcatMapEagerPublisher(org.reactivestreams.Publisher<T> publisher, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, int i, int i2, io.reactivex.internal.util.ErrorMode errorMode) {
        this.t = publisher;
        this.u = function;
        this.v = i;
        this.w = i2;
        this.x = errorMode;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super R> subscriber) {
        this.t.subscribe(new io.reactivex.internal.operators.flowable.FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(subscriber, this.u, this.v, this.w, this.x));
    }
}
