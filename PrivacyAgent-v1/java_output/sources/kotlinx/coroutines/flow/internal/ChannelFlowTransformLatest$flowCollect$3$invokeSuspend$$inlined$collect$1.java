package kotlinx.coroutines.flow.internal;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1<T> implements kotlinx.coroutines.flow.FlowCollector<T> {
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef n;
    public final /* synthetic */ kotlinx.coroutines.CoroutineScope t;
    public final /* synthetic */ kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest u;
    public final /* synthetic */ kotlinx.coroutines.flow.FlowCollector v;

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1", f = "Merge.kt", i = {0, 0}, l = {com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON}, m = "emit", n = {"this", "value"}, s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        int label;
        /* synthetic */ java.lang.Object result;

        public AnonymousClass1(kotlin.coroutines.Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1(kotlin.jvm.internal.Ref.ObjectRef objectRef, kotlinx.coroutines.CoroutineScope coroutineScope, kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest channelFlowTransformLatest, kotlinx.coroutines.flow.FlowCollector flowCollector) {
        this.n = objectRef;
        this.t = coroutineScope;
        this.u = channelFlowTransformLatest;
        this.v = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Object emit(T t, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.AnonymousClass1 anonymousClass1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1<T> channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1;
        kotlinx.coroutines.Job e;
        if (continuation instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.AnonymousClass1) {
            anonymousClass1 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = anonymousClass1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) this.n.element;
                    if (job != null) {
                        job.cancel((java.util.concurrent.CancellationException) new kotlinx.coroutines.flow.internal.ChildCancelledException());
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = t;
                        anonymousClass1.L$2 = job;
                        anonymousClass1.label = 1;
                        if (job.join(anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 = this;
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    t = (T) anonymousClass1.L$1;
                    channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                kotlin.jvm.internal.Ref.ObjectRef objectRef = channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.n;
                e = kotlinx.coroutines.BuildersKt__Builders_commonKt.e(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.t, null, kotlinx.coroutines.CoroutineStart.UNDISPATCHED, new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.u, channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.v, t, null), 1, null);
                objectRef.element = (T) e;
                return kotlin.Unit.INSTANCE;
            }
        }
        anonymousClass1 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.AnonymousClass1(continuation);
        java.lang.Object obj2 = anonymousClass1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        kotlin.jvm.internal.Ref.ObjectRef objectRef2 = channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.n;
        e = kotlinx.coroutines.BuildersKt__Builders_commonKt.e(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.t, null, kotlinx.coroutines.CoroutineStart.UNDISPATCHED, new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.u, channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.v, t, null), 1, null);
        objectRef2.element = (T) e;
        return kotlin.Unit.INSTANCE;
    }
}
