package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public final class ScheduledDirectTask extends io.reactivex.internal.schedulers.AbstractDirectTask implements java.util.concurrent.Callable<java.lang.Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(java.lang.Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    public java.lang.Void call() throws java.lang.Exception {
        this.runner = java.lang.Thread.currentThread();
        try {
            this.runnable.run();
            return null;
        } finally {
            lazySet(io.reactivex.internal.schedulers.AbstractDirectTask.FINISHED);
            this.runner = null;
        }
    }

    @Override // io.reactivex.internal.schedulers.AbstractDirectTask, io.reactivex.schedulers.SchedulerRunnableIntrospection
    public /* bridge */ /* synthetic */ java.lang.Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }
}
