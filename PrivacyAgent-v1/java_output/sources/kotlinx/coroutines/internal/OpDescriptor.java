package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0000J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\f\u001a\u00020\rH\u0016R\u0018\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/internal/OpDescriptor;", "", "()V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "isEarlierThan", "", "that", "perform", "affected", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public abstract class OpDescriptor {
    @org.jetbrains.annotations.Nullable
    public abstract kotlinx.coroutines.internal.AtomicOp<?> getAtomicOp();

    public final boolean isEarlierThan(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.OpDescriptor that) {
        kotlinx.coroutines.internal.AtomicOp<?> atomicOp;
        kotlinx.coroutines.internal.AtomicOp<?> atomicOp2 = getAtomicOp();
        return (atomicOp2 == null || (atomicOp = that.getAtomicOp()) == null || atomicOp2.getOpSequence() >= atomicOp.getOpSequence()) ? false : true;
    }

    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object perform(@org.jetbrains.annotations.Nullable java.lang.Object affected);

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return kotlinx.coroutines.DebugStringsKt.getClassSimpleName(this) + '@' + kotlinx.coroutines.DebugStringsKt.getHexAddress(this);
    }
}
