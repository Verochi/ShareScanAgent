package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public final class ComputationScheduler extends io.reactivex.Scheduler implements io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport {
    public static final io.reactivex.internal.schedulers.ComputationScheduler.FixedSchedulerPool v;
    public static final io.reactivex.internal.schedulers.RxThreadFactory w;
    public static final int x = a(java.lang.Runtime.getRuntime().availableProcessors(), java.lang.Integer.getInteger("rx2.computation-threads", 0).intValue());
    public static final io.reactivex.internal.schedulers.ComputationScheduler.PoolWorker y;
    public final java.util.concurrent.ThreadFactory t;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.schedulers.ComputationScheduler.FixedSchedulerPool> u;

    public static final class EventLoopWorker extends io.reactivex.Scheduler.Worker {
        public final io.reactivex.internal.disposables.ListCompositeDisposable n;
        public final io.reactivex.disposables.CompositeDisposable t;
        public final io.reactivex.internal.disposables.ListCompositeDisposable u;
        public final io.reactivex.internal.schedulers.ComputationScheduler.PoolWorker v;
        public volatile boolean w;

        public EventLoopWorker(io.reactivex.internal.schedulers.ComputationScheduler.PoolWorker poolWorker) {
            this.v = poolWorker;
            io.reactivex.internal.disposables.ListCompositeDisposable listCompositeDisposable = new io.reactivex.internal.disposables.ListCompositeDisposable();
            this.n = listCompositeDisposable;
            io.reactivex.disposables.CompositeDisposable compositeDisposable = new io.reactivex.disposables.CompositeDisposable();
            this.t = compositeDisposable;
            io.reactivex.internal.disposables.ListCompositeDisposable listCompositeDisposable2 = new io.reactivex.internal.disposables.ListCompositeDisposable();
            this.u = listCompositeDisposable2;
            listCompositeDisposable2.add(listCompositeDisposable);
            listCompositeDisposable2.add(compositeDisposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.w) {
                return;
            }
            this.w = true;
            this.u.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w;
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
            return this.w ? io.reactivex.internal.disposables.EmptyDisposable.INSTANCE : this.v.scheduleActual(runnable, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, this.n);
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
            return this.w ? io.reactivex.internal.disposables.EmptyDisposable.INSTANCE : this.v.scheduleActual(runnable, j, timeUnit, this.t);
        }
    }

    public static final class FixedSchedulerPool implements io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport {
        public final int n;
        public final io.reactivex.internal.schedulers.ComputationScheduler.PoolWorker[] t;
        public long u;

        public FixedSchedulerPool(int i, java.util.concurrent.ThreadFactory threadFactory) {
            this.n = i;
            this.t = new io.reactivex.internal.schedulers.ComputationScheduler.PoolWorker[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.t[i2] = new io.reactivex.internal.schedulers.ComputationScheduler.PoolWorker(threadFactory);
            }
        }

        public io.reactivex.internal.schedulers.ComputationScheduler.PoolWorker a() {
            int i = this.n;
            if (i == 0) {
                return io.reactivex.internal.schedulers.ComputationScheduler.y;
            }
            io.reactivex.internal.schedulers.ComputationScheduler.PoolWorker[] poolWorkerArr = this.t;
            long j = this.u;
            this.u = 1 + j;
            return poolWorkerArr[(int) (j % i)];
        }

        public void b() {
            for (io.reactivex.internal.schedulers.ComputationScheduler.PoolWorker poolWorker : this.t) {
                poolWorker.dispose();
            }
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
        public void createWorkers(int i, io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
            int i2 = this.n;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    workerCallback.onWorker(i3, io.reactivex.internal.schedulers.ComputationScheduler.y);
                }
                return;
            }
            int i4 = ((int) this.u) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                workerCallback.onWorker(i5, new io.reactivex.internal.schedulers.ComputationScheduler.EventLoopWorker(this.t[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.u = i4;
        }
    }

    public static final class PoolWorker extends io.reactivex.internal.schedulers.NewThreadWorker {
        public PoolWorker(java.util.concurrent.ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        io.reactivex.internal.schedulers.ComputationScheduler.PoolWorker poolWorker = new io.reactivex.internal.schedulers.ComputationScheduler.PoolWorker(new io.reactivex.internal.schedulers.RxThreadFactory("RxComputationShutdown"));
        y = poolWorker;
        poolWorker.dispose();
        io.reactivex.internal.schedulers.RxThreadFactory rxThreadFactory = new io.reactivex.internal.schedulers.RxThreadFactory("RxComputationThreadPool", java.lang.Math.max(1, java.lang.Math.min(10, java.lang.Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        w = rxThreadFactory;
        io.reactivex.internal.schedulers.ComputationScheduler.FixedSchedulerPool fixedSchedulerPool = new io.reactivex.internal.schedulers.ComputationScheduler.FixedSchedulerPool(0, rxThreadFactory);
        v = fixedSchedulerPool;
        fixedSchedulerPool.b();
    }

    public ComputationScheduler() {
        this(w);
    }

    public ComputationScheduler(java.util.concurrent.ThreadFactory threadFactory) {
        this.t = threadFactory;
        this.u = new java.util.concurrent.atomic.AtomicReference<>(v);
        start();
    }

    public static int a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.Scheduler.Worker createWorker() {
        return new io.reactivex.internal.schedulers.ComputationScheduler.EventLoopWorker(this.u.get().a());
    }

    @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
    public void createWorkers(int i, io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "number > 0 required");
        this.u.get().createWorkers(i, workerCallback);
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable scheduleDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        return this.u.get().a().scheduleDirect(runnable, j, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable schedulePeriodicallyDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        return this.u.get().a().schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        io.reactivex.internal.schedulers.ComputationScheduler.FixedSchedulerPool fixedSchedulerPool;
        io.reactivex.internal.schedulers.ComputationScheduler.FixedSchedulerPool fixedSchedulerPool2;
        do {
            fixedSchedulerPool = this.u.get();
            fixedSchedulerPool2 = v;
            if (fixedSchedulerPool == fixedSchedulerPool2) {
                return;
            }
        } while (!defpackage.xv0.a(this.u, fixedSchedulerPool, fixedSchedulerPool2));
        fixedSchedulerPool.b();
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        io.reactivex.internal.schedulers.ComputationScheduler.FixedSchedulerPool fixedSchedulerPool = new io.reactivex.internal.schedulers.ComputationScheduler.FixedSchedulerPool(x, this.t);
        if (defpackage.xv0.a(this.u, v, fixedSchedulerPool)) {
            return;
        }
        fixedSchedulerPool.b();
    }
}
