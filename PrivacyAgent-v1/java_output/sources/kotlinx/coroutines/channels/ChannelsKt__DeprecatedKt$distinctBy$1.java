package kotlinx.coroutines.channels;

/* JADX INFO: Add missing generic type declarations: [E] */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "K", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {326, 327, 329}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$distinctBy$1<E> extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.channels.ProducerScope<? super E>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super K>, java.lang.Object> $selector;
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel<E> $this_distinctBy;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    java.lang.Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$distinctBy$1(kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super K>, ? extends java.lang.Object> function2, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1> continuation) {
        super(2, continuation);
        this.$this_distinctBy = receiveChannel;
        this.$selector = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, continuation);
        channelsKt__DeprecatedKt$distinctBy$1.L$0 = obj;
        return channelsKt__DeprecatedKt$distinctBy$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope<? super E> producerScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1) create(producerScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d8  */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c5 -> B:7:0x00cb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00d2 -> B:8:0x0071). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.channels.ProducerScope producerScope;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1<E> channelsKt__DeprecatedKt$distinctBy$1;
        java.util.HashSet hashSet;
        kotlinx.coroutines.channels.ChannelIterator<E> it;
        kotlinx.coroutines.channels.ProducerScope producerScope2;
        java.util.HashSet hashSet2;
        E e;
        kotlinx.coroutines.channels.ChannelIterator<E> channelIterator;
        java.lang.Object obj2;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1<E> channelsKt__DeprecatedKt$distinctBy$12;
        kotlinx.coroutines.channels.ProducerScope producerScope3;
        java.util.HashSet hashSet3;
        java.lang.Object hasNext;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            kotlinx.coroutines.channels.ProducerScope producerScope4 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            java.util.HashSet hashSet4 = new java.util.HashSet();
            producerScope = producerScope4;
            channelsKt__DeprecatedKt$distinctBy$1 = this;
            hashSet = hashSet4;
            it = this.$this_distinctBy.iterator();
            channelsKt__DeprecatedKt$distinctBy$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$distinctBy$1.L$1 = hashSet;
            channelsKt__DeprecatedKt$distinctBy$1.L$2 = it;
            channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
            channelsKt__DeprecatedKt$distinctBy$1.label = 1;
            hasNext = it.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
            if (hasNext != coroutine_suspended) {
            }
        } else if (i == 1) {
            kotlinx.coroutines.channels.ChannelIterator<E> channelIterator2 = (kotlinx.coroutines.channels.ChannelIterator) this.L$2;
            java.util.HashSet hashSet5 = (java.util.HashSet) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope5 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope3 = producerScope5;
            hashSet3 = hashSet5;
            channelIterator = channelIterator2;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$distinctBy$12 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
            }
        } else if (i == 2) {
            ?? r1 = this.L$3;
            channelIterator = (kotlinx.coroutines.channels.ChannelIterator) this.L$2;
            java.util.HashSet hashSet6 = (java.util.HashSet) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope6 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope2 = producerScope6;
            hashSet2 = hashSet6;
            e = r1;
            obj2 = coroutine_suspended;
            channelsKt__DeprecatedKt$distinctBy$12 = this;
            if (hashSet2.contains(obj)) {
            }
        } else {
            if (i != 3) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            java.lang.Object obj3 = this.L$3;
            channelIterator = (kotlinx.coroutines.channels.ChannelIterator) this.L$2;
            java.util.HashSet hashSet7 = (java.util.HashSet) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope7 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            channelsKt__DeprecatedKt$distinctBy$1 = this;
            ?? r6 = hashSet7;
            r6.add(obj3);
            it = channelIterator;
            hashSet = r6;
            producerScope = producerScope7;
            channelsKt__DeprecatedKt$distinctBy$1.L$0 = producerScope;
            channelsKt__DeprecatedKt$distinctBy$1.L$1 = hashSet;
            channelsKt__DeprecatedKt$distinctBy$1.L$2 = it;
            channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
            channelsKt__DeprecatedKt$distinctBy$1.label = 1;
            hasNext = it.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
            if (hasNext != coroutine_suspended) {
                return coroutine_suspended;
            }
            java.lang.Object obj4 = coroutine_suspended;
            channelsKt__DeprecatedKt$distinctBy$12 = channelsKt__DeprecatedKt$distinctBy$1;
            obj = hasNext;
            producerScope3 = producerScope;
            hashSet3 = hashSet;
            channelIterator = it;
            obj2 = obj4;
            if (((java.lang.Boolean) obj).booleanValue()) {
                return kotlin.Unit.INSTANCE;
            }
            E next = channelIterator.next();
            kotlin.jvm.functions.Function2 function2 = channelsKt__DeprecatedKt$distinctBy$12.$selector;
            channelsKt__DeprecatedKt$distinctBy$12.L$0 = producerScope3;
            channelsKt__DeprecatedKt$distinctBy$12.L$1 = hashSet3;
            channelsKt__DeprecatedKt$distinctBy$12.L$2 = channelIterator;
            channelsKt__DeprecatedKt$distinctBy$12.L$3 = next;
            channelsKt__DeprecatedKt$distinctBy$12.label = 2;
            java.lang.Object mo5invoke = function2.mo5invoke(next, channelsKt__DeprecatedKt$distinctBy$12);
            if (mo5invoke == obj2) {
                return obj2;
            }
            java.util.HashSet hashSet8 = hashSet3;
            e = next;
            obj = mo5invoke;
            producerScope2 = producerScope3;
            hashSet2 = hashSet8;
            if (hashSet2.contains(obj)) {
                channelsKt__DeprecatedKt$distinctBy$12.L$0 = producerScope2;
                channelsKt__DeprecatedKt$distinctBy$12.L$1 = hashSet2;
                channelsKt__DeprecatedKt$distinctBy$12.L$2 = channelIterator;
                channelsKt__DeprecatedKt$distinctBy$12.L$3 = obj;
                channelsKt__DeprecatedKt$distinctBy$12.label = 3;
                if (producerScope2.send(e, channelsKt__DeprecatedKt$distinctBy$12) == obj2) {
                    return obj2;
                }
                r6 = hashSet2;
                producerScope7 = producerScope2;
                java.lang.Object obj5 = obj2;
                obj3 = obj;
                channelsKt__DeprecatedKt$distinctBy$1 = channelsKt__DeprecatedKt$distinctBy$12;
                coroutine_suspended = obj5;
                r6.add(obj3);
                it = channelIterator;
                hashSet = r6;
                producerScope = producerScope7;
                channelsKt__DeprecatedKt$distinctBy$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$distinctBy$1.L$1 = hashSet;
                channelsKt__DeprecatedKt$distinctBy$1.L$2 = it;
                channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
                channelsKt__DeprecatedKt$distinctBy$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
                if (hasNext != coroutine_suspended) {
                }
            } else {
                channelsKt__DeprecatedKt$distinctBy$1 = channelsKt__DeprecatedKt$distinctBy$12;
                coroutine_suspended = obj2;
                it = channelIterator;
                hashSet = hashSet2;
                producerScope = producerScope2;
                channelsKt__DeprecatedKt$distinctBy$1.L$0 = producerScope;
                channelsKt__DeprecatedKt$distinctBy$1.L$1 = hashSet;
                channelsKt__DeprecatedKt$distinctBy$1.L$2 = it;
                channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
                channelsKt__DeprecatedKt$distinctBy$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
    }
}
