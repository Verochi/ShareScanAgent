package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\n\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lkotlin/collections/ShortIterator;", "", "", "()V", "next", "()Ljava/lang/Short;", "nextShort", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public abstract class ShortIterator implements java.util.Iterator<java.lang.Short>, kotlin.jvm.internal.markers.KMappedMarker {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ java.lang.Short next() {
        return java.lang.Short.valueOf(nextShort());
    }

    @Override // java.util.Iterator
    @org.jetbrains.annotations.NotNull
    /* renamed from: next, reason: avoid collision after fix types in other method */
    public final java.lang.Short next2() {
        return java.lang.Short.valueOf(nextShort());
    }

    public abstract short nextShort();

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
