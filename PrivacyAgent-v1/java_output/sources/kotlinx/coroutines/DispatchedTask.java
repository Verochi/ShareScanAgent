package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001b\u001a\u00020\fJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001dR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public abstract class DispatchedTask<T> extends kotlinx.coroutines.scheduling.Task {

    @kotlin.jvm.JvmField
    public int resumeMode;

    public DispatchedTask(int i) {
        this.resumeMode = i;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable java.lang.Object takenState, @org.jetbrains.annotations.NotNull java.lang.Throwable cause) {
    }

    @org.jetbrains.annotations.NotNull
    public abstract kotlin.coroutines.Continuation<T> getDelegate$kotlinx_coroutines_core();

    @org.jetbrains.annotations.Nullable
    public java.lang.Throwable getExceptionalResult$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable java.lang.Object state) {
        kotlinx.coroutines.CompletedExceptionally completedExceptionally = state instanceof kotlinx.coroutines.CompletedExceptionally ? (kotlinx.coroutines.CompletedExceptionally) state : null;
        if (completedExceptionally == null) {
            return null;
        }
        return completedExceptionally.cause;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable java.lang.Object state) {
        return state;
    }

    public final void handleFatalException(@org.jetbrains.annotations.Nullable java.lang.Throwable exception, @org.jetbrains.annotations.Nullable java.lang.Throwable finallyException) {
        if (exception == null && finallyException == null) {
            return;
        }
        if (exception != null && finallyException != null) {
            kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(exception, finallyException);
        }
        if (exception == null) {
            exception = finallyException;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(exception);
        kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new kotlinx.coroutines.CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", exception));
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.Object m156constructorimpl;
        java.lang.Object m156constructorimpl2;
        kotlinx.coroutines.scheduling.TaskContext taskContext = this.taskContext;
        try {
            kotlinx.coroutines.internal.DispatchedContinuation dispatchedContinuation = (kotlinx.coroutines.internal.DispatchedContinuation) getDelegate$kotlinx_coroutines_core();
            kotlin.coroutines.Continuation<T> continuation = dispatchedContinuation.continuation;
            java.lang.Object obj = dispatchedContinuation.countOrElement;
            kotlin.coroutines.CoroutineContext context = continuation.getContext();
            java.lang.Object updateThreadContext = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(context, obj);
            kotlinx.coroutines.UndispatchedCoroutine<?> updateUndispatchedCompletion = updateThreadContext != kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS ? kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(continuation, context, updateThreadContext) : null;
            try {
                kotlin.coroutines.CoroutineContext context2 = continuation.getContext();
                java.lang.Object takeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                java.lang.Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
                kotlinx.coroutines.Job job = (exceptionalResult$kotlinx_coroutines_core == null && kotlinx.coroutines.DispatchedTaskKt.isCancellableMode(this.resumeMode)) ? (kotlinx.coroutines.Job) context2.get(kotlinx.coroutines.Job.INSTANCE) : null;
                if (job != null && !job.isActive()) {
                    java.util.concurrent.CancellationException cancellationException = job.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core, cancellationException);
                    kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                    continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(cancellationException)));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
                    continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core)));
                } else {
                    continuation.resumeWith(kotlin.Result.m156constructorimpl(getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core)));
                }
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                try {
                    taskContext.afterTask();
                    m156constructorimpl2 = kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE);
                } catch (java.lang.Throwable th) {
                    kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
                    m156constructorimpl2 = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th));
                }
                handleFatalException(null, kotlin.Result.m159exceptionOrNullimpl(m156constructorimpl2));
            } finally {
                if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                    kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                }
            }
        } catch (java.lang.Throwable th2) {
            try {
                kotlin.Result.Companion companion4 = kotlin.Result.INSTANCE;
                taskContext.afterTask();
                m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE);
            } catch (java.lang.Throwable th3) {
                kotlin.Result.Companion companion5 = kotlin.Result.INSTANCE;
                m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th3));
            }
            handleFatalException(th2, kotlin.Result.m159exceptionOrNullimpl(m156constructorimpl));
        }
    }

    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object takeState$kotlinx_coroutines_core();
}
