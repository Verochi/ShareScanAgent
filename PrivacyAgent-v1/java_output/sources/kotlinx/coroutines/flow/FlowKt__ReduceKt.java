package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001au\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00022F\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a{\u0010\u0010\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00028\u00012H\b\u0004\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013\u001a#\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013\u001aG\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a%\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0013\u001aI\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001a\u001a#\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013\u001a%\u0010\u001e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "accumulator", "value", "Lkotlin/coroutines/Continuation;", "", "operation", "h", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "initial", "acc", "e", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "a", "Lkotlin/Function2;", "", "predicate", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "d", "f", "g", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes16.dex */
final /* synthetic */ class FlowKt__ReduceKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 flowKt__ReduceKt$first$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        kotlinx.coroutines.flow.internal.AbortFlowException e;
        kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowCollector;
        T t;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1) {
            flowKt__ReduceKt$first$1 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1) continuation;
            int i2 = flowKt__ReduceKt$first$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__ReduceKt$first$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$first$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                    objectRef2.element = (T) kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL;
                    kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__ReduceKt$first$$inlined$collectWhile$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1<>(objectRef2);
                    try {
                        flowKt__ReduceKt$first$1.L$0 = objectRef2;
                        flowKt__ReduceKt$first$1.L$1 = flowKt__ReduceKt$first$$inlined$collectWhile$1;
                        flowKt__ReduceKt$first$1.label = 1;
                        if (flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$1, flowKt__ReduceKt$first$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    } catch (kotlinx.coroutines.flow.internal.AbortFlowException e2) {
                        objectRef = objectRef2;
                        e = e2;
                        flowCollector = flowKt__ReduceKt$first$$inlined$collectWhile$1;
                        kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        t = objectRef.element;
                        if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1) flowKt__ReduceKt$first$1.L$1;
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) flowKt__ReduceKt$first$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (kotlinx.coroutines.flow.internal.AbortFlowException e3) {
                        e = e3;
                        kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        t = objectRef.element;
                        if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                        }
                    }
                }
                t = objectRef.element;
                if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                    return t;
                }
                throw new java.util.NoSuchElementException("Expected at least one element");
            }
        }
        flowKt__ReduceKt$first$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1(continuation);
        java.lang.Object obj2 = flowKt__ReduceKt$first$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$first$1.label;
        if (i != 0) {
        }
        t = objectRef.element;
        if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 flowKt__ReduceKt$first$3;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function22;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        kotlinx.coroutines.flow.internal.AbortFlowException e;
        kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowCollector;
        T t;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3) {
            flowKt__ReduceKt$first$3 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3) continuation;
            int i2 = flowKt__ReduceKt$first$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$3.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__ReduceKt$first$3.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$first$3.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                    objectRef2.element = (T) kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL;
                    kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__ReduceKt$first$$inlined$collectWhile$2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2<>(function2, objectRef2);
                    try {
                        flowKt__ReduceKt$first$3.L$0 = function2;
                        flowKt__ReduceKt$first$3.L$1 = objectRef2;
                        flowKt__ReduceKt$first$3.L$2 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                        flowKt__ReduceKt$first$3.label = 1;
                        if (flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$2, flowKt__ReduceKt$first$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function22 = function2;
                        objectRef = objectRef2;
                    } catch (kotlinx.coroutines.flow.internal.AbortFlowException e2) {
                        function22 = function2;
                        objectRef = objectRef2;
                        e = e2;
                        flowCollector = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                        kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        t = objectRef.element;
                        if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2) flowKt__ReduceKt$first$3.L$2;
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) flowKt__ReduceKt$first$3.L$1;
                    function22 = (kotlin.jvm.functions.Function2) flowKt__ReduceKt$first$3.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (kotlinx.coroutines.flow.internal.AbortFlowException e3) {
                        e = e3;
                        kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        t = objectRef.element;
                        if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                        }
                    }
                }
                t = objectRef.element;
                if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                    return t;
                }
                throw new java.util.NoSuchElementException(kotlin.jvm.internal.Intrinsics.stringPlus("Expected at least one element matching the predicate ", function22));
            }
        }
        flowKt__ReduceKt$first$3 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3(continuation);
        java.lang.Object obj2 = flowKt__ReduceKt$first$3.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$first$3.label;
        if (i != 0) {
        }
        t = objectRef.element;
        if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object c(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 flowKt__ReduceKt$firstOrNull$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        kotlinx.coroutines.flow.internal.AbortFlowException e;
        kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowCollector;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1) {
            flowKt__ReduceKt$firstOrNull$1 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1) continuation;
            int i2 = flowKt__ReduceKt$firstOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$firstOrNull$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__ReduceKt$firstOrNull$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$firstOrNull$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                    kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1<>(objectRef2);
                    try {
                        flowKt__ReduceKt$firstOrNull$1.L$0 = objectRef2;
                        flowKt__ReduceKt$firstOrNull$1.L$1 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1;
                        flowKt__ReduceKt$firstOrNull$1.label = 1;
                        if (flow.collect(flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1, flowKt__ReduceKt$firstOrNull$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    } catch (kotlinx.coroutines.flow.internal.AbortFlowException e2) {
                        objectRef = objectRef2;
                        e = e2;
                        flowCollector = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1;
                        kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        return objectRef.element;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1) flowKt__ReduceKt$firstOrNull$1.L$1;
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) flowKt__ReduceKt$firstOrNull$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (kotlinx.coroutines.flow.internal.AbortFlowException e3) {
                        e = e3;
                        kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        return objectRef.element;
                    }
                }
                return objectRef.element;
            }
        }
        flowKt__ReduceKt$firstOrNull$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1(continuation);
        java.lang.Object obj2 = flowKt__ReduceKt$firstOrNull$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$firstOrNull$1.label;
        if (i != 0) {
        }
        return objectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object d(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> function2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 flowKt__ReduceKt$firstOrNull$3;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        kotlinx.coroutines.flow.internal.AbortFlowException e;
        kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowCollector;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3) {
            flowKt__ReduceKt$firstOrNull$3 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3) continuation;
            int i2 = flowKt__ReduceKt$firstOrNull$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$firstOrNull$3.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__ReduceKt$firstOrNull$3.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$firstOrNull$3.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                    kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2<>(function2, objectRef2);
                    try {
                        flowKt__ReduceKt$firstOrNull$3.L$0 = objectRef2;
                        flowKt__ReduceKt$firstOrNull$3.L$1 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
                        flowKt__ReduceKt$firstOrNull$3.label = 1;
                        if (flow.collect(flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2, flowKt__ReduceKt$firstOrNull$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    } catch (kotlinx.coroutines.flow.internal.AbortFlowException e2) {
                        objectRef = objectRef2;
                        e = e2;
                        flowCollector = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
                        kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        return objectRef.element;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector = (kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) flowKt__ReduceKt$firstOrNull$3.L$1;
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) flowKt__ReduceKt$firstOrNull$3.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (kotlinx.coroutines.flow.internal.AbortFlowException e3) {
                        e = e3;
                        kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        return objectRef.element;
                    }
                }
                return objectRef.element;
            }
        }
        flowKt__ReduceKt$firstOrNull$3 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3(continuation);
        java.lang.Object obj2 = flowKt__ReduceKt$firstOrNull$3.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$firstOrNull$3.label;
        if (i != 0) {
        }
        return objectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, R> java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super R, ? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> continuation) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 flowKt__ReduceKt$fold$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1) {
            flowKt__ReduceKt$fold$1 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1) continuation;
            int i2 = flowKt__ReduceKt$fold$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$fold$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__ReduceKt$fold$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$fold$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                    objectRef2.element = r;
                    kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__ReduceKt$fold$$inlined$collect$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$1<>(objectRef2, function3);
                    flowKt__ReduceKt$fold$1.L$0 = objectRef2;
                    flowKt__ReduceKt$fold$1.label = 1;
                    if (flow.collect(flowKt__ReduceKt$fold$$inlined$collect$1, flowKt__ReduceKt$fold$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) flowKt__ReduceKt$fold$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                return objectRef.element;
            }
        }
        flowKt__ReduceKt$fold$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1(continuation);
        java.lang.Object obj2 = flowKt__ReduceKt$fold$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$fold$1.label;
        if (i != 0) {
        }
        return objectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object f(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1 flowKt__ReduceKt$last$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        T t;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1) {
            flowKt__ReduceKt$last$1 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1) continuation;
            int i2 = flowKt__ReduceKt$last$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$last$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__ReduceKt$last$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$last$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                    objectRef2.element = (T) kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL;
                    kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__ReduceKt$last$$inlined$collect$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$last$$inlined$collect$1<>(objectRef2);
                    flowKt__ReduceKt$last$1.L$0 = objectRef2;
                    flowKt__ReduceKt$last$1.label = 1;
                    if (flow.collect(flowKt__ReduceKt$last$$inlined$collect$1, flowKt__ReduceKt$last$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) flowKt__ReduceKt$last$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                t = objectRef.element;
                if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                    return t;
                }
                throw new java.util.NoSuchElementException("Expected at least one element");
            }
        }
        flowKt__ReduceKt$last$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1(continuation);
        java.lang.Object obj2 = flowKt__ReduceKt$last$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$last$1.label;
        if (i != 0) {
        }
        t = objectRef.element;
        if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object g(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1 flowKt__ReduceKt$lastOrNull$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1) {
            flowKt__ReduceKt$lastOrNull$1 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1) continuation;
            int i2 = flowKt__ReduceKt$lastOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$lastOrNull$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__ReduceKt$lastOrNull$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$lastOrNull$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                    kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__ReduceKt$lastOrNull$$inlined$collect$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$$inlined$collect$1<>(objectRef2);
                    flowKt__ReduceKt$lastOrNull$1.L$0 = objectRef2;
                    flowKt__ReduceKt$lastOrNull$1.label = 1;
                    if (flow.collect(flowKt__ReduceKt$lastOrNull$$inlined$collect$1, flowKt__ReduceKt$lastOrNull$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) flowKt__ReduceKt$lastOrNull$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                return objectRef.element;
            }
        }
        flowKt__ReduceKt$lastOrNull$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1(continuation);
        java.lang.Object obj2 = flowKt__ReduceKt$lastOrNull$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$lastOrNull$1.label;
        if (i != 0) {
        }
        return objectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.Symbol] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S, T extends S> java.lang.Object h(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super S, ? super T, ? super kotlin.coroutines.Continuation<? super S>, ? extends java.lang.Object> function3, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super S> continuation) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1 flowKt__ReduceKt$reduce$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        T t;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1) {
            flowKt__ReduceKt$reduce$1 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1) continuation;
            int i2 = flowKt__ReduceKt$reduce$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$reduce$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__ReduceKt$reduce$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$reduce$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                    objectRef2.element = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL;
                    kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__ReduceKt$reduce$$inlined$collect$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1<>(objectRef2, function3);
                    flowKt__ReduceKt$reduce$1.L$0 = objectRef2;
                    flowKt__ReduceKt$reduce$1.label = 1;
                    if (flow.collect(flowKt__ReduceKt$reduce$$inlined$collect$1, flowKt__ReduceKt$reduce$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) flowKt__ReduceKt$reduce$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                t = objectRef.element;
                if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                    return t;
                }
                throw new java.util.NoSuchElementException("Empty flow can't be reduced");
            }
        }
        flowKt__ReduceKt$reduce$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1(continuation);
        java.lang.Object obj2 = flowKt__ReduceKt$reduce$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$reduce$1.label;
        if (i != 0) {
        }
        t = objectRef.element;
        if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object i(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1 flowKt__ReduceKt$single$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        T t;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1) {
            flowKt__ReduceKt$single$1 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1) continuation;
            int i2 = flowKt__ReduceKt$single$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$single$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__ReduceKt$single$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$single$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                    objectRef2.element = (T) kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL;
                    kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__ReduceKt$single$$inlined$collect$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$single$$inlined$collect$1<>(objectRef2);
                    flowKt__ReduceKt$single$1.L$0 = objectRef2;
                    flowKt__ReduceKt$single$1.label = 1;
                    if (flow.collect(flowKt__ReduceKt$single$$inlined$collect$1, flowKt__ReduceKt$single$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) flowKt__ReduceKt$single$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                t = objectRef.element;
                if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                    return t;
                }
                throw new java.util.NoSuchElementException("Flow is empty");
            }
        }
        flowKt__ReduceKt$single$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1(continuation);
        java.lang.Object obj2 = flowKt__ReduceKt$single$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$single$1.label;
        if (i != 0) {
        }
        t = objectRef.element;
        if (t == kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> java.lang.Object j(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1 flowKt__ReduceKt$singleOrNull$1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        kotlinx.coroutines.flow.internal.AbortFlowException e;
        kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowCollector;
        T t;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1) {
            flowKt__ReduceKt$singleOrNull$1 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1) continuation;
            int i2 = flowKt__ReduceKt$singleOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$singleOrNull$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__ReduceKt$singleOrNull$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$singleOrNull$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                    objectRef2.element = (T) kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL;
                    kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1<>(objectRef2);
                    try {
                        flowKt__ReduceKt$singleOrNull$1.L$0 = objectRef2;
                        flowKt__ReduceKt$singleOrNull$1.L$1 = flowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1;
                        flowKt__ReduceKt$singleOrNull$1.label = 1;
                        if (flow.collect(flowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1, flowKt__ReduceKt$singleOrNull$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    } catch (kotlinx.coroutines.flow.internal.AbortFlowException e2) {
                        objectRef = objectRef2;
                        e = e2;
                        flowCollector = flowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1;
                        kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        t = objectRef.element;
                        if (t != kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector = (kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1) flowKt__ReduceKt$singleOrNull$1.L$1;
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) flowKt__ReduceKt$singleOrNull$1.L$0;
                    try {
                        kotlin.ResultKt.throwOnFailure(obj);
                    } catch (kotlinx.coroutines.flow.internal.AbortFlowException e3) {
                        e = e3;
                        kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        t = objectRef.element;
                        if (t != kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                        }
                    }
                }
                t = objectRef.element;
                if (t != kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                    return null;
                }
                return t;
            }
        }
        flowKt__ReduceKt$singleOrNull$1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1(continuation);
        java.lang.Object obj2 = flowKt__ReduceKt$singleOrNull$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$singleOrNull$1.label;
        if (i != 0) {
        }
        t = objectRef.element;
        if (t != kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
        }
    }
}
