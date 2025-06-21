package io.reactivex.schedulers;

/* loaded from: classes13.dex */
public final class TestScheduler extends io.reactivex.Scheduler {
    public final java.util.Queue<io.reactivex.schedulers.TestScheduler.TimedRunnable> t = new java.util.concurrent.PriorityBlockingQueue(11);
    public long u;
    public volatile long v;

    public final class TestWorker extends io.reactivex.Scheduler.Worker {
        public volatile boolean n;

        public final class QueueRemove implements java.lang.Runnable {
            public final io.reactivex.schedulers.TestScheduler.TimedRunnable n;

            public QueueRemove(io.reactivex.schedulers.TestScheduler.TimedRunnable timedRunnable) {
                this.n = timedRunnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                io.reactivex.schedulers.TestScheduler.this.t.remove(this.n);
            }
        }

        public TestWorker() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.n = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.n;
        }

        @Override // io.reactivex.Scheduler.Worker
        public long now(@io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
            return io.reactivex.schedulers.TestScheduler.this.now(timeUnit);
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
            if (this.n) {
                return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
            }
            io.reactivex.schedulers.TestScheduler testScheduler = io.reactivex.schedulers.TestScheduler.this;
            long j = testScheduler.u;
            testScheduler.u = 1 + j;
            io.reactivex.schedulers.TestScheduler.TimedRunnable timedRunnable = new io.reactivex.schedulers.TestScheduler.TimedRunnable(this, 0L, runnable, j);
            io.reactivex.schedulers.TestScheduler.this.t.add(timedRunnable);
            return io.reactivex.disposables.Disposables.fromRunnable(new io.reactivex.schedulers.TestScheduler.TestWorker.QueueRemove(timedRunnable));
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
            if (this.n) {
                return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
            }
            long nanos = io.reactivex.schedulers.TestScheduler.this.v + timeUnit.toNanos(j);
            io.reactivex.schedulers.TestScheduler testScheduler = io.reactivex.schedulers.TestScheduler.this;
            long j2 = testScheduler.u;
            testScheduler.u = 1 + j2;
            io.reactivex.schedulers.TestScheduler.TimedRunnable timedRunnable = new io.reactivex.schedulers.TestScheduler.TimedRunnable(this, nanos, runnable, j2);
            io.reactivex.schedulers.TestScheduler.this.t.add(timedRunnable);
            return io.reactivex.disposables.Disposables.fromRunnable(new io.reactivex.schedulers.TestScheduler.TestWorker.QueueRemove(timedRunnable));
        }
    }

    public static final class TimedRunnable implements java.lang.Comparable<io.reactivex.schedulers.TestScheduler.TimedRunnable> {
        public final long n;
        public final java.lang.Runnable t;
        public final io.reactivex.schedulers.TestScheduler.TestWorker u;
        public final long v;

        public TimedRunnable(io.reactivex.schedulers.TestScheduler.TestWorker testWorker, long j, java.lang.Runnable runnable, long j2) {
            this.n = j;
            this.t = runnable;
            this.u = testWorker;
            this.v = j2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(io.reactivex.schedulers.TestScheduler.TimedRunnable timedRunnable) {
            long j = this.n;
            long j2 = timedRunnable.n;
            return j == j2 ? io.reactivex.internal.functions.ObjectHelper.compare(this.v, timedRunnable.v) : io.reactivex.internal.functions.ObjectHelper.compare(j, j2);
        }

        public java.lang.String toString() {
            return java.lang.String.format("TimedRunnable(time = %d, run = %s)", java.lang.Long.valueOf(this.n), this.t.toString());
        }
    }

    public TestScheduler() {
    }

    public TestScheduler(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.v = timeUnit.toNanos(j);
    }

    public final void a(long j) {
        while (true) {
            io.reactivex.schedulers.TestScheduler.TimedRunnable peek = this.t.peek();
            if (peek == null) {
                break;
            }
            long j2 = peek.n;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.v;
            }
            this.v = j2;
            this.t.remove(peek);
            if (!peek.u.n) {
                peek.t.run();
            }
        }
        this.v = j;
    }

    public void advanceTimeBy(long j, java.util.concurrent.TimeUnit timeUnit) {
        advanceTimeTo(this.v + timeUnit.toNanos(j), java.util.concurrent.TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j, java.util.concurrent.TimeUnit timeUnit) {
        a(timeUnit.toNanos(j));
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.Scheduler.Worker createWorker() {
        return new io.reactivex.schedulers.TestScheduler.TestWorker();
    }

    @Override // io.reactivex.Scheduler
    public long now(@io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.v, java.util.concurrent.TimeUnit.NANOSECONDS);
    }

    public void triggerActions() {
        a(this.v);
    }
}
