package androidx.collection;

/* loaded from: classes.dex */
public class ArrayMap<K, V> extends androidx.collection.SimpleArrayMap<K, V> implements java.util.Map<K, V> {

    @androidx.annotation.Nullable
    androidx.collection.MapCollections<K, V> mCollections;

    /* renamed from: androidx.collection.ArrayMap$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.collection.MapCollections<K, V> {
        public AnonymousClass1() {
        }

        @Override // androidx.collection.MapCollections
        public void colClear() {
            androidx.collection.ArrayMap.this.clear();
        }

        @Override // androidx.collection.MapCollections
        public java.lang.Object colGetEntry(int i, int i2) {
            return androidx.collection.ArrayMap.this.mArray[(i << 1) + i2];
        }

        @Override // androidx.collection.MapCollections
        public java.util.Map<K, V> colGetMap() {
            return androidx.collection.ArrayMap.this;
        }

        @Override // androidx.collection.MapCollections
        public int colGetSize() {
            return androidx.collection.ArrayMap.this.mSize;
        }

        @Override // androidx.collection.MapCollections
        public int colIndexOfKey(java.lang.Object obj) {
            return androidx.collection.ArrayMap.this.indexOfKey(obj);
        }

        @Override // androidx.collection.MapCollections
        public int colIndexOfValue(java.lang.Object obj) {
            return androidx.collection.ArrayMap.this.indexOfValue(obj);
        }

        @Override // androidx.collection.MapCollections
        public void colPut(K k, V v) {
            androidx.collection.ArrayMap.this.put(k, v);
        }

        @Override // androidx.collection.MapCollections
        public void colRemoveAt(int i) {
            androidx.collection.ArrayMap.this.removeAt(i);
        }

        @Override // androidx.collection.MapCollections
        public V colSetValue(int i, V v) {
            return androidx.collection.ArrayMap.this.setValueAt(i, v);
        }
    }

    public ArrayMap() {
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(androidx.collection.SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    private androidx.collection.MapCollections<K, V> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new androidx.collection.ArrayMap.AnonymousClass1();
        }
        return this.mCollections;
    }

    public boolean containsAll(@androidx.annotation.NonNull java.util.Collection<?> collection) {
        return androidx.collection.MapCollections.containsAllHelper(this, collection);
    }

    @Override // java.util.Map
    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        return getCollection().getEntrySet();
    }

    @Override // java.util.Map
    public java.util.Set<K> keySet() {
        return getCollection().getKeySet();
    }

    @Override // java.util.Map
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (java.util.Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean removeAll(@androidx.annotation.NonNull java.util.Collection<?> collection) {
        return androidx.collection.MapCollections.removeAllHelper(this, collection);
    }

    public boolean retainAll(@androidx.annotation.NonNull java.util.Collection<?> collection) {
        return androidx.collection.MapCollections.retainAllHelper(this, collection);
    }

    @Override // java.util.Map
    public java.util.Collection<V> values() {
        return getCollection().getValues();
    }
}
