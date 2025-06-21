package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a.\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/SendChannel;", "element", "", "a", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/ChannelResult;", "b", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes16.dex */
final /* synthetic */ class ChannelsKt__ChannelsKt {
    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @kotlin.ReplaceWith(expression = "trySendBlocking(element)", imports = {}))
    public static final <E> void a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.SendChannel<? super E> sendChannel, E e) {
        if (kotlinx.coroutines.channels.ChannelResult.m781isSuccessimpl(sendChannel.mo766trySendJP2dKIU(e))) {
            return;
        }
        kotlinx.coroutines.BuildersKt__BuildersKt.b(null, new kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1(sendChannel, e, null), 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public static final <E> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.SendChannel<? super E> sendChannel, E e) throws java.lang.InterruptedException {
        java.lang.Object b;
        java.lang.Object mo766trySendJP2dKIU = sendChannel.mo766trySendJP2dKIU(e);
        if (mo766trySendJP2dKIU instanceof kotlinx.coroutines.channels.ChannelResult.Failed) {
            b = kotlinx.coroutines.BuildersKt__BuildersKt.b(null, new kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2(sendChannel, e, null), 1, null);
            return ((kotlinx.coroutines.channels.ChannelResult) b).getHolder();
        }
        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m786successJP2dKIU(kotlin.Unit.INSTANCE);
    }
}
