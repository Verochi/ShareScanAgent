package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableInternalHelper {

    public static final class BufferedReplayCallable<T> implements java.util.concurrent.Callable<io.reactivex.flowables.ConnectableFlowable<T>> {
        public final io.reactivex.Flowable<T> n;
        public final int t;

        public BufferedReplayCallable(io.reactivex.Flowable<T> flowable, int i) {
            this.n = flowable;
            this.t = i;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.flowables.ConnectableFlowable<T> call() {
            return this.n.replay(this.t);
        }
    }

    public static final class BufferedTimedReplay<T> implements java.util.concurrent.Callable<io.reactivex.flowables.ConnectableFlowable<T>> {
        public final io.reactivex.Flowable<T> n;
        public final int t;
        public final long u;
        public final java.util.concurrent.TimeUnit v;
        public final io.reactivex.Scheduler w;

        public BufferedTimedReplay(io.reactivex.Flowable<T> flowable, int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.n = flowable;
            this.t = i;
            this.u = j;
            this.v = timeUnit;
            this.w = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.flowables.ConnectableFlowable<T> call() {
            return this.n.replay(this.t, this.u, this.v, this.w);
        }
    }

    public static final class FlatMapIntoIterable<T, U> implements io.reactivex.functions.Function<T, org.reactivestreams.Publisher<U>> {
        public final io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> n;

        public FlatMapIntoIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function) {
            this.n = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.reactivestreams.Publisher<U> apply(T t) throws java.lang.Exception {
            return new io.reactivex.internal.operators.flowable.FlowableFromIterable((java.lang.Iterable) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(t), "The mapper returned a null Iterable"));
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

    public static final class FlatMapWithCombinerOuter<T, R, U> implements io.reactivex.functions.Function<T, org.reactivestreams.Publisher<R>> {
        public final io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> n;
        public final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> t;

        public FlatMapWithCombinerOuter(io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> function) {
            this.n = biFunction;
            this.t = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.reactivestreams.Publisher<R> apply(T t) throws java.lang.Exception {
            return new io.reactivex.internal.operators.flowable.FlowableMapPublisher((org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t), "The mapper returned a null Publisher"), new io.reactivex.internal.operators.flowable.FlowableInternalHelper.FlatMapWithCombinerInner(this.n, t));
        }
    }

    public static final class ItemDelayFunction<T, U> implements io.reactivex.functions.Function<T, org.reactivestreams.Publisher<T>> {
        public final io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<U>> n;

        public ItemDelayFunction(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<U>> function) {
            this.n = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.reactivestreams.Publisher<T> apply(T t) throws java.lang.Exception {
            return new io.reactivex.internal.operators.flowable.FlowableTakePublisher((org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(t), "The itemDelay returned a null Publisher"), 1L).map(io.reactivex.internal.functions.Functions.justFunction(t)).defaultIfEmpty(t);
        }
    }

    public static final class ReplayCallable<T> implements java.util.concurrent.Callable<io.reactivex.flowables.ConnectableFlowable<T>> {
        public final io.reactivex.Flowable<T> n;

        public ReplayCallable(io.reactivex.Flowable<T> flowable) {
            this.n = flowable;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.flowables.ConnectableFlowable<T> call() {
            return this.n.replay();
        }
    }

    public static final class ReplayFunction<T, R> implements io.reactivex.functions.Function<io.reactivex.Flowable<T>, org.reactivestreams.Publisher<R>> {
        public final io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> n;
        public final io.reactivex.Scheduler t;

        public ReplayFunction(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> function, io.reactivex.Scheduler scheduler) {
            this.n = function;
            this.t = scheduler;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.reactivestreams.Publisher<R> apply(io.reactivex.Flowable<T> flowable) throws java.lang.Exception {
            return io.reactivex.Flowable.fromPublisher((org.reactivestreams.Publisher) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(flowable), "The selector returned a null Publisher")).observeOn(this.t);
        }
    }

    public enum RequestMax implements io.reactivex.functions.Consumer<org.reactivestreams.Subscription> {
        INSTANCE;

        @Override // io.reactivex.functions.Consumer
        public void accept(org.reactivestreams.Subscription subscription) throws java.lang.Exception {
            subscription.request(Long.MAX_VALUE);
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

    public static final class SubscriberOnComplete<T> implements io.reactivex.functions.Action {
        public final org.reactivestreams.Subscriber<T> n;

        public SubscriberOnComplete(org.reactivestreams.Subscriber<T> subscriber) {
            this.n = subscriber;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws java.lang.Exception {
            this.n.onComplete();
        }
    }

    public static final class SubscriberOnError<T> implements io.reactivex.functions.Consumer<java.lang.Throwable> {
        public final org.reactivestreams.Subscriber<T> n;

        public SubscriberOnError(org.reactivestreams.Subscriber<T> subscriber) {
            this.n = subscriber;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(java.lang.Throwable th) throws java.lang.Exception {
            this.n.onError(th);
        }
    }

    public static final class SubscriberOnNext<T> implements io.reactivex.functions.Consumer<T> {
        public final org.reactivestreams.Subscriber<T> n;

        public SubscriberOnNext(org.reactivestreams.Subscriber<T> subscriber) {
            this.n = subscriber;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws java.lang.Exception {
            this.n.onNext(t);
        }
    }

    public static final class TimedReplay<T> implements java.util.concurrent.Callable<io.reactivex.flowables.ConnectableFlowable<T>> {
        public final io.reactivex.Flowable<T> n;
        public final long t;
        public final java.util.concurrent.TimeUnit u;
        public final io.reactivex.Scheduler v;

        public TimedReplay(io.reactivex.Flowable<T> flowable, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.n = flowable;
            this.t = j;
            this.u = timeUnit;
            this.v = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.flowables.ConnectableFlowable<T> call() {
            return this.n.replay(this.t, this.u, this.v);
        }
    }

    public static final class ZipIterableFunction<T, R> implements io.reactivex.functions.Function<java.util.List<org.reactivestreams.Publisher<? extends T>>, org.reactivestreams.Publisher<? extends R>> {
        public final io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> n;

        public ZipIterableFunction(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
            this.n = function;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.reactivestreams.Publisher<? extends R> apply(java.util.List<org.reactivestreams.Publisher<? extends T>> list) {
            return io.reactivex.Flowable.zipIterable(list, this.n, false, io.reactivex.Flowable.bufferSize());
        }
    }

    public FlowableInternalHelper() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static <T, U> io.reactivex.functions.Function<T, org.reactivestreams.Publisher<U>> flatMapIntoIterable(io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends U>> function) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.FlatMapIntoIterable(function);
    }

    public static <T, U, R> io.reactivex.functions.Function<T, org.reactivestreams.Publisher<R>> flatMapWithCombiner(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<? extends U>> function, io.reactivex.functions.BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> io.reactivex.functions.Function<T, org.reactivestreams.Publisher<T>> itemDelay(io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<U>> function) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.ItemDelayFunction(function);
    }

    public static <T> java.util.concurrent.Callable<io.reactivex.flowables.ConnectableFlowable<T>> replayCallable(io.reactivex.Flowable<T> flowable) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.ReplayCallable(flowable);
    }

    public static <T> java.util.concurrent.Callable<io.reactivex.flowables.ConnectableFlowable<T>> replayCallable(io.reactivex.Flowable<T> flowable, int i) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.BufferedReplayCallable(flowable, i);
    }

    public static <T> java.util.concurrent.Callable<io.reactivex.flowables.ConnectableFlowable<T>> replayCallable(io.reactivex.Flowable<T> flowable, int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.BufferedTimedReplay(flowable, i, j, timeUnit, scheduler);
    }

    public static <T> java.util.concurrent.Callable<io.reactivex.flowables.ConnectableFlowable<T>> replayCallable(io.reactivex.Flowable<T> flowable, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.TimedReplay(flowable, j, timeUnit, scheduler);
    }

    public static <T, R> io.reactivex.functions.Function<io.reactivex.Flowable<T>, org.reactivestreams.Publisher<R>> replayFunction(io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> function, io.reactivex.Scheduler scheduler) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.ReplayFunction(function, scheduler);
    }

    public static <T, S> io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> simpleBiGenerator(io.reactivex.functions.BiConsumer<S, io.reactivex.Emitter<T>> biConsumer) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.SimpleBiGenerator(biConsumer);
    }

    public static <T, S> io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> simpleGenerator(io.reactivex.functions.Consumer<io.reactivex.Emitter<T>> consumer) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.SimpleGenerator(consumer);
    }

    public static <T> io.reactivex.functions.Action subscriberOnComplete(org.reactivestreams.Subscriber<T> subscriber) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.SubscriberOnComplete(subscriber);
    }

    public static <T> io.reactivex.functions.Consumer<java.lang.Throwable> subscriberOnError(org.reactivestreams.Subscriber<T> subscriber) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.SubscriberOnError(subscriber);
    }

    public static <T> io.reactivex.functions.Consumer<T> subscriberOnNext(org.reactivestreams.Subscriber<T> subscriber) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.SubscriberOnNext(subscriber);
    }

    public static <T, R> io.reactivex.functions.Function<java.util.List<org.reactivestreams.Publisher<? extends T>>, org.reactivestreams.Publisher<? extends R>> zipIterable(io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function) {
        return new io.reactivex.internal.operators.flowable.FlowableInternalHelper.ZipIterableFunction(function);
    }
}
