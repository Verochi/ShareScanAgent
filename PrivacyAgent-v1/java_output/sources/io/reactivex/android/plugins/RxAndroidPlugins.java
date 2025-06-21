package io.reactivex.android.plugins;

/* loaded from: classes9.dex */
public final class RxAndroidPlugins {
    public static volatile io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler> a;
    public static volatile io.reactivex.functions.Function<io.reactivex.Scheduler, io.reactivex.Scheduler> b;

    public RxAndroidPlugins() {
        throw new java.lang.AssertionError("No instances.");
    }

    public static <T, R> R a(io.reactivex.functions.Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (java.lang.Throwable th) {
            throw io.reactivex.exceptions.Exceptions.propagate(th);
        }
    }

    public static io.reactivex.Scheduler b(io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler> function, java.util.concurrent.Callable<io.reactivex.Scheduler> callable) {
        io.reactivex.Scheduler scheduler = (io.reactivex.Scheduler) a(function, callable);
        if (scheduler != null) {
            return scheduler;
        }
        throw new java.lang.NullPointerException("Scheduler Callable returned null");
    }

    public static io.reactivex.Scheduler c(java.util.concurrent.Callable<io.reactivex.Scheduler> callable) {
        try {
            io.reactivex.Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new java.lang.NullPointerException("Scheduler Callable returned null");
        } catch (java.lang.Throwable th) {
            throw io.reactivex.exceptions.Exceptions.propagate(th);
        }
    }

    public static io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler> getInitMainThreadSchedulerHandler() {
        return a;
    }

    public static io.reactivex.functions.Function<io.reactivex.Scheduler, io.reactivex.Scheduler> getOnMainThreadSchedulerHandler() {
        return b;
    }

    public static io.reactivex.Scheduler initMainThreadScheduler(java.util.concurrent.Callable<io.reactivex.Scheduler> callable) {
        if (callable == null) {
            throw new java.lang.NullPointerException("scheduler == null");
        }
        io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler> function = a;
        return function == null ? c(callable) : b(function, callable);
    }

    public static io.reactivex.Scheduler onMainThreadScheduler(io.reactivex.Scheduler scheduler) {
        if (scheduler == null) {
            throw new java.lang.NullPointerException("scheduler == null");
        }
        io.reactivex.functions.Function<io.reactivex.Scheduler, io.reactivex.Scheduler> function = b;
        return function == null ? scheduler : (io.reactivex.Scheduler) a(function, scheduler);
    }

    public static void reset() {
        setInitMainThreadSchedulerHandler(null);
        setMainThreadSchedulerHandler(null);
    }

    public static void setInitMainThreadSchedulerHandler(io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler> function) {
        a = function;
    }

    public static void setMainThreadSchedulerHandler(io.reactivex.functions.Function<io.reactivex.Scheduler, io.reactivex.Scheduler> function) {
        b = function;
    }
}
