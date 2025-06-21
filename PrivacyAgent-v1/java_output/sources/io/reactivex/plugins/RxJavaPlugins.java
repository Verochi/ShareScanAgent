package io.reactivex.plugins;

/* loaded from: classes13.dex */
public final class RxJavaPlugins {

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Consumer<? super java.lang.Throwable> a;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super java.lang.Runnable, ? extends java.lang.Runnable> b;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> c;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> d;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> e;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> f;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> g;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> h;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> i;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> j;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super io.reactivex.Flowable, ? extends io.reactivex.Flowable> k;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super io.reactivex.flowables.ConnectableFlowable, ? extends io.reactivex.flowables.ConnectableFlowable> l;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super io.reactivex.Observable, ? extends io.reactivex.Observable> m;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super io.reactivex.observables.ConnectableObservable, ? extends io.reactivex.observables.ConnectableObservable> n;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super io.reactivex.Maybe, ? extends io.reactivex.Maybe> o;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super io.reactivex.Single, ? extends io.reactivex.Single> p;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super io.reactivex.Completable, ? extends io.reactivex.Completable> q;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.Function<? super io.reactivex.parallel.ParallelFlowable, ? extends io.reactivex.parallel.ParallelFlowable> r;

    /* renamed from: s, reason: collision with root package name */
    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.BiFunction<? super io.reactivex.Flowable, ? super org.reactivestreams.Subscriber, ? extends org.reactivestreams.Subscriber> f492s;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.BiFunction<? super io.reactivex.Maybe, ? super io.reactivex.MaybeObserver, ? extends io.reactivex.MaybeObserver> t;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.BiFunction<? super io.reactivex.Observable, ? super io.reactivex.Observer, ? extends io.reactivex.Observer> u;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.BiFunction<? super io.reactivex.Single, ? super io.reactivex.SingleObserver, ? extends io.reactivex.SingleObserver> v;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.BiFunction<? super io.reactivex.Completable, ? super io.reactivex.CompletableObserver, ? extends io.reactivex.CompletableObserver> w;

    @io.reactivex.annotations.Nullable
    public static volatile io.reactivex.functions.BooleanSupplier x;
    public static volatile boolean y;
    public static volatile boolean z;

    public RxJavaPlugins() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    @io.reactivex.annotations.NonNull
    public static <T, U, R> R a(@io.reactivex.annotations.NonNull io.reactivex.functions.BiFunction<T, U, R> biFunction, @io.reactivex.annotations.NonNull T t2, @io.reactivex.annotations.NonNull U u2) {
        try {
            return biFunction.apply(t2, u2);
        } catch (java.lang.Throwable th) {
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @io.reactivex.annotations.NonNull
    public static <T, R> R b(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<T, R> function, @io.reactivex.annotations.NonNull T t2) {
        try {
            return function.apply(t2);
        } catch (java.lang.Throwable th) {
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler c(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> function, java.util.concurrent.Callable<io.reactivex.Scheduler> callable) {
        return (io.reactivex.Scheduler) io.reactivex.internal.functions.ObjectHelper.requireNonNull(b(function, callable), "Scheduler Callable result can't be null");
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler createComputationScheduler(@io.reactivex.annotations.NonNull java.util.concurrent.ThreadFactory threadFactory) {
        return new io.reactivex.internal.schedulers.ComputationScheduler((java.util.concurrent.ThreadFactory) io.reactivex.internal.functions.ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler createIoScheduler(@io.reactivex.annotations.NonNull java.util.concurrent.ThreadFactory threadFactory) {
        return new io.reactivex.internal.schedulers.IoScheduler((java.util.concurrent.ThreadFactory) io.reactivex.internal.functions.ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler createNewThreadScheduler(@io.reactivex.annotations.NonNull java.util.concurrent.ThreadFactory threadFactory) {
        return new io.reactivex.internal.schedulers.NewThreadScheduler((java.util.concurrent.ThreadFactory) io.reactivex.internal.functions.ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler createSingleScheduler(@io.reactivex.annotations.NonNull java.util.concurrent.ThreadFactory threadFactory) {
        return new io.reactivex.internal.schedulers.SingleScheduler((java.util.concurrent.ThreadFactory) io.reactivex.internal.functions.ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler d(@io.reactivex.annotations.NonNull java.util.concurrent.Callable<io.reactivex.Scheduler> callable) {
        try {
            return (io.reactivex.Scheduler) io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable.call(), "Scheduler Callable result can't be null");
        } catch (java.lang.Throwable th) {
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static boolean e(java.lang.Throwable th) {
        return (th instanceof io.reactivex.exceptions.OnErrorNotImplementedException) || (th instanceof io.reactivex.exceptions.MissingBackpressureException) || (th instanceof java.lang.IllegalStateException) || (th instanceof java.lang.NullPointerException) || (th instanceof java.lang.IllegalArgumentException) || (th instanceof io.reactivex.exceptions.CompositeException);
    }

    public static void f(@io.reactivex.annotations.NonNull java.lang.Throwable th) {
        java.lang.Thread currentThread = java.lang.Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> getComputationSchedulerHandler() {
        return g;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Consumer<? super java.lang.Throwable> getErrorHandler() {
        return a;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> getInitComputationSchedulerHandler() {
        return c;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> getInitIoSchedulerHandler() {
        return e;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> getInitNewThreadSchedulerHandler() {
        return f;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> getInitSingleSchedulerHandler() {
        return d;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> getIoSchedulerHandler() {
        return i;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> getNewThreadSchedulerHandler() {
        return j;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.BooleanSupplier getOnBeforeBlocking() {
        return x;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super io.reactivex.Completable, ? extends io.reactivex.Completable> getOnCompletableAssembly() {
        return q;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.BiFunction<? super io.reactivex.Completable, ? super io.reactivex.CompletableObserver, ? extends io.reactivex.CompletableObserver> getOnCompletableSubscribe() {
        return w;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super io.reactivex.flowables.ConnectableFlowable, ? extends io.reactivex.flowables.ConnectableFlowable> getOnConnectableFlowableAssembly() {
        return l;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super io.reactivex.observables.ConnectableObservable, ? extends io.reactivex.observables.ConnectableObservable> getOnConnectableObservableAssembly() {
        return n;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super io.reactivex.Flowable, ? extends io.reactivex.Flowable> getOnFlowableAssembly() {
        return k;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.BiFunction<? super io.reactivex.Flowable, ? super org.reactivestreams.Subscriber, ? extends org.reactivestreams.Subscriber> getOnFlowableSubscribe() {
        return f492s;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super io.reactivex.Maybe, ? extends io.reactivex.Maybe> getOnMaybeAssembly() {
        return o;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.BiFunction<? super io.reactivex.Maybe, ? super io.reactivex.MaybeObserver, ? extends io.reactivex.MaybeObserver> getOnMaybeSubscribe() {
        return t;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super io.reactivex.Observable, ? extends io.reactivex.Observable> getOnObservableAssembly() {
        return m;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.BiFunction<? super io.reactivex.Observable, ? super io.reactivex.Observer, ? extends io.reactivex.Observer> getOnObservableSubscribe() {
        return u;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super io.reactivex.parallel.ParallelFlowable, ? extends io.reactivex.parallel.ParallelFlowable> getOnParallelAssembly() {
        return r;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super io.reactivex.Single, ? extends io.reactivex.Single> getOnSingleAssembly() {
        return p;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.BiFunction<? super io.reactivex.Single, ? super io.reactivex.SingleObserver, ? extends io.reactivex.SingleObserver> getOnSingleSubscribe() {
        return v;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super java.lang.Runnable, ? extends java.lang.Runnable> getScheduleHandler() {
        return b;
    }

    @io.reactivex.annotations.Nullable
    public static io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> getSingleSchedulerHandler() {
        return h;
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler initComputationScheduler(@io.reactivex.annotations.NonNull java.util.concurrent.Callable<io.reactivex.Scheduler> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> function = c;
        return function == null ? d(callable) : c(function, callable);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler initIoScheduler(@io.reactivex.annotations.NonNull java.util.concurrent.Callable<io.reactivex.Scheduler> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> function = e;
        return function == null ? d(callable) : c(function, callable);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler initNewThreadScheduler(@io.reactivex.annotations.NonNull java.util.concurrent.Callable<io.reactivex.Scheduler> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> function = f;
        return function == null ? d(callable) : c(function, callable);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler initSingleScheduler(@io.reactivex.annotations.NonNull java.util.concurrent.Callable<io.reactivex.Scheduler> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> function = d;
        return function == null ? d(callable) : c(function, callable);
    }

    public static boolean isFailOnNonBlockingScheduler() {
        return z;
    }

    public static boolean isLockdown() {
        return y;
    }

    public static void lockdown() {
        y = true;
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable onAssembly(@io.reactivex.annotations.NonNull io.reactivex.Completable completable) {
        io.reactivex.functions.Function<? super io.reactivex.Completable, ? extends io.reactivex.Completable> function = q;
        return function != null ? (io.reactivex.Completable) b(function, completable) : completable;
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> onAssembly(@io.reactivex.annotations.NonNull io.reactivex.Flowable<T> flowable) {
        io.reactivex.functions.Function<? super io.reactivex.Flowable, ? extends io.reactivex.Flowable> function = k;
        return function != null ? (io.reactivex.Flowable) b(function, flowable) : flowable;
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> onAssembly(@io.reactivex.annotations.NonNull io.reactivex.Maybe<T> maybe) {
        io.reactivex.functions.Function<? super io.reactivex.Maybe, ? extends io.reactivex.Maybe> function = o;
        return function != null ? (io.reactivex.Maybe) b(function, maybe) : maybe;
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> onAssembly(@io.reactivex.annotations.NonNull io.reactivex.Observable<T> observable) {
        io.reactivex.functions.Function<? super io.reactivex.Observable, ? extends io.reactivex.Observable> function = m;
        return function != null ? (io.reactivex.Observable) b(function, observable) : observable;
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> onAssembly(@io.reactivex.annotations.NonNull io.reactivex.Single<T> single) {
        io.reactivex.functions.Function<? super io.reactivex.Single, ? extends io.reactivex.Single> function = p;
        return function != null ? (io.reactivex.Single) b(function, single) : single;
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.flowables.ConnectableFlowable<T> onAssembly(@io.reactivex.annotations.NonNull io.reactivex.flowables.ConnectableFlowable<T> connectableFlowable) {
        io.reactivex.functions.Function<? super io.reactivex.flowables.ConnectableFlowable, ? extends io.reactivex.flowables.ConnectableFlowable> function = l;
        return function != null ? (io.reactivex.flowables.ConnectableFlowable) b(function, connectableFlowable) : connectableFlowable;
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.observables.ConnectableObservable<T> onAssembly(@io.reactivex.annotations.NonNull io.reactivex.observables.ConnectableObservable<T> connectableObservable) {
        io.reactivex.functions.Function<? super io.reactivex.observables.ConnectableObservable, ? extends io.reactivex.observables.ConnectableObservable> function = n;
        return function != null ? (io.reactivex.observables.ConnectableObservable) b(function, connectableObservable) : connectableObservable;
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.parallel.ParallelFlowable<T> onAssembly(@io.reactivex.annotations.NonNull io.reactivex.parallel.ParallelFlowable<T> parallelFlowable) {
        io.reactivex.functions.Function<? super io.reactivex.parallel.ParallelFlowable, ? extends io.reactivex.parallel.ParallelFlowable> function = r;
        return function != null ? (io.reactivex.parallel.ParallelFlowable) b(function, parallelFlowable) : parallelFlowable;
    }

    public static boolean onBeforeBlocking() {
        io.reactivex.functions.BooleanSupplier booleanSupplier = x;
        if (booleanSupplier == null) {
            return false;
        }
        try {
            return booleanSupplier.getAsBoolean();
        } catch (java.lang.Throwable th) {
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler onComputationScheduler(@io.reactivex.annotations.NonNull io.reactivex.Scheduler scheduler) {
        io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> function = g;
        return function == null ? scheduler : (io.reactivex.Scheduler) b(function, scheduler);
    }

    public static void onError(@io.reactivex.annotations.NonNull java.lang.Throwable th) {
        io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer = a;
        if (th == null) {
            th = new java.lang.NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!e(th)) {
            th = new io.reactivex.exceptions.UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
                f(th2);
            }
        }
        th.printStackTrace();
        f(th);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler onIoScheduler(@io.reactivex.annotations.NonNull io.reactivex.Scheduler scheduler) {
        io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> function = i;
        return function == null ? scheduler : (io.reactivex.Scheduler) b(function, scheduler);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler onNewThreadScheduler(@io.reactivex.annotations.NonNull io.reactivex.Scheduler scheduler) {
        io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> function = j;
        return function == null ? scheduler : (io.reactivex.Scheduler) b(function, scheduler);
    }

    @io.reactivex.annotations.NonNull
    public static java.lang.Runnable onSchedule(@io.reactivex.annotations.NonNull java.lang.Runnable runnable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(runnable, "run is null");
        io.reactivex.functions.Function<? super java.lang.Runnable, ? extends java.lang.Runnable> function = b;
        return function == null ? runnable : (java.lang.Runnable) b(function, runnable);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.Scheduler onSingleScheduler(@io.reactivex.annotations.NonNull io.reactivex.Scheduler scheduler) {
        io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> function = h;
        return function == null ? scheduler : (io.reactivex.Scheduler) b(function, scheduler);
    }

    @io.reactivex.annotations.NonNull
    public static io.reactivex.CompletableObserver onSubscribe(@io.reactivex.annotations.NonNull io.reactivex.Completable completable, @io.reactivex.annotations.NonNull io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.functions.BiFunction<? super io.reactivex.Completable, ? super io.reactivex.CompletableObserver, ? extends io.reactivex.CompletableObserver> biFunction = w;
        return biFunction != null ? (io.reactivex.CompletableObserver) a(biFunction, completable, completableObserver) : completableObserver;
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.MaybeObserver<? super T> onSubscribe(@io.reactivex.annotations.NonNull io.reactivex.Maybe<T> maybe, @io.reactivex.annotations.NonNull io.reactivex.MaybeObserver<? super T> maybeObserver) {
        io.reactivex.functions.BiFunction<? super io.reactivex.Maybe, ? super io.reactivex.MaybeObserver, ? extends io.reactivex.MaybeObserver> biFunction = t;
        return biFunction != null ? (io.reactivex.MaybeObserver) a(biFunction, maybe, maybeObserver) : maybeObserver;
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observer<? super T> onSubscribe(@io.reactivex.annotations.NonNull io.reactivex.Observable<T> observable, @io.reactivex.annotations.NonNull io.reactivex.Observer<? super T> observer) {
        io.reactivex.functions.BiFunction<? super io.reactivex.Observable, ? super io.reactivex.Observer, ? extends io.reactivex.Observer> biFunction = u;
        return biFunction != null ? (io.reactivex.Observer) a(biFunction, observable, observer) : observer;
    }

    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.SingleObserver<? super T> onSubscribe(@io.reactivex.annotations.NonNull io.reactivex.Single<T> single, @io.reactivex.annotations.NonNull io.reactivex.SingleObserver<? super T> singleObserver) {
        io.reactivex.functions.BiFunction<? super io.reactivex.Single, ? super io.reactivex.SingleObserver, ? extends io.reactivex.SingleObserver> biFunction = v;
        return biFunction != null ? (io.reactivex.SingleObserver) a(biFunction, single, singleObserver) : singleObserver;
    }

    @io.reactivex.annotations.NonNull
    public static <T> org.reactivestreams.Subscriber<? super T> onSubscribe(@io.reactivex.annotations.NonNull io.reactivex.Flowable<T> flowable, @io.reactivex.annotations.NonNull org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.functions.BiFunction<? super io.reactivex.Flowable, ? super org.reactivestreams.Subscriber, ? extends org.reactivestreams.Subscriber> biFunction = f492s;
        return biFunction != null ? (org.reactivestreams.Subscriber) a(biFunction, flowable, subscriber) : subscriber;
    }

    public static void reset() {
        setErrorHandler(null);
        setScheduleHandler(null);
        setComputationSchedulerHandler(null);
        setInitComputationSchedulerHandler(null);
        setIoSchedulerHandler(null);
        setInitIoSchedulerHandler(null);
        setSingleSchedulerHandler(null);
        setInitSingleSchedulerHandler(null);
        setNewThreadSchedulerHandler(null);
        setInitNewThreadSchedulerHandler(null);
        setOnFlowableAssembly(null);
        setOnFlowableSubscribe(null);
        setOnObservableAssembly(null);
        setOnObservableSubscribe(null);
        setOnSingleAssembly(null);
        setOnSingleSubscribe(null);
        setOnCompletableAssembly(null);
        setOnCompletableSubscribe(null);
        setOnConnectableFlowableAssembly(null);
        setOnConnectableObservableAssembly(null);
        setOnMaybeAssembly(null);
        setOnMaybeSubscribe(null);
        setOnParallelAssembly(null);
        setFailOnNonBlockingScheduler(false);
        setOnBeforeBlocking(null);
    }

    public static void setComputationSchedulerHandler(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        g = function;
    }

    public static void setErrorHandler(@io.reactivex.annotations.Nullable io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        a = consumer;
    }

    public static void setFailOnNonBlockingScheduler(boolean z2) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        z = z2;
    }

    public static void setInitComputationSchedulerHandler(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        c = function;
    }

    public static void setInitIoSchedulerHandler(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        e = function;
    }

    public static void setInitNewThreadSchedulerHandler(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        f = function;
    }

    public static void setInitSingleSchedulerHandler(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        d = function;
    }

    public static void setIoSchedulerHandler(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        i = function;
    }

    public static void setNewThreadSchedulerHandler(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        j = function;
    }

    public static void setOnBeforeBlocking(@io.reactivex.annotations.Nullable io.reactivex.functions.BooleanSupplier booleanSupplier) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        x = booleanSupplier;
    }

    public static void setOnCompletableAssembly(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super io.reactivex.Completable, ? extends io.reactivex.Completable> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        q = function;
    }

    public static void setOnCompletableSubscribe(@io.reactivex.annotations.Nullable io.reactivex.functions.BiFunction<? super io.reactivex.Completable, ? super io.reactivex.CompletableObserver, ? extends io.reactivex.CompletableObserver> biFunction) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        w = biFunction;
    }

    public static void setOnConnectableFlowableAssembly(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super io.reactivex.flowables.ConnectableFlowable, ? extends io.reactivex.flowables.ConnectableFlowable> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        l = function;
    }

    public static void setOnConnectableObservableAssembly(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super io.reactivex.observables.ConnectableObservable, ? extends io.reactivex.observables.ConnectableObservable> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        n = function;
    }

    public static void setOnFlowableAssembly(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super io.reactivex.Flowable, ? extends io.reactivex.Flowable> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        k = function;
    }

    public static void setOnFlowableSubscribe(@io.reactivex.annotations.Nullable io.reactivex.functions.BiFunction<? super io.reactivex.Flowable, ? super org.reactivestreams.Subscriber, ? extends org.reactivestreams.Subscriber> biFunction) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        f492s = biFunction;
    }

    public static void setOnMaybeAssembly(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super io.reactivex.Maybe, ? extends io.reactivex.Maybe> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        o = function;
    }

    public static void setOnMaybeSubscribe(@io.reactivex.annotations.Nullable io.reactivex.functions.BiFunction<? super io.reactivex.Maybe, io.reactivex.MaybeObserver, ? extends io.reactivex.MaybeObserver> biFunction) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        t = biFunction;
    }

    public static void setOnObservableAssembly(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super io.reactivex.Observable, ? extends io.reactivex.Observable> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        m = function;
    }

    public static void setOnObservableSubscribe(@io.reactivex.annotations.Nullable io.reactivex.functions.BiFunction<? super io.reactivex.Observable, ? super io.reactivex.Observer, ? extends io.reactivex.Observer> biFunction) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        u = biFunction;
    }

    public static void setOnParallelAssembly(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super io.reactivex.parallel.ParallelFlowable, ? extends io.reactivex.parallel.ParallelFlowable> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        r = function;
    }

    public static void setOnSingleAssembly(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super io.reactivex.Single, ? extends io.reactivex.Single> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        p = function;
    }

    public static void setOnSingleSubscribe(@io.reactivex.annotations.Nullable io.reactivex.functions.BiFunction<? super io.reactivex.Single, ? super io.reactivex.SingleObserver, ? extends io.reactivex.SingleObserver> biFunction) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        v = biFunction;
    }

    public static void setScheduleHandler(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super java.lang.Runnable, ? extends java.lang.Runnable> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        b = function;
    }

    public static void setSingleSchedulerHandler(@io.reactivex.annotations.Nullable io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> function) {
        if (y) {
            throw new java.lang.IllegalStateException("Plugins can't be changed anymore");
        }
        h = function;
    }
}
