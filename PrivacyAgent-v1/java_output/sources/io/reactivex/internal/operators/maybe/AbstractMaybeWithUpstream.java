package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
abstract class AbstractMaybeWithUpstream<T, R> extends io.reactivex.Maybe<R> implements io.reactivex.internal.fuseable.HasUpstreamMaybeSource<T> {
    protected final io.reactivex.MaybeSource<T> source;

    public AbstractMaybeWithUpstream(io.reactivex.MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public final io.reactivex.MaybeSource<T> source() {
        return this.source;
    }
}
