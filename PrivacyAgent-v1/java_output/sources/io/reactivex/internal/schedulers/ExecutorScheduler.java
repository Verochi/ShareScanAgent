package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public final class ExecutorScheduler extends io.reactivex.Scheduler {
    public static final io.reactivex.Scheduler v = io.reactivex.schedulers.Schedulers.single();
    public final boolean t;

    @io.reactivex.annotations.NonNull
    public final java.util.concurrent.Executor u;

    public final class DelayedDispose implements java.lang.Runnable {
        public final io.reactivex.internal.schedulers.ExecutorScheduler.DelayedRunnable n;

        public DelayedDispose(io.reactivex.internal.schedulers.ExecutorScheduler.DelayedRunnable delayedRunnable) {
            this.n = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.reactivex.internal.schedulers.ExecutorScheduler.DelayedRunnable delayedRunnable = this.n;
            delayedRunnable.direct.replace(io.reactivex.internal.schedulers.ExecutorScheduler.this.scheduleDirect(delayedRunnable));
        }
    }

    public static final class DelayedRunnable extends java.util.concurrent.atomic.AtomicReference<java.lang.Runnable> implements java.lang.Runnable, io.reactivex.disposables.Disposable, io.reactivex.schedulers.SchedulerRunnableIntrospection {
        private static final long serialVersionUID = -4101336210206799084L;
        final io.reactivex.internal.disposables.SequentialDisposable direct;
        final io.reactivex.internal.disposables.SequentialDisposable timed;

        public DelayedRunnable(java.lang.Runnable runnable) {
            super(runnable);
            this.timed = new io.reactivex.internal.disposables.SequentialDisposable();
            this.direct = new io.reactivex.internal.disposables.SequentialDisposable();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public java.lang.Runnable getWrappedRunnable() {
            java.lang.Runnable runnable = get();
            return runnable != null ? runnable : io.reactivex.internal.functions.Functions.EMPTY_RUNNABLE;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet(null);
                    io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable = this.timed;
                    io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.direct.lazySet(disposableHelper);
                } catch (java.lang.Throwable th) {
                    lazySet(null);
                    this.timed.lazySet(io.reactivex.internal.disposables.DisposableHelper.DISPOSED);
                    this.direct.lazySet(io.reactivex.internal.disposables.DisposableHelper.DISPOSED);
                    throw th;
                }
            }
        }
    }

    public static final class ExecutorWorker extends io.reactivex.Scheduler.Worker implements java.lang.Runnable {
        public final boolean n;
        public final java.util.concurrent.Executor t;
        public volatile boolean v;
        public final java.util.concurrent.atomic.AtomicInteger w = new java.util.concurrent.atomic.AtomicInteger();
        public final io.reactivex.disposables.CompositeDisposable x = new io.reactivex.disposables.CompositeDisposable();
        public final io.reactivex.internal.queue.MpscLinkedQueue<java.lang.Runnable> u = new io.reactivex.internal.queue.MpscLinkedQueue<>();

        public static final class BooleanRunnable extends java.util.concurrent.atomic.AtomicBoolean implements java.lang.Runnable, io.reactivex.disposables.Disposable {
            private static final long serialVersionUID = -2421395018820541164L;
            final java.lang.Runnable actual;

            public BooleanRunnable(java.lang.Runnable runnable) {
                this.actual = runnable;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.actual.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        public static final class InterruptibleRunnable extends java.util.concurrent.atomic.AtomicInteger implements java.lang.Runnable, io.reactivex.disposables.Disposable {
            static final int FINISHED = 2;
            static final int INTERRUPTED = 4;
            static final int INTERRUPTING = 3;
            static final int READY = 0;
            static final int RUNNING = 1;
            private static final long serialVersionUID = -3603436687413320876L;
            final java.lang.Runnable run;
            final io.reactivex.internal.disposables.DisposableContainer tasks;
            volatile java.lang.Thread thread;

            public InterruptibleRunnable(java.lang.Runnable runnable, io.reactivex.internal.disposables.DisposableContainer disposableContainer) {
                this.run = runnable;
                this.tasks = disposableContainer;
            }

            public void cleanup() {
                io.reactivex.internal.disposables.DisposableContainer disposableContainer = this.tasks;
                if (disposableContainer != null) {
                    disposableContainer.delete(this);
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                while (true) {
                    int i = get();
                    if (i >= 2) {
                        return;
                    }
                    if (i == 0) {
                        if (compareAndSet(0, 4)) {
                            cleanup();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        java.lang.Thread thread = this.thread;
                        if (thread != null) {
                            thread.interrupt();
                            this.thread = null;
                        }
                        set(4);
                        cleanup();
                        return;
                    }
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.thread = java.lang.Thread.currentThread();
                    if (!compareAndSet(0, 1)) {
                        this.thread = null;
                        return;
                    }
                    try {
                        this.run.run();
                        this.thread = null;
                        if (compareAndSet(1, 2)) {
                            cleanup();
                            return;
                        }
                        while (get() == 3) {
                            java.lang.Thread.yield();
                        }
                        java.lang.Thread.interrupted();
                    } catch (java.lang.Throwable th) {
                        this.thread = null;
                        if (compareAndSet(1, 2)) {
                            cleanup();
                        } else {
                            while (get() == 3) {
                                java.lang.Thread.yield();
                            }
                            java.lang.Thread.interrupted();
                        }
                        throw th;
                    }
                }
            }
        }

        public final class SequentialDispose implements java.lang.Runnable {
            public final io.reactivex.internal.disposables.SequentialDisposable n;
            public final java.lang.Runnable t;

            public SequentialDispose(io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable, java.lang.Runnable runnable) {
                this.n = sequentialDisposable;
                this.t = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.n.replace(io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.this.schedule(this.t));
            }
        }

        public ExecutorWorker(java.util.concurrent.Executor executor, boolean z) {
            this.t = executor;
            this.n = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.v) {
                return;
            }
            this.v = true;
            this.x.dispose();
            if (this.w.getAndIncrement() == 0) {
                this.u.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.v;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.reactivex.internal.queue.MpscLinkedQueue<java.lang.Runnable> mpscLinkedQueue = this.u;
            int i = 1;
            while (!this.v) {
                do {
                    java.lang.Runnable poll = mpscLinkedQueue.poll();
                    if (poll != null) {
                        poll.run();
                    } else if (this.v) {
                        mpscLinkedQueue.clear();
                        return;
                    } else {
                        i = this.w.addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                } while (!this.v);
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.clear();
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
            io.reactivex.disposables.Disposable booleanRunnable;
            if (this.v) {
                return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
            }
            java.lang.Runnable onSchedule = io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable);
            if (this.n) {
                booleanRunnable = new io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.InterruptibleRunnable(onSchedule, this.x);
                this.x.add(booleanRunnable);
            } else {
                booleanRunnable = new io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.BooleanRunnable(onSchedule);
            }
            this.u.offer(booleanRunnable);
            if (this.w.getAndIncrement() == 0) {
                try {
                    this.t.execute(this);
                } catch (java.util.concurrent.RejectedExecutionException e) {
                    this.v = true;
                    this.u.clear();
                    io.reactivex.plugins.RxJavaPlugins.onError(e);
                    return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
                }
            }
            return booleanRunnable;
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
            if (j <= 0) {
                return schedule(runnable);
            }
            if (this.v) {
                return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
            }
            io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable = new io.reactivex.internal.disposables.SequentialDisposable();
            io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable2 = new io.reactivex.internal.disposables.SequentialDisposable(sequentialDisposable);
            io.reactivex.internal.schedulers.ScheduledRunnable scheduledRunnable = new io.reactivex.internal.schedulers.ScheduledRunnable(new io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.SequentialDispose(sequentialDisposable2, io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable)), this.x);
            this.x.add(scheduledRunnable);
            java.util.concurrent.Executor executor = this.t;
            if (executor instanceof java.util.concurrent.ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((java.util.concurrent.ScheduledExecutorService) executor).schedule((java.util.concurrent.Callable) scheduledRunnable, j, timeUnit));
                } catch (java.util.concurrent.RejectedExecutionException e) {
                    this.v = true;
                    io.reactivex.plugins.RxJavaPlugins.onError(e);
                    return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new io.reactivex.internal.schedulers.DisposeOnCancel(io.reactivex.internal.schedulers.ExecutorScheduler.v.scheduleDirect(scheduledRunnable, j, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }
    }

    public ExecutorScheduler(@io.reactivex.annotations.NonNull java.util.concurrent.Executor executor, boolean z) {
        this.u = executor;
        this.t = z;
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.Scheduler.Worker createWorker() {
        return new io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker(this.u, this.t);
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable scheduleDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
        java.lang.Runnable onSchedule = io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable);
        try {
            if (this.u instanceof java.util.concurrent.ExecutorService) {
                io.reactivex.internal.schedulers.ScheduledDirectTask scheduledDirectTask = new io.reactivex.internal.schedulers.ScheduledDirectTask(onSchedule);
                scheduledDirectTask.setFuture(((java.util.concurrent.ExecutorService) this.u).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (this.t) {
                io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.InterruptibleRunnable(onSchedule, null);
                this.u.execute(interruptibleRunnable);
                return interruptibleRunnable;
            }
            io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.BooleanRunnable booleanRunnable = new io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.BooleanRunnable(onSchedule);
            this.u.execute(booleanRunnable);
            return booleanRunnable;
        } catch (java.util.concurrent.RejectedExecutionException e) {
            io.reactivex.plugins.RxJavaPlugins.onError(e);
            return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable scheduleDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        java.lang.Runnable onSchedule = io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable);
        if (!(this.u instanceof java.util.concurrent.ScheduledExecutorService)) {
            io.reactivex.internal.schedulers.ExecutorScheduler.DelayedRunnable delayedRunnable = new io.reactivex.internal.schedulers.ExecutorScheduler.DelayedRunnable(onSchedule);
            delayedRunnable.timed.replace(v.scheduleDirect(new io.reactivex.internal.schedulers.ExecutorScheduler.DelayedDispose(delayedRunnable), j, timeUnit));
            return delayedRunnable;
        }
        try {
            io.reactivex.internal.schedulers.ScheduledDirectTask scheduledDirectTask = new io.reactivex.internal.schedulers.ScheduledDirectTask(onSchedule);
            scheduledDirectTask.setFuture(((java.util.concurrent.ScheduledExecutorService) this.u).schedule(scheduledDirectTask, j, timeUnit));
            return scheduledDirectTask;
        } catch (java.util.concurrent.RejectedExecutionException e) {
            io.reactivex.plugins.RxJavaPlugins.onError(e);
            return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable schedulePeriodicallyDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        if (!(this.u instanceof java.util.concurrent.ScheduledExecutorService)) {
            return super.schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
        }
        try {
            io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask(io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable));
            scheduledDirectPeriodicTask.setFuture(((java.util.concurrent.ScheduledExecutorService) this.u).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (java.util.concurrent.RejectedExecutionException e) {
            io.reactivex.plugins.RxJavaPlugins.onError(e);
            return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
        }
    }
}
