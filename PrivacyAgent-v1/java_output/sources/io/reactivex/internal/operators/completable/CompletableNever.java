package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableNever extends io.reactivex.Completable {
    public static final io.reactivex.Completable INSTANCE = new io.reactivex.internal.operators.completable.CompletableNever();

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        completableObserver.onSubscribe(io.reactivex.internal.disposables.EmptyDisposable.NEVER);
    }
}
