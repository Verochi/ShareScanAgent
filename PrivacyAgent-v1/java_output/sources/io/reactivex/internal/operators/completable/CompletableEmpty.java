package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableEmpty extends io.reactivex.Completable {
    public static final io.reactivex.Completable INSTANCE = new io.reactivex.internal.operators.completable.CompletableEmpty();

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.internal.disposables.EmptyDisposable.complete(completableObserver);
    }
}
