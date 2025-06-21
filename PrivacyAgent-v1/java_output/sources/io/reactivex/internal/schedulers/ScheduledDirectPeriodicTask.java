package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public final class ScheduledDirectPeriodicTask extends io.reactivex.internal.schedulers.AbstractDirectTask implements java.lang.Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(java.lang.Runnable runnable) {
        super(runnable);
    }

    @Override // io.reactivex.internal.schedulers.AbstractDirectTask, io.reactivex.schedulers.SchedulerRunnableIntrospection
    public /* bridge */ /* synthetic */ java.lang.Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.runner = java.lang.Thread.currentThread();
        try {
            this.runnable.run();
            this.runner = null;
        } catch (java.lang.Throwable th) {
            this.runner = null;
            lazySet(io.reactivex.internal.schedulers.AbstractDirectTask.FINISHED);
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        }
    }
}
