package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1}, l = {313, 314}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce"}, s = {"L$0", "I$0", "L$0"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$withIndex$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2 {
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel $this_withIndex;
    int I$0;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$withIndex$1(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        super(2, continuation);
        this.$this_withIndex = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1(this.$this_withIndex, continuation);
        channelsKt__DeprecatedKt$withIndex$1.L$0 = obj;
        return channelsKt__DeprecatedKt$withIndex$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope producerScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation continuation) {
        return ((kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1) create(producerScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x007f -> B:6:0x0047). Please report as a decompilation issue!!! */
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
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$12;
        kotlinx.coroutines.channels.ProducerScope producerScope2;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        int i2;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            it = this.$this_withIndex.iterator();
            i = 0;
            channelsKt__DeprecatedKt$withIndex$1 = this;
        } else if (i3 == 1) {
            i2 = this.I$0;
            channelIterator = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            producerScope2 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            channelsKt__DeprecatedKt$withIndex$12 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
                return kotlin.Unit.INSTANCE;
            }
            int i4 = i2 + 1;
            kotlin.collections.IndexedValue indexedValue = new kotlin.collections.IndexedValue(i2, channelIterator.next());
            channelsKt__DeprecatedKt$withIndex$12.L$0 = producerScope2;
            channelsKt__DeprecatedKt$withIndex$12.L$1 = channelIterator;
            channelsKt__DeprecatedKt$withIndex$12.I$0 = i4;
            channelsKt__DeprecatedKt$withIndex$12.label = 2;
            if (producerScope2.send(indexedValue, channelsKt__DeprecatedKt$withIndex$12) == coroutine_suspended) {
                return coroutine_suspended;
            }
            it = channelIterator;
            producerScope = producerScope2;
            channelsKt__DeprecatedKt$withIndex$1 = channelsKt__DeprecatedKt$withIndex$12;
            i = i4;
        } else {
            if (i3 != 2) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i5 = this.I$0;
            kotlinx.coroutines.channels.ChannelIterator channelIterator2 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope3 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope = producerScope3;
            channelsKt__DeprecatedKt$withIndex$1 = this;
            i = i5;
            it = channelIterator2;
        }
        channelsKt__DeprecatedKt$withIndex$1.L$0 = producerScope;
        channelsKt__DeprecatedKt$withIndex$1.L$1 = it;
        channelsKt__DeprecatedKt$withIndex$1.I$0 = i;
        channelsKt__DeprecatedKt$withIndex$1.label = 1;
        java.lang.Object hasNext = it.hasNext(channelsKt__DeprecatedKt$withIndex$1);
        if (hasNext == coroutine_suspended) {
            return coroutine_suspended;
        }
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$13 = channelsKt__DeprecatedKt$withIndex$1;
        producerScope2 = producerScope;
        obj = hasNext;
        channelsKt__DeprecatedKt$withIndex$12 = channelsKt__DeprecatedKt$withIndex$13;
        int i6 = i;
        channelIterator = it;
        i2 = i6;
        if (((java.lang.Boolean) obj).booleanValue()) {
        }
    }
}
