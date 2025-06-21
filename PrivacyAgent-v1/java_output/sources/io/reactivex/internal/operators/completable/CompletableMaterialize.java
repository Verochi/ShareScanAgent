package io.reactivex.internal.operators.completable;

@io.reactivex.annotations.Experimental
/* loaded from: classes9.dex */
public final class CompletableMaterialize<T> extends io.reactivex.Single<io.reactivex.Notification<T>> {
    public final io.reactivex.Completable n;

    public CompletableMaterialize(io.reactivex.Completable completable) {
        this.n = completable;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super io.reactivex.Notification<T>> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.mixed.MaterializeSingleObserver(singleObserver));
    }
}
