package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
abstract class AbstractBiMap<K, V> extends com.google.common.collect.ForwardingMap<K, V> implements com.google.common.collect.BiMap<K, V>, java.io.Serializable {

    @com.google.common.annotations.GwtIncompatible
    private static final long serialVersionUID = 0;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Map<K, V> delegate;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Set<java.util.Map.Entry<K, V>> entrySet;

    @com.google.j2objc.annotations.RetainedWith
    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    transient com.google.common.collect.AbstractBiMap<V, K> inverse;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Set<K> keySet;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Set<V> valueSet;

    /* renamed from: com.google.common.collect.AbstractBiMap$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Iterator<java.util.Map.Entry<K, V>> {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.util.Map.Entry<K, V> n;
        public final /* synthetic */ java.util.Iterator t;

        public AnonymousClass1(java.util.Iterator it) {
            this.t = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K, V> next() {
            java.util.Map.Entry<K, V> entry = (java.util.Map.Entry) this.t.next();
            this.n = entry;
            return new com.google.common.collect.AbstractBiMap.BiMapEntry(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.t.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.CollectPreconditions.e(this.n != null);
            V value = this.n.getValue();
            this.t.remove();
            com.google.common.collect.AbstractBiMap.this.removeFromInverseMap(value);
            this.n = null;
        }
    }

    public class BiMapEntry extends com.google.common.collect.ForwardingMapEntry<K, V> {
        public final java.util.Map.Entry<K, V> n;

        public BiMapEntry(java.util.Map.Entry<K, V> entry) {
            this.n = entry;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        public java.util.Map.Entry<K, V> delegate() {
            return this.n;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public V setValue(V v) {
            com.google.common.collect.AbstractBiMap.this.checkValue(v);
            com.google.common.base.Preconditions.checkState(com.google.common.collect.AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (com.google.common.base.Objects.equal(v, getValue())) {
                return v;
            }
            com.google.common.base.Preconditions.checkArgument(!com.google.common.collect.AbstractBiMap.this.containsValue(v), "value already present: %s", v);
            V value = this.n.setValue(v);
            com.google.common.base.Preconditions.checkState(com.google.common.base.Objects.equal(v, com.google.common.collect.AbstractBiMap.this.get(getKey())), "entry no longer in map");
            com.google.common.collect.AbstractBiMap.this.updateInverseMap(getKey(), true, value, v);
            return value;
        }
    }

    public class EntrySet extends com.google.common.collect.ForwardingSet<java.util.Map.Entry<K, V>> {
        public final java.util.Set<java.util.Map.Entry<K, V>> n;

        public EntrySet() {
            this.n = com.google.common.collect.AbstractBiMap.this.delegate.entrySet();
        }

        public /* synthetic */ EntrySet(com.google.common.collect.AbstractBiMap abstractBiMap, com.google.common.collect.AbstractBiMap.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.common.collect.AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return com.google.common.collect.Maps.l(delegate(), obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(java.util.Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Set<java.util.Map.Entry<K, V>> delegate() {
            return this.n;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
            return com.google.common.collect.AbstractBiMap.this.entrySetIterator();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            if (!this.n.contains(obj)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            ((com.google.common.collect.AbstractBiMap) com.google.common.collect.AbstractBiMap.this.inverse).delegate.remove(entry.getValue());
            this.n.remove(entry);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(java.util.Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(java.util.Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public java.lang.Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    public static class Inverse<K, V> extends com.google.common.collect.AbstractBiMap<K, V> {

        @com.google.common.annotations.GwtIncompatible
        private static final long serialVersionUID = 0;

        public Inverse(java.util.Map<K, V> map, com.google.common.collect.AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap, null);
        }

        @com.google.common.annotations.GwtIncompatible
        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((com.google.common.collect.AbstractBiMap) objectInputStream.readObject());
        }

        @com.google.common.annotations.GwtIncompatible
        private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap
        public K checkKey(K k) {
            return this.inverse.checkValue(k);
        }

        @Override // com.google.common.collect.AbstractBiMap
        public V checkValue(V v) {
            return this.inverse.checkKey(v);
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ java.lang.Object delegate() {
            return super.delegate();
        }

        @com.google.common.annotations.GwtIncompatible
        public java.lang.Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
        public /* bridge */ /* synthetic */ java.util.Collection values() {
            return super.values();
        }
    }

    public class KeySet extends com.google.common.collect.ForwardingSet<K> {
        public KeySet() {
        }

        public /* synthetic */ KeySet(com.google.common.collect.AbstractBiMap abstractBiMap, com.google.common.collect.AbstractBiMap.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.common.collect.AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Set<K> delegate() {
            return com.google.common.collect.AbstractBiMap.this.delegate.keySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<K> iterator() {
            return com.google.common.collect.Maps.w(com.google.common.collect.AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            if (!contains(obj)) {
                return false;
            }
            com.google.common.collect.AbstractBiMap.this.removeFromBothMaps(obj);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(java.util.Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(java.util.Collection<?> collection) {
            return standardRetainAll(collection);
        }
    }

    public class ValueSet extends com.google.common.collect.ForwardingSet<V> {
        public final java.util.Set<V> n;

        public ValueSet() {
            this.n = com.google.common.collect.AbstractBiMap.this.inverse.keySet();
        }

        public /* synthetic */ ValueSet(com.google.common.collect.AbstractBiMap abstractBiMap, com.google.common.collect.AbstractBiMap.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public java.util.Set<V> delegate() {
            return this.n;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<V> iterator() {
            return com.google.common.collect.Maps.Q(com.google.common.collect.AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public java.lang.Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.ForwardingObject
        public java.lang.String toString() {
            return standardToString();
        }
    }

    private AbstractBiMap(java.util.Map<K, V> map, com.google.common.collect.AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }

    public /* synthetic */ AbstractBiMap(java.util.Map map, com.google.common.collect.AbstractBiMap abstractBiMap, com.google.common.collect.AbstractBiMap.AnonymousClass1 anonymousClass1) {
        this(map, abstractBiMap);
    }

    public AbstractBiMap(java.util.Map<K, V> map, java.util.Map<V, K> map2) {
        setDelegates(map, map2);
    }

    private V putInBothMaps(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v, boolean z) {
        checkKey(k);
        checkValue(v);
        boolean containsKey = containsKey(k);
        if (containsKey && com.google.common.base.Objects.equal(v, get(k))) {
            return v;
        }
        if (z) {
            inverse().remove(v);
        } else {
            com.google.common.base.Preconditions.checkArgument(!containsValue(v), "value already present: %s", v);
        }
        V put = this.delegate.put(k, v);
        updateInverseMap(k, containsKey, put, v);
        return put;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V removeFromBothMaps(java.lang.Object obj) {
        V remove = this.delegate.remove(obj);
        removeFromInverseMap(remove);
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromInverseMap(V v) {
        this.inverse.delegate.remove(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInverseMap(K k, boolean z, V v, V v2) {
        if (z) {
            removeFromInverseMap(v);
        }
        this.inverse.delegate.put(v2, k);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public K checkKey(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k) {
        return k;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V checkValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return v;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public boolean containsValue(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public java.util.Map<K, V> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        java.util.Set<java.util.Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        com.google.common.collect.AbstractBiMap.EntrySet entrySet = new com.google.common.collect.AbstractBiMap.EntrySet(this, null);
        this.entrySet = entrySet;
        return entrySet;
    }

    public java.util.Iterator<java.util.Map.Entry<K, V>> entrySetIterator() {
        return new com.google.common.collect.AbstractBiMap.AnonymousClass1(this.delegate.entrySet().iterator());
    }

    @Override // com.google.common.collect.BiMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V forcePut(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return putInBothMaps(k, v, true);
    }

    @Override // com.google.common.collect.BiMap
    public com.google.common.collect.BiMap<V, K> inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public java.util.Set<K> keySet() {
        java.util.Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        com.google.common.collect.AbstractBiMap.KeySet keySet = new com.google.common.collect.AbstractBiMap.KeySet(this, null);
        this.keySet = keySet;
        return keySet;
    }

    public com.google.common.collect.AbstractBiMap<V, K> makeInverse(java.util.Map<V, K> map) {
        return new com.google.common.collect.AbstractBiMap.Inverse(map, this);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V put(@org.checkerframework.checker.nullness.compatqual.NullableDecl K k, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return putInBothMaps(k, v, false);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    public void setDelegates(java.util.Map<K, V> map, java.util.Map<V, K> map2) {
        com.google.common.base.Preconditions.checkState(this.delegate == null);
        com.google.common.base.Preconditions.checkState(this.inverse == null);
        com.google.common.base.Preconditions.checkArgument(map.isEmpty());
        com.google.common.base.Preconditions.checkArgument(map2.isEmpty());
        com.google.common.base.Preconditions.checkArgument(map != map2);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    public void setInverse(com.google.common.collect.AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public java.util.Set<V> values() {
        java.util.Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        com.google.common.collect.AbstractBiMap.ValueSet valueSet = new com.google.common.collect.AbstractBiMap.ValueSet(this, null);
        this.valueSet = valueSet;
        return valueSet;
    }
}
