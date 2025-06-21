package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
final class DisposeOnCancel implements java.util.concurrent.Future<java.lang.Object> {
    public final io.reactivex.disposables.Disposable n;

    public DisposeOnCancel(io.reactivex.disposables.Disposable disposable) {
        this.n = disposable;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.n.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public java.lang.Object get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public java.lang.Object get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }
}
