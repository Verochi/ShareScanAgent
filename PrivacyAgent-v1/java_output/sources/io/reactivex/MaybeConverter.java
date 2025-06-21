package io.reactivex;

/* loaded from: classes9.dex */
public interface MaybeConverter<T, R> {
    @io.reactivex.annotations.NonNull
    R apply(@io.reactivex.annotations.NonNull io.reactivex.Maybe<T> maybe);
}
