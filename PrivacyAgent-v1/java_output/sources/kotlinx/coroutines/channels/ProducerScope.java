package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/SendChannel;", "channel", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
@kotlinx.coroutines.ExperimentalCoroutinesApi
/* loaded from: classes16.dex */
public interface ProducerScope<E> extends kotlinx.coroutines.CoroutineScope, kotlinx.coroutines.channels.SendChannel<E> {

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Deprecated in the favour of 'trySend' method", replaceWith = @kotlin.ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean offer(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope<? super E> producerScope, E e) {
            return kotlinx.coroutines.channels.SendChannel.DefaultImpls.offer(producerScope, e);
        }
    }

    @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.channels.SendChannel<E> getChannel();
}
