package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k = 4, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class FlowKt {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> iterable) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.a(iterable);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(@org.jetbrains.annotations.NotNull java.util.Iterator<? extends T> it) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.b(it);
    }

    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> function0) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.c(function0);
    }

    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function1) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.d(function1);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.flow.Flow<java.lang.Integer> asFlow(@org.jetbrains.annotations.NotNull kotlin.ranges.IntRange intRange) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.e(intRange);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.flow.Flow<java.lang.Long> asFlow(@org.jetbrains.annotations.NotNull kotlin.ranges.LongRange longRange) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.f(longRange);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> sequence) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.g(sequence);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "'BroadcastChannel' is obsolete and all coreresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BroadcastChannel<T> broadcastChannel) {
        return kotlinx.coroutines.flow.FlowKt__ChannelsKt.b(broadcastChannel);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.flow.Flow<java.lang.Integer> asFlow(@org.jetbrains.annotations.NotNull int[] iArr) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.h(iArr);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.flow.Flow<java.lang.Long> asFlow(@org.jetbrains.annotations.NotNull long[] jArr) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.i(jArr);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> asFlow(@org.jetbrains.annotations.NotNull T[] tArr) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.j(tArr);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.SharedFlow<T> asSharedFlow(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.MutableSharedFlow<T> mutableSharedFlow) {
        return kotlinx.coroutines.flow.FlowKt__ShareKt.a(mutableSharedFlow);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.StateFlow<T> asStateFlow(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.MutableStateFlow<T> mutableStateFlow) {
        return kotlinx.coroutines.flow.FlowKt__ShareKt.b(mutableStateFlow);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use shareIn operator and the resulting SharedFlow as a replacement for BroadcastChannel", replaceWith = @kotlin.ReplaceWith(expression = "this.shareIn(scope, SharingStarted.Lazily, 0)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.channels.BroadcastChannel<T> broadcastIn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineStart coroutineStart) {
        return kotlinx.coroutines.flow.FlowKt__ChannelsKt.c(flow, coroutineScope, coroutineStart);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> buffer(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, int i, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BufferOverflow bufferOverflow) {
        return kotlinx.coroutines.flow.FlowKt__ContextKt.b(flow, i, bufferOverflow);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @kotlin.ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> cache(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.a(flow);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> callbackFlow(@kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.channels.ProducerScope<? super T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.k(function2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> cancellable(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        return kotlinx.coroutines.flow.FlowKt__ContextKt.e(flow);
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: catch, reason: not valid java name */
    public static final <T> kotlinx.coroutines.flow.Flow<T> m788catch(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__ErrorsKt.a(flow, function3);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object catchImpl(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Throwable> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ErrorsKt.b(flow, flowCollector, continuation);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> channelFlow(@kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.channels.ProducerScope<? super T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.l(function2);
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<?> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return kotlinx.coroutines.flow.FlowKt__CollectKt.a(flow, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return kotlinx.coroutines.flow.FlowKt__CollectKt.b(flow, function2, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object collectIndexed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function3, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return kotlinx.coroutines.flow.FlowKt__CollectKt.c(flow, function3, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object collectLatest(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return kotlinx.coroutines.flow.FlowKt__CollectKt.d(flow, function2, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object collectWhile(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return kotlinx.coroutines.flow.FlowKt__LimitKt.b(flow, function2, continuation);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> combine(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__ZipKt.c(flow, flow2, function3);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, T3, R> kotlinx.coroutines.flow.Flow<R> combine(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T3> flow3, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function4) {
        return kotlinx.coroutines.flow.FlowKt__ZipKt.d(flow, flow2, flow3, function4);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, T3, T4, R> kotlinx.coroutines.flow.Flow<R> combine(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T3> flow3, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T4> flow4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function5) {
        return kotlinx.coroutines.flow.FlowKt__ZipKt.e(flow, flow2, flow3, flow4, function5);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, T3, T4, T5, R> kotlinx.coroutines.flow.Flow<R> combine(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T3> flow3, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T4> flow4, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T5> flow5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function6) {
        return kotlinx.coroutines.flow.FlowKt__ZipKt.f(flow, flow2, flow3, flow4, flow5, function6);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> combineLatest(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.b(flow, flow2, function3);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, T3, R> kotlinx.coroutines.flow.Flow<R> combineLatest(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T3> flow3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function4) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.c(flow, flow2, flow3, function4);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, T3, T4, R> kotlinx.coroutines.flow.Flow<R> combineLatest(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T3> flow3, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T4> flow4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function5) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.d(flow, flow2, flow3, flow4, function5);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, T3, T4, T5, R> kotlinx.coroutines.flow.Flow<R> combineLatest(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T3> flow3, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T4> flow4, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T5> flow5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function6) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.e(flow, flow2, flow3, flow4, flow5, function6);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> combineTransform(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function4) {
        return kotlinx.coroutines.flow.FlowKt__ZipKt.i(flow, flow2, function4);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, T3, R> kotlinx.coroutines.flow.Flow<R> combineTransform(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T3> flow3, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function5<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function5) {
        return kotlinx.coroutines.flow.FlowKt__ZipKt.j(flow, flow2, flow3, function5);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, T3, T4, R> kotlinx.coroutines.flow.Flow<R> combineTransform(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T3> flow3, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T4> flow4, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function6<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function6) {
        return kotlinx.coroutines.flow.FlowKt__ZipKt.k(flow, flow2, flow3, flow4, function6);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, T3, T4, T5, R> kotlinx.coroutines.flow.Flow<R> combineTransform(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T3> flow3, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T4> flow4, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T5> flow5, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function7<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function7) {
        return kotlinx.coroutines.flow.FlowKt__ZipKt.l(flow, flow2, flow3, flow4, flow5, function7);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @kotlin.ReplaceWith(expression = "let(transformer)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> compose(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.flow.Flow<? extends T>, ? extends kotlinx.coroutines.flow.Flow<? extends R>> function1) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.f(flow, function1);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @kotlin.ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> concatMap(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends kotlinx.coroutines.flow.Flow<? extends R>> function1) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.g(flow, function1);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @kotlin.ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> concatWith(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, T t) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.h(flow, t);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @kotlin.ReplaceWith(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> concatWith(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow2) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.i(flow, flow2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> conflate(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        return kotlinx.coroutines.flow.FlowKt__ContextKt.g(flow);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> consumeAsFlow(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends T> receiveChannel) {
        return kotlinx.coroutines.flow.FlowKt__ChannelsKt.e(receiveChannel);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object count(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        return kotlinx.coroutines.flow.FlowKt__CountKt.a(flow, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object count(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        return kotlinx.coroutines.flow.FlowKt__CountKt.b(flow, function2, continuation);
    }

    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> debounce(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, long j) {
        return kotlinx.coroutines.flow.FlowKt__DelayKt.a(flow, j);
    }

    @kotlinx.coroutines.FlowPreview
    @kotlin.OverloadResolutionByLambdaReturnType
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> debounce(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Long> function1) {
        return kotlinx.coroutines.flow.FlowKt__DelayKt.b(flow, function1);
    }

    @kotlinx.coroutines.FlowPreview
    @kotlin.time.ExperimentalTime
    @org.jetbrains.annotations.NotNull
    /* renamed from: debounce-HG0u8IE, reason: not valid java name */
    public static final <T> kotlinx.coroutines.flow.Flow<T> m789debounceHG0u8IE(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, long j) {
        return kotlinx.coroutines.flow.FlowKt__DelayKt.c(flow, j);
    }

    @kotlinx.coroutines.FlowPreview
    @kotlin.jvm.JvmName(name = "debounceDuration")
    @org.jetbrains.annotations.NotNull
    @kotlin.OverloadResolutionByLambdaReturnType
    @kotlin.time.ExperimentalTime
    public static final <T> kotlinx.coroutines.flow.Flow<T> debounceDuration(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.time.Duration> function1) {
        return kotlinx.coroutines.flow.FlowKt__DelayKt.d(flow, function1);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @kotlin.ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> delayEach(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, long j) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.j(flow, j);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @kotlin.ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> delayFlow(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, long j) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.k(flow, j);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> distinctUntilChanged(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        return kotlinx.coroutines.flow.FlowKt__DistinctKt.a(flow);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> distinctUntilChanged(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super T, java.lang.Boolean> function2) {
        return kotlinx.coroutines.flow.FlowKt__DistinctKt.b(flow, function2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T, K> kotlinx.coroutines.flow.Flow<T> distinctUntilChangedBy(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends K> function1) {
        return kotlinx.coroutines.flow.FlowKt__DistinctKt.c(flow, function1);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> drop(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, int i) {
        return kotlinx.coroutines.flow.FlowKt__LimitKt.c(flow, i);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> dropWhile(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__LimitKt.d(flow, function2);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object emitAll(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends T> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ChannelsKt.f(flowCollector, receiveChannel, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object emitAll(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return kotlinx.coroutines.flow.FlowKt__CollectKt.e(flowCollector, flow, continuation);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> emptyFlow() {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.m();
    }

    public static final void ensureActive(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<?> flowCollector) {
        kotlinx.coroutines.flow.FlowKt__EmittersKt.b(flowCollector);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> filter(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__TransformKt.a(flow, function2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> filterNot(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__TransformKt.c(flow, function2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> filterNotNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        return kotlinx.coroutines.flow.FlowKt__TransformKt.d(flow);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object first(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ReduceKt.a(flow, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object first(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ReduceKt.b(flow, function2, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object firstOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ReduceKt.c(flow, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object firstOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ReduceKt.d(flow, function2, continuation);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.channels.ReceiveChannel<kotlin.Unit> fixedPeriodTicker(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, long j, long j2) {
        return kotlinx.coroutines.flow.FlowKt__DelayKt.f(coroutineScope, j, j2);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @kotlin.ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flatMap(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.l(flow, function2);
    }

    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flatMapConcat(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__MergeKt.a(flow, function2);
    }

    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flatMapLatest(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__MergeKt.b(flow, function2);
    }

    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flatMapMerge(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, int i, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__MergeKt.c(flow, i, function2);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @kotlin.ReplaceWith(expression = "flattenConcat()", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> flatten(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends kotlinx.coroutines.flow.Flow<? extends T>> flow) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.m(flow);
    }

    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> flattenConcat(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends kotlinx.coroutines.flow.Flow<? extends T>> flow) {
        return kotlinx.coroutines.flow.FlowKt__MergeKt.e(flow);
    }

    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> flattenMerge(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends kotlinx.coroutines.flow.Flow<? extends T>> flow, int i) {
        return kotlinx.coroutines.flow.FlowKt__MergeKt.f(flow, i);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> flow(@kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.n(function2);
    }

    @kotlin.jvm.JvmName(name = "flowCombine")
    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> flowCombine(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__ZipKt.n(flow, flow2, function3);
    }

    @kotlin.jvm.JvmName(name = "flowCombineTransform")
    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> flowCombineTransform(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function4) {
        return kotlinx.coroutines.flow.FlowKt__ZipKt.o(flow, flow2, function4);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> flowOf(T t) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.o(t);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> flowOf(@org.jetbrains.annotations.NotNull T... tArr) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.p(tArr);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> flowOn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlinx.coroutines.flow.FlowKt__ContextKt.h(flow, coroutineContext);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> flowViaChannel(int i, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlinx.coroutines.channels.SendChannel<? super T>, kotlin.Unit> function2) {
        return kotlinx.coroutines.flow.FlowKt__BuildersKt.q(i, function2);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flowWith(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, int i, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.flow.Flow<? extends T>, ? extends kotlinx.coroutines.flow.Flow<? extends R>> function1) {
        return kotlinx.coroutines.flow.FlowKt__ContextKt.i(flow, coroutineContext, i, function1);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T, R> java.lang.Object fold(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super R, ? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ReduceKt.e(flow, r, function3, continuation);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @kotlin.ReplaceWith(expression = "collect(block)", imports = {}))
    public static final <T> void forEach(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        kotlinx.coroutines.flow.FlowKt__MigrationKt.n(flow, function2);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return kotlinx.coroutines.flow.FlowKt__MergeKt.h();
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object last(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ReduceKt.f(flow, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object lastOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ReduceKt.g(flow, continuation);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.Job launchIn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope) {
        return kotlinx.coroutines.flow.FlowKt__CollectKt.f(flow, coroutineScope);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> map(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__TransformKt.e(flow, function2);
    }

    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> mapLatest(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__MergeKt.j(flow, function2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> mapNotNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__TransformKt.f(flow, function2);
    }

    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> merge(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends kotlinx.coroutines.flow.Flow<? extends T>> iterable) {
        return kotlinx.coroutines.flow.FlowKt__MergeKt.k(iterable);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @kotlin.ReplaceWith(expression = "flattenConcat()", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> merge(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends kotlinx.coroutines.flow.Flow<? extends T>> flow) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.o(flow);
    }

    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> merge(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T>... flowArr) {
        return kotlinx.coroutines.flow.FlowKt__MergeKt.l(flowArr);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Void noImpl() {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.p();
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> observeOn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.q(flow, coroutineContext);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> onCompletion(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__EmittersKt.d(flow, function3);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> onEach(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__TransformKt.g(flow, function2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> onEmpty(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__EmittersKt.e(flow, function2);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @kotlin.ReplaceWith(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorCollect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, java.lang.Boolean> function1) {
        return kotlinx.coroutines.flow.FlowKt__ErrorsKt.e(flow, flow2, function1);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @kotlin.ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorResume(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow2) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.r(flow, flow2);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @kotlin.ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorResumeNext(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow2) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.s(flow, flow2);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @kotlin.ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorReturn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, T t) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.t(flow, t);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @kotlin.ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorReturn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, T t, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, java.lang.Boolean> function1) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.u(flow, t, function1);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> onStart(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__EmittersKt.f(flow, function2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.SharedFlow<T> onSubscription(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.SharedFlow<? extends T> sharedFlow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__ShareKt.f(sharedFlow, function2);
    }

    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.channels.ReceiveChannel<T> produceIn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope) {
        return kotlinx.coroutines.flow.FlowKt__ChannelsKt.h(flow, coroutineScope);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @kotlin.ReplaceWith(expression = "this.shareIn(scope, 0)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> publish(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.w(flow);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @kotlin.ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> publish(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, int i) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.x(flow, i);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> publishOn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.y(flow, coroutineContext);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> receiveAsFlow(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends T> receiveChannel) {
        return kotlinx.coroutines.flow.FlowKt__ChannelsKt.i(receiveChannel);
    }

    @org.jetbrains.annotations.Nullable
    public static final <S, T extends S> java.lang.Object reduce(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super S, ? super T, ? super kotlin.coroutines.Continuation<? super S>, ? extends java.lang.Object> function3, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super S> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ReduceKt.h(flow, function3, continuation);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @kotlin.ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> replay(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.z(flow);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @kotlin.ReplaceWith(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> replay(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, int i) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.A(flow, i);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> retry(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, long j, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__ErrorsKt.h(flow, j, function2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> retryWhen(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super java.lang.Throwable, ? super java.lang.Long, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function4) {
        return kotlinx.coroutines.flow.FlowKt__ErrorsKt.k(flow, function4);
    }

    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> runningFold(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, R r, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super R, ? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__TransformKt.h(flow, r, function3);
    }

    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> runningReduce(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super T, ? super T, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__TransformKt.i(flow, function3);
    }

    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> sample(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, long j) {
        return kotlinx.coroutines.flow.FlowKt__DelayKt.h(flow, j);
    }

    @kotlinx.coroutines.FlowPreview
    @kotlin.time.ExperimentalTime
    @org.jetbrains.annotations.NotNull
    /* renamed from: sample-HG0u8IE, reason: not valid java name */
    public static final <T> kotlinx.coroutines.flow.Flow<T> m790sampleHG0u8IE(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, long j) {
        return kotlinx.coroutines.flow.FlowKt__DelayKt.i(flow, j);
    }

    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> scan(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, R r, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super R, ? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__TransformKt.j(flow, r, function3);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @kotlin.ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> scanFold(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, R r, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super R, ? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.B(flow, r, function3);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @kotlin.ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> scanReduce(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super T, ? super T, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.C(flow, function3);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.SharedFlow<T> shareIn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.SharingStarted sharingStarted, int i) {
        return kotlinx.coroutines.flow.FlowKt__ShareKt.g(flow, coroutineScope, sharingStarted, i);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object single(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ReduceKt.i(flow, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object singleOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ReduceKt.j(flow, continuation);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @kotlin.ReplaceWith(expression = "drop(count)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> skip(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, int i) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.D(flow, i);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @kotlin.ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> startWith(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, T t) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.E(flow, t);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @kotlin.ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> startWith(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow2) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.F(flow, flow2);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object stateIn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.StateFlow<? extends T>> continuation) {
        return kotlinx.coroutines.flow.FlowKt__ShareKt.i(flow, coroutineScope, continuation);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.StateFlow<T> stateIn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.SharingStarted sharingStarted, T t) {
        return kotlinx.coroutines.flow.FlowKt__ShareKt.j(flow, coroutineScope, sharingStarted, t);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        kotlinx.coroutines.flow.FlowKt__MigrationKt.G(flow);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        kotlinx.coroutines.flow.FlowKt__MigrationKt.H(flow, function2);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function22) {
        kotlinx.coroutines.flow.FlowKt__MigrationKt.I(flow, function2, function22);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> subscribeOn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.J(flow, coroutineContext);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @kotlin.ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> switchMap(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__MigrationKt.K(flow, function2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> take(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, int i) {
        return kotlinx.coroutines.flow.FlowKt__LimitKt.f(flow, i);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> takeWhile(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.flow.FlowKt__LimitKt.g(flow, function2);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T, C extends java.util.Collection<? super T>> java.lang.Object toCollection(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull C c, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> continuation) {
        return kotlinx.coroutines.flow.FlowKt__CollectionKt.a(flow, c, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object toList(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull java.util.List<T> list, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends T>> continuation) {
        return kotlinx.coroutines.flow.FlowKt__CollectionKt.b(flow, list, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object toSet(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull java.util.Set<T> set, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Set<? extends T>> continuation) {
        return kotlinx.coroutines.flow.FlowKt__CollectionKt.d(flow, set, continuation);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> transform(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__EmittersKt.g(flow, function3);
    }

    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> transformLatest(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__MergeKt.m(flow, function3);
    }

    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> transformWhile(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__LimitKt.h(flow, function3);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> unsafeTransform(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__EmittersKt.h(flow, function3);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<kotlin.collections.IndexedValue<T>> withIndex(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        return kotlinx.coroutines.flow.FlowKt__TransformKt.k(flow);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> zip(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T1> flow, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T2> flow2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.flow.FlowKt__ZipKt.q(flow, flow2, function3);
    }
}
