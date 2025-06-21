package kotlinx.coroutines.channels;

@kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 1}, l = {84, 88, 94, 96}, m = "fixedPeriodTicker", n = {"deadline", "delayNs"}, s = {"J$1", "J$1"})
/* loaded from: classes16.dex */
public final class TickerChannelsKt$fixedPeriodTicker$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    long J$0;
    long J$1;
    java.lang.Object L$0;
    int label;
    /* synthetic */ java.lang.Object result;

    public TickerChannelsKt$fixedPeriodTicker$1(kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object b;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        b = kotlinx.coroutines.channels.TickerChannelsKt.b(0L, 0L, null, this);
        return b;
    }
}
