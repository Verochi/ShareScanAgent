package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aV\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/BuildersKt")
/* loaded from: classes15.dex */
public final /* synthetic */ class BuildersKt__BuildersKt {
    public static final <T> T a(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2) throws java.lang.InterruptedException {
        kotlinx.coroutines.EventLoop currentOrNull$kotlinx_coroutines_core;
        kotlin.coroutines.CoroutineContext newCoroutineContext;
        java.lang.Thread currentThread = java.lang.Thread.currentThread();
        kotlin.coroutines.ContinuationInterceptor continuationInterceptor = (kotlin.coroutines.ContinuationInterceptor) coroutineContext.get(kotlin.coroutines.ContinuationInterceptor.INSTANCE);
        if (continuationInterceptor == null) {
            currentOrNull$kotlinx_coroutines_core = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            newCoroutineContext = kotlinx.coroutines.CoroutineContextKt.newCoroutineContext(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext.plus(currentOrNull$kotlinx_coroutines_core));
        } else {
            kotlinx.coroutines.EventLoop eventLoop = null;
            kotlinx.coroutines.EventLoop eventLoop2 = continuationInterceptor instanceof kotlinx.coroutines.EventLoop ? (kotlinx.coroutines.EventLoop) continuationInterceptor : null;
            if (eventLoop2 != null && eventLoop2.shouldBeProcessedFromContext()) {
                eventLoop = eventLoop2;
            }
            currentOrNull$kotlinx_coroutines_core = eventLoop == null ? kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core() : eventLoop;
            newCoroutineContext = kotlinx.coroutines.CoroutineContextKt.newCoroutineContext(kotlinx.coroutines.GlobalScope.INSTANCE, coroutineContext);
        }
        kotlinx.coroutines.BlockingCoroutine blockingCoroutine = new kotlinx.coroutines.BlockingCoroutine(newCoroutineContext, currentThread, currentOrNull$kotlinx_coroutines_core);
        blockingCoroutine.start(kotlinx.coroutines.CoroutineStart.DEFAULT, blockingCoroutine, function2);
        return (T) blockingCoroutine.D();
    }

    public static /* synthetic */ java.lang.Object b(kotlin.coroutines.CoroutineContext coroutineContext, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) throws java.lang.InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
        }
        return kotlinx.coroutines.BuildersKt.runBlocking(coroutineContext, function2);
    }
}
