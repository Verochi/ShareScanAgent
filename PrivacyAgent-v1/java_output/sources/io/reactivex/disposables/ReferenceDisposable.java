package io.reactivex.disposables;

/* loaded from: classes9.dex */
abstract class ReferenceDisposable<T> extends java.util.concurrent.atomic.AtomicReference<T> implements io.reactivex.disposables.Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    public ReferenceDisposable(T t) {
        super(io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "value is null"));
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        onDisposed(andSet);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return get() == null;
    }

    public abstract void onDisposed(@io.reactivex.annotations.NonNull T t);
}
