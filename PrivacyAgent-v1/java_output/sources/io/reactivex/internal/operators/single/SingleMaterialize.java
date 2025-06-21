package io.reactivex.internal.operators.single;

@io.reactivex.annotations.Experimental
/* loaded from: classes13.dex */
public final class SingleMaterialize<T> extends io.reactivex.Single<io.reactivex.Notification<T>> {
    public final io.reactivex.Single<T> n;

    public SingleMaterialize(io.reactivex.Single<T> single) {
        this.n = single;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super io.reactivex.Notification<T>> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.mixed.MaterializeSingleObserver(singleObserver));
    }
}
