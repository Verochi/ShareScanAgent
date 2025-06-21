package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public final class TrampolineScheduler extends io.reactivex.Scheduler {
    public static final io.reactivex.internal.schedulers.TrampolineScheduler t = new io.reactivex.internal.schedulers.TrampolineScheduler();

    public static final class SleepingRunnable implements java.lang.Runnable {
        public final java.lang.Runnable n;
        public final io.reactivex.internal.schedulers.TrampolineScheduler.TrampolineWorker t;
        public final long u;

        public SleepingRunnable(java.lang.Runnable runnable, io.reactivex.internal.schedulers.TrampolineScheduler.TrampolineWorker trampolineWorker, long j) {
            this.n = runnable;
            this.t = trampolineWorker;
            this.u = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.t.v) {
                return;
            }
            long now = this.t.now(java.util.concurrent.TimeUnit.MILLISECONDS);
            long j = this.u;
            if (j > now) {
                try {
                    java.lang.Thread.sleep(j - now);
                } catch (java.lang.InterruptedException e) {
                    java.lang.Thread.currentThread().interrupt();
                    io.reactivex.plugins.RxJavaPlugins.onError(e);
                    return;
                }
            }
            if (this.t.v) {
                return;
            }
            this.n.run();
        }
    }

    public static final class TimedRunnable implements java.lang.Comparable<io.reactivex.internal.schedulers.TrampolineScheduler.TimedRunnable> {
        public final java.lang.Runnable n;
        public final long t;
        public final int u;
        public volatile boolean v;

        public TimedRunnable(java.lang.Runnable runnable, java.lang.Long l, int i) {
            this.n = runnable;
            this.t = l.longValue();
            this.u = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(io.reactivex.internal.schedulers.TrampolineScheduler.TimedRunnable timedRunnable) {
            int compare = io.reactivex.internal.functions.ObjectHelper.compare(this.t, timedRunnable.t);
            return compare == 0 ? io.reactivex.internal.functions.ObjectHelper.compare(this.u, timedRunnable.u) : compare;
        }
    }

    public static final class TrampolineWorker extends io.reactivex.Scheduler.Worker {
        public final java.util.concurrent.PriorityBlockingQueue<io.reactivex.internal.schedulers.TrampolineScheduler.TimedRunnable> n = new java.util.concurrent.PriorityBlockingQueue<>();
        public final java.util.concurrent.atomic.AtomicInteger t = new java.util.concurrent.atomic.AtomicInteger();
        public final java.util.concurrent.atomic.AtomicInteger u = new java.util.concurrent.atomic.AtomicInteger();
        public volatile boolean v;

        public final class AppendToQueueTask implements java.lang.Runnable {
            public final io.reactivex.internal.schedulers.TrampolineScheduler.TimedRunnable n;

            public AppendToQueueTask(io.reactivex.internal.schedulers.TrampolineScheduler.TimedRunnable timedRunnable) {
                this.n = timedRunnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.n.v = true;
                io.reactivex.internal.schedulers.TrampolineScheduler.TrampolineWorker.this.n.remove(this.n);
            }
        }

        public io.reactivex.disposables.Disposable a(java.lang.Runnable runnable, long j) {
            if (this.v) {
                return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
            }
            io.reactivex.internal.schedulers.TrampolineScheduler.TimedRunnable timedRunnable = new io.reactivex.internal.schedulers.TrampolineScheduler.TimedRunnable(runnable, java.lang.Long.valueOf(j), this.u.incrementAndGet());
            this.n.add(timedRunnable);
            if (this.t.getAndIncrement() != 0) {
                return io.reactivex.disposables.Disposables.fromRunnable(new io.reactivex.internal.schedulers.TrampolineScheduler.TrampolineWorker.AppendToQueueTask(timedRunnable));
            }
            int i = 1;
            while (!this.v) {
                io.reactivex.internal.schedulers.TrampolineScheduler.TimedRunnable poll = this.n.poll();
                if (poll == null) {
                    i = this.t.addAndGet(-i);
                    if (i == 0) {
                        return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.v) {
                    poll.n.run();
                }
            }
            this.n.clear();
            return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.v = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.v;
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
            return a(runnable, now(java.util.concurrent.TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
            long now = now(java.util.concurrent.TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return a(new io.reactivex.internal.schedulers.TrampolineScheduler.SleepingRunnable(runnable, this, now), now);
        }
    }

    public static io.reactivex.internal.schedulers.TrampolineScheduler instance() {
        return t;
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.Scheduler.Worker createWorker() {
        return new io.reactivex.internal.schedulers.TrampolineScheduler.TrampolineWorker();
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable scheduleDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
        io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable).run();
        return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable scheduleDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable).run();
        } catch (java.lang.InterruptedException e) {
            java.lang.Thread.currentThread().interrupt();
            io.reactivex.plugins.RxJavaPlugins.onError(e);
        }
        return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
    }
}
