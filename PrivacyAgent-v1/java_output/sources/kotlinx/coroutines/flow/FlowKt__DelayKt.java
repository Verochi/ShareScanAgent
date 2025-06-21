package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a2\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0005H\u0007\u001a3\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a<\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a9\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\f\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000f\u001a\u00020\u0002H\u0007\u001a$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002H\u0000\u001a3\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0017\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "", "timeoutMillis", "a", "Lkotlin/Function1;", "b", "Lkotlin/time/Duration;", "timeout", "c", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "d", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "timeoutMillisSelector", "e", "periodMillis", "h", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "initialDelayMillis", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "f", com.umeng.analytics.AnalyticsConfig.RTD_PERIOD, "i", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes16.dex */
final /* synthetic */ class FlowKt__DelayKt {
    /* JADX WARN: Multi-variable type inference failed */
    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, long j) {
        if (j >= 0) {
            return j == 0 ? flow : e(flow, new kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$2(j));
        }
        throw new java.lang.IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    @kotlinx.coroutines.FlowPreview
    @kotlin.OverloadResolutionByLambdaReturnType
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Long> function1) {
        return e(flow, function1);
    }

    @kotlinx.coroutines.FlowPreview
    @kotlin.time.ExperimentalTime
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> c(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, long j) {
        return kotlinx.coroutines.flow.FlowKt.debounce(flow, kotlinx.coroutines.DelayKt.m756toDelayMillisLRDsOJo(j));
    }

    @kotlinx.coroutines.FlowPreview
    @kotlin.jvm.JvmName(name = "debounceDuration")
    @org.jetbrains.annotations.NotNull
    @kotlin.OverloadResolutionByLambdaReturnType
    @kotlin.time.ExperimentalTime
    public static final <T> kotlinx.coroutines.flow.Flow<T> d(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.time.Duration> function1) {
        return e(flow, new kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$3(function1));
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> e(kotlinx.coroutines.flow.Flow<? extends T> flow, kotlin.jvm.functions.Function1<? super T, java.lang.Long> function1) {
        return kotlinx.coroutines.flow.internal.FlowCoroutineKt.scopedFlow(new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1(function1, flow, null));
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.channels.ReceiveChannel<kotlin.Unit> f(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, long j, long j2) {
        if (!(j >= 0)) {
            throw new java.lang.IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
        }
        if (j2 >= 0) {
            return kotlinx.coroutines.channels.ProduceKt.produce$default(coroutineScope, null, 0, new kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3(j2, j, null), 1, null);
        }
        throw new java.lang.IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
    }

    public static /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel g(kotlinx.coroutines.CoroutineScope coroutineScope, long j, long j2, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        return kotlinx.coroutines.flow.FlowKt.fixedPeriodTicker(coroutineScope, j, j2);
    }

    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> h(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, long j) {
        if (j > 0) {
            return kotlinx.coroutines.flow.internal.FlowCoroutineKt.scopedFlow(new kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2(j, flow, null));
        }
        throw new java.lang.IllegalArgumentException("Sample period should be positive".toString());
    }

    @kotlinx.coroutines.FlowPreview
    @kotlin.time.ExperimentalTime
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> i(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, long j) {
        return kotlinx.coroutines.flow.FlowKt.sample(flow, kotlinx.coroutines.DelayKt.m756toDelayMillisLRDsOJo(j));
    }
}
