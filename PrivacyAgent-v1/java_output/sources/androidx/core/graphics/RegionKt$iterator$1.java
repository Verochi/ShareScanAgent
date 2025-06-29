package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\b\u001a\u00020\u0004H\u0096\u0002J\t\u0010\t\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/graphics/RegionKt$iterator$1", "", "Landroid/graphics/Rect;", "hasMore", "", "iterator", "Landroid/graphics/RegionIterator;", "rect", "hasNext", "next", "core-ktx_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class RegionKt$iterator$1 implements java.util.Iterator<android.graphics.Rect>, kotlin.jvm.internal.markers.KMappedMarker {
    final /* synthetic */ android.graphics.Region $this_iterator;
    private boolean hasMore;
    private final android.graphics.RegionIterator iterator;
    private final android.graphics.Rect rect;

    public RegionKt$iterator$1(android.graphics.Region region) {
        this.$this_iterator = region;
        android.graphics.RegionIterator regionIterator = new android.graphics.RegionIterator(region);
        this.iterator = regionIterator;
        android.graphics.Rect rect = new android.graphics.Rect();
        this.rect = rect;
        this.hasMore = regionIterator.next(rect);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasMore;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @org.jetbrains.annotations.NotNull
    public android.graphics.Rect next() {
        if (!this.hasMore) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        android.graphics.Rect rect = new android.graphics.Rect(this.rect);
        this.hasMore = this.iterator.next(this.rect);
        return rect;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
