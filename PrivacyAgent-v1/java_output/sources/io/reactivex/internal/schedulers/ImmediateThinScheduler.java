package io.reactivex.internal.schedulers;

/* loaded from: classes13.dex */
public final class ImmediateThinScheduler extends io.reactivex.Scheduler {
    public static final io.reactivex.Scheduler INSTANCE = new io.reactivex.internal.schedulers.ImmediateThinScheduler();
    public static final io.reactivex.Scheduler.Worker t = new io.reactivex.internal.schedulers.ImmediateThinScheduler.ImmediateThinWorker();
    public static final io.reactivex.disposables.Disposable u;

    public static final class ImmediateThinWorker extends io.reactivex.Scheduler.Worker {
        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
            runnable.run();
            return io.reactivex.internal.schedulers.ImmediateThinScheduler.u;
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
            throw new java.lang.UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // io.reactivex.Scheduler.Worker
        @io.reactivex.annotations.NonNull
        public io.reactivex.disposables.Disposable schedulePeriodically(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
            throw new java.lang.UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }
    }

    static {
        io.reactivex.disposables.Disposable empty = io.reactivex.disposables.Disposables.empty();
        u = empty;
        empty.dispose();
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.Scheduler.Worker createWorker() {
        return t;
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable scheduleDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
        runnable.run();
        return u;
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable scheduleDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        throw new java.lang.UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // io.reactivex.Scheduler
    @io.reactivex.annotations.NonNull
    public io.reactivex.disposables.Disposable schedulePeriodicallyDirect(@io.reactivex.annotations.NonNull java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        throw new java.lang.UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }
}
