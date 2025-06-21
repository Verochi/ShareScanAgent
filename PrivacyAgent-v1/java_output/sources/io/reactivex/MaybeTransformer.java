package io.reactivex;

/* loaded from: classes9.dex */
public interface MaybeTransformer<Upstream, Downstream> {
    @io.reactivex.annotations.NonNull
    io.reactivex.MaybeSource<Downstream> apply(@io.reactivex.annotations.NonNull io.reactivex.Maybe<Upstream> maybe);
}
