package io.reactivex;

/* loaded from: classes9.dex */
public interface CompletableConverter<R> {
    @io.reactivex.annotations.NonNull
    R apply(@io.reactivex.annotations.NonNull io.reactivex.Completable completable);
}
