package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class LockFreeLinkedListNode$makeCondAddOp$1 extends kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp {
    public final /* synthetic */ kotlin.jvm.functions.Function0<java.lang.Boolean> b;
    public final /* synthetic */ kotlinx.coroutines.internal.LockFreeLinkedListNode c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LockFreeLinkedListNode$makeCondAddOp$1(kotlin.jvm.functions.Function0<java.lang.Boolean> function0, kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode) {
        super(lockFreeLinkedListNode);
        this.b = function0;
        this.c = lockFreeLinkedListNode;
    }

    @Override // kotlinx.coroutines.internal.AtomicOp
    @org.jetbrains.annotations.Nullable
    public java.lang.Object prepare(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected) {
        if (this.b.invoke().booleanValue()) {
            return null;
        }
        return kotlinx.coroutines.internal.LockFreeLinkedListKt.getCONDITION_FALSE();
    }
}
