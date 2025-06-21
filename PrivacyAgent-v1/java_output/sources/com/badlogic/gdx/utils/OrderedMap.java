package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class OrderedMap<K, V> extends com.badlogic.gdx.utils.ObjectMap<K, V> {
    public final com.badlogic.gdx.utils.Array<K> I;
    public com.badlogic.gdx.utils.ObjectMap.Entries J;
    public com.badlogic.gdx.utils.ObjectMap.Entries K;
    public com.badlogic.gdx.utils.ObjectMap.Values L;
    public com.badlogic.gdx.utils.ObjectMap.Values M;
    public com.badlogic.gdx.utils.ObjectMap.Keys N;
    public com.badlogic.gdx.utils.ObjectMap.Keys O;

    public static class OrderedMapEntries<K, V> extends com.badlogic.gdx.utils.ObjectMap.Entries<K, V> {
        public com.badlogic.gdx.utils.Array<K> x;

        public OrderedMapEntries(com.badlogic.gdx.utils.OrderedMap<K, V> orderedMap) {
            super(orderedMap);
            this.x = orderedMap.I;
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.Entries, java.util.Iterator
        public com.badlogic.gdx.utils.ObjectMap.Entry next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            this.w.key = this.x.get(this.t);
            com.badlogic.gdx.utils.ObjectMap.Entry<K, V> entry = this.w;
            entry.value = this.n.get(entry.key);
            int i = this.t + 1;
            this.t = i;
            this.hasNext = i < this.n.size;
            return this.w;
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.Entries, com.badlogic.gdx.utils.ObjectMap.MapIterator, java.util.Iterator
        public void remove() {
            if (this.u < 0) {
                throw new java.lang.IllegalStateException("next must be called before remove.");
            }
            this.n.remove(this.w.key);
            this.t--;
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.Entries, com.badlogic.gdx.utils.ObjectMap.MapIterator
        public void reset() {
            this.t = 0;
            this.hasNext = this.n.size > 0;
        }
    }

    public static class OrderedMapKeys<K> extends com.badlogic.gdx.utils.ObjectMap.Keys<K> {
        public com.badlogic.gdx.utils.Array<K> w;

        public OrderedMapKeys(com.badlogic.gdx.utils.OrderedMap<K, ?> orderedMap) {
            super(orderedMap);
            this.w = orderedMap.I;
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.Keys, java.util.Iterator
        public K next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            K k = this.w.get(this.t);
            int i = this.t;
            this.u = i;
            int i2 = i + 1;
            this.t = i2;
            this.hasNext = i2 < this.n.size;
            return k;
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.Keys, com.badlogic.gdx.utils.ObjectMap.MapIterator, java.util.Iterator
        public void remove() {
            if (this.u < 0) {
                throw new java.lang.IllegalStateException("next must be called before remove.");
            }
            this.n.remove(this.w.get(this.t - 1));
            this.t = this.u;
            this.u = -1;
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.Keys, com.badlogic.gdx.utils.ObjectMap.MapIterator
        public void reset() {
            this.t = 0;
            this.hasNext = this.n.size > 0;
        }
    }

    public static class OrderedMapValues<V> extends com.badlogic.gdx.utils.ObjectMap.Values<V> {
        public com.badlogic.gdx.utils.Array w;

        public OrderedMapValues(com.badlogic.gdx.utils.OrderedMap<?, V> orderedMap) {
            super(orderedMap);
            this.w = orderedMap.I;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.badlogic.gdx.utils.ObjectMap.Values, java.util.Iterator
        public V next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            V v = (V) this.n.get(this.w.get(this.t));
            int i = this.t;
            this.u = i;
            int i2 = i + 1;
            this.t = i2;
            this.hasNext = i2 < this.n.size;
            return v;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.badlogic.gdx.utils.ObjectMap.Values, com.badlogic.gdx.utils.ObjectMap.MapIterator, java.util.Iterator
        public void remove() {
            int i = this.u;
            if (i < 0) {
                throw new java.lang.IllegalStateException("next must be called before remove.");
            }
            this.n.remove(this.w.get(i));
            this.t = this.u;
            this.u = -1;
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.Values, com.badlogic.gdx.utils.ObjectMap.MapIterator
        public void reset() {
            this.t = 0;
            this.hasNext = this.n.size > 0;
        }
    }

    public OrderedMap() {
        this.I = new com.badlogic.gdx.utils.Array<>();
    }

    public OrderedMap(int i) {
        super(i);
        this.I = new com.badlogic.gdx.utils.Array<>(this.u);
    }

    public OrderedMap(int i, float f) {
        super(i, f);
        this.I = new com.badlogic.gdx.utils.Array<>(this.u);
    }

    public OrderedMap(com.badlogic.gdx.utils.OrderedMap<? extends K, ? extends V> orderedMap) {
        super(orderedMap);
        this.I = new com.badlogic.gdx.utils.Array<>(orderedMap.I);
    }

    @Override // com.badlogic.gdx.utils.ObjectMap
    public void clear() {
        this.I.clear();
        super.clear();
    }

    @Override // com.badlogic.gdx.utils.ObjectMap
    public void clear(int i) {
        this.I.clear();
        super.clear(i);
    }

    @Override // com.badlogic.gdx.utils.ObjectMap
    public com.badlogic.gdx.utils.ObjectMap.Entries<K, V> entries() {
        if (this.J == null) {
            this.J = new com.badlogic.gdx.utils.OrderedMap.OrderedMapEntries(this);
            this.K = new com.badlogic.gdx.utils.OrderedMap.OrderedMapEntries(this);
        }
        com.badlogic.gdx.utils.ObjectMap.Entries entries = this.J;
        if (entries.v) {
            this.K.reset();
            com.badlogic.gdx.utils.ObjectMap.Entries<K, V> entries2 = this.K;
            entries2.v = true;
            this.J.v = false;
            return entries2;
        }
        entries.reset();
        com.badlogic.gdx.utils.ObjectMap.Entries<K, V> entries3 = this.J;
        entries3.v = true;
        this.K.v = false;
        return entries3;
    }

    @Override // com.badlogic.gdx.utils.ObjectMap, java.lang.Iterable
    public com.badlogic.gdx.utils.ObjectMap.Entries<K, V> iterator() {
        return entries();
    }

    @Override // com.badlogic.gdx.utils.ObjectMap
    public com.badlogic.gdx.utils.ObjectMap.Keys<K> keys() {
        if (this.N == null) {
            this.N = new com.badlogic.gdx.utils.OrderedMap.OrderedMapKeys(this);
            this.O = new com.badlogic.gdx.utils.OrderedMap.OrderedMapKeys(this);
        }
        com.badlogic.gdx.utils.ObjectMap.Keys keys = this.N;
        if (keys.v) {
            this.O.reset();
            com.badlogic.gdx.utils.ObjectMap.Keys<K> keys2 = this.O;
            keys2.v = true;
            this.N.v = false;
            return keys2;
        }
        keys.reset();
        com.badlogic.gdx.utils.ObjectMap.Keys<K> keys3 = this.N;
        keys3.v = true;
        this.O.v = false;
        return keys3;
    }

    public com.badlogic.gdx.utils.Array<K> orderedKeys() {
        return this.I;
    }

    @Override // com.badlogic.gdx.utils.ObjectMap
    public V put(K k, V v) {
        if (!containsKey(k)) {
            this.I.add(k);
        }
        return (V) super.put(k, v);
    }

    @Override // com.badlogic.gdx.utils.ObjectMap
    public V remove(K k) {
        this.I.removeValue(k, false);
        return (V) super.remove(k);
    }

    @Override // com.badlogic.gdx.utils.ObjectMap
    public java.lang.String toString() {
        if (this.size == 0) {
            return "{}";
        }
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append('{');
        com.badlogic.gdx.utils.Array<K> array = this.I;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            K k = array.get(i2);
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(k);
            stringBuilder.append(com.alipay.sdk.m.n.a.h);
            stringBuilder.append(get(k));
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override // com.badlogic.gdx.utils.ObjectMap
    public com.badlogic.gdx.utils.ObjectMap.Values<V> values() {
        if (this.L == null) {
            this.L = new com.badlogic.gdx.utils.OrderedMap.OrderedMapValues(this);
            this.M = new com.badlogic.gdx.utils.OrderedMap.OrderedMapValues(this);
        }
        com.badlogic.gdx.utils.ObjectMap.Values values = this.L;
        if (values.v) {
            this.M.reset();
            com.badlogic.gdx.utils.ObjectMap.Values<V> values2 = this.M;
            values2.v = true;
            this.L.v = false;
            return values2;
        }
        values.reset();
        com.badlogic.gdx.utils.ObjectMap.Values<V> values3 = this.L;
        values3.v = true;
        this.M.v = false;
        return values3;
    }
}
