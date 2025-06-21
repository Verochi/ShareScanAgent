package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableInternalHelper {

    public static final class BufferedReplayCallable<T> implements java.util.concurrent.Callable<io.reactivex.observables.ConnectableObservable<T>> {
        public final io.reactivex.Observable<T> n;
        public final int t;

        public BufferedReplayCallable(io.reactivex.Observable<T> observable, int i) {
            this.n = observable;
            this.t = i;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.observables.ConnectableObservable<T> call() {
            return this.n.replay(this.t);
        }
    }

    public static final class BufferedTimedReplayCallable<T> implements java.util.concurrent.Callable<io.reactivex.observables.ConnectableObservable<T>> {
        public final io.reactivex.Observable<T> n;
        public final int t;
        public final long u;
        public final java.util.concurrent.TimeUnit v;
        public final io.reactivex.Scheduler w;

        public BufferedTimedReplayCallable(io.reactivex.Observable<T> observable, int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.n = observable;
            this.t = i;
            this.u = j;
            this.v = timeUnit;
            this.w = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.observables.ConnectableObservable<T> call() {
            return this.n.replay(this.t, this.u, this.v, this.w);
        }
    }

    public static final class FlatMapIntoIterable<T, U> implements io.reactivex.functions.Function<T, io.reactivex.ObservableSource<U>> {
        public final io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> n;

        public FlatMapIntoIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function) {
            this.n = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.ObservableSource<U> apply(T t) throws java.lang.Exception {
            return new io.reactivex.internal.operators.observable.ObservableFromIterable((java.lang.Iterable) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(t), "The mapper returned a null Iterable"));
        }
    }

    public static final class FlatMapWithCombinerInner<U, R, T> implements io.reactivex.functions.Function<U, R> {
        public final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> n;
        public final T t;

        public FlatMapWithCombinerInner(io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
            this.n = biFunction;
            this.t = t;
        }

        @Override // io.reactivex.functions.Function
        public R apply(U u) throws java.lang.Exception {
            return this.n.apply(this.t, u);
        }
    }

    public static final class FlatMapWithCombinerOuter<T, R, U> implements io.reactivex.functions.Function<T, io.reactivex.ObservableSource<R>> {
        public final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> n;
        public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> t;

        public FlatMapWithCombinerOuter(io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> function) {
            this.n = biFunction;
            this.t = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.ObservableSource<R> apply(T t) throws java.lang.Exception {
            return new io.reactivex.internal.operators.observable.ObservableMap((io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t), "The mapper returned a null ObservableSource"), new io.reactivex.internal.operators.observable.ObservableInternalHelper.FlatMapWithCombinerInner(this.n, t));
        }
    }

    public static final class ItemDelayFunction<T, U> implements io.reactivex.functions.Function<T, io.reactivex.ObservableSource<T>> {
        public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<U>> n;

        public ItemDelayFunction(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<U>> function) {
            this.n = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.ObservableSource<T> apply(T t) throws java.lang.Exception {
            return new io.reactivex.internal.operators.observable.ObservableTake((io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(t), "The itemDelay returned a null ObservableSource"), 1L).map(io.reactivex.internal.functions.Functions.justFunction(t)).defaultIfEmpty(t);
        }
    }

    public enum MapToInt implements io.reactivex.functions.Function<java.lang.Object, java.lang.Object> {
        INSTANCE;

        @Override // io.reactivex.functions.Function
        public java.lang.Object apply(java.lang.Object obj) throws java.lang.Exception {
            return 0;
        }
    }

    public static final class ObserverOnComplete<T> implements io.reactivex.functions.Action {
        public final io.reactivex.Observer<T> n;

        public ObserverOnComplete(io.reactivex.Observer<T> observer) {
            this.n = observer;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws java.lang.Exception {
            this.n.onComplete();
        }
    }

    public static final class ObserverOnError<T> implements io.reactivex.functions.Consumer<java.lang.Throwable> {
        public final io.reactivex.Observer<T> n;

        public ObserverOnError(io.reactivex.Observer<T> observer) {
            this.n = observer;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(java.lang.Throwable th) throws java.lang.Exception {
            this.n.onError(th);
        }
    }

    public static final class ObserverOnNext<T> implements io.reactivex.functions.Consumer<T> {
        public final io.reactivex.Observer<T> n;

        public ObserverOnNext(io.reactivex.Observer<T> observer) {
            this.n = observer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws java.lang.Exception {
            this.n.onNext(t);
        }
    }

    public static final class ReplayCallable<T> implements java.util.concurrent.Callable<io.reactivex.observables.ConnectableObservable<T>> {
        public final io.reactivex.Observable<T> n;

        public ReplayCallable(io.reactivex.Observable<T> observable) {
            this.n = observable;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.observables.ConnectableObservable<T> call() {
            return this.n.replay();
        }
    }

    public static final class ReplayFunction<T, R> implements io.reactivex.functions.Function<io.reactivex.Observable<T>, io.reactivex.ObservableSource<R>> {
        public final io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> n;
        public final io.reactivex.Scheduler t;

        public ReplayFunction(io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> function, io.reactivex.Scheduler scheduler) {
            this.n = function;
            this.t = scheduler;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.ObservableSource<R> apply(io.reactivex.Observable<T> observable) throws java.lang.Exception {
            return io.reactivex.Observable.wrap((io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(observable), "The selector returned a null ObservableSource")).observeOn(this.t);
        }
    }

    public static final class SimpleBiGenerator<T, S> implements io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> {
        public final io.reactivex.functions.BiConsumer<S, io.reactivex.Emitter<T>> n;

        public SimpleBiGenerator(io.reactivex.functions.BiConsumer<S, io.reactivex.Emitter<T>> biConsumer) {
            this.n = biConsumer;
        }

        @Override // io.reactivex.functions.BiFunction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s2, io.reactivex.Emitter<T> emitter) throws java.lang.Exception {
            this.n.accept(s2, emitter);
            return s2;
        }
    }

    public static final class SimpleGenerator<T, S> implements io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> {
        public final io.reactivex.functions.Consumer<io.reactivex.Emitter<T>> n;

        public SimpleGenerator(io.reactivex.functions.Consumer<io.reactivex.Emitter<T>> consumer) {
            this.n = consumer;
        }

        @Override // io.reactivex.functions.BiFunction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s2, io.reactivex.Emitter<T> emitter) throws java.lang.Exception {
            this.n.accept(emitter);
            return s2;
        }
    }

    public static final class TimedReplayCallable<T> implements java.util.concurrent.Callable<io.reactivex.observables.ConnectableObservable<T>> {
        public final io.reactivex.Observable<T> n;
        public final long t;
        public final java.util.concurrent.TimeUnit u;
        public final io.reactivex.Scheduler v;

        public TimedReplayCallable(io.reactivex.Observable<T> observable, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.n = observable;
            this.t = j;
            this.u = timeUnit;
            this.v = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.observables.ConnectableObservable<T> call() {
            return this.n.replay(this.t, this.u, this.v);
        }
    }

    public static final class ZipIterableFunction<T, R> implements io.reactivex.functions.Function<java.util.List<io.reactivex.ObservableSource<? extends T>>, io.reactivex.ObservableSource<? extends R>> {
        public final io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> n;

        public ZipIterableFunction(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
            this.n = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.ObservableSource<? extends R> apply(java.util.List<io.reactivex.ObservableSource<? extends T>> list) {
            return io.reactivex.Observable.zipIterable(list, this.n, false, io.reactivex.Observable.bufferSize());
        }
    }

    public ObservableInternalHelper() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static <T, U> io.reactivex.functions.Function<T, io.reactivex.ObservableSource<U>> flatMapIntoIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.FlatMapIntoIterable(function);
    }

    public static <T, U, R> io.reactivex.functions.Function<T, io.reactivex.ObservableSource<R>> flatMapWithCombiner(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> io.reactivex.functions.Function<T, io.reactivex.ObservableSource<T>> itemDelay(io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<U>> function) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.ItemDelayFunction(function);
    }

    public static <T> io.reactivex.functions.Action observerOnComplete(io.reactivex.Observer<T> observer) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.ObserverOnComplete(observer);
    }

    public static <T> io.reactivex.functions.Consumer<java.lang.Throwable> observerOnError(io.reactivex.Observer<T> observer) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.ObserverOnError(observer);
    }

    public static <T> io.reactivex.functions.Consumer<T> observerOnNext(io.reactivex.Observer<T> observer) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.ObserverOnNext(observer);
    }

    public static <T> java.util.concurrent.Callable<io.reactivex.observables.ConnectableObservable<T>> replayCallable(io.reactivex.Observable<T> observable) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.ReplayCallable(observable);
    }

    public static <T> java.util.concurrent.Callable<io.reactivex.observables.ConnectableObservable<T>> replayCallable(io.reactivex.Observable<T> observable, int i) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.BufferedReplayCallable(observable, i);
    }

    public static <T> java.util.concurrent.Callable<io.reactivex.observables.ConnectableObservable<T>> replayCallable(io.reactivex.Observable<T> observable, int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.BufferedTimedReplayCallable(observable, i, j, timeUnit, scheduler);
    }

    public static <T> java.util.concurrent.Callable<io.reactivex.observables.ConnectableObservable<T>> replayCallable(io.reactivex.Observable<T> observable, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.TimedReplayCallable(observable, j, timeUnit, scheduler);
    }

    public static <T, R> io.reactivex.functions.Function<io.reactivex.Observable<T>, io.reactivex.ObservableSource<R>> replayFunction(io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> function, io.reactivex.Scheduler scheduler) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.ReplayFunction(function, scheduler);
    }

    public static <T, S> io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> simpleBiGenerator(io.reactivex.functions.BiConsumer<S, io.reactivex.Emitter<T>> biConsumer) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.SimpleBiGenerator(biConsumer);
    }

    public static <T, S> io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> simpleGenerator(io.reactivex.functions.Consumer<io.reactivex.Emitter<T>> consumer) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.SimpleGenerator(consumer);
    }

    public static <T, R> io.reactivex.functions.Function<java.util.List<io.reactivex.ObservableSource<? extends T>>, io.reactivex.ObservableSource<? extends R>> zipIterable(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        return new io.reactivex.internal.operators.observable.ObservableInternalHelper.ZipIterableFunction(function);
    }
}
