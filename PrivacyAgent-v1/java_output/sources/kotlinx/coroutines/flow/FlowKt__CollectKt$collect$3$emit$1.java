package kotlinx.coroutines.flow;

@kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class FlowKt__CollectKt$collect$3$emit$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    int label;
    /* synthetic */ java.lang.Object result;
    final /* synthetic */ kotlinx.coroutines.flow.FlowKt__CollectKt$collect$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__CollectKt$collect$3$emit$1(kotlinx.coroutines.flow.FlowKt__CollectKt$collect$3 flowKt__CollectKt$collect$3, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.FlowKt__CollectKt$collect$3$emit$1> continuation) {
        super(continuation);
        this.this$0 = flowKt__CollectKt$collect$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
