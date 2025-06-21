package kotlinx.coroutines.sync;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000\u001a8\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\b\u0010\t\u001a\u001a\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002\"\u001a\u0010\u0012\u001a\u00020\u00008\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0017\u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0016\u0010\u0011\"\u001a\u0010\u001a\u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u0012\u0004\b\u0019\u0010\u0011\"\u001a\u0010\u001d\u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u0012\u0004\b\u001c\u0010\u0011\"\u001a\u0010 \u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u0012\u0004\b\u001f\u0010\u0011\"\u001a\u0010#\u001a\u00020\u00008\u0002X\u0083\u0004¢\u0006\f\n\u0004\b!\u0010\u000f\u0012\u0004\b\"\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"", "permits", "acquiredPermits", "Lkotlinx/coroutines/sync/Semaphore;", "Semaphore", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "action", "withPermit", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "id", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "prev", "a", "I", "getMAX_SPIN_CYCLES$annotations", "()V", "MAX_SPIN_CYCLES", "Lkotlinx/coroutines/internal/Symbol;", "b", "Lkotlinx/coroutines/internal/Symbol;", "getPERMIT$annotations", "PERMIT", "c", "getTAKEN$annotations", "TAKEN", "d", "getBROKEN$annotations", "BROKEN", "e", "getCANCELLED$annotations", "CANCELLED", "f", "getSEGMENT_SIZE$annotations", "SEGMENT_SIZE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class SemaphoreKt {
    public static final int a;

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol b;

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol c;

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol d;

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol e;
    public static final int f;

    static {
        int d2;
        int d3;
        d2 = kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        a = d2;
        b = new kotlinx.coroutines.internal.Symbol("PERMIT");
        c = new kotlinx.coroutines.internal.Symbol("TAKEN");
        d = new kotlinx.coroutines.internal.Symbol("BROKEN");
        e = new kotlinx.coroutines.internal.Symbol("CANCELLED");
        d3 = kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f = d3;
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.sync.Semaphore Semaphore(int i, int i2) {
        return new kotlinx.coroutines.sync.SemaphoreImpl(i, i2);
    }

    public static /* synthetic */ kotlinx.coroutines.sync.Semaphore Semaphore$default(int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return Semaphore(i, i2);
    }

    public static final kotlinx.coroutines.sync.SemaphoreSegment a(long j, kotlinx.coroutines.sync.SemaphoreSegment semaphoreSegment) {
        return new kotlinx.coroutines.sync.SemaphoreSegment(j, semaphoreSegment, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object withPermit(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.Semaphore semaphore, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> function0, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 semaphoreKt$withPermit$1;
        java.lang.Object coroutine_suspended;
        int i;
        try {
            if (continuation instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) {
                semaphoreKt$withPermit$1 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) continuation;
                int i2 = semaphoreKt$withPermit$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    semaphoreKt$withPermit$1.label = i2 - Integer.MIN_VALUE;
                    java.lang.Object obj = semaphoreKt$withPermit$1.result;
                    coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = semaphoreKt$withPermit$1.label;
                    if (i != 0) {
                        kotlin.ResultKt.throwOnFailure(obj);
                        semaphoreKt$withPermit$1.L$0 = semaphore;
                        semaphoreKt$withPermit$1.L$1 = function0;
                        semaphoreKt$withPermit$1.label = 1;
                        if (semaphore.acquire(semaphoreKt$withPermit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        function0 = (kotlin.jvm.functions.Function0) semaphoreKt$withPermit$1.L$1;
                        semaphore = (kotlinx.coroutines.sync.Semaphore) semaphoreKt$withPermit$1.L$0;
                        kotlin.ResultKt.throwOnFailure(obj);
                    }
                    return function0.invoke();
                }
            }
            return function0.invoke();
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            semaphore.release();
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
        semaphoreKt$withPermit$1 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1(continuation);
        java.lang.Object obj2 = semaphoreKt$withPermit$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = semaphoreKt$withPermit$1.label;
        if (i != 0) {
        }
    }
}
