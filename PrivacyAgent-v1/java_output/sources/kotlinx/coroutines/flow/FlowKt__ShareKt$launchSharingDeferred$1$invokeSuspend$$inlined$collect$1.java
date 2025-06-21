package kotlinx.coroutines.flow;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class FlowKt__ShareKt$launchSharingDeferred$1$invokeSuspend$$inlined$collect$1<T> implements kotlinx.coroutines.flow.FlowCollector<T> {
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef n;
    public final /* synthetic */ kotlinx.coroutines.CoroutineScope t;
    public final /* synthetic */ kotlinx.coroutines.CompletableDeferred u;

    public FlowKt__ShareKt$launchSharingDeferred$1$invokeSuspend$$inlined$collect$1(kotlin.jvm.internal.Ref.ObjectRef objectRef, kotlinx.coroutines.CoroutineScope coroutineScope, kotlinx.coroutines.CompletableDeferred completableDeferred) {
        this.n = objectRef;
        this.t = coroutineScope;
        this.u = completableDeferred;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [T, kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @org.jetbrains.annotations.Nullable
    public java.lang.Object emit(T t, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlin.Unit unit;
        kotlinx.coroutines.flow.MutableStateFlow mutableStateFlow = (kotlinx.coroutines.flow.MutableStateFlow) this.n.element;
        if (mutableStateFlow == null) {
            unit = null;
        } else {
            mutableStateFlow.setValue(t);
            unit = kotlin.Unit.INSTANCE;
        }
        if (unit == null) {
            kotlinx.coroutines.CoroutineScope coroutineScope = this.t;
            kotlin.jvm.internal.Ref.ObjectRef objectRef = this.n;
            ?? r4 = (T) kotlinx.coroutines.flow.StateFlowKt.MutableStateFlow(t);
            this.u.complete(new kotlinx.coroutines.flow.ReadonlyStateFlow(r4, kotlinx.coroutines.JobKt.getJob(coroutineScope.getCoroutineContext())));
            kotlin.Unit unit2 = kotlin.Unit.INSTANCE;
            objectRef.element = r4;
        }
        return kotlin.Unit.INSTANCE;
    }
}
