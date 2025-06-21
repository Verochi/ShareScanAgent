package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2}, l = {187, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_PACKET_SIZE, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_PACKET_SIZE}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$2", "L$0"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2 {
    final /* synthetic */ kotlin.jvm.functions.Function3 $predicate;
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel $this_filterIndexed;
    int I$0;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$filterIndexed$1(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.jvm.functions.Function3 function3, kotlin.coroutines.Continuation continuation) {
        super(2, continuation);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, continuation);
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterIndexed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope producerScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation continuation) {
        return ((kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1) create(producerScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        r13 = r0;
        r0 = r1;
        r7 = r8;
        r1 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.channels.ProducerScope producerScope;
        kotlinx.coroutines.channels.ChannelIterator it;
        int i;
        kotlinx.coroutines.channels.ProducerScope producerScope2;
        java.lang.Object obj2;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$12;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        int i2;
        java.lang.Object hasNext;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            it = this.$this_filterIndexed.iterator();
            i = 0;
        } else if (i3 == 1) {
            int i4 = this.I$0;
            kotlinx.coroutines.channels.ChannelIterator channelIterator2 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope3 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope2 = producerScope3;
            channelIterator = channelIterator2;
            i2 = i4;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$filterIndexed$1 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
        } else if (i3 == 2) {
            int i5 = this.I$0;
            java.lang.Object obj3 = this.L$2;
            kotlinx.coroutines.channels.ChannelIterator channelIterator3 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            producerScope2 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            int i6 = i5;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$filterIndexed$1 = this;
            kotlinx.coroutines.channels.ChannelIterator channelIterator4 = channelIterator3;
            java.lang.Object obj4 = obj3;
            it = channelIterator4;
            if (((java.lang.Boolean) obj).booleanValue()) {
                channelsKt__DeprecatedKt$filterIndexed$1.L$0 = producerScope2;
                channelsKt__DeprecatedKt$filterIndexed$1.L$1 = it;
                channelsKt__DeprecatedKt$filterIndexed$1.L$2 = null;
                channelsKt__DeprecatedKt$filterIndexed$1.I$0 = i6;
                channelsKt__DeprecatedKt$filterIndexed$1.label = 3;
                if (producerScope2.send(obj4, channelsKt__DeprecatedKt$filterIndexed$1) == obj2) {
                    return obj2;
                }
            }
            channelsKt__DeprecatedKt$filterIndexed$12 = channelsKt__DeprecatedKt$filterIndexed$1;
            coroutine_suspended = obj2;
            producerScope = producerScope2;
            i = i6;
            channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope;
            channelsKt__DeprecatedKt$filterIndexed$12.L$1 = it;
            channelsKt__DeprecatedKt$filterIndexed$12.L$2 = null;
            channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i;
            channelsKt__DeprecatedKt$filterIndexed$12.label = 1;
            hasNext = it.hasNext(channelsKt__DeprecatedKt$filterIndexed$12);
            if (hasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
            java.lang.Object obj5 = coroutine_suspended;
            channelsKt__DeprecatedKt$filterIndexed$1 = channelsKt__DeprecatedKt$filterIndexed$12;
            obj = hasNext;
            producerScope2 = producerScope;
            channelIterator = it;
            i2 = i;
            obj2 = obj5;
            if (((java.lang.Boolean) obj).booleanValue()) {
                return kotlin.Unit.INSTANCE;
            }
            java.lang.Object next = channelIterator.next();
            kotlin.jvm.functions.Function3 function3 = channelsKt__DeprecatedKt$filterIndexed$1.$predicate;
            i6 = i2 + 1;
            java.lang.Integer boxInt = kotlin.coroutines.jvm.internal.Boxing.boxInt(i2);
            channelsKt__DeprecatedKt$filterIndexed$1.L$0 = producerScope2;
            channelsKt__DeprecatedKt$filterIndexed$1.L$1 = channelIterator;
            channelsKt__DeprecatedKt$filterIndexed$1.L$2 = next;
            channelsKt__DeprecatedKt$filterIndexed$1.I$0 = i6;
            channelsKt__DeprecatedKt$filterIndexed$1.label = 2;
            java.lang.Object invoke = function3.invoke(boxInt, next, channelsKt__DeprecatedKt$filterIndexed$1);
            if (invoke == obj2) {
                return obj2;
            }
            channelIterator4 = channelIterator;
            obj4 = next;
            obj = invoke;
            it = channelIterator4;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
            channelsKt__DeprecatedKt$filterIndexed$12 = channelsKt__DeprecatedKt$filterIndexed$1;
            coroutine_suspended = obj2;
            producerScope = producerScope2;
            i = i6;
            channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope;
            channelsKt__DeprecatedKt$filterIndexed$12.L$1 = it;
            channelsKt__DeprecatedKt$filterIndexed$12.L$2 = null;
            channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i;
            channelsKt__DeprecatedKt$filterIndexed$12.label = 1;
            hasNext = it.hasNext(channelsKt__DeprecatedKt$filterIndexed$12);
            if (hasNext == coroutine_suspended) {
            }
        } else {
            if (i3 != 3) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            it = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            producerScope = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
        }
        channelsKt__DeprecatedKt$filterIndexed$12 = this;
        channelsKt__DeprecatedKt$filterIndexed$12.L$0 = producerScope;
        channelsKt__DeprecatedKt$filterIndexed$12.L$1 = it;
        channelsKt__DeprecatedKt$filterIndexed$12.L$2 = null;
        channelsKt__DeprecatedKt$filterIndexed$12.I$0 = i;
        channelsKt__DeprecatedKt$filterIndexed$12.label = 1;
        hasNext = it.hasNext(channelsKt__DeprecatedKt$filterIndexed$12);
        if (hasNext == coroutine_suspended) {
        }
    }
}
