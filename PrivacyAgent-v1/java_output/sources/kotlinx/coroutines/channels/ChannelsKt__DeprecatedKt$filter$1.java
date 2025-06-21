package kotlinx.coroutines.channels;

/* JADX INFO: Add missing generic type declarations: [E] */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {178, 179, 179}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$filter$1<E> extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.channels.ProducerScope<? super E>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> $predicate;
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel<E> $this_filter;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filter$1(kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1> continuation) {
        super(2, continuation);
        this.$this_filter = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1 channelsKt__DeprecatedKt$filter$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1(this.$this_filter, this.$predicate, continuation);
        channelsKt__DeprecatedKt$filter$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filter$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope<? super E> producerScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1) create(producerScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
    
        r11 = r0;
        r0 = r1;
        r1 = r6;
        r6 = r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.channels.ChannelIterator<E> it;
        kotlinx.coroutines.channels.ProducerScope producerScope;
        kotlinx.coroutines.channels.ChannelIterator<E> channelIterator;
        java.lang.Object obj2;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1<E> channelsKt__DeprecatedKt$filter$1;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1<E> channelsKt__DeprecatedKt$filter$12;
        kotlinx.coroutines.channels.ProducerScope producerScope2;
        java.lang.Object hasNext;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            kotlinx.coroutines.channels.ProducerScope producerScope3 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            it = this.$this_filter.iterator();
            producerScope = producerScope3;
        } else if (i == 1) {
            kotlinx.coroutines.channels.ChannelIterator<E> channelIterator2 = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope4 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope2 = producerScope4;
            channelIterator = channelIterator2;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$filter$1 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
        } else if (i == 2) {
            java.lang.Object obj3 = this.L$2;
            channelIterator = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope5 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            kotlinx.coroutines.channels.ProducerScope producerScope6 = producerScope5;
            E e = obj3;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$filter$1 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
                channelsKt__DeprecatedKt$filter$1.L$0 = producerScope6;
                channelsKt__DeprecatedKt$filter$1.L$1 = channelIterator;
                channelsKt__DeprecatedKt$filter$1.L$2 = null;
                channelsKt__DeprecatedKt$filter$1.label = 3;
                if (producerScope6.send(e, channelsKt__DeprecatedKt$filter$1) == obj2) {
                    return obj2;
                }
            }
            channelsKt__DeprecatedKt$filter$12 = channelsKt__DeprecatedKt$filter$1;
            coroutine_suspended = obj2;
            it = channelIterator;
            producerScope = producerScope6;
            channelsKt__DeprecatedKt$filter$12.L$0 = producerScope;
            channelsKt__DeprecatedKt$filter$12.L$1 = it;
            channelsKt__DeprecatedKt$filter$12.L$2 = null;
            channelsKt__DeprecatedKt$filter$12.label = 1;
            hasNext = it.hasNext(channelsKt__DeprecatedKt$filter$12);
            if (hasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
            java.lang.Object obj4 = coroutine_suspended;
            channelsKt__DeprecatedKt$filter$1 = channelsKt__DeprecatedKt$filter$12;
            obj = hasNext;
            producerScope2 = producerScope;
            channelIterator = it;
            obj2 = obj4;
            if (((java.lang.Boolean) obj).booleanValue()) {
                return kotlin.Unit.INSTANCE;
            }
            E next = channelIterator.next();
            kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> function2 = channelsKt__DeprecatedKt$filter$1.$predicate;
            channelsKt__DeprecatedKt$filter$1.L$0 = producerScope2;
            channelsKt__DeprecatedKt$filter$1.L$1 = channelIterator;
            channelsKt__DeprecatedKt$filter$1.L$2 = next;
            channelsKt__DeprecatedKt$filter$1.label = 2;
            java.lang.Object mo5invoke = function2.mo5invoke(next, channelsKt__DeprecatedKt$filter$1);
            if (mo5invoke == obj2) {
                return obj2;
            }
            kotlinx.coroutines.channels.ProducerScope producerScope7 = producerScope2;
            e = next;
            obj = mo5invoke;
            producerScope6 = producerScope7;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
            channelsKt__DeprecatedKt$filter$12 = channelsKt__DeprecatedKt$filter$1;
            coroutine_suspended = obj2;
            it = channelIterator;
            producerScope = producerScope6;
            channelsKt__DeprecatedKt$filter$12.L$0 = producerScope;
            channelsKt__DeprecatedKt$filter$12.L$1 = it;
            channelsKt__DeprecatedKt$filter$12.L$2 = null;
            channelsKt__DeprecatedKt$filter$12.label = 1;
            hasNext = it.hasNext(channelsKt__DeprecatedKt$filter$12);
            if (hasNext == coroutine_suspended) {
            }
        } else {
            if (i != 3) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            producerScope = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
        }
        channelsKt__DeprecatedKt$filter$12 = this;
        channelsKt__DeprecatedKt$filter$12.L$0 = producerScope;
        channelsKt__DeprecatedKt$filter$12.L$1 = it;
        channelsKt__DeprecatedKt$filter$12.L$2 = null;
        channelsKt__DeprecatedKt$filter$12.label = 1;
        hasNext = it.hasNext(channelsKt__DeprecatedKt$filter$12);
        if (hasNext == coroutine_suspended) {
        }
    }
}
