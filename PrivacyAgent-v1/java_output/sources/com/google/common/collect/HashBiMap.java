package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class HashBiMap<K, V> extends java.util.AbstractMap<K, V> implements com.google.common.collect.BiMap<K, V>, java.io.Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    private transient java.util.Set<java.util.Map.Entry<K, V>> entrySet;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;

    @com.google.j2objc.annotations.RetainedWith
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.collect.BiMap<V, K> inverse;
    private transient java.util.Set<K> keySet;
    transient K[] keys;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;
    private transient java.util.Set<V> valueSet;
    transient V[] values;

    public final class EntryForKey extends com.google.common.collect.AbstractMapEntry<K, V> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final K n;
        public int t;

        public EntryForKey(int i) {
            this.n = com.google.common.collect.HashBiMap.this.keys[i];
            this.t = i;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.n;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public V getValue() {
            i();
            int i = this.t;
            if (i == -1) {
                return null;
            }
            return com.google.common.collect.HashBiMap.this.values[i];
        }

        public void i() {
            int i = this.t;
            if (i != -1) {
                com.google.common.collect.HashBiMap hashBiMap = com.google.common.collect.HashBiMap.this;
                if (i <= hashBiMap.size && com.google.common.base.Objects.equal(hashBiMap.keys[i], this.n)) {
                    return;
                }
            }
            this.t = com.google.common.collect.HashBiMap.this.findEntryByKey(this.n);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V v) {
            i();
            int i = this.t;
            if (i == -1) {
                return (V) com.google.common.collect.HashBiMap.this.put(this.n, v);
            }
            V v2 = com.google.common.collect.HashBiMap.this.values[i];
            if (com.google.common.base.Objects.equal(v2, v)) {
                return v;
            }
            com.google.common.collect.HashBiMap.this.replaceValueInEntry(this.t, v, false);
            return v2;
        }
    }

    public static final class EntryForValue<K, V> extends com.google.common.collect.AbstractMapEntry<V, K> {
        public final com.google.common.collect.HashBiMap<K, V> n;
        public final V t;
        public int u;

        public EntryForValue(com.google.common.collect.HashBiMap<K, V> hashBiMap, int i) {
            this.n = hashBiMap;
            this.t = hashBiMap.values[i];
            this.u = i;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getKey() {
            return this.t;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getValue() {
            i();
            int i = this.u;
            if (i == -1) {
                return null;
            }
            return this.n.keys[i];
        }

        public final void i() {
            int i = this.u;
            if (i != -1) {
                com.google.common.collect.HashBiMap<K, V> hashBiMap = this.n;
                if (i <= hashBiMap.size && com.google.common.base.Objects.equal(this.t, hashBiMap.values[i])) {
                    return;
                }
            }
            this.u = this.n.findEntryByValue(this.t);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K setValue(K k) {
            i();
            int i = this.u;
            if (i == -1) {
                return this.n.putInverse(this.t, k, false);
            }
            K k2 = this.n.keys[i];
            if (com.google.common.base.Objects.equal(k2, k)) {
                return k;
            }
            this.n.replaceKeyInEntry(this.u, k, false);
            return k2;
        }
    }

    public final class EntrySet extends com.google.common.collect.HashBiMap.View<K, V, java.util.Map.Entry<K, V>> {
        public EntrySet() {
            super(com.google.common.collect.HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K, V> a(int i) {
            return new com.google.common.collect.HashBiMap.EntryForKey(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            java.lang.Object key = entry.getKey();
            java.lang.Object value = entry.getValue();
            int findEntryByKey = com.google.common.collect.HashBiMap.this.findEntryByKey(key);
            return findEntryByKey != -1 && com.google.common.base.Objects.equal(value, com.google.common.collect.HashBiMap.this.values[findEntryByKey]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            java.lang.Object key = entry.getKey();
            java.lang.Object value = entry.getValue();
            int d = com.google.common.collect.Hashing.d(key);
            int findEntryByKey = com.google.common.collect.HashBiMap.this.findEntryByKey(key, d);
            if (findEntryByKey == -1 || !com.google.common.base.Objects.equal(value, com.google.common.collect.HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            com.google.common.collect.HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d);
            return true;
        }
    }

    public static class Inverse<K, V> extends java.util.AbstractMap<V, K> implements com.google.common.collect.BiMap<V, K>, java.io.Serializable {
        private final com.google.common.collect.HashBiMap<K, V> forward;
        private transient java.util.Set<java.util.Map.Entry<V, K>> inverseEntrySet;

        public Inverse(com.google.common.collect.HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        @com.google.common.annotations.GwtIncompatible("serialization")
        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.lang.ClassNotFoundException, java.io.IOException {
            objectInputStream.defaultReadObject();
            ((com.google.common.collect.HashBiMap) this.forward).inverse = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public java.util.Set<java.util.Map.Entry<V, K>> entrySet() {
            java.util.Set<java.util.Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set != null) {
                return set;
            }
            com.google.common.collect.HashBiMap.InverseEntrySet inverseEntrySet = new com.google.common.collect.HashBiMap.InverseEntrySet(this.forward);
            this.inverseEntrySet = inverseEntrySet;
            return inverseEntrySet;
        }

        @Override // com.google.common.collect.BiMap
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public K forcePut(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v, @org.checkerframework.checker.nullness.compatqual.NullableDecl K k) {
            return this.forward.putInverse(v, k, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public K get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.forward.getInverse(obj);
        }

        @Override // com.google.common.collect.BiMap
        public com.google.common.collect.BiMap<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public java.util.Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public K put(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v, @org.checkerframework.checker.nullness.compatqual.NullableDecl K k) {
            return this.forward.putInverse(v, k, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public K remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.forward.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public java.util.Set<K> values() {
            return this.forward.keySet();
        }
    }

    public static class InverseEntrySet<K, V> extends com.google.common.collect.HashBiMap.View<K, V, java.util.Map.Entry<V, K>> {
        public InverseEntrySet(com.google.common.collect.HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        @Override // com.google.common.collect.HashBiMap.View
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<V, K> a(int i) {
            return new com.google.common.collect.HashBiMap.EntryForValue(this.n, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            java.lang.Object key = entry.getKey();
            java.lang.Object value = entry.getValue();
            int findEntryByValue = this.n.findEntryByValue(key);
            return findEntryByValue != -1 && com.google.common.base.Objects.equal(this.n.keys[findEntryByValue], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            java.lang.Object key = entry.getKey();
            java.lang.Object value = entry.getValue();
            int d = com.google.common.collect.Hashing.d(key);
            int findEntryByValue = this.n.findEntryByValue(key, d);
            if (findEntryByValue == -1 || !com.google.common.base.Objects.equal(this.n.keys[findEntryByValue], value)) {
                return false;
            }
            this.n.removeEntryValueHashKnown(findEntryByValue, d);
            return true;
        }
    }

    public final class KeySet extends com.google.common.collect.HashBiMap.View<K, V, K> {
        public KeySet() {
            super(com.google.common.collect.HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        public K a(int i) {
            return com.google.common.collect.HashBiMap.this.keys[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return com.google.common.collect.HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            int d = com.google.common.collect.Hashing.d(obj);
            int findEntryByKey = com.google.common.collect.HashBiMap.this.findEntryByKey(obj, d);
            if (findEntryByKey == -1) {
                return false;
            }
            com.google.common.collect.HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d);
            return true;
        }
    }

    public final class ValueSet extends com.google.common.collect.HashBiMap.View<K, V, V> {
        public ValueSet() {
            super(com.google.common.collect.HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        public V a(int i) {
            return com.google.common.collect.HashBiMap.this.values[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return com.google.common.collect.HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            int d = com.google.common.collect.Hashing.d(obj);
            int findEntryByValue = com.google.common.collect.HashBiMap.this.findEntryByValue(obj, d);
            if (findEntryByValue == -1) {
                return false;
            }
            com.google.common.collect.HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, d);
            return true;
        }
    }

    public static abstract class View<K, V, T> extends java.util.AbstractSet<T> {
        public final com.google.common.collect.HashBiMap<K, V> n;

        /* renamed from: com.google.common.collect.HashBiMap$View$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.Iterator<T> {
            public int n;
            public int t = -1;
            public int u;
            public int v;

            public AnonymousClass1() {
                this.n = ((com.google.common.collect.HashBiMap) com.google.common.collect.HashBiMap.View.this.n).firstInInsertionOrder;
                com.google.common.collect.HashBiMap<K, V> hashBiMap = com.google.common.collect.HashBiMap.View.this.n;
                this.u = hashBiMap.modCount;
                this.v = hashBiMap.size;
            }

            public final void a() {
                if (com.google.common.collect.HashBiMap.View.this.n.modCount != this.u) {
                    throw new java.util.ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.n != -2 && this.v > 0;
            }

            @Override // java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                T t = (T) com.google.common.collect.HashBiMap.View.this.a(this.n);
                this.t = this.n;
                this.n = ((com.google.common.collect.HashBiMap) com.google.common.collect.HashBiMap.View.this.n).nextInInsertionOrder[this.n];
                this.v--;
                return t;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                com.google.common.collect.CollectPreconditions.e(this.t != -1);
                com.google.common.collect.HashBiMap.View.this.n.removeEntry(this.t);
                int i = this.n;
                com.google.common.collect.HashBiMap<K, V> hashBiMap = com.google.common.collect.HashBiMap.View.this.n;
                if (i == hashBiMap.size) {
                    this.n = this.t;
                }
                this.t = -1;
                this.u = hashBiMap.modCount;
            }
        }

        public View(com.google.common.collect.HashBiMap<K, V> hashBiMap) {
            this.n = hashBiMap;
        }

        public abstract T a(int i);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.n.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<T> iterator() {
            return new com.google.common.collect.HashBiMap.View.AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.n.size;
        }
    }

    private HashBiMap(int i) {
        init(i);
    }

    private int bucket(int i) {
        return i & (this.hashTableKToV.length - 1);
    }

    public static <K, V> com.google.common.collect.HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> com.google.common.collect.HashBiMap<K, V> create(int i) {
        return new com.google.common.collect.HashBiMap<>(i);
    }

    public static <K, V> com.google.common.collect.HashBiMap<K, V> create(java.util.Map<? extends K, ? extends V> map) {
        com.google.common.collect.HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }

    private static int[] createFilledWithAbsent(int i) {
        int[] iArr = new int[i];
        java.util.Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i, int i2) {
        com.google.common.base.Preconditions.checkArgument(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.hashTableKToV;
        int i3 = iArr[bucket];
        if (i3 == i) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.nextInBucketKToV[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 == -1) {
                throw new java.lang.AssertionError("Expected to find entry with key " + this.keys[i]);
            }
            if (i3 == i) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i5] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i4 = this.nextInBucketKToV[i3];
        }
    }

    private void deleteFromTableVToK(int i, int i2) {
        com.google.common.base.Preconditions.checkArgument(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.hashTableVToK;
        int i3 = iArr[bucket];
        if (i3 == i) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.nextInBucketVToK[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 == -1) {
                throw new java.lang.AssertionError("Expected to find entry with value " + this.values[i]);
            }
            if (i3 == i) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i5] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i4 = this.nextInBucketVToK[i3];
        }
    }

    private void ensureCapacity(int i) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i) {
            int a = com.google.common.collect.ImmutableCollection.Builder.a(iArr.length, i);
            this.keys = (K[]) java.util.Arrays.copyOf(this.keys, a);
            this.values = (V[]) java.util.Arrays.copyOf(this.values, a);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, a);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, a);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, a);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, a);
        }
        if (this.hashTableKToV.length < i) {
            int a2 = com.google.common.collect.Hashing.a(i, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(a2);
            this.hashTableVToK = createFilledWithAbsent(a2);
            for (int i2 = 0; i2 < this.size; i2++) {
                int bucket = bucket(com.google.common.collect.Hashing.d(this.keys[i2]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i2] = iArr3[bucket];
                iArr3[bucket] = i2;
                int bucket2 = bucket(com.google.common.collect.Hashing.d(this.values[i2]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i2] = iArr5[bucket2];
                iArr5[bucket2] = i2;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i) {
        int length = iArr.length;
        int[] copyOf = java.util.Arrays.copyOf(iArr, i);
        java.util.Arrays.fill(copyOf, length, i, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i, int i2) {
        com.google.common.base.Preconditions.checkArgument(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i] = iArr2[bucket];
        iArr2[bucket] = i;
    }

    private void insertIntoTableVToK(int i, int i2) {
        com.google.common.base.Preconditions.checkArgument(i != -1);
        int bucket = bucket(i2);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i] = iArr2[bucket];
        iArr2[bucket] = i;
    }

    private void moveEntryToIndex(int i, int i2) {
        int i3;
        int i4;
        if (i == i2) {
            return;
        }
        int i5 = this.prevInInsertionOrder[i];
        int i6 = this.nextInInsertionOrder[i];
        setSucceeds(i5, i2);
        setSucceeds(i2, i6);
        K[] kArr = this.keys;
        K k = kArr[i];
        V[] vArr = this.values;
        V v = vArr[i];
        kArr[i2] = k;
        vArr[i2] = v;
        int bucket = bucket(com.google.common.collect.Hashing.d(k));
        int[] iArr = this.hashTableKToV;
        int i7 = iArr[bucket];
        if (i7 == i) {
            iArr[bucket] = i2;
        } else {
            int i8 = this.nextInBucketKToV[i7];
            while (true) {
                i3 = i7;
                i7 = i8;
                if (i7 == i) {
                    break;
                } else {
                    i8 = this.nextInBucketKToV[i7];
                }
            }
            this.nextInBucketKToV[i3] = i2;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i2] = iArr2[i];
        iArr2[i] = -1;
        int bucket2 = bucket(com.google.common.collect.Hashing.d(v));
        int[] iArr3 = this.hashTableVToK;
        int i9 = iArr3[bucket2];
        if (i9 == i) {
            iArr3[bucket2] = i2;
        } else {
            int i10 = this.nextInBucketVToK[i9];
            while (true) {
                i4 = i9;
                i9 = i10;
                if (i9 == i) {
                    break;
                } else {
                    i10 = this.nextInBucketVToK[i9];
                }
            }
            this.nextInBucketVToK[i4] = i2;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i2] = iArr4[i];
        iArr4[i] = -1;
    }

    @com.google.common.annotations.GwtIncompatible
    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h = com.google.common.collect.Serialization.h(objectInputStream);
        init(16);
        com.google.common.collect.Serialization.c(this, objectInputStream, h);
    }

    private void removeEntry(int i, int i2, int i3) {
        com.google.common.base.Preconditions.checkArgument(i != -1);
        deleteFromTableKToV(i, i2);
        deleteFromTableVToK(i, i3);
        setSucceeds(this.prevInInsertionOrder[i], this.nextInInsertionOrder[i]);
        moveEntryToIndex(this.size - 1, i);
        K[] kArr = this.keys;
        int i4 = this.size;
        kArr[i4 - 1] = null;
        this.values[i4 - 1] = null;
        this.size = i4 - 1;
        this.modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl K k, boolean z) {
        int i2;
        com.google.common.base.Preconditions.checkArgument(i != -1);
        int d = com.google.common.collect.Hashing.d(k);
        int findEntryByKey = findEntryByKey(k, d);
        int i3 = this.lastInInsertionOrder;
        if (findEntryByKey == -1) {
            i2 = -2;
        } else {
            if (!z) {
                throw new java.lang.IllegalArgumentException("Key already present in map: " + k);
            }
            i3 = this.prevInInsertionOrder[findEntryByKey];
            i2 = this.nextInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, d);
            if (i == this.size) {
                i = findEntryByKey;
            }
        }
        if (i3 == i) {
            i3 = this.prevInInsertionOrder[i];
        } else if (i3 == this.size) {
            i3 = findEntryByKey;
        }
        if (i2 == i) {
            findEntryByKey = this.nextInInsertionOrder[i];
        } else if (i2 != this.size) {
            findEntryByKey = i2;
        }
        setSucceeds(this.prevInInsertionOrder[i], this.nextInInsertionOrder[i]);
        deleteFromTableKToV(i, com.google.common.collect.Hashing.d(this.keys[i]));
        this.keys[i] = k;
        insertIntoTableKToV(i, com.google.common.collect.Hashing.d(k));
        setSucceeds(i3, i);
        setSucceeds(i, findEntryByKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, boolean z) {
        com.google.common.base.Preconditions.checkArgument(i != -1);
        int d = com.google.common.collect.Hashing.d(v);
        int findEntryByValue = findEntryByValue(v, d);
        if (findEntryByValue != -1) {
            if (!z) {
                throw new java.lang.IllegalArgumentException("Value already present in map: " + v);
            }
            removeEntryValueHashKnown(findEntryByValue, d);
            if (i == this.size) {
                i = findEntryByValue;
            }
        }
        deleteFromTableVToK(i, com.google.common.collect.Hashing.d(this.values[i]));
        this.values[i] = v;
        insertIntoTableVToK(i, d);
    }

    private void setSucceeds(int i, int i2) {
        if (i == -2) {
            this.firstInInsertionOrder = i2;
        } else {
            this.nextInInsertionOrder[i] = i2;
        }
        if (i2 == -2) {
            this.lastInInsertionOrder = i;
        } else {
            this.prevInInsertionOrder[i2] = i;
        }
    }

    @com.google.common.annotations.GwtIncompatible
    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        com.google.common.collect.Serialization.i(this, objectOutputStream);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        java.util.Arrays.fill(this.keys, 0, this.size, (java.lang.Object) null);
        java.util.Arrays.fill(this.values, 0, this.size, (java.lang.Object) null);
        java.util.Arrays.fill(this.hashTableKToV, -1);
        java.util.Arrays.fill(this.hashTableVToK, -1);
        java.util.Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        java.util.Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        java.util.Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        java.util.Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return findEntryByKey(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return findEntryByValue(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        java.util.Set<java.util.Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        com.google.common.collect.HashBiMap.EntrySet entrySet = new com.google.common.collect.HashBiMap.EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    public int findEntry(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i, int[] iArr, int[] iArr2, java.lang.Object[] objArr) {
        int i2 = iArr[bucket(i)];
        while (i2 != -1) {
            if (com.google.common.base.Objects.equal(objArr[i2], obj)) {
                return i2;
            }
            i2 = iArr2[i2];
        }
        return -1;
    }

    public int findEntryByKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return findEntryByKey(obj, com.google.common.collect.Hashing.d(obj));
    }

    public int findEntryByKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        return findEntry(obj, i, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    public int findEntryByValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return findEntryByValue(obj, com.google.common.collect.Hashing.d(obj));
    }

    public int findEntryByValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        return findEntry(obj, i, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    @Override // com.google.common.collect.BiMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V forcePut(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return put(k, v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public K getInverse(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    public void init(int i) {
        com.google.common.collect.CollectPreconditions.b(i, "expectedSize");
        int a = com.google.common.collect.Hashing.a(i, 1.0d);
        this.size = 0;
        this.keys = (K[]) new java.lang.Object[i];
        this.values = (V[]) new java.lang.Object[i];
        this.hashTableKToV = createFilledWithAbsent(a);
        this.hashTableVToK = createFilledWithAbsent(a);
        this.nextInBucketKToV = createFilledWithAbsent(i);
        this.nextInBucketVToK = createFilledWithAbsent(i);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i);
        this.nextInInsertionOrder = createFilledWithAbsent(i);
    }

    @Override // com.google.common.collect.BiMap
    public com.google.common.collect.BiMap<V, K> inverse() {
        com.google.common.collect.BiMap<V, K> biMap = this.inverse;
        if (biMap != null) {
            return biMap;
        }
        com.google.common.collect.HashBiMap.Inverse inverse = new com.google.common.collect.HashBiMap.Inverse(this);
        this.inverse = inverse;
        return inverse;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<K> keySet() {
        java.util.Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        com.google.common.collect.HashBiMap.KeySet keySet = new com.google.common.collect.HashBiMap.KeySet();
        this.keySet = keySet;
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V put(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return put(k, v, false);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V put(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, boolean z) {
        int d = com.google.common.collect.Hashing.d(k);
        int findEntryByKey = findEntryByKey(k, d);
        if (findEntryByKey != -1) {
            V v2 = this.values[findEntryByKey];
            if (com.google.common.base.Objects.equal(v2, v)) {
                return v;
            }
            replaceValueInEntry(findEntryByKey, v, z);
            return v2;
        }
        int d2 = com.google.common.collect.Hashing.d(v);
        int findEntryByValue = findEntryByValue(v, d2);
        if (!z) {
            com.google.common.base.Preconditions.checkArgument(findEntryByValue == -1, "Value already present: %s", v);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, d2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i = this.size;
        kArr[i] = k;
        this.values[i] = v;
        insertIntoTableKToV(i, d);
        insertIntoTableVToK(this.size, d2);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public K putInverse(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v, @org.checkerframework.checker.nullness.compatqual.NullableDecl K k, boolean z) {
        int d = com.google.common.collect.Hashing.d(v);
        int findEntryByValue = findEntryByValue(v, d);
        if (findEntryByValue != -1) {
            K k2 = this.keys[findEntryByValue];
            if (com.google.common.base.Objects.equal(k2, k)) {
                return k;
            }
            replaceKeyInEntry(findEntryByValue, k, z);
            return k2;
        }
        int i = this.lastInInsertionOrder;
        int d2 = com.google.common.collect.Hashing.d(k);
        int findEntryByKey = findEntryByKey(k, d2);
        if (!z) {
            com.google.common.base.Preconditions.checkArgument(findEntryByKey == -1, "Key already present: %s", k);
        } else if (findEntryByKey != -1) {
            i = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, d2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i2 = this.size;
        kArr[i2] = k;
        this.values[i2] = v;
        insertIntoTableKToV(i2, d2);
        insertIntoTableVToK(this.size, d);
        int i3 = i == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i];
        setSucceeds(i, this.size);
        setSucceeds(this.size, i3);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int d = com.google.common.collect.Hashing.d(obj);
        int findEntryByKey = findEntryByKey(obj, d);
        if (findEntryByKey == -1) {
            return null;
        }
        V v = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, d);
        return v;
    }

    public void removeEntry(int i) {
        removeEntryKeyHashKnown(i, com.google.common.collect.Hashing.d(this.keys[i]));
    }

    public void removeEntryKeyHashKnown(int i, int i2) {
        removeEntry(i, i2, com.google.common.collect.Hashing.d(this.values[i]));
    }

    public void removeEntryValueHashKnown(int i, int i2) {
        removeEntry(i, com.google.common.collect.Hashing.d(this.keys[i]), i2);
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public K removeInverse(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        int d = com.google.common.collect.Hashing.d(obj);
        int findEntryByValue = findEntryByValue(obj, d);
        if (findEntryByValue == -1) {
            return null;
        }
        K k = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, d);
        return k;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<V> values() {
        java.util.Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        com.google.common.collect.HashBiMap.ValueSet valueSet = new com.google.common.collect.HashBiMap.ValueSet();
        this.valueSet = valueSet;
        return valueSet;
    }
}
