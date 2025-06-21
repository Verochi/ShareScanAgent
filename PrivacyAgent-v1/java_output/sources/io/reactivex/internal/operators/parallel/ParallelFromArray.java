package io.reactivex.internal.operators.parallel;

/* loaded from: classes13.dex */
public final class ParallelFromArray<T> extends io.reactivex.parallel.ParallelFlowable<T> {
    public final org.reactivestreams.Publisher<T>[] a;

    public ParallelFromArray(org.reactivestreams.Publisher<T>[] publisherArr) {
        this.a = publisherArr;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.length;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(org.reactivestreams.Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            for (int i = 0; i < length; i++) {
                this.a[i].subscribe(subscriberArr[i]);
            }
        }
    }
}
