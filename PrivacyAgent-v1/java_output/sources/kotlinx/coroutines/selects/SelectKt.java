package kotlinx.coroutines.selects;

@kotlin.Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aN\u0010\u000b\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001aG\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\b\fH\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u000e\u0010\u000f\" \u0010\u0016\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\" \u0010\u001a\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u0012\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0018\u0010\u0013\"\u001a\u0010\u001d\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u0012\u0004\b\u001c\u0010\u0015\"\u001a\u0010 \u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u0012\u0004\b\u001f\u0010\u0015\"\u001a\u0010%\u001a\u00020!8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\"\u0010#\u0012\u0004\b$\u0010\u0015\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"R", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlin/time/Duration;", "timeout", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "", "onTimeout-8Mi8wO0", "(Lkotlinx/coroutines/selects/SelectBuilder;JLkotlin/jvm/functions/Function1;)V", "onTimeout", "Lkotlin/ExtensionFunctionType;", "builder", "select", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Ljava/lang/Object;", "getNOT_SELECTED", "()Ljava/lang/Object;", "getNOT_SELECTED$annotations", "()V", "NOT_SELECTED", "b", "getALREADY_SELECTED", "getALREADY_SELECTED$annotations", "ALREADY_SELECTED", "c", "getUNDECIDED$annotations", "UNDECIDED", "d", "getRESUMED$annotations", "RESUMED", "Lkotlinx/coroutines/selects/SeqNumber;", "e", "Lkotlinx/coroutines/selects/SeqNumber;", "getSelectOpSequenceNumber$annotations", "selectOpSequenceNumber", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class SelectKt {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object a = new kotlinx.coroutines.internal.Symbol("NOT_SELECTED");

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object b = new kotlinx.coroutines.internal.Symbol("ALREADY_SELECTED");

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object c = new kotlinx.coroutines.internal.Symbol("UNDECIDED");

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object d = new kotlinx.coroutines.internal.Symbol("RESUMED");

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.selects.SeqNumber e = new kotlinx.coroutines.selects.SeqNumber();

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object getALREADY_SELECTED() {
        return b;
    }

    public static /* synthetic */ void getALREADY_SELECTED$annotations() {
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object getNOT_SELECTED() {
        return a;
    }

    public static /* synthetic */ void getNOT_SELECTED$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.time.ExperimentalTime
    @kotlinx.coroutines.ExperimentalCoroutinesApi
    /* renamed from: onTimeout-8Mi8wO0, reason: not valid java name */
    public static final <R> void m815onTimeout8Mi8wO0(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectBuilder<? super R> selectBuilder, long j, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function1) {
        selectBuilder.onTimeout(kotlinx.coroutines.DelayKt.m756toDelayMillisLRDsOJo(j), function1);
    }

    @org.jetbrains.annotations.Nullable
    public static final <R> java.lang.Object select(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.selects.SelectBuilder<? super R>, kotlin.Unit> function1, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> continuation) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.selects.SelectInstance selectInstance = new kotlinx.coroutines.selects.SelectInstance(continuation);
        try {
            function1.invoke(selectInstance);
        } catch (java.lang.Throwable th) {
            selectInstance.handleBuilderException(th);
        }
        java.lang.Object result = selectInstance.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
