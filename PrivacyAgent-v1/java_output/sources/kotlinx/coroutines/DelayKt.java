package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a!\u0010\u0000\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0087@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\n*\u00020\rH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class DelayKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object awaitCancellation(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.DelayKt$awaitCancellation$1 delayKt$awaitCancellation$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended2;
        if (continuation instanceof kotlinx.coroutines.DelayKt$awaitCancellation$1) {
            delayKt$awaitCancellation$1 = (kotlinx.coroutines.DelayKt$awaitCancellation$1) continuation;
            int i2 = delayKt$awaitCancellation$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                delayKt$awaitCancellation$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = delayKt$awaitCancellation$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = delayKt$awaitCancellation$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    delayKt$awaitCancellation$1.label = 1;
                    intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(delayKt$awaitCancellation$1);
                    kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(intercepted, 1);
                    cancellableContinuationImpl.initCancellability();
                    java.lang.Object result = cancellableContinuationImpl.getResult();
                    coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (result == coroutine_suspended2) {
                        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(delayKt$awaitCancellation$1);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                throw new kotlin.KotlinNothingValueException();
            }
        }
        delayKt$awaitCancellation$1 = new kotlinx.coroutines.DelayKt$awaitCancellation$1(continuation);
        java.lang.Object obj2 = delayKt$awaitCancellation$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = delayKt$awaitCancellation$1.label;
        if (i != 0) {
        }
        throw new kotlin.KotlinNothingValueException();
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object delay(long j, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        if (j <= 0) {
            return kotlin.Unit.INSTANCE;
        }
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (j < Long.MAX_VALUE) {
            getDelay(cancellableContinuationImpl.getN()).scheduleResumeAfterDelay(j, cancellableContinuationImpl);
        }
        java.lang.Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return result == coroutine_suspended2 ? result : kotlin.Unit.INSTANCE;
    }

    @kotlin.time.ExperimentalTime
    @org.jetbrains.annotations.Nullable
    /* renamed from: delay-VtjQ1oo, reason: not valid java name */
    public static final java.lang.Object m755delayVtjQ1oo(long j, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object coroutine_suspended;
        java.lang.Object delay = delay(m756toDelayMillisLRDsOJo(j), continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return delay == coroutine_suspended ? delay : kotlin.Unit.INSTANCE;
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.Delay getDelay(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        kotlin.coroutines.CoroutineContext.Element element = coroutineContext.get(kotlin.coroutines.ContinuationInterceptor.INSTANCE);
        kotlinx.coroutines.Delay delay = element instanceof kotlinx.coroutines.Delay ? (kotlinx.coroutines.Delay) element : null;
        return delay == null ? kotlinx.coroutines.DefaultExecutorKt.getDefaultDelay() : delay;
    }

    @kotlin.time.ExperimentalTime
    /* renamed from: toDelayMillis-LRDsOJo, reason: not valid java name */
    public static final long m756toDelayMillisLRDsOJo(long j) {
        long coerceAtLeast;
        if (kotlin.time.Duration.m629compareToLRDsOJo(j, kotlin.time.Duration.INSTANCE.m706getZEROUwyO8pc()) <= 0) {
            return 0L;
        }
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(kotlin.time.Duration.m672toLongMillisecondsimpl(j), 1L);
        return coerceAtLeast;
    }
}
