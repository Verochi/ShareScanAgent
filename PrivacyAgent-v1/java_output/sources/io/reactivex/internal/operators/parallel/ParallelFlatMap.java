package io.reactivex.internal.operators.parallel;

/* loaded from: classes13.dex */
public final class ParallelFlatMap<T, R> extends io.reactivex.parallel.ParallelFlowable<R> {
    public final io.reactivex.parallel.ParallelFlowable<T> a;
    public final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> b;
    public final boolean c;
    public final int d;
    public final int e;

    public ParallelFlatMap(io.reactivex.parallel.ParallelFlowable<T> parallelFlowable, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, boolean z, int i, int i2) {
        this.a = parallelFlowable;
        this.b = function;
        this.c = z;
        this.d = i;
        this.e = i2;
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
                subscriberArr2[i] = io.reactivex.internal.operators.flowable.FlowableFlatMap.subscribe(subscriberArr[i], this.b, this.c, this.d, this.e);
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
