package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableFlatMapPublisher<T, U> extends io.reactivex.Flowable<U> {
    public final org.reactivestreams.Publisher<T> t;
    public final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> u;
    public final boolean v;
    public final int w;
    public final int x;

    public FlowableFlatMapPublisher(org.reactivestreams.Publisher<T> publisher, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> function, boolean z, int i, int i2) {
        this.t = publisher;
        this.u = function;
        this.v = z;
        this.w = i;
        this.x = i2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super U> subscriber) {
        if (io.reactivex.internal.operators.flowable.FlowableScalarXMap.tryScalarXMapSubscribe(this.t, subscriber, this.u)) {
            return;
        }
        this.t.subscribe(io.reactivex.internal.operators.flowable.FlowableFlatMap.subscribe(subscriber, this.u, this.v, this.w, this.x));
    }
}
