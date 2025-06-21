package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016J\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0016J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J*\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0002R\u0016\u0010$\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "", "initFutureCancellation$kotlinx_coroutines_core", "()V", "initFutureCancellation", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "close", "", "toString", "", "other", "", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "Ljava/util/concurrent/ScheduledFuture;", "b", "Ljava/util/concurrent/RejectedExecutionException;", "exception", "a", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Z", "removesFutureOnCancellation", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public abstract class ExecutorCoroutineDispatcherBase extends kotlinx.coroutines.ExecutorCoroutineDispatcher implements kotlinx.coroutines.Delay {

    /* renamed from: n, reason: from kotlin metadata */
    public boolean removesFutureOnCancellation;

    public final void a(kotlin.coroutines.CoroutineContext context, java.util.concurrent.RejectedExecutionException exception) {
        kotlinx.coroutines.JobKt.cancel(context, kotlinx.coroutines.ExceptionsKt.CancellationException("The task was rejected", exception));
    }

    public final java.util.concurrent.ScheduledFuture<?> b(java.lang.Runnable block, kotlin.coroutines.CoroutineContext context, long timeMillis) {
        try {
            java.util.concurrent.Executor executor = getExecutor();
            java.util.concurrent.ScheduledExecutorService scheduledExecutorService = executor instanceof java.util.concurrent.ScheduledExecutorService ? (java.util.concurrent.ScheduledExecutorService) executor : null;
            if (scheduledExecutorService == null) {
                return null;
            }
            return scheduledExecutorService.schedule(block, timeMillis, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.util.concurrent.RejectedExecutionException e) {
            a(context, e);
            return null;
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        java.util.concurrent.Executor executor = getExecutor();
        java.util.concurrent.ExecutorService executorService = executor instanceof java.util.concurrent.ExecutorService ? (java.util.concurrent.ExecutorService) executor : null;
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
    }

    @Override // kotlinx.coroutines.Delay
    @org.jetbrains.annotations.Nullable
    public java.lang.Object delay(long j, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return kotlinx.coroutines.Delay.DefaultImpls.delay(this, j, continuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable block) {
        try {
            java.util.concurrent.Executor executor = getExecutor();
            kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
            executor.execute(timeSource == null ? block : timeSource.wrapTask(block));
        } catch (java.util.concurrent.RejectedExecutionException e) {
            kotlinx.coroutines.AbstractTimeSource timeSource2 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
            if (timeSource2 != null) {
                timeSource2.unTrackTask();
            }
            a(context, e);
            kotlinx.coroutines.Dispatchers.getIO().dispatch(context, block);
        }
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        return (other instanceof kotlinx.coroutines.ExecutorCoroutineDispatcherBase) && ((kotlinx.coroutines.ExecutorCoroutineDispatcherBase) other).getExecutor() == getExecutor();
    }

    public int hashCode() {
        return java.lang.System.identityHashCode(getExecutor());
    }

    public final void initFutureCancellation$kotlinx_coroutines_core() {
        this.removesFutureOnCancellation = kotlinx.coroutines.internal.ConcurrentKt.removeFutureOnCancel(getExecutor());
    }

    @Override // kotlinx.coroutines.Delay
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.DisposableHandle invokeOnTimeout(long timeMillis, @org.jetbrains.annotations.NotNull java.lang.Runnable block, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context) {
        java.util.concurrent.ScheduledFuture<?> b = this.removesFutureOnCancellation ? b(block, context, timeMillis) : null;
        return b != null ? new kotlinx.coroutines.DisposableFutureHandle(b) : kotlinx.coroutines.DefaultExecutor.INSTANCE.invokeOnTimeout(timeMillis, block, context);
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long timeMillis, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> continuation) {
        java.util.concurrent.ScheduledFuture<?> b = this.removesFutureOnCancellation ? b(new kotlinx.coroutines.ResumeUndispatchedRunnable(this, continuation), continuation.getN(), timeMillis) : null;
        if (b != null) {
            kotlinx.coroutines.JobKt.cancelFutureOnCancellation(continuation, b);
        } else {
            kotlinx.coroutines.DefaultExecutor.INSTANCE.scheduleResumeAfterDelay(timeMillis, continuation);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return getExecutor().toString();
    }
}
