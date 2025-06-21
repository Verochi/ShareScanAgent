package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0006\u0010\t\u001a\u00020\u0002\u001aM\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\b\u0010H\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0011\u001a\u0011\u0010\u0012\u001a\u00020\bH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b\u001a\n\u0010\u001c\u001a\u00020\u0015*\u00020\u0002\u001a\u0015\u0010\u001d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002\"\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentCoroutineContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", com.anythink.expressad.d.a.b.dO, "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class CoroutineScopeKt {
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineScope CoroutineScope(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        kotlinx.coroutines.CompletableJob d;
        if (coroutineContext.get(kotlinx.coroutines.Job.INSTANCE) == null) {
            d = kotlinx.coroutines.JobKt__JobKt.d(null, 1, null);
            coroutineContext = coroutineContext.plus(d);
        }
        return new kotlinx.coroutines.internal.CoroutineScope(coroutineContext);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineScope MainScope() {
        return new kotlinx.coroutines.internal.CoroutineScope(kotlinx.coroutines.SupervisorKt.SupervisorJob$default((kotlinx.coroutines.Job) null, 1, (java.lang.Object) null).plus(kotlinx.coroutines.Dispatchers.getMain()));
    }

    public static final void cancel(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.Nullable java.lang.Throwable th) {
        cancel(coroutineScope, kotlinx.coroutines.ExceptionsKt.CancellationException(str, th));
    }

    public static final void cancel(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable java.util.concurrent.CancellationException cancellationException) {
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) coroutineScope.getCoroutineContext().get(kotlinx.coroutines.Job.INSTANCE);
        if (job == null) {
            throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Scope cannot be cancelled because it does not have a job: ", coroutineScope).toString());
        }
        job.cancel(cancellationException);
    }

    public static /* synthetic */ void cancel$default(kotlinx.coroutines.CoroutineScope coroutineScope, java.lang.String str, java.lang.Throwable th, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        cancel(coroutineScope, str, th);
    }

    public static /* synthetic */ void cancel$default(kotlinx.coroutines.CoroutineScope coroutineScope, java.util.concurrent.CancellationException cancellationException, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        cancel(coroutineScope, cancellationException);
    }

    @org.jetbrains.annotations.Nullable
    public static final <R> java.lang.Object coroutineScope(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> continuation) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.internal.ScopeCoroutine scopeCoroutine = new kotlinx.coroutines.internal.ScopeCoroutine(continuation.getContext(), continuation);
        java.lang.Object startUndispatchedOrReturn = kotlinx.coroutines.intrinsics.UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (startUndispatchedOrReturn == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return startUndispatchedOrReturn;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object currentCoroutineContext(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.coroutines.CoroutineContext> continuation) {
        return continuation.getContext();
    }

    public static final void ensureActive(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope) {
        kotlinx.coroutines.JobKt.ensureActive(coroutineScope.getCoroutineContext());
    }

    public static final boolean isActive(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope) {
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) coroutineScope.getCoroutineContext().get(kotlinx.coroutines.Job.INSTANCE);
        if (job == null) {
            return true;
        }
        return job.isActive();
    }

    public static /* synthetic */ void isActive$annotations(kotlinx.coroutines.CoroutineScope coroutineScope) {
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineScope plus(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        return new kotlinx.coroutines.internal.CoroutineScope(coroutineScope.getCoroutineContext().plus(coroutineContext));
    }
}
