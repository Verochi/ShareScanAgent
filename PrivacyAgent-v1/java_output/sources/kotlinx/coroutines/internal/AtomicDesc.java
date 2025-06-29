package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&J\u0016\u0010\r\u001a\u0004\u0018\u00010\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0004H&R\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/internal/AtomicDesc;", "", "()V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "setAtomicOp", "(Lkotlinx/coroutines/internal/AtomicOp;)V", com.anythink.expressad.foundation.d.c.bX, "", "op", "failure", "prepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public abstract class AtomicDesc {
    public kotlinx.coroutines.internal.AtomicOp<?> atomicOp;

    public abstract void complete(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.AtomicOp<?> op, @org.jetbrains.annotations.Nullable java.lang.Object failure);

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.internal.AtomicOp<?> getAtomicOp() {
        kotlinx.coroutines.internal.AtomicOp<?> atomicOp = this.atomicOp;
        if (atomicOp != null) {
            return atomicOp;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("atomicOp");
        throw null;
    }

    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object prepare(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.AtomicOp<?> op);

    public final void setAtomicOp(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.AtomicOp<?> atomicOp) {
        this.atomicOp = atomicOp;
    }
}
