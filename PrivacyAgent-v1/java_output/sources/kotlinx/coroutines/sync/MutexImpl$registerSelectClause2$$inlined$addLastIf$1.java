package kotlinx.coroutines.sync;

@kotlin.Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class MutexImpl$registerSelectClause2$$inlined$addLastIf$1 extends kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp {
    public final /* synthetic */ kotlinx.coroutines.internal.LockFreeLinkedListNode b;
    public final /* synthetic */ kotlinx.coroutines.sync.MutexImpl c;
    public final /* synthetic */ java.lang.Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutexImpl$registerSelectClause2$$inlined$addLastIf$1(kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode, kotlinx.coroutines.sync.MutexImpl mutexImpl, java.lang.Object obj) {
        super(lockFreeLinkedListNode);
        this.b = lockFreeLinkedListNode;
        this.c = mutexImpl;
        this.d = obj;
    }

    @Override // kotlinx.coroutines.internal.AtomicOp
    @org.jetbrains.annotations.Nullable
    public java.lang.Object prepare(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected) {
        if (this.c._state == this.d) {
            return null;
        }
        return kotlinx.coroutines.internal.LockFreeLinkedListKt.getCONDITION_FALSE();
    }
}
