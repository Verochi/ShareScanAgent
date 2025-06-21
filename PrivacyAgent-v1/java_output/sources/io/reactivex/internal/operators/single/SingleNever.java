package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleNever extends io.reactivex.Single<java.lang.Object> {
    public static final io.reactivex.Single<java.lang.Object> INSTANCE = new io.reactivex.internal.operators.single.SingleNever();

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super java.lang.Object> singleObserver) {
        singleObserver.onSubscribe(io.reactivex.internal.disposables.EmptyDisposable.NEVER);
    }
}
