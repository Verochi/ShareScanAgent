package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u001a3\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\n\u001a3\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0018\u0010\f\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0018\u0010\u000f\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"getOrCreateCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "delegate", "Lkotlin/coroutines/Continuation;", "suspendCancellableCoroutine", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendCancellableCoroutineReusable", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/DisposableHandle;", "removeOnCancellation", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class CancellableContinuationKt {
    @kotlinx.coroutines.InternalCoroutinesApi
    public static final void disposeOnCancellation(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<?> cancellableContinuation, @org.jetbrains.annotations.NotNull kotlinx.coroutines.DisposableHandle disposableHandle) {
        cancellableContinuation.invokeOnCancellation(new kotlinx.coroutines.DisposeOnCancel(disposableHandle));
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.CancellableContinuationImpl<T> getOrCreateCancellableContinuation(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        if (!(continuation instanceof kotlinx.coroutines.internal.DispatchedContinuation)) {
            return new kotlinx.coroutines.CancellableContinuationImpl<>(continuation, 1);
        }
        kotlinx.coroutines.CancellableContinuationImpl<T> claimReusableCancellableContinuation = ((kotlinx.coroutines.internal.DispatchedContinuation) continuation).claimReusableCancellableContinuation();
        if (claimReusableCancellableContinuation == null || !claimReusableCancellableContinuation.resetStateReusable()) {
            claimReusableCancellableContinuation = null;
        }
        return claimReusableCancellableContinuation == null ? new kotlinx.coroutines.CancellableContinuationImpl<>(continuation, 2) : claimReusableCancellableContinuation;
    }

    public static final void removeOnCancellation(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<?> cancellableContinuation, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode) {
        cancellableContinuation.invokeOnCancellation(new kotlinx.coroutines.RemoveOnCancel(lockFreeLinkedListNode));
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object suspendCancellableCoroutine(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.CancellableContinuation<? super T>, kotlin.Unit> function1, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        function1.invoke(cancellableContinuationImpl);
        java.lang.Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object suspendCancellableCoroutineReusable(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.CancellableContinuation<? super T>, kotlin.Unit> function1, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = getOrCreateCancellableContinuation(intercepted);
        function1.invoke(orCreateCancellableContinuation);
        java.lang.Object result = orCreateCancellableContinuation.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
