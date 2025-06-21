package kotlinx.coroutines.flow.internal;

@kotlin.Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0005\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tH\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0080\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"unsafeFlow", "Lkotlinx/coroutines/flow/Flow;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "checkContext", "Lkotlinx/coroutines/flow/internal/SafeCollector;", "currentContext", "Lkotlin/coroutines/CoroutineContext;", "transitiveCoroutineParent", "Lkotlinx/coroutines/Job;", "collectJob", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class SafeCollector_commonKt {
    @kotlin.jvm.JvmName(name = "checkContext")
    public static final void checkContext(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.internal.SafeCollector<?> safeCollector, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        if (((java.lang.Number) coroutineContext.fold(0, new kotlinx.coroutines.flow.internal.SafeCollector_commonKt$checkContext$result$1(safeCollector))).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new java.lang.IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    @org.jetbrains.annotations.Nullable
    public static final kotlinx.coroutines.Job transitiveCoroutineParent(@org.jetbrains.annotations.Nullable kotlinx.coroutines.Job job, @org.jetbrains.annotations.Nullable kotlinx.coroutines.Job job2) {
        while (job != null) {
            if (job == job2 || !(job instanceof kotlinx.coroutines.internal.ScopeCoroutine)) {
                return job;
            }
            job = ((kotlinx.coroutines.internal.ScopeCoroutine) job).getParent$kotlinx_coroutines_core();
        }
        return null;
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> unsafeFlow(@kotlin.BuilderInference @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        return new kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1(function2);
    }
}
