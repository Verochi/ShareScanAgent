package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001aW\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0012\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\t0\rH\u0000\"\u001a\u0010\u0015\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0016\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u0012\u0004\b\u0017\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "onCancellation", "resumeCancellableWith", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "", "yieldUndispatched", "Lkotlinx/coroutines/internal/Symbol;", "a", "Lkotlinx/coroutines/internal/Symbol;", "getUNDEFINED$annotations", "()V", "UNDEFINED", "REUSABLE_CLAIMED", "getREUSABLE_CLAIMED$annotations", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class DispatchedContinuationKt {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol a = new kotlinx.coroutines.internal.Symbol("UNDEFINED");

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol REUSABLE_CLAIMED = new kotlinx.coroutines.internal.Symbol("REUSABLE_CLAIMED");

    public static /* synthetic */ void getREUSABLE_CLAIMED$annotations() {
    }

    /* JADX WARN: Finally extract failed */
    @kotlinx.coroutines.InternalCoroutinesApi
    public static final <T> void resumeCancellableWith(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation, @org.jetbrains.annotations.NotNull java.lang.Object obj, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> function1) {
        boolean z;
        if (!(continuation instanceof kotlinx.coroutines.internal.DispatchedContinuation)) {
            continuation.resumeWith(obj);
            return;
        }
        kotlinx.coroutines.internal.DispatchedContinuation dispatchedContinuation = (kotlinx.coroutines.internal.DispatchedContinuation) continuation;
        java.lang.Object state = kotlinx.coroutines.CompletionStateKt.toState(obj, function1);
        if (dispatchedContinuation.dispatcher.isDispatchNeeded(dispatchedContinuation.getContext())) {
            dispatchedContinuation._state = state;
            dispatchedContinuation.resumeMode = 1;
            dispatchedContinuation.dispatcher.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
            return;
        }
        kotlinx.coroutines.EventLoop eventLoop$kotlinx_coroutines_core = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = state;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) dispatchedContinuation.getContext().get(kotlinx.coroutines.Job.INSTANCE);
            if (job == null || job.isActive()) {
                z = false;
            } else {
                java.util.concurrent.CancellationException cancellationException = job.getCancellationException();
                dispatchedContinuation.cancelCompletedResult$kotlinx_coroutines_core(state, cancellationException);
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                dispatchedContinuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(cancellationException)));
                z = true;
            }
            if (!z) {
                kotlin.coroutines.Continuation<T> continuation2 = dispatchedContinuation.continuation;
                java.lang.Object obj2 = dispatchedContinuation.countOrElement;
                kotlin.coroutines.CoroutineContext context = continuation2.getContext();
                java.lang.Object updateThreadContext = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(context, obj2);
                kotlinx.coroutines.UndispatchedCoroutine<?> updateUndispatchedCompletion = updateThreadContext != kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS ? kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(continuation2, context, updateThreadContext) : null;
                try {
                    dispatchedContinuation.continuation.resumeWith(obj);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                        kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                    }
                } catch (java.lang.Throwable th) {
                    if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                        kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                    }
                    throw th;
                }
            }
            while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void resumeCancellableWith$default(kotlin.coroutines.Continuation continuation, java.lang.Object obj, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        resumeCancellableWith(continuation, obj, function1);
    }

    public static final boolean yieldUndispatched(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.DispatchedContinuation<? super kotlin.Unit> dispatchedContinuation) {
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        kotlinx.coroutines.EventLoop eventLoop$kotlinx_coroutines_core = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = unit;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
