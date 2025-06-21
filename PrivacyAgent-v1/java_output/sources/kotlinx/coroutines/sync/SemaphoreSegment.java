package kotlinx.coroutines.sync;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreSegment;", "Lkotlinx/coroutines/internal/Segment;", "", "index", "", "d", "(I)V", "", "toString", "()Ljava/lang/String;", "getMaxSlots", "()I", "maxSlots", "", "id", "prev", "pointers", "<init>", "(JLkotlinx/coroutines/sync/SemaphoreSegment;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
final class SemaphoreSegment extends kotlinx.coroutines.internal.Segment<kotlinx.coroutines.sync.SemaphoreSegment> {

    @org.jetbrains.annotations.NotNull
    public /* synthetic */ java.util.concurrent.atomic.AtomicReferenceArray e;

    public SemaphoreSegment(long j, @org.jetbrains.annotations.Nullable kotlinx.coroutines.sync.SemaphoreSegment semaphoreSegment, int i) {
        super(j, semaphoreSegment, i);
        int i2;
        i2 = kotlinx.coroutines.sync.SemaphoreKt.f;
        this.e = new java.util.concurrent.atomic.AtomicReferenceArray(i2);
    }

    public final void d(int index) {
        kotlinx.coroutines.internal.Symbol symbol;
        symbol = kotlinx.coroutines.sync.SemaphoreKt.e;
        this.e.set(index, symbol);
        onSlotCleaned();
    }

    @Override // kotlinx.coroutines.internal.Segment
    public int getMaxSlots() {
        int i;
        i = kotlinx.coroutines.sync.SemaphoreKt.f;
        return i;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "SemaphoreSegment[id=" + getId() + ", hashCode=" + hashCode() + ']';
    }
}
