package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableLift extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;
    public final io.reactivex.CompletableOperator t;

    public CompletableLift(io.reactivex.CompletableSource completableSource, io.reactivex.CompletableOperator completableOperator) {
        this.n = completableSource;
        this.t = completableOperator;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        try {
            this.n.subscribe(this.t.apply(completableObserver));
        } catch (java.lang.NullPointerException e) {
            throw e;
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        }
    }
}
