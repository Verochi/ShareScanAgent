package io.reactivex;

/* loaded from: classes9.dex */
public abstract class Scheduler {
    public static final long n = java.util.concurrent.TimeUnit.MINUTES.toNanos(java.lang.Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public static final class DisposeTask implements io.reactivex.disposables.Disposable, java.lang.Runnable, io.reactivex.schedulers.SchedulerRunnableIntrospection {

        @io.reactivex.annotations.NonNull
        public final java.lang.Runnable n;

        @io.reactivex.annotations.NonNull
        public final io.reactivex.Scheduler.Worker t;

        @io.reactivex.annotations.Nullable
        public java.lang.Thread u;

        public DisposeTask(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, @io.reactivex.annotations.NonNull io.reactivex.Scheduler.Worker worker) {
            this.n = runnable;
            this.t = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.u == java.lang.Thread.currentThread()) {
                io.reactivex.Scheduler.Worker worker = this.t;
                if (worker instanceof io.reactivex.internal.schedulers.NewThreadWorker) {
                    ((io.reactivex.internal.schedulers.NewThreadWorker) worker).shutdown();
                    return;
                }
            }
            this.t.dispose();
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public java.lang.Runnable getWrappedRunnable() {
            return this.n;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.u = java.lang.Thread.currentThread();
            try {
                this.n.run();
            } finally {
                dispose();
                this.u = null;
            }
        }
    }

    public static final class PeriodicDirectTask implements io.reactivex.disposables.Disposable, java.lang.Runnable, io.reactivex.schedulers.SchedulerRunnableIntrospection {

        @io.reactivex.annotations.NonNull
        public final java.lang.Runnable n;

        @io.reactivex.annotations.NonNull
        public final io.reactivex.Scheduler.Worker t;
        public volatile boolean u;

        public PeriodicDirectTask(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, @io.reactivex.annotations.NonNull io.reactivex.Scheduler.Worker worker) {
            this.n = runnable;
            this.t = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u = true;
            this.t.dispose();
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public java.lang.Runnable getWrappedRunnable() {
            return this.n;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.u) {
                return;
            }
            try {
                this.n.run();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.t.dispose();
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
            }
        }
    }

    public static abstract class Worker implements io.reactivex.disposables.Disposable {

        public final class PeriodicTask implements java.lang.Runnable, io.reactivex.schedulers.SchedulerRunnableIntrospection {

            @io.reactivex.annotations.NonNull
            public final java.lang.Runnable n;

            @io.reactivex.annotations.NonNull
            public final io.reactivex.internal.disposables.SequentialDisposable t;
            public final long u;
            public long v;
            public long w;
            public long x;

            public PeriodicTask(long j, @io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j2, @io.reactivex.annotations.NonNull io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable, long j3) {
                this.n = runnable;
                this.t = sequentialDisposable;
                this.u = j3;
                this.w = j2;
                this.x = j;
            }

            @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
            public java.lang.Runnable getWrappedRunnable() {
                return this.n;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.n.run();
                if (this.t.isDisposed()) {
                    return;
                }
                io.reactivex.Scheduler.Worker worker = io.reactivex.Scheduler.Worker.this;
                java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS;
                long now = worker.now(timeUnit);
                long j2 = io.reactivex.Scheduler.n;
                long j3 = now + j2;
                long j4 = this.w;
                if (j3 >= j4) {
                    long j5 = this.u;
                    if (now < j4 + j5 + j2) {
                        long j6 = this.x;
                        long j7 = this.v + 1;
                        this.v = j7;
                        j = j6 + (j7 * j5);
                        this.w = now;
                        this.t.replace(io.reactivex.Scheduler.Worker.this.schedule(this, j - now, timeUnit));
                    }
                }
                long j8 = this.u;
                long j9 = now + j8;
                long j10 = this.v + 1;
                this.v = j10;
                this.x = j9 - (j8 * j10);
                j = j9;
                this.w = now;
                this.t.replace(io.reactivex.Scheduler.Worker.this.schedule(this, j - now, timeUnit));
            }
        }

        public long now(@io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
            return timeUnit.convert(java.lang.System.currentTimeMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
        }

        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
            return schedule(runnable, 0L, java.util.concurrent.TimeUnit.NANOSECONDS);
        }

        @io.reactivex.annotations.NonNull
        public abstract io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit);

        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedulePeriodically(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, long j2, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
            io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable = new io.reactivex.internal.disposables.SequentialDisposable();
            io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable2 = new io.reactivex.internal.disposables.SequentialDisposable(sequentialDisposable);
            java.lang.Runnable onSchedule = io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable);
            long nanos = timeUnit.toNanos(j2);
            long now = now(java.util.concurrent.TimeUnit.NANOSECONDS);
            io.reactivex.disposables.Disposable schedule = schedule(new io.reactivex.Scheduler.Worker.PeriodicTask(now + timeUnit.toNanos(j), onSchedule, now, sequentialDisposable2, nanos), j, timeUnit);
            if (schedule == io.reactivex.internal.disposables.EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable.replace(schedule);
            return sequentialDisposable2;
        }
    }

    public static long clockDriftTolerance() {
        return n;
    }

    @io.reactivex.annotations.NonNull
    public abstract io.reactivex.Scheduler.Worker createWorker();

    public long now(@io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(java.lang.System.currentTimeMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable scheduleDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
        return scheduleDirect(runnable, 0L, java.util.concurrent.TimeUnit.NANOSECONDS);
    }

    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable scheduleDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
        io.reactivex.Scheduler.Worker createWorker = createWorker();
        io.reactivex.Scheduler.DisposeTask disposeTask = new io.reactivex.Scheduler.DisposeTask(io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable), createWorker);
        createWorker.schedule(disposeTask, j, timeUnit);
        return disposeTask;
    }

    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable schedulePeriodicallyDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, long j2, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
        io.reactivex.Scheduler.Worker createWorker = createWorker();
        io.reactivex.Scheduler.PeriodicDirectTask periodicDirectTask = new io.reactivex.Scheduler.PeriodicDirectTask(io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable), createWorker);
        io.reactivex.disposables.Disposable schedulePeriodically = createWorker.schedulePeriodically(periodicDirectTask, j, j2, timeUnit);
        return schedulePeriodically == io.reactivex.internal.disposables.EmptyDisposable.INSTANCE ? schedulePeriodically : periodicDirectTask;
    }

    public void shutdown() {
    }

    public void start() {
    }

    @io.reactivex.annotations.NonNull
    public <S extends io.reactivex.Scheduler & io.reactivex.disposables.Disposable> S when(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<io.reactivex.Flowable<io.reactivex.Flowable<io.reactivex.Completable>>, io.reactivex.Completable> function) {
        return new io.reactivex.internal.schedulers.SchedulerWhen(function, this);
    }
}
