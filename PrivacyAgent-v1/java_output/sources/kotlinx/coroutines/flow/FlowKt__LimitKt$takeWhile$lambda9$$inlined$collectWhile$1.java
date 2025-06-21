package kotlinx.coroutines.flow;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-9$$inlined$collectWhile$1, reason: invalid class name */
/* loaded from: classes16.dex */
public final class FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1<T> implements kotlinx.coroutines.flow.FlowCollector<T> {
    public final /* synthetic */ kotlin.jvm.functions.Function2 n;
    public final /* synthetic */ kotlinx.coroutines.flow.FlowCollector t;

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-9$$inlined$collectWhile$1", f = "Limit.kt", i = {0, 0, 1}, l = {144, 145}, m = "emit", n = {"this", "value", "this"}, s = {"L$0", "L$1", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-9$$inlined$collectWhile$1$1, reason: invalid class name */
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
            return kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1.this.emit(null, this);
        }
    }

    public FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1(kotlin.jvm.functions.Function2 function2, kotlinx.coroutines.flow.FlowCollector flowCollector) {
        this.n = function2;
        this.t = flowCollector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Object emit(T t, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1.AnonymousClass1 anonymousClass1;
        java.lang.Object coroutine_suspended;
        int i;
        boolean z;
        java.lang.Object obj;
        T t2;
        kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1<T> flowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1;
        if (continuation instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1.AnonymousClass1) {
            anonymousClass1 = (kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1.AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj2 = anonymousClass1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                z = true;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj2);
                    kotlin.jvm.functions.Function2 function2 = this.n;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = t;
                    anonymousClass1.label = 1;
                    kotlin.jvm.internal.InlineMarker.mark(6);
                    java.lang.Object mo5invoke = function2.mo5invoke(t, anonymousClass1);
                    kotlin.jvm.internal.InlineMarker.mark(7);
                    if (mo5invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = mo5invoke;
                    t2 = t;
                    flowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1 = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        flowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1 = (kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1) anonymousClass1.L$0;
                        kotlin.ResultKt.throwOnFailure(obj2);
                        if (kotlin.coroutines.jvm.internal.Boxing.boxBoolean(z).booleanValue()) {
                            return kotlin.Unit.INSTANCE;
                        }
                        throw new kotlinx.coroutines.flow.internal.AbortFlowException(flowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1);
                    }
                    java.lang.Object obj3 = anonymousClass1.L$1;
                    kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1<T> flowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$12 = (kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1) anonymousClass1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj2);
                    t2 = obj3;
                    flowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1 = flowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$12;
                    obj = obj2;
                }
                if (((java.lang.Boolean) obj).booleanValue()) {
                    z = false;
                } else {
                    kotlinx.coroutines.flow.FlowCollector flowCollector = flowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1.t;
                    anonymousClass1.L$0 = flowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 2;
                    if (flowCollector.emit(t2, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (kotlin.coroutines.jvm.internal.Boxing.boxBoolean(z).booleanValue()) {
                }
            }
        }
        anonymousClass1 = new kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1.AnonymousClass1(continuation);
        java.lang.Object obj22 = anonymousClass1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        z = true;
        if (i != 0) {
        }
        if (((java.lang.Boolean) obj).booleanValue()) {
        }
        if (kotlin.coroutines.jvm.internal.Boxing.boxBoolean(z).booleanValue()) {
        }
    }
}
