package kotlinx.coroutines.flow;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements kotlinx.coroutines.flow.Flow<T> {
    public final /* synthetic */ kotlinx.coroutines.flow.Flow n;
    public final /* synthetic */ kotlin.jvm.functions.Function3 t;

    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 1, 2}, l = {114, 121, 128}, m = "collect", n = {"this", "$this$onCompletion_u24lambda_u2d3", "e", "sc"}, s = {"L$0", "L$1", "L$0", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1, reason: invalid class name */
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
            return kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(kotlinx.coroutines.flow.Flow flow, kotlin.jvm.functions.Function3 function3) {
        this.n = flow;
        this.t = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // kotlinx.coroutines.flow.Flow
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1 anonymousClass1;
        java.lang.Object coroutine_suspended;
        int i;
        kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        java.lang.Object c;
        kotlinx.coroutines.flow.internal.SafeCollector safeCollector;
        kotlinx.coroutines.flow.internal.SafeCollector safeCollector2;
        java.lang.Object invoke;
        try {
            if (continuation instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1) {
                anonymousClass1 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1) continuation;
                int i2 = anonymousClass1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.label = i2 - Integer.MIN_VALUE;
                    java.lang.Object obj = anonymousClass1.result;
                    coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                        kotlin.ResultKt.throwOnFailure(obj);
                        try {
                            kotlinx.coroutines.flow.Flow flow = this.n;
                            anonymousClass1.L$0 = this;
                            anonymousClass1.L$1 = flowCollector;
                            anonymousClass1.label = 1;
                            if (flow.collect(flowCollector, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                            kotlinx.coroutines.flow.ThrowingCollector throwingCollector = new kotlinx.coroutines.flow.ThrowingCollector(th);
                            kotlin.jvm.functions.Function3 function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.t;
                            anonymousClass1.L$0 = th;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 2;
                            c = kotlinx.coroutines.flow.FlowKt__EmittersKt.c(throwingCollector, function3, th, anonymousClass1);
                            if (c != coroutine_suspended) {
                            }
                        }
                    } else {
                        if (i != 1) {
                            if (i == 2) {
                                java.lang.Throwable th2 = (java.lang.Throwable) anonymousClass1.L$0;
                                kotlin.ResultKt.throwOnFailure(obj);
                                throw th2;
                            }
                            if (i != 3) {
                                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            safeCollector2 = (kotlinx.coroutines.flow.internal.SafeCollector) anonymousClass1.L$0;
                            try {
                                kotlin.ResultKt.throwOnFailure(obj);
                                safeCollector2.releaseIntercepted();
                                return kotlin.Unit.INSTANCE;
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                safeCollector2.releaseIntercepted();
                                throw th;
                            }
                        }
                        flowCollector = (kotlinx.coroutines.flow.FlowCollector) anonymousClass1.L$1;
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                        try {
                            kotlin.ResultKt.throwOnFailure(obj);
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            kotlinx.coroutines.flow.ThrowingCollector throwingCollector2 = new kotlinx.coroutines.flow.ThrowingCollector(th);
                            kotlin.jvm.functions.Function3 function32 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.t;
                            anonymousClass1.L$0 = th;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 2;
                            c = kotlinx.coroutines.flow.FlowKt__EmittersKt.c(throwingCollector2, function32, th, anonymousClass1);
                            if (c != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw th;
                        }
                    }
                    safeCollector = new kotlinx.coroutines.flow.internal.SafeCollector(flowCollector, anonymousClass1.getContext());
                    kotlin.jvm.functions.Function3 function33 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.t;
                    anonymousClass1.L$0 = safeCollector;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 3;
                    kotlin.jvm.internal.InlineMarker.mark(6);
                    invoke = function33.invoke(safeCollector, null, anonymousClass1);
                    kotlin.jvm.internal.InlineMarker.mark(7);
                    if (invoke != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    safeCollector2 = safeCollector;
                    safeCollector2.releaseIntercepted();
                    return kotlin.Unit.INSTANCE;
                }
            }
            kotlin.jvm.functions.Function3 function332 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.t;
            anonymousClass1.L$0 = safeCollector;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 3;
            kotlin.jvm.internal.InlineMarker.mark(6);
            invoke = function332.invoke(safeCollector, null, anonymousClass1);
            kotlin.jvm.internal.InlineMarker.mark(7);
            if (invoke != coroutine_suspended) {
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            safeCollector2 = safeCollector;
            safeCollector2.releaseIntercepted();
            throw th;
        }
        anonymousClass1 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1(continuation);
        java.lang.Object obj2 = anonymousClass1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        safeCollector = new kotlinx.coroutines.flow.internal.SafeCollector(flowCollector, anonymousClass1.getContext());
    }
}
