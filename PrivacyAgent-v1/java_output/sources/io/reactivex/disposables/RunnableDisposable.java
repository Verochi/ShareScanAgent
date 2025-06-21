package io.reactivex.disposables;

/* loaded from: classes9.dex */
final class RunnableDisposable extends io.reactivex.disposables.ReferenceDisposable<java.lang.Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    public RunnableDisposable(java.lang.Runnable runnable) {
        super(runnable);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public java.lang.String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
