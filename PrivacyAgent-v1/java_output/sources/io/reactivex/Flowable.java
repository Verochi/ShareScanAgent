package io.reactivex;

/* loaded from: classes9.dex */
public abstract class Flowable<T> implements org.reactivestreams.Publisher<T> {
    public static final int n = java.lang.Math.max(1, java.lang.Integer.getInteger("rx2.buffer-size", 128).intValue());

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> amb(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableAmb(null, iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> ambArray(org.reactivestreams.Publisher<? extends T>... publisherArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisherArr, "sources is null");
        int length = publisherArr.length;
        return length == 0 ? empty() : length == 1 ? fromPublisher(publisherArr[0]) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableAmb(publisherArr, null));
    }

    public static int bufferSize() {
        return n;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Flowable<R> combineLatest(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, org.reactivestreams.Publisher<? extends T>... publisherArr) {
        return combineLatest(publisherArr, function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Flowable<R> combineLatest(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        return combineLatest(iterable, function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Flowable<R> combineLatest(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "combiner is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableCombineLatest((java.lang.Iterable) iterable, (io.reactivex.functions.Function) function, i, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T1, T2, R> io.reactivex.Flowable<R> combineLatest(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(biFunction), publisher, publisher2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, R> io.reactivex.Flowable<R> combineLatest(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, io.reactivex.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function3), publisher, publisher2, publisher3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, R> io.reactivex.Flowable<R> combineLatest(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, org.reactivestreams.Publisher<? extends T4> publisher4, io.reactivex.functions.Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function4), publisher, publisher2, publisher3, publisher4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, R> io.reactivex.Flowable<R> combineLatest(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, org.reactivestreams.Publisher<? extends T4> publisher4, org.reactivestreams.Publisher<? extends T5> publisher5, io.reactivex.functions.Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher5, "source5 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function5), publisher, publisher2, publisher3, publisher4, publisher5);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, R> io.reactivex.Flowable<R> combineLatest(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, org.reactivestreams.Publisher<? extends T4> publisher4, org.reactivestreams.Publisher<? extends T5> publisher5, org.reactivestreams.Publisher<? extends T6> publisher6, io.reactivex.functions.Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher6, "source6 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function6), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, R> io.reactivex.Flowable<R> combineLatest(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, org.reactivestreams.Publisher<? extends T4> publisher4, org.reactivestreams.Publisher<? extends T5> publisher5, org.reactivestreams.Publisher<? extends T6> publisher6, org.reactivestreams.Publisher<? extends T7> publisher7, io.reactivex.functions.Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher7, "source7 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function7), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> io.reactivex.Flowable<R> combineLatest(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, org.reactivestreams.Publisher<? extends T4> publisher4, org.reactivestreams.Publisher<? extends T5> publisher5, org.reactivestreams.Publisher<? extends T6> publisher6, org.reactivestreams.Publisher<? extends T7> publisher7, org.reactivestreams.Publisher<? extends T8> publisher8, io.reactivex.functions.Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher7, "source7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher8, "source8 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function8), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> io.reactivex.Flowable<R> combineLatest(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, org.reactivestreams.Publisher<? extends T4> publisher4, org.reactivestreams.Publisher<? extends T5> publisher5, org.reactivestreams.Publisher<? extends T6> publisher6, org.reactivestreams.Publisher<? extends T7> publisher7, org.reactivestreams.Publisher<? extends T8> publisher8, org.reactivestreams.Publisher<? extends T9> publisher9, io.reactivex.functions.Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher7, "source7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher8, "source8 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher9, "source9 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function9), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Flowable<R> combineLatest(org.reactivestreams.Publisher<? extends T>[] publisherArr, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        return combineLatest(publisherArr, function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Flowable<R> combineLatest(org.reactivestreams.Publisher<? extends T>[] publisherArr, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return empty();
        }
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "combiner is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableCombineLatest((org.reactivestreams.Publisher[]) publisherArr, (io.reactivex.functions.Function) function, i, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Flowable<R> combineLatestDelayError(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i, org.reactivestreams.Publisher<? extends T>... publisherArr) {
        return combineLatestDelayError(publisherArr, function, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Flowable<R> combineLatestDelayError(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, org.reactivestreams.Publisher<? extends T>... publisherArr) {
        return combineLatestDelayError(publisherArr, function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Flowable<R> combineLatestDelayError(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        return combineLatestDelayError(iterable, function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Flowable<R> combineLatestDelayError(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "combiner is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableCombineLatest((java.lang.Iterable) iterable, (io.reactivex.functions.Function) function, i, true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Flowable<R> combineLatestDelayError(org.reactivestreams.Publisher<? extends T>[] publisherArr, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        return combineLatestDelayError(publisherArr, function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Flowable<R> combineLatestDelayError(org.reactivestreams.Publisher<? extends T>[] publisherArr, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisherArr, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "combiner is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return publisherArr.length == 0 ? empty() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableCombineLatest((org.reactivestreams.Publisher[]) publisherArr, (io.reactivex.functions.Function) function, i, true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(io.reactivex.internal.functions.Functions.identity(), 2, false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concat(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher) {
        return concat(publisher, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concat(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).concatMap(io.reactivex.internal.functions.Functions.identity(), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return concatArray(publisher, publisher2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2, org.reactivestreams.Publisher<? extends T> publisher3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        return concatArray(publisher, publisher2, publisher3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concat(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2, org.reactivestreams.Publisher<? extends T> publisher3, org.reactivestreams.Publisher<? extends T> publisher4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        return concatArray(publisher, publisher2, publisher3, publisher4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatArray(org.reactivestreams.Publisher<? extends T>... publisherArr) {
        return publisherArr.length == 0 ? empty() : publisherArr.length == 1 ? fromPublisher(publisherArr[0]) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatArray(publisherArr, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatArrayDelayError(org.reactivestreams.Publisher<? extends T>... publisherArr) {
        return publisherArr.length == 0 ? empty() : publisherArr.length == 1 ? fromPublisher(publisherArr[0]) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatArray(publisherArr, true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concatArrayEager(int i, int i2, org.reactivestreams.Publisher<? extends T>... publisherArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisherArr, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatMapEager(new io.reactivex.internal.operators.flowable.FlowableFromArray(publisherArr), io.reactivex.internal.functions.Functions.identity(), i, i2, io.reactivex.internal.util.ErrorMode.IMMEDIATE));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatArrayEager(org.reactivestreams.Publisher<? extends T>... publisherArr) {
        return concatArrayEager(bufferSize(), bufferSize(), publisherArr);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatArrayEagerDelayError(int i, int i2, org.reactivestreams.Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).concatMapEagerDelayError(io.reactivex.internal.functions.Functions.identity(), i, i2, true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatArrayEagerDelayError(org.reactivestreams.Publisher<? extends T>... publisherArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), publisherArr);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concatDelayError(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(io.reactivex.internal.functions.Functions.identity());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatDelayError(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher) {
        return concatDelayError(publisher, bufferSize(), true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatDelayError(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher, int i, boolean z) {
        return fromPublisher(publisher).concatMapDelayError(io.reactivex.internal.functions.Functions.identity(), i, z);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatEager(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concatEager(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable, int i, int i2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatMapEager(new io.reactivex.internal.operators.flowable.FlowableFromIterable(iterable), io.reactivex.internal.functions.Functions.identity(), i, i2, io.reactivex.internal.util.ErrorMode.IMMEDIATE));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> concatEager(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher) {
        return concatEager(publisher, bufferSize(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> concatEager(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher, int i, int i2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatMapEagerPublisher(publisher, io.reactivex.internal.functions.Functions.identity(), i, i2, io.reactivex.internal.util.ErrorMode.IMMEDIATE));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> create(io.reactivex.FlowableOnSubscribe<T> flowableOnSubscribe, io.reactivex.BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(flowableOnSubscribe, "source is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(backpressureStrategy, "mode is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableCreate(flowableOnSubscribe, backpressureStrategy));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> defer(java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<? extends T>> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "supplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDefer(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> empty() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(io.reactivex.internal.operators.flowable.FlowableEmpty.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> error(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "throwable is null");
        return error((java.util.concurrent.Callable<? extends java.lang.Throwable>) io.reactivex.internal.functions.Functions.justCallable(th));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> error(java.util.concurrent.Callable<? extends java.lang.Throwable> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "supplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableError(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> fromArray(T... tArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(tArr, "items is null");
        return tArr.length == 0 ? empty() : tArr.length == 1 ? just(tArr[0]) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFromArray(tArr));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> fromCallable(java.util.concurrent.Callable<? extends T> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "supplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFromCallable(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> fromFuture(java.util.concurrent.Future<? extends T> future) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(future, "future is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFromFuture(future, 0L, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> fromFuture(java.util.concurrent.Future<? extends T> future, long j, java.util.concurrent.TimeUnit timeUnit) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(future, "future is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFromFuture(future, j, timeUnit));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> fromFuture(java.util.concurrent.Future<? extends T> future, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return fromFuture(future, j, timeUnit).subscribeOn(scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> fromFuture(java.util.concurrent.Future<? extends T> future, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return fromFuture(future).subscribeOn(scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> fromIterable(java.lang.Iterable<? extends T> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFromIterable(iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> fromPublisher(org.reactivestreams.Publisher<? extends T> publisher) {
        if (publisher instanceof io.reactivex.Flowable) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.Flowable) publisher);
        }
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFromPublisher(publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> generate(io.reactivex.functions.Consumer<io.reactivex.Emitter<T>> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "generator is null");
        return generate(io.reactivex.internal.functions.Functions.nullSupplier(), io.reactivex.internal.operators.flowable.FlowableInternalHelper.simpleGenerator(consumer), io.reactivex.internal.functions.Functions.emptyConsumer());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, S> io.reactivex.Flowable<T> generate(java.util.concurrent.Callable<S> callable, io.reactivex.functions.BiConsumer<S, io.reactivex.Emitter<T>> biConsumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biConsumer, "generator is null");
        return generate(callable, io.reactivex.internal.operators.flowable.FlowableInternalHelper.simpleBiGenerator(biConsumer), io.reactivex.internal.functions.Functions.emptyConsumer());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, S> io.reactivex.Flowable<T> generate(java.util.concurrent.Callable<S> callable, io.reactivex.functions.BiConsumer<S, io.reactivex.Emitter<T>> biConsumer, io.reactivex.functions.Consumer<? super S> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biConsumer, "generator is null");
        return generate(callable, io.reactivex.internal.operators.flowable.FlowableInternalHelper.simpleBiGenerator(biConsumer), consumer);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T, S> io.reactivex.Flowable<T> generate(java.util.concurrent.Callable<S> callable, io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> biFunction) {
        return generate(callable, biFunction, io.reactivex.internal.functions.Functions.emptyConsumer());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, S> io.reactivex.Flowable<T> generate(java.util.concurrent.Callable<S> callable, io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> biFunction, io.reactivex.functions.Consumer<? super S> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "initialState is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "generator is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "disposeState is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableGenerate(callable, biFunction, consumer));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Flowable<java.lang.Long> interval(long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Flowable<java.lang.Long> interval(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableInterval(java.lang.Math.max(0L, j), java.lang.Math.max(0L, j2), timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Flowable<java.lang.Long> interval(long j, java.util.concurrent.TimeUnit timeUnit) {
        return interval(j, j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Flowable<java.lang.Long> interval(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return interval(j, j, timeUnit, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Flowable<java.lang.Long> intervalRange(long j, long j2, long j3, long j4, java.util.concurrent.TimeUnit timeUnit) {
        return intervalRange(j, j2, j3, j4, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Flowable<java.lang.Long> intervalRange(long j, long j2, long j3, long j4, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        if (j2 < 0) {
            throw new java.lang.IllegalArgumentException("count >= 0 required but it was " + j2);
        }
        if (j2 == 0) {
            return empty().delay(j3, timeUnit, scheduler);
        }
        long j5 = j + (j2 - 1);
        if (j > 0 && j5 < 0) {
            throw new java.lang.IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableIntervalRange(j, j5, java.lang.Math.max(0L, j3), java.lang.Math.max(0L, j4), timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> just(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableJust(t));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> just(T t, T t2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        return fromArray(t, t2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> just(T t, T t2, T t3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t3, "item3 is null");
        return fromArray(t, t2, t3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> just(T t, T t2, T t3, T t4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t3, "item3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t4, "item4 is null");
        return fromArray(t, t2, t3, t4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> just(T t, T t2, T t3, T t4, T t5) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t3, "item3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t4, "item4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t5, "item5 is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t3, "item3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t4, "item4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t5, "item5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t6, "item6 is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t3, "item3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t4, "item4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t5, "item5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t6, "item6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t7, "item7 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t3, "item3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t4, "item4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t5, "item5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t6, "item6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t7, "item7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t8, "item8 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t3, "item3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t4, "item4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t5, "item5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t6, "item6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t7, "item7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t8, "item8 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t9, "item9 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t3, "item3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t4, "item4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t5, "item5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t6, "item6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t7, "item7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t8, "item8 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t9, "item9 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t10, "item10 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> merge(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.Functions.identity());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> merge(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.Functions.identity(), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> merge(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.Functions.identity(), false, i, i2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> merge(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher) {
        return merge(publisher, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> merge(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).flatMap(io.reactivex.internal.functions.Functions.identity(), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> merge(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return fromArray(publisher, publisher2).flatMap(io.reactivex.internal.functions.Functions.identity(), false, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> merge(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2, org.reactivestreams.Publisher<? extends T> publisher3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        return fromArray(publisher, publisher2, publisher3).flatMap(io.reactivex.internal.functions.Functions.identity(), false, 3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> merge(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2, org.reactivestreams.Publisher<? extends T> publisher3, org.reactivestreams.Publisher<? extends T> publisher4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        return fromArray(publisher, publisher2, publisher3, publisher4).flatMap(io.reactivex.internal.functions.Functions.identity(), false, 4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> mergeArray(int i, int i2, org.reactivestreams.Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(io.reactivex.internal.functions.Functions.identity(), false, i, i2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> mergeArray(org.reactivestreams.Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(io.reactivex.internal.functions.Functions.identity(), publisherArr.length);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> mergeArrayDelayError(int i, int i2, org.reactivestreams.Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(io.reactivex.internal.functions.Functions.identity(), true, i, i2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> mergeArrayDelayError(org.reactivestreams.Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(io.reactivex.internal.functions.Functions.identity(), true, publisherArr.length);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> mergeDelayError(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.Functions.identity(), true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> mergeDelayError(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.Functions.identity(), true, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> mergeDelayError(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.Functions.identity(), true, i, i2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> mergeDelayError(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher) {
        return mergeDelayError(publisher, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> mergeDelayError(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).flatMap(io.reactivex.internal.functions.Functions.identity(), true, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeDelayError(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return fromArray(publisher, publisher2).flatMap(io.reactivex.internal.functions.Functions.identity(), true, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeDelayError(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2, org.reactivestreams.Publisher<? extends T> publisher3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        return fromArray(publisher, publisher2, publisher3).flatMap(io.reactivex.internal.functions.Functions.identity(), true, 3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> mergeDelayError(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2, org.reactivestreams.Publisher<? extends T> publisher3, org.reactivestreams.Publisher<? extends T> publisher4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        return fromArray(publisher, publisher2, publisher3, publisher4).flatMap(io.reactivex.internal.functions.Functions.identity(), true, 4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> never() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(io.reactivex.internal.operators.flowable.FlowableNever.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Flowable<java.lang.Integer> range(int i, int i2) {
        if (i2 < 0) {
            throw new java.lang.IllegalArgumentException("count >= 0 required but it was " + i2);
        }
        if (i2 == 0) {
            return empty();
        }
        if (i2 == 1) {
            return just(java.lang.Integer.valueOf(i));
        }
        if (i + (i2 - 1) <= 2147483647L) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableRange(i, i2));
        }
        throw new java.lang.IllegalArgumentException("Integer overflow");
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Flowable<java.lang.Long> rangeLong(long j, long j2) {
        if (j2 < 0) {
            throw new java.lang.IllegalArgumentException("count >= 0 required but it was " + j2);
        }
        if (j2 == 0) {
            return empty();
        }
        if (j2 == 1) {
            return just(java.lang.Long.valueOf(j));
        }
        long j3 = (j2 - 1) + j;
        if (j <= 0 || j3 >= 0) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableRangeLong(j, j2));
        }
        throw new java.lang.IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<java.lang.Boolean> sequenceEqual(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2) {
        return sequenceEqual(publisher, publisher2, io.reactivex.internal.functions.ObjectHelper.equalsPredicate(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<java.lang.Boolean> sequenceEqual(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2, int i) {
        return sequenceEqual(publisher, publisher2, io.reactivex.internal.functions.ObjectHelper.equalsPredicate(), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<java.lang.Boolean> sequenceEqual(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2, io.reactivex.functions.BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(publisher, publisher2, biPredicate, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Single<java.lang.Boolean> sequenceEqual(org.reactivestreams.Publisher<? extends T> publisher, org.reactivestreams.Publisher<? extends T> publisher2, io.reactivex.functions.BiPredicate<? super T, ? super T> biPredicate, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biPredicate, "isEqual is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle(publisher, publisher2, biPredicate, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> switchOnNext(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher) {
        return fromPublisher(publisher).switchMap(io.reactivex.internal.functions.Functions.identity());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> switchOnNext(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).switchMap(io.reactivex.internal.functions.Functions.identity(), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> switchOnNextDelayError(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher) {
        return switchOnNextDelayError(publisher, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Flowable<T> switchOnNextDelayError(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).switchMapDelayError(io.reactivex.internal.functions.Functions.identity(), i);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Flowable<java.lang.Long> timer(long j, java.util.concurrent.TimeUnit timeUnit) {
        return timer(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Flowable<java.lang.Long> timer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableTimer(java.lang.Math.max(0L, j), timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.NONE)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Flowable<T> unsafeCreate(org.reactivestreams.Publisher<T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "onSubscribe is null");
        if (publisher instanceof io.reactivex.Flowable) {
            throw new java.lang.IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
        }
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFromPublisher(publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public static <T, D> io.reactivex.Flowable<T> using(java.util.concurrent.Callable<? extends D> callable, io.reactivex.functions.Function<? super D, ? extends org.reactivestreams.Publisher<? extends T>> function, io.reactivex.functions.Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, D> io.reactivex.Flowable<T> using(java.util.concurrent.Callable<? extends D> callable, io.reactivex.functions.Function<? super D, ? extends org.reactivestreams.Publisher<? extends T>> function, io.reactivex.functions.Consumer<? super D> consumer, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "sourceSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "resourceDisposer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableUsing(callable, function, consumer, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Flowable<R> zip(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "zipper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableZip(null, iterable, function, bufferSize(), false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Flowable<R> zip(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> publisher, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "zipper is null");
        return fromPublisher(publisher).toList().flatMapPublisher(io.reactivex.internal.operators.flowable.FlowableInternalHelper.zipIterable(function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, R> io.reactivex.Flowable<R> zip(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(biFunction), false, bufferSize(), publisher, publisher2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, R> io.reactivex.Flowable<R> zip(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(biFunction), z, bufferSize(), publisher, publisher2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, R> io.reactivex.Flowable<R> zip(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(biFunction), z, i, publisher, publisher2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, R> io.reactivex.Flowable<R> zip(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, io.reactivex.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function3), false, bufferSize(), publisher, publisher2, publisher3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, R> io.reactivex.Flowable<R> zip(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, org.reactivestreams.Publisher<? extends T4> publisher4, io.reactivex.functions.Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function4), false, bufferSize(), publisher, publisher2, publisher3, publisher4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, R> io.reactivex.Flowable<R> zip(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, org.reactivestreams.Publisher<? extends T4> publisher4, org.reactivestreams.Publisher<? extends T5> publisher5, io.reactivex.functions.Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher5, "source5 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function5), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, R> io.reactivex.Flowable<R> zip(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, org.reactivestreams.Publisher<? extends T4> publisher4, org.reactivestreams.Publisher<? extends T5> publisher5, org.reactivestreams.Publisher<? extends T6> publisher6, io.reactivex.functions.Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher6, "source6 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function6), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, R> io.reactivex.Flowable<R> zip(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, org.reactivestreams.Publisher<? extends T4> publisher4, org.reactivestreams.Publisher<? extends T5> publisher5, org.reactivestreams.Publisher<? extends T6> publisher6, org.reactivestreams.Publisher<? extends T7> publisher7, io.reactivex.functions.Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher7, "source7 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function7), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> io.reactivex.Flowable<R> zip(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, org.reactivestreams.Publisher<? extends T4> publisher4, org.reactivestreams.Publisher<? extends T5> publisher5, org.reactivestreams.Publisher<? extends T6> publisher6, org.reactivestreams.Publisher<? extends T7> publisher7, org.reactivestreams.Publisher<? extends T8> publisher8, io.reactivex.functions.Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher7, "source7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher8, "source8 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function8), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> io.reactivex.Flowable<R> zip(org.reactivestreams.Publisher<? extends T1> publisher, org.reactivestreams.Publisher<? extends T2> publisher2, org.reactivestreams.Publisher<? extends T3> publisher3, org.reactivestreams.Publisher<? extends T4> publisher4, org.reactivestreams.Publisher<? extends T5> publisher5, org.reactivestreams.Publisher<? extends T6> publisher6, org.reactivestreams.Publisher<? extends T7> publisher7, org.reactivestreams.Publisher<? extends T8> publisher8, org.reactivestreams.Publisher<? extends T9> publisher9, io.reactivex.functions.Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher7, "source7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher8, "source8 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher9, "source9 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function9), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Flowable<R> zipArray(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, boolean z, int i, org.reactivestreams.Publisher<? extends T>... publisherArr) {
        if (publisherArr.length == 0) {
            return empty();
        }
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "zipper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableZip(publisherArr, null, function, i, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Flowable<R> zipIterable(java.lang.Iterable<? extends org.reactivestreams.Publisher<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "zipper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableZip(null, iterable, function, i, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> a(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action, io.reactivex.functions.Action action2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onNext is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer2, "onError is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action2, "onAfterTerminate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDoOnEach(this, consumer, consumer2, action, action2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<java.lang.Boolean> all(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableAllSingle(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> ambWith(org.reactivestreams.Publisher<? extends T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return ambArray(this, publisher);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<java.lang.Boolean> any(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableAnySingle(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> R as(@io.reactivex.annotations.NonNull io.reactivex.FlowableConverter<T, ? extends R> flowableConverter) {
        return (R) ((io.reactivex.FlowableConverter) io.reactivex.internal.functions.ObjectHelper.requireNonNull(flowableConverter, "converter is null")).apply(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <R> io.reactivex.Flowable<R> b(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, int i, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        if (!(this instanceof io.reactivex.internal.fuseable.ScalarCallable)) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSwitchMap(this, function, i, z));
        }
        java.lang.Object call = ((io.reactivex.internal.fuseable.ScalarCallable) this).call();
        return call == null ? empty() : io.reactivex.internal.operators.flowable.FlowableScalarXMap.scalarXMap(call, function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingFirst() {
        io.reactivex.internal.subscribers.BlockingFirstSubscriber blockingFirstSubscriber = new io.reactivex.internal.subscribers.BlockingFirstSubscriber();
        subscribe((io.reactivex.FlowableSubscriber) blockingFirstSubscriber);
        T blockingGet = blockingFirstSubscriber.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new java.util.NoSuchElementException();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingFirst(T t) {
        io.reactivex.internal.subscribers.BlockingFirstSubscriber blockingFirstSubscriber = new io.reactivex.internal.subscribers.BlockingFirstSubscriber();
        subscribe((io.reactivex.FlowableSubscriber) blockingFirstSubscriber);
        T blockingGet = blockingFirstSubscriber.blockingGet();
        return blockingGet != null ? blockingGet : t;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    public final void blockingForEach(io.reactivex.functions.Consumer<? super T> consumer) {
        java.util.Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                consumer.accept(it.next());
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                ((io.reactivex.disposables.Disposable) it).dispose();
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
            }
        }
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final java.lang.Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final java.lang.Iterable<T> blockingIterable(int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return new io.reactivex.internal.operators.flowable.BlockingFlowableIterable(this, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingLast() {
        io.reactivex.internal.subscribers.BlockingLastSubscriber blockingLastSubscriber = new io.reactivex.internal.subscribers.BlockingLastSubscriber();
        subscribe((io.reactivex.FlowableSubscriber) blockingLastSubscriber);
        T blockingGet = blockingLastSubscriber.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new java.util.NoSuchElementException();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingLast(T t) {
        io.reactivex.internal.subscribers.BlockingLastSubscriber blockingLastSubscriber = new io.reactivex.internal.subscribers.BlockingLastSubscriber();
        subscribe((io.reactivex.FlowableSubscriber) blockingLastSubscriber);
        T blockingGet = blockingLastSubscriber.blockingGet();
        return blockingGet != null ? blockingGet : t;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final java.lang.Iterable<T> blockingLatest() {
        return new io.reactivex.internal.operators.flowable.BlockingFlowableLatest(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final java.lang.Iterable<T> blockingMostRecent(T t) {
        return new io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent(this, t);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final java.lang.Iterable<T> blockingNext() {
        return new io.reactivex.internal.operators.flowable.BlockingFlowableNext(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingSingle() {
        return singleOrError().blockingGet();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingSingle(T t) {
        return single(t).blockingGet();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    public final void blockingSubscribe() {
        io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    public final void blockingSubscribe(io.reactivex.functions.Consumer<? super T> consumer) {
        io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe(this, consumer, io.reactivex.internal.functions.Functions.ON_ERROR_MISSING, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    public final void blockingSubscribe(io.reactivex.functions.Consumer<? super T> consumer, int i) {
        io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe(this, consumer, io.reactivex.internal.functions.Functions.ON_ERROR_MISSING, io.reactivex.internal.functions.Functions.EMPTY_ACTION, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    public final void blockingSubscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2) {
        io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    public final void blockingSubscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, int i) {
        io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, io.reactivex.internal.functions.Functions.EMPTY_ACTION, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    public final void blockingSubscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action) {
        io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    public final void blockingSubscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action, int i) {
        io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, action, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    public final void blockingSubscribe(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe(this, subscriber);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<java.util.List<T>> buffer(int i) {
        return buffer(i, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<java.util.List<T>> buffer(int i, int i2) {
        return (io.reactivex.Flowable<java.util.List<T>>) buffer(i, i2, io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U extends java.util.Collection<? super T>> io.reactivex.Flowable<U> buffer(int i, int i2, java.util.concurrent.Callable<U> callable) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP);
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableBuffer(this, i, i2, callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <U extends java.util.Collection<? super T>> io.reactivex.Flowable<U> buffer(int i, java.util.concurrent.Callable<U> callable) {
        return buffer(i, i, callable);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<java.util.List<T>> buffer(long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        return (io.reactivex.Flowable<java.util.List<T>>) buffer(j, j2, timeUnit, io.reactivex.schedulers.Schedulers.computation(), io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<java.util.List<T>> buffer(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return (io.reactivex.Flowable<java.util.List<T>>) buffer(j, j2, timeUnit, scheduler, io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U extends java.util.Collection<? super T>> io.reactivex.Flowable<U> buffer(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, java.util.concurrent.Callable<U> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableBufferTimed(this, j, j2, timeUnit, scheduler, callable, Integer.MAX_VALUE, false));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<java.util.List<T>> buffer(long j, java.util.concurrent.TimeUnit timeUnit) {
        return buffer(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), Integer.MAX_VALUE);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<java.util.List<T>> buffer(long j, java.util.concurrent.TimeUnit timeUnit, int i) {
        return buffer(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), i);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<java.util.List<T>> buffer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return (io.reactivex.Flowable<java.util.List<T>>) buffer(j, timeUnit, scheduler, Integer.MAX_VALUE, io.reactivex.internal.util.ArrayListSupplier.asCallable(), false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<java.util.List<T>> buffer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i) {
        return (io.reactivex.Flowable<java.util.List<T>>) buffer(j, timeUnit, scheduler, i, io.reactivex.internal.util.ArrayListSupplier.asCallable(), false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final <U extends java.util.Collection<? super T>> io.reactivex.Flowable<U> buffer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i, java.util.concurrent.Callable<U> callable, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableBufferTimed(this, j, j, timeUnit, scheduler, callable, i, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final <TOpening, TClosing> io.reactivex.Flowable<java.util.List<T>> buffer(io.reactivex.Flowable<? extends TOpening> flowable, io.reactivex.functions.Function<? super TOpening, ? extends org.reactivestreams.Publisher<? extends TClosing>> function) {
        return (io.reactivex.Flowable<java.util.List<T>>) buffer(flowable, function, io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final <TOpening, TClosing, U extends java.util.Collection<? super T>> io.reactivex.Flowable<U> buffer(io.reactivex.Flowable<? extends TOpening> flowable, io.reactivex.functions.Function<? super TOpening, ? extends org.reactivestreams.Publisher<? extends TClosing>> function, java.util.concurrent.Callable<U> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(flowable, "openingIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "closingIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableBufferBoundary(this, flowable, function, callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final <B> io.reactivex.Flowable<java.util.List<T>> buffer(java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<B>> callable) {
        return (io.reactivex.Flowable<java.util.List<T>>) buffer(callable, io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final <B, U extends java.util.Collection<? super T>> io.reactivex.Flowable<U> buffer(java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<B>> callable, java.util.concurrent.Callable<U> callable2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "boundaryIndicatorSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable2, "bufferSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier(this, callable, callable2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final <B> io.reactivex.Flowable<java.util.List<T>> buffer(org.reactivestreams.Publisher<B> publisher) {
        return (io.reactivex.Flowable<java.util.List<T>>) buffer(publisher, io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final <B> io.reactivex.Flowable<java.util.List<T>> buffer(org.reactivestreams.Publisher<B> publisher, int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "initialCapacity");
        return (io.reactivex.Flowable<java.util.List<T>>) buffer(publisher, io.reactivex.internal.functions.Functions.createArrayList(i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final <B, U extends java.util.Collection<? super T>> io.reactivex.Flowable<U> buffer(org.reactivestreams.Publisher<B> publisher, java.util.concurrent.Callable<U> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "boundaryIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary(this, publisher, callable));
    }

    public final io.reactivex.Flowable<T> c(long j, java.util.concurrent.TimeUnit timeUnit, org.reactivestreams.Publisher<? extends T> publisher, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "timeUnit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableTimeoutTimed(this, j, timeUnit, scheduler, publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> cacheWithInitialCapacity(int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "initialCapacity");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableCache(this, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<U> cast(java.lang.Class<U> cls) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(cls, "clazz is null");
        return (io.reactivex.Flowable<U>) map(io.reactivex.internal.functions.Functions.castFunction(cls));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Single<U> collect(java.util.concurrent.Callable<? extends U> callable, io.reactivex.functions.BiConsumer<? super U, ? super T> biConsumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "initialItemSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biConsumer, "collector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableCollectSingle(this, callable, biConsumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Single<U> collectInto(U u, io.reactivex.functions.BiConsumer<? super U, ? super T> biConsumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(u, "initialItem is null");
        return collect(io.reactivex.internal.functions.Functions.justCallable(u), biConsumer);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> compose(io.reactivex.FlowableTransformer<? super T, ? extends R> flowableTransformer) {
        return fromPublisher(((io.reactivex.FlowableTransformer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(flowableTransformer, "composer is null")).apply(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> concatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function) {
        return concatMap(function, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> concatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        if (!(this instanceof io.reactivex.internal.fuseable.ScalarCallable)) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatMap(this, function, i, io.reactivex.internal.util.ErrorMode.IMMEDIATE));
        }
        java.lang.Object call = ((io.reactivex.internal.fuseable.ScalarCallable) this).call();
        return call == null ? empty() : io.reactivex.internal.operators.flowable.FlowableScalarXMap.scalarXMap(call, function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable concatMapCompletable(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        return concatMapCompletable(function, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable concatMapCompletable(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable(this, function, io.reactivex.internal.util.ErrorMode.IMMEDIATE, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable concatMapCompletableDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        return concatMapCompletableDelayError(function, true, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable concatMapCompletableDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, boolean z) {
        return concatMapCompletableDelayError(function, z, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable concatMapCompletableDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable(this, function, z ? io.reactivex.internal.util.ErrorMode.END : io.reactivex.internal.util.ErrorMode.BOUNDARY, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> concatMapDelayError(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function) {
        return concatMapDelayError(function, 2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> concatMapDelayError(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, int i, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        if (!(this instanceof io.reactivex.internal.fuseable.ScalarCallable)) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatMap(this, function, i, z ? io.reactivex.internal.util.ErrorMode.END : io.reactivex.internal.util.ErrorMode.BOUNDARY));
        }
        java.lang.Object call = ((io.reactivex.internal.fuseable.ScalarCallable) this).call();
        return call == null ? empty() : io.reactivex.internal.operators.flowable.FlowableScalarXMap.scalarXMap(call, function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> concatMapEager(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function) {
        return concatMapEager(function, bufferSize(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> concatMapEager(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, int i, int i2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatMapEager(this, function, i, i2, io.reactivex.internal.util.ErrorMode.IMMEDIATE));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> concatMapEagerDelayError(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, int i, int i2, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatMapEager(this, function, i, i2, z ? io.reactivex.internal.util.ErrorMode.END : io.reactivex.internal.util.ErrorMode.BOUNDARY));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> concatMapEagerDelayError(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, boolean z) {
        return concatMapEagerDelayError(function, bufferSize(), bufferSize(), z);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Flowable<U> concatMapIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function) {
        return concatMapIterable(function, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<U> concatMapIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFlattenIterable(this, function, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> concatMapMaybe(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        return concatMapMaybe(function, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> concatMapMaybe(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe(this, function, io.reactivex.internal.util.ErrorMode.IMMEDIATE, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> concatMapMaybeDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        return concatMapMaybeDelayError(function, true, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> concatMapMaybeDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function, boolean z) {
        return concatMapMaybeDelayError(function, z, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> concatMapMaybeDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe(this, function, z ? io.reactivex.internal.util.ErrorMode.END : io.reactivex.internal.util.ErrorMode.BOUNDARY, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> concatMapSingle(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        return concatMapSingle(function, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> concatMapSingle(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.FlowableConcatMapSingle(this, function, io.reactivex.internal.util.ErrorMode.IMMEDIATE, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> concatMapSingleDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        return concatMapSingleDelayError(function, true, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> concatMapSingleDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function, boolean z) {
        return concatMapSingleDelayError(function, z, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> concatMapSingleDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.FlowableConcatMapSingle(this, function, z ? io.reactivex.internal.util.ErrorMode.END : io.reactivex.internal.util.ErrorMode.BOUNDARY, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> concatWith(@io.reactivex.annotations.NonNull io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatWithCompletable(this, completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> concatWith(@io.reactivex.annotations.NonNull io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe(this, maybeSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> concatWith(@io.reactivex.annotations.NonNull io.reactivex.SingleSource<? extends T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableConcatWithSingle(this, singleSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> concatWith(org.reactivestreams.Publisher<? extends T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return concat(this, publisher);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<java.lang.Boolean> contains(java.lang.Object obj) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(obj, "item is null");
        return any(io.reactivex.internal.functions.Functions.equalsWith(obj));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.lang.Long> count() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableCountSingle(this));
    }

    public final <U, V> io.reactivex.Flowable<T> d(org.reactivestreams.Publisher<U> publisher, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> function, org.reactivestreams.Publisher<? extends T> publisher2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "itemTimeoutIndicator is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableTimeout(this, publisher, function, publisher2));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> debounce(long j, java.util.concurrent.TimeUnit timeUnit) {
        return debounce(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> debounce(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDebounceTimed(this, j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<T> debounce(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<U>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "debounceIndicator is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDebounce(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> defaultIfEmpty(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> delay(long j, java.util.concurrent.TimeUnit timeUnit) {
        return delay(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> delay(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> delay(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDelay(this, java.lang.Math.max(0L, j), timeUnit, scheduler, z));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> delay(long j, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), z);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<T> delay(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<U>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "itemDelayIndicator is null");
        return (io.reactivex.Flowable<T>) flatMap(io.reactivex.internal.operators.flowable.FlowableInternalHelper.itemDelay(function));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <U, V> io.reactivex.Flowable<T> delay(org.reactivestreams.Publisher<U> publisher, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> function) {
        return delaySubscription(publisher).delay(function);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> delaySubscription(long j, java.util.concurrent.TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> delaySubscription(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return delaySubscription(timer(j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<T> delaySubscription(org.reactivestreams.Publisher<U> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "subscriptionIndicator is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther(this, publisher));
    }

    @java.lang.Deprecated
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final <T2> io.reactivex.Flowable<T2> dematerialize() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDematerialize(this, io.reactivex.internal.functions.Functions.identity()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.Experimental
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> dematerialize(io.reactivex.functions.Function<? super T, io.reactivex.Notification<R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDematerialize(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> distinct() {
        return distinct(io.reactivex.internal.functions.Functions.identity(), io.reactivex.internal.functions.Functions.createHashSet());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Flowable<T> distinct(io.reactivex.functions.Function<? super T, K> function) {
        return distinct(function, io.reactivex.internal.functions.Functions.createHashSet());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Flowable<T> distinct(io.reactivex.functions.Function<? super T, K> function, java.util.concurrent.Callable<? extends java.util.Collection<? super K>> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDistinct(this, function, callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> distinctUntilChanged() {
        return distinctUntilChanged(io.reactivex.internal.functions.Functions.identity());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> distinctUntilChanged(io.reactivex.functions.BiPredicate<? super T, ? super T> biPredicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biPredicate, "comparer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged(this, io.reactivex.internal.functions.Functions.identity(), biPredicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Flowable<T> distinctUntilChanged(io.reactivex.functions.Function<? super T, K> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged(this, function, io.reactivex.internal.functions.ObjectHelper.equalsPredicate()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> doAfterNext(io.reactivex.functions.Consumer<? super T> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onAfterNext is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDoAfterNext(this, consumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> doAfterTerminate(io.reactivex.functions.Action action) {
        return a(io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.EMPTY_ACTION, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> doFinally(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onFinally is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDoFinally(this, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> doOnCancel(io.reactivex.functions.Action action) {
        return doOnLifecycle(io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.EMPTY_LONG_CONSUMER, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> doOnComplete(io.reactivex.functions.Action action) {
        return a(io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.emptyConsumer(), action, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> doOnEach(io.reactivex.functions.Consumer<? super io.reactivex.Notification<T>> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onNotification is null");
        return a(io.reactivex.internal.functions.Functions.notificationOnNext(consumer), io.reactivex.internal.functions.Functions.notificationOnError(consumer), io.reactivex.internal.functions.Functions.notificationOnComplete(consumer), io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> doOnEach(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(subscriber, "subscriber is null");
        return a(io.reactivex.internal.operators.flowable.FlowableInternalHelper.subscriberOnNext(subscriber), io.reactivex.internal.operators.flowable.FlowableInternalHelper.subscriberOnError(subscriber), io.reactivex.internal.operators.flowable.FlowableInternalHelper.subscriberOnComplete(subscriber), io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> doOnError(io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer) {
        io.reactivex.functions.Consumer<? super T> emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return a(emptyConsumer, consumer, action, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> doOnLifecycle(io.reactivex.functions.Consumer<? super org.reactivestreams.Subscription> consumer, io.reactivex.functions.LongConsumer longConsumer, io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onCancel is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDoOnLifecycle(this, consumer, longConsumer, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> doOnNext(io.reactivex.functions.Consumer<? super T> consumer) {
        io.reactivex.functions.Consumer<? super java.lang.Throwable> emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return a(consumer, emptyConsumer, action, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> doOnRequest(io.reactivex.functions.LongConsumer longConsumer) {
        return doOnLifecycle(io.reactivex.internal.functions.Functions.emptyConsumer(), longConsumer, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> doOnSubscribe(io.reactivex.functions.Consumer<? super org.reactivestreams.Subscription> consumer) {
        return doOnLifecycle(consumer, io.reactivex.internal.functions.Functions.EMPTY_LONG_CONSUMER, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> doOnTerminate(io.reactivex.functions.Action action) {
        return a(io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.actionConsumer(action), action, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> elementAt(long j) {
        if (j >= 0) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableElementAtMaybe(this, j));
        }
        throw new java.lang.IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> elementAt(long j, T t) {
        if (j >= 0) {
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultItem is null");
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableElementAtSingle(this, j, t));
        }
        throw new java.lang.IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> elementAtOrError(long j) {
        if (j >= 0) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableElementAtSingle(this, j, null));
        }
        throw new java.lang.IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> filter(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFilter(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> first(T t) {
        return elementAt(0L, t);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> firstElement() {
        return elementAt(0L);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> firstOrError() {
        return elementAtOrError(0L);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function) {
        return flatMap((io.reactivex.functions.Function) function, false, bufferSize(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, int i) {
        return flatMap((io.reactivex.functions.Function) function, false, i, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Flowable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Flowable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, int i) {
        return flatMap(function, biFunction, false, i, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Flowable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return flatMap(function, biFunction, z, bufferSize(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Flowable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return flatMap(function, biFunction, z, i, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U, R> io.reactivex.Flowable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i, int i2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "combiner is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, "bufferSize");
        return flatMap(io.reactivex.internal.operators.flowable.FlowableInternalHelper.flatMapWithCombiner(function, biFunction), z, i, i2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends org.reactivestreams.Publisher<? extends R>> function2, java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<? extends R>> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "onNextMapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new io.reactivex.internal.operators.flowable.FlowableMapNotification(this, function, function2, callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, io.reactivex.functions.Function<java.lang.Throwable, ? extends org.reactivestreams.Publisher<? extends R>> function2, java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<? extends R>> callable, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "onNextMapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new io.reactivex.internal.operators.flowable.FlowableMapNotification(this, function, function2, callable), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, boolean z) {
        return flatMap(function, z, bufferSize(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, boolean z, int i) {
        return flatMap(function, z, i, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, boolean z, int i, int i2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, "bufferSize");
        if (!(this instanceof io.reactivex.internal.fuseable.ScalarCallable)) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFlatMap(this, function, z, i, i2));
        }
        java.lang.Object call = ((io.reactivex.internal.fuseable.ScalarCallable) this).call();
        return call == null ? empty() : io.reactivex.internal.operators.flowable.FlowableScalarXMap.scalarXMap(call, function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable flatMapCompletable(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        return flatMapCompletable(function, false, Integer.MAX_VALUE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable flatMapCompletable(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable(this, function, z, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Flowable<U> flatMapIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function) {
        return flatMapIterable(function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<U> flatMapIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFlattenIterable(this, function, i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U, V> io.reactivex.Flowable<V> flatMapIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return (io.reactivex.Flowable<V>) flatMap(io.reactivex.internal.operators.flowable.FlowableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U, V> io.reactivex.Flowable<V> flatMapIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> biFunction, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return (io.reactivex.Flowable<V>) flatMap(io.reactivex.internal.operators.flowable.FlowableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> flatMapMaybe(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false, Integer.MAX_VALUE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> flatMapMaybe(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe(this, function, z, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> flatMapSingle(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        return flatMapSingle(function, false, Integer.MAX_VALUE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> flatMapSingle(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableFlatMapSingle(this, function, z, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.NONE)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable forEach(io.reactivex.functions.Consumer<? super T> consumer) {
        return subscribe(consumer);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.NONE)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable forEachWhile(io.reactivex.functions.Predicate<? super T> predicate) {
        return forEachWhile(predicate, io.reactivex.internal.functions.Functions.ON_ERROR_MISSING, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.NONE)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable forEachWhile(io.reactivex.functions.Predicate<? super T> predicate, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer) {
        return forEachWhile(predicate, consumer, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.NONE)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.disposables.Disposable forEachWhile(io.reactivex.functions.Predicate<? super T> predicate, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer, io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "onNext is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onError is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        io.reactivex.internal.subscribers.ForEachWhileSubscriber forEachWhileSubscriber = new io.reactivex.internal.subscribers.ForEachWhileSubscriber(predicate, consumer, action);
        subscribe((io.reactivex.FlowableSubscriber) forEachWhileSubscriber);
        return forEachWhileSubscriber;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Flowable<io.reactivex.flowables.GroupedFlowable<K, T>> groupBy(io.reactivex.functions.Function<? super T, ? extends K> function) {
        return (io.reactivex.Flowable<io.reactivex.flowables.GroupedFlowable<K, T>>) groupBy(function, io.reactivex.internal.functions.Functions.identity(), false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <K, V> io.reactivex.Flowable<io.reactivex.flowables.GroupedFlowable<K, V>> groupBy(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <K, V> io.reactivex.Flowable<io.reactivex.flowables.GroupedFlowable<K, V>> groupBy(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, boolean z) {
        return groupBy(function, function2, z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <K, V> io.reactivex.Flowable<io.reactivex.flowables.GroupedFlowable<K, V>> groupBy(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "valueSelector is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableGroupBy(this, function, function2, i, z, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <K, V> io.reactivex.Flowable<io.reactivex.flowables.GroupedFlowable<K, V>> groupBy(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, boolean z, int i, io.reactivex.functions.Function<? super io.reactivex.functions.Consumer<java.lang.Object>, ? extends java.util.Map<K, java.lang.Object>> function3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "valueSelector is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function3, "evictingMapFactory is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableGroupBy(this, function, function2, i, z, function3));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Flowable<io.reactivex.flowables.GroupedFlowable<K, T>> groupBy(io.reactivex.functions.Function<? super T, ? extends K> function, boolean z) {
        return (io.reactivex.Flowable<io.reactivex.flowables.GroupedFlowable<K, T>>) groupBy(function, io.reactivex.internal.functions.Functions.identity(), z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <TRight, TLeftEnd, TRightEnd, R> io.reactivex.Flowable<R> groupJoin(org.reactivestreams.Publisher<? extends TRight> publisher, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<TLeftEnd>> function, io.reactivex.functions.Function<? super TRight, ? extends org.reactivestreams.Publisher<TRightEnd>> function2, io.reactivex.functions.BiFunction<? super T, ? super io.reactivex.Flowable<TRight>, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "leftEnd is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "rightEnd is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableGroupJoin(this, publisher, function, function2, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> hide() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableHide(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable ignoreElements() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableIgnoreElementsCompletable(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.lang.Boolean> isEmpty() {
        return all(io.reactivex.internal.functions.Functions.alwaysFalse());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <TRight, TLeftEnd, TRightEnd, R> io.reactivex.Flowable<R> join(org.reactivestreams.Publisher<? extends TRight> publisher, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<TLeftEnd>> function, io.reactivex.functions.Function<? super TRight, ? extends org.reactivestreams.Publisher<TRightEnd>> function2, io.reactivex.functions.BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "leftEnd is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "rightEnd is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableJoin(this, publisher, function, function2, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> last(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultItem");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableLastSingle(this, t));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> lastElement() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableLastMaybe(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> lastOrError() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableLastSingle(this, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> lift(io.reactivex.FlowableOperator<? extends R, ? super T> flowableOperator) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(flowableOperator, "lifter is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableLift(this, flowableOperator));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> limit(long j) {
        if (j >= 0) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableLimit(this, j));
        }
        throw new java.lang.IllegalArgumentException("count >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> map(io.reactivex.functions.Function<? super T, ? extends R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableMap(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.Notification<T>> materialize() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableMaterialize(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> mergeWith(@io.reactivex.annotations.NonNull io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable(this, completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> mergeWith(@io.reactivex.annotations.NonNull io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe(this, maybeSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> mergeWith(@io.reactivex.annotations.NonNull io.reactivex.SingleSource<? extends T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableMergeWithSingle(this, singleSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> mergeWith(org.reactivestreams.Publisher<? extends T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return merge(this, publisher);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> observeOn(io.reactivex.Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> observeOn(io.reactivex.Scheduler scheduler, boolean z) {
        return observeOn(scheduler, z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> observeOn(io.reactivex.Scheduler scheduler, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableObserveOn(this, scheduler, z, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<U> ofType(java.lang.Class<U> cls) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(cls, "clazz is null");
        return filter(io.reactivex.internal.functions.Functions.isInstanceOf(cls)).cast(cls);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> onBackpressureBuffer() {
        return onBackpressureBuffer(bufferSize(), false, true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> onBackpressureBuffer(int i) {
        return onBackpressureBuffer(i, false, false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> onBackpressureBuffer(int i, io.reactivex.functions.Action action) {
        return onBackpressureBuffer(i, false, false, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> onBackpressureBuffer(int i, boolean z) {
        return onBackpressureBuffer(i, z, false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> onBackpressureBuffer(int i, boolean z, boolean z2) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "capacity");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer(this, i, z2, z, io.reactivex.internal.functions.Functions.EMPTY_ACTION));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> onBackpressureBuffer(int i, boolean z, boolean z2, io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onOverflow is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "capacity");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer(this, i, z2, z, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> onBackpressureBuffer(long j, io.reactivex.functions.Action action, io.reactivex.BackpressureOverflowStrategy backpressureOverflowStrategy) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(backpressureOverflowStrategy, "overflowStrategy is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(j, "capacity");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy(this, j, action, backpressureOverflowStrategy));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> onBackpressureBuffer(boolean z) {
        return onBackpressureBuffer(bufferSize(), z, true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> onBackpressureDrop() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> onBackpressureDrop(io.reactivex.functions.Consumer<? super T> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onDrop is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop(this, consumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> onBackpressureLatest() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> onErrorResumeNext(io.reactivex.functions.Function<? super java.lang.Throwable, ? extends org.reactivestreams.Publisher<? extends T>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableOnErrorNext(this, function, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> onErrorResumeNext(org.reactivestreams.Publisher<? extends T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "next is null");
        return onErrorResumeNext(io.reactivex.internal.functions.Functions.justFunction(publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> onErrorReturn(io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "valueSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableOnErrorReturn(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> onErrorReturnItem(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item is null");
        return onErrorReturn(io.reactivex.internal.functions.Functions.justFunction(t));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> onExceptionResumeNext(org.reactivestreams.Publisher<? extends T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "next is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableOnErrorNext(this, io.reactivex.internal.functions.Functions.justFunction(publisher), true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> onTerminateDetach() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableDetach(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.parallel.ParallelFlowable<T> parallel() {
        return io.reactivex.parallel.ParallelFlowable.from(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.parallel.ParallelFlowable<T> parallel(int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "parallelism");
        return io.reactivex.parallel.ParallelFlowable.from(this, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.parallel.ParallelFlowable<T> parallel(int i, int i2) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "parallelism");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, "prefetch");
        return io.reactivex.parallel.ParallelFlowable.from(this, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> publish(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> function) {
        return publish(function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> publish(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<? extends R>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowablePublishMulticast(this, function, i, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.flowables.ConnectableFlowable<T> publish() {
        return publish(bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.flowables.ConnectableFlowable<T> publish(int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.internal.operators.flowable.FlowablePublish.create(this, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> rebatchRequests(int i) {
        return observeOn(io.reactivex.internal.schedulers.ImmediateThinScheduler.INSTANCE, true, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Maybe<T> reduce(io.reactivex.functions.BiFunction<T, T, T> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableReduceMaybe(this, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Single<R> reduce(R r, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(r, "seed is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle(this, r, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Single<R> reduceWith(java.util.concurrent.Callable<R> callable, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "seedSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableReduceWithSingle(this, callable, biFunction));
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
        if (j >= 0) {
            return j == 0 ? empty() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableRepeat(this, j));
        }
        throw new java.lang.IllegalArgumentException("times >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> repeatUntil(io.reactivex.functions.BooleanSupplier booleanSupplier) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableRepeatUntil(this, booleanSupplier));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> repeatWhen(io.reactivex.functions.Function<? super io.reactivex.Flowable<java.lang.Object>, ? extends org.reactivestreams.Publisher<?>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "handler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableRepeatWhen(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        return io.reactivex.internal.operators.flowable.FlowableReplay.multicastSelector(io.reactivex.internal.operators.flowable.FlowableInternalHelper.replayCallable(this), function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.internal.operators.flowable.FlowableReplay.multicastSelector(io.reactivex.internal.operators.flowable.FlowableInternalHelper.replayCallable(this, i), function);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> function, int i, long j, java.util.concurrent.TimeUnit timeUnit) {
        return replay(function, i, j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> function, int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.internal.operators.flowable.FlowableReplay.multicastSelector(io.reactivex.internal.operators.flowable.FlowableInternalHelper.replayCallable(this, i, j, timeUnit, scheduler), function);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> function, int i, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.internal.operators.flowable.FlowableReplay.multicastSelector(io.reactivex.internal.operators.flowable.FlowableInternalHelper.replayCallable(this, i), io.reactivex.internal.operators.flowable.FlowableInternalHelper.replayFunction(function, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> function, long j, java.util.concurrent.TimeUnit timeUnit) {
        return replay(function, j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> function, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.internal.operators.flowable.FlowableReplay.multicastSelector(io.reactivex.internal.operators.flowable.FlowableInternalHelper.replayCallable(this, j, timeUnit, scheduler), function);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> function, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.internal.operators.flowable.FlowableReplay.multicastSelector(io.reactivex.internal.operators.flowable.FlowableInternalHelper.replayCallable(this), io.reactivex.internal.operators.flowable.FlowableInternalHelper.replayFunction(function, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.flowables.ConnectableFlowable<T> replay() {
        return io.reactivex.internal.operators.flowable.FlowableReplay.createFrom(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.flowables.ConnectableFlowable<T> replay(int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.internal.operators.flowable.FlowableReplay.create(this, i);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.flowables.ConnectableFlowable<T> replay(int i, long j, java.util.concurrent.TimeUnit timeUnit) {
        return replay(i, j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.flowables.ConnectableFlowable<T> replay(int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.internal.operators.flowable.FlowableReplay.create(this, j, timeUnit, scheduler, i);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.flowables.ConnectableFlowable<T> replay(int i, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.internal.operators.flowable.FlowableReplay.observeOn(replay(i), scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.flowables.ConnectableFlowable<T> replay(long j, java.util.concurrent.TimeUnit timeUnit) {
        return replay(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.flowables.ConnectableFlowable<T> replay(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.internal.operators.flowable.FlowableReplay.create(this, j, timeUnit, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.flowables.ConnectableFlowable<T> replay(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.internal.operators.flowable.FlowableReplay.observeOn(replay(), scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> retry() {
        return retry(Long.MAX_VALUE, io.reactivex.internal.functions.Functions.alwaysTrue());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> retry(long j) {
        return retry(j, io.reactivex.internal.functions.Functions.alwaysTrue());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> retry(long j, io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        if (j >= 0) {
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableRetryPredicate(this, j, predicate));
        }
        throw new java.lang.IllegalArgumentException("times >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> retry(io.reactivex.functions.BiPredicate<? super java.lang.Integer, ? super java.lang.Throwable> biPredicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biPredicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableRetryBiPredicate(this, biPredicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> retry(io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> retryUntil(io.reactivex.functions.BooleanSupplier booleanSupplier) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return retry(Long.MAX_VALUE, io.reactivex.internal.functions.Functions.predicateReverseFor(booleanSupplier));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> retryWhen(io.reactivex.functions.Function<? super io.reactivex.Flowable<java.lang.Throwable>, ? extends org.reactivestreams.Publisher<?>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "handler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableRetryWhen(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    public final void safeSubscribe(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(subscriber, "s is null");
        if (subscriber instanceof io.reactivex.subscribers.SafeSubscriber) {
            subscribe((io.reactivex.FlowableSubscriber) subscriber);
        } else {
            subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.subscribers.SafeSubscriber(subscriber));
        }
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> sample(long j, java.util.concurrent.TimeUnit timeUnit) {
        return sample(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> sample(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSampleTimed(this, j, timeUnit, scheduler, false));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> sample(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSampleTimed(this, j, timeUnit, scheduler, z));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> sample(long j, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        return sample(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), z);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<T> sample(org.reactivestreams.Publisher<U> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "sampler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSamplePublisher(this, publisher, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<T> sample(org.reactivestreams.Publisher<U> publisher, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "sampler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSamplePublisher(this, publisher, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> scan(io.reactivex.functions.BiFunction<T, T, T> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "accumulator is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableScan(this, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> scan(R r, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(r, "initialValue is null");
        return scanWith(io.reactivex.internal.functions.Functions.justCallable(r), biFunction);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> scanWith(java.util.concurrent.Callable<R> callable, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "seedSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "accumulator is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableScanSeed(this, callable, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> serialize() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSerialized(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> share() {
        return publish().refCount();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<T> single(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultItem is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSingleSingle(this, t));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> singleElement() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSingleMaybe(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> singleOrError() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSingleSingle(this, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> skip(long j) {
        return j <= 0 ? io.reactivex.plugins.RxJavaPlugins.onAssembly(this) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSkip(this, j));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> skip(long j, java.util.concurrent.TimeUnit timeUnit) {
        return skipUntil(timer(j, timeUnit));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> skip(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return skipUntil(timer(j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> skipLast(int i) {
        if (i >= 0) {
            return i == 0 ? io.reactivex.plugins.RxJavaPlugins.onAssembly(this) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSkipLast(this, i));
        }
        throw new java.lang.IndexOutOfBoundsException("count >= 0 required but it was " + i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> skipLast(long j, java.util.concurrent.TimeUnit timeUnit) {
        return skipLast(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> skipLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return skipLast(j, timeUnit, scheduler, false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> skipLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        return skipLast(j, timeUnit, scheduler, z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> skipLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSkipLastTimed(this, j, timeUnit, scheduler, i << 1, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> skipLast(long j, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        return skipLast(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<T> skipUntil(org.reactivestreams.Publisher<U> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSkipUntil(this, publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> skipWhile(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSkipWhile(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> sorted() {
        return toList().toFlowable().map(io.reactivex.internal.functions.Functions.listSorter(io.reactivex.internal.functions.Functions.naturalComparator())).flatMapIterable(io.reactivex.internal.functions.Functions.identity());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> sorted(java.util.Comparator<? super T> comparator) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(comparator, "sortFunction");
        return toList().toFlowable().map(io.reactivex.internal.functions.Functions.listSorter(comparator)).flatMapIterable(io.reactivex.internal.functions.Functions.identity());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> startWith(java.lang.Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> startWith(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "value is null");
        return concatArray(just(t), this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> startWith(org.reactivestreams.Publisher<? extends T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return concatArray(publisher, this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> startWithArray(T... tArr) {
        io.reactivex.Flowable fromArray = fromArray(tArr);
        return fromArray == empty() ? io.reactivex.plugins.RxJavaPlugins.onAssembly(this) : concatArray(fromArray, this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    public final io.reactivex.disposables.Disposable subscribe() {
        return subscribe(io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.ON_ERROR_MISSING, io.reactivex.internal.functions.Functions.EMPTY_ACTION, io.reactivex.internal.operators.flowable.FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer) {
        return subscribe(consumer, io.reactivex.internal.functions.Functions.ON_ERROR_MISSING, io.reactivex.internal.functions.Functions.EMPTY_ACTION, io.reactivex.internal.operators.flowable.FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2) {
        return subscribe(consumer, consumer2, io.reactivex.internal.functions.Functions.EMPTY_ACTION, io.reactivex.internal.operators.flowable.FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action) {
        return subscribe(consumer, consumer2, action, io.reactivex.internal.operators.flowable.FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action, io.reactivex.functions.Consumer<? super org.reactivestreams.Subscription> consumer3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onNext is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer2, "onError is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer3, "onSubscribe is null");
        io.reactivex.internal.subscribers.LambdaSubscriber lambdaSubscriber = new io.reactivex.internal.subscribers.LambdaSubscriber(consumer, consumer2, action, consumer3);
        subscribe((io.reactivex.FlowableSubscriber) lambdaSubscriber);
        return lambdaSubscriber;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    public final void subscribe(io.reactivex.FlowableSubscriber<? super T> flowableSubscriber) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(flowableSubscriber, "s is null");
        try {
            org.reactivestreams.Subscriber<? super T> onSubscribe = io.reactivex.plugins.RxJavaPlugins.onSubscribe(this, flowableSubscriber);
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(onSubscribe);
        } catch (java.lang.NullPointerException e) {
            throw e;
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @Override // org.reactivestreams.Publisher
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    public final void subscribe(org.reactivestreams.Subscriber<? super T> subscriber) {
        if (subscriber instanceof io.reactivex.FlowableSubscriber) {
            subscribe((io.reactivex.FlowableSubscriber) subscriber);
        } else {
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(subscriber, "s is null");
            subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.subscribers.StrictSubscriber(subscriber));
        }
    }

    public abstract void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber);

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> subscribeOn(@io.reactivex.annotations.NonNull io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return subscribeOn(scheduler, !(this instanceof io.reactivex.internal.operators.flowable.FlowableCreate));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> subscribeOn(@io.reactivex.annotations.NonNull io.reactivex.Scheduler scheduler, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSubscribeOn(this, scheduler, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    public final <E extends org.reactivestreams.Subscriber<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> switchIfEmpty(org.reactivestreams.Publisher<? extends T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableSwitchIfEmpty(this, publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> switchMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> switchMap(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, int i) {
        return b(function, i, false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable switchMapCompletable(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable(this, function, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Completable switchMapCompletableDelayError(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable(this, function, true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> switchMapDelayError(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Flowable<R> switchMapDelayError(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends R>> function, int i) {
        return b(function, i, true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> switchMapMaybe(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe(this, function, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> switchMapMaybeDelayError(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe(this, function, true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> switchMapSingle(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle(this, function, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> switchMapSingleDelayError(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle(this, function, true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> take(long j) {
        if (j >= 0) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableTake(this, j));
        }
        throw new java.lang.IllegalArgumentException("count >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> take(long j, java.util.concurrent.TimeUnit timeUnit) {
        return takeUntil(timer(j, timeUnit));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> take(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return takeUntil(timer(j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> takeLast(int i) {
        if (i >= 0) {
            return i == 0 ? io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableIgnoreElements(this)) : i == 1 ? io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableTakeLastOne(this)) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableTakeLast(this, i));
        }
        throw new java.lang.IndexOutOfBoundsException("count >= 0 required but it was " + i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> takeLast(long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        return takeLast(j, j2, timeUnit, io.reactivex.schedulers.Schedulers.computation(), false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> takeLast(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return takeLast(j, j2, timeUnit, scheduler, false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> takeLast(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        if (j >= 0) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableTakeLastTimed(this, j, j2, timeUnit, scheduler, i, z));
        }
        throw new java.lang.IndexOutOfBoundsException("count >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> takeLast(long j, java.util.concurrent.TimeUnit timeUnit) {
        return takeLast(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> takeLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return takeLast(j, timeUnit, scheduler, false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> takeLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        return takeLast(j, timeUnit, scheduler, z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> takeLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z, int i) {
        return takeLast(Long.MAX_VALUE, j, timeUnit, scheduler, z, i);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> takeLast(long j, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        return takeLast(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> takeUntil(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "stopPredicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableTakeUntilPredicate(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U> io.reactivex.Flowable<T> takeUntil(org.reactivestreams.Publisher<U> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableTakeUntil(this, publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> takeWhile(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableTakeWhile(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.subscribers.TestSubscriber<T> test() {
        io.reactivex.subscribers.TestSubscriber<T> testSubscriber = new io.reactivex.subscribers.TestSubscriber<>();
        subscribe((io.reactivex.FlowableSubscriber) testSubscriber);
        return testSubscriber;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.subscribers.TestSubscriber<T> test(long j) {
        io.reactivex.subscribers.TestSubscriber<T> testSubscriber = new io.reactivex.subscribers.TestSubscriber<>(j);
        subscribe((io.reactivex.FlowableSubscriber) testSubscriber);
        return testSubscriber;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.subscribers.TestSubscriber<T> test(long j, boolean z) {
        io.reactivex.subscribers.TestSubscriber<T> testSubscriber = new io.reactivex.subscribers.TestSubscriber<>(j);
        if (z) {
            testSubscriber.cancel();
        }
        subscribe((io.reactivex.FlowableSubscriber) testSubscriber);
        return testSubscriber;
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> throttleFirst(long j, java.util.concurrent.TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> throttleFirst(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed(this, j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> throttleLast(long j, java.util.concurrent.TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> throttleLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return sample(j, timeUnit, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> throttleLatest(long j, java.util.concurrent.TimeUnit timeUnit) {
        return throttleLatest(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> throttleLatest(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return throttleLatest(j, timeUnit, scheduler, false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> throttleLatest(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableThrottleLatest(this, j, timeUnit, scheduler, z));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> throttleLatest(long j, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        return throttleLatest(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), z);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> throttleWithTimeout(long j, java.util.concurrent.TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> throttleWithTimeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return debounce(j, timeUnit, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.schedulers.Timed<T>> timeInterval() {
        return timeInterval(java.util.concurrent.TimeUnit.MILLISECONDS, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.schedulers.Timed<T>> timeInterval(io.reactivex.Scheduler scheduler) {
        return timeInterval(java.util.concurrent.TimeUnit.MILLISECONDS, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.schedulers.Timed<T>> timeInterval(java.util.concurrent.TimeUnit timeUnit) {
        return timeInterval(timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.schedulers.Timed<T>> timeInterval(java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableTimeInterval(this, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit) {
        return c(j, timeUnit, null, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return c(j, timeUnit, null, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, org.reactivestreams.Publisher<? extends T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return c(j, timeUnit, publisher, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit, org.reactivestreams.Publisher<? extends T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return c(j, timeUnit, publisher, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final <V> io.reactivex.Flowable<T> timeout(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> function) {
        return d(null, function, null);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <V> io.reactivex.Flowable<T> timeout(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> function, io.reactivex.Flowable<? extends T> flowable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(flowable, "other is null");
        return d(null, function, flowable);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U, V> io.reactivex.Flowable<T> timeout(org.reactivestreams.Publisher<U> publisher, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "firstTimeoutIndicator is null");
        return d(publisher, function, null);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U, V> io.reactivex.Flowable<T> timeout(org.reactivestreams.Publisher<U> publisher, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> function, org.reactivestreams.Publisher<? extends T> publisher2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "firstTimeoutSelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "other is null");
        return d(publisher, function, publisher2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.schedulers.Timed<T>> timestamp() {
        return timestamp(java.util.concurrent.TimeUnit.MILLISECONDS, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.schedulers.Timed<T>> timestamp(io.reactivex.Scheduler scheduler) {
        return timestamp(java.util.concurrent.TimeUnit.MILLISECONDS, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.schedulers.Timed<T>> timestamp(java.util.concurrent.TimeUnit timeUnit) {
        return timestamp(timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<io.reactivex.schedulers.Timed<T>> timestamp(java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return (io.reactivex.Flowable<io.reactivex.schedulers.Timed<T>>) map(io.reactivex.internal.functions.Functions.timestampWith(timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> R to(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, R> function) {
        try {
            return (R) ((io.reactivex.functions.Function) io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final java.util.concurrent.Future<T> toFuture() {
        return (java.util.concurrent.Future) subscribeWith(new io.reactivex.internal.subscribers.FutureSubscriber());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.util.List<T>> toList() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableToListSingle(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.util.List<T>> toList(int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "capacityHint");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableToListSingle(this, io.reactivex.internal.functions.Functions.createArrayList(i)));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final <U extends java.util.Collection<? super T>> io.reactivex.Single<U> toList(java.util.concurrent.Callable<U> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableToListSingle(this, callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <K> io.reactivex.Single<java.util.Map<K, T>> toMap(io.reactivex.functions.Function<? super T, ? extends K> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        return (io.reactivex.Single<java.util.Map<K, T>>) collect(io.reactivex.internal.util.HashMapSupplier.asCallable(), io.reactivex.internal.functions.Functions.toMapKeySelector(function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <K, V> io.reactivex.Single<java.util.Map<K, V>> toMap(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "valueSelector is null");
        return (io.reactivex.Single<java.util.Map<K, V>>) collect(io.reactivex.internal.util.HashMapSupplier.asCallable(), io.reactivex.internal.functions.Functions.toMapKeyValueSelector(function, function2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <K, V> io.reactivex.Single<java.util.Map<K, V>> toMap(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, java.util.concurrent.Callable<? extends java.util.Map<K, V>> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "valueSelector is null");
        return (io.reactivex.Single<java.util.Map<K, V>>) collect(callable, io.reactivex.internal.functions.Functions.toMapKeyValueSelector(function, function2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Single<java.util.Map<K, java.util.Collection<T>>> toMultimap(io.reactivex.functions.Function<? super T, ? extends K> function) {
        return (io.reactivex.Single<java.util.Map<K, java.util.Collection<T>>>) toMultimap(function, io.reactivex.internal.functions.Functions.identity(), io.reactivex.internal.util.HashMapSupplier.asCallable(), io.reactivex.internal.util.ArrayListSupplier.asFunction());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final <K, V> io.reactivex.Single<java.util.Map<K, java.util.Collection<V>>> toMultimap(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2) {
        return toMultimap(function, function2, io.reactivex.internal.util.HashMapSupplier.asCallable(), io.reactivex.internal.util.ArrayListSupplier.asFunction());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final <K, V> io.reactivex.Single<java.util.Map<K, java.util.Collection<V>>> toMultimap(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, java.util.concurrent.Callable<java.util.Map<K, java.util.Collection<V>>> callable) {
        return toMultimap(function, function2, callable, io.reactivex.internal.util.ArrayListSupplier.asFunction());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <K, V> io.reactivex.Single<java.util.Map<K, java.util.Collection<V>>> toMultimap(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, java.util.concurrent.Callable<? extends java.util.Map<K, java.util.Collection<V>>> callable, io.reactivex.functions.Function<? super K, ? extends java.util.Collection<? super V>> function3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "valueSelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "mapSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function3, "collectionFactory is null");
        return (io.reactivex.Single<java.util.Map<K, java.util.Collection<V>>>) collect(callable, io.reactivex.internal.functions.Functions.toMultimapKeyValueSelector(function, function2, function3));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> toObservable() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFromPublisher(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.util.List<T>> toSortedList() {
        return toSortedList(io.reactivex.internal.functions.Functions.naturalComparator());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.util.List<T>> toSortedList(int i) {
        return toSortedList(io.reactivex.internal.functions.Functions.naturalComparator(), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<java.util.List<T>> toSortedList(java.util.Comparator<? super T> comparator) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(comparator, "comparator is null");
        return (io.reactivex.Single<java.util.List<T>>) toList().map(io.reactivex.internal.functions.Functions.listSorter(comparator));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Single<java.util.List<T>> toSortedList(java.util.Comparator<? super T> comparator, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(comparator, "comparator is null");
        return (io.reactivex.Single<java.util.List<T>>) toList(i).map(io.reactivex.internal.functions.Functions.listSorter(comparator));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<T> unsubscribeOn(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn(this, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j) {
        return window(j, j, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j, long j2) {
        return window(j, j2, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j, long j2, int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(j2, org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP);
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(j, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableWindow(this, j, j2, i));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        return window(j, j2, timeUnit, io.reactivex.schedulers.Schedulers.computation(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return window(j, j2, timeUnit, scheduler, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(j, "timespan");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(j2, "timeskip");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableWindowTimed(this, j, j2, timeUnit, scheduler, Long.MAX_VALUE, i, false));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit) {
        return window(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), Long.MAX_VALUE, false);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit, long j2) {
        return window(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), j2, false);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit, long j2, boolean z) {
        return window(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), j2, z);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return window(j, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, long j2) {
        return window(j, timeUnit, scheduler, j2, false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, long j2, boolean z) {
        return window(j, timeUnit, scheduler, j2, z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final io.reactivex.Flowable<io.reactivex.Flowable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, long j2, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(j2, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableWindowTimed(this, j, j, timeUnit, scheduler, j2, i, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final <B> io.reactivex.Flowable<io.reactivex.Flowable<T>> window(java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<B>> callable) {
        return window(callable, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <B> io.reactivex.Flowable<io.reactivex.Flowable<T>> window(java.util.concurrent.Callable<? extends org.reactivestreams.Publisher<B>> callable, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "boundaryIndicatorSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier(this, callable, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final <B> io.reactivex.Flowable<io.reactivex.Flowable<T>> window(org.reactivestreams.Publisher<B> publisher) {
        return window(publisher, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <B> io.reactivex.Flowable<io.reactivex.Flowable<T>> window(org.reactivestreams.Publisher<B> publisher, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "boundaryIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableWindowBoundary(this, publisher, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    public final <U, V> io.reactivex.Flowable<io.reactivex.Flowable<T>> window(org.reactivestreams.Publisher<U> publisher, io.reactivex.functions.Function<? super U, ? extends org.reactivestreams.Publisher<V>> function) {
        return window(publisher, function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.ERROR)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U, V> io.reactivex.Flowable<io.reactivex.Flowable<T>> window(org.reactivestreams.Publisher<U> publisher, io.reactivex.functions.Function<? super U, ? extends org.reactivestreams.Publisher<V>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "openingIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "closingIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector(this, publisher, function, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> withLatestFrom(java.lang.Iterable<? extends org.reactivestreams.Publisher<?>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "others is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "combiner is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany(this, iterable, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U, R> io.reactivex.Flowable<R> withLatestFrom(org.reactivestreams.Publisher<? extends U> publisher, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "combiner is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableWithLatestFrom(this, biFunction, publisher));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <T1, T2, R> io.reactivex.Flowable<R> withLatestFrom(org.reactivestreams.Publisher<T1> publisher, org.reactivestreams.Publisher<T2> publisher2, io.reactivex.functions.Function3<? super T, ? super T1, ? super T2, R> function3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return withLatestFrom((org.reactivestreams.Publisher<?>[]) new org.reactivestreams.Publisher[]{publisher, publisher2}, io.reactivex.internal.functions.Functions.toFunction(function3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <T1, T2, T3, R> io.reactivex.Flowable<R> withLatestFrom(org.reactivestreams.Publisher<T1> publisher, org.reactivestreams.Publisher<T2> publisher2, org.reactivestreams.Publisher<T3> publisher3, io.reactivex.functions.Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        return withLatestFrom((org.reactivestreams.Publisher<?>[]) new org.reactivestreams.Publisher[]{publisher, publisher2, publisher3}, io.reactivex.internal.functions.Functions.toFunction(function4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <T1, T2, T3, T4, R> io.reactivex.Flowable<R> withLatestFrom(org.reactivestreams.Publisher<T1> publisher, org.reactivestreams.Publisher<T2> publisher2, org.reactivestreams.Publisher<T3> publisher3, org.reactivestreams.Publisher<T4> publisher4, io.reactivex.functions.Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher4, "source4 is null");
        return withLatestFrom((org.reactivestreams.Publisher<?>[]) new org.reactivestreams.Publisher[]{publisher, publisher2, publisher3, publisher4}, io.reactivex.internal.functions.Functions.toFunction(function5));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.PASS_THROUGH)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Flowable<R> withLatestFrom(org.reactivestreams.Publisher<?>[] publisherArr, io.reactivex.functions.Function<? super java.lang.Object[], R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisherArr, "others is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "combiner is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany(this, publisherArr, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U, R> io.reactivex.Flowable<R> zipWith(java.lang.Iterable<U> iterable, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "other is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "zipper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableZipIterable(this, iterable, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <U, R> io.reactivex.Flowable<R> zipWith(org.reactivestreams.Publisher<? extends U> publisher, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "other is null");
        return zip(this, publisher, biFunction);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Flowable<R> zipWith(org.reactivestreams.Publisher<? extends U> publisher, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return zip(this, publisher, biFunction, z);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Flowable<R> zipWith(org.reactivestreams.Publisher<? extends U> publisher, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return zip(this, publisher, biFunction, z, i);
    }
}
