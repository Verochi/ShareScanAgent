package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u001aX\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u000b0\bH\u0086\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a^\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0016\u0010\u0013\u001a^\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0017\u0010\u0013\u001a\\\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u001a\u0010\u0013\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Channel", "Lkotlinx/coroutines/channels/Channel;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "getOrElse", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ChannelResult;", "onFailure", "", "Lkotlin/ParameterName;", "name", "exception", "getOrElse-WpGqRn0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onClosed", "action", "onClosed-WpGqRn0", "onFailure-WpGqRn0", "onSuccess", "value", "onSuccess-WpGqRn0", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ChannelKt {
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ kotlinx.coroutines.channels.Channel Channel(int i) {
        return Channel$default(i, null, null, 6, null);
    }

    @org.jetbrains.annotations.NotNull
    public static final <E> kotlinx.coroutines.channels.Channel<E> Channel(int i, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BufferOverflow bufferOverflow, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super E, kotlin.Unit> function1) {
        if (i == -2) {
            return new kotlinx.coroutines.channels.ArrayChannel(bufferOverflow == kotlinx.coroutines.channels.BufferOverflow.SUSPEND ? kotlinx.coroutines.channels.Channel.INSTANCE.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core() : 1, bufferOverflow, function1);
        }
        if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? (i == 1 && bufferOverflow == kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST) ? new kotlinx.coroutines.channels.ConflatedChannel(function1) : new kotlinx.coroutines.channels.ArrayChannel(i, bufferOverflow, function1) : new kotlinx.coroutines.channels.LinkedListChannel(function1) : bufferOverflow == kotlinx.coroutines.channels.BufferOverflow.SUSPEND ? new kotlinx.coroutines.channels.RendezvousChannel(function1) : new kotlinx.coroutines.channels.ArrayChannel(1, bufferOverflow, function1);
        }
        if ((bufferOverflow != kotlinx.coroutines.channels.BufferOverflow.SUSPEND ? 0 : 1) != 0) {
            return new kotlinx.coroutines.channels.ConflatedChannel(function1);
        }
        throw new java.lang.IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    }

    public static /* synthetic */ kotlinx.coroutines.channels.Channel Channel$default(int i, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return Channel(i);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.Channel Channel$default(int i, kotlinx.coroutines.channels.BufferOverflow bufferOverflow, kotlin.jvm.functions.Function1 function1, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = kotlinx.coroutines.channels.BufferOverflow.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return Channel(i, bufferOverflow, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrElse-WpGqRn0, reason: not valid java name */
    public static final <T> T m767getOrElseWpGqRn0(@org.jetbrains.annotations.NotNull java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, ? extends T> function1) {
        return obj instanceof kotlinx.coroutines.channels.ChannelResult.Failed ? function1.invoke(kotlinx.coroutines.channels.ChannelResult.m775exceptionOrNullimpl(obj)) : obj;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: onClosed-WpGqRn0, reason: not valid java name */
    public static final <T> java.lang.Object m768onClosedWpGqRn0(@org.jetbrains.annotations.NotNull java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> function1) {
        if (obj instanceof kotlinx.coroutines.channels.ChannelResult.Closed) {
            function1.invoke(kotlinx.coroutines.channels.ChannelResult.m775exceptionOrNullimpl(obj));
        }
        return obj;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: onFailure-WpGqRn0, reason: not valid java name */
    public static final <T> java.lang.Object m769onFailureWpGqRn0(@org.jetbrains.annotations.NotNull java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> function1) {
        if (obj instanceof kotlinx.coroutines.channels.ChannelResult.Failed) {
            function1.invoke(kotlinx.coroutines.channels.ChannelResult.m775exceptionOrNullimpl(obj));
        }
        return obj;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: onSuccess-WpGqRn0, reason: not valid java name */
    public static final <T> java.lang.Object m770onSuccessWpGqRn0(@org.jetbrains.annotations.NotNull java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, kotlin.Unit> function1) {
        if (!(obj instanceof kotlinx.coroutines.channels.ChannelResult.Failed)) {
            function1.invoke(obj);
        }
        return obj;
    }
}
