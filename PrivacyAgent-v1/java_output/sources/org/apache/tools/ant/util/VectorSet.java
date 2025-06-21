package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public final class VectorSet<E> extends java.util.Vector<E> {
    private static final long serialVersionUID = 1;
    private final java.util.HashSet<E> set;

    public VectorSet() {
        this.set = new java.util.HashSet<>();
    }

    public VectorSet(int i) {
        super(i);
        this.set = new java.util.HashSet<>();
    }

    public VectorSet(int i, int i2) {
        super(i, i2);
        this.set = new java.util.HashSet<>();
    }

    public VectorSet(java.util.Collection<? extends E> collection) {
        this.set = new java.util.HashSet<>();
        if (collection != null) {
            java.util.Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        }
    }

    private synchronized void doAdd(int i, E e) {
        if (this.set.add(e)) {
            int size = size();
            ensureCapacity(size + 1);
            if (i != size) {
                java.lang.Object[] objArr = ((java.util.Vector) this).elementData;
                java.lang.System.arraycopy(objArr, i, objArr, i + 1, size - i);
            }
            ((java.util.Vector) this).elementData[i] = e;
            ((java.util.Vector) this).elementCount++;
        }
    }

    private synchronized boolean doRemove(java.lang.Object obj) {
        if (!this.set.remove(obj)) {
            return false;
        }
        int indexOf = indexOf(obj);
        java.lang.Object[] objArr = ((java.util.Vector) this).elementData;
        if (indexOf < objArr.length - 1) {
            java.lang.System.arraycopy(objArr, indexOf + 1, objArr, indexOf, (objArr.length - indexOf) - 1);
        }
        ((java.util.Vector) this).elementCount--;
        return true;
    }

    @Override // java.util.Vector, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        doAdd(i, e);
    }

    @Override // java.util.Vector, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized boolean add(E e) {
        if (this.set.contains(e)) {
            return false;
        }
        doAdd(size(), e);
        return true;
    }

    @Override // java.util.Vector, java.util.AbstractList, java.util.List
    public synchronized boolean addAll(int i, java.util.Collection<? extends E> collection) {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        for (E e : collection) {
            if (this.set.add(e)) {
                linkedList.add(e);
            }
        }
        if (linkedList.isEmpty()) {
            return false;
        }
        int size = size();
        ensureCapacity(linkedList.size() + size);
        if (i != size) {
            java.lang.Object[] objArr = ((java.util.Vector) this).elementData;
            java.lang.System.arraycopy(objArr, i, objArr, linkedList.size() + i, size - i);
        }
        java.util.Iterator<E> it = linkedList.iterator();
        while (it.hasNext()) {
            ((java.util.Vector) this).elementData[i] = it.next();
            i++;
        }
        ((java.util.Vector) this).elementCount += linkedList.size();
        return true;
    }

    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized boolean addAll(java.util.Collection<? extends E> collection) {
        boolean z;
        java.util.Iterator<? extends E> it = collection.iterator();
        z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // java.util.Vector
    public synchronized void addElement(E e) {
        doAdd(size(), e);
    }

    @Override // java.util.Vector, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized void clear() {
        super.clear();
        this.set.clear();
    }

    @Override // java.util.Vector
    public java.lang.Object clone() {
        org.apache.tools.ant.util.VectorSet vectorSet = (org.apache.tools.ant.util.VectorSet) super.clone();
        vectorSet.set.addAll(this.set);
        return vectorSet;
    }

    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized boolean contains(java.lang.Object obj) {
        return this.set.contains(obj);
    }

    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized boolean containsAll(java.util.Collection<?> collection) {
        return this.set.containsAll(collection);
    }

    @Override // java.util.Vector
    public void insertElementAt(E e, int i) {
        doAdd(i, e);
    }

    @Override // java.util.Vector, java.util.AbstractList, java.util.List
    public synchronized E remove(int i) {
        E e;
        e = get(i);
        remove(e);
        return e;
    }

    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(java.lang.Object obj) {
        return doRemove(obj);
    }

    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized boolean removeAll(java.util.Collection<?> collection) {
        boolean z;
        java.util.Iterator<?> it = collection.iterator();
        z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Vector
    public synchronized void removeAllElements() {
        this.set.clear();
        super.removeAllElements();
    }

    @Override // java.util.Vector
    public boolean removeElement(java.lang.Object obj) {
        return doRemove(obj);
    }

    @Override // java.util.Vector
    public synchronized void removeElementAt(int i) {
        remove(get(i));
    }

    @Override // java.util.Vector, java.util.AbstractList
    public synchronized void removeRange(int i, int i2) {
        while (i2 > i) {
            i2--;
            remove(i2);
        }
    }

    @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
    public synchronized boolean retainAll(java.util.Collection<?> collection) {
        if (!(collection instanceof java.util.Set)) {
            collection = new java.util.HashSet((java.util.Collection<? extends java.lang.Object>) collection);
        }
        java.util.LinkedList linkedList = new java.util.LinkedList();
        java.util.Iterator<E> it = iterator();
        while (it.hasNext()) {
            E next = it.next();
            if (!collection.contains(next)) {
                linkedList.addLast(next);
            }
        }
        if (linkedList.isEmpty()) {
            return false;
        }
        removeAll(linkedList);
        return true;
    }

    @Override // java.util.Vector, java.util.AbstractList, java.util.List
    public synchronized E set(int i, E e) {
        E e2;
        e2 = get(i);
        if (this.set.add(e)) {
            ((java.util.Vector) this).elementData[i] = e;
            this.set.remove(e2);
        } else {
            int indexOf = indexOf(e);
            remove(e);
            remove(e2);
            if (indexOf <= i) {
                i--;
            }
            add(i, e);
        }
        return e2;
    }

    @Override // java.util.Vector
    public void setElementAt(E e, int i) {
        set(i, e);
    }
}
