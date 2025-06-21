package kotlinx.coroutines.channels;

/* JADX INFO: Add missing generic type declarations: [R] */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {com.anythink.expressad.foundation.g.a.aP, com.anythink.expressad.foundation.g.a.aV, com.anythink.expressad.foundation.g.a.aV}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
/* loaded from: classes16.dex */
public final class ChannelsKt__DeprecatedKt$mapIndexed$1<R> extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.channels.ProducerScope<? super R>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel<E> $this_mapIndexed;
    final /* synthetic */ kotlin.jvm.functions.Function3<java.lang.Integer, E, kotlin.coroutines.Continuation<? super R>, java.lang.Object> $transform;
    int I$0;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$mapIndexed$1(kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super E, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1> continuation) {
        super(2, continuation);
        this.$this_mapIndexed = receiveChannel;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1 = new kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, continuation);
        channelsKt__DeprecatedKt$mapIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$mapIndexed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope<? super R> producerScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1) create(producerScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00ab -> B:7:0x005c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.channels.ProducerScope producerScope;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1<R> channelsKt__DeprecatedKt$mapIndexed$1;
        kotlinx.coroutines.channels.ChannelIterator it;
        int i;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1<R> channelsKt__DeprecatedKt$mapIndexed$12;
        kotlinx.coroutines.channels.ProducerScope producerScope2;
        kotlinx.coroutines.channels.ChannelIterator channelIterator;
        kotlinx.coroutines.channels.ProducerScope producerScope3;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1<R> channelsKt__DeprecatedKt$mapIndexed$13;
        kotlinx.coroutines.channels.ProducerScope producerScope4;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            channelsKt__DeprecatedKt$mapIndexed$1 = this;
            it = this.$this_mapIndexed.iterator();
            i = 0;
        } else if (i2 == 1) {
            i = this.I$0;
            it = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            producerScope4 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            channelsKt__DeprecatedKt$mapIndexed$13 = this;
            if (((java.lang.Boolean) obj).booleanValue()) {
                return kotlin.Unit.INSTANCE;
            }
            java.lang.Object next = it.next();
            kotlin.jvm.functions.Function3<java.lang.Integer, E, kotlin.coroutines.Continuation<? super R>, java.lang.Object> function3 = channelsKt__DeprecatedKt$mapIndexed$13.$transform;
            int i3 = i + 1;
            java.lang.Integer boxInt = kotlin.coroutines.jvm.internal.Boxing.boxInt(i);
            channelsKt__DeprecatedKt$mapIndexed$13.L$0 = producerScope4;
            channelsKt__DeprecatedKt$mapIndexed$13.L$1 = it;
            channelsKt__DeprecatedKt$mapIndexed$13.L$2 = producerScope4;
            channelsKt__DeprecatedKt$mapIndexed$13.I$0 = i3;
            channelsKt__DeprecatedKt$mapIndexed$13.label = 2;
            obj = function3.invoke(boxInt, next, channelsKt__DeprecatedKt$mapIndexed$13);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            channelsKt__DeprecatedKt$mapIndexed$12 = channelsKt__DeprecatedKt$mapIndexed$13;
            i = i3;
            producerScope2 = producerScope4;
            channelIterator = it;
            producerScope3 = producerScope2;
            channelsKt__DeprecatedKt$mapIndexed$12.L$0 = producerScope2;
            channelsKt__DeprecatedKt$mapIndexed$12.L$1 = channelIterator;
            channelsKt__DeprecatedKt$mapIndexed$12.L$2 = null;
            channelsKt__DeprecatedKt$mapIndexed$12.I$0 = i;
            channelsKt__DeprecatedKt$mapIndexed$12.label = 3;
            if (producerScope3.send(obj, channelsKt__DeprecatedKt$mapIndexed$12) != coroutine_suspended) {
            }
        } else if (i2 == 2) {
            i = this.I$0;
            producerScope3 = (kotlinx.coroutines.channels.ProducerScope) this.L$2;
            channelIterator = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            producerScope2 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            channelsKt__DeprecatedKt$mapIndexed$12 = this;
            channelsKt__DeprecatedKt$mapIndexed$12.L$0 = producerScope2;
            channelsKt__DeprecatedKt$mapIndexed$12.L$1 = channelIterator;
            channelsKt__DeprecatedKt$mapIndexed$12.L$2 = null;
            channelsKt__DeprecatedKt$mapIndexed$12.I$0 = i;
            channelsKt__DeprecatedKt$mapIndexed$12.label = 3;
            if (producerScope3.send(obj, channelsKt__DeprecatedKt$mapIndexed$12) != coroutine_suspended) {
                return coroutine_suspended;
            }
            it = channelIterator;
            producerScope = producerScope2;
            channelsKt__DeprecatedKt$mapIndexed$1 = channelsKt__DeprecatedKt$mapIndexed$12;
        } else {
            if (i2 != 3) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            it = (kotlinx.coroutines.channels.ChannelIterator) this.L$1;
            kotlinx.coroutines.channels.ProducerScope producerScope5 = (kotlinx.coroutines.channels.ProducerScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            producerScope = producerScope5;
            channelsKt__DeprecatedKt$mapIndexed$1 = this;
        }
        channelsKt__DeprecatedKt$mapIndexed$1.L$0 = producerScope;
        channelsKt__DeprecatedKt$mapIndexed$1.L$1 = it;
        channelsKt__DeprecatedKt$mapIndexed$1.I$0 = i;
        channelsKt__DeprecatedKt$mapIndexed$1.label = 1;
        java.lang.Object hasNext = it.hasNext(channelsKt__DeprecatedKt$mapIndexed$1);
        if (hasNext == coroutine_suspended) {
            return coroutine_suspended;
        }
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1<R> channelsKt__DeprecatedKt$mapIndexed$14 = channelsKt__DeprecatedKt$mapIndexed$1;
        producerScope4 = producerScope;
        obj = hasNext;
        channelsKt__DeprecatedKt$mapIndexed$13 = channelsKt__DeprecatedKt$mapIndexed$14;
        if (((java.lang.Boolean) obj).booleanValue()) {
        }
    }
}
