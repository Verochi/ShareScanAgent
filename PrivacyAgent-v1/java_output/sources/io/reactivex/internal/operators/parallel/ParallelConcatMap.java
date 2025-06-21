package io.reactivex.internal.operators.parallel;

/* loaded from: classes13.dex */
public final class ParallelConcatMap<T, R> extends io.reactivex.parallel.ParallelFlowable<R> {
    public final io.reactivex.parallel.ParallelFlowable<T> a;
    public final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> b;
    public final int c;
    public final io.reactivex.internal.util.ErrorMode d;

    public ParallelConcatMap(io.reactivex.parallel.ParallelFlowable<T> parallelFlowable, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, int i, io.reactivex.internal.util.ErrorMode errorMode) {
        this.a = parallelFlowable;
        this.b = (io.reactivex.functions.Function) io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper");
        this.c = i;
        this.d = (io.reactivex.internal.util.ErrorMode) io.reactivex.internal.functions.ObjectHelper.requireNonNull(errorMode, "errorMode");
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(org.reactivestreams.Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            org.reactivestreams.Subscriber<? super T>[] subscriberArr2 = new org.reactivestreams.Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = io.reactivex.internal.operators.flowable.FlowableConcatMap.subscribe(subscriberArr[i], this.b, this.c, this.d);
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
