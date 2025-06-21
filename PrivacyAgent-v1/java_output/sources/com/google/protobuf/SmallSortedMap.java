package com.google.protobuf;

/* loaded from: classes22.dex */
class SmallSortedMap<K extends java.lang.Comparable<K>, V> extends java.util.AbstractMap<K, V> {
    private java.util.List<com.google.protobuf.SmallSortedMap<K, V>.Entry> entryList;
    private boolean isImmutable;
    private volatile com.google.protobuf.SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    private final int maxArraySize;
    private java.util.Map<K, V> overflowEntries;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* renamed from: com.google.protobuf.SmallSortedMap$1, reason: invalid class name */
    public static class AnonymousClass1<FieldDescriptorType> extends com.google.protobuf.SmallSortedMap<FieldDescriptorType, java.lang.Object> {
        public AnonymousClass1(int i) {
            super(i, null);
        }

        @Override // com.google.protobuf.SmallSortedMap
        public void makeImmutable() {
            if (!isImmutable()) {
                for (int i = 0; i < getNumArrayEntries(); i++) {
                    java.util.Map.Entry<FieldDescriptorType, java.lang.Object> arrayEntryAt = getArrayEntryAt(i);
                    if (((com.google.protobuf.FieldSet.FieldDescriptorLite) arrayEntryAt.getKey()).isRepeated()) {
                        arrayEntryAt.setValue(java.util.Collections.unmodifiableList((java.util.List) arrayEntryAt.getValue()));
                    }
                }
                for (java.util.Map.Entry<FieldDescriptorType, java.lang.Object> entry : getOverflowEntries()) {
                    if (((com.google.protobuf.FieldSet.FieldDescriptorLite) entry.getKey()).isRepeated()) {
                        entry.setValue(java.util.Collections.unmodifiableList((java.util.List) entry.getValue()));
                    }
                }
            }
            super.makeImmutable();
        }

        @Override // com.google.protobuf.SmallSortedMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ java.lang.Object put(java.lang.Object obj, java.lang.Object obj2) {
            return super.put((com.google.protobuf.SmallSortedMap.AnonymousClass1<FieldDescriptorType>) obj, (com.google.protobuf.FieldSet.FieldDescriptorLite) obj2);
        }
    }

    public static class EmptySet {
        private static final java.util.Iterator<java.lang.Object> ITERATOR = new com.google.protobuf.SmallSortedMap.EmptySet.AnonymousClass1();
        private static final java.lang.Iterable<java.lang.Object> ITERABLE = new com.google.protobuf.SmallSortedMap.EmptySet.AnonymousClass2();

        /* renamed from: com.google.protobuf.SmallSortedMap$EmptySet$1, reason: invalid class name */
        public static class AnonymousClass1 implements java.util.Iterator<java.lang.Object> {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public java.lang.Object next() {
                throw new java.util.NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }
        }

        /* renamed from: com.google.protobuf.SmallSortedMap$EmptySet$2, reason: invalid class name */
        public static class AnonymousClass2 implements java.lang.Iterable<java.lang.Object> {
            @Override // java.lang.Iterable
            public java.util.Iterator<java.lang.Object> iterator() {
                return com.google.protobuf.SmallSortedMap.EmptySet.ITERATOR;
            }
        }

        private EmptySet() {
        }

        public static <T> java.lang.Iterable<T> iterable() {
            return (java.lang.Iterable<T>) ITERABLE;
        }
    }

    public class Entry implements java.util.Map.Entry<K, V>, java.lang.Comparable<com.google.protobuf.SmallSortedMap<K, V>.Entry> {
        private final K key;
        private V value;

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public Entry(com.google.protobuf.SmallSortedMap smallSortedMap, java.util.Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean equals(java.lang.Object obj, java.lang.Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.protobuf.SmallSortedMap<K, V>.Entry entry) {
            return getKey().compareTo(entry.getKey());
        }

        @Override // java.util.Map.Entry
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            return equals(this.key, entry.getKey()) && equals(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.key;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.value;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            com.google.protobuf.SmallSortedMap.this.checkMutable();
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public java.lang.String toString() {
            return this.key + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + this.value;
        }
    }

    public class EntryIterator implements java.util.Iterator<java.util.Map.Entry<K, V>> {
        private java.util.Iterator<java.util.Map.Entry<K, V>> lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;

        private EntryIterator() {
            this.pos = -1;
        }

        public /* synthetic */ EntryIterator(com.google.protobuf.SmallSortedMap smallSortedMap, com.google.protobuf.SmallSortedMap.AnonymousClass1 anonymousClass1) {
            this();
        }

        private java.util.Iterator<java.util.Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = com.google.protobuf.SmallSortedMap.this.overflowEntries.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos + 1 < com.google.protobuf.SmallSortedMap.this.entryList.size() || getOverflowIterator().hasNext();
        }

        @Override // java.util.Iterator
        public java.util.Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int i = this.pos + 1;
            this.pos = i;
            return i < com.google.protobuf.SmallSortedMap.this.entryList.size() ? (java.util.Map.Entry) com.google.protobuf.SmallSortedMap.this.entryList.get(this.pos) : getOverflowIterator().next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.nextCalledBeforeRemove) {
                throw new java.lang.IllegalStateException("remove() was called before next()");
            }
            this.nextCalledBeforeRemove = false;
            com.google.protobuf.SmallSortedMap.this.checkMutable();
            if (this.pos >= com.google.protobuf.SmallSortedMap.this.entryList.size()) {
                getOverflowIterator().remove();
                return;
            }
            com.google.protobuf.SmallSortedMap smallSortedMap = com.google.protobuf.SmallSortedMap.this;
            int i = this.pos;
            this.pos = i - 1;
            smallSortedMap.removeArrayEntryAt(i);
        }
    }

    public class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {
        private EntrySet() {
        }

        public /* synthetic */ EntrySet(com.google.protobuf.SmallSortedMap smallSortedMap, com.google.protobuf.SmallSortedMap.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(java.util.Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            com.google.protobuf.SmallSortedMap.this.put((com.google.protobuf.SmallSortedMap) entry.getKey(), (K) entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.protobuf.SmallSortedMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            java.lang.Object obj2 = com.google.protobuf.SmallSortedMap.this.get(entry.getKey());
            java.lang.Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
            return new com.google.protobuf.SmallSortedMap.EntryIterator(com.google.protobuf.SmallSortedMap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            com.google.protobuf.SmallSortedMap.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.protobuf.SmallSortedMap.this.size();
        }
    }

    private SmallSortedMap(int i) {
        this.maxArraySize = i;
        this.entryList = java.util.Collections.emptyList();
        this.overflowEntries = java.util.Collections.emptyMap();
    }

    public /* synthetic */ SmallSortedMap(int i, com.google.protobuf.SmallSortedMap.AnonymousClass1 anonymousClass1) {
        this(i);
    }

    private int binarySearchInArray(K k) {
        int size = this.entryList.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.entryList.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.entryList.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkMutable() {
        if (this.isImmutable) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    private void ensureEntryArrayMutable() {
        checkMutable();
        if (!this.entryList.isEmpty() || (this.entryList instanceof java.util.ArrayList)) {
            return;
        }
        this.entryList = new java.util.ArrayList(this.maxArraySize);
    }

    private java.util.SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof java.util.TreeMap)) {
            this.overflowEntries = new java.util.TreeMap();
        }
        return (java.util.SortedMap) this.overflowEntries;
    }

    public static <FieldDescriptorType extends com.google.protobuf.FieldSet.FieldDescriptorLite<FieldDescriptorType>> com.google.protobuf.SmallSortedMap<FieldDescriptorType, java.lang.Object> newFieldMap(int i) {
        return new com.google.protobuf.SmallSortedMap.AnonymousClass1(i);
    }

    public static <K extends java.lang.Comparable<K>, V> com.google.protobuf.SmallSortedMap<K, V> newInstanceForTest(int i) {
        return new com.google.protobuf.SmallSortedMap<>(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeArrayEntryAt(int i) {
        checkMutable();
        V value = this.entryList.remove(i).getValue();
        if (!this.overflowEntries.isEmpty()) {
            java.util.Iterator<java.util.Map.Entry<K, V>> it = getOverflowEntriesMutable().entrySet().iterator();
            this.entryList.add(new com.google.protobuf.SmallSortedMap.Entry(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        checkMutable();
        if (!this.entryList.isEmpty()) {
            this.entryList.clear();
        }
        if (this.overflowEntries.isEmpty()) {
            return;
        }
        this.overflowEntries.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(java.lang.Object obj) {
        java.lang.Comparable comparable = (java.lang.Comparable) obj;
        return binarySearchInArray(comparable) >= 0 || this.overflowEntries.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet == null) {
            this.lazyEntrySet = new com.google.protobuf.SmallSortedMap.EntrySet(this, null);
        }
        return this.lazyEntrySet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(java.lang.Object obj) {
        java.lang.Comparable comparable = (java.lang.Comparable) obj;
        int binarySearchInArray = binarySearchInArray(comparable);
        return binarySearchInArray >= 0 ? this.entryList.get(binarySearchInArray).getValue() : this.overflowEntries.get(comparable);
    }

    public java.util.Map.Entry<K, V> getArrayEntryAt(int i) {
        return this.entryList.get(i);
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public java.lang.Iterable<java.util.Map.Entry<K, V>> getOverflowEntries() {
        return this.overflowEntries.isEmpty() ? com.google.protobuf.SmallSortedMap.EmptySet.iterable() : this.overflowEntries.entrySet();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public void makeImmutable() {
        if (this.isImmutable) {
            return;
        }
        this.overflowEntries = this.overflowEntries.isEmpty() ? java.util.Collections.emptyMap() : java.util.Collections.unmodifiableMap(this.overflowEntries);
        this.isImmutable = true;
    }

    public V put(K k, V v) {
        checkMutable();
        int binarySearchInArray = binarySearchInArray(k);
        if (binarySearchInArray >= 0) {
            return this.entryList.get(binarySearchInArray).setValue(v);
        }
        ensureEntryArrayMutable();
        int i = -(binarySearchInArray + 1);
        if (i >= this.maxArraySize) {
            return getOverflowEntriesMutable().put(k, v);
        }
        int size = this.entryList.size();
        int i2 = this.maxArraySize;
        if (size == i2) {
            com.google.protobuf.SmallSortedMap<K, V>.Entry remove = this.entryList.remove(i2 - 1);
            getOverflowEntriesMutable().put(remove.getKey(), remove.getValue());
        }
        this.entryList.add(i, new com.google.protobuf.SmallSortedMap.Entry(k, v));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ java.lang.Object put(java.lang.Object obj, java.lang.Object obj2) {
        return put((com.google.protobuf.SmallSortedMap<K, V>) obj, (java.lang.Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(java.lang.Object obj) {
        checkMutable();
        java.lang.Comparable comparable = (java.lang.Comparable) obj;
        int binarySearchInArray = binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return (V) removeArrayEntryAt(binarySearchInArray);
        }
        if (this.overflowEntries.isEmpty()) {
            return null;
        }
        return this.overflowEntries.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.entryList.size() + this.overflowEntries.size();
    }
}
