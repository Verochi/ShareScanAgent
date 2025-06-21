package kotlinx.coroutines.channels;

@kotlinx.coroutines.ObsoleteCoroutinesApi
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/channels/ActorScope;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channel", "Lkotlinx/coroutines/channels/Channel;", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public interface ActorScope<E> extends kotlinx.coroutines.CoroutineScope, kotlinx.coroutines.channels.ReceiveChannel<E> {

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        @org.jetbrains.annotations.NotNull
        public static <E> kotlinx.coroutines.selects.SelectClause1<E> getOnReceiveOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ActorScope<E> actorScope) {
            return kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.getOnReceiveOrNull(actorScope);
        }

        @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @kotlin.ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
        @org.jetbrains.annotations.Nullable
        public static <E> E poll(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ActorScope<E> actorScope) {
            return (E) kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.poll(actorScope);
        }

        @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @kotlin.ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
        @kotlin.internal.LowPriorityInOverloadResolution
        @org.jetbrains.annotations.Nullable
        public static <E> java.lang.Object receiveOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ActorScope<E> actorScope, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> continuation) {
            return kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.receiveOrNull(actorScope, continuation);
        }
    }

    @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.channels.Channel<E> getChannel();
}
