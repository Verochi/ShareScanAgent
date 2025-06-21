package kotlinx.coroutines.sync;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000\u001aD\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\"\u001a\u0010\u0010\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u0012\u0004\b\u000e\u0010\u000f\"\u001a\u0010\u0013\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u0012\u0004\b\u0012\u0010\u000f\"\u001a\u0010\u0016\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u0012\u0004\b\u0015\u0010\u000f\"\u001a\u0010\u0019\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u0012\u0004\b\u0018\u0010\u000f\"\u001a\u0010\u001c\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001a\u0010\r\u0012\u0004\b\u001b\u0010\u000f\"\u001a\u0010!\u001a\u00020\u001d8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b \u0010\u000f\"\u001a\u0010$\u001a\u00020\u001d8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\"\u0010\u001f\u0012\u0004\b#\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"", "locked", "Lkotlinx/coroutines/sync/Mutex;", "Mutex", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "owner", "Lkotlin/Function0;", "action", "withLock", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "a", "Lkotlinx/coroutines/internal/Symbol;", "getLOCK_FAIL$annotations", "()V", "LOCK_FAIL", "b", "getUNLOCK_FAIL$annotations", "UNLOCK_FAIL", "c", "getSELECT_SUCCESS$annotations", "SELECT_SUCCESS", "d", "getLOCKED$annotations", "LOCKED", "e", "getUNLOCKED$annotations", "UNLOCKED", "Lkotlinx/coroutines/sync/Empty;", "f", "Lkotlinx/coroutines/sync/Empty;", "getEMPTY_LOCKED$annotations", "EMPTY_LOCKED", "g", "getEMPTY_UNLOCKED$annotations", "EMPTY_UNLOCKED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class MutexKt {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol a = new kotlinx.coroutines.internal.Symbol("LOCK_FAIL");

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol b = new kotlinx.coroutines.internal.Symbol("UNLOCK_FAIL");

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol c = new kotlinx.coroutines.internal.Symbol("SELECT_SUCCESS");

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol d;

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol e;

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.sync.Empty f;

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.sync.Empty g;

    static {
        kotlinx.coroutines.internal.Symbol symbol = new kotlinx.coroutines.internal.Symbol("LOCKED");
        d = symbol;
        kotlinx.coroutines.internal.Symbol symbol2 = new kotlinx.coroutines.internal.Symbol("UNLOCKED");
        e = symbol2;
        f = new kotlinx.coroutines.sync.Empty(symbol);
        g = new kotlinx.coroutines.sync.Empty(symbol2);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.sync.Mutex Mutex(boolean z) {
        return new kotlinx.coroutines.sync.MutexImpl(z);
    }

    public static /* synthetic */ kotlinx.coroutines.sync.Mutex Mutex$default(boolean z, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return Mutex(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object withLock(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.Mutex mutex, @org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> function0, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.sync.MutexKt$withLock$1 mutexKt$withLock$1;
        java.lang.Object coroutine_suspended;
        int i;
        try {
            if (continuation instanceof kotlinx.coroutines.sync.MutexKt$withLock$1) {
                mutexKt$withLock$1 = (kotlinx.coroutines.sync.MutexKt$withLock$1) continuation;
                int i2 = mutexKt$withLock$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    mutexKt$withLock$1.label = i2 - Integer.MIN_VALUE;
                    java.lang.Object obj2 = mutexKt$withLock$1.result;
                    coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = mutexKt$withLock$1.label;
                    if (i != 0) {
                        kotlin.ResultKt.throwOnFailure(obj2);
                        mutexKt$withLock$1.L$0 = mutex;
                        mutexKt$withLock$1.L$1 = obj;
                        mutexKt$withLock$1.L$2 = function0;
                        mutexKt$withLock$1.label = 1;
                        if (mutex.lock(obj, mutexKt$withLock$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        function0 = (kotlin.jvm.functions.Function0) mutexKt$withLock$1.L$2;
                        obj = mutexKt$withLock$1.L$1;
                        mutex = (kotlinx.coroutines.sync.Mutex) mutexKt$withLock$1.L$0;
                        kotlin.ResultKt.throwOnFailure(obj2);
                    }
                    return function0.invoke();
                }
            }
            return function0.invoke();
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            mutex.unlock(obj);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
        mutexKt$withLock$1 = new kotlinx.coroutines.sync.MutexKt$withLock$1(continuation);
        java.lang.Object obj22 = mutexKt$withLock$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = mutexKt$withLock$1.label;
        if (i != 0) {
        }
    }

    public static /* synthetic */ java.lang.Object withLock$default(kotlinx.coroutines.sync.Mutex mutex, java.lang.Object obj, kotlin.jvm.functions.Function0 function0, kotlin.coroutines.Continuation continuation, int i, java.lang.Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        kotlin.jvm.internal.InlineMarker.mark(0);
        mutex.lock(obj, continuation);
        kotlin.jvm.internal.InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            mutex.unlock(obj);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }
}
