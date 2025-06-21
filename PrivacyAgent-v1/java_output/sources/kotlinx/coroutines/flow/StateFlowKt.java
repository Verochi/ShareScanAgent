package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\b\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a6\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0000\"\u001a\u0010\u0016\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0014\u0010\u0015\"\u001a\u0010\u0019\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u0012\u0004\b\u0018\u0010\u0015¨\u0006\u001a"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlinx/coroutines/flow/MutableStateFlow;", "MutableStateFlow", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "", "delta", "", "increment", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuseStateFlow", "Lkotlinx/coroutines/internal/Symbol;", "a", "Lkotlinx/coroutines/internal/Symbol;", "getNONE$annotations", "()V", "NONE", "b", "getPENDING$annotations", "PENDING", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class StateFlowKt {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol a = new kotlinx.coroutines.internal.Symbol("NONE");

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol b = new kotlinx.coroutines.internal.Symbol("PENDING");

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.MutableStateFlow<T> MutableStateFlow(T t) {
        if (t == null) {
            t = (T) kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL;
        }
        return new kotlinx.coroutines.flow.StateFlowImpl(t);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> fuseStateFlow(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.StateFlow<? extends T> stateFlow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, int i, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BufferOverflow bufferOverflow) {
        boolean z = false;
        if (i >= 0 && i <= 1) {
            z = true;
        }
        return ((z || i == -2) && bufferOverflow == kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST) ? stateFlow : kotlinx.coroutines.flow.SharedFlowKt.fuseSharedFlow(stateFlow, coroutineContext, i, bufferOverflow);
    }

    public static final void increment(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> mutableStateFlow, int i) {
        int intValue;
        do {
            intValue = mutableStateFlow.getValue().intValue();
        } while (!mutableStateFlow.compareAndSet(java.lang.Integer.valueOf(intValue), java.lang.Integer.valueOf(intValue + i)));
    }
}
