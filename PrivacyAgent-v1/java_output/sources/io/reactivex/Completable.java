package io.reactivex;

/* loaded from: classes9.dex */
public abstract class Completable implements io.reactivex.CompletableSource {
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable amb(java.lang.Iterable<? extends io.reactivex.CompletableSource> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableAmb(null, iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable ambArray(io.reactivex.CompletableSource... completableSourceArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
        return completableSourceArr.length == 0 ? complete() : completableSourceArr.length == 1 ? wrap(completableSourceArr[0]) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableAmb(completableSourceArr, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable b(org.reactivestreams.Publisher<? extends io.reactivex.CompletableSource> publisher, int i, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableMerge(publisher, i, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable complete() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(io.reactivex.internal.operators.completable.CompletableEmpty.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable concat(java.lang.Iterable<? extends io.reactivex.CompletableSource> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableConcatIterable(iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Completable concat(org.reactivestreams.Publisher<? extends io.reactivex.CompletableSource> publisher) {
        return concat(publisher, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable concat(org.reactivestreams.Publisher<? extends io.reactivex.CompletableSource> publisher, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableConcat(publisher, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable concatArray(io.reactivex.CompletableSource... completableSourceArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
        return completableSourceArr.length == 0 ? complete() : completableSourceArr.length == 1 ? wrap(completableSourceArr[0]) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableConcatArray(completableSourceArr));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable create(io.reactivex.CompletableOnSubscribe completableOnSubscribe) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableOnSubscribe, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableCreate(completableOnSubscribe));
    }

    public static java.lang.NullPointerException d(java.lang.Throwable th) {
        java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable defer(java.util.concurrent.Callable<? extends io.reactivex.CompletableSource> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "completableSupplier");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableDefer(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable error(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "error is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableError(th));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable error(java.util.concurrent.Callable<? extends java.lang.Throwable> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableErrorSupplier(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable fromAction(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "run is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableFromAction(action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable fromCallable(java.util.concurrent.Callable<?> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "callable is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableFromCallable(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable fromFuture(java.util.concurrent.Future<?> future) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(future, "future is null");
        return fromAction(io.reactivex.internal.functions.Functions.futureAction(future));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Completable fromMaybe(io.reactivex.MaybeSource<T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "maybe is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable(maybeSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Completable fromObservable(io.reactivex.ObservableSource<T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "observable is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableFromObservable(observableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Completable fromPublisher(org.reactivestreams.Publisher<T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "publisher is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableFromPublisher(publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable fromRunnable(java.lang.Runnable runnable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(runnable, "run is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableFromRunnable(runnable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Completable fromSingle(io.reactivex.SingleSource<T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "single is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableFromSingle(singleSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable merge(java.lang.Iterable<? extends io.reactivex.CompletableSource> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableMergeIterable(iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Completable merge(org.reactivestreams.Publisher<? extends io.reactivex.CompletableSource> publisher) {
        return b(publisher, Integer.MAX_VALUE, false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Completable merge(org.reactivestreams.Publisher<? extends io.reactivex.CompletableSource> publisher, int i) {
        return b(publisher, i, false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable mergeArray(io.reactivex.CompletableSource... completableSourceArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
        return completableSourceArr.length == 0 ? complete() : completableSourceArr.length == 1 ? wrap(completableSourceArr[0]) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableMergeArray(completableSourceArr));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable mergeArrayDelayError(io.reactivex.CompletableSource... completableSourceArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray(completableSourceArr));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable mergeDelayError(java.lang.Iterable<? extends io.reactivex.CompletableSource> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableMergeDelayErrorIterable(iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Completable mergeDelayError(org.reactivestreams.Publisher<? extends io.reactivex.CompletableSource> publisher) {
        return b(publisher, Integer.MAX_VALUE, true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Completable mergeDelayError(org.reactivestreams.Publisher<? extends io.reactivex.CompletableSource> publisher, int i) {
        return b(publisher, i, true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Completable never() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(io.reactivex.internal.operators.completable.CompletableNever.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Completable timer(long j, java.util.concurrent.TimeUnit timeUnit) {
        return timer(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable timer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableTimer(j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable unsafeCreate(io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "source is null");
        if (completableSource instanceof io.reactivex.Completable) {
            throw new java.lang.IllegalArgumentException("Use of unsafeCreate(Completable)!");
        }
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableFromUnsafeSource(completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <R> io.reactivex.Completable using(java.util.concurrent.Callable<R> callable, io.reactivex.functions.Function<? super R, ? extends io.reactivex.CompletableSource> function, io.reactivex.functions.Consumer<? super R> consumer) {
        return using(callable, function, consumer, true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <R> io.reactivex.Completable using(java.util.concurrent.Callable<R> callable, io.reactivex.functions.Function<? super R, ? extends io.reactivex.CompletableSource> function, io.reactivex.functions.Consumer<? super R> consumer, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "completableFunction is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "disposer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableUsing(callable, function, consumer, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Completable wrap(io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "source is null");
        return completableSource instanceof io.reactivex.Completable ? io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.Completable) completableSource) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableFromUnsafeSource(completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable a(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action, io.reactivex.functions.Action action2, io.reactivex.functions.Action action3, io.reactivex.functions.Action action4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer2, "onError is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action2, "onTerminate is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action3, "onAfterTerminate is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action4, "onDispose is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletablePeek(this, consumer, consumer2, action, action2, action3, action4));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable ambWith(io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return ambArray(this, completableSource);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable andThen(io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "next is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableAndThenCompletable(this, completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <T> io.reactivex.Flowable<T> andThen(org.reactivestreams.Publisher<T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "next is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.CompletableAndThenPublisher(this, publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <T> io.reactivex.Maybe<T> andThen(io.reactivex.MaybeSource<T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "next is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable(maybeSource, this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <T> io.reactivex.Observable<T> andThen(io.reactivex.ObservableSource<T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "next is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.CompletableAndThenObservable(this, observableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <T> io.reactivex.Single<T> andThen(io.reactivex.SingleSource<T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "next is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.single.SingleDelayWithCompletable(singleSource, this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> R as(@io.reactivex.annotations.NonNull io.reactivex.CompletableConverter<? extends R> completableConverter) {
        return (R) ((io.reactivex.CompletableConverter) io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableConverter, "converter is null")).apply(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    public final void blockingAwait() {
        io.reactivex.internal.observers.BlockingMultiObserver blockingMultiObserver = new io.reactivex.internal.observers.BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        blockingMultiObserver.blockingGet();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final boolean blockingAwait(long j, java.util.concurrent.TimeUnit timeUnit) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.observers.BlockingMultiObserver blockingMultiObserver = new io.reactivex.internal.observers.BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.blockingAwait(j, timeUnit);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.Nullable
    public final java.lang.Throwable blockingGet() {
        io.reactivex.internal.observers.BlockingMultiObserver blockingMultiObserver = new io.reactivex.internal.observers.BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.blockingGetError();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.Nullable
    public final java.lang.Throwable blockingGet(long j, java.util.concurrent.TimeUnit timeUnit) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.observers.BlockingMultiObserver blockingMultiObserver = new io.reactivex.internal.observers.BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.blockingGetError(j, timeUnit);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable c(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableTimeout(this, j, timeUnit, scheduler, completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable cache() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableCache(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable compose(io.reactivex.CompletableTransformer completableTransformer) {
        return wrap(((io.reactivex.CompletableTransformer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableTransformer, "transformer is null")).apply(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable concatWith(io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableAndThenCompletable(this, completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable delay(long j, java.util.concurrent.TimeUnit timeUnit) {
        return delay(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable delay(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable delay(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableDelay(this, j, timeUnit, scheduler, z));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.Experimental
    public final io.reactivex.Completable delaySubscription(long j, java.util.concurrent.TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.Experimental
    public final io.reactivex.Completable delaySubscription(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return timer(j, timeUnit, scheduler).andThen(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable doAfterTerminate(io.reactivex.functions.Action action) {
        io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer<? super java.lang.Throwable> emptyConsumer2 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action2 = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return a(emptyConsumer, emptyConsumer2, action2, action2, action, action2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable doFinally(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onFinally is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableDoFinally(this, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable doOnComplete(io.reactivex.functions.Action action) {
        io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer<? super java.lang.Throwable> emptyConsumer2 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action2 = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return a(emptyConsumer, emptyConsumer2, action, action2, action2, action2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable doOnDispose(io.reactivex.functions.Action action) {
        io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer<? super java.lang.Throwable> emptyConsumer2 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action2 = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return a(emptyConsumer, emptyConsumer2, action2, action2, action2, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable doOnError(io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer) {
        io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return a(emptyConsumer, consumer, action, action, action, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable doOnEvent(io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onEvent is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableDoOnEvent(this, consumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable doOnSubscribe(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        io.reactivex.functions.Consumer<? super java.lang.Throwable> emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return a(consumer, emptyConsumer, action, action, action, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable doOnTerminate(io.reactivex.functions.Action action) {
        io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Consumer<? super java.lang.Throwable> emptyConsumer2 = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action2 = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return a(emptyConsumer, emptyConsumer2, action2, action, action2, action2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable hide() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableHide(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable lift(io.reactivex.CompletableOperator completableOperator) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableOperator, "onLift is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableLift(this, completableOperator));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.Experimental
    public final <T> io.reactivex.Single<io.reactivex.Notification<T>> materialize() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableMaterialize(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable mergeWith(io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return mergeArray(this, completableSource);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable observeOn(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableObserveOn(this, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable onErrorComplete() {
        return onErrorComplete(io.reactivex.internal.functions.Functions.alwaysTrue());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable onErrorComplete(io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableOnErrorComplete(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable onErrorResumeNext(io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.CompletableSource> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "errorMapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableResumeNext(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable onTerminateDetach() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableDetach(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable repeat() {
        return fromPublisher(toFlowable().repeat());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable repeat(long j) {
        return fromPublisher(toFlowable().repeat(j));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable repeatUntil(io.reactivex.functions.BooleanSupplier booleanSupplier) {
        return fromPublisher(toFlowable().repeatUntil(booleanSupplier));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable repeatWhen(io.reactivex.functions.Function<? super io.reactivex.Flowable<java.lang.Object>, ? extends org.reactivestreams.Publisher<?>> function) {
        return fromPublisher(toFlowable().repeatWhen(function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable retry() {
        return fromPublisher(toFlowable().retry());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable retry(long j) {
        return fromPublisher(toFlowable().retry(j));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable retry(long j, io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        return fromPublisher(toFlowable().retry(j, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable retry(io.reactivex.functions.BiPredicate<? super java.lang.Integer, ? super java.lang.Throwable> biPredicate) {
        return fromPublisher(toFlowable().retry(biPredicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable retry(io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        return fromPublisher(toFlowable().retry(predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable retryWhen(io.reactivex.functions.Function<? super io.reactivex.Flowable<java.lang.Throwable>, ? extends org.reactivestreams.Publisher<?>> function) {
        return fromPublisher(toFlowable().retryWhen(function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable startWith(io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return concatArray(completableSource, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <T> io.reactivex.Flowable<T> startWith(org.reactivestreams.Publisher<T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return toFlowable().startWith((org.reactivestreams.Publisher) publisher);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <T> io.reactivex.Observable<T> startWith(io.reactivex.Observable<T> observable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observable, "other is null");
        return observable.concatWith(toObservable());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    public final io.reactivex.disposables.Disposable subscribe() {
        io.reactivex.internal.observers.EmptyCompletableObserver emptyCompletableObserver = new io.reactivex.internal.observers.EmptyCompletableObserver();
        subscribe(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        io.reactivex.internal.observers.CallbackCompletableObserver callbackCompletableObserver = new io.reactivex.internal.observers.CallbackCompletableObserver(action);
        subscribe(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Action action, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onError is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        io.reactivex.internal.observers.CallbackCompletableObserver callbackCompletableObserver = new io.reactivex.internal.observers.CallbackCompletableObserver(consumer, action);
        subscribe(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    @Override // io.reactivex.CompletableSource
    @io.reactivex.annotations.SchedulerSupport("none")
    public final void subscribe(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableObserver, "observer is null");
        try {
            io.reactivex.CompletableObserver onSubscribe = io.reactivex.plugins.RxJavaPlugins.onSubscribe(this, completableObserver);
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(onSubscribe);
        } catch (java.lang.NullPointerException e) {
            throw e;
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            throw d(th);
        }
    }

    public abstract void subscribeActual(io.reactivex.CompletableObserver completableObserver);

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable subscribeOn(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableSubscribeOn(this, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <E extends io.reactivex.CompletableObserver> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable takeUntil(io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable(this, completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observers.TestObserver<java.lang.Void> test() {
        io.reactivex.observers.TestObserver<java.lang.Void> testObserver = new io.reactivex.observers.TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observers.TestObserver<java.lang.Void> test(boolean z) {
        io.reactivex.observers.TestObserver<java.lang.Void> testObserver = new io.reactivex.observers.TestObserver<>();
        if (z) {
            testObserver.cancel();
        }
        subscribe(testObserver);
        return testObserver;
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable timeout(long j, java.util.concurrent.TimeUnit timeUnit) {
        return c(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), null);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return c(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), completableSource);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return c(j, timeUnit, scheduler, null);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return c(j, timeUnit, scheduler, completableSource);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> U to(io.reactivex.functions.Function<? super io.reactivex.Completable, U> function) {
        try {
            return (U) ((io.reactivex.functions.Function) io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <T> io.reactivex.Flowable<T> toFlowable() {
        return this instanceof io.reactivex.internal.fuseable.FuseToFlowable ? ((io.reactivex.internal.fuseable.FuseToFlowable) this).fuseToFlowable() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableToFlowable(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <T> io.reactivex.Maybe<T> toMaybe() {
        return this instanceof io.reactivex.internal.fuseable.FuseToMaybe ? ((io.reactivex.internal.fuseable.FuseToMaybe) this).fuseToMaybe() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.MaybeFromCompletable(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <T> io.reactivex.Observable<T> toObservable() {
        return this instanceof io.reactivex.internal.fuseable.FuseToObservable ? ((io.reactivex.internal.fuseable.FuseToObservable) this).fuseToObservable() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableToObservable(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <T> io.reactivex.Single<T> toSingle(java.util.concurrent.Callable<? extends T> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "completionValueSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableToSingle(this, callable, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <T> io.reactivex.Single<T> toSingleDefault(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "completionValue is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableToSingle(this, null, t));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable unsubscribeOn(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.CompletableDisposeOn(this, scheduler));
    }
}
