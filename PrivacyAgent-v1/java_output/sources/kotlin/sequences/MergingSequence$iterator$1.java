package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [V] */
@kotlin.Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"kotlin/sequences/MergingSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/util/Iterator;", "getIterator1", "()Ljava/util/Iterator;", "iterator1", "t", "getIterator2", "iterator2", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MergingSequence$iterator$1<V> implements java.util.Iterator<V>, kotlin.jvm.internal.markers.KMappedMarker {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<T1> iterator1;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<T2> iterator2;
    public final /* synthetic */ kotlin.sequences.MergingSequence<T1, T2, V> u;

    public MergingSequence$iterator$1(kotlin.sequences.MergingSequence<T1, T2, V> mergingSequence) {
        kotlin.sequences.Sequence sequence;
        kotlin.sequences.Sequence sequence2;
        this.u = mergingSequence;
        sequence = mergingSequence.sequence1;
        this.iterator1 = sequence.iterator();
        sequence2 = mergingSequence.sequence2;
        this.iterator2 = sequence2.iterator();
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<T1> getIterator1() {
        return this.iterator1;
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<T2> getIterator2() {
        return this.iterator2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator1.hasNext() && this.iterator2.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        kotlin.jvm.functions.Function2 function2;
        function2 = this.u.transform;
        return (V) function2.mo5invoke(this.iterator1.next(), this.iterator2.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
