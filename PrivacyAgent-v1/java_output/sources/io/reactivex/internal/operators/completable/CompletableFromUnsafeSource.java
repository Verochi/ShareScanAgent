package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableFromUnsafeSource extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;

    public CompletableFromUnsafeSource(io.reactivex.CompletableSource completableSource) {
        this.n = completableSource;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(completableObserver);
    }
}
