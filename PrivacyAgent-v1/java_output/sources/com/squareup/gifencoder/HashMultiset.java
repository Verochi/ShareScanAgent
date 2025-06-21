package com.squareup.gifencoder;

/* loaded from: classes19.dex */
public final class HashMultiset<E> extends java.util.AbstractCollection<E> implements com.squareup.gifencoder.Multiset<E> {
    public final java.util.Map<E, com.squareup.gifencoder.HashMultiset.Count> n = new java.util.HashMap();
    public int t;

    public static final class Count {
        public int a;

        public Count(int i) {
            this.a = i;
        }
    }

    public final class HashMultisetIterator implements java.util.Iterator<E> {
        public final java.util.Iterator<java.util.Map.Entry<E, com.squareup.gifencoder.HashMultiset.Count>> n;
        public E t;
        public int u = 0;
        public boolean v;

        public HashMultisetIterator() {
            this.n = com.squareup.gifencoder.HashMultiset.this.n.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.u > 0 || this.n.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("iterator has been exhausted");
            }
            if (this.u == 0) {
                java.util.Map.Entry<E, com.squareup.gifencoder.HashMultiset.Count> next = this.n.next();
                this.t = next.getKey();
                this.u = next.getValue().a;
            }
            this.u--;
            this.v = false;
            return this.t;
        }

        @Override // java.util.Iterator
        public void remove() {
            E e = this.t;
            if (e == null) {
                throw new java.lang.IllegalStateException("next() has not been called");
            }
            if (this.v) {
                throw new java.lang.IllegalStateException("remove() already called for current element");
            }
            com.squareup.gifencoder.HashMultiset.this.remove(e);
        }
    }

    public HashMultiset() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HashMultiset(java.util.Collection<E> collection) {
        addAll(collection);
    }

    @Override // com.squareup.gifencoder.Multiset
    public void add(E e, int i) {
        com.squareup.gifencoder.HashMultiset.Count count = this.n.get(e);
        if (count != null) {
            count.a += i;
        } else {
            this.n.put(e, new com.squareup.gifencoder.HashMultiset.Count(i));
        }
        this.t += i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(E e) {
        add(e, 1);
        return true;
    }

    @Override // com.squareup.gifencoder.Multiset
    public int count(java.lang.Object obj) {
        com.squareup.gifencoder.HashMultiset.Count count = this.n.get(obj);
        if (count != null) {
            return count.a;
        }
        return 0;
    }

    @Override // com.squareup.gifencoder.Multiset
    public java.util.Set<E> getDistinctElements() {
        return this.n.keySet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public java.util.Iterator<E> iterator() {
        return new com.squareup.gifencoder.HashMultiset.HashMultisetIterator();
    }

    @Override // com.squareup.gifencoder.Multiset
    public int remove(java.lang.Object obj, int i) {
        com.squareup.gifencoder.HashMultiset.Count count = this.n.get(obj);
        if (count == null) {
            return 0;
        }
        int i2 = count.a;
        if (i < i2) {
            count.a = i2 - i;
            this.t -= i;
            return i;
        }
        this.n.remove(obj);
        int i3 = this.t;
        int i4 = count.a;
        this.t = i3 - i4;
        return i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(java.lang.Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.t;
    }
}
