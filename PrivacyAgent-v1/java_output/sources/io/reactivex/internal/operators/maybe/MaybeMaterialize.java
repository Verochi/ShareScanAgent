package io.reactivex.internal.operators.maybe;

@io.reactivex.annotations.Experimental
/* loaded from: classes11.dex */
public final class MaybeMaterialize<T> extends io.reactivex.Single<io.reactivex.Notification<T>> {
    public final io.reactivex.Maybe<T> n;

    public MaybeMaterialize(io.reactivex.Maybe<T> maybe) {
        this.n = maybe;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super io.reactivex.Notification<T>> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.mixed.MaterializeSingleObserver(singleObserver));
    }
}
