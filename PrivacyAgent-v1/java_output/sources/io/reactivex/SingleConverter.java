package io.reactivex;

/* loaded from: classes9.dex */
public interface SingleConverter<T, R> {
    @io.reactivex.annotations.NonNull
    R apply(@io.reactivex.annotations.NonNull io.reactivex.Single<T> single);
}
