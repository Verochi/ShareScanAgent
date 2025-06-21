package io.reactivex.internal.disposables;

/* loaded from: classes9.dex */
public interface DisposableContainer {
    boolean add(io.reactivex.disposables.Disposable disposable);

    boolean delete(io.reactivex.disposables.Disposable disposable);

    boolean remove(io.reactivex.disposables.Disposable disposable);
}
