package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a#\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001aG\u0010\n\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "", "a", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "predicate", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes16.dex */
final /* synthetic */ class FlowKt__CountKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        kotlinx.coroutines.flow.FlowKt__CountKt$count$1 flowKt__CountKt$count$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.IntRef intRef;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$1) {
            flowKt__CountKt$count$1 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$1) continuation;
            int i2 = flowKt__CountKt$count$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__CountKt$count$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__CountKt$count$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CountKt$count$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.IntRef intRef2 = new kotlin.jvm.internal.Ref.IntRef();
                    kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__CountKt$count$$inlined$collect$1 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$1<>(intRef2);
                    flowKt__CountKt$count$1.L$0 = intRef2;
                    flowKt__CountKt$count$1.label = 1;
                    if (flow.collect(flowKt__CountKt$count$$inlined$collect$1, flowKt__CountKt$count$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intRef = intRef2;
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    intRef = (kotlin.jvm.internal.Ref.IntRef) flowKt__CountKt$count$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                return kotlin.coroutines.jvm.internal.Boxing.boxInt(intRef.element);
            }
        }
        flowKt__CountKt$count$1 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$1(continuation);
        java.lang.Object obj2 = flowKt__CountKt$count$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CountKt$count$1.label;
        if (i != 0) {
        }
        return kotlin.coroutines.jvm.internal.Boxing.boxInt(intRef.element);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        kotlinx.coroutines.flow.FlowKt__CountKt$count$3 flowKt__CountKt$count$3;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.IntRef intRef;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$3) {
            flowKt__CountKt$count$3 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$3) continuation;
            int i2 = flowKt__CountKt$count$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__CountKt$count$3.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__CountKt$count$3.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CountKt$count$3.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.IntRef intRef2 = new kotlin.jvm.internal.Ref.IntRef();
                    kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__CountKt$count$$inlined$collect$2 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2<>(function2, intRef2);
                    flowKt__CountKt$count$3.L$0 = intRef2;
                    flowKt__CountKt$count$3.label = 1;
                    if (flow.collect(flowKt__CountKt$count$$inlined$collect$2, flowKt__CountKt$count$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intRef = intRef2;
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    intRef = (kotlin.jvm.internal.Ref.IntRef) flowKt__CountKt$count$3.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                return kotlin.coroutines.jvm.internal.Boxing.boxInt(intRef.element);
            }
        }
        flowKt__CountKt$count$3 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$3(continuation);
        java.lang.Object obj2 = flowKt__CountKt$count$3.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CountKt$count$3.label;
        if (i != 0) {
        }
        return kotlin.coroutines.jvm.internal.Boxing.boxInt(intRef.element);
    }
}
