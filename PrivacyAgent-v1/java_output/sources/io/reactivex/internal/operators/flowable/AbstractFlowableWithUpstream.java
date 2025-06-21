package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
abstract class AbstractFlowableWithUpstream<T, R> extends io.reactivex.Flowable<R> implements io.reactivex.internal.fuseable.HasUpstreamPublisher<T> {
    protected final io.reactivex.Flowable<T> source;

    public AbstractFlowableWithUpstream(io.reactivex.Flowable<T> flowable) {
        this.source = (io.reactivex.Flowable) io.reactivex.internal.functions.ObjectHelper.requireNonNull(flowable, "source is null");
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public final org.reactivestreams.Publisher<T> source() {
        return this.source;
    }
}
