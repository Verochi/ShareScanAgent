package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\u001a9\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a=\u0010\r\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00028\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "", "destination", "", "b", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "d", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "C", "a", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes16.dex */
final /* synthetic */ class FlowKt__CollectionKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, C extends java.util.Collection<? super T>> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull C c, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> continuation) {
        kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 flowKt__CollectionKt$toCollection$1;
        java.lang.Object coroutine_suspended;
        int i;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1) {
            flowKt__CollectionKt$toCollection$1 = (kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1) continuation;
            int i2 = flowKt__CollectionKt$toCollection$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$toCollection$1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = flowKt__CollectionKt$toCollection$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$toCollection$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    java.util.Collection collection = (java.util.Collection) flowKt__CollectionKt$toCollection$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                    return collection;
                }
                kotlin.ResultKt.throwOnFailure(obj);
                kotlinx.coroutines.flow.FlowCollector<? super java.lang.Object> flowKt__CollectionKt$toCollection$$inlined$collect$1 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$$inlined$collect$1<>(c);
                flowKt__CollectionKt$toCollection$1.L$0 = c;
                flowKt__CollectionKt$toCollection$1.label = 1;
                return flow.collect(flowKt__CollectionKt$toCollection$$inlined$collect$1, flowKt__CollectionKt$toCollection$1) == coroutine_suspended ? coroutine_suspended : c;
            }
        }
        flowKt__CollectionKt$toCollection$1 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1(continuation);
        java.lang.Object obj2 = flowKt__CollectionKt$toCollection$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$toCollection$1.label;
        if (i == 0) {
        }
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull java.util.List<T> list, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends T>> continuation) {
        return kotlinx.coroutines.flow.FlowKt.toCollection(flow, list, continuation);
    }

    public static /* synthetic */ java.lang.Object c(kotlinx.coroutines.flow.Flow flow, java.util.List list, kotlin.coroutines.Continuation continuation, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            list = new java.util.ArrayList();
        }
        return kotlinx.coroutines.flow.FlowKt.toList(flow, list, continuation);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object d(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull java.util.Set<T> set, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Set<? extends T>> continuation) {
        return kotlinx.coroutines.flow.FlowKt.toCollection(flow, set, continuation);
    }

    public static /* synthetic */ java.lang.Object e(kotlinx.coroutines.flow.Flow flow, java.util.Set set, kotlin.coroutines.Continuation continuation, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            set = new java.util.LinkedHashSet();
        }
        return kotlinx.coroutines.flow.FlowKt.toSet(flow, set, continuation);
    }
}
