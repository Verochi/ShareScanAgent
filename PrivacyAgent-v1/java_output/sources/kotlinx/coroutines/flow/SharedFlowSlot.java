package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J)\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", com.alimm.tanx.core.constant.TanxAdType.FEED_STRING, "", "a", "", "Lkotlin/coroutines/Continuation;", "", "b", "(Lkotlinx/coroutines/flow/SharedFlowImpl;)[Lkotlin/coroutines/Continuation;", "", "J", "index", "Lkotlin/coroutines/Continuation;", "cont", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
final class SharedFlowSlot extends kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlinx.coroutines.flow.SharedFlowImpl<?>> {

    /* renamed from: a, reason: from kotlin metadata */
    @kotlin.jvm.JvmField
    public long index = -1;

    /* renamed from: b, reason: from kotlin metadata */
    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.Nullable
    public kotlin.coroutines.Continuation<? super kotlin.Unit> cont;

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean allocateLocked(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.SharedFlowImpl<?> flow) {
        if (this.index >= 0) {
            return false;
        }
        this.index = flow.H();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    @org.jetbrains.annotations.NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.Continuation<kotlin.Unit>[] freeLocked(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.SharedFlowImpl<?> flow) {
        long j = this.index;
        this.index = -1L;
        this.cont = null;
        return flow.G(j);
    }
}
