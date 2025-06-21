package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\rJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", com.alimm.tanx.core.constant.TanxAdType.FEED_STRING, "", "a", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "Lkotlin/coroutines/Continuation;", "", "c", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "d", "()V", "e", "()Z", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
final class StateFlowSlot extends kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlinx.coroutines.flow.StateFlowImpl<?>> {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater a = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.flow.StateFlowSlot.class, java.lang.Object.class, "_state");

    @org.jetbrains.annotations.NotNull
    volatile /* synthetic */ java.lang.Object _state = null;

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean allocateLocked(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.StateFlowImpl<?> flow) {
        kotlinx.coroutines.internal.Symbol symbol;
        if (this._state != null) {
            return false;
        }
        symbol = kotlinx.coroutines.flow.StateFlowKt.a;
        this._state = symbol;
        return true;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlin.coroutines.Continuation intercepted;
        kotlinx.coroutines.internal.Symbol symbol;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        symbol = kotlinx.coroutines.flow.StateFlowKt.a;
        if (!defpackage.q1.a(atomicReferenceFieldUpdater, this, symbol, cancellableContinuationImpl)) {
            cancellableContinuationImpl.resumeWith(kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE));
        }
        java.lang.Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return result == coroutine_suspended2 ? result : kotlin.Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    @org.jetbrains.annotations.NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.Continuation<kotlin.Unit>[] freeLocked(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.StateFlowImpl<?> flow) {
        this._state = null;
        return kotlinx.coroutines.flow.internal.AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    public final void d() {
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        kotlinx.coroutines.internal.Symbol symbol3;
        kotlinx.coroutines.internal.Symbol symbol4;
        while (true) {
            java.lang.Object obj = this._state;
            if (obj == null) {
                return;
            }
            symbol = kotlinx.coroutines.flow.StateFlowKt.b;
            if (obj == symbol) {
                return;
            }
            symbol2 = kotlinx.coroutines.flow.StateFlowKt.a;
            if (obj == symbol2) {
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
                symbol3 = kotlinx.coroutines.flow.StateFlowKt.b;
                if (defpackage.q1.a(atomicReferenceFieldUpdater, this, obj, symbol3)) {
                    return;
                }
            } else {
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = a;
                symbol4 = kotlinx.coroutines.flow.StateFlowKt.a;
                if (defpackage.q1.a(atomicReferenceFieldUpdater2, this, obj, symbol4)) {
                    ((kotlinx.coroutines.CancellableContinuationImpl) obj).resumeWith(kotlin.Result.m156constructorimpl(kotlin.Unit.INSTANCE));
                    return;
                }
            }
        }
    }

    public final boolean e() {
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        symbol = kotlinx.coroutines.flow.StateFlowKt.a;
        java.lang.Object andSet = atomicReferenceFieldUpdater.getAndSet(this, symbol);
        kotlin.jvm.internal.Intrinsics.checkNotNull(andSet);
        symbol2 = kotlinx.coroutines.flow.StateFlowKt.b;
        return andSet == symbol2;
    }
}
