package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public enum MaybeToPublisher implements io.reactivex.functions.Function<io.reactivex.MaybeSource<java.lang.Object>, org.reactivestreams.Publisher<java.lang.Object>> {
    INSTANCE;

    public static <T> io.reactivex.functions.Function<io.reactivex.MaybeSource<T>, org.reactivestreams.Publisher<T>> instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.functions.Function
    public org.reactivestreams.Publisher<java.lang.Object> apply(io.reactivex.MaybeSource<java.lang.Object> maybeSource) throws java.lang.Exception {
        return new io.reactivex.internal.operators.maybe.MaybeToFlowable(maybeSource);
    }
}
