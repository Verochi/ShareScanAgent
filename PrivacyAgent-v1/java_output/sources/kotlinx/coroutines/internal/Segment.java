package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\u0005J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/Segment;", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "", "tryIncPointers$kotlinx_coroutines_core", "()Z", "tryIncPointers", "decPointers$kotlinx_coroutines_core", "decPointers", "", "onSlotCleaned", "()V", "", "c", "J", "getId", "()J", "id", "", "getMaxSlots", "()I", "maxSlots", "getRemoved", "removed", "prev", "pointers", "<init>", "(JLkotlinx/coroutines/internal/Segment;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public abstract class Segment<S extends kotlinx.coroutines.internal.Segment<S>> extends kotlinx.coroutines.internal.ConcurrentLinkedListNode<S> {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater d = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.internal.Segment.class, "cleanedAndPointers");

    /* renamed from: c, reason: from kotlin metadata */
    public final long id;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int cleanedAndPointers;

    public Segment(long j, @org.jetbrains.annotations.Nullable S s2, int i) {
        super(s2);
        this.id = j;
        this.cleanedAndPointers = i << 16;
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        return d.addAndGet(this, androidx.core.internal.view.SupportMenu.CATEGORY_MASK) == getMaxSlots() && !isTail();
    }

    public final long getId() {
        return this.id;
    }

    public abstract int getMaxSlots();

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public boolean getRemoved() {
        return this.cleanedAndPointers == getMaxSlots() && !isTail();
    }

    public final void onSlotCleaned() {
        if (d.incrementAndGet(this) != getMaxSlots() || isTail()) {
            return;
        }
        remove();
    }

    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        int i;
        do {
            i = this.cleanedAndPointers;
            if (!(i != getMaxSlots() || isTail())) {
                return false;
            }
        } while (!d.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
