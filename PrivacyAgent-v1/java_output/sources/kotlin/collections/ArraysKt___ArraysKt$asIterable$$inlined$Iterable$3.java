package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class ArraysKt___ArraysKt$asIterable$$inlined$Iterable$3 implements java.lang.Iterable<java.lang.Short>, kotlin.jvm.internal.markers.KMappedMarker {
    public final /* synthetic */ short[] n;

    public ArraysKt___ArraysKt$asIterable$$inlined$Iterable$3(short[] sArr) {
        this.n = sArr;
    }

    @Override // java.lang.Iterable
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator<java.lang.Short> iterator() {
        return kotlin.jvm.internal.ArrayIteratorsKt.iterator(this.n);
    }
}
