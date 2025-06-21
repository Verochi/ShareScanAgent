package kotlinx.coroutines.flow.internal;

@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H¤@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0094@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\bJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J)\u0010\u0012\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "flowCollect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ProducerScope;", com.tencent.connect.common.Constants.PARAM_SCOPE, "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collect", "", "toString", "Lkotlin/coroutines/CoroutineContext;", "newContext", "d", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", com.alimm.tanx.core.constant.TanxAdType.FEED_STRING, "Lkotlinx/coroutines/flow/Flow;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public abstract class ChannelFlowOperator<S, T> extends kotlinx.coroutines.flow.internal.ChannelFlow<T> {

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    protected final kotlinx.coroutines.flow.Flow<S> flow;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends S> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, int i, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.flow = flow;
    }

    public static /* synthetic */ java.lang.Object b(kotlinx.coroutines.flow.internal.ChannelFlowOperator channelFlowOperator, kotlinx.coroutines.flow.FlowCollector flowCollector, kotlin.coroutines.Continuation continuation) {
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        java.lang.Object coroutine_suspended3;
        if (channelFlowOperator.capacity == -3) {
            kotlin.coroutines.CoroutineContext context = continuation.getContext();
            kotlin.coroutines.CoroutineContext plus = context.plus(channelFlowOperator.context);
            if (kotlin.jvm.internal.Intrinsics.areEqual(plus, context)) {
                java.lang.Object flowCollect = channelFlowOperator.flowCollect(flowCollector, continuation);
                coroutine_suspended3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return flowCollect == coroutine_suspended3 ? flowCollect : kotlin.Unit.INSTANCE;
            }
            kotlin.coroutines.ContinuationInterceptor.Companion companion = kotlin.coroutines.ContinuationInterceptor.INSTANCE;
            if (kotlin.jvm.internal.Intrinsics.areEqual(plus.get(companion), context.get(companion))) {
                java.lang.Object d = channelFlowOperator.d(flowCollector, plus, continuation);
                coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return d == coroutine_suspended2 ? d : kotlin.Unit.INSTANCE;
            }
        }
        java.lang.Object collect = super.collect(flowCollector, continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return collect == coroutine_suspended ? collect : kotlin.Unit.INSTANCE;
    }

    public static /* synthetic */ java.lang.Object c(kotlinx.coroutines.flow.internal.ChannelFlowOperator channelFlowOperator, kotlinx.coroutines.channels.ProducerScope producerScope, kotlin.coroutines.Continuation continuation) {
        java.lang.Object coroutine_suspended;
        java.lang.Object flowCollect = channelFlowOperator.flowCollect(new kotlinx.coroutines.flow.internal.SendingCollector(producerScope), continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return flowCollect == coroutine_suspended ? flowCollect : kotlin.Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    @org.jetbrains.annotations.Nullable
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return b(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @org.jetbrains.annotations.Nullable
    public java.lang.Object collectTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope<? super T> producerScope, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return c(this, producerScope, continuation);
    }

    public final java.lang.Object d(kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, kotlin.coroutines.CoroutineContext coroutineContext, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.flow.FlowCollector a;
        java.lang.Object coroutine_suspended;
        a = kotlinx.coroutines.flow.internal.ChannelFlowKt.a(flowCollector, continuation.getContext());
        java.lang.Object withContextUndispatched$default = kotlinx.coroutines.flow.internal.ChannelFlowKt.withContextUndispatched$default(coroutineContext, a, null, new kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation, 4, null);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContextUndispatched$default == coroutine_suspended ? withContextUndispatched$default : kotlin.Unit.INSTANCE;
    }

    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object flowCollect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return this.flow + " -> " + super.toString();
    }
}
