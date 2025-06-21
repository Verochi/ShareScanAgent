package kotlinx.coroutines.flow;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1, reason: invalid class name */
/* loaded from: classes16.dex */
public final class FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1<T> implements kotlinx.coroutines.flow.FlowCollector<T> {
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef n;
    public final /* synthetic */ kotlin.jvm.functions.Function3 t;
    public final /* synthetic */ kotlinx.coroutines.flow.FlowCollector u;

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1", f = "Transform.kt", i = {0}, l = {135, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME}, m = "emit", n = {"this"}, s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
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
            return kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1(kotlin.jvm.internal.Ref.ObjectRef objectRef, kotlin.jvm.functions.Function3 function3, kotlinx.coroutines.flow.FlowCollector flowCollector) {
        this.n = objectRef;
        this.t = function3;
        this.u = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Object emit(T t, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.AnonymousClass1 anonymousClass1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1<T> flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1;
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        kotlinx.coroutines.flow.FlowCollector flowCollector;
        T t2;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.AnonymousClass1) {
            anonymousClass1 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
                T t3 = (T) anonymousClass1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(t3);
                    kotlin.jvm.internal.Ref.ObjectRef objectRef2 = this.n;
                    kotlin.jvm.functions.Function3 function3 = this.t;
                    T t4 = objectRef2.element;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = objectRef2;
                    anonymousClass1.label = 1;
                    kotlin.jvm.internal.InlineMarker.mark(6);
                    java.lang.Object invoke = function3.invoke(t4, t, anonymousClass1);
                    kotlin.jvm.internal.InlineMarker.mark(7);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1 = this;
                    t3 = (T) invoke;
                    objectRef = objectRef2;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(t3);
                        return kotlin.Unit.INSTANCE;
                    }
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) anonymousClass1.L$1;
                    flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1) anonymousClass1.L$0;
                    kotlin.ResultKt.throwOnFailure(t3);
                }
                objectRef.element = t3;
                flowCollector = flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.u;
                t2 = flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.n.element;
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 2;
                if (flowCollector.emit(t2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return kotlin.Unit.INSTANCE;
            }
        }
        anonymousClass1 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.AnonymousClass1(continuation);
        T t32 = (T) anonymousClass1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        objectRef.element = t32;
        flowCollector = flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.u;
        t2 = flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.n.element;
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.label = 2;
        if (flowCollector.emit(t2, anonymousClass1) == coroutine_suspended) {
        }
        return kotlin.Unit.INSTANCE;
    }
}
