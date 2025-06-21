package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"BroadcastChannel", "Lkotlinx/coroutines/channels/BroadcastChannel;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "capacity", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class BroadcastChannelKt {
    @kotlinx.coroutines.ObsoleteCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final <E> kotlinx.coroutines.channels.BroadcastChannel<E> BroadcastChannel(int i) {
        if (i == -2) {
            return new kotlinx.coroutines.channels.ArrayBroadcastChannel(kotlinx.coroutines.channels.Channel.INSTANCE.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core());
        }
        if (i == -1) {
            return new kotlinx.coroutines.channels.ConflatedBroadcastChannel();
        }
        if (i == 0) {
            throw new java.lang.IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
        }
        if (i != Integer.MAX_VALUE) {
            return new kotlinx.coroutines.channels.ArrayBroadcastChannel(i);
        }
        throw new java.lang.IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
    }
}
