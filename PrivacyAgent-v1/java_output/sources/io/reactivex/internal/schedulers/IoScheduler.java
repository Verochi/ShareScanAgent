package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public final class IoScheduler extends io.reactivex.Scheduler {
    public static final io.reactivex.internal.schedulers.IoScheduler.CachedWorkerPool A;
    public static final long KEEP_ALIVE_TIME_DEFAULT = 60;
    public static final io.reactivex.internal.schedulers.RxThreadFactory v;
    public static final io.reactivex.internal.schedulers.RxThreadFactory w;
    public static final io.reactivex.internal.schedulers.IoScheduler.ThreadWorker z;
    public final java.util.concurrent.ThreadFactory t;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.schedulers.IoScheduler.CachedWorkerPool> u;
    public static final java.util.concurrent.TimeUnit y = java.util.concurrent.TimeUnit.SECONDS;
    public static final long x = java.lang.Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    public static final class CachedWorkerPool implements java.lang.Runnable {
        public final long n;
        public final java.util.concurrent.ConcurrentLinkedQueue<io.reactivex.internal.schedulers.IoScheduler.ThreadWorker> t;
        public final io.reactivex.disposables.CompositeDisposable u;
        public final java.util.concurrent.ScheduledExecutorService v;
        public final java.util.concurrent.Future<?> w;
        public final java.util.concurrent.ThreadFactory x;

        public CachedWorkerPool(long j, java.util.concurrent.TimeUnit timeUnit, java.util.concurrent.ThreadFactory threadFactory) {
            java.util.concurrent.ScheduledExecutorService scheduledExecutorService;
            java.util.concurrent.ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.n = nanos;
            this.t = new java.util.concurrent.ConcurrentLinkedQueue<>();
            this.u = new io.reactivex.disposables.CompositeDisposable();
            this.x = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = java.util.concurrent.Executors.newScheduledThreadPool(1, io.reactivex.internal.schedulers.IoScheduler.w);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, java.util.concurrent.TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.v = scheduledExecutorService;
            this.w = scheduledFuture;
        }

        public void a() {
            if (this.t.isEmpty()) {
                return;
            }
            long c = c();
            java.util.Iterator<io.reactivex.internal.schedulers.IoScheduler.ThreadWorker> it = this.t.iterator();
            while (it.hasNext()) {
                io.reactivex.internal.schedulers.IoScheduler.ThreadWorker next = it.next();
                if (next.a() > c) {
                    return;
                }
                if (this.t.remove(next)) {
                    this.u.remove(next);
                }
            }
        }

        public io.reactivex.internal.schedulers.IoScheduler.ThreadWorker b() {
            if (this.u.isDisposed()) {
                return io.reactivex.internal.schedulers.IoScheduler.z;
            }
            while (!this.t.isEmpty()) {
                io.reactivex.internal.schedulers.IoScheduler.ThreadWorker poll = this.t.poll();
                if (poll != null) {
                    return poll;
                }
            }
            io.reactivex.internal.schedulers.IoScheduler.ThreadWorker threadWorker = new io.reactivex.internal.schedulers.IoScheduler.ThreadWorker(this.x);
            this.u.add(threadWorker);
            return threadWorker;
        }

        public long c() {
            return java.lang.System.nanoTime();
        }

        public void d(io.reactivex.internal.schedulers.IoScheduler.ThreadWorker threadWorker) {
            threadWorker.b(c() + this.n);
            this.t.offer(threadWorker);
        }

        public void e() {
            this.u.dispose();
            java.util.concurrent.Future<?> future = this.w;
            if (future != null) {
                future.cancel(true);
            }
            java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.v;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    public static final class EventLoopWorker extends io.reactivex.Scheduler.Worker {
        public final io.reactivex.internal.schedulers.IoScheduler.CachedWorkerPool t;
        public final io.reactivex.internal.schedulers.IoScheduler.ThreadWorker u;
        public final java.util.concurrent.atomic.AtomicBoolean v = new java.util.concurrent.atomic.AtomicBoolean();
        public final io.reactivex.disposables.CompositeDisposable n = new io.reactivex.disposables.CompositeDisposable();

        public EventLoopWorker(io.reactivex.internal.schedulers.IoScheduler.CachedWorkerPool cachedWorkerPool) {
            this.t = cachedWorkerPool;
            this.u = cachedWorkerPool.b();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.v.compareAndSet(false, true)) {
                this.n.dispose();
                this.t.d(this.u);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.v.get();
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
            return this.n.isDisposed() ? io.reactivex.internal.disposables.EmptyDisposable.INSTANCE : this.u.scheduleActual(runnable, j, timeUnit, this.n);
        }
    }

    public static final class ThreadWorker extends io.reactivex.internal.schedulers.NewThreadWorker {
        public long u;

        public ThreadWorker(java.util.concurrent.ThreadFactory threadFactory) {
            super(threadFactory);
            this.u = 0L;
        }

        public long a() {
            return this.u;
        }

        public void b(long j) {
            this.u = j;
        }
    }

    static {
        io.reactivex.internal.schedulers.IoScheduler.ThreadWorker threadWorker = new io.reactivex.internal.schedulers.IoScheduler.ThreadWorker(new io.reactivex.internal.schedulers.RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        z = threadWorker;
        threadWorker.dispose();
        int max = java.lang.Math.max(1, java.lang.Math.min(10, java.lang.Integer.getInteger("rx2.io-priority", 5).intValue()));
        io.reactivex.internal.schedulers.RxThreadFactory rxThreadFactory = new io.reactivex.internal.schedulers.RxThreadFactory("RxCachedThreadScheduler", max);
        v = rxThreadFactory;
        w = new io.reactivex.internal.schedulers.RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        io.reactivex.internal.schedulers.IoScheduler.CachedWorkerPool cachedWorkerPool = new io.reactivex.internal.schedulers.IoScheduler.CachedWorkerPool(0L, null, rxThreadFactory);
        A = cachedWorkerPool;
        cachedWorkerPool.e();
    }

    public IoScheduler() {
        this(v);
    }

    public IoScheduler(java.util.concurrent.ThreadFactory threadFactory) {
        this.t = threadFactory;
        this.u = new java.util.concurrent.atomic.AtomicReference<>(A);
        start();
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.Scheduler.Worker createWorker() {
        return new io.reactivex.internal.schedulers.IoScheduler.EventLoopWorker(this.u.get());
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        io.reactivex.internal.schedulers.IoScheduler.CachedWorkerPool cachedWorkerPool;
        io.reactivex.internal.schedulers.IoScheduler.CachedWorkerPool cachedWorkerPool2;
        do {
            cachedWorkerPool = this.u.get();
            cachedWorkerPool2 = A;
            if (cachedWorkerPool == cachedWorkerPool2) {
                return;
            }
        } while (!defpackage.xv0.a(this.u, cachedWorkerPool, cachedWorkerPool2));
        cachedWorkerPool.e();
    }

    public int size() {
        return this.u.get().u.size();
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        io.reactivex.internal.schedulers.IoScheduler.CachedWorkerPool cachedWorkerPool = new io.reactivex.internal.schedulers.IoScheduler.CachedWorkerPool(x, y, this.t);
        if (defpackage.xv0.a(this.u, A, cachedWorkerPool)) {
            return;
        }
        cachedWorkerPool.e();
    }
}
