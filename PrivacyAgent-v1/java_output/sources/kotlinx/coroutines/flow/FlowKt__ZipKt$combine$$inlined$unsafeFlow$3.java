package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$3 implements kotlinx.coroutines.flow.Flow {
    public final /* synthetic */ kotlinx.coroutines.flow.Flow[] n;
    public final /* synthetic */ kotlin.jvm.functions.Function2 t;

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$1, reason: invalid class name */
    public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
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
            return kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3.this.collect(null, this);
        }
    }

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$3(kotlinx.coroutines.flow.Flow[] flowArr, kotlin.jvm.functions.Function2 function2) {
        this.n = flowArr;
        this.t = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @org.jetbrains.annotations.Nullable
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector flowCollector, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation continuation) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.flow.Flow[] flowArr = this.n;
        kotlin.jvm.internal.Intrinsics.needClassReification();
        java.lang.Object combineInternal = kotlinx.coroutines.flow.internal.CombineKt.combineInternal(flowCollector, flowArr, new kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$1(this.n), new kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2(this.t, null), continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return combineInternal == coroutine_suspended ? combineInternal : kotlin.Unit.INSTANCE;
    }

    @org.jetbrains.annotations.Nullable
    public java.lang.Object collect$$forInline(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector flowCollector, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation continuation) {
        kotlin.jvm.internal.InlineMarker.mark(4);
        new kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3.AnonymousClass1(continuation);
        kotlin.jvm.internal.InlineMarker.mark(5);
        kotlinx.coroutines.flow.Flow[] flowArr = this.n;
        kotlin.jvm.internal.Intrinsics.needClassReification();
        kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$1 flowKt__ZipKt$combine$6$1 = new kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$1(this.n);
        kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2 flowKt__ZipKt$combine$6$2 = new kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2(this.t, null);
        kotlin.jvm.internal.InlineMarker.mark(0);
        kotlinx.coroutines.flow.internal.CombineKt.combineInternal(flowCollector, flowArr, flowKt__ZipKt$combine$6$1, flowKt__ZipKt$combine$6$2, continuation);
        kotlin.jvm.internal.InlineMarker.mark(1);
        return kotlin.Unit.INSTANCE;
    }
}
