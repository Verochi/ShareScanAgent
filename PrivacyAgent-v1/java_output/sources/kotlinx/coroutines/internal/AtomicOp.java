package kotlinx.coroutines.internal;

@kotlinx.coroutines.InternalCoroutinesApi
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u000e\u0010\fR\u001a\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0016\u001a\u00020\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/AtomicOp;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "affected", "", "failure", "", com.anythink.expressad.foundation.d.c.bX, "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "getConsensus", "()Ljava/lang/Object;", "consensus", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public abstract class AtomicOp<T> extends kotlinx.coroutines.internal.OpDescriptor {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater a = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.AtomicOp.class, java.lang.Object.class, "_consensus");

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object _consensus = kotlinx.coroutines.internal.AtomicKt.NO_DECISION;

    public abstract void complete(T affected, @org.jetbrains.annotations.Nullable java.lang.Object failure);

    @org.jetbrains.annotations.Nullable
    public final java.lang.Object decide(@org.jetbrains.annotations.Nullable java.lang.Object decision) {
        java.lang.Object obj = this._consensus;
        java.lang.Object obj2 = kotlinx.coroutines.internal.AtomicKt.NO_DECISION;
        return obj != obj2 ? obj : defpackage.q1.a(a, this, obj2, decision) ? decision : this._consensus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.internal.AtomicOp<?> getAtomicOp() {
        return this;
    }

    @org.jetbrains.annotations.Nullable
    /* renamed from: getConsensus, reason: from getter */
    public final java.lang.Object get_consensus() {
        return this._consensus;
    }

    public long getOpSequence() {
        return 0L;
    }

    public final boolean isDecided() {
        return this._consensus != kotlinx.coroutines.internal.AtomicKt.NO_DECISION;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object perform(@org.jetbrains.annotations.Nullable java.lang.Object affected) {
        java.lang.Object obj = this._consensus;
        if (obj == kotlinx.coroutines.internal.AtomicKt.NO_DECISION) {
            obj = decide(prepare(affected));
        }
        complete(affected, obj);
        return obj;
    }

    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object prepare(T affected);
}
