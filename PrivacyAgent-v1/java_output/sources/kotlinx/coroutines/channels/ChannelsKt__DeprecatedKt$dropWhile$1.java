package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {164, 165, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 170, 171}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$dropWhile$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2 {
    final /* synthetic */ kotlin.jvm.functions.Function2 $predicate;
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel $this_dropWhile;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$dropWhile$1(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlin.jvm.functions.Function2 function2, kotlin.coroutines.Continuation continuation) {
        super(2, continuation);
        this.$this_dropWhile = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, continuation);
        channelsKt__DeprecatedKt$dropWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$dropWhile$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope producerScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation continuation) {
        return ((kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1) create(producerScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00e5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0102 -> B:9:0x00d9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00b1 -> B:29:0x00b5). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.channels.ChannelIterator it;
        kotlinx.coroutines.channels.ProducerScope producerScope;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1;
        kotlinx.coroutines.channels.ProducerScope producerScope2;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        java.lang.Object obj2;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$12;
        kotlinx.coroutines.channels.ProducerScope producerScope3;
        java.lang.Object hasNext;
        kotlinx.coroutines.channels.ChannelIterator it2;
        kotlinx.coroutines.channels.ChannelIterator channelIterator2;
        java.lang.Object hasNext2;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            kotlinx.coroutines.channels.ProducerScope producerScope4 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            it = this.$this_dropWhile.iterator();
            producerScope = producerScope4;
            channelsKt__DeprecatedKt$dropWhile$1 = this;
            channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$dropWhile$1.L$1 = it;
            channelsKt__DeprecatedKt$dropWhile$1.L$2 = null;
            channelsKt__DeprecatedKt$dropWhile$1.label = 1;
            hasNext = it.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
            if (hasNext != coroutine_suspended) {
            }
        } else if (i == 1) {
            kotlinx.coroutines.channels.ChannelIterator channelIterator3 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope5 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope2 = producerScope5;
            channelIterator = channelIterator3;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$dropWhile$12 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
            it2 = channelsKt__DeprecatedKt$dropWhile$12.$this_dropWhile.iterator();
            channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
            channelsKt__DeprecatedKt$dropWhile$12.L$1 = it2;
            channelsKt__DeprecatedKt$dropWhile$12.label = 4;
            hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
            if (hasNext2 != obj2) {
            }
        } else if (i == 2) {
            java.lang.Object obj3 = this.L$2;
            channelIterator = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope6 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope3 = producerScope6;
            java.lang.Object obj4 = obj3;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$dropWhile$12 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
                channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope3;
                channelsKt__DeprecatedKt$dropWhile$12.L$1 = null;
                channelsKt__DeprecatedKt$dropWhile$12.L$2 = null;
                channelsKt__DeprecatedKt$dropWhile$12.label = 3;
                if (producerScope3.send(obj4, channelsKt__DeprecatedKt$dropWhile$12) == obj2) {
                    return obj2;
                }
                producerScope2 = producerScope3;
                it2 = channelsKt__DeprecatedKt$dropWhile$12.$this_dropWhile.iterator();
                channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
                channelsKt__DeprecatedKt$dropWhile$12.L$1 = it2;
                channelsKt__DeprecatedKt$dropWhile$12.label = 4;
                hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
                if (hasNext2 != obj2) {
                }
            } else {
                channelsKt__DeprecatedKt$dropWhile$1 = channelsKt__DeprecatedKt$dropWhile$12;
                coroutine_suspended = obj2;
                it = channelIterator;
                producerScope = producerScope3;
                channelsKt__DeprecatedKt$dropWhile$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$dropWhile$1.L$1 = it;
                channelsKt__DeprecatedKt$dropWhile$1.L$2 = null;
                channelsKt__DeprecatedKt$dropWhile$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
                if (hasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                java.lang.Object obj5 = coroutine_suspended;
                channelsKt__DeprecatedKt$dropWhile$12 = channelsKt__DeprecatedKt$dropWhile$1;
                obj = hasNext;
                producerScope2 = producerScope;
                channelIterator = it;
                obj2 = obj5;
                if (((java.lang.Boolean) obj).booleanValue()) {
                    java.lang.Object next = channelIterator.next();
                    kotlin.jvm.functions.Function2 function2 = channelsKt__DeprecatedKt$dropWhile$12.$predicate;
                    channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
                    channelsKt__DeprecatedKt$dropWhile$12.L$1 = channelIterator;
                    channelsKt__DeprecatedKt$dropWhile$12.L$2 = next;
                    channelsKt__DeprecatedKt$dropWhile$12.label = 2;
                    java.lang.Object mo5invoke = function2.mo5invoke(next, channelsKt__DeprecatedKt$dropWhile$12);
                    if (mo5invoke == obj2) {
                        return obj2;
                    }
                    kotlinx.coroutines.channels.ProducerScope producerScope7 = producerScope2;
                    obj4 = next;
                    obj = mo5invoke;
                    producerScope3 = producerScope7;
                    if (((java.lang.Boolean) obj).booleanValue()) {
                    }
                }
                it2 = channelsKt__DeprecatedKt$dropWhile$12.$this_dropWhile.iterator();
                channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
                channelsKt__DeprecatedKt$dropWhile$12.L$1 = it2;
                channelsKt__DeprecatedKt$dropWhile$12.label = 4;
                hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
                if (hasNext2 != obj2) {
                }
            }
        } else if (i == 3) {
            kotlinx.coroutines.channels.ProducerScope producerScope8 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope3 = producerScope8;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$dropWhile$12 = this;
            producerScope2 = producerScope3;
            it2 = channelsKt__DeprecatedKt$dropWhile$12.$this_dropWhile.iterator();
            channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
            channelsKt__DeprecatedKt$dropWhile$12.L$1 = it2;
            channelsKt__DeprecatedKt$dropWhile$12.label = 4;
            hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
            if (hasNext2 != obj2) {
            }
        } else if (i == 4) {
            kotlinx.coroutines.channels.ChannelIterator channelIterator4 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope9 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope2 = producerScope9;
            channelIterator2 = channelIterator4;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$dropWhile$12 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
        } else {
            if (i != 5) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlinx.coroutines.channels.ChannelIterator channelIterator5 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope10 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            it2 = channelIterator5;
            producerScope2 = producerScope10;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$dropWhile$12 = this;
            channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
            channelsKt__DeprecatedKt$dropWhile$12.L$1 = it2;
            channelsKt__DeprecatedKt$dropWhile$12.label = 4;
            hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
            if (hasNext2 != obj2) {
                return obj2;
            }
            channelIterator2 = it2;
            obj = hasNext2;
            if (((java.lang.Boolean) obj).booleanValue()) {
                return kotlin.Unit.INSTANCE;
            }
            java.lang.Object next2 = channelIterator2.next();
            channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
            channelsKt__DeprecatedKt$dropWhile$12.L$1 = channelIterator2;
            channelsKt__DeprecatedKt$dropWhile$12.label = 5;
            if (producerScope2.send(next2, channelsKt__DeprecatedKt$dropWhile$12) == obj2) {
                return obj2;
            }
            it2 = channelIterator2;
            channelsKt__DeprecatedKt$dropWhile$12.L$0 = producerScope2;
            channelsKt__DeprecatedKt$dropWhile$12.L$1 = it2;
            channelsKt__DeprecatedKt$dropWhile$12.label = 4;
            hasNext2 = it2.hasNext(channelsKt__DeprecatedKt$dropWhile$12);
            if (hasNext2 != obj2) {
            }
        }
    }
}
