package io.reactivex.parallel;

/* loaded from: classes13.dex */
public enum ParallelFailureHandling implements io.reactivex.functions.BiFunction<java.lang.Long, java.lang.Throwable, io.reactivex.parallel.ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // io.reactivex.functions.BiFunction
    public io.reactivex.parallel.ParallelFailureHandling apply(java.lang.Long l, java.lang.Throwable th) {
        return this;
    }
}
