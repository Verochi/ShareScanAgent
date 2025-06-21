package kotlinx.coroutines.flow.internal;

/* JADX INFO: Add missing generic type declarations: [T2] */
@kotlin.Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class CombineKt$zipImpl$1$1$second$1$invokeSuspend$$inlined$collect$1<T2> implements kotlinx.coroutines.flow.FlowCollector<T2> {
    public final /* synthetic */ kotlinx.coroutines.channels.ProducerScope n;

    public CombineKt$zipImpl$1$1$second$1$invokeSuspend$$inlined$collect$1(kotlinx.coroutines.channels.ProducerScope producerScope) {
        this.n = producerScope;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @org.jetbrains.annotations.Nullable
    public java.lang.Object emit(T2 t2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.channels.SendChannel channel = this.n.getChannel();
        if (t2 == null) {
            t2 = (T2) kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL;
        }
        java.lang.Object send = channel.send(t2, continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return send == coroutine_suspended ? send : kotlin.Unit.INSTANCE;
    }
}
