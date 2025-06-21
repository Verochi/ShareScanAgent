package kotlinx.coroutines.channels;

@kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {369, 371}, m = "minWith", n = {"comparator", "iterator", "iterator", org.apache.tools.ant.types.selectors.DepthSelector.MIN_KEY}, s = {"L$0", "L$2", "L$2", "L$3"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$minWith$1<E> extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    java.lang.Object L$3;
    int label;
    /* synthetic */ java.lang.Object result;

    public ChannelsKt__DeprecatedKt$minWith$1(kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object N;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        N = kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.N(null, null, this);
        return N;
    }
}
