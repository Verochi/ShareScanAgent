package kotlinx.coroutines.flow.internal;

/* JADX INFO: Add missing generic type declarations: [T1] */
@kotlin.Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class CombineKt$zipImpl$1$1$2$invokeSuspend$$inlined$collect$1<T1> implements kotlinx.coroutines.flow.FlowCollector<T1> {
    public final /* synthetic */ kotlin.coroutines.CoroutineContext n;
    public final /* synthetic */ java.lang.Object t;
    public final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel u;
    public final /* synthetic */ kotlinx.coroutines.flow.FlowCollector v;
    public final /* synthetic */ kotlin.jvm.functions.Function3 w;

    public CombineKt$zipImpl$1$1$2$invokeSuspend$$inlined$collect$1(kotlin.coroutines.CoroutineContext coroutineContext, java.lang.Object obj, kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlinx.coroutines.flow.FlowCollector flowCollector, kotlin.jvm.functions.Function3 function3) {
        this.n = coroutineContext;
        this.t = obj;
        this.u = receiveChannel;
        this.v = flowCollector;
        this.w = function3;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @org.jetbrains.annotations.Nullable
    public java.lang.Object emit(T1 t1, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object coroutine_suspended;
        kotlin.coroutines.CoroutineContext coroutineContext = this.n;
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        java.lang.Object withContextUndispatched = kotlinx.coroutines.flow.internal.ChannelFlowKt.withContextUndispatched(coroutineContext, unit, this.t, new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1(this.u, this.v, this.w, t1, null), continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContextUndispatched == coroutine_suspended ? withContextUndispatched : unit;
    }
}
