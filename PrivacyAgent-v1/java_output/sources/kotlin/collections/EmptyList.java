package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0011\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bH\u0096\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0096\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020&H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"Lkotlin/collections/EmptyList;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "()V", "serialVersionUID", "", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "index", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "readResolve", "subList", "fromIndex", "toIndex", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class EmptyList implements java.util.List, java.io.Serializable, java.util.RandomAccess, kotlin.jvm.internal.markers.KMappedMarker {

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.EmptyList INSTANCE = new kotlin.collections.EmptyList();
    private static final long serialVersionUID = -7390468764508069838L;

    private EmptyList() {
    }

    private final java.lang.Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i, java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int i, java.lang.Void r2) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(java.lang.Void r2) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, java.util.Collection collection) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(java.util.Collection collection) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(java.lang.Object obj) {
        if (obj instanceof java.lang.Void) {
            return contains((java.lang.Void) obj);
        }
        return false;
    }

    public boolean contains(@org.jetbrains.annotations.NotNull java.lang.Void element) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(element, "element");
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@org.jetbrains.annotations.NotNull java.util.Collection elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        return (other instanceof java.util.List) && ((java.util.List) other).isEmpty();
    }

    @Override // java.util.List
    @org.jetbrains.annotations.NotNull
    public java.lang.Void get(int index) {
        throw new java.lang.IndexOutOfBoundsException("Empty list doesn't contain element at index " + index + '.');
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(java.lang.Object obj) {
        if (obj instanceof java.lang.Void) {
            return indexOf((java.lang.Void) obj);
        }
        return -1;
    }

    public int indexOf(@org.jetbrains.annotations.NotNull java.lang.Void element) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(element, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator iterator() {
        return kotlin.collections.EmptyIterator.INSTANCE;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(java.lang.Object obj) {
        if (obj instanceof java.lang.Void) {
            return lastIndexOf((java.lang.Void) obj);
        }
        return -1;
    }

    public int lastIndexOf(@org.jetbrains.annotations.NotNull java.lang.Void element) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(element, "element");
        return -1;
    }

    @Override // java.util.List
    @org.jetbrains.annotations.NotNull
    public java.util.ListIterator listIterator() {
        return kotlin.collections.EmptyIterator.INSTANCE;
    }

    @Override // java.util.List
    @org.jetbrains.annotations.NotNull
    public java.util.ListIterator listIterator(int index) {
        if (index == 0) {
            return kotlin.collections.EmptyIterator.INSTANCE;
        }
        throw new java.lang.IndexOutOfBoundsException("Index: " + index);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ java.lang.Object remove(int i) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public java.lang.Void remove(int i) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(java.util.Collection collection) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(java.util.Collection collection) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ java.lang.Object set(int i, java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public java.lang.Void set(int i, java.lang.Void r2) {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    @org.jetbrains.annotations.NotNull
    public java.util.List subList(int fromIndex, int toIndex) {
        if (fromIndex == 0 && toIndex == 0) {
            return this;
        }
        throw new java.lang.IndexOutOfBoundsException("fromIndex: " + fromIndex + ", toIndex: " + toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public java.lang.Object[] toArray() {
        return kotlin.jvm.internal.CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) kotlin.jvm.internal.CollectionToArray.toArray(this, array);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "[]";
    }
}
