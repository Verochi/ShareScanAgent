package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class WeakSet<T> implements java.util.Set<T> {
    private static final java.lang.Object PRESENT = new java.lang.Object();
    private transient java.util.WeakHashMap<T, java.lang.Object> map;

    public static class EmptyIterator<E> implements java.util.Iterator<E> {
        private static com.sensorsdata.analytics.android.sdk.util.WeakSet.EmptyIterator EMPTY_ITERATOR = new com.sensorsdata.analytics.android.sdk.util.WeakSet.EmptyIterator();

        private EmptyIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            throw new java.lang.UnsupportedOperationException("EmptyIterator should not call this method directly");
        }
    }

    public static class NonEmptyIterator<E> implements java.util.Iterator<E> {
        private final java.util.Iterator<java.lang.ref.WeakReference<E>> iterator;

        private NonEmptyIterator(java.util.Iterator<java.lang.ref.WeakReference<E>> it) {
            this.iterator = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            return this.iterator.next().get();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(T t) {
        if (t == null) {
            throw new java.lang.IllegalArgumentException("The argument t can't be null");
        }
        if (this.map == null) {
            this.map = new java.util.WeakHashMap<>();
        }
        return this.map.put(t, PRESENT) != null;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(java.util.Collection<? extends T> collection) {
        throw new java.lang.UnsupportedOperationException("method addAll not supported now");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        java.util.WeakHashMap<T, java.lang.Object> weakHashMap = this.map;
        if (weakHashMap != null) {
            weakHashMap.clear();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(java.lang.Object obj) {
        if (isEmpty() || obj == null) {
            return false;
        }
        return this.map.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(java.util.Collection<?> collection) {
        throw new java.lang.UnsupportedOperationException("method containsAll not supported");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        return isEmpty() ? com.sensorsdata.analytics.android.sdk.util.WeakSet.EmptyIterator.EMPTY_ITERATOR : this.map.keySet().iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(java.lang.Object obj) {
        return (isEmpty() || obj == null || this.map.remove(obj) != PRESENT) ? false : true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(java.util.Collection<?> collection) {
        throw new java.lang.UnsupportedOperationException("method removeAll not supported now");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(java.util.Collection<?> collection) {
        throw new java.lang.UnsupportedOperationException("method retainAll not supported now");
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        java.util.WeakHashMap<T, java.lang.Object> weakHashMap = this.map;
        if (weakHashMap == null) {
            return 0;
        }
        return weakHashMap.size();
    }

    @Override // java.util.Set, java.util.Collection
    public java.lang.Object[] toArray() {
        throw new java.lang.UnsupportedOperationException("method toArray() not supported");
    }

    @Override // java.util.Set, java.util.Collection
    public <T1> T1[] toArray(T1[] t1Arr) {
        throw new java.lang.UnsupportedOperationException("method toArray(T[] a) not supported");
    }
}
