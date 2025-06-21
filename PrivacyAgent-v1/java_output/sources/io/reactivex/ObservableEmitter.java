package io.reactivex;

/* loaded from: classes9.dex */
public interface ObservableEmitter<T> extends io.reactivex.Emitter<T> {
    boolean isDisposed();

    @io.reactivex.annotations.NonNull
    io.reactivex.ObservableEmitter<T> serialize();

    void setCancellable(@io.reactivex.annotations.Nullable io.reactivex.functions.Cancellable cancellable);

    void setDisposable(@io.reactivex.annotations.Nullable io.reactivex.disposables.Disposable disposable);

    boolean tryOnError(@io.reactivex.annotations.NonNull java.lang.Throwable th);
}
