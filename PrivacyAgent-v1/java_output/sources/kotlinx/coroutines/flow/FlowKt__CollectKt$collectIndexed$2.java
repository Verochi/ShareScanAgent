package kotlinx.coroutines.flow;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "index", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class FlowKt__CollectKt$collectIndexed$2<T> implements kotlinx.coroutines.flow.FlowCollector<T> {

    /* renamed from: n, reason: from kotlin metadata */
    public int index;
    public final /* synthetic */ kotlin.jvm.functions.Function3<java.lang.Integer, T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> t;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CollectKt$collectIndexed$2(kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function3) {
        this.t = function3;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @org.jetbrains.annotations.Nullable
    public java.lang.Object emit(T t, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object coroutine_suspended;
        kotlin.jvm.functions.Function3<java.lang.Integer, T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> function3 = this.t;
        int i = this.index;
        this.index = i + 1;
        if (i < 0) {
            throw new java.lang.ArithmeticException("Index overflow has happened");
        }
        java.lang.Object invoke = function3.invoke(kotlin.coroutines.jvm.internal.Boxing.boxInt(i), t, continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return invoke == coroutine_suspended ? invoke : kotlin.Unit.INSTANCE;
    }

    @org.jetbrains.annotations.Nullable
    public java.lang.Object emit$$forInline(T t, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlin.jvm.internal.InlineMarker.mark(4);
        new kotlinx.coroutines.flow.FlowKt__CollectKt$collectIndexed$2$emit$1(this, continuation);
        kotlin.jvm.internal.InlineMarker.mark(5);
        kotlin.jvm.functions.Function3<java.lang.Integer, T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> function3 = this.t;
        int i = this.index;
        this.index = i + 1;
        if (i < 0) {
            throw new java.lang.ArithmeticException("Index overflow has happened");
        }
        function3.invoke(java.lang.Integer.valueOf(i), t, continuation);
        return kotlin.Unit.INSTANCE;
    }
}
