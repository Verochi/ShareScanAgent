package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
abstract class AbstractDirectTask extends java.util.concurrent.atomic.AtomicReference<java.util.concurrent.Future<?>> implements io.reactivex.disposables.Disposable, io.reactivex.schedulers.SchedulerRunnableIntrospection {
    protected static final java.util.concurrent.FutureTask<java.lang.Void> DISPOSED;
    protected static final java.util.concurrent.FutureTask<java.lang.Void> FINISHED;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final java.lang.Runnable runnable;
    protected java.lang.Thread runner;

    static {
        java.lang.Runnable runnable = io.reactivex.internal.functions.Functions.EMPTY_RUNNABLE;
        FINISHED = new java.util.concurrent.FutureTask<>(runnable, null);
        DISPOSED = new java.util.concurrent.FutureTask<>(runnable, null);
    }

    public AbstractDirectTask(java.lang.Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        java.util.concurrent.FutureTask<java.lang.Void> futureTask;
        java.util.concurrent.Future<?> future = get();
        if (future == FINISHED || future == (futureTask = DISPOSED) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.runner != java.lang.Thread.currentThread());
    }

    @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
    public java.lang.Runnable getWrappedRunnable() {
        return this.runnable;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        java.util.concurrent.Future<?> future = get();
        return future == FINISHED || future == DISPOSED;
    }

    public final void setFuture(java.util.concurrent.Future<?> future) {
        java.util.concurrent.Future<?> future2;
        do {
            future2 = get();
            if (future2 == FINISHED) {
                return;
            }
            if (future2 == DISPOSED) {
                future.cancel(this.runner != java.lang.Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
