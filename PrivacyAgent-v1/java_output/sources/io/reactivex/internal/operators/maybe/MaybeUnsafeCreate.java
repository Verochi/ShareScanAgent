package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeUnsafeCreate<T> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, T> {
    public MaybeUnsafeCreate(io.reactivex.MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(maybeObserver);
    }
}
