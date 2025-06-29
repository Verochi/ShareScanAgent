package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0014\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J-\u0010\u000f\u001a\u00020\u00102#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00100\u0012H'J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b2\u0006\u0010\u0016\u001a\u00028\u0000H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007R$\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/SendChannel;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "", "isClosedForSend", "", "isClosedForSend$annotations", "()V", "()Z", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "close", "cause", "", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public interface SendChannel<E> {

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean close$default(kotlinx.coroutines.channels.SendChannel sendChannel, java.lang.Throwable th, int i, java.lang.Object obj) {
            if (obj != null) {
                throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return sendChannel.close(th);
        }

        @kotlinx.coroutines.ExperimentalCoroutinesApi
        public static /* synthetic */ void isClosedForSend$annotations() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Deprecated in the favour of 'trySend' method", replaceWith = @kotlin.ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean offer(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.SendChannel<? super E> sendChannel, E e) {
            java.lang.Object mo766trySendJP2dKIU = sendChannel.mo766trySendJP2dKIU(e);
            if (kotlinx.coroutines.channels.ChannelResult.m781isSuccessimpl(mo766trySendJP2dKIU)) {
                return true;
            }
            java.lang.Throwable m775exceptionOrNullimpl = kotlinx.coroutines.channels.ChannelResult.m775exceptionOrNullimpl(mo766trySendJP2dKIU);
            if (m775exceptionOrNullimpl == null) {
                return false;
            }
            throw kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverStackTrace(m775exceptionOrNullimpl);
        }
    }

    boolean close(@org.jetbrains.annotations.Nullable java.lang.Throwable cause);

    @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.selects.SelectClause2<E, kotlinx.coroutines.channels.SendChannel<E>> getOnSend();

    @kotlinx.coroutines.ExperimentalCoroutinesApi
    void invokeOnClose(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler);

    boolean isClosedForSend();

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Deprecated in the favour of 'trySend' method", replaceWith = @kotlin.ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    boolean offer(E element);

    @org.jetbrains.annotations.Nullable
    java.lang.Object send(E e, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);

    @org.jetbrains.annotations.NotNull
    /* renamed from: trySend-JP2dKIU */
    java.lang.Object mo766trySendJP2dKIU(E element);
}
