package kotlinx.coroutines.channels;

@kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", i = {}, l = {632}, m = "receiveCatching-JP2dKIU", n = {}, s = {})
/* loaded from: classes16.dex */
public final class AbstractChannel$receiveCatching$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    int label;
    /* synthetic */ java.lang.Object result;
    final /* synthetic */ kotlinx.coroutines.channels.AbstractChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractChannel$receiveCatching$1(kotlinx.coroutines.channels.AbstractChannel<E> abstractChannel, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1> continuation) {
        super(continuation);
        this.this$0 = abstractChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        java.lang.Object mo764receiveCatchingJP2dKIU = this.this$0.mo764receiveCatchingJP2dKIU(this);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return mo764receiveCatchingJP2dKIU == coroutine_suspended ? mo764receiveCatchingJP2dKIU : kotlinx.coroutines.channels.ChannelResult.m771boximpl(mo764receiveCatchingJP2dKIU);
    }
}
