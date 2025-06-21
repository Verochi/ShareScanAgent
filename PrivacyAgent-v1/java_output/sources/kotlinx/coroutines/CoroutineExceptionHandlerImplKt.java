package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\"\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleCoroutineExceptionImpl", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "a", "Ljava/util/List;", "handlers", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class CoroutineExceptionHandlerImplKt {

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<kotlinx.coroutines.CoroutineExceptionHandler> a;

    static {
        kotlin.sequences.Sequence asSequence;
        asSequence = kotlin.sequences.SequencesKt__SequencesKt.asSequence(java.util.ServiceLoader.load(kotlinx.coroutines.CoroutineExceptionHandler.class, kotlinx.coroutines.CoroutineExceptionHandler.class.getClassLoader()).iterator());
        a = kotlin.sequences.SequencesKt___SequencesKt.toList(asSequence);
    }

    public static final void handleCoroutineExceptionImpl(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull java.lang.Throwable th) {
        java.util.Iterator<kotlinx.coroutines.CoroutineExceptionHandler> it = a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(coroutineContext, th);
            } catch (java.lang.Throwable th2) {
                java.lang.Thread currentThread = java.lang.Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, kotlinx.coroutines.CoroutineExceptionHandlerKt.handlerException(th, th2));
            }
        }
        java.lang.Thread currentThread2 = java.lang.Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
