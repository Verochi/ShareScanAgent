package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u001a6\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0080\b¢\u0006\u0004\b\u000b\u0010\f\u001a:\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0080\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a(\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0000\u001a\u0013\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012*\u00020\u0014H\u0080\u0010\"\u0014\u0010\u0017\u001a\u00020\u00168\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001e\u001a\u00020\u00198\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u001a\u0010!\u001a\u0004\u0018\u00010\u0016*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "newCoroutineContext", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "countOrElement", "Lkotlin/Function0;", "block", "withCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "continuation", "withContinuationContext", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "oldValue", "Lkotlinx/coroutines/UndispatchedCoroutine;", "updateUndispatchedCompletion", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "undispatchedCompletion", "", "COROUTINES_SCHEDULER_PROPERTY_NAME", "Ljava/lang/String;", "", "a", "Z", "getUseCoroutinesScheduler", "()Z", "useCoroutinesScheduler", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "coroutineName", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class CoroutineContextKt {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String COROUTINES_SCHEDULER_PROPERTY_NAME = "kotlinx.coroutines.scheduler";
    public static final boolean a;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
    
        if (r0.equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        if (r0.equals("") != false) goto L21;
     */
    static {
        boolean z;
        java.lang.String systemProp = kotlinx.coroutines.internal.SystemPropsKt.systemProp(COROUTINES_SCHEDULER_PROPERTY_NAME);
        if (systemProp != null) {
            int hashCode = systemProp.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    z = (hashCode == 109935 && systemProp.equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF)) ? false : true;
                }
                throw new java.lang.IllegalStateException(("System property 'kotlinx.coroutines.scheduler' has unrecognized value '" + ((java.lang.Object) systemProp) + '\'').toString());
            }
            a = z;
        }
        a = z;
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineDispatcher createDefaultDispatcher() {
        return a ? kotlinx.coroutines.scheduling.DefaultScheduler.INSTANCE : kotlinx.coroutines.CommonPool.INSTANCE;
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.String getCoroutineName(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        return null;
    }

    public static final boolean getUseCoroutinesScheduler() {
        return a;
    }

    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final kotlin.coroutines.CoroutineContext newCoroutineContext(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        kotlin.coroutines.CoroutineContext plus = coroutineScope.getCoroutineContext().plus(coroutineContext);
        return (plus == kotlinx.coroutines.Dispatchers.getDefault() || plus.get(kotlin.coroutines.ContinuationInterceptor.INSTANCE) != null) ? plus : plus.plus(kotlinx.coroutines.Dispatchers.getDefault());
    }

    @org.jetbrains.annotations.Nullable
    public static final kotlinx.coroutines.UndispatchedCoroutine<?> undispatchedCompletion(@org.jetbrains.annotations.NotNull kotlin.coroutines.jvm.internal.CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof kotlinx.coroutines.DispatchedCoroutine) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof kotlinx.coroutines.UndispatchedCoroutine) {
                return (kotlinx.coroutines.UndispatchedCoroutine) coroutineStackFrame;
            }
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static final kotlinx.coroutines.UndispatchedCoroutine<?> updateUndispatchedCompletion(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.Nullable java.lang.Object obj) {
        if (!(continuation instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame)) {
            return null;
        }
        if (!(coroutineContext.get(kotlinx.coroutines.UndispatchedMarker.n) != null)) {
            return null;
        }
        kotlinx.coroutines.UndispatchedCoroutine<?> undispatchedCompletion = undispatchedCompletion((kotlin.coroutines.jvm.internal.CoroutineStackFrame) continuation);
        if (undispatchedCompletion != null) {
            undispatchedCompletion.saveThreadContext(coroutineContext, obj);
        }
        return undispatchedCompletion;
    }

    public static final <T> T withContinuationContext(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation, @org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> function0) {
        kotlin.coroutines.CoroutineContext context = continuation.getContext();
        java.lang.Object updateThreadContext = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(context, obj);
        kotlinx.coroutines.UndispatchedCoroutine<?> updateUndispatchedCompletion = updateThreadContext != kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS ? updateUndispatchedCompletion(continuation, context, updateThreadContext) : null;
        try {
            return function0.invoke();
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static final <T> T withCoroutineContext(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> function0) {
        java.lang.Object updateThreadContext = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(coroutineContext, obj);
        try {
            return function0.invoke();
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }
}
