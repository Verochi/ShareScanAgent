package kotlinx.coroutines.flow;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/FlowCollector;", "downstream", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {}, l = {224, 358}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class FlowKt__DelayKt$debounceInternal$1<T> extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, kotlinx.coroutines.flow.FlowCollector<? super T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ kotlinx.coroutines.flow.Flow<T> $this_debounceInternal;
    final /* synthetic */ kotlin.jvm.functions.Function1<T, java.lang.Long> $timeoutMillisSelector;
    private /* synthetic */ java.lang.Object L$0;
    /* synthetic */ java.lang.Object L$1;
    java.lang.Object L$2;
    java.lang.Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1(kotlin.jvm.functions.Function1<? super T, java.lang.Long> function1, kotlinx.coroutines.flow.Flow<? extends T> flow, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:50|26|30|31|32|33|(1:35)|36|37|(1:39)|(1:41)(1:42)) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f8, code lost:
    
        r10.handleBuilderException(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e0 A[Catch: all -> 0x00f7, TryCatch #0 {all -> 0x00f7, blocks: (B:33:0x00dc, B:35:0x00e0, B:36:0x00ea), top: B:32:0x00dc }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x010b -> B:6:0x006f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.flow.FlowCollector flowCollector;
        kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1<T> flowKt__DelayKt$debounceInternal$1;
        kotlinx.coroutines.channels.ReceiveChannel produce$default;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        kotlin.jvm.internal.Ref.LongRef longRef;
        java.lang.Object obj2;
        java.lang.Object result;
        java.lang.Object coroutine_suspended2;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            kotlinx.coroutines.CoroutineScope coroutineScope = (kotlinx.coroutines.CoroutineScope) this.L$0;
            flowCollector = (kotlinx.coroutines.flow.FlowCollector) this.L$1;
            flowKt__DelayKt$debounceInternal$1 = this;
            produce$default = kotlinx.coroutines.channels.ProduceKt.produce$default(coroutineScope, null, 0, new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, null);
            objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        } else if (i == 1) {
            kotlin.jvm.internal.Ref.LongRef longRef2 = (kotlin.jvm.internal.Ref.LongRef) this.L$3;
            objectRef = (kotlin.jvm.internal.Ref.ObjectRef) this.L$2;
            produce$default = (kotlinx.coroutines.channels.ReceiveChannel) this.L$1;
            flowCollector = (kotlinx.coroutines.flow.FlowCollector) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            longRef = longRef2;
            flowKt__DelayKt$debounceInternal$1 = this;
            objectRef.element = null;
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1<T> flowKt__DelayKt$debounceInternal$12 = flowKt__DelayKt$debounceInternal$1;
            obj2 = coroutine_suspended;
            kotlin.jvm.internal.Ref.LongRef longRef3 = longRef;
            kotlinx.coroutines.flow.FlowCollector flowCollector2 = flowCollector;
            kotlinx.coroutines.channels.ReceiveChannel receiveChannel = produce$default;
            flowKt__DelayKt$debounceInternal$12.L$0 = flowCollector2;
            flowKt__DelayKt$debounceInternal$12.L$1 = receiveChannel;
            flowKt__DelayKt$debounceInternal$12.L$2 = objectRef;
            flowKt__DelayKt$debounceInternal$12.L$3 = longRef3;
            flowKt__DelayKt$debounceInternal$12.label = 2;
            kotlinx.coroutines.selects.SelectInstance selectInstance = new kotlinx.coroutines.selects.SelectInstance(flowKt__DelayKt$debounceInternal$12);
            if (objectRef.element != null) {
                selectInstance.onTimeout(longRef3.element, new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1(flowCollector2, objectRef, null));
            }
            selectInstance.invoke(receiveChannel.getOnReceiveCatching(), new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2(objectRef, flowCollector2, null));
            result = selectInstance.getResult();
            coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended2) {
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(flowKt__DelayKt$debounceInternal$12);
            }
            if (result != obj2) {
                return obj2;
            }
            coroutine_suspended = obj2;
            flowKt__DelayKt$debounceInternal$1 = flowKt__DelayKt$debounceInternal$12;
            produce$default = receiveChannel;
            flowCollector = flowCollector2;
        } else {
            if (i != 2) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.jvm.internal.Ref.ObjectRef objectRef2 = (kotlin.jvm.internal.Ref.ObjectRef) this.L$2;
            kotlinx.coroutines.channels.ReceiveChannel receiveChannel2 = (kotlinx.coroutines.channels.ReceiveChannel) this.L$1;
            kotlinx.coroutines.flow.FlowCollector flowCollector3 = (kotlinx.coroutines.flow.FlowCollector) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            flowCollector = flowCollector3;
            produce$default = receiveChannel2;
            objectRef = objectRef2;
            flowKt__DelayKt$debounceInternal$1 = this;
        }
        if (objectRef.element == kotlinx.coroutines.flow.internal.NullSurrogateKt.DONE) {
            return kotlin.Unit.INSTANCE;
        }
        longRef = new kotlin.jvm.internal.Ref.LongRef();
        T t = objectRef.element;
        if (t != null) {
            kotlin.jvm.functions.Function1<T, java.lang.Long> function1 = flowKt__DelayKt$debounceInternal$1.$timeoutMillisSelector;
            kotlinx.coroutines.internal.Symbol symbol = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL;
            if (t == symbol) {
                t = null;
            }
            long longValue = function1.invoke(t).longValue();
            longRef.element = longValue;
            if (!(longValue >= 0)) {
                throw new java.lang.IllegalArgumentException("Debounce timeout should not be negative".toString());
            }
            if (longValue == 0) {
                T t2 = objectRef.element;
                if (t2 == symbol) {
                    t2 = null;
                }
                flowKt__DelayKt$debounceInternal$1.L$0 = flowCollector;
                flowKt__DelayKt$debounceInternal$1.L$1 = produce$default;
                flowKt__DelayKt$debounceInternal$1.L$2 = objectRef;
                flowKt__DelayKt$debounceInternal$1.L$3 = longRef;
                flowKt__DelayKt$debounceInternal$1.label = 1;
                if (flowCollector.emit(t2, flowKt__DelayKt$debounceInternal$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef.element = null;
            }
        }
        kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1<T> flowKt__DelayKt$debounceInternal$122 = flowKt__DelayKt$debounceInternal$1;
        obj2 = coroutine_suspended;
        kotlin.jvm.internal.Ref.LongRef longRef32 = longRef;
        kotlinx.coroutines.flow.FlowCollector flowCollector22 = flowCollector;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel3 = produce$default;
        flowKt__DelayKt$debounceInternal$122.L$0 = flowCollector22;
        flowKt__DelayKt$debounceInternal$122.L$1 = receiveChannel3;
        flowKt__DelayKt$debounceInternal$122.L$2 = objectRef;
        flowKt__DelayKt$debounceInternal$122.L$3 = longRef32;
        flowKt__DelayKt$debounceInternal$122.label = 2;
        kotlinx.coroutines.selects.SelectInstance selectInstance2 = new kotlinx.coroutines.selects.SelectInstance(flowKt__DelayKt$debounceInternal$122);
        if (objectRef.element != null) {
        }
        selectInstance2.invoke(receiveChannel3.getOnReceiveCatching(), new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2(objectRef, flowCollector22, null));
        result = selectInstance2.getResult();
        coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended2) {
        }
        if (result != obj2) {
        }
    }
}
