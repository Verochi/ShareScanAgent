package kotlin.collections;

/* JADX INFO: Add missing generic type declarations: [V] */
@kotlin.Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0002\u001a\u00020\u0003H\u0096\u0002J\u000e\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"kotlin/collections/AbstractMap$values$1$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class AbstractMap$values$1$iterator$1<V> implements java.util.Iterator<V>, kotlin.jvm.internal.markers.KMappedMarker {
    public final /* synthetic */ java.util.Iterator<java.util.Map.Entry<K, V>> n;

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractMap$values$1$iterator$1(java.util.Iterator<? extends java.util.Map.Entry<? extends K, ? extends V>> it) {
        this.n = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.n.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        return (V) ((java.util.Map.Entry) this.n.next()).getValue();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
