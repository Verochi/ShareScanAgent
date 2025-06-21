package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1}, l = {234, 235, 236}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e"}, s = {"L$0", "L$0", "L$2"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$takeWhile$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2 {
    final /* synthetic */ kotlin.jvm.functions.Function2 $predicate;
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel $this_takeWhile;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$takeWhile$1(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.jvm.functions.Function2 function2, kotlin.coroutines.Continuation continuation) {
        super(2, continuation);
        this.$this_takeWhile = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1(this.$this_takeWhile, this.$predicate, continuation);
        channelsKt__DeprecatedKt$takeWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$takeWhile$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope producerScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation continuation) {
        return ((kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1) create(producerScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ac  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a7 -> B:8:0x0057). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.channels.ChannelIterator it;
        kotlinx.coroutines.channels.ProducerScope producerScope;
        java.lang.Object obj2;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$1;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$12;
        kotlinx.coroutines.channels.ProducerScope producerScope2;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        java.lang.Object hasNext;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            kotlinx.coroutines.channels.ProducerScope producerScope3 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            it = this.$this_takeWhile.iterator();
            producerScope = producerScope3;
        } else if (i == 1) {
            kotlinx.coroutines.channels.ChannelIterator channelIterator2 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope4 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope2 = producerScope4;
            channelIterator = channelIterator2;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$takeWhile$1 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
        } else if (i == 2) {
            java.lang.Object obj3 = this.L$2;
            kotlinx.coroutines.channels.ChannelIterator channelIterator3 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope5 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            kotlinx.coroutines.channels.ProducerScope producerScope6 = producerScope5;
            kotlinx.coroutines.channels.ChannelIterator channelIterator4 = channelIterator3;
            java.lang.Object obj4 = obj3;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$takeWhile$1 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
                return kotlin.Unit.INSTANCE;
            }
            channelsKt__DeprecatedKt$takeWhile$1.L$0 = producerScope6;
            channelsKt__DeprecatedKt$takeWhile$1.L$1 = channelIterator4;
            channelsKt__DeprecatedKt$takeWhile$1.L$2 = null;
            channelsKt__DeprecatedKt$takeWhile$1.label = 3;
            if (producerScope6.send(obj4, channelsKt__DeprecatedKt$takeWhile$1) == obj2) {
                return obj2;
            }
            channelsKt__DeprecatedKt$takeWhile$12 = channelsKt__DeprecatedKt$takeWhile$1;
            coroutine_suspended = obj2;
            it = channelIterator4;
            producerScope = producerScope6;
            channelsKt__DeprecatedKt$takeWhile$12.L$0 = producerScope;
            channelsKt__DeprecatedKt$takeWhile$12.L$1 = it;
            channelsKt__DeprecatedKt$takeWhile$12.label = 1;
            hasNext = it.hasNext(channelsKt__DeprecatedKt$takeWhile$12);
            if (hasNext != coroutine_suspended) {
                return coroutine_suspended;
            }
            java.lang.Object obj5 = coroutine_suspended;
            channelsKt__DeprecatedKt$takeWhile$1 = channelsKt__DeprecatedKt$takeWhile$12;
            obj = hasNext;
            producerScope2 = producerScope;
            channelIterator = it;
            obj2 = obj5;
            if (((java.lang.Boolean) obj).booleanValue()) {
                return kotlin.Unit.INSTANCE;
            }
            java.lang.Object next = channelIterator.next();
            kotlin.jvm.functions.Function2 function2 = channelsKt__DeprecatedKt$takeWhile$1.$predicate;
            channelsKt__DeprecatedKt$takeWhile$1.L$0 = producerScope2;
            channelsKt__DeprecatedKt$takeWhile$1.L$1 = channelIterator;
            channelsKt__DeprecatedKt$takeWhile$1.L$2 = next;
            channelsKt__DeprecatedKt$takeWhile$1.label = 2;
            java.lang.Object mo5invoke = function2.mo5invoke(next, channelsKt__DeprecatedKt$takeWhile$1);
            if (mo5invoke == obj2) {
                return obj2;
            }
            kotlinx.coroutines.channels.ChannelIterator channelIterator5 = channelIterator;
            obj4 = next;
            obj = mo5invoke;
            producerScope6 = producerScope2;
            channelIterator4 = channelIterator5;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
        } else {
            if (i != 3) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            producerScope = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
        }
        channelsKt__DeprecatedKt$takeWhile$12 = this;
        channelsKt__DeprecatedKt$takeWhile$12.L$0 = producerScope;
        channelsKt__DeprecatedKt$takeWhile$12.L$1 = it;
        channelsKt__DeprecatedKt$takeWhile$12.label = 1;
        hasNext = it.hasNext(channelsKt__DeprecatedKt$takeWhile$12);
        if (hasNext != coroutine_suspended) {
        }
    }
}
