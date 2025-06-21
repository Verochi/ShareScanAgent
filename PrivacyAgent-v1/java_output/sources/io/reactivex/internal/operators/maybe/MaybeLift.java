package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeLift<T, R> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, R> {
    public final io.reactivex.MaybeOperator<? extends R, ? super T> n;

    public MaybeLift(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.MaybeOperator<? extends R, ? super T> maybeOperator) {
        super(maybeSource);
        this.n = maybeOperator;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super R> maybeObserver) {
        try {
            this.source.subscribe((io.reactivex.MaybeObserver) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(maybeObserver), "The operator returned a null MaybeObserver"));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, maybeObserver);
        }
    }
}
