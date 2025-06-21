package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0003"}, d2 = {"yield", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class YieldKt {
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object yield(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        java.lang.Object coroutine_suspended3;
        kotlin.coroutines.CoroutineContext context = continuation.getContext();
        kotlinx.coroutines.JobKt.ensureActive(context);
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.internal.DispatchedContinuation dispatchedContinuation = intercepted instanceof kotlinx.coroutines.internal.DispatchedContinuation ? (kotlinx.coroutines.internal.DispatchedContinuation) intercepted : null;
        if (dispatchedContinuation == null) {
            coroutine_suspended = kotlin.Unit.INSTANCE;
        } else {
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(context, kotlin.Unit.INSTANCE);
            } else {
                kotlinx.coroutines.YieldContext yieldContext = new kotlinx.coroutines.YieldContext();
                kotlin.coroutines.CoroutineContext plus = context.plus(yieldContext);
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(plus, unit);
                if (yieldContext.dispatcherWasUnconfined) {
                    coroutine_suspended = kotlinx.coroutines.internal.DispatchedContinuationKt.yieldUndispatched(dispatchedContinuation) ? kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() : unit;
                }
            }
            coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == coroutine_suspended2) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutine_suspended == coroutine_suspended3 ? coroutine_suspended : kotlin.Unit.INSTANCE;
    }
}
