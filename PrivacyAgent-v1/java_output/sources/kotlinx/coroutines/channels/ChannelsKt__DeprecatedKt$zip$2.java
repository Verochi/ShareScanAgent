package kotlinx.coroutines.channels;

/* JADX INFO: Add missing generic type declarations: [V] */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0003H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "R", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_COVER_URL_CODE, 397, 399}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$zip$2<V> extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.channels.ProducerScope<? super V>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel<R> $other;
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel<E> $this_zip;
    final /* synthetic */ kotlin.jvm.functions.Function2<E, R, V> $transform;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    java.lang.Object L$3;
    java.lang.Object L$4;
    java.lang.Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$zip$2(kotlinx.coroutines.channels.ReceiveChannel<? extends R> receiveChannel, kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel2, kotlin.jvm.functions.Function2<? super E, ? super R, ? extends V> function2, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2> continuation) {
        super(2, continuation);
        this.$other = receiveChannel;
        this.$this_zip = receiveChannel2;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2(this.$other, this.$this_zip, this.$transform, continuation);
        channelsKt__DeprecatedKt$zip$2.L$0 = obj;
        return channelsKt__DeprecatedKt$zip$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope<? super V> producerScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2) create(producerScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
    
        r14 = r0;
        r0 = r1;
        r1 = r6;
        r6 = r8;
        r7 = r9;
        r8 = r10;
        r9 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b9 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #3 {all -> 0x0056, blocks: (B:15:0x00b1, B:17:0x00b9, B:38:0x0109, B:49:0x004a), top: B:48:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e9 A[Catch: all -> 0x0106, TRY_LEAVE, TryCatch #2 {all -> 0x0106, blocks: (B:22:0x00d9, B:25:0x00e9), top: B:21:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0109 A[Catch: all -> 0x0056, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0056, blocks: (B:15:0x00b1, B:17:0x00b9, B:38:0x0109, B:49:0x004a), top: B:48:0x004a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel;
        kotlin.jvm.functions.Function2 function2;
        kotlinx.coroutines.channels.ProducerScope producerScope;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2<V> channelsKt__DeprecatedKt$zip$2;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        kotlinx.coroutines.channels.ChannelIterator it;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        kotlinx.coroutines.channels.ProducerScope producerScope2;
        kotlinx.coroutines.channels.ChannelIterator channelIterator2;
        kotlin.jvm.functions.Function2 function22;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel3;
        java.lang.Object obj2;
        kotlinx.coroutines.channels.ChannelIterator channelIterator3;
        java.lang.Object obj3;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2<V> channelsKt__DeprecatedKt$zip$22;
        kotlinx.coroutines.channels.ProducerScope producerScope3;
        kotlinx.coroutines.channels.ChannelIterator channelIterator4;
        kotlin.jvm.functions.Function2 function23;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                kotlin.ResultKt.throwOnFailure(obj);
                kotlinx.coroutines.channels.ProducerScope producerScope4 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
                kotlinx.coroutines.channels.ChannelIterator it2 = this.$other.iterator();
                receiveChannel = this.$this_zip;
                function2 = this.$transform;
                producerScope = producerScope4;
                channelsKt__DeprecatedKt$zip$2 = this;
                channelIterator = it2;
                it = receiveChannel.iterator();
            } else if (i == 1) {
                kotlinx.coroutines.channels.ChannelIterator channelIterator5 = (kotlinx.coroutines.channels.ChannelIterator) this.L$4;
                kotlinx.coroutines.channels.ReceiveChannel receiveChannel4 = (kotlinx.coroutines.channels.ReceiveChannel) this.L$3;
                kotlin.jvm.functions.Function2 function24 = (kotlin.jvm.functions.Function2) this.L$2;
                kotlinx.coroutines.channels.ChannelIterator channelIterator6 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
                kotlinx.coroutines.channels.ProducerScope producerScope5 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                producerScope3 = producerScope5;
                channelIterator4 = channelIterator6;
                function23 = function24;
                receiveChannel2 = receiveChannel4;
                channelIterator3 = channelIterator5;
                obj3 = coroutine_suspended;
                channelsKt__DeprecatedKt$zip$22 = this;
                if (((java.lang.Boolean) obj).booleanValue()) {
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel2, null);
                    return kotlin.Unit.INSTANCE;
                }
                java.lang.Object next = channelIterator3.next();
                channelsKt__DeprecatedKt$zip$22.L$0 = producerScope3;
                channelsKt__DeprecatedKt$zip$22.L$1 = channelIterator4;
                channelsKt__DeprecatedKt$zip$22.L$2 = function23;
                channelsKt__DeprecatedKt$zip$22.L$3 = receiveChannel2;
                channelsKt__DeprecatedKt$zip$22.L$4 = channelIterator3;
                channelsKt__DeprecatedKt$zip$22.L$5 = next;
                channelsKt__DeprecatedKt$zip$22.label = 2;
                java.lang.Object hasNext = channelIterator4.hasNext(channelsKt__DeprecatedKt$zip$22);
                if (hasNext == obj3) {
                    return obj3;
                }
                kotlinx.coroutines.channels.ReceiveChannel receiveChannel5 = receiveChannel2;
                obj2 = next;
                obj = hasNext;
                producerScope2 = producerScope3;
                channelIterator2 = channelIterator4;
                function22 = function23;
                receiveChannel3 = receiveChannel5;
                if (((java.lang.Boolean) obj).booleanValue()) {
                }
            } else if (i == 2) {
                java.lang.Object obj4 = this.L$5;
                channelIterator3 = (kotlinx.coroutines.channels.ChannelIterator) this.L$4;
                receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) this.L$3;
                kotlin.jvm.functions.Function2 function25 = (kotlin.jvm.functions.Function2) this.L$2;
                kotlinx.coroutines.channels.ChannelIterator channelIterator7 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
                kotlinx.coroutines.channels.ProducerScope producerScope6 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
                try {
                    kotlin.ResultKt.throwOnFailure(obj);
                    producerScope2 = producerScope6;
                    channelIterator2 = channelIterator7;
                    function22 = function25;
                    receiveChannel3 = receiveChannel2;
                    obj2 = obj4;
                    obj3 = coroutine_suspended;
                    channelsKt__DeprecatedKt$zip$22 = this;
                    try {
                        if (((java.lang.Boolean) obj).booleanValue()) {
                            channelsKt__DeprecatedKt$zip$2 = channelsKt__DeprecatedKt$zip$22;
                            coroutine_suspended = obj3;
                            it = channelIterator3;
                            receiveChannel = receiveChannel3;
                            function2 = function22;
                            channelIterator = channelIterator2;
                            producerScope = producerScope2;
                        } else {
                            java.lang.Object mo5invoke = function22.mo5invoke(obj2, channelIterator2.next());
                            channelsKt__DeprecatedKt$zip$22.L$0 = producerScope2;
                            channelsKt__DeprecatedKt$zip$22.L$1 = channelIterator2;
                            channelsKt__DeprecatedKt$zip$22.L$2 = function22;
                            channelsKt__DeprecatedKt$zip$22.L$3 = receiveChannel3;
                            channelsKt__DeprecatedKt$zip$22.L$4 = channelIterator3;
                            channelsKt__DeprecatedKt$zip$22.L$5 = null;
                            channelsKt__DeprecatedKt$zip$22.label = 3;
                            if (producerScope2.send(mo5invoke, channelsKt__DeprecatedKt$zip$22) == obj3) {
                                return obj3;
                            }
                            channelsKt__DeprecatedKt$zip$2 = channelsKt__DeprecatedKt$zip$22;
                            coroutine_suspended = obj3;
                            it = channelIterator3;
                            receiveChannel = receiveChannel3;
                            function2 = function22;
                            channelIterator = channelIterator2;
                            producerScope = producerScope2;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        receiveChannel = receiveChannel3;
                        try {
                            throw th;
                        } catch (java.lang.Throwable th2) {
                            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, th);
                            throw th2;
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    receiveChannel = receiveChannel2;
                    throw th;
                }
            } else {
                if (i != 3) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (kotlinx.coroutines.channels.ChannelIterator) this.L$4;
                receiveChannel = (kotlinx.coroutines.channels.ReceiveChannel) this.L$3;
                function2 = (kotlin.jvm.functions.Function2) this.L$2;
                channelIterator = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
                producerScope = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                channelsKt__DeprecatedKt$zip$2 = this;
            }
            channelsKt__DeprecatedKt$zip$2.L$0 = producerScope;
            channelsKt__DeprecatedKt$zip$2.L$1 = channelIterator;
            channelsKt__DeprecatedKt$zip$2.L$2 = function2;
            channelsKt__DeprecatedKt$zip$2.L$3 = receiveChannel;
            channelsKt__DeprecatedKt$zip$2.L$4 = it;
            channelsKt__DeprecatedKt$zip$2.L$5 = null;
            channelsKt__DeprecatedKt$zip$2.label = 1;
            java.lang.Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$zip$2);
            if (hasNext2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            java.lang.Object obj5 = coroutine_suspended;
            channelsKt__DeprecatedKt$zip$22 = channelsKt__DeprecatedKt$zip$2;
            obj = hasNext2;
            producerScope3 = producerScope;
            channelIterator4 = channelIterator;
            function23 = function2;
            receiveChannel2 = receiveChannel;
            channelIterator3 = it;
            obj3 = obj5;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
    }
}
