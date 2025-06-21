package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public final class SingleScheduler extends io.reactivex.Scheduler {
    public static final io.reactivex.internal.schedulers.RxThreadFactory v;
    public static final java.util.concurrent.ScheduledExecutorService w;
    public final java.util.concurrent.ThreadFactory t;
    public final java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledExecutorService> u;

    public static final class ScheduledWorker extends io.reactivex.Scheduler.Worker {
        public final java.util.concurrent.ScheduledExecutorService n;
        public final io.reactivex.disposables.CompositeDisposable t = new io.reactivex.disposables.CompositeDisposable();
        public volatile boolean u;

        public ScheduledWorker(java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
            this.n = scheduledExecutorService;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.u) {
                return;
            }
            this.u = true;
            this.t.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u;
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
            if (this.u) {
                return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
            }
            io.reactivex.internal.schedulers.ScheduledRunnable scheduledRunnable = new io.reactivex.internal.schedulers.ScheduledRunnable(io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable), this.t);
            this.t.add(scheduledRunnable);
            try {
                scheduledRunnable.setFuture(j <= 0 ? this.n.submit((java.util.concurrent.Callable) scheduledRunnable) : this.n.schedule((java.util.concurrent.Callable) scheduledRunnable, j, timeUnit));
                return scheduledRunnable;
            } catch (java.util.concurrent.RejectedExecutionException e) {
                dispose();
                io.reactivex.plugins.RxJavaPlugins.onError(e);
                return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
            }
        }
    }

    static {
        java.util.concurrent.ScheduledExecutorService newScheduledThreadPool = java.util.concurrent.Executors.newScheduledThreadPool(0);
        w = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        v = new io.reactivex.internal.schedulers.RxThreadFactory("RxSingleScheduler", java.lang.Math.max(1, java.lang.Math.min(10, java.lang.Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public SingleScheduler() {
        this(v);
    }

    public SingleScheduler(java.util.concurrent.ThreadFactory threadFactory) {
        java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledExecutorService> atomicReference = new java.util.concurrent.atomic.AtomicReference<>();
        this.u = atomicReference;
        this.t = threadFactory;
        atomicReference.lazySet(a(threadFactory));
    }

    public static java.util.concurrent.ScheduledExecutorService a(java.util.concurrent.ThreadFactory threadFactory) {
        return io.reactivex.internal.schedulers.SchedulerPoolFactory.create(threadFactory);
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.Scheduler.Worker createWorker() {
        return new io.reactivex.internal.schedulers.SingleScheduler.ScheduledWorker(this.u.get());
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable scheduleDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        io.reactivex.internal.schedulers.ScheduledDirectTask scheduledDirectTask = new io.reactivex.internal.schedulers.ScheduledDirectTask(io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable));
        try {
            scheduledDirectTask.setFuture(j <= 0 ? this.u.get().submit(scheduledDirectTask) : this.u.get().schedule(scheduledDirectTask, j, timeUnit));
            return scheduledDirectTask;
        } catch (java.util.concurrent.RejectedExecutionException e) {
            io.reactivex.plugins.RxJavaPlugins.onError(e);
            return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable schedulePeriodicallyDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        java.lang.Runnable onSchedule = io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable);
        if (j2 > 0) {
            io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask(onSchedule);
            try {
                scheduledDirectPeriodicTask.setFuture(this.u.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (java.util.concurrent.RejectedExecutionException e) {
                io.reactivex.plugins.RxJavaPlugins.onError(e);
                return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
            }
        }
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.u.get();
        io.reactivex.internal.schedulers.InstantPeriodicTask instantPeriodicTask = new io.reactivex.internal.schedulers.InstantPeriodicTask(onSchedule, scheduledExecutorService);
        try {
            instantPeriodicTask.a(j <= 0 ? scheduledExecutorService.submit(instantPeriodicTask) : scheduledExecutorService.schedule(instantPeriodicTask, j, timeUnit));
            return instantPeriodicTask;
        } catch (java.util.concurrent.RejectedExecutionException e2) {
            io.reactivex.plugins.RxJavaPlugins.onError(e2);
            return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        java.util.concurrent.ScheduledExecutorService andSet;
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.u.get();
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService2 = w;
        if (scheduledExecutorService == scheduledExecutorService2 || (andSet = this.u.getAndSet(scheduledExecutorService2)) == scheduledExecutorService2) {
            return;
        }
        andSet.shutdownNow();
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService;
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.u.get();
            if (scheduledExecutorService != w) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = a(this.t);
            }
        } while (!defpackage.xv0.a(this.u, scheduledExecutorService, scheduledExecutorService2));
    }
}
