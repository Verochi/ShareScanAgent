package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableConcatMapPublisher<T, R> extends io.reactivex.Flowable<R> {
    public final org.reactivestreams.Publisher<T> t;
    public final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> u;
    public final int v;
    public final io.reactivex.internal.util.ErrorMode w;

    public FlowableConcatMapPublisher(org.reactivestreams.Publisher<T> publisher, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, int i, io.reactivex.internal.util.ErrorMode errorMode) {
        this.t = publisher;
        this.u = function;
        this.v = i;
        this.w = errorMode;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super R> subscriber) {
        if (io.reactivex.internal.operators.flowable.FlowableScalarXMap.tryScalarXMapSubscribe(this.t, subscriber, this.u)) {
            return;
        }
        this.t.subscribe(io.reactivex.internal.operators.flowable.FlowableConcatMap.subscribe(subscriber, this.u, this.v, this.w));
    }
}
