package io.reactivex.parallel;

/* loaded from: classes13.dex */
public interface ParallelFlowableConverter<T, R> {
    @io.reactivex.annotations.NonNull
    R apply(@io.reactivex.annotations.NonNull io.reactivex.parallel.ParallelFlowable<T> parallelFlowable);
}
