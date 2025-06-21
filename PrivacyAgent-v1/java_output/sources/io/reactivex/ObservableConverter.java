package io.reactivex;

/* loaded from: classes9.dex */
public interface ObservableConverter<T, R> {
    @io.reactivex.annotations.NonNull
    R apply(@io.reactivex.annotations.NonNull io.reactivex.Observable<T> observable);
}
