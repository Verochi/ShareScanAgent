package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0}, l = {151, 156, 157}, m = "invokeSuspend", n = {"remaining"}, s = {"I$0"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$drop$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2 {
    final /* synthetic */ int $n;
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel $this_drop;
    int I$0;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$drop$1(int i, kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.coroutines.Continuation continuation) {
        super(2, continuation);
        this.$n = i;
        this.$this_drop = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1(this.$n, this.$this_drop, continuation);
        channelsKt__DeprecatedKt$drop$1.L$0 = obj;
        return channelsKt__DeprecatedKt$drop$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope producerScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation continuation) {
        return ((kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1) create(producerScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00ab A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00c8 -> B:7:0x009f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0077 -> B:24:0x007e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.channels.ProducerScope producerScope;
        int i;
        java.lang.Object obj2;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$1;
        kotlinx.coroutines.channels.ChannelIterator it;
        kotlinx.coroutines.channels.ProducerScope producerScope2;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$12;
        kotlinx.coroutines.channels.ChannelIterator it2;
        java.lang.Object hasNext;
        kotlinx.coroutines.channels.ProducerScope producerScope3;
        java.lang.Object hasNext2;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            i = this.$n;
            if (!(i >= 0)) {
                throw new java.lang.IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
            }
            if (i > 0) {
                it = this.$this_drop.iterator();
                producerScope2 = producerScope;
                channelsKt__DeprecatedKt$drop$12 = this;
                channelsKt__DeprecatedKt$drop$12.L$0 = producerScope2;
                channelsKt__DeprecatedKt$drop$12.L$1 = it;
                channelsKt__DeprecatedKt$drop$12.I$0 = i;
                channelsKt__DeprecatedKt$drop$12.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$drop$12);
                if (hasNext != coroutine_suspended) {
                }
            } else {
                obj2 = coroutine_suspended;
                channelsKt__DeprecatedKt$drop$1 = this;
                it2 = channelsKt__DeprecatedKt$drop$1.$this_drop.iterator();
                channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$drop$1.L$1 = it2;
                channelsKt__DeprecatedKt$drop$1.label = 2;
                hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$drop$1);
                if (hasNext2 != obj2) {
                }
            }
        } else if (i2 == 1) {
            int i3 = this.I$0;
            kotlinx.coroutines.channels.ChannelIterator channelIterator = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope4 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            kotlinx.coroutines.channels.ProducerScope producerScope5 = producerScope4;
            kotlinx.coroutines.channels.ChannelIterator channelIterator2 = channelIterator;
            int i4 = i3;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$drop$1 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
                channelIterator2.next();
                int i5 = i4 - 1;
                if (i5 != 0) {
                    it = channelIterator2;
                    producerScope2 = producerScope5;
                    java.lang.Object obj3 = obj2;
                    i = i5;
                    channelsKt__DeprecatedKt$drop$12 = channelsKt__DeprecatedKt$drop$1;
                    coroutine_suspended = obj3;
                    channelsKt__DeprecatedKt$drop$12.L$0 = producerScope2;
                    channelsKt__DeprecatedKt$drop$12.L$1 = it;
                    channelsKt__DeprecatedKt$drop$12.I$0 = i;
                    channelsKt__DeprecatedKt$drop$12.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$drop$12);
                    if (hasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    java.lang.Object obj4 = coroutine_suspended;
                    channelsKt__DeprecatedKt$drop$1 = channelsKt__DeprecatedKt$drop$12;
                    obj = hasNext;
                    producerScope5 = producerScope2;
                    channelIterator2 = it;
                    i4 = i;
                    obj2 = obj4;
                    if (((java.lang.Boolean) obj).booleanValue()) {
                    }
                }
            }
            producerScope = producerScope5;
            it2 = channelsKt__DeprecatedKt$drop$1.$this_drop.iterator();
            channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$drop$1.L$1 = it2;
            channelsKt__DeprecatedKt$drop$1.label = 2;
            hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$drop$1);
            if (hasNext2 != obj2) {
            }
        } else if (i2 == 2) {
            kotlinx.coroutines.channels.ChannelIterator channelIterator3 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope6 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope3 = producerScope6;
            it2 = channelIterator3;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$drop$1 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
        } else {
            if (i2 != 3) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlinx.coroutines.channels.ChannelIterator channelIterator4 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope7 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope = producerScope7;
            it2 = channelIterator4;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$drop$1 = this;
            channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$drop$1.L$1 = it2;
            channelsKt__DeprecatedKt$drop$1.label = 2;
            hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$drop$1);
            if (hasNext2 != obj2) {
                return obj2;
            }
            producerScope3 = producerScope;
            obj = hasNext2;
            if (((java.lang.Boolean) obj).booleanValue()) {
                return kotlin.Unit.INSTANCE;
            }
            java.lang.Object next = it2.next();
            channelsKt__DeprecatedKt$drop$1.L$0 = producerScope3;
            channelsKt__DeprecatedKt$drop$1.L$1 = it2;
            channelsKt__DeprecatedKt$drop$1.label = 3;
            if (producerScope3.send(next, channelsKt__DeprecatedKt$drop$1) == obj2) {
                return obj2;
            }
            producerScope = producerScope3;
            channelsKt__DeprecatedKt$drop$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$drop$1.L$1 = it2;
            channelsKt__DeprecatedKt$drop$1.label = 2;
            hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$drop$1);
            if (hasNext2 != obj2) {
            }
        }
    }
}
