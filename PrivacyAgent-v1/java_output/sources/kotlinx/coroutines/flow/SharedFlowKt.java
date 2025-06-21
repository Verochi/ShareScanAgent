package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a%\u0010\f\u001a\u0004\u0018\u00010\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\r\u001a-\u0010\u0010\u001a\u00020\u000f*\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a6\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\"\u001a\u0010\u0019\u001a\u00020\u00188\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "replay", "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "MutableSharedFlow", "", "", "", "index", "a", "([Ljava/lang/Object;J)Ljava/lang/Object;", "item", "", "b", "([Ljava/lang/Object;JLjava/lang/Object;)V", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/flow/Flow;", "fuseSharedFlow", "Lkotlinx/coroutines/internal/Symbol;", "NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;", "getNO_VALUE$annotations", "()V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class SharedFlowKt {

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol NO_VALUE = new kotlinx.coroutines.internal.Symbol("NO_VALUE");

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.MutableSharedFlow<T> MutableSharedFlow(int i, int i2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BufferOverflow bufferOverflow) {
        boolean z = true;
        if (!(i >= 0)) {
            throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("replay cannot be negative, but was ", java.lang.Integer.valueOf(i)).toString());
        }
        if (!(i2 >= 0)) {
            throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("extraBufferCapacity cannot be negative, but was ", java.lang.Integer.valueOf(i2)).toString());
        }
        if (i <= 0 && i2 <= 0 && bufferOverflow != kotlinx.coroutines.channels.BufferOverflow.SUSPEND) {
            z = false;
        }
        if (!z) {
            throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ", bufferOverflow).toString());
        }
        int i3 = i2 + i;
        if (i3 < 0) {
            i3 = Integer.MAX_VALUE;
        }
        return new kotlinx.coroutines.flow.SharedFlowImpl(i, i3, bufferOverflow);
    }

    public static /* synthetic */ kotlinx.coroutines.flow.MutableSharedFlow MutableSharedFlow$default(int i, int i2, kotlinx.coroutines.channels.BufferOverflow bufferOverflow, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            bufferOverflow = kotlinx.coroutines.channels.BufferOverflow.SUSPEND;
        }
        return MutableSharedFlow(i, i2, bufferOverflow);
    }

    public static final java.lang.Object a(java.lang.Object[] objArr, long j) {
        return objArr[(objArr.length - 1) & ((int) j)];
    }

    public static final void b(java.lang.Object[] objArr, long j, java.lang.Object obj) {
        objArr[(objArr.length - 1) & ((int) j)] = obj;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> fuseSharedFlow(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.SharedFlow<? extends T> sharedFlow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, int i, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BufferOverflow bufferOverflow) {
        return ((i == 0 || i == -3) && bufferOverflow == kotlinx.coroutines.channels.BufferOverflow.SUSPEND) ? sharedFlow : new kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl(sharedFlow, coroutineContext, i, bufferOverflow);
    }

    public static /* synthetic */ void getNO_VALUE$annotations() {
    }
}
