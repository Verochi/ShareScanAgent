package io.reactivex;

/* loaded from: classes9.dex */
public interface FlowableTransformer<Upstream, Downstream> {
    @io.reactivex.annotations.NonNull
    org.reactivestreams.Publisher<Downstream> apply(@io.reactivex.annotations.NonNull io.reactivex.Flowable<Upstream> flowable);
}
