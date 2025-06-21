package io.reactivex;

/* loaded from: classes9.dex */
public interface CompletableEmitter {
    boolean isDisposed();

    void onComplete();

    void onError(@io.reactivex.annotations.NonNull java.lang.Throwable th);

    void setCancellable(@io.reactivex.annotations.Nullable io.reactivex.functions.Cancellable cancellable);

    void setDisposable(@io.reactivex.annotations.Nullable io.reactivex.disposables.Disposable disposable);

    boolean tryOnError(@io.reactivex.annotations.NonNull java.lang.Throwable th);
}
