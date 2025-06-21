package io.reactivex.disposables;

/* loaded from: classes9.dex */
final class FutureDisposable extends java.util.concurrent.atomic.AtomicReference<java.util.concurrent.Future<?>> implements io.reactivex.disposables.Disposable {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    public FutureDisposable(java.util.concurrent.Future<?> future, boolean z) {
        super(future);
        this.allowInterrupt = z;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        java.util.concurrent.Future<?> andSet = getAndSet(null);
        if (andSet != null) {
            andSet.cancel(this.allowInterrupt);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        java.util.concurrent.Future<?> future = get();
        return future == null || future.isDone();
    }
}
