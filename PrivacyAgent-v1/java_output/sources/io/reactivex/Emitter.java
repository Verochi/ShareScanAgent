package io.reactivex;

/* loaded from: classes9.dex */
public interface Emitter<T> {
    void onComplete();

    void onError(@io.reactivex.annotations.NonNull java.lang.Throwable th);

    void onNext(@io.reactivex.annotations.NonNull T t);
}
