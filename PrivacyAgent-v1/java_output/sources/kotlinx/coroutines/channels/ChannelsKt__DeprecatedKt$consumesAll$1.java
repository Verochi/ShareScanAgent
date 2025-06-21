package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", "cause", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$consumesAll$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> {
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel<?>[] $channels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$consumesAll$1(kotlinx.coroutines.channels.ReceiveChannel<?>[] receiveChannelArr) {
        super(1);
        this.$channels = receiveChannelArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable th) {
        invoke2(th);
        return kotlin.Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Throwable th) {
        kotlinx.coroutines.channels.ReceiveChannel<?>[] receiveChannelArr = this.$channels;
        int length = receiveChannelArr.length;
        java.lang.Throwable th2 = null;
        int i = 0;
        while (i < length) {
            kotlinx.coroutines.channels.ReceiveChannel<?> receiveChannel = receiveChannelArr[i];
            i++;
            try {
                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, th);
            } catch (java.lang.Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(th2, th3);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
    }
}
