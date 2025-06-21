package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class FlowLiveDataConversions$asFlow$1$observer$1<T> implements androidx.lifecycle.Observer {
    final /* synthetic */ kotlinx.coroutines.channels.Channel<T> $channel;

    public FlowLiveDataConversions$asFlow$1$observer$1(kotlinx.coroutines.channels.Channel<T> channel) {
        this.$channel = channel;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        this.$channel.mo766trySendJP2dKIU(t);
    }
}
