package kotlinx.coroutines.channels;

@kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 1}, l = {125, 128}, m = "single", n = {"iterator", "single"}, s = {"L$1", "L$1"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$single$1<E> extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    java.lang.Object L$0;
    java.lang.Object L$1;
    int label;
    /* synthetic */ java.lang.Object result;

    public ChannelsKt__DeprecatedKt$single$1(kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object Q;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Q = kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.Q(null, this);
        return Q;
    }
}
