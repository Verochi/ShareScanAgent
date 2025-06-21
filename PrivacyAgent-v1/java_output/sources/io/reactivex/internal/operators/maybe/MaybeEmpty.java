package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeEmpty extends io.reactivex.Maybe<java.lang.Object> implements io.reactivex.internal.fuseable.ScalarCallable<java.lang.Object> {
    public static final io.reactivex.internal.operators.maybe.MaybeEmpty INSTANCE = new io.reactivex.internal.operators.maybe.MaybeEmpty();

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public java.lang.Object call() {
        return null;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super java.lang.Object> maybeObserver) {
        io.reactivex.internal.disposables.EmptyDisposable.complete(maybeObserver);
    }
}
