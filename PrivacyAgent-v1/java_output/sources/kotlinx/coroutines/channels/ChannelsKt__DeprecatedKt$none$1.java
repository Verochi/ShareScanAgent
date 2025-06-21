package kotlinx.coroutines.channels;

@kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {}, l = {381}, m = "none", n = {}, s = {})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$none$1<E> extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    java.lang.Object L$0;
    int label;
    /* synthetic */ java.lang.Object result;

    public ChannelsKt__DeprecatedKt$none$1(kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object O;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        O = kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.O(null, this);
        return O;
    }
}
