package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
final class InstantPeriodicTask implements java.util.concurrent.Callable<java.lang.Void>, io.reactivex.disposables.Disposable {
    public static final java.util.concurrent.FutureTask<java.lang.Void> x = new java.util.concurrent.FutureTask<>(io.reactivex.internal.functions.Functions.EMPTY_RUNNABLE, null);
    public final java.lang.Runnable n;
    public final java.util.concurrent.ExecutorService v;
    public java.lang.Thread w;
    public final java.util.concurrent.atomic.AtomicReference<java.util.concurrent.Future<?>> u = new java.util.concurrent.atomic.AtomicReference<>();
    public final java.util.concurrent.atomic.AtomicReference<java.util.concurrent.Future<?>> t = new java.util.concurrent.atomic.AtomicReference<>();

    public InstantPeriodicTask(java.lang.Runnable runnable, java.util.concurrent.ExecutorService executorService) {
        this.n = runnable;
        this.v = executorService;
    }

    public void a(java.util.concurrent.Future<?> future) {
        java.util.concurrent.Future<?> future2;
        do {
            future2 = this.u.get();
            if (future2 == x) {
                future.cancel(this.w != java.lang.Thread.currentThread());
                return;
            }
        } while (!defpackage.xv0.a(this.u, future2, future));
    }

    public void b(java.util.concurrent.Future<?> future) {
        java.util.concurrent.Future<?> future2;
        do {
            future2 = this.t.get();
            if (future2 == x) {
                future.cancel(this.w != java.lang.Thread.currentThread());
                return;
            }
        } while (!defpackage.xv0.a(this.t, future2, future));
    }

    @Override // java.util.concurrent.Callable
    public java.lang.Void call() throws java.lang.Exception {
        this.w = java.lang.Thread.currentThread();
        try {
            this.n.run();
            b(this.v.submit(this));
            this.w = null;
        } catch (java.lang.Throwable th) {
            this.w = null;
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        java.util.concurrent.atomic.AtomicReference<java.util.concurrent.Future<?>> atomicReference = this.u;
        java.util.concurrent.FutureTask<java.lang.Void> futureTask = x;
        java.util.concurrent.Future<?> andSet = atomicReference.getAndSet(futureTask);
        if (andSet != null && andSet != futureTask) {
            andSet.cancel(this.w != java.lang.Thread.currentThread());
        }
        java.util.concurrent.Future<?> andSet2 = this.t.getAndSet(futureTask);
        if (andSet2 == null || andSet2 == futureTask) {
            return;
        }
        andSet2.cancel(this.w != java.lang.Thread.currentThread());
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.u.get() == x;
    }
}
