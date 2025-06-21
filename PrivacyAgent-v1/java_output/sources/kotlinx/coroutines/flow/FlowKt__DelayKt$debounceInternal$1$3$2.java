package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ChannelResult;", "", "value", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.channels.ChannelResult<? extends java.lang.Object>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ kotlinx.coroutines.flow.FlowCollector<T> $downstream;
    final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> $lastValue;
    /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$2(kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef, kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2> continuation) {
        super(2, continuation);
        this.$lastValue = objectRef;
        this.$downstream = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, continuation);
        flowKt__DelayKt$debounceInternal$1$3$2.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ java.lang.Object mo5invoke(kotlinx.coroutines.channels.ChannelResult<? extends java.lang.Object> channelResult, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return m791invokeWpGqRn0(channelResult.getHolder(), continuation);
    }

    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final java.lang.Object m791invokeWpGqRn0(@org.jetbrains.annotations.NotNull java.lang.Object obj, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2) create(kotlinx.coroutines.channels.ChannelResult.m771boximpl(obj), continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [T, kotlinx.coroutines.internal.Symbol] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef;
        kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef2;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            ?? holder = ((kotlinx.coroutines.channels.ChannelResult) this.L$0).getHolder();
            objectRef = this.$lastValue;
            boolean z = holder instanceof kotlinx.coroutines.channels.ChannelResult.Failed;
            if (!z) {
                objectRef.element = holder;
            }
            kotlinx.coroutines.flow.FlowCollector<T> flowCollector = this.$downstream;
            if (z) {
                java.lang.Throwable m775exceptionOrNullimpl = kotlinx.coroutines.channels.ChannelResult.m775exceptionOrNullimpl(holder);
                if (m775exceptionOrNullimpl != null) {
                    throw m775exceptionOrNullimpl;
                }
                java.lang.Object obj2 = objectRef.element;
                if (obj2 != null) {
                    if (obj2 == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                        obj2 = null;
                    }
                    this.L$0 = holder;
                    this.L$1 = objectRef;
                    this.label = 1;
                    if (flowCollector.emit(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef2 = objectRef;
                }
                objectRef.element = kotlinx.coroutines.flow.internal.NullSurrogateKt.DONE;
            }
            return kotlin.Unit.INSTANCE;
        }
        if (i != 1) {
            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2 = (kotlin.jvm.internal.Ref.ObjectRef) this.L$1;
        kotlin.ResultKt.throwOnFailure(obj);
        objectRef = objectRef2;
        objectRef.element = kotlinx.coroutines.flow.internal.NullSurrogateKt.DONE;
        return kotlin.Unit.INSTANCE;
    }
}
