package kotlinx.coroutines.channels;

@kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 1, 1}, l = {113, 116}, m = "lastOrNull", n = {"iterator", "iterator", "last"}, s = {"L$1", "L$1", "L$2"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$lastOrNull$1<E> extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    int label;
    /* synthetic */ java.lang.Object result;

    public ChannelsKt__DeprecatedKt$lastOrNull$1(kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object D;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        D = kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.D(null, this);
        return D;
    }
}
