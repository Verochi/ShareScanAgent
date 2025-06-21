package io.reactivex.schedulers;

/* loaded from: classes13.dex */
public final class Schedulers {

    @io.reactivex.annotations.NonNull
    public static final io.reactivex.Scheduler a = io.reactivex.plugins.RxJavaPlugins.initSingleScheduler(new io.reactivex.schedulers.Schedulers.SingleTask());

    @io.reactivex.annotations.NonNull
    public static final io.reactivex.Scheduler b = io.reactivex.plugins.RxJavaPlugins.initComputationScheduler(new io.reactivex.schedulers.Schedulers.ComputationTask());

    @io.reactivex.annotations.NonNull
    public static final io.reactivex.Scheduler c = io.reactivex.plugins.RxJavaPlugins.initIoScheduler(new io.reactivex.schedulers.Schedulers.IOTask());

    @io.reactivex.annotations.NonNull
    public static final io.reactivex.Scheduler d = io.reactivex.internal.schedulers.TrampolineScheduler.instance();

    @io.reactivex.annotations.NonNull
    public static final io.reactivex.Scheduler e = io.reactivex.plugins.RxJavaPlugins.initNewThreadScheduler(new io.reactivex.schedulers.Schedulers.NewThreadTask());

    public static final class ComputationHolder {
        public static final io.reactivex.Scheduler a = new io.reactivex.internal.schedulers.ComputationScheduler();
    }

    public static final class ComputationTask implements java.util.concurrent.Callable<io.reactivex.Scheduler> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public io.reactivex.Scheduler call() throws java.lang.Exception {
            return io.reactivex.schedulers.Schedulers.ComputationHolder.a;
        }
    }

    public static final class IOTask implements java.util.concurrent.Callable<io.reactivex.Scheduler> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public io.reactivex.Scheduler call() throws java.lang.Exception {
            return io.reactivex.schedulers.Schedulers.IoHolder.a;
        }
    }

    public static final class IoHolder {
        public static final io.reactivex.Scheduler a = new io.reactivex.internal.schedulers.IoScheduler();
    }

    public static final class NewThreadHolder {
        public static final io.reactivex.Scheduler a = new io.reactivex.internal.schedulers.NewThreadScheduler();
    }

    public static final class NewThreadTask implements java.util.concurrent.Callable<io.reactivex.Scheduler> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public io.reactivex.Scheduler call() throws java.lang.Exception {
            return io.reactivex.schedulers.Schedulers.NewThreadHolder.a;
        }
    }

    public static final class SingleHolder {
        public static final io.reactivex.Scheduler a = new io.reactivex.internal.schedulers.SingleScheduler();
    }

    public static final class SingleTask implements java.util.concurrent.Callable<io.reactivex.Scheduler> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public io.reactivex.Scheduler call() throws java.lang.Exception {
            return io.reactivex.schedulers.Schedulers.SingleHolder.a;
        }
    }

    public Schedulers() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler computation() {
        return io.reactivex.plugins.RxJavaPlugins.onComputationScheduler(b);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler from(@io.reactivex.annotations.NonNull java.util.concurrent.Executor executor) {
        return new io.reactivex.internal.schedulers.ExecutorScheduler(executor, false);
    }

    @io.reactivex.annotations.Experimental
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler from(@io.reactivex.annotations.NonNull java.util.concurrent.Executor executor, boolean z) {
        return new io.reactivex.internal.schedulers.ExecutorScheduler(executor, z);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler io() {
        return io.reactivex.plugins.RxJavaPlugins.onIoScheduler(c);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler newThread() {
        return io.reactivex.plugins.RxJavaPlugins.onNewThreadScheduler(e);
    }

    public static void shutdown() {
        computation().shutdown();
        io().shutdown();
        newThread().shutdown();
        single().shutdown();
        trampoline().shutdown();
        io.reactivex.internal.schedulers.SchedulerPoolFactory.shutdown();
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler single() {
        return io.reactivex.plugins.RxJavaPlugins.onSingleScheduler(a);
    }

    public static void start() {
        computation().start();
        io().start();
        newThread().start();
        single().start();
        trampoline().start();
        io.reactivex.internal.schedulers.SchedulerPoolFactory.start();
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler trampoline() {
        return d;
    }
}
