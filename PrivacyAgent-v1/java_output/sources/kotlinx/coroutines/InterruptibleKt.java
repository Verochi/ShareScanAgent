package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a1\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function0;", "block", "runInterruptible", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coroutineContext", "a", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class InterruptibleKt {
    public static final <T> T a(kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function0<? extends T> function0) {
        try {
            kotlinx.coroutines.ThreadState threadState = new kotlinx.coroutines.ThreadState(kotlinx.coroutines.JobKt.getJob(coroutineContext));
            threadState.d();
            try {
                return function0.invoke();
            } finally {
                threadState.a();
            }
        } catch (java.lang.InterruptedException e) {
            throw new java.util.concurrent.CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
        }
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object runInterruptible(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> function0, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        return kotlinx.coroutines.BuildersKt.withContext(coroutineContext, new kotlinx.coroutines.InterruptibleKt$runInterruptible$2(function0, null), continuation);
    }

    public static /* synthetic */ java.lang.Object runInterruptible$default(kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function0 function0, kotlin.coroutines.Continuation continuation, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
        }
        return runInterruptible(coroutineContext, function0, continuation);
    }
}
