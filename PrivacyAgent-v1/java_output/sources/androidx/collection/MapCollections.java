package androidx.collection;

/* loaded from: classes.dex */
abstract class MapCollections<K, V> {

    @androidx.annotation.Nullable
    androidx.collection.MapCollections<K, V>.EntrySet mEntrySet;

    @androidx.annotation.Nullable
    androidx.collection.MapCollections<K, V>.KeySet mKeySet;

    @androidx.annotation.Nullable
    androidx.collection.MapCollections<K, V>.ValuesCollection mValues;

    public final class ArrayIterator<T> implements java.util.Iterator<T> {
        boolean mCanRemove = false;
        int mIndex;
        final int mOffset;
        int mSize;

        public ArrayIterator(int i) {
            this.mOffset = i;
            this.mSize = androidx.collection.MapCollections.this.colGetSize();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T t = (T) androidx.collection.MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
            this.mIndex++;
            this.mCanRemove = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.mCanRemove) {
                throw new java.lang.IllegalStateException();
            }
            int i = this.mIndex - 1;
            this.mIndex = i;
            this.mSize--;
            this.mCanRemove = false;
            androidx.collection.MapCollections.this.colRemoveAt(i);
        }
    }

    public final class EntrySet implements java.util.Set<java.util.Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(java.util.Map.Entry<K, V> entry) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(java.util.Collection<? extends java.util.Map.Entry<K, V>> collection) {
            int colGetSize = androidx.collection.MapCollections.this.colGetSize();
            for (java.util.Map.Entry<K, V> entry : collection) {
                androidx.collection.MapCollections.this.colPut(entry.getKey(), entry.getValue());
            }
            return colGetSize != androidx.collection.MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            androidx.collection.MapCollections.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            int colIndexOfKey = androidx.collection.MapCollections.this.colIndexOfKey(entry.getKey());
            if (colIndexOfKey < 0) {
                return false;
            }
            return androidx.collection.ContainerHelpers.equal(androidx.collection.MapCollections.this.colGetEntry(colIndexOfKey, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(java.util.Collection<?> collection) {
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(java.lang.Object obj) {
            return androidx.collection.MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int colGetSize = androidx.collection.MapCollections.this.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                java.lang.Object colGetEntry = androidx.collection.MapCollections.this.colGetEntry(colGetSize, 0);
                java.lang.Object colGetEntry2 = androidx.collection.MapCollections.this.colGetEntry(colGetSize, 1);
                i += (colGetEntry == null ? 0 : colGetEntry.hashCode()) ^ (colGetEntry2 == null ? 0 : colGetEntry2.hashCode());
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return androidx.collection.MapCollections.this.colGetSize() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
            return new androidx.collection.MapCollections.MapIterator();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(java.lang.Object obj) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return androidx.collection.MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public java.lang.Object[] toArray() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public final class KeySet implements java.util.Set<K> {
        public KeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(java.util.Collection<? extends K> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            androidx.collection.MapCollections.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(java.lang.Object obj) {
            return androidx.collection.MapCollections.this.colIndexOfKey(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(java.util.Collection<?> collection) {
            return androidx.collection.MapCollections.containsAllHelper(androidx.collection.MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(java.lang.Object obj) {
            return androidx.collection.MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int colGetSize = androidx.collection.MapCollections.this.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                java.lang.Object colGetEntry = androidx.collection.MapCollections.this.colGetEntry(colGetSize, 0);
                i += colGetEntry == null ? 0 : colGetEntry.hashCode();
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return androidx.collection.MapCollections.this.colGetSize() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<K> iterator() {
            return new androidx.collection.MapCollections.ArrayIterator(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(java.lang.Object obj) {
            int colIndexOfKey = androidx.collection.MapCollections.this.colIndexOfKey(obj);
            if (colIndexOfKey < 0) {
                return false;
            }
            androidx.collection.MapCollections.this.colRemoveAt(colIndexOfKey);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            return androidx.collection.MapCollections.removeAllHelper(androidx.collection.MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            return androidx.collection.MapCollections.retainAllHelper(androidx.collection.MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return androidx.collection.MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public java.lang.Object[] toArray() {
            return androidx.collection.MapCollections.this.toArrayHelper(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) androidx.collection.MapCollections.this.toArrayHelper(tArr, 0);
        }
    }

    public final class MapIterator implements java.util.Iterator<java.util.Map.Entry<K, V>>, java.util.Map.Entry<K, V> {
        int mEnd;
        boolean mEntryValid = false;
        int mIndex = -1;

        public MapIterator() {
            this.mEnd = androidx.collection.MapCollections.this.colGetSize() - 1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(java.lang.Object obj) {
            if (!this.mEntryValid) {
                throw new java.lang.IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            return androidx.collection.ContainerHelpers.equal(entry.getKey(), androidx.collection.MapCollections.this.colGetEntry(this.mIndex, 0)) && androidx.collection.ContainerHelpers.equal(entry.getValue(), androidx.collection.MapCollections.this.colGetEntry(this.mIndex, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.mEntryValid) {
                return (K) androidx.collection.MapCollections.this.colGetEntry(this.mIndex, 0);
            }
            throw new java.lang.IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.mEntryValid) {
                return (V) androidx.collection.MapCollections.this.colGetEntry(this.mIndex, 1);
            }
            throw new java.lang.IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mIndex < this.mEnd;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.mEntryValid) {
                throw new java.lang.IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            java.lang.Object colGetEntry = androidx.collection.MapCollections.this.colGetEntry(this.mIndex, 0);
            java.lang.Object colGetEntry2 = androidx.collection.MapCollections.this.colGetEntry(this.mIndex, 1);
            return (colGetEntry == null ? 0 : colGetEntry.hashCode()) ^ (colGetEntry2 != null ? colGetEntry2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public java.util.Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            this.mIndex++;
            this.mEntryValid = true;
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.mEntryValid) {
                throw new java.lang.IllegalStateException();
            }
            androidx.collection.MapCollections.this.colRemoveAt(this.mIndex);
            this.mIndex--;
            this.mEnd--;
            this.mEntryValid = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.mEntryValid) {
                return (V) androidx.collection.MapCollections.this.colSetValue(this.mIndex, v);
            }
            throw new java.lang.IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public java.lang.String toString() {
            return getKey() + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }
    }

    public final class ValuesCollection implements java.util.Collection<V> {
        public ValuesCollection() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(java.util.Collection<? extends V> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            androidx.collection.MapCollections.this.colClear();
        }

        @Override // java.util.Collection
        public boolean contains(java.lang.Object obj) {
            return androidx.collection.MapCollections.this.colIndexOfValue(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(java.util.Collection<?> collection) {
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return androidx.collection.MapCollections.this.colGetSize() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public java.util.Iterator<V> iterator() {
            return new androidx.collection.MapCollections.ArrayIterator(1);
        }

        @Override // java.util.Collection
        public boolean remove(java.lang.Object obj) {
            int colIndexOfValue = androidx.collection.MapCollections.this.colIndexOfValue(obj);
            if (colIndexOfValue < 0) {
                return false;
            }
            androidx.collection.MapCollections.this.colRemoveAt(colIndexOfValue);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            int colGetSize = androidx.collection.MapCollections.this.colGetSize();
            int i = 0;
            boolean z = false;
            while (i < colGetSize) {
                if (collection.contains(androidx.collection.MapCollections.this.colGetEntry(i, 1))) {
                    androidx.collection.MapCollections.this.colRemoveAt(i);
                    i--;
                    colGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            int colGetSize = androidx.collection.MapCollections.this.colGetSize();
            int i = 0;
            boolean z = false;
            while (i < colGetSize) {
                if (!collection.contains(androidx.collection.MapCollections.this.colGetEntry(i, 1))) {
                    androidx.collection.MapCollections.this.colRemoveAt(i);
                    i--;
                    colGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return androidx.collection.MapCollections.this.colGetSize();
        }

        @Override // java.util.Collection
        public java.lang.Object[] toArray() {
            return androidx.collection.MapCollections.this.toArrayHelper(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) androidx.collection.MapCollections.this.toArrayHelper(tArr, 1);
        }
    }

    public static <K, V> boolean containsAllHelper(java.util.Map<K, V> map, java.util.Collection<?> collection) {
        java.util.Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equalsSetHelper(java.util.Set<T> set, java.lang.Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof java.util.Set) {
            java.util.Set set2 = (java.util.Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean removeAllHelper(java.util.Map<K, V> map, java.util.Collection<?> collection) {
        int size = map.size();
        java.util.Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean retainAllHelper(java.util.Map<K, V> map, java.util.Collection<?> collection) {
        int size = map.size();
        java.util.Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract void colClear();

    public abstract java.lang.Object colGetEntry(int i, int i2);

    public abstract java.util.Map<K, V> colGetMap();

    public abstract int colGetSize();

    public abstract int colIndexOfKey(java.lang.Object obj);

    public abstract int colIndexOfValue(java.lang.Object obj);

    public abstract void colPut(K k, V v);

    public abstract void colRemoveAt(int i);

    public abstract V colSetValue(int i, V v);

    public java.util.Set<java.util.Map.Entry<K, V>> getEntrySet() {
        if (this.mEntrySet == null) {
            this.mEntrySet = new androidx.collection.MapCollections.EntrySet();
        }
        return this.mEntrySet;
    }

    public java.util.Set<K> getKeySet() {
        if (this.mKeySet == null) {
            this.mKeySet = new androidx.collection.MapCollections.KeySet();
        }
        return this.mKeySet;
    }

    public java.util.Collection<V> getValues() {
        if (this.mValues == null) {
            this.mValues = new androidx.collection.MapCollections.ValuesCollection();
        }
        return this.mValues;
    }

    public java.lang.Object[] toArrayHelper(int i) {
        int colGetSize = colGetSize();
        java.lang.Object[] objArr = new java.lang.Object[colGetSize];
        for (int i2 = 0; i2 < colGetSize; i2++) {
            objArr[i2] = colGetEntry(i2, i);
        }
        return objArr;
    }

    public <T> T[] toArrayHelper(T[] tArr, int i) {
        int colGetSize = colGetSize();
        if (tArr.length < colGetSize) {
            tArr = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), colGetSize));
        }
        for (int i2 = 0; i2 < colGetSize; i2++) {
            tArr[i2] = colGetEntry(i2, i);
        }
        if (tArr.length > colGetSize) {
            tArr[colGetSize] = null;
        }
        return tArr;
    }
}
