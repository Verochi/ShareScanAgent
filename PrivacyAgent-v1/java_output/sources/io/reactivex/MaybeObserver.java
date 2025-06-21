package io.reactivex;

/* loaded from: classes9.dex */
public interface MaybeObserver<T> {
    void onComplete();

    void onError(@io.reactivex.annotations.NonNull java.lang.Throwable th);

    void onSubscribe(@io.reactivex.annotations.NonNull io.reactivex.disposables.Disposable disposable);

    void onSuccess(@io.reactivex.annotations.NonNull T t);
}
