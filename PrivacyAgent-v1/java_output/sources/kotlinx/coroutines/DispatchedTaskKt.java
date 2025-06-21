package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000e\u001a \u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a.\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002\u001a'\u0010\u0010\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0080\b\u001a\u0019\u0010\u0013\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0080\b\"\u0014\u0010\u0014\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u001a\u0010\u0016\u001a\u00020\u00028\u0000X\u0081T¢\u0006\f\n\u0004\b\u0016\u0010\u0015\u0012\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u0019\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015\"\u0014\u0010\u001a\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015\"\u0014\u0010\u001b\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015\"\u0018\u0010\u001c\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0018\u0010\u001e\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001d¨\u0006\u001f"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DispatchedTask;", "", "mode", "", "dispatch", "Lkotlin/coroutines/Continuation;", "delegate", "", "undispatched", com.anythink.expressad.foundation.d.c.cc, "a", "Lkotlinx/coroutines/EventLoop;", "eventLoop", "Lkotlin/Function0;", "block", "runUnconfinedEventLoop", "", "exception", "resumeWithStackTrace", "MODE_ATOMIC", "I", "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", "(I)Z", "isReusableMode", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class DispatchedTaskKt {
    public static final int MODE_ATOMIC = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_CANCELLABLE_REUSABLE = 2;
    public static final int MODE_UNDISPATCHED = 4;
    public static final int MODE_UNINITIALIZED = -1;

    public static final void a(kotlinx.coroutines.DispatchedTask<?> dispatchedTask) {
        kotlinx.coroutines.EventLoop eventLoop$kotlinx_coroutines_core = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedTask);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            resume(dispatchedTask, dispatchedTask.getDelegate$kotlinx_coroutines_core(), true);
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final <T> void dispatch(@org.jetbrains.annotations.NotNull kotlinx.coroutines.DispatchedTask<? super T> dispatchedTask, int i) {
        kotlin.coroutines.Continuation<? super T> delegate$kotlinx_coroutines_core = dispatchedTask.getDelegate$kotlinx_coroutines_core();
        boolean z = i == 4;
        if (z || !(delegate$kotlinx_coroutines_core instanceof kotlinx.coroutines.internal.DispatchedContinuation) || isCancellableMode(i) != isCancellableMode(dispatchedTask.resumeMode)) {
            resume(dispatchedTask, delegate$kotlinx_coroutines_core, z);
            return;
        }
        kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher = ((kotlinx.coroutines.internal.DispatchedContinuation) delegate$kotlinx_coroutines_core).dispatcher;
        kotlin.coroutines.CoroutineContext context = delegate$kotlinx_coroutines_core.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, dispatchedTask);
        } else {
            a(dispatchedTask);
        }
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getMODE_CANCELLABLE$annotations() {
    }

    public static final boolean isCancellableMode(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean isReusableMode(int i) {
        return i == 2;
    }

    public static final <T> void resume(@org.jetbrains.annotations.NotNull kotlinx.coroutines.DispatchedTask<? super T> dispatchedTask, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation, boolean z) {
        java.lang.Object successfulResult$kotlinx_coroutines_core;
        java.lang.Object takeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        java.lang.Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            successfulResult$kotlinx_coroutines_core = kotlin.ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core);
        } else {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            successfulResult$kotlinx_coroutines_core = dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        }
        java.lang.Object m156constructorimpl = kotlin.Result.m156constructorimpl(successfulResult$kotlinx_coroutines_core);
        if (!z) {
            continuation.resumeWith(m156constructorimpl);
            return;
        }
        kotlinx.coroutines.internal.DispatchedContinuation dispatchedContinuation = (kotlinx.coroutines.internal.DispatchedContinuation) continuation;
        kotlin.coroutines.Continuation<T> continuation2 = dispatchedContinuation.continuation;
        java.lang.Object obj = dispatchedContinuation.countOrElement;
        kotlin.coroutines.CoroutineContext context = continuation2.getContext();
        java.lang.Object updateThreadContext = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(context, obj);
        kotlinx.coroutines.UndispatchedCoroutine<?> updateUndispatchedCompletion = updateThreadContext != kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS ? kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(continuation2, context, updateThreadContext) : null;
        try {
            dispatchedContinuation.continuation.resumeWith(m156constructorimpl);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        } finally {
            if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        }
    }

    public static final void resumeWithStackTrace(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation, @org.jetbrains.annotations.NotNull java.lang.Throwable th) {
        kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
        continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th)));
    }

    public static final void runUnconfinedEventLoop(@org.jetbrains.annotations.NotNull kotlinx.coroutines.DispatchedTask<?> dispatchedTask, @org.jetbrains.annotations.NotNull kotlinx.coroutines.EventLoop eventLoop, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> function0) {
        eventLoop.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop.processUnconfinedEvent());
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
        } catch (java.lang.Throwable th) {
            try {
                dispatchedTask.handleFatalException(th, null);
                kotlin.jvm.internal.InlineMarker.finallyStart(1);
            } catch (java.lang.Throwable th2) {
                kotlin.jvm.internal.InlineMarker.finallyStart(1);
                eventLoop.decrementUseCount(true);
                kotlin.jvm.internal.InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        eventLoop.decrementUseCount(true);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
    }
}
