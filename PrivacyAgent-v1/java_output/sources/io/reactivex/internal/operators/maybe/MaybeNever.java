package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeNever extends io.reactivex.Maybe<java.lang.Object> {
    public static final io.reactivex.internal.operators.maybe.MaybeNever INSTANCE = new io.reactivex.internal.operators.maybe.MaybeNever();

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super java.lang.Object> maybeObserver) {
        maybeObserver.onSubscribe(io.reactivex.internal.disposables.EmptyDisposable.NEVER);
    }
}
