package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a%\u0010\u0000\u001a\u00020\u00012\u001a\b\u0004\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0086\b\u001a\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0000¨\u0006\r"}, d2 = {"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class CoroutineExceptionHandlerKt {
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineExceptionHandler CoroutineExceptionHandler(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlin.coroutines.CoroutineContext, ? super java.lang.Throwable, kotlin.Unit> function2) {
        return new kotlinx.coroutines.CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1(function2, kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE);
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    public static final void handleCoroutineException(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull java.lang.Throwable th) {
        try {
            kotlinx.coroutines.CoroutineExceptionHandler coroutineExceptionHandler = (kotlinx.coroutines.CoroutineExceptionHandler) coroutineContext.get(kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE);
            if (coroutineExceptionHandler == null) {
                kotlinx.coroutines.CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(coroutineContext, th);
            } else {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            }
        } catch (java.lang.Throwable th2) {
            kotlinx.coroutines.CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(coroutineContext, handlerException(th, th2));
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Throwable handlerException(@org.jetbrains.annotations.NotNull java.lang.Throwable th, @org.jetbrains.annotations.NotNull java.lang.Throwable th2) {
        if (th == th2) {
            return th;
        }
        java.lang.RuntimeException runtimeException = new java.lang.RuntimeException("Exception while trying to handle coroutine exception", th2);
        kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(runtimeException, th);
        return runtimeException;
    }
}
