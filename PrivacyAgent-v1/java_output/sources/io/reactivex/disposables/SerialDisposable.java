package io.reactivex.disposables;

/* loaded from: classes9.dex */
public final class SerialDisposable implements io.reactivex.disposables.Disposable {
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> n;

    public SerialDisposable() {
        this.n = new java.util.concurrent.atomic.AtomicReference<>();
    }

    public SerialDisposable(@io.reactivex.annotations.Nullable io.reactivex.disposables.Disposable disposable) {
        this.n = new java.util.concurrent.atomic.AtomicReference<>(disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        io.reactivex.internal.disposables.DisposableHelper.dispose(this.n);
    }

    @io.reactivex.annotations.Nullable
    public io.reactivex.disposables.Disposable get() {
        io.reactivex.disposables.Disposable disposable = this.n.get();
        return disposable == io.reactivex.internal.disposables.DisposableHelper.DISPOSED ? io.reactivex.disposables.Disposables.disposed() : disposable;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.n.get());
    }

    public boolean replace(@io.reactivex.annotations.Nullable io.reactivex.disposables.Disposable disposable) {
        return io.reactivex.internal.disposables.DisposableHelper.replace(this.n, disposable);
    }

    public boolean set(@io.reactivex.annotations.Nullable io.reactivex.disposables.Disposable disposable) {
        return io.reactivex.internal.disposables.DisposableHelper.set(this.n, disposable);
    }
}
