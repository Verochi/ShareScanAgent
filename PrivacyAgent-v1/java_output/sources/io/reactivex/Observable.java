package io.reactivex;

/* loaded from: classes9.dex */
public abstract class Observable<T> implements io.reactivex.ObservableSource<T> {

    /* renamed from: io.reactivex.Observable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.reactivex.BackpressureStrategy.values().length];
            a = iArr;
            try {
                iArr[io.reactivex.BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[io.reactivex.BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[io.reactivex.BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[io.reactivex.BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> amb(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableAmb(null, iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> ambArray(io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSourceArr, "sources is null");
        int length = observableSourceArr.length;
        return length == 0 ? empty() : length == 1 ? wrap(observableSourceArr[0]) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableAmb(observableSourceArr, null));
    }

    public static int bufferSize() {
        return io.reactivex.Flowable.bufferSize();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> io.reactivex.Observable<R> combineLatest(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.ObservableSource<? extends T4> observableSource4, io.reactivex.ObservableSource<? extends T5> observableSource5, io.reactivex.ObservableSource<? extends T6> observableSource6, io.reactivex.ObservableSource<? extends T7> observableSource7, io.reactivex.ObservableSource<? extends T8> observableSource8, io.reactivex.ObservableSource<? extends T9> observableSource9, io.reactivex.functions.Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource8, "source8 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource9, "source9 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function9), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> io.reactivex.Observable<R> combineLatest(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.ObservableSource<? extends T4> observableSource4, io.reactivex.ObservableSource<? extends T5> observableSource5, io.reactivex.ObservableSource<? extends T6> observableSource6, io.reactivex.ObservableSource<? extends T7> observableSource7, io.reactivex.ObservableSource<? extends T8> observableSource8, io.reactivex.functions.Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource8, "source8 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function8), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, R> io.reactivex.Observable<R> combineLatest(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.ObservableSource<? extends T4> observableSource4, io.reactivex.ObservableSource<? extends T5> observableSource5, io.reactivex.ObservableSource<? extends T6> observableSource6, io.reactivex.ObservableSource<? extends T7> observableSource7, io.reactivex.functions.Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function7), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, T6, R> io.reactivex.Observable<R> combineLatest(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.ObservableSource<? extends T4> observableSource4, io.reactivex.ObservableSource<? extends T5> observableSource5, io.reactivex.ObservableSource<? extends T6> observableSource6, io.reactivex.functions.Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function6), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, T5, R> io.reactivex.Observable<R> combineLatest(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.ObservableSource<? extends T4> observableSource4, io.reactivex.ObservableSource<? extends T5> observableSource5, io.reactivex.functions.Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function5), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, T4, R> io.reactivex.Observable<R> combineLatest(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.ObservableSource<? extends T4> observableSource4, io.reactivex.functions.Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function4), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, T3, R> io.reactivex.Observable<R> combineLatest(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(function3), bufferSize(), observableSource, observableSource2, observableSource3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T1, T2, R> io.reactivex.Observable<R> combineLatest(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return combineLatest(io.reactivex.internal.functions.Functions.toFunction(biFunction), bufferSize(), observableSource, observableSource2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Observable<R> combineLatest(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i, io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        return combineLatest(observableSourceArr, function, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Observable<R> combineLatest(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        return combineLatest(iterable, function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Observable<R> combineLatest(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "combiner is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableCombineLatest(null, iterable, function, i << 1, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Observable<R> combineLatest(io.reactivex.ObservableSource<? extends T>[] observableSourceArr, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        return combineLatest(observableSourceArr, function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Observable<R> combineLatest(io.reactivex.ObservableSource<? extends T>[] observableSourceArr, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "combiner is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableCombineLatest(observableSourceArr, null, function, i << 1, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Observable<R> combineLatestDelayError(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i, io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        return combineLatestDelayError(observableSourceArr, function, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Observable<R> combineLatestDelayError(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        return combineLatestDelayError(iterable, function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Observable<R> combineLatestDelayError(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "combiner is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableCombineLatest(null, iterable, function, i << 1, true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Observable<R> combineLatestDelayError(io.reactivex.ObservableSource<? extends T>[] observableSourceArr, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        return combineLatestDelayError(observableSourceArr, function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, R> io.reactivex.Observable<R> combineLatestDelayError(io.reactivex.ObservableSource<? extends T>[] observableSourceArr, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "combiner is null");
        return observableSourceArr.length == 0 ? empty() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableCombineLatest(observableSourceArr, null, function, i << 1, true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> concat(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource) {
        return concat(observableSource, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> concat(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableConcatMap(observableSource, io.reactivex.internal.functions.Functions.identity(), i, io.reactivex.internal.util.ErrorMode.IMMEDIATE));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> concat(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return concatArray(observableSource, observableSource2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> concat(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2, io.reactivex.ObservableSource<? extends T> observableSource3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return concatArray(observableSource, observableSource2, observableSource3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> concat(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2, io.reactivex.ObservableSource<? extends T> observableSource3, io.reactivex.ObservableSource<? extends T> observableSource4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return concatArray(observableSource, observableSource2, observableSource3, observableSource4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> concat(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(io.reactivex.internal.functions.Functions.identity(), bufferSize(), false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> concatArray(io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        return observableSourceArr.length == 0 ? empty() : observableSourceArr.length == 1 ? wrap(observableSourceArr[0]) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableConcatMap(fromArray(observableSourceArr), io.reactivex.internal.functions.Functions.identity(), bufferSize(), io.reactivex.internal.util.ErrorMode.BOUNDARY));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> concatArrayDelayError(io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        return observableSourceArr.length == 0 ? empty() : observableSourceArr.length == 1 ? wrap(observableSourceArr[0]) : concatDelayError(fromArray(observableSourceArr));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> concatArrayEager(int i, int i2, io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(io.reactivex.internal.functions.Functions.identity(), i, i2, false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> concatArrayEager(io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEager(bufferSize(), bufferSize(), observableSourceArr);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> concatArrayEagerDelayError(int i, int i2, io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(io.reactivex.internal.functions.Functions.identity(), i, i2, true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> concatArrayEagerDelayError(io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), observableSourceArr);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> concatDelayError(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource) {
        return concatDelayError(observableSource, bufferSize(), true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> concatDelayError(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource, int i, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableConcatMap(observableSource, io.reactivex.internal.functions.Functions.identity(), i, z ? io.reactivex.internal.util.ErrorMode.END : io.reactivex.internal.util.ErrorMode.BOUNDARY));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> concatDelayError(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> concatEager(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource) {
        return concatEager(observableSource, bufferSize(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> concatEager(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource, int i, int i2) {
        return wrap(observableSource).concatMapEager(io.reactivex.internal.functions.Functions.identity(), i, i2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> concatEager(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> concatEager(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).concatMapEagerDelayError(io.reactivex.internal.functions.Functions.identity(), i, i2, false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> create(io.reactivex.ObservableOnSubscribe<T> observableOnSubscribe) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableOnSubscribe, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableCreate(observableOnSubscribe));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> defer(java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<? extends T>> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "supplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDefer(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> empty() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(io.reactivex.internal.operators.observable.ObservableEmpty.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> error(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "exception is null");
        return error((java.util.concurrent.Callable<? extends java.lang.Throwable>) io.reactivex.internal.functions.Functions.justCallable(th));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> error(java.util.concurrent.Callable<? extends java.lang.Throwable> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableError(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> fromArray(T... tArr) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(tArr, "items is null");
        return tArr.length == 0 ? empty() : tArr.length == 1 ? just(tArr[0]) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFromArray(tArr));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> fromCallable(java.util.concurrent.Callable<? extends T> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "supplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFromCallable(callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> fromFuture(java.util.concurrent.Future<? extends T> future) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(future, "future is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFromFuture(future, 0L, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> fromFuture(java.util.concurrent.Future<? extends T> future, long j, java.util.concurrent.TimeUnit timeUnit) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(future, "future is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFromFuture(future, j, timeUnit));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> fromFuture(java.util.concurrent.Future<? extends T> future, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return fromFuture(future, j, timeUnit).subscribeOn(scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> fromFuture(java.util.concurrent.Future<? extends T> future, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return fromFuture(future).subscribeOn(scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> fromIterable(java.lang.Iterable<? extends T> iterable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFromIterable(iterable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.UNBOUNDED_IN)
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> fromPublisher(org.reactivestreams.Publisher<? extends T> publisher) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(publisher, "publisher is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFromPublisher(publisher));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> generate(io.reactivex.functions.Consumer<io.reactivex.Emitter<T>> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "generator is null");
        return generate(io.reactivex.internal.functions.Functions.nullSupplier(), io.reactivex.internal.operators.observable.ObservableInternalHelper.simpleGenerator(consumer), io.reactivex.internal.functions.Functions.emptyConsumer());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, S> io.reactivex.Observable<T> generate(java.util.concurrent.Callable<S> callable, io.reactivex.functions.BiConsumer<S, io.reactivex.Emitter<T>> biConsumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biConsumer, "generator is null");
        return generate(callable, io.reactivex.internal.operators.observable.ObservableInternalHelper.simpleBiGenerator(biConsumer), io.reactivex.internal.functions.Functions.emptyConsumer());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, S> io.reactivex.Observable<T> generate(java.util.concurrent.Callable<S> callable, io.reactivex.functions.BiConsumer<S, io.reactivex.Emitter<T>> biConsumer, io.reactivex.functions.Consumer<? super S> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biConsumer, "generator is null");
        return generate(callable, io.reactivex.internal.operators.observable.ObservableInternalHelper.simpleBiGenerator(biConsumer), consumer);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, S> io.reactivex.Observable<T> generate(java.util.concurrent.Callable<S> callable, io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> biFunction) {
        return generate(callable, biFunction, io.reactivex.internal.functions.Functions.emptyConsumer());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T, S> io.reactivex.Observable<T> generate(java.util.concurrent.Callable<S> callable, io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> biFunction, io.reactivex.functions.Consumer<? super S> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "initialState is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "generator is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "disposeState is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableGenerate(callable, biFunction, consumer));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Observable<java.lang.Long> interval(long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Observable<java.lang.Long> interval(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableInterval(java.lang.Math.max(0L, j), java.lang.Math.max(0L, j2), timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Observable<java.lang.Long> interval(long j, java.util.concurrent.TimeUnit timeUnit) {
        return interval(j, j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Observable<java.lang.Long> interval(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return interval(j, j, timeUnit, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Observable<java.lang.Long> intervalRange(long j, long j2, long j3, long j4, java.util.concurrent.TimeUnit timeUnit) {
        return intervalRange(j, j2, j3, j4, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.Observable<java.lang.Long> intervalRange(long j, long j2, long j3, long j4, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
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
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableIntervalRange(j, j5, java.lang.Math.max(0L, j3), java.lang.Math.max(0L, j4), timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> just(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableJust(t));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> just(T t, T t2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        return fromArray(t, t2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> just(T t, T t2, T t3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t3, "item3 is null");
        return fromArray(t, t2, t3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> just(T t, T t2, T t3, T t4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t3, "item3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t4, "item4 is null");
        return fromArray(t, t2, t3, t4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> just(T t, T t2, T t3, T t4, T t5) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t3, "item3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t4, "item4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t5, "item5 is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t2, "item2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t3, "item3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t4, "item4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t5, "item5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t6, "item6 is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
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
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
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
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
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
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
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
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> merge(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFlatMap(observableSource, io.reactivex.internal.functions.Functions.identity(), false, Integer.MAX_VALUE, bufferSize()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> merge(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFlatMap(observableSource, io.reactivex.internal.functions.Functions.identity(), false, i, bufferSize()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> merge(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(io.reactivex.internal.functions.Functions.identity(), false, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> merge(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2, io.reactivex.ObservableSource<? extends T> observableSource3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(io.reactivex.internal.functions.Functions.identity(), false, 3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> merge(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2, io.reactivex.ObservableSource<? extends T> observableSource3, io.reactivex.ObservableSource<? extends T> observableSource4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(io.reactivex.internal.functions.Functions.identity(), false, 4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> merge(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.Functions.identity());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> merge(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.Functions.identity(), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> merge(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.Functions.identity(), false, i, i2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> mergeArray(int i, int i2, io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(io.reactivex.internal.functions.Functions.identity(), false, i, i2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> mergeArray(io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(io.reactivex.internal.functions.Functions.identity(), observableSourceArr.length);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> mergeArrayDelayError(int i, int i2, io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(io.reactivex.internal.functions.Functions.identity(), true, i, i2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> mergeArrayDelayError(io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(io.reactivex.internal.functions.Functions.identity(), true, observableSourceArr.length);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> mergeDelayError(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFlatMap(observableSource, io.reactivex.internal.functions.Functions.identity(), true, Integer.MAX_VALUE, bufferSize()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> mergeDelayError(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFlatMap(observableSource, io.reactivex.internal.functions.Functions.identity(), true, i, bufferSize()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> mergeDelayError(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(io.reactivex.internal.functions.Functions.identity(), true, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> mergeDelayError(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2, io.reactivex.ObservableSource<? extends T> observableSource3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(io.reactivex.internal.functions.Functions.identity(), true, 3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> mergeDelayError(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2, io.reactivex.ObservableSource<? extends T> observableSource3, io.reactivex.ObservableSource<? extends T> observableSource4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(io.reactivex.internal.functions.Functions.identity(), true, 4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> mergeDelayError(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.Functions.identity(), true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> mergeDelayError(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.Functions.identity(), true, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> mergeDelayError(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(io.reactivex.internal.functions.Functions.identity(), true, i, i2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> never() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(io.reactivex.internal.operators.observable.ObservableNever.INSTANCE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Observable<java.lang.Integer> range(int i, int i2) {
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
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableRange(i, i2));
        }
        throw new java.lang.IllegalArgumentException("Integer overflow");
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Observable<java.lang.Long> rangeLong(long j, long j2) {
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
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableRangeLong(j, j2));
        }
        throw new java.lang.IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<java.lang.Boolean> sequenceEqual(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2) {
        return sequenceEqual(observableSource, observableSource2, io.reactivex.internal.functions.ObjectHelper.equalsPredicate(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<java.lang.Boolean> sequenceEqual(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2, int i) {
        return sequenceEqual(observableSource, observableSource2, io.reactivex.internal.functions.ObjectHelper.equalsPredicate(), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<java.lang.Boolean> sequenceEqual(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2, io.reactivex.functions.BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(observableSource, observableSource2, biPredicate, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Single<java.lang.Boolean> sequenceEqual(io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.ObservableSource<? extends T> observableSource2, io.reactivex.functions.BiPredicate<? super T, ? super T> biPredicate, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biPredicate, "isEqual is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> switchOnNext(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource) {
        return switchOnNext(observableSource, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> switchOnNext(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSwitchMap(observableSource, io.reactivex.internal.functions.Functions.identity(), i, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> switchOnNextDelayError(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource) {
        return switchOnNextDelayError(observableSource, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> switchOnNextDelayError(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSwitchMap(observableSource, io.reactivex.internal.functions.Functions.identity(), i, true));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Observable<java.lang.Long> timer(long j, java.util.concurrent.TimeUnit timeUnit) {
        return timer(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public static io.reactivex.Observable<java.lang.Long> timer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableTimer(java.lang.Math.max(j, 0L), timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> unsafeCreate(io.reactivex.ObservableSource<T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "onSubscribe is null");
        if (observableSource instanceof io.reactivex.Observable) {
            throw new java.lang.IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFromUnsafeSource(observableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, D> io.reactivex.Observable<T> using(java.util.concurrent.Callable<? extends D> callable, io.reactivex.functions.Function<? super D, ? extends io.reactivex.ObservableSource<? extends T>> function, io.reactivex.functions.Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, D> io.reactivex.Observable<T> using(java.util.concurrent.Callable<? extends D> callable, io.reactivex.functions.Function<? super D, ? extends io.reactivex.ObservableSource<? extends T>> function, io.reactivex.functions.Consumer<? super D> consumer, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "sourceSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "disposer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableUsing(callable, function, consumer, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T> io.reactivex.Observable<T> wrap(io.reactivex.ObservableSource<T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source is null");
        return observableSource instanceof io.reactivex.Observable ? io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.Observable) observableSource) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFromUnsafeSource(observableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> io.reactivex.Observable<R> zip(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.ObservableSource<? extends T4> observableSource4, io.reactivex.ObservableSource<? extends T5> observableSource5, io.reactivex.ObservableSource<? extends T6> observableSource6, io.reactivex.ObservableSource<? extends T7> observableSource7, io.reactivex.ObservableSource<? extends T8> observableSource8, io.reactivex.ObservableSource<? extends T9> observableSource9, io.reactivex.functions.Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource8, "source8 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource9, "source9 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function9), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> io.reactivex.Observable<R> zip(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.ObservableSource<? extends T4> observableSource4, io.reactivex.ObservableSource<? extends T5> observableSource5, io.reactivex.ObservableSource<? extends T6> observableSource6, io.reactivex.ObservableSource<? extends T7> observableSource7, io.reactivex.ObservableSource<? extends T8> observableSource8, io.reactivex.functions.Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource8, "source8 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function8), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> io.reactivex.Observable<R> zip(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.ObservableSource<? extends T4> observableSource4, io.reactivex.ObservableSource<? extends T5> observableSource5, io.reactivex.ObservableSource<? extends T6> observableSource6, io.reactivex.ObservableSource<? extends T7> observableSource7, io.reactivex.functions.Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function7), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> io.reactivex.Observable<R> zip(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.ObservableSource<? extends T4> observableSource4, io.reactivex.ObservableSource<? extends T5> observableSource5, io.reactivex.ObservableSource<? extends T6> observableSource6, io.reactivex.functions.Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function6), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> io.reactivex.Observable<R> zip(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.ObservableSource<? extends T4> observableSource4, io.reactivex.ObservableSource<? extends T5> observableSource5, io.reactivex.functions.Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function5), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T1, T2, T3, T4, R> io.reactivex.Observable<R> zip(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.ObservableSource<? extends T4> observableSource4, io.reactivex.functions.Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function4), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T1, T2, T3, R> io.reactivex.Observable<R> zip(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.ObservableSource<? extends T3> observableSource3, io.reactivex.functions.Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(function3), false, bufferSize(), observableSource, observableSource2, observableSource3);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T1, T2, R> io.reactivex.Observable<R> zip(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(biFunction), false, bufferSize(), observableSource, observableSource2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T1, T2, R> io.reactivex.Observable<R> zip(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(biFunction), z, bufferSize(), observableSource, observableSource2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T1, T2, R> io.reactivex.Observable<R> zip(io.reactivex.ObservableSource<? extends T1> observableSource, io.reactivex.ObservableSource<? extends T2> observableSource2, io.reactivex.functions.BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "source1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return zipArray(io.reactivex.internal.functions.Functions.toFunction(biFunction), z, i, observableSource, observableSource2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Observable<R> zip(io.reactivex.ObservableSource<? extends io.reactivex.ObservableSource<? extends T>> observableSource, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "zipper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableToList(observableSource, 16).flatMap(io.reactivex.internal.operators.observable.ObservableInternalHelper.zipIterable(function)));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Observable<R> zip(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "zipper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableZip(null, iterable, function, bufferSize(), false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Observable<R> zipArray(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, boolean z, int i, io.reactivex.ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "zipper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableZip(observableSourceArr, null, function, i, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public static <T, R> io.reactivex.Observable<R> zipIterable(java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "zipper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "sources is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableZip(null, iterable, function, i, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> a(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action, io.reactivex.functions.Action action2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onNext is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer2, "onError is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action2, "onAfterTerminate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDoOnEach(this, consumer, consumer2, action, action2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.lang.Boolean> all(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableAllSingle(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> ambWith(io.reactivex.ObservableSource<? extends T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return ambArray(this, observableSource);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.lang.Boolean> any(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableAnySingle(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> R as(@io.reactivex.annotations.NonNull io.reactivex.ObservableConverter<T, ? extends R> observableConverter) {
        return (R) ((io.reactivex.ObservableConverter) io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableConverter, "converter is null")).apply(this);
    }

    public final io.reactivex.Observable<T> b(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.ObservableSource<? extends T> observableSource, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "timeUnit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableTimeoutTimed(this, j, timeUnit, scheduler, observableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingFirst() {
        io.reactivex.internal.observers.BlockingFirstObserver blockingFirstObserver = new io.reactivex.internal.observers.BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T blockingGet = blockingFirstObserver.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new java.util.NoSuchElementException();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingFirst(T t) {
        io.reactivex.internal.observers.BlockingFirstObserver blockingFirstObserver = new io.reactivex.internal.observers.BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T blockingGet = blockingFirstObserver.blockingGet();
        return blockingGet != null ? blockingGet : t;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
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
    @io.reactivex.annotations.CheckReturnValue
    public final java.lang.Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final java.lang.Iterable<T> blockingIterable(int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return new io.reactivex.internal.operators.observable.BlockingObservableIterable(this, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingLast() {
        io.reactivex.internal.observers.BlockingLastObserver blockingLastObserver = new io.reactivex.internal.observers.BlockingLastObserver();
        subscribe(blockingLastObserver);
        T blockingGet = blockingLastObserver.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new java.util.NoSuchElementException();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingLast(T t) {
        io.reactivex.internal.observers.BlockingLastObserver blockingLastObserver = new io.reactivex.internal.observers.BlockingLastObserver();
        subscribe(blockingLastObserver);
        T blockingGet = blockingLastObserver.blockingGet();
        return blockingGet != null ? blockingGet : t;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final java.lang.Iterable<T> blockingLatest() {
        return new io.reactivex.internal.operators.observable.BlockingObservableLatest(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final java.lang.Iterable<T> blockingMostRecent(T t) {
        return new io.reactivex.internal.operators.observable.BlockingObservableMostRecent(this, t);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final java.lang.Iterable<T> blockingNext() {
        return new io.reactivex.internal.operators.observable.BlockingObservableNext(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingSingle() {
        T blockingGet = singleElement().blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new java.util.NoSuchElementException();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final T blockingSingle(T t) {
        return single(t).blockingGet();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    public final void blockingSubscribe() {
        io.reactivex.internal.operators.observable.ObservableBlockingSubscribe.subscribe(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    public final void blockingSubscribe(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.operators.observable.ObservableBlockingSubscribe.subscribe(this, observer);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    public final void blockingSubscribe(io.reactivex.functions.Consumer<? super T> consumer) {
        io.reactivex.internal.operators.observable.ObservableBlockingSubscribe.subscribe(this, consumer, io.reactivex.internal.functions.Functions.ON_ERROR_MISSING, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    public final void blockingSubscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2) {
        io.reactivex.internal.operators.observable.ObservableBlockingSubscribe.subscribe(this, consumer, consumer2, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    public final void blockingSubscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action) {
        io.reactivex.internal.operators.observable.ObservableBlockingSubscribe.subscribe(this, consumer, consumer2, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<java.util.List<T>> buffer(int i) {
        return buffer(i, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<java.util.List<T>> buffer(int i, int i2) {
        return (io.reactivex.Observable<java.util.List<T>>) buffer(i, i2, io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U extends java.util.Collection<? super T>> io.reactivex.Observable<U> buffer(int i, int i2, java.util.concurrent.Callable<U> callable) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP);
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableBuffer(this, i, i2, callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U extends java.util.Collection<? super T>> io.reactivex.Observable<U> buffer(int i, java.util.concurrent.Callable<U> callable) {
        return buffer(i, i, callable);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<java.util.List<T>> buffer(long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        return (io.reactivex.Observable<java.util.List<T>>) buffer(j, j2, timeUnit, io.reactivex.schedulers.Schedulers.computation(), io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<java.util.List<T>> buffer(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return (io.reactivex.Observable<java.util.List<T>>) buffer(j, j2, timeUnit, scheduler, io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final <U extends java.util.Collection<? super T>> io.reactivex.Observable<U> buffer(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, java.util.concurrent.Callable<U> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableBufferTimed(this, j, j2, timeUnit, scheduler, callable, Integer.MAX_VALUE, false));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<java.util.List<T>> buffer(long j, java.util.concurrent.TimeUnit timeUnit) {
        return buffer(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), Integer.MAX_VALUE);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<java.util.List<T>> buffer(long j, java.util.concurrent.TimeUnit timeUnit, int i) {
        return buffer(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), i);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<java.util.List<T>> buffer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return (io.reactivex.Observable<java.util.List<T>>) buffer(j, timeUnit, scheduler, Integer.MAX_VALUE, io.reactivex.internal.util.ArrayListSupplier.asCallable(), false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<java.util.List<T>> buffer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i) {
        return (io.reactivex.Observable<java.util.List<T>>) buffer(j, timeUnit, scheduler, i, io.reactivex.internal.util.ArrayListSupplier.asCallable(), false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final <U extends java.util.Collection<? super T>> io.reactivex.Observable<U> buffer(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i, java.util.concurrent.Callable<U> callable, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableBufferTimed(this, j, j, timeUnit, scheduler, callable, i, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <B> io.reactivex.Observable<java.util.List<T>> buffer(io.reactivex.ObservableSource<B> observableSource) {
        return (io.reactivex.Observable<java.util.List<T>>) buffer(observableSource, io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <B> io.reactivex.Observable<java.util.List<T>> buffer(io.reactivex.ObservableSource<B> observableSource, int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "initialCapacity");
        return (io.reactivex.Observable<java.util.List<T>>) buffer(observableSource, io.reactivex.internal.functions.Functions.createArrayList(i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <TOpening, TClosing> io.reactivex.Observable<java.util.List<T>> buffer(io.reactivex.ObservableSource<? extends TOpening> observableSource, io.reactivex.functions.Function<? super TOpening, ? extends io.reactivex.ObservableSource<? extends TClosing>> function) {
        return (io.reactivex.Observable<java.util.List<T>>) buffer(observableSource, function, io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <TOpening, TClosing, U extends java.util.Collection<? super T>> io.reactivex.Observable<U> buffer(io.reactivex.ObservableSource<? extends TOpening> observableSource, io.reactivex.functions.Function<? super TOpening, ? extends io.reactivex.ObservableSource<? extends TClosing>> function, java.util.concurrent.Callable<U> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "openingIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "closingIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableBufferBoundary(this, observableSource, function, callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <B, U extends java.util.Collection<? super T>> io.reactivex.Observable<U> buffer(io.reactivex.ObservableSource<B> observableSource, java.util.concurrent.Callable<U> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "boundary is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableBufferExactBoundary(this, observableSource, callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <B> io.reactivex.Observable<java.util.List<T>> buffer(java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<B>> callable) {
        return (io.reactivex.Observable<java.util.List<T>>) buffer(callable, io.reactivex.internal.util.ArrayListSupplier.asCallable());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <B, U extends java.util.Collection<? super T>> io.reactivex.Observable<U> buffer(java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<B>> callable, java.util.concurrent.Callable<U> callable2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "boundarySupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable2, "bufferSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier(this, callable, callable2));
    }

    public final <U, V> io.reactivex.Observable<T> c(io.reactivex.ObservableSource<U> observableSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>> function, io.reactivex.ObservableSource<? extends T> observableSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "itemTimeoutIndicator is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableTimeout(this, observableSource, function, observableSource2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> cacheWithInitialCapacity(int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "initialCapacity");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableCache(this, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Observable<U> cast(java.lang.Class<U> cls) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(cls, "clazz is null");
        return (io.reactivex.Observable<U>) map(io.reactivex.internal.functions.Functions.castFunction(cls));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Single<U> collect(java.util.concurrent.Callable<? extends U> callable, io.reactivex.functions.BiConsumer<? super U, ? super T> biConsumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "initialValueSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biConsumer, "collector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableCollectSingle(this, callable, biConsumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Single<U> collectInto(U u, io.reactivex.functions.BiConsumer<? super U, ? super T> biConsumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(u, "initialValue is null");
        return collect(io.reactivex.internal.functions.Functions.justCallable(u), biConsumer);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> compose(io.reactivex.ObservableTransformer<? super T, ? extends R> observableTransformer) {
        return wrap(((io.reactivex.ObservableTransformer) io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableTransformer, "composer is null")).apply(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function) {
        return concatMap(function, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        if (!(this instanceof io.reactivex.internal.fuseable.ScalarCallable)) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableConcatMap(this, function, i, io.reactivex.internal.util.ErrorMode.IMMEDIATE));
        }
        java.lang.Object call = ((io.reactivex.internal.fuseable.ScalarCallable) this).call();
        return call == null ? empty() : io.reactivex.internal.operators.observable.ObservableScalarXMap.scalarXMap(call, function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable concatMapCompletable(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        return concatMapCompletable(function, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable concatMapCompletable(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "capacityHint");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable(this, function, io.reactivex.internal.util.ErrorMode.IMMEDIATE, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable concatMapCompletableDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        return concatMapCompletableDelayError(function, true, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable concatMapCompletableDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, boolean z) {
        return concatMapCompletableDelayError(function, z, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable concatMapCompletableDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable(this, function, z ? io.reactivex.internal.util.ErrorMode.END : io.reactivex.internal.util.ErrorMode.BOUNDARY, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function) {
        return concatMapDelayError(function, bufferSize(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, int i, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        if (!(this instanceof io.reactivex.internal.fuseable.ScalarCallable)) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableConcatMap(this, function, i, z ? io.reactivex.internal.util.ErrorMode.END : io.reactivex.internal.util.ErrorMode.BOUNDARY));
        }
        java.lang.Object call = ((io.reactivex.internal.fuseable.ScalarCallable) this).call();
        return call == null ? empty() : io.reactivex.internal.operators.observable.ObservableScalarXMap.scalarXMap(call, function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapEager(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function) {
        return concatMapEager(function, Integer.MAX_VALUE, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapEager(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, int i, int i2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableConcatMapEager(this, function, io.reactivex.internal.util.ErrorMode.IMMEDIATE, i, i2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapEagerDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, int i, int i2, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableConcatMapEager(this, function, z ? io.reactivex.internal.util.ErrorMode.END : io.reactivex.internal.util.ErrorMode.BOUNDARY, i, i2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapEagerDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, boolean z) {
        return concatMapEagerDelayError(function, Integer.MAX_VALUE, bufferSize(), z);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Observable<U> concatMapIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFlattenIterable(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Observable<U> concatMapIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return (io.reactivex.Observable<U>) concatMap(io.reactivex.internal.operators.observable.ObservableInternalHelper.flatMapIntoIterable(function), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapMaybe(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        return concatMapMaybe(function, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapMaybe(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe(this, function, io.reactivex.internal.util.ErrorMode.IMMEDIATE, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapMaybeDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        return concatMapMaybeDelayError(function, true, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapMaybeDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function, boolean z) {
        return concatMapMaybeDelayError(function, z, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapMaybeDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe(this, function, z ? io.reactivex.internal.util.ErrorMode.END : io.reactivex.internal.util.ErrorMode.BOUNDARY, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapSingle(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        return concatMapSingle(function, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapSingle(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.ObservableConcatMapSingle(this, function, io.reactivex.internal.util.ErrorMode.IMMEDIATE, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapSingleDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        return concatMapSingleDelayError(function, true, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapSingleDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function, boolean z) {
        return concatMapSingleDelayError(function, z, 2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> concatMapSingleDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "prefetch");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.ObservableConcatMapSingle(this, function, z ? io.reactivex.internal.util.ErrorMode.END : io.reactivex.internal.util.ErrorMode.BOUNDARY, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> concatWith(@io.reactivex.annotations.NonNull io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableConcatWithCompletable(this, completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> concatWith(@io.reactivex.annotations.NonNull io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableConcatWithMaybe(this, maybeSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> concatWith(io.reactivex.ObservableSource<? extends T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return concat(this, observableSource);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> concatWith(@io.reactivex.annotations.NonNull io.reactivex.SingleSource<? extends T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableConcatWithSingle(this, singleSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.lang.Boolean> contains(java.lang.Object obj) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(obj, "element is null");
        return any(io.reactivex.internal.functions.Functions.equalsWith(obj));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.lang.Long> count() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableCountSingle(this));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> debounce(long j, java.util.concurrent.TimeUnit timeUnit) {
        return debounce(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> debounce(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDebounceTimed(this, j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Observable<T> debounce(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<U>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "debounceSelector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDebounce(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> defaultIfEmpty(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> delay(long j, java.util.concurrent.TimeUnit timeUnit) {
        return delay(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> delay(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> delay(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDelay(this, j, timeUnit, scheduler, z));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> delay(long j, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, V> io.reactivex.Observable<T> delay(io.reactivex.ObservableSource<U> observableSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>> function) {
        return delaySubscription(observableSource).delay(function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Observable<T> delay(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<U>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "itemDelay is null");
        return (io.reactivex.Observable<T>) flatMap(io.reactivex.internal.operators.observable.ObservableInternalHelper.itemDelay(function));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> delaySubscription(long j, java.util.concurrent.TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> delaySubscription(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return delaySubscription(timer(j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Observable<T> delaySubscription(io.reactivex.ObservableSource<U> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther(this, observableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @java.lang.Deprecated
    public final <T2> io.reactivex.Observable<T2> dematerialize() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDematerialize(this, io.reactivex.internal.functions.Functions.identity()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.Experimental
    public final <R> io.reactivex.Observable<R> dematerialize(io.reactivex.functions.Function<? super T, io.reactivex.Notification<R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDematerialize(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> distinct() {
        return distinct(io.reactivex.internal.functions.Functions.identity(), io.reactivex.internal.functions.Functions.createHashSet());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Observable<T> distinct(io.reactivex.functions.Function<? super T, K> function) {
        return distinct(function, io.reactivex.internal.functions.Functions.createHashSet());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Observable<T> distinct(io.reactivex.functions.Function<? super T, K> function, java.util.concurrent.Callable<? extends java.util.Collection<? super K>> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDistinct(this, function, callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> distinctUntilChanged() {
        return distinctUntilChanged(io.reactivex.internal.functions.Functions.identity());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> distinctUntilChanged(io.reactivex.functions.BiPredicate<? super T, ? super T> biPredicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biPredicate, "comparer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged(this, io.reactivex.internal.functions.Functions.identity(), biPredicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Observable<T> distinctUntilChanged(io.reactivex.functions.Function<? super T, K> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged(this, function, io.reactivex.internal.functions.ObjectHelper.equalsPredicate()));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> doAfterNext(io.reactivex.functions.Consumer<? super T> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onAfterNext is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDoAfterNext(this, consumer));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> doAfterTerminate(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onFinally is null");
        return a(io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.EMPTY_ACTION, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> doFinally(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onFinally is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDoFinally(this, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> doOnComplete(io.reactivex.functions.Action action) {
        return a(io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.emptyConsumer(), action, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> doOnDispose(io.reactivex.functions.Action action) {
        return doOnLifecycle(io.reactivex.internal.functions.Functions.emptyConsumer(), action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> doOnEach(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observer, "observer is null");
        return a(io.reactivex.internal.operators.observable.ObservableInternalHelper.observerOnNext(observer), io.reactivex.internal.operators.observable.ObservableInternalHelper.observerOnError(observer), io.reactivex.internal.operators.observable.ObservableInternalHelper.observerOnComplete(observer), io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> doOnEach(io.reactivex.functions.Consumer<? super io.reactivex.Notification<T>> consumer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onNotification is null");
        return a(io.reactivex.internal.functions.Functions.notificationOnNext(consumer), io.reactivex.internal.functions.Functions.notificationOnError(consumer), io.reactivex.internal.functions.Functions.notificationOnComplete(consumer), io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> doOnError(io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer) {
        io.reactivex.functions.Consumer<? super T> emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return a(emptyConsumer, consumer, action, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> doOnLifecycle(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer, io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onDispose is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDoOnLifecycle(this, consumer, action));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> doOnNext(io.reactivex.functions.Consumer<? super T> consumer) {
        io.reactivex.functions.Consumer<? super java.lang.Throwable> emptyConsumer = io.reactivex.internal.functions.Functions.emptyConsumer();
        io.reactivex.functions.Action action = io.reactivex.internal.functions.Functions.EMPTY_ACTION;
        return a(consumer, emptyConsumer, action, action);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> doOnSubscribe(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        return doOnLifecycle(consumer, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> doOnTerminate(io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onTerminate is null");
        return a(io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.actionConsumer(action), action, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> elementAt(long j) {
        if (j >= 0) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableElementAtMaybe(this, j));
        }
        throw new java.lang.IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> elementAt(long j, T t) {
        if (j >= 0) {
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultItem is null");
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableElementAtSingle(this, j, t));
        }
        throw new java.lang.IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> elementAtOrError(long j) {
        if (j >= 0) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableElementAtSingle(this, j, null));
        }
        throw new java.lang.IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> filter(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFilter(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> first(T t) {
        return elementAt(0L, t);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> firstElement() {
        return elementAt(0L);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> firstOrError() {
        return elementAtOrError(0L);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function) {
        return flatMap((io.reactivex.functions.Function) function, false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, int i) {
        return flatMap((io.reactivex.functions.Function) function, false, i, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Observable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Observable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, int i) {
        return flatMap(function, biFunction, false, i, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Observable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return flatMap(function, biFunction, z, bufferSize(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Observable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return flatMap(function, biFunction, z, i, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Observable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i, int i2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "combiner is null");
        return flatMap(io.reactivex.internal.operators.observable.ObservableInternalHelper.flatMapWithCombiner(function, biFunction), z, i, i2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.ObservableSource<? extends R>> function2, java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<? extends R>> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "onNextMapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new io.reactivex.internal.operators.observable.ObservableMapNotification(this, function, function2, callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, io.reactivex.functions.Function<java.lang.Throwable, ? extends io.reactivex.ObservableSource<? extends R>> function2, java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<? extends R>> callable, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "onNextMapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new io.reactivex.internal.operators.observable.ObservableMapNotification(this, function, function2, callable), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, boolean z) {
        return flatMap(function, z, Integer.MAX_VALUE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, boolean z, int i) {
        return flatMap(function, z, i, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> flatMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, boolean z, int i, int i2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "maxConcurrency");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i2, "bufferSize");
        if (!(this instanceof io.reactivex.internal.fuseable.ScalarCallable)) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFlatMap(this, function, z, i, i2));
        }
        java.lang.Object call = ((io.reactivex.internal.fuseable.ScalarCallable) this).call();
        return call == null ? empty() : io.reactivex.internal.operators.observable.ObservableScalarXMap.scalarXMap(call, function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable flatMapCompletable(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        return flatMapCompletable(function, false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable flatMapCompletable(io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable(this, function, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Observable<U> flatMapIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFlattenIterable(this, function));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, V> io.reactivex.Observable<V> flatMapIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return (io.reactivex.Observable<V>) flatMap(io.reactivex.internal.operators.observable.ObservableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> flatMapMaybe(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> flatMapMaybe(io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFlatMapMaybe(this, function, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> flatMapSingle(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        return flatMapSingle(function, false);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> flatMapSingle(io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableFlatMapSingle(this, function, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable forEach(io.reactivex.functions.Consumer<? super T> consumer) {
        return subscribe(consumer);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable forEachWhile(io.reactivex.functions.Predicate<? super T> predicate) {
        return forEachWhile(predicate, io.reactivex.internal.functions.Functions.ON_ERROR_MISSING, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable forEachWhile(io.reactivex.functions.Predicate<? super T> predicate, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer) {
        return forEachWhile(predicate, consumer, io.reactivex.internal.functions.Functions.EMPTY_ACTION);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable forEachWhile(io.reactivex.functions.Predicate<? super T> predicate, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer, io.reactivex.functions.Action action) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "onNext is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onError is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        io.reactivex.internal.observers.ForEachWhileObserver forEachWhileObserver = new io.reactivex.internal.observers.ForEachWhileObserver(predicate, consumer, action);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Observable<io.reactivex.observables.GroupedObservable<K, T>> groupBy(io.reactivex.functions.Function<? super T, ? extends K> function) {
        return (io.reactivex.Observable<io.reactivex.observables.GroupedObservable<K, T>>) groupBy(function, io.reactivex.internal.functions.Functions.identity(), false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K, V> io.reactivex.Observable<io.reactivex.observables.GroupedObservable<K, V>> groupBy(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K, V> io.reactivex.Observable<io.reactivex.observables.GroupedObservable<K, V>> groupBy(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, boolean z) {
        return groupBy(function, function2, z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K, V> io.reactivex.Observable<io.reactivex.observables.GroupedObservable<K, V>> groupBy(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "valueSelector is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableGroupBy(this, function, function2, i, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Observable<io.reactivex.observables.GroupedObservable<K, T>> groupBy(io.reactivex.functions.Function<? super T, ? extends K> function, boolean z) {
        return (io.reactivex.Observable<io.reactivex.observables.GroupedObservable<K, T>>) groupBy(function, io.reactivex.internal.functions.Functions.identity(), z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> io.reactivex.Observable<R> groupJoin(io.reactivex.ObservableSource<? extends TRight> observableSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<TLeftEnd>> function, io.reactivex.functions.Function<? super TRight, ? extends io.reactivex.ObservableSource<TRightEnd>> function2, io.reactivex.functions.BiFunction<? super T, ? super io.reactivex.Observable<TRight>, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "leftEnd is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "rightEnd is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableGroupJoin(this, observableSource, function, function2, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> hide() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableHide(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable ignoreElements() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.lang.Boolean> isEmpty() {
        return all(io.reactivex.internal.functions.Functions.alwaysFalse());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> io.reactivex.Observable<R> join(io.reactivex.ObservableSource<? extends TRight> observableSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<TLeftEnd>> function, io.reactivex.functions.Function<? super TRight, ? extends io.reactivex.ObservableSource<TRightEnd>> function2, io.reactivex.functions.BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "leftEnd is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "rightEnd is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableJoin(this, observableSource, function, function2, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> last(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultItem is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableLastSingle(this, t));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> lastElement() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableLastMaybe(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> lastOrError() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableLastSingle(this, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> lift(io.reactivex.ObservableOperator<? extends R, ? super T> observableOperator) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableOperator, "lifter is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableLift(this, observableOperator));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> map(io.reactivex.functions.Function<? super T, ? extends R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableMap(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Notification<T>> materialize() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableMaterialize(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> mergeWith(@io.reactivex.annotations.NonNull io.reactivex.CompletableSource completableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(completableSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableMergeWithCompletable(this, completableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> mergeWith(@io.reactivex.annotations.NonNull io.reactivex.MaybeSource<? extends T> maybeSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(maybeSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableMergeWithMaybe(this, maybeSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> mergeWith(io.reactivex.ObservableSource<? extends T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return merge(this, observableSource);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> mergeWith(@io.reactivex.annotations.NonNull io.reactivex.SingleSource<? extends T> singleSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(singleSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableMergeWithSingle(this, singleSource));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> observeOn(io.reactivex.Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> observeOn(io.reactivex.Scheduler scheduler, boolean z) {
        return observeOn(scheduler, z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> observeOn(io.reactivex.Scheduler scheduler, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableObserveOn(this, scheduler, z, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Observable<U> ofType(java.lang.Class<U> cls) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(cls, "clazz is null");
        return filter(io.reactivex.internal.functions.Functions.isInstanceOf(cls)).cast(cls);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> onErrorResumeNext(io.reactivex.ObservableSource<? extends T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "next is null");
        return onErrorResumeNext(io.reactivex.internal.functions.Functions.justFunction(observableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> onErrorResumeNext(io.reactivex.functions.Function<? super java.lang.Throwable, ? extends io.reactivex.ObservableSource<? extends T>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableOnErrorNext(this, function, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> onErrorReturn(io.reactivex.functions.Function<? super java.lang.Throwable, ? extends T> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "valueSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableOnErrorReturn(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> onErrorReturnItem(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item is null");
        return onErrorReturn(io.reactivex.internal.functions.Functions.justFunction(t));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> onExceptionResumeNext(io.reactivex.ObservableSource<? extends T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "next is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableOnErrorNext(this, io.reactivex.internal.functions.Functions.justFunction(observableSource), true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> onTerminateDetach() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableDetach(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> publish(io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservablePublishSelector(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observables.ConnectableObservable<T> publish() {
        return io.reactivex.internal.operators.observable.ObservablePublish.create(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> reduce(io.reactivex.functions.BiFunction<T, T, T> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableReduceMaybe(this, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Single<R> reduce(R r, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(r, "seed is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableReduceSeedSingle(this, r, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Single<R> reduceWith(java.util.concurrent.Callable<R> callable, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "seedSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableReduceWithSingle(this, callable, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> repeat(long j) {
        if (j >= 0) {
            return j == 0 ? empty() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableRepeat(this, j));
        }
        throw new java.lang.IllegalArgumentException("times >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> repeatUntil(io.reactivex.functions.BooleanSupplier booleanSupplier) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableRepeatUntil(this, booleanSupplier));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> repeatWhen(io.reactivex.functions.Function<? super io.reactivex.Observable<java.lang.Object>, ? extends io.reactivex.ObservableSource<?>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "handler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableRepeatWhen(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        return io.reactivex.internal.operators.observable.ObservableReplay.multicastSelector(io.reactivex.internal.operators.observable.ObservableInternalHelper.replayCallable(this), function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.internal.operators.observable.ObservableReplay.multicastSelector(io.reactivex.internal.operators.observable.ObservableInternalHelper.replayCallable(this, i), function);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> function, int i, long j, java.util.concurrent.TimeUnit timeUnit) {
        return replay(function, i, j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> function, int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.internal.operators.observable.ObservableReplay.multicastSelector(io.reactivex.internal.operators.observable.ObservableInternalHelper.replayCallable(this, i, j, timeUnit, scheduler), function);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> function, int i, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.internal.operators.observable.ObservableReplay.multicastSelector(io.reactivex.internal.operators.observable.ObservableInternalHelper.replayCallable(this, i), io.reactivex.internal.operators.observable.ObservableInternalHelper.replayFunction(function, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> function, long j, java.util.concurrent.TimeUnit timeUnit) {
        return replay(function, j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> function, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.internal.operators.observable.ObservableReplay.multicastSelector(io.reactivex.internal.operators.observable.ObservableInternalHelper.replayCallable(this, j, timeUnit, scheduler), function);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> replay(io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> function, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "selector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.internal.operators.observable.ObservableReplay.multicastSelector(io.reactivex.internal.operators.observable.ObservableInternalHelper.replayCallable(this), io.reactivex.internal.operators.observable.ObservableInternalHelper.replayFunction(function, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observables.ConnectableObservable<T> replay() {
        return io.reactivex.internal.operators.observable.ObservableReplay.createFrom(this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observables.ConnectableObservable<T> replay(int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.internal.operators.observable.ObservableReplay.create(this, i);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observables.ConnectableObservable<T> replay(int i, long j, java.util.concurrent.TimeUnit timeUnit) {
        return replay(i, j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observables.ConnectableObservable<T> replay(int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.internal.operators.observable.ObservableReplay.create(this, j, timeUnit, scheduler, i);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observables.ConnectableObservable<T> replay(int i, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.internal.operators.observable.ObservableReplay.observeOn(replay(i), scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observables.ConnectableObservable<T> replay(long j, java.util.concurrent.TimeUnit timeUnit) {
        return replay(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observables.ConnectableObservable<T> replay(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.internal.operators.observable.ObservableReplay.create(this, j, timeUnit, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.observables.ConnectableObservable<T> replay(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.internal.operators.observable.ObservableReplay.observeOn(replay(), scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> retry() {
        return retry(Long.MAX_VALUE, io.reactivex.internal.functions.Functions.alwaysTrue());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> retry(long j) {
        return retry(j, io.reactivex.internal.functions.Functions.alwaysTrue());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> retry(long j, io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        if (j >= 0) {
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableRetryPredicate(this, j, predicate));
        }
        throw new java.lang.IllegalArgumentException("times >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> retry(io.reactivex.functions.BiPredicate<? super java.lang.Integer, ? super java.lang.Throwable> biPredicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biPredicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableRetryBiPredicate(this, biPredicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> retry(io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> retryUntil(io.reactivex.functions.BooleanSupplier booleanSupplier) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return retry(Long.MAX_VALUE, io.reactivex.internal.functions.Functions.predicateReverseFor(booleanSupplier));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> retryWhen(io.reactivex.functions.Function<? super io.reactivex.Observable<java.lang.Throwable>, ? extends io.reactivex.ObservableSource<?>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "handler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableRetryWhen(this, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    public final void safeSubscribe(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observer, "observer is null");
        if (observer instanceof io.reactivex.observers.SafeObserver) {
            subscribe(observer);
        } else {
            subscribe(new io.reactivex.observers.SafeObserver(observer));
        }
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> sample(long j, java.util.concurrent.TimeUnit timeUnit) {
        return sample(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> sample(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSampleTimed(this, j, timeUnit, scheduler, false));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> sample(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSampleTimed(this, j, timeUnit, scheduler, z));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> sample(long j, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        return sample(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), z);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Observable<T> sample(io.reactivex.ObservableSource<U> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "sampler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSampleWithObservable(this, observableSource, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Observable<T> sample(io.reactivex.ObservableSource<U> observableSource, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "sampler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSampleWithObservable(this, observableSource, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> scan(io.reactivex.functions.BiFunction<T, T, T> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "accumulator is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableScan(this, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> scan(R r, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(r, "initialValue is null");
        return scanWith(io.reactivex.internal.functions.Functions.justCallable(r), biFunction);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> scanWith(java.util.concurrent.Callable<R> callable, io.reactivex.functions.BiFunction<R, ? super T, R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "seedSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "accumulator is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableScanSeed(this, callable, biFunction));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> serialize() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSerialized(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> share() {
        return publish().refCount();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> single(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultItem is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSingleSingle(this, t));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Maybe<T> singleElement() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSingleMaybe(this));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<T> singleOrError() {
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSingleSingle(this, null));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> skip(long j) {
        return j <= 0 ? io.reactivex.plugins.RxJavaPlugins.onAssembly(this) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSkip(this, j));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> skip(long j, java.util.concurrent.TimeUnit timeUnit) {
        return skipUntil(timer(j, timeUnit));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> skip(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return skipUntil(timer(j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> skipLast(int i) {
        if (i >= 0) {
            return i == 0 ? io.reactivex.plugins.RxJavaPlugins.onAssembly(this) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSkipLast(this, i));
        }
        throw new java.lang.IndexOutOfBoundsException("count >= 0 required but it was " + i);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.TRAMPOLINE)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> skipLast(long j, java.util.concurrent.TimeUnit timeUnit) {
        return skipLast(j, timeUnit, io.reactivex.schedulers.Schedulers.trampoline(), false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> skipLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return skipLast(j, timeUnit, scheduler, false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> skipLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        return skipLast(j, timeUnit, scheduler, z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> skipLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSkipLastTimed(this, j, timeUnit, scheduler, i << 1, z));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.TRAMPOLINE)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> skipLast(long j, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        return skipLast(j, timeUnit, io.reactivex.schedulers.Schedulers.trampoline(), z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Observable<T> skipUntil(io.reactivex.ObservableSource<U> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSkipUntil(this, observableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> skipWhile(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSkipWhile(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> sorted() {
        return toList().toObservable().map(io.reactivex.internal.functions.Functions.listSorter(io.reactivex.internal.functions.Functions.naturalComparator())).flatMapIterable(io.reactivex.internal.functions.Functions.identity());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> sorted(java.util.Comparator<? super T> comparator) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(comparator, "sortFunction is null");
        return toList().toObservable().map(io.reactivex.internal.functions.Functions.listSorter(comparator)).flatMapIterable(io.reactivex.internal.functions.Functions.identity());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> startWith(io.reactivex.ObservableSource<? extends T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return concatArray(observableSource, this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> startWith(java.lang.Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> startWith(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "item is null");
        return concatArray(just(t), this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> startWithArray(T... tArr) {
        io.reactivex.Observable fromArray = fromArray(tArr);
        return fromArray == empty() ? io.reactivex.plugins.RxJavaPlugins.onAssembly(this) : concatArray(fromArray, this);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    public final io.reactivex.disposables.Disposable subscribe() {
        return subscribe(io.reactivex.internal.functions.Functions.emptyConsumer(), io.reactivex.internal.functions.Functions.ON_ERROR_MISSING, io.reactivex.internal.functions.Functions.EMPTY_ACTION, io.reactivex.internal.functions.Functions.emptyConsumer());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer) {
        return subscribe(consumer, io.reactivex.internal.functions.Functions.ON_ERROR_MISSING, io.reactivex.internal.functions.Functions.EMPTY_ACTION, io.reactivex.internal.functions.Functions.emptyConsumer());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2) {
        return subscribe(consumer, consumer2, io.reactivex.internal.functions.Functions.EMPTY_ACTION, io.reactivex.internal.functions.Functions.emptyConsumer());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action) {
        return subscribe(consumer, consumer2, action, io.reactivex.internal.functions.Functions.emptyConsumer());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.disposables.Disposable subscribe(io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action, io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer, "onNext is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer2, "onError is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(action, "onComplete is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(consumer3, "onSubscribe is null");
        io.reactivex.internal.observers.LambdaObserver lambdaObserver = new io.reactivex.internal.observers.LambdaObserver(consumer, consumer2, action, consumer3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    @Override // io.reactivex.ObservableSource
    @io.reactivex.annotations.SchedulerSupport("none")
    public final void subscribe(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observer, "observer is null");
        try {
            io.reactivex.Observer<? super T> onSubscribe = io.reactivex.plugins.RxJavaPlugins.onSubscribe(this, observer);
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
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

    public abstract void subscribeActual(io.reactivex.Observer<? super T> observer);

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> subscribeOn(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSubscribeOn(this, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <E extends io.reactivex.Observer<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> switchIfEmpty(io.reactivex.ObservableSource<? extends T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty(this, observableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> switchMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> switchMap(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        if (!(this instanceof io.reactivex.internal.fuseable.ScalarCallable)) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSwitchMap(this, function, i, false));
        }
        java.lang.Object call = ((io.reactivex.internal.fuseable.ScalarCallable) this).call();
        return call == null ? empty() : io.reactivex.internal.operators.observable.ObservableScalarXMap.scalarXMap(call, function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable switchMapCompletable(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable(this, function, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Completable switchMapCompletableDelayError(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable(this, function, true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> switchMapDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> switchMapDelayError(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        if (!(this instanceof io.reactivex.internal.fuseable.ScalarCallable)) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableSwitchMap(this, function, i, true));
        }
        java.lang.Object call = ((io.reactivex.internal.fuseable.ScalarCallable) this).call();
        return call == null ? empty() : io.reactivex.internal.operators.observable.ObservableScalarXMap.scalarXMap(call, function);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> switchMapMaybe(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe(this, function, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> switchMapMaybeDelayError(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe(this, function, true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Observable<R> switchMapSingle(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle(this, function, false));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public final <R> io.reactivex.Observable<R> switchMapSingleDelayError(@io.reactivex.annotations.NonNull io.reactivex.functions.Function<? super T, ? extends io.reactivex.SingleSource<? extends R>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "mapper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle(this, function, true));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> take(long j) {
        if (j >= 0) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableTake(this, j));
        }
        throw new java.lang.IllegalArgumentException("count >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> take(long j, java.util.concurrent.TimeUnit timeUnit) {
        return takeUntil(timer(j, timeUnit));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> take(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return takeUntil(timer(j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> takeLast(int i) {
        if (i >= 0) {
            return i == 0 ? io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableIgnoreElements(this)) : i == 1 ? io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableTakeLastOne(this)) : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableTakeLast(this, i));
        }
        throw new java.lang.IndexOutOfBoundsException("count >= 0 required but it was " + i);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.TRAMPOLINE)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> takeLast(long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        return takeLast(j, j2, timeUnit, io.reactivex.schedulers.Schedulers.trampoline(), false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> takeLast(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return takeLast(j, j2, timeUnit, scheduler, false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> takeLast(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        if (j >= 0) {
            return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableTakeLastTimed(this, j, j2, timeUnit, scheduler, i, z));
        }
        throw new java.lang.IndexOutOfBoundsException("count >= 0 required but it was " + j);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.TRAMPOLINE)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> takeLast(long j, java.util.concurrent.TimeUnit timeUnit) {
        return takeLast(j, timeUnit, io.reactivex.schedulers.Schedulers.trampoline(), false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> takeLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return takeLast(j, timeUnit, scheduler, false, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> takeLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        return takeLast(j, timeUnit, scheduler, z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> takeLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z, int i) {
        return takeLast(Long.MAX_VALUE, j, timeUnit, scheduler, z, i);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.TRAMPOLINE)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> takeLast(long j, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        return takeLast(j, timeUnit, io.reactivex.schedulers.Schedulers.trampoline(), z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U> io.reactivex.Observable<T> takeUntil(io.reactivex.ObservableSource<U> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableTakeUntil(this, observableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> takeUntil(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "stopPredicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate(this, predicate));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> takeWhile(io.reactivex.functions.Predicate<? super T> predicate) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(predicate, "predicate is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableTakeWhile(this, predicate));
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
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> throttleFirst(long j, java.util.concurrent.TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> throttleFirst(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed(this, j, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> throttleLast(long j, java.util.concurrent.TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> throttleLast(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return sample(j, timeUnit, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> throttleLatest(long j, java.util.concurrent.TimeUnit timeUnit) {
        return throttleLatest(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> throttleLatest(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return throttleLatest(j, timeUnit, scheduler, false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> throttleLatest(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableThrottleLatest(this, j, timeUnit, scheduler, z));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> throttleLatest(long j, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        return throttleLatest(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), z);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> throttleWithTimeout(long j, java.util.concurrent.TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> throttleWithTimeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return debounce(j, timeUnit, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.schedulers.Timed<T>> timeInterval() {
        return timeInterval(java.util.concurrent.TimeUnit.MILLISECONDS, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.schedulers.Timed<T>> timeInterval(io.reactivex.Scheduler scheduler) {
        return timeInterval(java.util.concurrent.TimeUnit.MILLISECONDS, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.schedulers.Timed<T>> timeInterval(java.util.concurrent.TimeUnit timeUnit) {
        return timeInterval(timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.schedulers.Timed<T>> timeInterval(java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableTimeInterval(this, timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit) {
        return b(j, timeUnit, null, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.ObservableSource<? extends T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return b(j, timeUnit, observableSource, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return b(j, timeUnit, null, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> timeout(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, io.reactivex.ObservableSource<? extends T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return b(j, timeUnit, observableSource, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, V> io.reactivex.Observable<T> timeout(io.reactivex.ObservableSource<U> observableSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "firstTimeoutIndicator is null");
        return c(observableSource, function, null);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, V> io.reactivex.Observable<T> timeout(io.reactivex.ObservableSource<U> observableSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>> function, io.reactivex.ObservableSource<? extends T> observableSource2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "firstTimeoutIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "other is null");
        return c(observableSource, function, observableSource2);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <V> io.reactivex.Observable<T> timeout(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>> function) {
        return c(null, function, null);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <V> io.reactivex.Observable<T> timeout(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>> function, io.reactivex.ObservableSource<? extends T> observableSource) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return c(null, function, observableSource);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.schedulers.Timed<T>> timestamp() {
        return timestamp(java.util.concurrent.TimeUnit.MILLISECONDS, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.schedulers.Timed<T>> timestamp(io.reactivex.Scheduler scheduler) {
        return timestamp(java.util.concurrent.TimeUnit.MILLISECONDS, scheduler);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.schedulers.Timed<T>> timestamp(java.util.concurrent.TimeUnit timeUnit) {
        return timestamp(timeUnit, io.reactivex.schedulers.Schedulers.computation());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.schedulers.Timed<T>> timestamp(java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return (io.reactivex.Observable<io.reactivex.schedulers.Timed<T>>) map(io.reactivex.internal.functions.Functions.timestampWith(timeUnit, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> R to(io.reactivex.functions.Function<? super io.reactivex.Observable<T>, R> function) {
        try {
            return (R) ((io.reactivex.functions.Function) io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.SPECIAL)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Flowable<T> toFlowable(io.reactivex.BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.operators.flowable.FlowableFromObservable flowableFromObservable = new io.reactivex.internal.operators.flowable.FlowableFromObservable(this);
        int i = io.reactivex.Observable.AnonymousClass1.a[backpressureStrategy.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? flowableFromObservable.onBackpressureBuffer() : io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.flowable.FlowableOnBackpressureError(flowableFromObservable)) : flowableFromObservable : flowableFromObservable.onBackpressureLatest() : flowableFromObservable.onBackpressureDrop();
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final java.util.concurrent.Future<T> toFuture() {
        return (java.util.concurrent.Future) subscribeWith(new io.reactivex.internal.observers.FutureObserver());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.util.List<T>> toList() {
        return toList(16);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.util.List<T>> toList(int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "capacityHint");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableToListSingle(this, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U extends java.util.Collection<? super T>> io.reactivex.Single<U> toList(java.util.concurrent.Callable<U> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableToListSingle(this, callable));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Single<java.util.Map<K, T>> toMap(io.reactivex.functions.Function<? super T, ? extends K> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        return (io.reactivex.Single<java.util.Map<K, T>>) collect(io.reactivex.internal.util.HashMapSupplier.asCallable(), io.reactivex.internal.functions.Functions.toMapKeySelector(function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K, V> io.reactivex.Single<java.util.Map<K, V>> toMap(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "valueSelector is null");
        return (io.reactivex.Single<java.util.Map<K, V>>) collect(io.reactivex.internal.util.HashMapSupplier.asCallable(), io.reactivex.internal.functions.Functions.toMapKeyValueSelector(function, function2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K, V> io.reactivex.Single<java.util.Map<K, V>> toMap(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, java.util.concurrent.Callable<? extends java.util.Map<K, V>> callable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "valueSelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "mapSupplier is null");
        return (io.reactivex.Single<java.util.Map<K, V>>) collect(callable, io.reactivex.internal.functions.Functions.toMapKeyValueSelector(function, function2));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K> io.reactivex.Single<java.util.Map<K, java.util.Collection<T>>> toMultimap(io.reactivex.functions.Function<? super T, ? extends K> function) {
        return (io.reactivex.Single<java.util.Map<K, java.util.Collection<T>>>) toMultimap(function, io.reactivex.internal.functions.Functions.identity(), io.reactivex.internal.util.HashMapSupplier.asCallable(), io.reactivex.internal.util.ArrayListSupplier.asFunction());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K, V> io.reactivex.Single<java.util.Map<K, java.util.Collection<V>>> toMultimap(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2) {
        return toMultimap(function, function2, io.reactivex.internal.util.HashMapSupplier.asCallable(), io.reactivex.internal.util.ArrayListSupplier.asFunction());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K, V> io.reactivex.Single<java.util.Map<K, java.util.Collection<V>>> toMultimap(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, java.util.concurrent.Callable<java.util.Map<K, java.util.Collection<V>>> callable) {
        return toMultimap(function, function2, callable, io.reactivex.internal.util.ArrayListSupplier.asFunction());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <K, V> io.reactivex.Single<java.util.Map<K, java.util.Collection<V>>> toMultimap(io.reactivex.functions.Function<? super T, ? extends K> function, io.reactivex.functions.Function<? super T, ? extends V> function2, java.util.concurrent.Callable<? extends java.util.Map<K, java.util.Collection<V>>> callable, io.reactivex.functions.Function<? super K, ? extends java.util.Collection<? super V>> function3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "keySelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function2, "valueSelector is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "mapSupplier is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function3, "collectionFactory is null");
        return (io.reactivex.Single<java.util.Map<K, java.util.Collection<V>>>) collect(callable, io.reactivex.internal.functions.Functions.toMultimapKeyValueSelector(function, function2, function3));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.util.List<T>> toSortedList() {
        return toSortedList(io.reactivex.internal.functions.Functions.naturalOrder());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.util.List<T>> toSortedList(int i) {
        return toSortedList(io.reactivex.internal.functions.Functions.naturalOrder(), i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.util.List<T>> toSortedList(java.util.Comparator<? super T> comparator) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(comparator, "comparator is null");
        return (io.reactivex.Single<java.util.List<T>>) toList().map(io.reactivex.internal.functions.Functions.listSorter(comparator));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Single<java.util.List<T>> toSortedList(java.util.Comparator<? super T> comparator, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(comparator, "comparator is null");
        return (io.reactivex.Single<java.util.List<T>>) toList(i).map(io.reactivex.internal.functions.Functions.listSorter(comparator));
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<T> unsubscribeOn(io.reactivex.Scheduler scheduler) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableUnsubscribeOn(this, scheduler));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j) {
        return window(j, j, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j, long j2) {
        return window(j, j2, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j, long j2, int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(j, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(j2, org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP);
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableWindow(this, j, j2, i));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        return window(j, j2, timeUnit, io.reactivex.schedulers.Schedulers.computation(), bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return window(j, j2, timeUnit, scheduler, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j, long j2, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(j, "timespan");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(j2, "timeskip");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableWindowTimed(this, j, j2, timeUnit, scheduler, Long.MAX_VALUE, i, false));
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit) {
        return window(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), Long.MAX_VALUE, false);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit, long j2) {
        return window(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), j2, false);
    }

    @io.reactivex.annotations.SchedulerSupport(io.reactivex.annotations.SchedulerSupport.COMPUTATION)
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit, long j2, boolean z) {
        return window(j, timeUnit, io.reactivex.schedulers.Schedulers.computation(), j2, z);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return window(j, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, long j2) {
        return window(j, timeUnit, scheduler, j2, false);
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, long j2, boolean z) {
        return window(j, timeUnit, scheduler, j2, z, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("custom")
    @io.reactivex.annotations.CheckReturnValue
    public final io.reactivex.Observable<io.reactivex.Observable<T>> window(long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, long j2, boolean z, int i) {
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(j2, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableWindowTimed(this, j, j, timeUnit, scheduler, j2, i, z));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <B> io.reactivex.Observable<io.reactivex.Observable<T>> window(io.reactivex.ObservableSource<B> observableSource) {
        return window(observableSource, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <B> io.reactivex.Observable<io.reactivex.Observable<T>> window(io.reactivex.ObservableSource<B> observableSource, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "boundary is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableWindowBoundary(this, observableSource, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, V> io.reactivex.Observable<io.reactivex.Observable<T>> window(io.reactivex.ObservableSource<U> observableSource, io.reactivex.functions.Function<? super U, ? extends io.reactivex.ObservableSource<V>> function) {
        return window(observableSource, function, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, V> io.reactivex.Observable<io.reactivex.Observable<T>> window(io.reactivex.ObservableSource<U> observableSource, io.reactivex.functions.Function<? super U, ? extends io.reactivex.ObservableSource<V>> function, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "openingIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "closingIndicator is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector(this, observableSource, function, i));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <B> io.reactivex.Observable<io.reactivex.Observable<T>> window(java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<B>> callable) {
        return window(callable, bufferSize());
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <B> io.reactivex.Observable<io.reactivex.Observable<T>> window(java.util.concurrent.Callable<? extends io.reactivex.ObservableSource<B>> callable, int i) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(callable, "boundary is null");
        io.reactivex.internal.functions.ObjectHelper.verifyPositive(i, "bufferSize");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier(this, callable, i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <T1, T2, T3, T4, R> io.reactivex.Observable<R> withLatestFrom(io.reactivex.ObservableSource<T1> observableSource, io.reactivex.ObservableSource<T2> observableSource2, io.reactivex.ObservableSource<T3> observableSource3, io.reactivex.ObservableSource<T4> observableSource4, io.reactivex.functions.Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "o1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "o2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "o3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource4, "o4 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function5, "combiner is null");
        return withLatestFrom((io.reactivex.ObservableSource<?>[]) new io.reactivex.ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, io.reactivex.internal.functions.Functions.toFunction(function5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <T1, T2, T3, R> io.reactivex.Observable<R> withLatestFrom(io.reactivex.ObservableSource<T1> observableSource, io.reactivex.ObservableSource<T2> observableSource2, io.reactivex.ObservableSource<T3> observableSource3, io.reactivex.functions.Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "o1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "o2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource3, "o3 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function4, "combiner is null");
        return withLatestFrom((io.reactivex.ObservableSource<?>[]) new io.reactivex.ObservableSource[]{observableSource, observableSource2, observableSource3}, io.reactivex.internal.functions.Functions.toFunction(function4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <T1, T2, R> io.reactivex.Observable<R> withLatestFrom(io.reactivex.ObservableSource<T1> observableSource, io.reactivex.ObservableSource<T2> observableSource2, io.reactivex.functions.Function3<? super T, ? super T1, ? super T2, R> function3) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "o1 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource2, "o2 is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function3, "combiner is null");
        return withLatestFrom((io.reactivex.ObservableSource<?>[]) new io.reactivex.ObservableSource[]{observableSource, observableSource2}, io.reactivex.internal.functions.Functions.toFunction(function3));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Observable<R> withLatestFrom(io.reactivex.ObservableSource<? extends U> observableSource, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "combiner is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableWithLatestFrom(this, biFunction, observableSource));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> withLatestFrom(java.lang.Iterable<? extends io.reactivex.ObservableSource<?>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "others is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "combiner is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableWithLatestFromMany(this, iterable, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <R> io.reactivex.Observable<R> withLatestFrom(io.reactivex.ObservableSource<?>[] observableSourceArr, io.reactivex.functions.Function<? super java.lang.Object[], R> function) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSourceArr, "others is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(function, "combiner is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableWithLatestFromMany(this, observableSourceArr, function));
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Observable<R> zipWith(io.reactivex.ObservableSource<? extends U> observableSource, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(observableSource, "other is null");
        return zip(this, observableSource, biFunction);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Observable<R> zipWith(io.reactivex.ObservableSource<? extends U> observableSource, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return zip(this, observableSource, biFunction, z);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Observable<R> zipWith(io.reactivex.ObservableSource<? extends U> observableSource, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return zip(this, observableSource, biFunction, z, i);
    }

    @io.reactivex.annotations.SchedulerSupport("none")
    @io.reactivex.annotations.CheckReturnValue
    public final <U, R> io.reactivex.Observable<R> zipWith(java.lang.Iterable<U> iterable, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(iterable, "other is null");
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(biFunction, "zipper is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.observable.ObservableZipIterable(this, iterable, biFunction));
    }
}
