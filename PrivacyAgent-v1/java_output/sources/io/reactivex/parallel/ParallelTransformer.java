package io.reactivex.parallel;

/* loaded from: classes13.dex */
public interface ParallelTransformer<Upstream, Downstream> {
    @io.reactivex.annotations.NonNull
    io.reactivex.parallel.ParallelFlowable<Downstream> apply(@io.reactivex.annotations.NonNull io.reactivex.parallel.ParallelFlowable<Upstream> parallelFlowable);
}
