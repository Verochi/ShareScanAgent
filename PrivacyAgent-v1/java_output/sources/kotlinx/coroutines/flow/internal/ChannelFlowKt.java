package kotlinx.coroutines.flow.internal;

@kotlin.Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a]\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "asChannelFlow", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/CoroutineContext;", "emitContext", "a", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "newContext", "value", "", "countOrElement", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "withContextUndispatched", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ChannelFlowKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> kotlinx.coroutines.flow.FlowCollector<T> a(kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, kotlin.coroutines.CoroutineContext coroutineContext) {
        return flowCollector instanceof kotlinx.coroutines.flow.internal.SendingCollector ? true : flowCollector instanceof kotlinx.coroutines.flow.internal.NopCollector ? flowCollector : new kotlinx.coroutines.flow.internal.UndispatchedContextCollector(flowCollector, coroutineContext);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.internal.ChannelFlow<T> asChannelFlow(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        kotlinx.coroutines.flow.internal.ChannelFlow<T> channelFlow = flow instanceof kotlinx.coroutines.flow.internal.ChannelFlow ? (kotlinx.coroutines.flow.internal.ChannelFlow) flow : null;
        return channelFlow == null ? new kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl(flow, null, 0, null, 14, null) : channelFlow;
    }

    @org.jetbrains.annotations.Nullable
    public static final <T, V> java.lang.Object withContextUndispatched(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, V v, @org.jetbrains.annotations.NotNull java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super V, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        java.lang.Object coroutine_suspended;
        java.lang.Object updateThreadContext = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(coroutineContext, obj);
        try {
            kotlinx.coroutines.flow.internal.StackFrameContinuation stackFrameContinuation = new kotlinx.coroutines.flow.internal.StackFrameContinuation(continuation, coroutineContext);
            if (function2 == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            java.lang.Object mo5invoke = ((kotlin.jvm.functions.Function2) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).mo5invoke(v, stackFrameContinuation);
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (mo5invoke == coroutine_suspended) {
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return mo5invoke;
        } catch (java.lang.Throwable th) {
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            throw th;
        }
    }

    public static /* synthetic */ java.lang.Object withContextUndispatched$default(kotlin.coroutines.CoroutineContext coroutineContext, java.lang.Object obj, java.lang.Object obj2, kotlin.jvm.functions.Function2 function2, kotlin.coroutines.Continuation continuation, int i, java.lang.Object obj3) {
        if ((i & 4) != 0) {
            obj2 = kotlinx.coroutines.internal.ThreadContextKt.threadContextElements(coroutineContext);
        }
        return withContextUndispatched(coroutineContext, obj, obj2, function2, continuation);
    }
}
