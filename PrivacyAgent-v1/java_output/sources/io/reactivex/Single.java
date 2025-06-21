package io.reactivex;

/* loaded from: classes9.dex */
public abstract class Single<T> implements io.reactivex.SingleSource<T> {
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> amb(java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleAmb(null, iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<T> ambArray(io.reactivex.SingleSource<? extends T>... singleSourceArr) {
        return singleSourceArr.length == 0 ? error(io.reactivex.internal.operators.single.SingleInternalHelper.emptyThrower()) : singleSourceArr.length == 1 ? wrap(singleSourceArr[0]) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleAmb(singleSourceArr, null));
    }

    public static <T> io.reactivex.Single<T> b(io.reactivex.Flowable<T> flowable) {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSingleSingle(flowable, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.SingleSource<? extends T> singleSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        return concat(io.reactivex.Flowable.fromArray(singleSource, singleSource2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.SingleSource<? extends T> singleSource2, io.reactivex.SingleSource<? extends T> singleSource3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        return concat(io.reactivex.Flowable.fromArray(singleSource, singleSource2, singleSource3));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.SingleSource<? extends T> singleSource2, io.reactivex.SingleSource<? extends T> singleSource3, io.reactivex.SingleSource<? extends T> singleSource4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        return concat(io.reactivex.Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> iterable) {
        return concat(io.reactivex.Flowable.fromIterable(iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(org.reactivestreams.Publisher<? extends io.reactivex.SingleSource<? extends T>> publisher) {
        return concat(publisher, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(org.reactivestreams.Publisher<? extends io.reactivex.SingleSource<? extends T>> publisher, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher(publisher, io.reactivex.internal.operators.single.SingleInternalHelper.toFlowable(), i, io.reactivex.internal.util.ErrorMode.IMMEDIATE));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> concat(io.reactivex.ObservableSource<? extends io.reactivex.SingleSource<? extends T>> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableConcatMap(observableSource, io.reactivex.internal.operators.single.SingleInternalHelper.toObservable(), 2, io.reactivex.internal.util.ErrorMode.IMMEDIATE));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concatArray(io.reactivex.SingleSource<? extends T>... singleSourceArr) {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatMap(io.reactivex.Flowable.fromArray(singleSourceArr), io.reactivex.internal.operators.single.SingleInternalHelper.toFlowable(), 2, io.reactivex.internal.util.ErrorMode.BOUNDARY));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concatArrayEager(io.reactivex.SingleSource<? extends T>... singleSourceArr) {
        return io.reactivex.Flowable.fromArray(singleSourceArr).concatMapEager(io.reactivex.internal.operators.single.SingleInternalHelper.toFlowable());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concatEager(java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> iterable) {
        return io.reactivex.Flowable.fromIterable(iterable).concatMapEager(io.reactivex.internal.operators.single.SingleInternalHelper.toFlowable());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concatEager(org.reactivestreams.Publisher<? extends io.reactivex.SingleSource<? extends T>> publisher) {
        return io.reactivex.Flowable.fromPublisher(publisher).concatMapEager(io.reactivex.internal.operators.single.SingleInternalHelper.toFlowable());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> create(io.reactivex.SingleOnSubscribe<T> singleOnSubscribe) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleOnSubscribe, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleCreate(singleOnSubscribe));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> defer(java.util.concurrent.Callable<? extends io.reactivex.SingleSource<? extends T>> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "singleSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDefer(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<java.lang.Boolean> equals(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.SingleSource<? extends T> singleSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "first is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "second is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleEquals(singleSource, singleSource2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> error(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "exception is null");
        return error((java.util.concurrent.Callable<? extends java.lang.Throwable>) io.reactivex.internal.functions.Functions.justCallable(th));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> error(java.util.concurrent.Callable<? extends java.lang.Throwable> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleError(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> fromCallable(java.util.concurrent.Callable<? extends T> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "callable is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleFromCallable(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<T> fromFuture(java.util.concurrent.Future<? extends T> future) {
        return b(io.reactivex.Flowable.fromFuture(future));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<T> fromFuture(java.util.concurrent.Future<? extends T> future, long j, java.util.concurrent.TimeUnit timeUnit) {
        return b(io.reactivex.Flowable.fromFuture(future, j, timeUnit));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<T> fromFuture(java.util.concurrent.Future<? extends T> future, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return b(io.reactivex.Flowable.fromFuture(future, j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<T> fromFuture(java.util.concurrent.Future<? extends T> future, io.reactivex.Scheduler scheduler) {
        return b(io.reactivex.Flowable.fromFuture(future, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> fromObservable(io.reactivex.ObservableSource<? extends T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "observableSource is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSingleSingle(observableSource, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> fromPublisher(org.reactivestreams.Publisher<? extends T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "publisher is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleFromPublisher(publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> just(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleJust(t));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> merge(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.SingleSource<? extends T> singleSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        return merge(io.reactivex.Flowable.fromArray(singleSource, singleSource2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> merge(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.SingleSource<? extends T> singleSource2, io.reactivex.SingleSource<? extends T> singleSource3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        return merge(io.reactivex.Flowable.fromArray(singleSource, singleSource2, singleSource3));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> merge(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.SingleSource<? extends T> singleSource2, io.reactivex.SingleSource<? extends T> singleSource3, io.reactivex.SingleSource<? extends T> singleSource4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        return merge(io.reactivex.Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> merge(java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> iterable) {
        return merge(io.reactivex.Flowable.fromIterable(iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> merge(org.reactivestreams.Publisher<? extends io.reactivex.SingleSource<? extends T>> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher(publisher, io.reactivex.internal.operators.single.SingleInternalHelper.toFlowable(), false, Integer.MAX_VALUE, io.reactivex.Flowable.bufferSize()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> merge(io.reactivex.SingleSource<? extends io.reactivex.SingleSource<? extends T>> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleFlatMap(singleSource, io.reactivex.internal.functions.Functions.identity()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeDelayError(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.SingleSource<? extends T> singleSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        return mergeDelayError(io.reactivex.Flowable.fromArray(singleSource, singleSource2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeDelayError(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.SingleSource<? extends T> singleSource2, io.reactivex.SingleSource<? extends T> singleSource3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        return mergeDelayError(io.reactivex.Flowable.fromArray(singleSource, singleSource2, singleSource3));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeDelayError(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.SingleSource<? extends T> singleSource2, io.reactivex.SingleSource<? extends T> singleSource3, io.reactivex.SingleSource<? extends T> singleSource4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        return mergeDelayError(io.reactivex.Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeDelayError(java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> iterable) {
        return mergeDelayError(io.reactivex.Flowable.fromIterable(iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeDelayError(org.reactivestreams.Publisher<? extends io.reactivex.SingleSource<? extends T>> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher(publisher, io.reactivex.internal.operators.single.SingleInternalHelper.toFlowable(), true, Integer.MAX_VALUE, io.reactivex.Flowable.bufferSize()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<T> never() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(io.reactivex.internal.operators.single.SingleNever.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Single<java.lang.Long> timer(long j, java.util.concurrent.TimeUnit timeUnit) {
        return timer(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Single<java.lang.Long> timer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleTimer(j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> unsafeCreate(io.reactivex.SingleSource<T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "onSubscribe is null");
        if (singleSource instanceof io.reactivex.Single) {
            throw new java.lang.IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        }
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleFromUnsafeSource(singleSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, U> io.reactivex.Single<T> using(java.util.concurrent.Callable<U> callable, io.reactivex.functions.Function<? super U, ? extends io.reactivex.SingleSource<? extends T>> function, io.reactivex.functions.Consumer<? super U> consumer) {
        return using(callable, function, consumer, true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, U> io.reactivex.Single<T> using(java.util.concurrent.Callable<U> callable, io.reactivex.functions.Function<? super U, ? extends io.reactivex.SingleSource<? extends T>> function, io.reactivex.functions.Consumer<? super U> consumer, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "singleFunction is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "disposer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleUsing(callable, function, consumer, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<T> wrap(io.reactivex.SingleSource<T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source is null");
        return singleSource instanceof io.reactivex.Single ? io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.Single) singleSource) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleFromUnsafeSource(singleSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> io.reactivex.Single<R> zip(io.reactivex.SingleSource<? extends T1> singleSource, io.reactivex.SingleSource<? extends T2> singleSource2, io.reactivex.SingleSource<? extends T3> singleSource3, io.reactivex.SingleSource<? extends T4> singleSource4, io.reactivex.SingleSource<? extends T5> singleSource5, io.reactivex.SingleSource<? extends T6> singleSource6, io.reactivex.SingleSource<? extends T7> singleSource7, io.reactivex.SingleSource<? extends T8> singleSource8, io.reactivex.SingleSource<? extends T9> singleSource9, io.reactivex.functions.Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource7, "source7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource8, "source8 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource9, "source9 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function9), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, singleSource9);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> io.reactivex.Single<R> zip(io.reactivex.SingleSource<? extends T1> singleSource, io.reactivex.SingleSource<? extends T2> singleSource2, io.reactivex.SingleSource<? extends T3> singleSource3, io.reactivex.SingleSource<? extends T4> singleSource4, io.reactivex.SingleSource<? extends T5> singleSource5, io.reactivex.SingleSource<? extends T6> singleSource6, io.reactivex.SingleSource<? extends T7> singleSource7, io.reactivex.SingleSource<? extends T8> singleSource8, io.reactivex.functions.Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource7, "source7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource8, "source8 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function8), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, R> io.reactivex.Single<R> zip(io.reactivex.SingleSource<? extends T1> singleSource, io.reactivex.SingleSource<? extends T2> singleSource2, io.reactivex.SingleSource<? extends T3> singleSource3, io.reactivex.SingleSource<? extends T4> singleSource4, io.reactivex.SingleSource<? extends T5> singleSource5, io.reactivex.SingleSource<? extends T6> singleSource6, io.reactivex.SingleSource<? extends T7> singleSource7, io.reactivex.functions.Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource7, "source7 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function7), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, R> io.reactivex.Single<R> zip(io.reactivex.SingleSource<? extends T1> singleSource, io.reactivex.SingleSource<? extends T2> singleSource2, io.reactivex.SingleSource<? extends T3> singleSource3, io.reactivex.SingleSource<? extends T4> singleSource4, io.reactivex.SingleSource<? extends T5> singleSource5, io.reactivex.SingleSource<? extends T6> singleSource6, io.reactivex.functions.Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource6, "source6 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function6), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, R> io.reactivex.Single<R> zip(io.reactivex.SingleSource<? extends T1> singleSource, io.reactivex.SingleSource<? extends T2> singleSource2, io.reactivex.SingleSource<? extends T3> singleSource3, io.reactivex.SingleSource<? extends T4> singleSource4, io.reactivex.SingleSource<? extends T5> singleSource5, io.reactivex.functions.Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource5, "source5 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function5), singleSource, singleSource2, singleSource3, singleSource4, singleSource5);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, R> io.reactivex.Single<R> zip(io.reactivex.SingleSource<? extends T1> singleSource, io.reactivex.SingleSource<? extends T2> singleSource2, io.reactivex.SingleSource<? extends T3> singleSource3, io.reactivex.SingleSource<? extends T4> singleSource4, io.reactivex.functions.Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource4, "source4 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function4), singleSource, singleSource2, singleSource3, singleSource4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, R> io.reactivex.Single<R> zip(io.reactivex.SingleSource<? extends T1> singleSource, io.reactivex.SingleSource<? extends T2> singleSource2, io.reactivex.SingleSource<? extends T3> singleSource3, io.reactivex.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource3, "source3 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function3), singleSource, singleSource2, singleSource3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, R> io.reactivex.Single<R> zip(io.reactivex.SingleSource<? extends T1> singleSource, io.reactivex.SingleSource<? extends T2> singleSource2, io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource2, "source2 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(biFunction), singleSource, singleSource2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Single<R> zip(java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "zipper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleZipIterable(iterable, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Single<R> zipArray(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, io.reactivex.SingleSource<? extends T>... singleSourceArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "zipper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSourceArr, "sources is null");
        return singleSourceArr.length == 0 ? error(new java.util.NoSuchElementException()) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleZipArray(singleSourceArr, function));
    }

    public final io.reactivex.Single<T> a(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, io.reactivex.SingleSource<? extends T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleTimeout(this, j, timeUnit, scheduler, singleSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> ambWith(io.reactivex.SingleSource<? extends T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "other is null");
        return ambArray(this, singleSource);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> R as(@io.reactivex.annotations.NonNull io.reactivex.SingleConverter<T, ? extends R> singleConverter) {
        return (R) ((io.reactivex.SingleConverter) io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleConverter, "converter is null")).apply(this);
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
    public final io.reactivex.Single<T> cache() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleCache(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Single<U> cast(java.lang.Class<? extends U> cls) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(cls, "clazz is null");
        return (io.reactivex.Single<U>) map(io.reactivex.internal.functions.Functions.castFunction(cls));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Single<R> compose(io.reactivex.SingleTransformer<? super T, ? extends R> singleTransformer) {
        return wrap(((io.reactivex.SingleTransformer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleTransformer, "transformer is null")).apply(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> concatWith(io.reactivex.SingleSource<? extends T> singleSource) {
        return concat(this, singleSource);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.lang.Boolean> contains(java.lang.Object obj) {
        return contains(obj, io.reactivex.internal.functions.ObjectHelper.equalsPredicate());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<java.lang.Boolean> contains(java.lang.Object obj, io.reactivex.functions.BiPredicate<java.lang.Object, java.lang.Object> biPredicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(obj, "value is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biPredicate, "comparer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleContains(this, obj, biPredicate));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> delay(long j, java.util.concurrent.TimeUnit timeUnit) {
        return delay(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> delay(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> delay(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDelay(this, j, timeUnit, scheduler, z));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> delay(long j, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), z);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> delaySubscription(long j, java.util.concurrent.TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> delaySubscription(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return delaySubscription(io.reactivex.Observable.timer(j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> delaySubscription(io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDelayWithCompletable(this, completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Single<T> delaySubscription(io.reactivex.ObservableSource<U> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDelayWithObservable(this, observableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Single<T> delaySubscription(io.reactivex.SingleSource<U> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDelayWithSingle(this, singleSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Single<T> delaySubscription(org.reactivestreams.Publisher<U> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDelayWithPublisher(this, publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.Experimental
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Maybe<R> dematerialize(io.reactivex.functions.Function<? super T, io.reactivex.Notification<R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDematerialize(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> doAfterSuccess(io.reactivex.functions.Consumer<? super T> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onAfterSuccess is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDoAfterSuccess(this, consumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> doAfterTerminate(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onAfterTerminate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDoAfterTerminate(this, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> doFinally(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onFinally is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDoFinally(this, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> doOnDispose(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onDispose is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDoOnDispose(this, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> doOnError(io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onError is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDoOnError(this, consumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> doOnEvent(io.reactivex.functions.BiConsumer<? super T, ? super java.lang.Throwable> biConsumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biConsumer, "onEvent is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDoOnEvent(this, biConsumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> doOnSubscribe(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDoOnSubscribe(this, consumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> doOnSuccess(io.reactivex.functions.Consumer<? super T> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDoOnSuccess(this, consumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.Experimental
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> doOnTerminate(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onTerminate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDoOnTerminate(this, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> filter(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFilterSingle(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Single<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleFlatMap(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable flatMapCompletable(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleFlatMapCompletable(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Maybe<R> flatMapMaybe(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleFlatMapMaybe(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Observable<R> flatMapObservable(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.SingleFlatMapObservable(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> flatMapPublisher(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleFlatMapPublisher(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<U> flattenAsFlowable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Observable<U> flattenAsObservable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleFlatMapIterableObservable(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> hide() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleHide(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable ignoreElement() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableFromSingle(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Single<R> lift(io.reactivex.SingleOperator<? extends R, ? super T> singleOperator) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleOperator, "lift is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleLift(this, singleOperator));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Single<R> map(io.reactivex.functions.Function<? super T, ? extends R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleMap(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.Experimental
    public final io.reactivex.Single<io.reactivex.Notification<T>> materialize() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleMaterialize(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> mergeWith(io.reactivex.SingleSource<? extends T> singleSource) {
        return merge(this, singleSource);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> observeOn(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleObserveOn(this, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> onErrorResumeNext(io.reactivex.Single<? extends T> single) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(single, "resumeSingleInCaseOfError is null");
        return onErrorResumeNext(io.reactivex.internal.functions.Functions.justFunction(single));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> onErrorResumeNext(io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.SingleSource<? extends T>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "resumeFunctionInCaseOfError is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleResumeNext(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> onErrorReturn(io.reactivex.functions.Function<java.lang.Throwable, ? extends T> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleOnErrorReturn(this, function, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> onErrorReturnItem(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "value is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleOnErrorReturn(this, null, t));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> onTerminateDetach() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDetach(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> repeat() {
        return toFlowable().repeat();
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
    public final io.reactivex.Single<T> retry() {
        return b(toFlowable().retry());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> retry(long j) {
        return b(toFlowable().retry(j));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> retry(long j, io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        return b(toFlowable().retry(j, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> retry(io.reactivex.functions.BiPredicate<? super java.lang.Integer, ? super java.lang.Throwable> biPredicate) {
        return b(toFlowable().retry(biPredicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> retry(io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        return b(toFlowable().retry(predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> retryWhen(io.reactivex.functions.Function<? super io.reactivex.Flowable<java.lang.Throwable>, ? extends org.reactivestreams.Publisher<?>> function) {
        return b(toFlowable().retryWhen(function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    public final io.reactivex.disposables.Disposable subscribe() {
        return subscribe(io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.ON_ERROR_MISSING);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.BiConsumer<? super T, ? super java.lang.Throwable> biConsumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biConsumer, "onCallback is null");
        io.reactivex.internal.observers.BiConsumerSingleObserver biConsumerSingleObserver = new io.reactivex.internal.observers.BiConsumerSingleObserver(biConsumer);
        subscribe(biConsumerSingleObserver);
        return biConsumerSingleObserver;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer) {
        return subscribe(consumer, io.reactivex.internal.functions.Functions.ON_ERROR_MISSING);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer2, "onError is null");
        io.reactivex.internal.observers.ConsumerSingleObserver consumerSingleObserver = new io.reactivex.internal.observers.ConsumerSingleObserver(consumer, consumer2);
        subscribe(consumerSingleObserver);
        return consumerSingleObserver;
    }

    @Override // io.reactivex.SingleSource
    @io.reactivex.annotations.SchedulerSupport("none")
    public final void subscribe(io.reactivex.SingleObserver<? super T> singleObserver) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleObserver, "observer is null");
        io.reactivex.SingleObserver<? super T> onSubscribe = io.reactivex.plugins.RxJavaPlugins.onSubscribe(this, singleObserver);
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
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

    public abstract void subscribeActual(@io.reactivex.annotations.NonNull io.reactivex.SingleObserver<? super T> singleObserver);

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> subscribeOn(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleSubscribeOn(this, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <E extends io.reactivex.SingleObserver<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> takeUntil(io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return takeUntil(new io.reactivex.internal.operators.completable.CompletableToFlowable(completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <E> io.reactivex.Single<T> takeUntil(io.reactivex.SingleSource<? extends E> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "other is null");
        return takeUntil(new io.reactivex.internal.operators.single.SingleToFlowable(singleSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <E> io.reactivex.Single<T> takeUntil(org.reactivestreams.Publisher<E> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleTakeUntil(this, publisher));
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
    public final io.reactivex.Single<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit) {
        return a(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), null);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return a(j, timeUnit, scheduler, null);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, io.reactivex.SingleSource<? extends T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "other is null");
        return a(j, timeUnit, scheduler, singleSource);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.SingleSource<? extends T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "other is null");
        return a(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), singleSource);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> R to(io.reactivex.functions.Function<? super io.reactivex.Single<T>, R> function) {
        try {
            return (R) ((io.reactivex.functions.Function) io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "convert is null")).apply(this);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @java.lang.Deprecated
    public final io.reactivex.Completable toCompletable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableFromSingle(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> toFlowable() {
        return this instanceof io.reactivex.internal.fuseable.FuseToFlowable ? ((io.reactivex.internal.fuseable.FuseToFlowable) this).fuseToFlowable() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleToFlowable(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final java.util.concurrent.Future<T> toFuture() {
        return (java.util.concurrent.Future) subscribeWith(new io.reactivex.internal.observers.FutureSingleObserver());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> toMaybe() {
        return this instanceof io.reactivex.internal.fuseable.FuseToMaybe ? ((io.reactivex.internal.fuseable.FuseToMaybe) this).fuseToMaybe() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFromSingle(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> toObservable() {
        return this instanceof io.reactivex.internal.fuseable.FuseToObservable ? ((io.reactivex.internal.fuseable.FuseToObservable) this).fuseToObservable() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleToObservable(this));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> unsubscribeOn(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleUnsubscribeOn(this, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Single<R> zipWith(io.reactivex.SingleSource<U> singleSource, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return zip(this, singleSource, biFunction);
    }
}
