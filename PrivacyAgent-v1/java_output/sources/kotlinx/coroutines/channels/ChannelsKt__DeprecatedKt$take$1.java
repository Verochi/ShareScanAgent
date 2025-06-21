package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 1}, l = {223, 224}, m = "invokeSuspend", n = {"remaining", "remaining"}, s = {"I$0", "I$0"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$take$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2 {
    final /* synthetic */ int $n;
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel $this_take;
    int I$0;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$take$1(int i, kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        super(2, continuation);
        this.$n = i;
        this.$this_take = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, continuation);
        channelsKt__DeprecatedKt$take$1.L$0 = obj;
        return channelsKt__DeprecatedKt$take$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope producerScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation continuation) {
        return ((kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1) create(producerScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0080 -> B:6:0x0082). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.channels.ProducerScope producerScope;
        int i;
        kotlinx.coroutines.channels.ChannelIterator it;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$12;
        kotlinx.coroutines.channels.ProducerScope producerScope2;
        java.lang.Object hasNext;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            i = this.$n;
            if (i == 0) {
                return kotlin.Unit.INSTANCE;
            }
            if (!(i >= 0)) {
                throw new java.lang.IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
            }
            it = this.$this_take.iterator();
            channelsKt__DeprecatedKt$take$1 = this;
            channelsKt__DeprecatedKt$take$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$take$1.L$1 = it;
            channelsKt__DeprecatedKt$take$1.I$0 = i;
            channelsKt__DeprecatedKt$take$1.label = 1;
            hasNext = it.hasNext(channelsKt__DeprecatedKt$take$1);
            if (hasNext == coroutine_suspended) {
            }
        } else if (i2 == 1) {
            i = this.I$0;
            it = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            producerScope2 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            channelsKt__DeprecatedKt$take$12 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
        } else {
            if (i2 != 2) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            it = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope3 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope = producerScope3;
            channelsKt__DeprecatedKt$take$1 = this;
            i--;
            if (i == 0) {
                return kotlin.Unit.INSTANCE;
            }
            channelsKt__DeprecatedKt$take$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$take$1.L$1 = it;
            channelsKt__DeprecatedKt$take$1.I$0 = i;
            channelsKt__DeprecatedKt$take$1.label = 1;
            hasNext = it.hasNext(channelsKt__DeprecatedKt$take$1);
            if (hasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$13 = channelsKt__DeprecatedKt$take$1;
            producerScope2 = producerScope;
            obj = hasNext;
            channelsKt__DeprecatedKt$take$12 = channelsKt__DeprecatedKt$take$13;
            if (((java.lang.Boolean) obj).booleanValue()) {
                return kotlin.Unit.INSTANCE;
            }
            java.lang.Object next = it.next();
            channelsKt__DeprecatedKt$take$12.L$0 = producerScope2;
            channelsKt__DeprecatedKt$take$12.L$1 = it;
            channelsKt__DeprecatedKt$take$12.I$0 = i;
            channelsKt__DeprecatedKt$take$12.label = 2;
            if (producerScope2.send(next, channelsKt__DeprecatedKt$take$12) == coroutine_suspended) {
                return coroutine_suspended;
            }
            producerScope = producerScope2;
            channelsKt__DeprecatedKt$take$1 = channelsKt__DeprecatedKt$take$12;
            i--;
            if (i == 0) {
            }
            channelsKt__DeprecatedKt$take$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$take$1.L$1 = it;
            channelsKt__DeprecatedKt$take$1.I$0 = i;
            channelsKt__DeprecatedKt$take$1.label = 1;
            hasNext = it.hasNext(channelsKt__DeprecatedKt$take$1);
            if (hasNext == coroutine_suspended) {
            }
        }
    }
}
