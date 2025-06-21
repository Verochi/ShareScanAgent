package io.reactivex;

/* loaded from: classes9.dex */
public abstract class Maybe<T> implements io.reactivex.MaybeSource<T> {
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> amb(java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeAmb(null, iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Maybe<T> ambArray(io.reactivex.MaybeSource<? extends T>... maybeSourceArr) {
        return maybeSourceArr.length == 0 ? empty() : maybeSourceArr.length == 1 ? wrap(maybeSourceArr[0]) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeAmb(maybeSourceArr, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(io.reactivex.MaybeSource<? extends T> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        return concatArray(maybeSource, maybeSource2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(io.reactivex.MaybeSource<? extends T> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2, io.reactivex.MaybeSource<? extends T> maybeSource3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        return concatArray(maybeSource, maybeSource2, maybeSource3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(io.reactivex.MaybeSource<? extends T> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2, io.reactivex.MaybeSource<? extends T> maybeSource3, io.reactivex.MaybeSource<? extends T> maybeSource4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        return concatArray(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeConcatIterable(iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concat(org.reactivestreams.Publisher<? extends io.reactivex.MaybeSource<? extends T>> publisher) {
        return concat(publisher, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(org.reactivestreams.Publisher<? extends io.reactivex.MaybeSource<? extends T>> publisher, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher(publisher, io.reactivex.internal.operators.maybe.MaybeToPublisher.instance(), i, io.reactivex.internal.util.ErrorMode.IMMEDIATE));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concatArray(io.reactivex.MaybeSource<? extends T>... maybeSourceArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSourceArr, "sources is null");
        return maybeSourceArr.length == 0 ? io.reactivex.Flowable.empty() : maybeSourceArr.length == 1 ? io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeToFlowable(maybeSourceArr[0])) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeConcatArray(maybeSourceArr));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatArrayDelayError(io.reactivex.MaybeSource<? extends T>... maybeSourceArr) {
        return maybeSourceArr.length == 0 ? io.reactivex.Flowable.empty() : maybeSourceArr.length == 1 ? io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeToFlowable(maybeSourceArr[0])) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeConcatArrayDelayError(maybeSourceArr));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatArrayEager(io.reactivex.MaybeSource<? extends T>... maybeSourceArr) {
        return io.reactivex.Flowable.fromArray(maybeSourceArr).concatMapEager(io.reactivex.internal.operators.maybe.MaybeToPublisher.instance());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concatDelayError(java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.Flowable.fromIterable(iterable).concatMapDelayError(io.reactivex.internal.operators.maybe.MaybeToPublisher.instance());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatDelayError(org.reactivestreams.Publisher<? extends io.reactivex.MaybeSource<? extends T>> publisher) {
        return io.reactivex.Flowable.fromPublisher(publisher).concatMapDelayError(io.reactivex.internal.operators.maybe.MaybeToPublisher.instance());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatEager(java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> iterable) {
        return io.reactivex.Flowable.fromIterable(iterable).concatMapEager(io.reactivex.internal.operators.maybe.MaybeToPublisher.instance());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatEager(org.reactivestreams.Publisher<? extends io.reactivex.MaybeSource<? extends T>> publisher) {
        return io.reactivex.Flowable.fromPublisher(publisher).concatMapEager(io.reactivex.internal.operators.maybe.MaybeToPublisher.instance());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> create(io.reactivex.MaybeOnSubscribe<T> maybeOnSubscribe) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeOnSubscribe, "onSubscribe is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeCreate(maybeOnSubscribe));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> defer(java.util.concurrent.Callable<? extends io.reactivex.MaybeSource<? extends T>> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "maybeSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeDefer(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Maybe<T> empty() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(io.reactivex.internal.operators.maybe.MaybeEmpty.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> error(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "exception is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeError(th));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> error(java.util.concurrent.Callable<? extends java.lang.Throwable> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeErrorCallable(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> fromAction(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "run is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFromAction(action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> fromCallable(@io.reactivex.annotations.NonNull java.util.concurrent.Callable<? extends T> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "callable is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFromCallable(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> fromCompletable(io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "completableSource is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFromCompletable(completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> fromFuture(java.util.concurrent.Future<? extends T> future) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(future, "future is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFromFuture(future, 0L, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> fromFuture(java.util.concurrent.Future<? extends T> future, long j, java.util.concurrent.TimeUnit timeUnit) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(future, "future is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFromFuture(future, j, timeUnit));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> fromRunnable(java.lang.Runnable runnable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(runnable, "run is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFromRunnable(runnable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> fromSingle(io.reactivex.SingleSource<T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "singleSource is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFromSingle(singleSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> just(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeJust(t));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> merge(io.reactivex.MaybeSource<? extends T> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        return mergeArray(maybeSource, maybeSource2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> merge(io.reactivex.MaybeSource<? extends T> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2, io.reactivex.MaybeSource<? extends T> maybeSource3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        return mergeArray(maybeSource, maybeSource2, maybeSource3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> merge(io.reactivex.MaybeSource<? extends T> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2, io.reactivex.MaybeSource<? extends T> maybeSource3, io.reactivex.MaybeSource<? extends T> maybeSource4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        return mergeArray(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> merge(java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> iterable) {
        return merge(io.reactivex.Flowable.fromIterable(iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> merge(org.reactivestreams.Publisher<? extends io.reactivex.MaybeSource<? extends T>> publisher) {
        return merge(publisher, Integer.MAX_VALUE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> merge(org.reactivestreams.Publisher<? extends io.reactivex.MaybeSource<? extends T>> publisher, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher(publisher, io.reactivex.internal.operators.maybe.MaybeToPublisher.instance(), false, i, 1));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> merge(io.reactivex.MaybeSource<? extends io.reactivex.MaybeSource<? extends T>> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFlatten(maybeSource, io.reactivex.internal.functions.Functions.identity()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeArray(io.reactivex.MaybeSource<? extends T>... maybeSourceArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSourceArr, "sources is null");
        return maybeSourceArr.length == 0 ? io.reactivex.Flowable.empty() : maybeSourceArr.length == 1 ? io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeToFlowable(maybeSourceArr[0])) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeMergeArray(maybeSourceArr));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> mergeArrayDelayError(io.reactivex.MaybeSource<? extends T>... maybeSourceArr) {
        return maybeSourceArr.length == 0 ? io.reactivex.Flowable.empty() : io.reactivex.Flowable.fromArray(maybeSourceArr).flatMap(io.reactivex.internal.operators.maybe.MaybeToPublisher.instance(), true, maybeSourceArr.length);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeDelayError(io.reactivex.MaybeSource<? extends T> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        return mergeArrayDelayError(maybeSource, maybeSource2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeDelayError(io.reactivex.MaybeSource<? extends T> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2, io.reactivex.MaybeSource<? extends T> maybeSource3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        return mergeArrayDelayError(maybeSource, maybeSource2, maybeSource3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeDelayError(io.reactivex.MaybeSource<? extends T> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2, io.reactivex.MaybeSource<? extends T> maybeSource3, io.reactivex.MaybeSource<? extends T> maybeSource4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        return mergeArrayDelayError(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> mergeDelayError(java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> iterable) {
        return io.reactivex.Flowable.fromIterable(iterable).flatMap(io.reactivex.internal.operators.maybe.MaybeToPublisher.instance(), true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> mergeDelayError(org.reactivestreams.Publisher<? extends io.reactivex.MaybeSource<? extends T>> publisher) {
        return mergeDelayError(publisher, Integer.MAX_VALUE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeDelayError(org.reactivestreams.Publisher<? extends io.reactivex.MaybeSource<? extends T>> publisher, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher(publisher, io.reactivex.internal.operators.maybe.MaybeToPublisher.instance(), true, i, 1));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Maybe<T> never() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(io.reactivex.internal.operators.maybe.MaybeNever.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<java.lang.Boolean> sequenceEqual(io.reactivex.MaybeSource<? extends T> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2) {
        return sequenceEqual(maybeSource, maybeSource2, io.reactivex.internal.functions.ObjectHelper.equalsPredicate());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<java.lang.Boolean> sequenceEqual(io.reactivex.MaybeSource<? extends T> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2, io.reactivex.functions.BiPredicate<? super T, ? super T> biPredicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biPredicate, "isEqual is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeEqualSingle(maybeSource, maybeSource2, biPredicate));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Maybe<java.lang.Long> timer(long j, java.util.concurrent.TimeUnit timeUnit) {
        return timer(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Maybe<java.lang.Long> timer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeTimer(java.lang.Math.max(0L, j), timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> unsafeCreate(io.reactivex.MaybeSource<T> maybeSource) {
        if (maybeSource instanceof io.reactivex.Maybe) {
            throw new java.lang.IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
        }
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "onSubscribe is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeUnsafeCreate(maybeSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, D> io.reactivex.Maybe<T> using(java.util.concurrent.Callable<? extends D> callable, io.reactivex.functions.Function<? super D, ? extends io.reactivex.MaybeSource<? extends T>> function, io.reactivex.functions.Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, D> io.reactivex.Maybe<T> using(java.util.concurrent.Callable<? extends D> callable, io.reactivex.functions.Function<? super D, ? extends io.reactivex.MaybeSource<? extends T>> function, io.reactivex.functions.Consumer<? super D> consumer, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "sourceSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "disposer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeUsing(callable, function, consumer, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Maybe<T> wrap(io.reactivex.MaybeSource<T> maybeSource) {
        if (maybeSource instanceof io.reactivex.Maybe) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.Maybe) maybeSource);
        }
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "onSubscribe is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeUnsafeCreate(maybeSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> io.reactivex.Maybe<R> zip(io.reactivex.MaybeSource<? extends T1> maybeSource, io.reactivex.MaybeSource<? extends T2> maybeSource2, io.reactivex.MaybeSource<? extends T3> maybeSource3, io.reactivex.MaybeSource<? extends T4> maybeSource4, io.reactivex.MaybeSource<? extends T5> maybeSource5, io.reactivex.MaybeSource<? extends T6> maybeSource6, io.reactivex.MaybeSource<? extends T7> maybeSource7, io.reactivex.MaybeSource<? extends T8> maybeSource8, io.reactivex.MaybeSource<? extends T9> maybeSource9, io.reactivex.functions.Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource7, "source7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource8, "source8 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource9, "source9 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function9), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8, maybeSource9);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> io.reactivex.Maybe<R> zip(io.reactivex.MaybeSource<? extends T1> maybeSource, io.reactivex.MaybeSource<? extends T2> maybeSource2, io.reactivex.MaybeSource<? extends T3> maybeSource3, io.reactivex.MaybeSource<? extends T4> maybeSource4, io.reactivex.MaybeSource<? extends T5> maybeSource5, io.reactivex.MaybeSource<? extends T6> maybeSource6, io.reactivex.MaybeSource<? extends T7> maybeSource7, io.reactivex.MaybeSource<? extends T8> maybeSource8, io.reactivex.functions.Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource7, "source7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource8, "source8 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function8), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, R> io.reactivex.Maybe<R> zip(io.reactivex.MaybeSource<? extends T1> maybeSource, io.reactivex.MaybeSource<? extends T2> maybeSource2, io.reactivex.MaybeSource<? extends T3> maybeSource3, io.reactivex.MaybeSource<? extends T4> maybeSource4, io.reactivex.MaybeSource<? extends T5> maybeSource5, io.reactivex.MaybeSource<? extends T6> maybeSource6, io.reactivex.MaybeSource<? extends T7> maybeSource7, io.reactivex.functions.Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource7, "source7 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function7), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, R> io.reactivex.Maybe<R> zip(io.reactivex.MaybeSource<? extends T1> maybeSource, io.reactivex.MaybeSource<? extends T2> maybeSource2, io.reactivex.MaybeSource<? extends T3> maybeSource3, io.reactivex.MaybeSource<? extends T4> maybeSource4, io.reactivex.MaybeSource<? extends T5> maybeSource5, io.reactivex.MaybeSource<? extends T6> maybeSource6, io.reactivex.functions.Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource6, "source6 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function6), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, R> io.reactivex.Maybe<R> zip(io.reactivex.MaybeSource<? extends T1> maybeSource, io.reactivex.MaybeSource<? extends T2> maybeSource2, io.reactivex.MaybeSource<? extends T3> maybeSource3, io.reactivex.MaybeSource<? extends T4> maybeSource4, io.reactivex.MaybeSource<? extends T5> maybeSource5, io.reactivex.functions.Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function5), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, R> io.reactivex.Maybe<R> zip(io.reactivex.MaybeSource<? extends T1> maybeSource, io.reactivex.MaybeSource<? extends T2> maybeSource2, io.reactivex.MaybeSource<? extends T3> maybeSource3, io.reactivex.MaybeSource<? extends T4> maybeSource4, io.reactivex.functions.Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function4), maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, R> io.reactivex.Maybe<R> zip(io.reactivex.MaybeSource<? extends T1> maybeSource, io.reactivex.MaybeSource<? extends T2> maybeSource2, io.reactivex.MaybeSource<? extends T3> maybeSource3, io.reactivex.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function3), maybeSource, maybeSource2, maybeSource3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, R> io.reactivex.Maybe<R> zip(io.reactivex.MaybeSource<? extends T1> maybeSource, io.reactivex.MaybeSource<? extends T2> maybeSource2, io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(biFunction), maybeSource, maybeSource2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Maybe<R> zip(java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "zipper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeZipIterable(iterable, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Maybe<R> zipArray(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, io.reactivex.MaybeSource<? extends T>... maybeSourceArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return empty();
        }
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "zipper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeZipArray(maybeSourceArr, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> ambWith(io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "other is null");
        return ambArray(this, maybeSource);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> R as(@io.reactivex.annotations.NonNull io.reactivex.MaybeConverter<T, ? extends R> maybeConverter) {
        return (R) ((io.reactivex.MaybeConverter) io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeConverter, "converter is null")).apply(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingGet() {
        io.reactivex.internal.observers.BlockingMultiObserver blockingMultiObserver = new io.reactivex.internal.observers.BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return (T) blockingMultiObserver.blockingGet();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingGet(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultValue is null");
        io.reactivex.internal.observers.BlockingMultiObserver blockingMultiObserver = new io.reactivex.internal.observers.BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return (T) blockingMultiObserver.blockingGet(t);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> cache() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeCache(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Maybe<U> cast(java.lang.Class<? extends U> cls) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(cls, "clazz is null");
        return (io.reactivex.Maybe<U>) map(io.reactivex.internal.functions.Functions.castFunction(cls));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Maybe<R> compose(io.reactivex.MaybeTransformer<? super T, ? extends R> maybeTransformer) {
        return wrap(((io.reactivex.MaybeTransformer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeTransformer, "transformer is null")).apply(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Maybe<R> concatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFlatten(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> concatWith(io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "other is null");
        return concat(this, maybeSource);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<java.lang.Boolean> contains(java.lang.Object obj) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(obj, "item is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeContains(this, obj));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.lang.Long> count() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeCount(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> defaultIfEmpty(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> delay(long j, java.util.concurrent.TimeUnit timeUnit) {
        return delay(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> delay(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeDelay(this, java.lang.Math.max(0L, j), timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U, V> io.reactivex.Maybe<T> delay(org.reactivestreams.Publisher<U> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "delayIndicator is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher(this, publisher));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> delaySubscription(long j, java.util.concurrent.TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> delaySubscription(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return delaySubscription(io.reactivex.Flowable.timer(j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Maybe<T> delaySubscription(org.reactivestreams.Publisher<U> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "subscriptionIndicator is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher(this, publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> doAfterSuccess(io.reactivex.functions.Consumer<? super T> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onAfterSuccess is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeDoAfterSuccess(this, consumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> doAfterTerminate(io.reactivex.functions.Action action) {
        io.reactivex.functions.Consumer emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer emptyConsumer2 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer emptyConsumer3 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action2 = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybePeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, (io.reactivex.functions.Action) io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onAfterTerminate is null"), action2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> doFinally(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onFinally is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeDoFinally(this, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> doOnComplete(io.reactivex.functions.Action action) {
        io.reactivex.functions.Consumer emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer emptyConsumer2 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer emptyConsumer3 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action2 = (io.reactivex.functions.Action) io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        io.reactivex.functions.Action action3 = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybePeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action3, action3));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> doOnDispose(io.reactivex.functions.Action action) {
        io.reactivex.functions.Consumer emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer emptyConsumer2 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer emptyConsumer3 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action2 = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybePeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action2, (io.reactivex.functions.Action) io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onDispose is null")));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> doOnError(io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer) {
        io.reactivex.functions.Consumer emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer emptyConsumer2 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer consumer2 = (io.reactivex.functions.Consumer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onError is null");
        io.reactivex.functions.Action action = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybePeek(this, emptyConsumer, emptyConsumer2, consumer2, action, action, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> doOnEvent(io.reactivex.functions.BiConsumer<? super T, ? super java.lang.Throwable> biConsumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biConsumer, "onEvent is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeDoOnEvent(this, biConsumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> doOnSubscribe(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        io.reactivex.functions.Consumer consumer2 = (io.reactivex.functions.Consumer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        io.reactivex.functions.Consumer emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer emptyConsumer2 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybePeek(this, consumer2, emptyConsumer, emptyConsumer2, action, action, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> doOnSuccess(io.reactivex.functions.Consumer<? super T> consumer) {
        io.reactivex.functions.Consumer emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer consumer2 = (io.reactivex.functions.Consumer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        io.reactivex.functions.Consumer emptyConsumer2 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybePeek(this, emptyConsumer, consumer2, emptyConsumer2, action, action, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.Experimental
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> doOnTerminate(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onTerminate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeDoOnTerminate(this, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> filter(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFilter(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Maybe<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFlatten(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U, R> io.reactivex.Maybe<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector(this, function, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Maybe<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.MaybeSource<? extends R>> function2, java.util.concurrent.Callable<? extends io.reactivex.MaybeSource<? extends R>> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "onSuccessMapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFlatMapNotification(this, function, function2, callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable flatMapCompletable(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Observable<R> flatMapObservable(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.MaybeFlatMapObservable(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> flatMapPublisher(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.MaybeFlatMapPublisher(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Single<R> flatMapSingle(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFlatMapSingle(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Maybe<R> flatMapSingleElement(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<U> flattenAsFlowable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFlatMapIterableFlowable(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Observable<U> flattenAsObservable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFlatMapIterableObservable(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> hide() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeHide(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable ignoreElement() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.lang.Boolean> isEmpty() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeIsEmptySingle(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Maybe<R> lift(io.reactivex.MaybeOperator<? extends R, ? super T> maybeOperator) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeOperator, "lift is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeLift(this, maybeOperator));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Maybe<R> map(io.reactivex.functions.Function<? super T, ? extends R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeMap(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.Experimental
    public final io.reactivex.Single<io.reactivex.Notification<T>> materialize() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeMaterialize(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> mergeWith(io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "other is null");
        return merge(this, maybeSource);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> observeOn(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeObserveOn(this, scheduler));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Maybe<U> ofType(java.lang.Class<U> cls) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(cls, "clazz is null");
        return filter(io.reactivex.internal.functions.Functions.isInstanceOf(cls)).cast(cls);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> onErrorComplete() {
        return onErrorComplete(io.reactivex.internal.functions.Functions.alwaysTrue());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> onErrorComplete(io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeOnErrorComplete(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> onErrorResumeNext(io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "next is null");
        return onErrorResumeNext(io.reactivex.internal.functions.Functions.justFunction(maybeSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> onErrorResumeNext(io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.MaybeSource<? extends T>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeOnErrorNext(this, function, true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> onErrorReturn(io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "valueSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeOnErrorReturn(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> onErrorReturnItem(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item is null");
        return onErrorReturn(io.reactivex.internal.functions.Functions.justFunction(t));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> onExceptionResumeNext(io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "next is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeOnErrorNext(this, io.reactivex.internal.functions.Functions.justFunction(maybeSource), false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> onTerminateDetach() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeDetach(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> repeat(long j) {
        return toFlowable().repeat(j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> repeatUntil(io.reactivex.functions.BooleanSupplier booleanSupplier) {
        return toFlowable().repeatUntil(booleanSupplier);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> repeatWhen(io.reactivex.functions.Function<? super io.reactivex.Flowable<java.lang.Object>, ? extends org.reactivestreams.Publisher<?>> function) {
        return toFlowable().repeatWhen(function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> retry() {
        return retry(Long.MAX_VALUE, io.reactivex.internal.functions.Functions.alwaysTrue());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> retry(long j) {
        return retry(j, io.reactivex.internal.functions.Functions.alwaysTrue());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> retry(long j, io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        return toFlowable().retry(j, predicate).singleElement();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> retry(io.reactivex.functions.BiPredicate<? super java.lang.Integer, ? super java.lang.Throwable> biPredicate) {
        return toFlowable().retry(biPredicate).singleElement();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> retry(io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> retryUntil(io.reactivex.functions.BooleanSupplier booleanSupplier) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return retry(Long.MAX_VALUE, io.reactivex.internal.functions.Functions.predicateReverseFor(booleanSupplier));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> retryWhen(io.reactivex.functions.Function<? super io.reactivex.Flowable<java.lang.Throwable>, ? extends org.reactivestreams.Publisher<?>> function) {
        return toFlowable().retryWhen(function).singleElement();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    public final io.reactivex.disposables.Disposable subscribe() {
        return subscribe(io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.ON_ERROR_MISSING, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer) {
        return subscribe(consumer, io.reactivex.internal.functions.Functions.ON_ERROR_MISSING, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2) {
        return subscribe(consumer, consumer2, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer2, "onError is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        return (io.reactivex.disposables.Disposable) subscribeWith(new io.reactivex.internal.operators.maybe.MaybeCallbackObserver(consumer, consumer2, action));
    }

    @Override // io.reactivex.MaybeSource
    @io.reactivex.annotations.SchedulerSupport("none")
    public final void subscribe(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeObserver, "observer is null");
        io.reactivex.MaybeObserver<? super T> onSubscribe = io.reactivex.plugins.RxJavaPlugins.onSubscribe(this, maybeObserver);
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            subscribeActual(onSubscribe);
        } catch (java.lang.NullPointerException e) {
            throw e;
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver);

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> subscribeOn(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeSubscribeOn(this, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <E extends io.reactivex.MaybeObserver<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> switchIfEmpty(io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty(this, maybeSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> switchIfEmpty(io.reactivex.SingleSource<? extends T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle(this, singleSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Maybe<T> takeUntil(io.reactivex.MaybeSource<U> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe(this, maybeSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Maybe<T> takeUntil(org.reactivestreams.Publisher<U> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher(this, publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observers.TestObserver<T> test() {
        io.reactivex.observers.TestObserver<T> testObserver = new io.reactivex.observers.TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observers.TestObserver<T> test(boolean z) {
        io.reactivex.observers.TestObserver<T> testObserver = new io.reactivex.observers.TestObserver<>();
        if (z) {
            testObserver.cancel();
        }
        subscribe(testObserver);
        return testObserver;
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit) {
        return timeout(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "fallback is null");
        return timeout(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), maybeSource);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return timeout(timer(j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "fallback is null");
        return timeout(timer(j, timeUnit, scheduler), maybeSource);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Maybe<T> timeout(io.reactivex.MaybeSource<U> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "timeoutIndicator is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe(this, maybeSource, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Maybe<T> timeout(io.reactivex.MaybeSource<U> maybeSource, io.reactivex.MaybeSource<? extends T> maybeSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "timeoutIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource2, "fallback is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe(this, maybeSource, maybeSource2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Maybe<T> timeout(org.reactivestreams.Publisher<U> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "timeoutIndicator is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher(this, publisher, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Maybe<T> timeout(org.reactivestreams.Publisher<U> publisher, io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "timeoutIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "fallback is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher(this, publisher, maybeSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> R to(io.reactivex.functions.Function<? super io.reactivex.Maybe<T>, R> function) {
        try {
            return (R) ((io.reactivex.functions.Function) io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "convert is null")).apply(this);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> toFlowable() {
        return this instanceof io.reactivex.internal.fuseable.FuseToFlowable ? ((io.reactivex.internal.fuseable.FuseToFlowable) this).fuseToFlowable() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeToFlowable(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> toObservable() {
        return this instanceof io.reactivex.internal.fuseable.FuseToObservable ? ((io.reactivex.internal.fuseable.FuseToObservable) this).fuseToObservable() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeToObservable(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> toSingle() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeToSingle(this, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> toSingle(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultValue is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeToSingle(this, t));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> unsubscribeOn(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeUnsubscribeOn(this, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U, R> io.reactivex.Maybe<R> zipWith(io.reactivex.MaybeSource<? extends U> maybeSource, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "other is null");
        return zip(this, maybeSource, biFunction);
    }
}
