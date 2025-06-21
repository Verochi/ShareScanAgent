package kotlinx.coroutines.flow;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class FlowKt__ReduceKt$reduce$$inlined$collect$1<T> implements kotlinx.coroutines.flow.FlowCollector<T> {
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef n;
    public final /* synthetic */ kotlin.jvm.functions.Function3 t;

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1", f = "Reduce.kt", i = {}, l = {com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON}, m = "emit", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
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
            return kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowKt__ReduceKt$reduce$$inlined$collect$1(kotlin.jvm.internal.Ref.ObjectRef objectRef, kotlin.jvm.functions.Function3 function3) {
        this.n = objectRef;
        this.t = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Object emit(T t, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1.AnonymousClass1 anonymousClass1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1.AnonymousClass1) {
            anonymousClass1 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1.AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = anonymousClass1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    objectRef = this.n;
                    T t2 = objectRef.element;
                    if (t2 != kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL) {
                        kotlin.jvm.functions.Function3 function3 = this.t;
                        anonymousClass1.L$0 = objectRef;
                        anonymousClass1.label = 1;
                        kotlin.jvm.internal.InlineMarker.mark(6);
                        t = (T) function3.invoke(t2, t, anonymousClass1);
                        kotlin.jvm.internal.InlineMarker.mark(7);
                        if (t == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = (kotlin.jvm.internal.Ref.ObjectRef) anonymousClass1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                    objectRef = objectRef2;
                    t = (T) obj;
                }
                objectRef.element = t;
                return kotlin.Unit.INSTANCE;
            }
        }
        anonymousClass1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1.AnonymousClass1(continuation);
        java.lang.Object obj2 = anonymousClass1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        objectRef.element = t;
        return kotlin.Unit.INSTANCE;
    }
}
