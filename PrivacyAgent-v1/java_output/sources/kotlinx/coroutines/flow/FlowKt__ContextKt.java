package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00020\t\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a[\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00022#\u0010\u0012\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u0010¢\u0006\u0002\b\u0011H\u0007\u001a\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "b", "a", "g", "Lkotlin/coroutines/CoroutineContext;", "context", "h", "e", "R", "flowContext", "bufferSize", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "builder", "i", "", "f", "(Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes16.dex */
final /* synthetic */ class FlowKt__ContextKt {
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ kotlinx.coroutines.flow.Flow a(kotlinx.coroutines.flow.Flow flow, int i) {
        return d(flow, i, null, 2, null);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, int i, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BufferOverflow bufferOverflow) {
        int i2;
        kotlinx.coroutines.channels.BufferOverflow bufferOverflow2;
        boolean z = true;
        if (!(i >= 0 || i == -2 || i == -1)) {
            throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ", java.lang.Integer.valueOf(i)).toString());
        }
        if (i == -1 && bufferOverflow != kotlinx.coroutines.channels.BufferOverflow.SUSPEND) {
            z = false;
        }
        if (!z) {
            throw new java.lang.IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i == -1) {
            bufferOverflow2 = kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST;
            i2 = 0;
        } else {
            i2 = i;
            bufferOverflow2 = bufferOverflow;
        }
        return flow instanceof kotlinx.coroutines.flow.internal.FusibleFlow ? kotlinx.coroutines.flow.internal.FusibleFlow.DefaultImpls.fuse$default((kotlinx.coroutines.flow.internal.FusibleFlow) flow, null, i2, bufferOverflow2, 1, null) : new kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl(flow, null, i2, bufferOverflow2, 2, null);
    }

    public static /* synthetic */ kotlinx.coroutines.flow.Flow c(kotlinx.coroutines.flow.Flow flow, int i, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        return a(flow, i);
    }

    public static /* synthetic */ kotlinx.coroutines.flow.Flow d(kotlinx.coroutines.flow.Flow flow, int i, kotlinx.coroutines.channels.BufferOverflow bufferOverflow, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = kotlinx.coroutines.channels.BufferOverflow.SUSPEND;
        }
        return kotlinx.coroutines.flow.FlowKt.buffer(flow, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        return flow instanceof kotlinx.coroutines.flow.CancellableFlow ? flow : new kotlinx.coroutines.flow.CancellableFlowImpl(flow);
    }

    public static final void f(kotlin.coroutines.CoroutineContext coroutineContext) {
        if (!(coroutineContext.get(kotlinx.coroutines.Job.INSTANCE) == null)) {
            throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("Flow context cannot contain job in it. Had ", coroutineContext).toString());
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> g(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow) {
        return d(flow, -1, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlinx.coroutines.flow.Flow<T> h(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        f(coroutineContext);
        return kotlin.jvm.internal.Intrinsics.areEqual(coroutineContext, kotlin.coroutines.EmptyCoroutineContext.INSTANCE) ? flow : flow instanceof kotlinx.coroutines.flow.internal.FusibleFlow ? kotlinx.coroutines.flow.internal.FusibleFlow.DefaultImpls.fuse$default((kotlinx.coroutines.flow.internal.FusibleFlow) flow, coroutineContext, 0, null, 6, null) : new kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl(flow, coroutineContext, 0, null, 12, null);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    @kotlinx.coroutines.FlowPreview
    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> i(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, int i, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.flow.Flow<? extends T>, ? extends kotlinx.coroutines.flow.Flow<? extends R>> function1) {
        f(coroutineContext);
        return new kotlinx.coroutines.flow.FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1(flow, i, function1, coroutineContext);
    }

    public static /* synthetic */ kotlinx.coroutines.flow.Flow j(kotlinx.coroutines.flow.Flow flow, kotlin.coroutines.CoroutineContext coroutineContext, int i, kotlin.jvm.functions.Function1 function1, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = -2;
        }
        return kotlinx.coroutines.flow.FlowKt.flowWith(flow, coroutineContext, i, function1);
    }
}
