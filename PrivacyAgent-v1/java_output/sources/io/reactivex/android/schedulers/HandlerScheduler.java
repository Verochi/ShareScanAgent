package io.reactivex.android.schedulers;

/* loaded from: classes9.dex */
final class HandlerScheduler extends io.reactivex.Scheduler {
    public final android.os.Handler t;
    public final boolean u;

    public static final class HandlerWorker extends io.reactivex.Scheduler.Worker {
        public final android.os.Handler n;
        public final boolean t;
        public volatile boolean u;

        public HandlerWorker(android.os.Handler handler, boolean z) {
            this.n = handler;
            this.t = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u = true;
            this.n.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u;
        }

        @Override // io.reactivex.Scheduler.Worker
        @android.annotation.SuppressLint({"NewApi"})
        public io.reactivex.disposables.Disposable schedule(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
            if (runnable == null) {
                throw new java.lang.NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new java.lang.NullPointerException("unit == null");
            }
            if (this.u) {
                return io.reactivex.disposables.Disposables.disposed();
            }
            io.reactivex.android.schedulers.HandlerScheduler.ScheduledRunnable scheduledRunnable = new io.reactivex.android.schedulers.HandlerScheduler.ScheduledRunnable(this.n, io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable));
            android.os.Message obtain = android.os.Message.obtain(this.n, scheduledRunnable);
            obtain.obj = this;
            if (this.t) {
                obtain.setAsynchronous(true);
            }
            this.n.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (!this.u) {
                return scheduledRunnable;
            }
            this.n.removeCallbacks(scheduledRunnable);
            return io.reactivex.disposables.Disposables.disposed();
        }
    }

    public static final class ScheduledRunnable implements java.lang.Runnable, io.reactivex.disposables.Disposable {
        public final android.os.Handler n;
        public final java.lang.Runnable t;
        public volatile boolean u;

        public ScheduledRunnable(android.os.Handler handler, java.lang.Runnable runnable) {
            this.n = handler;
            this.t = runnable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.n.removeCallbacks(this);
            this.u = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.t.run();
            } catch (java.lang.Throwable th) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }
    }

    public HandlerScheduler(android.os.Handler handler, boolean z) {
        this.t = handler;
        this.u = z;
    }

    @Override // io.reactivex.Scheduler
    public io.reactivex.Scheduler.Worker createWorker() {
        return new io.reactivex.android.schedulers.HandlerScheduler.HandlerWorker(this.t, this.u);
    }

    @Override // io.reactivex.Scheduler
    @android.annotation.SuppressLint({"NewApi"})
    public io.reactivex.disposables.Disposable scheduleDirect(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        if (runnable == null) {
            throw new java.lang.NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new java.lang.NullPointerException("unit == null");
        }
        io.reactivex.android.schedulers.HandlerScheduler.ScheduledRunnable scheduledRunnable = new io.reactivex.android.schedulers.HandlerScheduler.ScheduledRunnable(this.t, io.reactivex.plugins.RxJavaPlugins.onSchedule(runnable));
        android.os.Message obtain = android.os.Message.obtain(this.t, scheduledRunnable);
        if (this.u) {
            obtain.setAsynchronous(true);
        }
        this.t.sendMessageDelayed(obtain, timeUnit.toMillis(j));
        return scheduledRunnable;
    }
}
