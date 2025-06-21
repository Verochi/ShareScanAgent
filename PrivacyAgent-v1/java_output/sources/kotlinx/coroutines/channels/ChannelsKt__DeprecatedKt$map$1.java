package kotlinx.coroutines.channels;

/* JADX INFO: Add missing generic type declarations: [R] */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_COVER_URL_CODE, com.anythink.expressad.foundation.g.a.aW, com.anythink.expressad.foundation.g.a.aW}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$map$1<R> extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.channels.ProducerScope<? super R>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel<E> $this_map;
    final /* synthetic */ kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super R>, java.lang.Object> $transform;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    java.lang.Object L$3;
    java.lang.Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$map$1(kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1> continuation) {
        super(2, continuation);
        this.$this_map = receiveChannel;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1(this.$this_map, this.$transform, continuation);
        channelsKt__DeprecatedKt$map$1.L$0 = obj;
        return channelsKt__DeprecatedKt$map$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope<? super R> producerScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1) create(producerScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0093 A[Catch: all -> 0x00d1, TRY_LEAVE, TryCatch #0 {all -> 0x00d1, blocks: (B:8:0x0022, B:10:0x0076, B:15:0x008b, B:17:0x0093, B:34:0x00c9, B:45:0x005e, B:48:0x006e), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9 A[Catch: all -> 0x00d1, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00d1, blocks: (B:8:0x0022, B:10:0x0076, B:15:0x008b, B:17:0x0093, B:34:0x00c9, B:45:0x005e, B:48:0x006e), top: B:2:0x000a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c3 -> B:10:0x0076). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel;
        kotlinx.coroutines.channels.ProducerScope producerScope;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1<R> channelsKt__DeprecatedKt$map$1;
        kotlin.jvm.functions.Function2 function2;
        kotlinx.coroutines.channels.ChannelIterator it;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1<R> channelsKt__DeprecatedKt$map$12;
        kotlinx.coroutines.channels.ProducerScope producerScope2;
        kotlin.jvm.functions.Function2 function22;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        kotlinx.coroutines.channels.ProducerScope producerScope3;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1<R> channelsKt__DeprecatedKt$map$13;
        kotlinx.coroutines.channels.ProducerScope producerScope4;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                kotlin.ResultKt.throwOnFailure(obj);
                producerScope = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
                receiveChannel = this.$this_map;
                channelsKt__DeprecatedKt$map$1 = this;
                function2 = this.$transform;
                it = receiveChannel.iterator();
            } else if (i == 1) {
                it = (kotlinx.coroutines.channels.ChannelIterator) this.L$3;
                receiveChannel = (kotlinx.coroutines.channels.ReceiveChannel) this.L$2;
                function2 = (kotlin.jvm.functions.Function2) this.L$1;
                producerScope4 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                channelsKt__DeprecatedKt$map$13 = this;
                if (((java.lang.Boolean) obj).booleanValue()) {
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, null);
                    return kotlin.Unit.INSTANCE;
                }
                java.lang.Object next = it.next();
                channelsKt__DeprecatedKt$map$13.L$0 = producerScope4;
                channelsKt__DeprecatedKt$map$13.L$1 = function2;
                channelsKt__DeprecatedKt$map$13.L$2 = receiveChannel;
                channelsKt__DeprecatedKt$map$13.L$3 = it;
                channelsKt__DeprecatedKt$map$13.L$4 = producerScope4;
                channelsKt__DeprecatedKt$map$13.label = 2;
                obj = function2.mo5invoke(next, channelsKt__DeprecatedKt$map$13);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                channelsKt__DeprecatedKt$map$12 = channelsKt__DeprecatedKt$map$13;
                producerScope2 = producerScope4;
                function22 = function2;
                receiveChannel2 = receiveChannel;
                channelIterator = it;
                producerScope3 = producerScope2;
                channelsKt__DeprecatedKt$map$12.L$0 = producerScope2;
                channelsKt__DeprecatedKt$map$12.L$1 = function22;
                channelsKt__DeprecatedKt$map$12.L$2 = receiveChannel2;
                channelsKt__DeprecatedKt$map$12.L$3 = channelIterator;
                channelsKt__DeprecatedKt$map$12.L$4 = null;
                channelsKt__DeprecatedKt$map$12.label = 3;
                if (producerScope3.send(obj, channelsKt__DeprecatedKt$map$12) != coroutine_suspended) {
                }
            } else if (i == 2) {
                producerScope3 = (kotlinx.coroutines.channels.ProducerScope) this.L$4;
                channelIterator = (kotlinx.coroutines.channels.ChannelIterator) this.L$3;
                receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) this.L$2;
                function22 = (kotlin.jvm.functions.Function2) this.L$1;
                producerScope2 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
                try {
                    kotlin.ResultKt.throwOnFailure(obj);
                    channelsKt__DeprecatedKt$map$12 = this;
                    channelsKt__DeprecatedKt$map$12.L$0 = producerScope2;
                    channelsKt__DeprecatedKt$map$12.L$1 = function22;
                    channelsKt__DeprecatedKt$map$12.L$2 = receiveChannel2;
                    channelsKt__DeprecatedKt$map$12.L$3 = channelIterator;
                    channelsKt__DeprecatedKt$map$12.L$4 = null;
                    channelsKt__DeprecatedKt$map$12.label = 3;
                    if (producerScope3.send(obj, channelsKt__DeprecatedKt$map$12) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it = channelIterator;
                    receiveChannel = receiveChannel2;
                    function2 = function22;
                    producerScope = producerScope2;
                    channelsKt__DeprecatedKt$map$1 = channelsKt__DeprecatedKt$map$12;
                } catch (java.lang.Throwable th) {
                    th = th;
                    receiveChannel = receiveChannel2;
                    try {
                        throw th;
                    } catch (java.lang.Throwable th2) {
                        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, th);
                        throw th2;
                    }
                }
            } else {
                if (i != 3) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (kotlinx.coroutines.channels.ChannelIterator) this.L$3;
                receiveChannel = (kotlinx.coroutines.channels.ReceiveChannel) this.L$2;
                function2 = (kotlin.jvm.functions.Function2) this.L$1;
                kotlinx.coroutines.channels.ProducerScope producerScope5 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                producerScope = producerScope5;
                channelsKt__DeprecatedKt$map$1 = this;
            }
            channelsKt__DeprecatedKt$map$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$map$1.L$1 = function2;
            channelsKt__DeprecatedKt$map$1.L$2 = receiveChannel;
            channelsKt__DeprecatedKt$map$1.L$3 = it;
            channelsKt__DeprecatedKt$map$1.label = 1;
            java.lang.Object hasNext = it.hasNext(channelsKt__DeprecatedKt$map$1);
            if (hasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1<R> channelsKt__DeprecatedKt$map$14 = channelsKt__DeprecatedKt$map$1;
            producerScope4 = producerScope;
            obj = hasNext;
            channelsKt__DeprecatedKt$map$13 = channelsKt__DeprecatedKt$map$14;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }
}
