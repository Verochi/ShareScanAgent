package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeJust<T> extends io.reactivex.Maybe<T> implements io.reactivex.internal.fuseable.ScalarCallable<T> {
    public final T n;

    public MaybeJust(T t) {
        this.n = t;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return this.n;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(io.reactivex.disposables.Disposables.disposed());
        maybeObserver.onSuccess(this.n);
    }
}
