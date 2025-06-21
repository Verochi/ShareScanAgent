package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, k = 4, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ChannelsKt {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    @kotlin.PublishedApi
    public static final void cancelConsumed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<?> receiveChannel, @org.jetbrains.annotations.Nullable java.lang.Throwable th) {
        kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.a(receiveChannel, th);
    }

    @kotlinx.coroutines.ObsoleteCoroutinesApi
    public static final <E, R> R consume(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BroadcastChannel<E> broadcastChannel, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.channels.ReceiveChannel<? extends E>, ? extends R> function1) {
        return (R) kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.b(broadcastChannel, function1);
    }

    public static final <E, R> R consume(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.channels.ReceiveChannel<? extends E>, ? extends R> function1) {
        return (R) kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.c(receiveChannel, function1);
    }

    @kotlinx.coroutines.ObsoleteCoroutinesApi
    @org.jetbrains.annotations.Nullable
    public static final <E> java.lang.Object consumeEach(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.BroadcastChannel<E> broadcastChannel, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, kotlin.Unit> function1, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.d(broadcastChannel, function1, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <E> java.lang.Object consumeEach(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super E, kotlin.Unit> function1, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.e(receiveChannel, function1, continuation);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> consumes(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<?> receiveChannel) {
        return kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.b(receiveChannel);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> consumesAll(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<?>... receiveChannelArr) {
        return kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.c(receiveChannelArr);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel distinct(kotlinx.coroutines.channels.ReceiveChannel receiveChannel) {
        kotlinx.coroutines.channels.ReceiveChannel g;
        g = kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.g(receiveChannel, null, new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1(null), 1, null);
        return g;
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E, K> kotlinx.coroutines.channels.ReceiveChannel<E> distinctBy(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super K>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.f(receiveChannel, coroutineContext, function2);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E> kotlinx.coroutines.channels.ReceiveChannel<E> filter(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.n(receiveChannel, coroutineContext, function2);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E> kotlinx.coroutines.channels.ReceiveChannel<E> filterNotNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel) {
        return kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.t(receiveChannel);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E, R> kotlinx.coroutines.channels.ReceiveChannel<R> map(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2) {
        return kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.E(receiveChannel, coroutineContext, function2);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E, R> kotlinx.coroutines.channels.ReceiveChannel<R> mapIndexed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super E, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3) {
        return kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.G(receiveChannel, coroutineContext, function3);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Deprecated in the favour of 'onReceiveCatching'")
    @org.jetbrains.annotations.NotNull
    public static final <E> kotlinx.coroutines.selects.SelectClause1<E> onReceiveOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel) {
        return kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.f(receiveChannel);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @kotlin.ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @org.jetbrains.annotations.Nullable
    public static final <E> java.lang.Object receiveOrNull(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super E> continuation) {
        return kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.g(receiveChannel, continuation);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Left for binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel requireNoNulls(kotlinx.coroutines.channels.ReceiveChannel receiveChannel) {
        kotlinx.coroutines.channels.ReceiveChannel F;
        F = kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.F(receiveChannel, null, new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1(receiveChannel, null), 1, null);
        return F;
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @kotlin.ReplaceWith(expression = "trySendBlocking(element)", imports = {}))
    public static final <E> void sendBlocking(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.SendChannel<? super E> sendChannel, E e) {
        kotlinx.coroutines.channels.ChannelsKt__ChannelsKt.a(sendChannel, e);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    public static final <E, C extends kotlinx.coroutines.channels.SendChannel<? super E>> java.lang.Object toChannel(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull C c, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> continuation) {
        return kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.W(receiveChannel, c, continuation);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object toCollection(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull C c, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> continuation) {
        return kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.X(receiveChannel, c, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <E> java.lang.Object toList(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends E>> continuation) {
        return kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.h(receiveChannel, continuation);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object toMap(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends kotlin.Pair<? extends K, ? extends V>> receiveChannel, @org.jetbrains.annotations.NotNull M m, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super M> continuation) {
        return kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.Y(receiveChannel, m, continuation);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object toMap(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        java.lang.Object map;
        map = toMap(receiveChannel, new java.util.LinkedHashMap(), continuation);
        return map;
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ java.lang.Object toMutableList(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        java.lang.Object collection;
        collection = toCollection(receiveChannel, new java.util.ArrayList(), continuation);
        return collection;
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    public static final <E> java.lang.Object toMutableSet(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Set<E>> continuation) {
        return kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.b0(receiveChannel, continuation);
    }

    @org.jetbrains.annotations.NotNull
    public static final <E> java.lang.Object trySendBlocking(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.SendChannel<? super E> sendChannel, E e) throws java.lang.InterruptedException {
        return kotlinx.coroutines.channels.ChannelsKt__ChannelsKt.b(sendChannel, e);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel zip(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlinx.coroutines.channels.ReceiveChannel receiveChannel2) {
        kotlinx.coroutines.channels.ReceiveChannel h0;
        h0 = kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.h0(receiveChannel, receiveChannel2, null, kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$1.INSTANCE, 2, null);
        return h0;
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E, R, V> kotlinx.coroutines.channels.ReceiveChannel<V> zip(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends R> receiveChannel2, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super E, ? super R, ? extends V> function2) {
        return kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.g0(receiveChannel, receiveChannel2, coroutineContext, function2);
    }
}
