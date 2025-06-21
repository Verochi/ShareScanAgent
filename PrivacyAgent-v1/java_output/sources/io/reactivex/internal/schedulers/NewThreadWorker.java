package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public class NewThreadWorker extends io.reactivex.Scheduler.Worker {
    public final java.util.concurrent.ScheduledExecutorService n;
    public volatile boolean t;

    public NewThreadWorker(java.util.concurrent.ThreadFactory threadFactory) {
        this.n = io.reactivex.internal.schedulers.SchedulerPoolFactory.create(threadFactory);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.t) {
            return;
        }
        this.t = true;
        this.n.shutdownNow();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.t;
    }

    @Override // io.reactivex.Scheduler.Worker
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
        return schedule(runnable, 0L, null);
    }

    @Override // io.reactivex.Scheduler.Worker
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
        return this.t ? io.reactivex.internal.disposables.EmptyDisposable.INSTANCE : scheduleActual(runnable, j, timeUnit, null);
    }

    @io.reactivex.annotations.NonNull
    public io.reactivex.internal.schedulers.ScheduledRunnable scheduleActual(java.lang.Runnable runnable, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit, @io.reactivex.annotations.Nullable io.reactivex.internal.disposables.DisposableContainer disposableContainer) {
        io.reactivex.internal.schedulers.ScheduledRunnable scheduledRunnable = new io.reactivex.internal.schedulers.ScheduledRunnable(io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable), disposableContainer);
        if (disposableContainer != null && !disposableContainer.add(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            scheduledRunnable.setFuture(j <= 0 ? this.n.submit((java.util.concurrent.Callable) scheduledRunnable) : this.n.schedule((java.util.concurrent.Callable) scheduledRunnable, j, timeUnit));
        } catch (java.util.concurrent.RejectedExecutionException e) {
            if (disposableContainer != null) {
                disposableContainer.remove(scheduledRunnable);
            }
            io.reactivex.plugins.RxJavaPlugins.onError(e);
        }
        return scheduledRunnable;
    }

    public io.reactivex.disposables.Disposable scheduleDirect(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        io.reactivex.internal.schedulers.ScheduledDirectTask scheduledDirectTask = new io.reactivex.internal.schedulers.ScheduledDirectTask(io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable));
        try {
            scheduledDirectTask.setFuture(j <= 0 ? this.n.submit(scheduledDirectTask) : this.n.schedule(scheduledDirectTask, j, timeUnit));
            return scheduledDirectTask;
        } catch (java.util.concurrent.RejectedExecutionException e) {
            io.reactivex.plugins.RxJavaPlugins.onError(e);
            return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
        }
    }

    public io.reactivex.disposables.Disposable schedulePeriodicallyDirect(java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        java.lang.Runnable onSchedule = io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable);
        if (j2 <= 0) {
            io.reactivex.internal.schedulers.InstantPeriodicTask instantPeriodicTask = new io.reactivex.internal.schedulers.InstantPeriodicTask(onSchedule, this.n);
            try {
                instantPeriodicTask.a(j <= 0 ? this.n.submit(instantPeriodicTask) : this.n.schedule(instantPeriodicTask, j, timeUnit));
                return instantPeriodicTask;
            } catch (java.util.concurrent.RejectedExecutionException e) {
                io.reactivex.plugins.RxJavaPlugins.onError(e);
                return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
            }
        }
        io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask(onSchedule);
        try {
            scheduledDirectPeriodicTask.setFuture(this.n.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (java.util.concurrent.RejectedExecutionException e2) {
            io.reactivex.plugins.RxJavaPlugins.onError(e2);
            return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
        }
    }

    public void shutdown() {
        if (this.t) {
            return;
        }
        this.t = true;
        this.n.shutdown();
    }
}
