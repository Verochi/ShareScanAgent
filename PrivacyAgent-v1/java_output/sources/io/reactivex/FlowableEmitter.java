package io.reactivex;

/* loaded from: classes9.dex */
public interface FlowableEmitter<T> extends io.reactivex.Emitter<T> {
    boolean isCancelled();

    long requested();

    @io.reactivex.annotations.NonNull
    io.reactivex.FlowableEmitter<T> serialize();

    void setCancellable(@io.reactivex.annotations.Nullable io.reactivex.functions.Cancellable cancellable);

    void setDisposable(@io.reactivex.annotations.Nullable io.reactivex.disposables.Disposable disposable);

    boolean tryOnError(@io.reactivex.annotations.NonNull java.lang.Throwable th);
}
