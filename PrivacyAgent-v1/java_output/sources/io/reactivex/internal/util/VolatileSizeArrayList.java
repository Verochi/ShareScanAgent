package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public final class VolatileSizeArrayList<T> extends java.util.concurrent.atomic.AtomicInteger implements java.util.List<T>, java.util.RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final java.util.ArrayList<T> list;

    public VolatileSizeArrayList() {
        this.list = new java.util.ArrayList<>();
    }

    public VolatileSizeArrayList(int i) {
        this.list = new java.util.ArrayList<>(i);
    }

    @Override // java.util.List
    public void add(int i, T t) {
        this.list.add(i, t);
        lazySet(this.list.size());
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        boolean add = this.list.add(t);
        lazySet(this.list.size());
        return add;
    }

    @Override // java.util.List
    public boolean addAll(int i, java.util.Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(i, collection);
        lazySet(this.list.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(java.util.Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(collection);
        lazySet(this.list.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.list.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(java.lang.Object obj) {
        return this.list.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(java.util.Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(java.lang.Object obj) {
        return obj instanceof io.reactivex.internal.util.VolatileSizeArrayList ? this.list.equals(((io.reactivex.internal.util.VolatileSizeArrayList) obj).list) : this.list.equals(obj);
    }

    @Override // java.util.List
    public T get(int i) {
        return this.list.get(i);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.List
    public int indexOf(java.lang.Object obj) {
        return this.list.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return get() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(java.lang.Object obj) {
        return this.list.lastIndexOf(obj);
    }

    @Override // java.util.List
    public java.util.ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List
    public java.util.ListIterator<T> listIterator(int i) {
        return this.list.listIterator(i);
    }

    @Override // java.util.List
    public T remove(int i) {
        T remove = this.list.remove(i);
        lazySet(this.list.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(java.lang.Object obj) {
        boolean remove = this.list.remove(obj);
        lazySet(this.list.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(java.util.Collection<?> collection) {
        boolean removeAll = this.list.removeAll(collection);
        lazySet(this.list.size());
        return removeAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(java.util.Collection<?> collection) {
        boolean retainAll = this.list.retainAll(collection);
        lazySet(this.list.size());
        return retainAll;
    }

    @Override // java.util.List
    public T set(int i, T t) {
        return this.list.set(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public java.util.List<T> subList(int i, int i2) {
        return this.list.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public java.lang.Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        return (E[]) this.list.toArray(eArr);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public java.lang.String toString() {
        return this.list.toString();
    }
}
