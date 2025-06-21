package kotlin.collections;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SlidingWindowKt$windowedSequence$$inlined$Sequence$1<T> implements kotlin.sequences.Sequence<java.util.List<? extends T>> {
    public final /* synthetic */ kotlin.sequences.Sequence a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;

    public SlidingWindowKt$windowedSequence$$inlined$Sequence$1(kotlin.sequences.Sequence sequence, int i, int i2, boolean z, boolean z2) {
        this.a = sequence;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    @Override // kotlin.sequences.Sequence
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator<java.util.List<? extends T>> iterator() {
        return kotlin.collections.SlidingWindowKt.windowedIterator(this.a.iterator(), this.b, this.c, this.d, this.e);
    }
}
