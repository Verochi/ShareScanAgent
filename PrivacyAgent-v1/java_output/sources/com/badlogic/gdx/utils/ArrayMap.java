package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class ArrayMap<K, V> implements java.lang.Iterable<com.badlogic.gdx.utils.ObjectMap.Entry<K, V>> {
    public K[] keys;
    public com.badlogic.gdx.utils.ArrayMap.Entries n;
    public boolean ordered;
    public int size;
    public com.badlogic.gdx.utils.ArrayMap.Entries t;
    public com.badlogic.gdx.utils.ArrayMap.Values u;
    public com.badlogic.gdx.utils.ArrayMap.Values v;
    public V[] values;
    public com.badlogic.gdx.utils.ArrayMap.Keys w;
    public com.badlogic.gdx.utils.ArrayMap.Keys x;

    public static class Entries<K, V> implements java.lang.Iterable<com.badlogic.gdx.utils.ObjectMap.Entry<K, V>>, java.util.Iterator<com.badlogic.gdx.utils.ObjectMap.Entry<K, V>> {
        public final com.badlogic.gdx.utils.ArrayMap<K, V> n;
        public int u;
        public com.badlogic.gdx.utils.ObjectMap.Entry<K, V> t = new com.badlogic.gdx.utils.ObjectMap.Entry<>();
        public boolean v = true;

        public Entries(com.badlogic.gdx.utils.ArrayMap<K, V> arrayMap) {
            this.n = arrayMap;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.v) {
                return this.u < this.n.size;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<com.badlogic.gdx.utils.ObjectMap.Entry<K, V>> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public com.badlogic.gdx.utils.ObjectMap.Entry<K, V> next() {
            int i = this.u;
            com.badlogic.gdx.utils.ArrayMap<K, V> arrayMap = this.n;
            if (i >= arrayMap.size) {
                throw new java.util.NoSuchElementException(java.lang.String.valueOf(this.u));
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            com.badlogic.gdx.utils.ObjectMap.Entry<K, V> entry = this.t;
            entry.key = arrayMap.keys[i];
            V[] vArr = arrayMap.values;
            this.u = i + 1;
            entry.value = vArr[i];
            return entry;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.u - 1;
            this.u = i;
            this.n.removeIndex(i);
        }

        public void reset() {
            this.u = 0;
        }
    }

    public static class Keys<K> implements java.lang.Iterable<K>, java.util.Iterator<K> {
        public final com.badlogic.gdx.utils.ArrayMap<K, java.lang.Object> n;
        public int t;
        public boolean u = true;

        public Keys(com.badlogic.gdx.utils.ArrayMap<K, java.lang.Object> arrayMap) {
            this.n = arrayMap;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.u) {
                return this.t < this.n.size;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<K> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public K next() {
            int i = this.t;
            com.badlogic.gdx.utils.ArrayMap<K, java.lang.Object> arrayMap = this.n;
            if (i >= arrayMap.size) {
                throw new java.util.NoSuchElementException(java.lang.String.valueOf(this.t));
            }
            if (!this.u) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            K[] kArr = arrayMap.keys;
            this.t = i + 1;
            return kArr[i];
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.t - 1;
            this.t = i;
            this.n.removeIndex(i);
        }

        public void reset() {
            this.t = 0;
        }

        public com.badlogic.gdx.utils.Array<K> toArray() {
            com.badlogic.gdx.utils.ArrayMap<K, java.lang.Object> arrayMap = this.n;
            K[] kArr = arrayMap.keys;
            int i = this.t;
            return new com.badlogic.gdx.utils.Array<>(true, kArr, i, arrayMap.size - i);
        }

        public com.badlogic.gdx.utils.Array<K> toArray(com.badlogic.gdx.utils.Array array) {
            com.badlogic.gdx.utils.ArrayMap<K, java.lang.Object> arrayMap = this.n;
            K[] kArr = arrayMap.keys;
            int i = this.t;
            array.addAll(kArr, i, arrayMap.size - i);
            return array;
        }
    }

    public static class Values<V> implements java.lang.Iterable<V>, java.util.Iterator<V> {
        public final com.badlogic.gdx.utils.ArrayMap<java.lang.Object, V> n;
        public int t;
        public boolean u = true;

        public Values(com.badlogic.gdx.utils.ArrayMap<java.lang.Object, V> arrayMap) {
            this.n = arrayMap;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.u) {
                return this.t < this.n.size;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<V> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public V next() {
            int i = this.t;
            com.badlogic.gdx.utils.ArrayMap<java.lang.Object, V> arrayMap = this.n;
            if (i >= arrayMap.size) {
                throw new java.util.NoSuchElementException(java.lang.String.valueOf(this.t));
            }
            if (!this.u) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            V[] vArr = arrayMap.values;
            this.t = i + 1;
            return vArr[i];
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.t - 1;
            this.t = i;
            this.n.removeIndex(i);
        }

        public void reset() {
            this.t = 0;
        }

        public com.badlogic.gdx.utils.Array<V> toArray() {
            com.badlogic.gdx.utils.ArrayMap<java.lang.Object, V> arrayMap = this.n;
            V[] vArr = arrayMap.values;
            int i = this.t;
            return new com.badlogic.gdx.utils.Array<>(true, vArr, i, arrayMap.size - i);
        }

        public com.badlogic.gdx.utils.Array<V> toArray(com.badlogic.gdx.utils.Array array) {
            com.badlogic.gdx.utils.ArrayMap<java.lang.Object, V> arrayMap = this.n;
            V[] vArr = arrayMap.values;
            int i = this.t;
            array.addAll(vArr, i, arrayMap.size - i);
            return array;
        }
    }

    public ArrayMap() {
        this(true, 16);
    }

    public ArrayMap(int i) {
        this(true, i);
    }

    public ArrayMap(com.badlogic.gdx.utils.ArrayMap arrayMap) {
        this(arrayMap.ordered, arrayMap.size, arrayMap.keys.getClass().getComponentType(), arrayMap.values.getClass().getComponentType());
        int i = arrayMap.size;
        this.size = i;
        java.lang.System.arraycopy(arrayMap.keys, 0, this.keys, 0, i);
        java.lang.System.arraycopy(arrayMap.values, 0, this.values, 0, this.size);
    }

    public ArrayMap(java.lang.Class cls, java.lang.Class cls2) {
        this(false, 16, cls, cls2);
    }

    public ArrayMap(boolean z, int i) {
        this.ordered = z;
        this.keys = (K[]) new java.lang.Object[i];
        this.values = (V[]) new java.lang.Object[i];
    }

    public ArrayMap(boolean z, int i, java.lang.Class cls, java.lang.Class cls2) {
        this.ordered = z;
        this.keys = (K[]) ((java.lang.Object[]) com.badlogic.gdx.utils.reflect.ArrayReflection.newInstance(cls, i));
        this.values = (V[]) ((java.lang.Object[]) com.badlogic.gdx.utils.reflect.ArrayReflection.newInstance(cls2, i));
    }

    public void clear() {
        K[] kArr = this.keys;
        V[] vArr = this.values;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            kArr[i2] = null;
            vArr[i2] = null;
        }
        this.size = 0;
    }

    public void clear(int i) {
        if (this.keys.length <= i) {
            clear();
        } else {
            this.size = 0;
            resize(i);
        }
    }

    public boolean containsKey(K k) {
        K[] kArr = this.keys;
        int i = this.size - 1;
        if (k == null) {
            while (i >= 0) {
                int i2 = i - 1;
                if (kArr[i] == k) {
                    return true;
                }
                i = i2;
            }
            return false;
        }
        while (i >= 0) {
            int i3 = i - 1;
            if (k.equals(kArr[i])) {
                return true;
            }
            i = i3;
        }
        return false;
    }

    public boolean containsValue(V v, boolean z) {
        V[] vArr = this.values;
        int i = this.size - 1;
        if (z || v == null) {
            while (i >= 0) {
                int i2 = i - 1;
                if (vArr[i] == v) {
                    return true;
                }
                i = i2;
            }
            return false;
        }
        while (i >= 0) {
            int i3 = i - 1;
            if (v.equals(vArr[i])) {
                return true;
            }
            i = i3;
        }
        return false;
    }

    public void ensureCapacity(int i) {
        int i2 = this.size + i;
        if (i2 >= this.keys.length) {
            resize(java.lang.Math.max(8, i2));
        }
    }

    public com.badlogic.gdx.utils.ArrayMap.Entries<K, V> entries() {
        if (this.n == null) {
            this.n = new com.badlogic.gdx.utils.ArrayMap.Entries(this);
            this.t = new com.badlogic.gdx.utils.ArrayMap.Entries(this);
        }
        com.badlogic.gdx.utils.ArrayMap.Entries<K, V> entries = this.n;
        if (!entries.v) {
            entries.u = 0;
            entries.v = true;
            this.t.v = false;
            return entries;
        }
        com.badlogic.gdx.utils.ArrayMap.Entries<K, V> entries2 = this.t;
        entries2.u = 0;
        entries2.v = true;
        entries.v = false;
        return entries2;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.badlogic.gdx.utils.ArrayMap)) {
            return false;
        }
        com.badlogic.gdx.utils.ArrayMap arrayMap = (com.badlogic.gdx.utils.ArrayMap) obj;
        int i = arrayMap.size;
        int i2 = this.size;
        if (i != i2) {
            return false;
        }
        K[] kArr = this.keys;
        V[] vArr = this.values;
        for (int i3 = 0; i3 < i2; i3++) {
            K k = kArr[i3];
            V v = vArr[i3];
            if (v == null) {
                if (!arrayMap.containsKey(k) || arrayMap.get(k) != null) {
                    return false;
                }
            } else if (!v.equals(arrayMap.get(k))) {
                return false;
            }
        }
        return true;
    }

    public K firstKey() {
        if (this.size != 0) {
            return this.keys[0];
        }
        throw new java.lang.IllegalStateException("Map is empty.");
    }

    public V firstValue() {
        if (this.size != 0) {
            return this.values[0];
        }
        throw new java.lang.IllegalStateException("Map is empty.");
    }

    public V get(K k) {
        K[] kArr = this.keys;
        int i = this.size - 1;
        if (k == null) {
            while (i >= 0) {
                if (kArr[i] == k) {
                    return this.values[i];
                }
                i--;
            }
            return null;
        }
        while (i >= 0) {
            if (k.equals(kArr[i])) {
                return this.values[i];
            }
            i--;
        }
        return null;
    }

    public K getKey(V v, boolean z) {
        V[] vArr = this.values;
        int i = this.size - 1;
        if (z || v == null) {
            while (i >= 0) {
                if (vArr[i] == v) {
                    return this.keys[i];
                }
                i--;
            }
            return null;
        }
        while (i >= 0) {
            if (v.equals(vArr[i])) {
                return this.keys[i];
            }
            i--;
        }
        return null;
    }

    public K getKeyAt(int i) {
        if (i < this.size) {
            return this.keys[i];
        }
        throw new java.lang.IndexOutOfBoundsException(java.lang.String.valueOf(i));
    }

    public V getValueAt(int i) {
        if (i < this.size) {
            return this.values[i];
        }
        throw new java.lang.IndexOutOfBoundsException(java.lang.String.valueOf(i));
    }

    public int hashCode() {
        K[] kArr = this.keys;
        V[] vArr = this.values;
        int i = this.size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            K k = kArr[i3];
            V v = vArr[i3];
            if (k != null) {
                i2 += k.hashCode() * 31;
            }
            if (v != null) {
                i2 += v.hashCode();
            }
        }
        return i2;
    }

    public int indexOfKey(K k) {
        K[] kArr = this.keys;
        int i = 0;
        if (k == null) {
            int i2 = this.size;
            while (i < i2) {
                if (kArr[i] == k) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int i3 = this.size;
        while (i < i3) {
            if (k.equals(kArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int indexOfValue(V v, boolean z) {
        V[] vArr = this.values;
        int i = 0;
        if (z || v == null) {
            int i2 = this.size;
            while (i < i2) {
                if (vArr[i] == v) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int i3 = this.size;
        while (i < i3) {
            if (v.equals(vArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void insert(int i, K k, V v) {
        int i2 = this.size;
        if (i > i2) {
            throw new java.lang.IndexOutOfBoundsException(java.lang.String.valueOf(i));
        }
        if (i2 == this.keys.length) {
            resize(java.lang.Math.max(8, (int) (i2 * 1.75f)));
        }
        if (this.ordered) {
            K[] kArr = this.keys;
            int i3 = i + 1;
            java.lang.System.arraycopy(kArr, i, kArr, i3, this.size - i);
            V[] vArr = this.values;
            java.lang.System.arraycopy(vArr, i, vArr, i3, this.size - i);
        } else {
            K[] kArr2 = this.keys;
            int i4 = this.size;
            kArr2[i4] = kArr2[i];
            V[] vArr2 = this.values;
            vArr2[i4] = vArr2[i];
        }
        this.size++;
        this.keys[i] = k;
        this.values[i] = v;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<com.badlogic.gdx.utils.ObjectMap.Entry<K, V>> iterator() {
        return entries();
    }

    public com.badlogic.gdx.utils.ArrayMap.Keys<K> keys() {
        if (this.w == null) {
            this.w = new com.badlogic.gdx.utils.ArrayMap.Keys(this);
            this.x = new com.badlogic.gdx.utils.ArrayMap.Keys(this);
        }
        com.badlogic.gdx.utils.ArrayMap.Keys<K> keys = this.w;
        if (!keys.u) {
            keys.t = 0;
            keys.u = true;
            this.x.u = false;
            return keys;
        }
        com.badlogic.gdx.utils.ArrayMap.Keys<K> keys2 = this.x;
        keys2.t = 0;
        keys2.u = true;
        keys.u = false;
        return keys2;
    }

    public K peekKey() {
        return this.keys[this.size - 1];
    }

    public V peekValue() {
        return this.values[this.size - 1];
    }

    public int put(K k, V v) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey == -1) {
            int i = this.size;
            if (i == this.keys.length) {
                resize(java.lang.Math.max(8, (int) (i * 1.75f)));
            }
            indexOfKey = this.size;
            this.size = indexOfKey + 1;
        }
        this.keys[indexOfKey] = k;
        this.values[indexOfKey] = v;
        return indexOfKey;
    }

    public int put(K k, V v, int i) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey != -1) {
            removeIndex(indexOfKey);
        } else {
            int i2 = this.size;
            if (i2 == this.keys.length) {
                resize(java.lang.Math.max(8, (int) (i2 * 1.75f)));
            }
        }
        K[] kArr = this.keys;
        int i3 = i + 1;
        java.lang.System.arraycopy(kArr, i, kArr, i3, this.size - i);
        V[] vArr = this.values;
        java.lang.System.arraycopy(vArr, i, vArr, i3, this.size - i);
        this.keys[i] = k;
        this.values[i] = v;
        this.size++;
        return i;
    }

    public void putAll(com.badlogic.gdx.utils.ArrayMap arrayMap) {
        putAll(arrayMap, 0, arrayMap.size);
    }

    public void putAll(com.badlogic.gdx.utils.ArrayMap arrayMap, int i, int i2) {
        if (i + i2 <= arrayMap.size) {
            int i3 = (this.size + i2) - i;
            if (i3 >= this.keys.length) {
                resize(java.lang.Math.max(8, (int) (i3 * 1.75f)));
            }
            java.lang.System.arraycopy(arrayMap.keys, i, this.keys, this.size, i2);
            java.lang.System.arraycopy(arrayMap.values, i, this.values, this.size, i2);
            this.size += i2;
            return;
        }
        throw new java.lang.IllegalArgumentException("offset + length must be <= size: " + i + " + " + i2 + " <= " + arrayMap.size);
    }

    public void removeIndex(int i) {
        int i2 = this.size;
        if (i >= i2) {
            throw new java.lang.IndexOutOfBoundsException(java.lang.String.valueOf(i));
        }
        K[] kArr = this.keys;
        int i3 = i2 - 1;
        this.size = i3;
        if (this.ordered) {
            int i4 = i + 1;
            java.lang.System.arraycopy(kArr, i4, kArr, i, i3 - i);
            V[] vArr = this.values;
            java.lang.System.arraycopy(vArr, i4, vArr, i, this.size - i);
        } else {
            kArr[i] = kArr[i3];
            V[] vArr2 = this.values;
            vArr2[i] = vArr2[i3];
        }
        int i5 = this.size;
        kArr[i5] = null;
        this.values[i5] = null;
    }

    public V removeKey(K k) {
        K[] kArr = this.keys;
        int i = 0;
        if (k == null) {
            int i2 = this.size;
            while (i < i2) {
                if (kArr[i] == k) {
                    V v = this.values[i];
                    removeIndex(i);
                    return v;
                }
                i++;
            }
            return null;
        }
        int i3 = this.size;
        while (i < i3) {
            if (k.equals(kArr[i])) {
                V v2 = this.values[i];
                removeIndex(i);
                return v2;
            }
            i++;
        }
        return null;
    }

    public boolean removeValue(V v, boolean z) {
        V[] vArr = this.values;
        if (z || v == null) {
            int i = this.size;
            for (int i2 = 0; i2 < i; i2++) {
                if (vArr[i2] == v) {
                    removeIndex(i2);
                    return true;
                }
            }
        } else {
            int i3 = this.size;
            for (int i4 = 0; i4 < i3; i4++) {
                if (v.equals(vArr[i4])) {
                    removeIndex(i4);
                    return true;
                }
            }
        }
        return false;
    }

    public void resize(int i) {
        K[] kArr = (K[]) ((java.lang.Object[]) com.badlogic.gdx.utils.reflect.ArrayReflection.newInstance(this.keys.getClass().getComponentType(), i));
        java.lang.System.arraycopy(this.keys, 0, kArr, 0, java.lang.Math.min(this.size, kArr.length));
        this.keys = kArr;
        V[] vArr = (V[]) ((java.lang.Object[]) com.badlogic.gdx.utils.reflect.ArrayReflection.newInstance(this.values.getClass().getComponentType(), i));
        java.lang.System.arraycopy(this.values, 0, vArr, 0, java.lang.Math.min(this.size, vArr.length));
        this.values = vArr;
    }

    public void reverse() {
        int i = this.size;
        int i2 = i - 1;
        int i3 = i / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 - i4;
            K[] kArr = this.keys;
            K k = kArr[i4];
            kArr[i4] = kArr[i5];
            kArr[i5] = k;
            V[] vArr = this.values;
            V v = vArr[i4];
            vArr[i4] = vArr[i5];
            vArr[i5] = v;
        }
    }

    public void setKey(int i, K k) {
        if (i >= this.size) {
            throw new java.lang.IndexOutOfBoundsException(java.lang.String.valueOf(i));
        }
        this.keys[i] = k;
    }

    public void setValue(int i, V v) {
        if (i >= this.size) {
            throw new java.lang.IndexOutOfBoundsException(java.lang.String.valueOf(i));
        }
        this.values[i] = v;
    }

    public void shrink() {
        int length = this.keys.length;
        int i = this.size;
        if (length == i) {
            return;
        }
        resize(i);
    }

    public void shuffle() {
        for (int i = this.size - 1; i >= 0; i--) {
            int random = com.badlogic.gdx.math.MathUtils.random(i);
            K[] kArr = this.keys;
            K k = kArr[i];
            kArr[i] = kArr[random];
            kArr[random] = k;
            V[] vArr = this.values;
            V v = vArr[i];
            vArr[i] = vArr[random];
            vArr[random] = v;
        }
    }

    public java.lang.String toString() {
        if (this.size == 0) {
            return "{}";
        }
        K[] kArr = this.keys;
        V[] vArr = this.values;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append('{');
        stringBuilder.append(kArr[0]);
        stringBuilder.append(com.alipay.sdk.m.n.a.h);
        stringBuilder.append(vArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(kArr[i]);
            stringBuilder.append(com.alipay.sdk.m.n.a.h);
            stringBuilder.append(vArr[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void truncate(int i) {
        if (this.size <= i) {
            return;
        }
        for (int i2 = i; i2 < this.size; i2++) {
            this.keys[i2] = null;
            this.values[i2] = null;
        }
        this.size = i;
    }

    public com.badlogic.gdx.utils.ArrayMap.Values<V> values() {
        if (this.u == null) {
            this.u = new com.badlogic.gdx.utils.ArrayMap.Values(this);
            this.v = new com.badlogic.gdx.utils.ArrayMap.Values(this);
        }
        com.badlogic.gdx.utils.ArrayMap.Values<V> values = this.u;
        if (!values.u) {
            values.t = 0;
            values.u = true;
            this.v.u = false;
            return values;
        }
        com.badlogic.gdx.utils.ArrayMap.Values<V> values2 = this.v;
        values2.t = 0;
        values2.u = true;
        values.u = false;
        return values2;
    }
}
