package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class ObjectMap<K, V> implements java.lang.Iterable<com.badlogic.gdx.utils.ObjectMap.Entry<K, V>> {
    public int A;
    public int B;
    public com.badlogic.gdx.utils.ObjectMap.Entries C;
    public com.badlogic.gdx.utils.ObjectMap.Entries D;
    public com.badlogic.gdx.utils.ObjectMap.Values E;
    public com.badlogic.gdx.utils.ObjectMap.Values F;
    public com.badlogic.gdx.utils.ObjectMap.Keys G;
    public com.badlogic.gdx.utils.ObjectMap.Keys H;
    public K[] n;
    public int size;
    public V[] t;
    public int u;
    public int v;
    public float w;
    public int x;
    public int y;
    public int z;

    public static class Entries<K, V> extends com.badlogic.gdx.utils.ObjectMap.MapIterator<K, V, com.badlogic.gdx.utils.ObjectMap.Entry<K, V>> {
        public com.badlogic.gdx.utils.ObjectMap.Entry<K, V> w;

        public Entries(com.badlogic.gdx.utils.ObjectMap<K, V> objectMap) {
            super(objectMap);
            this.w = new com.badlogic.gdx.utils.ObjectMap.Entry<>();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.v) {
                return this.hasNext;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public com.badlogic.gdx.utils.ObjectMap.Entries<K, V> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public com.badlogic.gdx.utils.ObjectMap.Entry<K, V> next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            com.badlogic.gdx.utils.ObjectMap<K, V> objectMap = this.n;
            K[] kArr = objectMap.n;
            com.badlogic.gdx.utils.ObjectMap.Entry<K, V> entry = this.w;
            int i = this.t;
            entry.key = kArr[i];
            entry.value = objectMap.t[i];
            this.u = i;
            a();
            return this.w;
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }
    }

    public static class Entry<K, V> {
        public K key;
        public V value;

        public java.lang.String toString() {
            return this.key + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + this.value;
        }
    }

    public static class Keys<K> extends com.badlogic.gdx.utils.ObjectMap.MapIterator<K, java.lang.Object, K> {
        public Keys(com.badlogic.gdx.utils.ObjectMap<K, ?> objectMap) {
            super(objectMap);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.v) {
                return this.hasNext;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public com.badlogic.gdx.utils.ObjectMap.Keys<K> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public K next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            K[] kArr = this.n.n;
            int i = this.t;
            K k = kArr[i];
            this.u = i;
            a();
            return k;
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public com.badlogic.gdx.utils.Array<K> toArray() {
            return toArray(new com.badlogic.gdx.utils.Array<>(true, this.n.size));
        }

        public com.badlogic.gdx.utils.Array<K> toArray(com.badlogic.gdx.utils.Array<K> array) {
            while (this.hasNext) {
                array.add(next());
            }
            return array;
        }
    }

    public static abstract class MapIterator<K, V, I> implements java.lang.Iterable<I>, java.util.Iterator<I> {
        public boolean hasNext;
        public final com.badlogic.gdx.utils.ObjectMap<K, V> n;
        public int t;
        public int u;
        public boolean v = true;

        public MapIterator(com.badlogic.gdx.utils.ObjectMap<K, V> objectMap) {
            this.n = objectMap;
            reset();
        }

        public void a() {
            int i;
            this.hasNext = false;
            com.badlogic.gdx.utils.ObjectMap<K, V> objectMap = this.n;
            K[] kArr = objectMap.n;
            int i2 = objectMap.u + objectMap.v;
            do {
                i = this.t + 1;
                this.t = i;
                if (i >= i2) {
                    return;
                }
            } while (kArr[i] == null);
            this.hasNext = true;
        }

        public void remove() {
            int i = this.u;
            if (i < 0) {
                throw new java.lang.IllegalStateException("next must be called before remove.");
            }
            com.badlogic.gdx.utils.ObjectMap<K, V> objectMap = this.n;
            if (i >= objectMap.u) {
                objectMap.k(i);
                this.t = this.u - 1;
                a();
            } else {
                objectMap.n[i] = null;
                objectMap.t[i] = null;
            }
            this.u = -1;
            com.badlogic.gdx.utils.ObjectMap<K, V> objectMap2 = this.n;
            objectMap2.size--;
        }

        public void reset() {
            this.u = -1;
            this.t = -1;
            a();
        }
    }

    public static class Values<V> extends com.badlogic.gdx.utils.ObjectMap.MapIterator<java.lang.Object, V, V> {
        public Values(com.badlogic.gdx.utils.ObjectMap<?, V> objectMap) {
            super(objectMap);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.v) {
                return this.hasNext;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public com.badlogic.gdx.utils.ObjectMap.Values<V> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            V[] vArr = this.n.t;
            int i = this.t;
            V v = vArr[i];
            this.u = i;
            a();
            return v;
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        @Override // com.badlogic.gdx.utils.ObjectMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public com.badlogic.gdx.utils.Array<V> toArray() {
            return toArray(new com.badlogic.gdx.utils.Array<>(true, this.n.size));
        }

        public com.badlogic.gdx.utils.Array<V> toArray(com.badlogic.gdx.utils.Array<V> array) {
            while (this.hasNext) {
                array.add(next());
            }
            return array;
        }
    }

    public ObjectMap() {
        this(51, 0.8f);
    }

    public ObjectMap(int i) {
        this(i, 0.8f);
    }

    public ObjectMap(int i, float f) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("initialCapacity must be >= 0: " + i);
        }
        int nextPowerOfTwo = com.badlogic.gdx.math.MathUtils.nextPowerOfTwo((int) java.lang.Math.ceil(i / f));
        if (nextPowerOfTwo > 1073741824) {
            throw new java.lang.IllegalArgumentException("initialCapacity is too large: " + nextPowerOfTwo);
        }
        this.u = nextPowerOfTwo;
        if (f <= 0.0f) {
            throw new java.lang.IllegalArgumentException("loadFactor must be > 0: " + f);
        }
        this.w = f;
        this.z = (int) (nextPowerOfTwo * f);
        this.y = nextPowerOfTwo - 1;
        this.x = 31 - java.lang.Integer.numberOfTrailingZeros(nextPowerOfTwo);
        this.A = java.lang.Math.max(3, ((int) java.lang.Math.ceil(java.lang.Math.log(this.u))) * 2);
        this.B = java.lang.Math.max(java.lang.Math.min(this.u, 8), ((int) java.lang.Math.sqrt(this.u)) / 8);
        K[] kArr = (K[]) new java.lang.Object[this.u + this.A];
        this.n = kArr;
        this.t = (V[]) new java.lang.Object[kArr.length];
    }

    public ObjectMap(com.badlogic.gdx.utils.ObjectMap<? extends K, ? extends V> objectMap) {
        this((int) java.lang.Math.floor(objectMap.u * objectMap.w), objectMap.w);
        this.v = objectMap.v;
        java.lang.Object[] objArr = objectMap.n;
        java.lang.System.arraycopy(objArr, 0, this.n, 0, objArr.length);
        java.lang.Object[] objArr2 = objectMap.t;
        java.lang.System.arraycopy(objArr2, 0, this.t, 0, objArr2.length);
        this.size = objectMap.size;
    }

    public final boolean a(K k) {
        K[] kArr = this.n;
        int i = this.u;
        int i2 = this.v + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public final V b(K k) {
        K[] kArr = this.n;
        int i = this.u;
        int i2 = this.v + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return this.t[i];
            }
            i++;
        }
        return null;
    }

    public final V c(K k, V v) {
        K[] kArr = this.n;
        int i = this.u;
        int i2 = this.v + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return this.t[i];
            }
            i++;
        }
        return v;
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        K[] kArr = this.n;
        V[] vArr = this.t;
        int i = this.u + this.v;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                this.size = 0;
                this.v = 0;
                return;
            } else {
                kArr[i2] = null;
                vArr[i2] = null;
                i = i2;
            }
        }
    }

    public void clear(int i) {
        if (this.u <= i) {
            clear();
        } else {
            this.size = 0;
            l(i);
        }
    }

    public boolean containsKey(K k) {
        int hashCode = k.hashCode();
        if (k.equals(this.n[this.y & hashCode])) {
            return true;
        }
        if (k.equals(this.n[d(hashCode)])) {
            return true;
        }
        if (k.equals(this.n[e(hashCode)])) {
            return true;
        }
        return a(k);
    }

    public boolean containsValue(java.lang.Object obj, boolean z) {
        V[] vArr = this.t;
        if (obj == null) {
            K[] kArr = this.n;
            int i = this.u + this.v;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return false;
                }
                if (kArr[i2] != null && vArr[i2] == null) {
                    return true;
                }
                i = i2;
            }
        } else if (z) {
            int i3 = this.u + this.v;
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    return false;
                }
                if (vArr[i4] == obj) {
                    return true;
                }
                i3 = i4;
            }
        } else {
            int i5 = this.u + this.v;
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    return false;
                }
                if (obj.equals(vArr[i6])) {
                    return true;
                }
                i5 = i6;
            }
        }
    }

    public final int d(int i) {
        int i2 = i * (-1262997959);
        return (i2 ^ (i2 >>> this.x)) & this.y;
    }

    public final int e(int i) {
        int i2 = i * (-825114047);
        return (i2 ^ (i2 >>> this.x)) & this.y;
    }

    public void ensureCapacity(int i) {
        if (this.size + i >= this.z) {
            l(com.badlogic.gdx.math.MathUtils.nextPowerOfTwo((int) java.lang.Math.ceil(r0 / this.w)));
        }
    }

    public com.badlogic.gdx.utils.ObjectMap.Entries<K, V> entries() {
        if (this.C == null) {
            this.C = new com.badlogic.gdx.utils.ObjectMap.Entries(this);
            this.D = new com.badlogic.gdx.utils.ObjectMap.Entries(this);
        }
        com.badlogic.gdx.utils.ObjectMap.Entries entries = this.C;
        if (entries.v) {
            this.D.reset();
            com.badlogic.gdx.utils.ObjectMap.Entries<K, V> entries2 = this.D;
            entries2.v = true;
            this.C.v = false;
            return entries2;
        }
        entries.reset();
        com.badlogic.gdx.utils.ObjectMap.Entries<K, V> entries3 = this.C;
        entries3.v = true;
        this.D.v = false;
        return entries3;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.badlogic.gdx.utils.ObjectMap)) {
            return false;
        }
        com.badlogic.gdx.utils.ObjectMap objectMap = (com.badlogic.gdx.utils.ObjectMap) obj;
        if (objectMap.size != this.size) {
            return false;
        }
        K[] kArr = this.n;
        V[] vArr = this.t;
        int i = this.u + this.v;
        for (int i2 = 0; i2 < i; i2++) {
            K k = kArr[i2];
            if (k != null) {
                V v = vArr[i2];
                if (v == null) {
                    if (!objectMap.containsKey(k) || objectMap.get(k) != null) {
                        return false;
                    }
                } else if (!v.equals(objectMap.get(k))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void f(K k, V v, int i, K k2, int i2, K k3, int i3, K k4) {
        K[] kArr = this.n;
        V[] vArr = this.t;
        int i4 = this.y;
        int i5 = this.B;
        K k5 = k;
        V v2 = v;
        int i6 = i;
        K k6 = k2;
        int i7 = i2;
        K k7 = k3;
        int i8 = i3;
        K k8 = k4;
        int i9 = 0;
        while (true) {
            int random = com.badlogic.gdx.math.MathUtils.random(2);
            if (random == 0) {
                V v3 = vArr[i6];
                kArr[i6] = k5;
                vArr[i6] = v2;
                k5 = k6;
                v2 = v3;
            } else if (random != 1) {
                V v4 = vArr[i8];
                kArr[i8] = k5;
                vArr[i8] = v2;
                v2 = v4;
                k5 = k8;
            } else {
                V v5 = vArr[i7];
                kArr[i7] = k5;
                vArr[i7] = v2;
                v2 = v5;
                k5 = k7;
            }
            int hashCode = k5.hashCode();
            int i10 = hashCode & i4;
            K k9 = kArr[i10];
            if (k9 == null) {
                kArr[i10] = k5;
                vArr[i10] = v2;
                int i11 = this.size;
                this.size = i11 + 1;
                if (i11 >= this.z) {
                    l(this.u << 1);
                    return;
                }
                return;
            }
            int d = d(hashCode);
            K k10 = kArr[d];
            if (k10 == null) {
                kArr[d] = k5;
                vArr[d] = v2;
                int i12 = this.size;
                this.size = i12 + 1;
                if (i12 >= this.z) {
                    l(this.u << 1);
                    return;
                }
                return;
            }
            int e = e(hashCode);
            k8 = kArr[e];
            if (k8 == null) {
                kArr[e] = k5;
                vArr[e] = v2;
                int i13 = this.size;
                this.size = i13 + 1;
                if (i13 >= this.z) {
                    l(this.u << 1);
                    return;
                }
                return;
            }
            i9++;
            if (i9 == i5) {
                h(k5, v2);
                return;
            }
            i8 = e;
            i6 = i10;
            k6 = k9;
            i7 = d;
            k7 = k10;
        }
    }

    public K findKey(java.lang.Object obj, boolean z) {
        V[] vArr = this.t;
        if (obj == null) {
            K[] kArr = this.n;
            int i = this.u + this.v;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return null;
                }
                K k = kArr[i2];
                if (k != null && vArr[i2] == null) {
                    return k;
                }
                i = i2;
            }
        } else if (z) {
            int i3 = this.u + this.v;
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    return null;
                }
                if (vArr[i4] == obj) {
                    return this.n[i4];
                }
                i3 = i4;
            }
        } else {
            int i5 = this.u + this.v;
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    return null;
                }
                if (obj.equals(vArr[i6])) {
                    return this.n[i6];
                }
                i5 = i6;
            }
        }
    }

    public final void g(K k, V v) {
        int hashCode = k.hashCode();
        int i = hashCode & this.y;
        K[] kArr = this.n;
        K k2 = kArr[i];
        if (k2 == null) {
            kArr[i] = k;
            this.t[i] = v;
            int i2 = this.size;
            this.size = i2 + 1;
            if (i2 >= this.z) {
                l(this.u << 1);
                return;
            }
            return;
        }
        int d = d(hashCode);
        K[] kArr2 = this.n;
        K k3 = kArr2[d];
        if (k3 == null) {
            kArr2[d] = k;
            this.t[d] = v;
            int i3 = this.size;
            this.size = i3 + 1;
            if (i3 >= this.z) {
                l(this.u << 1);
                return;
            }
            return;
        }
        int e = e(hashCode);
        K[] kArr3 = this.n;
        K k4 = kArr3[e];
        if (k4 != null) {
            f(k, v, i, k2, d, k3, e, k4);
            return;
        }
        kArr3[e] = k;
        this.t[e] = v;
        int i4 = this.size;
        this.size = i4 + 1;
        if (i4 >= this.z) {
            l(this.u << 1);
        }
    }

    public V get(K k) {
        int hashCode = k.hashCode();
        int i = this.y & hashCode;
        if (!k.equals(this.n[i])) {
            i = d(hashCode);
            if (!k.equals(this.n[i])) {
                i = e(hashCode);
                if (!k.equals(this.n[i])) {
                    return b(k);
                }
            }
        }
        return this.t[i];
    }

    public V get(K k, V v) {
        int hashCode = k.hashCode();
        int i = this.y & hashCode;
        if (!k.equals(this.n[i])) {
            i = d(hashCode);
            if (!k.equals(this.n[i])) {
                i = e(hashCode);
                if (!k.equals(this.n[i])) {
                    return c(k, v);
                }
            }
        }
        return this.t[i];
    }

    public final void h(K k, V v) {
        int i = this.v;
        if (i == this.A) {
            l(this.u << 1);
            i(k, v);
            return;
        }
        int i2 = this.u + i;
        this.n[i2] = k;
        this.t[i2] = v;
        this.v = i + 1;
        this.size++;
    }

    public int hashCode() {
        K[] kArr = this.n;
        V[] vArr = this.t;
        int i = this.u + this.v;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            K k = kArr[i3];
            if (k != null) {
                i2 += k.hashCode() * 31;
                V v = vArr[i3];
                if (v != null) {
                    i2 += v.hashCode();
                }
            }
        }
        return i2;
    }

    public final V i(K k, V v) {
        java.lang.Object[] objArr = this.n;
        int hashCode = k.hashCode();
        int i = hashCode & this.y;
        K k2 = objArr[i];
        if (k.equals(k2)) {
            V[] vArr = this.t;
            V v2 = vArr[i];
            vArr[i] = v;
            return v2;
        }
        int d = d(hashCode);
        K k3 = objArr[d];
        if (k.equals(k3)) {
            V[] vArr2 = this.t;
            V v3 = vArr2[d];
            vArr2[d] = v;
            return v3;
        }
        int e = e(hashCode);
        K k4 = objArr[e];
        if (k.equals(k4)) {
            V[] vArr3 = this.t;
            V v4 = vArr3[e];
            vArr3[e] = v;
            return v4;
        }
        int i2 = this.u;
        int i3 = this.v + i2;
        while (i2 < i3) {
            if (k.equals(objArr[i2])) {
                V[] vArr4 = this.t;
                V v5 = vArr4[i2];
                vArr4[i2] = v;
                return v5;
            }
            i2++;
        }
        if (k2 == null) {
            objArr[i] = k;
            this.t[i] = v;
            int i4 = this.size;
            this.size = i4 + 1;
            if (i4 >= this.z) {
                l(this.u << 1);
            }
            return null;
        }
        if (k3 == null) {
            objArr[d] = k;
            this.t[d] = v;
            int i5 = this.size;
            this.size = i5 + 1;
            if (i5 >= this.z) {
                l(this.u << 1);
            }
            return null;
        }
        if (k4 != null) {
            f(k, v, i, k2, d, k3, e, k4);
            return null;
        }
        objArr[e] = k;
        this.t[e] = v;
        int i6 = this.size;
        this.size = i6 + 1;
        if (i6 >= this.z) {
            l(this.u << 1);
        }
        return null;
    }

    @Override // java.lang.Iterable
    public com.badlogic.gdx.utils.ObjectMap.Entries<K, V> iterator() {
        return entries();
    }

    public V j(K k) {
        K[] kArr = this.n;
        int i = this.u;
        int i2 = this.v + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                V v = this.t[i];
                k(i);
                this.size--;
                return v;
            }
            i++;
        }
        return null;
    }

    public void k(int i) {
        int i2 = this.v - 1;
        this.v = i2;
        int i3 = this.u + i2;
        if (i >= i3) {
            this.t[i] = null;
            return;
        }
        K[] kArr = this.n;
        kArr[i] = kArr[i3];
        V[] vArr = this.t;
        vArr[i] = vArr[i3];
        vArr[i3] = null;
    }

    public com.badlogic.gdx.utils.ObjectMap.Keys<K> keys() {
        if (this.G == null || this.H == null) {
            this.G = new com.badlogic.gdx.utils.ObjectMap.Keys(this);
            this.H = new com.badlogic.gdx.utils.ObjectMap.Keys(this);
        }
        com.badlogic.gdx.utils.ObjectMap.Keys keys = this.G;
        if (keys.v) {
            this.H.reset();
            com.badlogic.gdx.utils.ObjectMap.Keys<K> keys2 = this.H;
            keys2.v = true;
            this.G.v = false;
            return keys2;
        }
        keys.reset();
        com.badlogic.gdx.utils.ObjectMap.Keys<K> keys3 = this.G;
        keys3.v = true;
        this.H.v = false;
        return keys3;
    }

    public final void l(int i) {
        int i2 = this.u + this.v;
        this.u = i;
        this.z = (int) (i * this.w);
        this.y = i - 1;
        this.x = 31 - java.lang.Integer.numberOfTrailingZeros(i);
        double d = i;
        this.A = java.lang.Math.max(3, ((int) java.lang.Math.ceil(java.lang.Math.log(d))) * 2);
        this.B = java.lang.Math.max(java.lang.Math.min(i, 8), ((int) java.lang.Math.sqrt(d)) / 8);
        K[] kArr = this.n;
        V[] vArr = this.t;
        int i3 = this.A;
        this.n = (K[]) new java.lang.Object[i + i3];
        this.t = (V[]) new java.lang.Object[i + i3];
        int i4 = this.size;
        this.size = 0;
        this.v = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                K k = kArr[i5];
                if (k != null) {
                    g(k, vArr[i5]);
                }
            }
        }
    }

    public final java.lang.String m(java.lang.String str, boolean z) {
        int i;
        if (this.size == 0) {
            return z ? "{}" : "";
        }
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        if (z) {
            stringBuilder.append('{');
        }
        K[] kArr = this.n;
        V[] vArr = this.t;
        int length = kArr.length;
        while (true) {
            i = length - 1;
            if (length > 0) {
                K k = kArr[i];
                if (k != null) {
                    stringBuilder.append(k);
                    stringBuilder.append(com.alipay.sdk.m.n.a.h);
                    stringBuilder.append(vArr[i]);
                    break;
                }
                length = i;
            } else {
                break;
            }
        }
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            K k2 = kArr[i2];
            if (k2 != null) {
                stringBuilder.append(str);
                stringBuilder.append(k2);
                stringBuilder.append(com.alipay.sdk.m.n.a.h);
                stringBuilder.append(vArr[i2]);
            }
            i = i2;
        }
        if (z) {
            stringBuilder.append('}');
        }
        return stringBuilder.toString();
    }

    public V put(K k, V v) {
        if (k != null) {
            return i(k, v);
        }
        throw new java.lang.IllegalArgumentException("key cannot be null.");
    }

    public void putAll(com.badlogic.gdx.utils.ObjectMap<K, V> objectMap) {
        ensureCapacity(objectMap.size);
        com.badlogic.gdx.utils.ObjectMap.Entries<K, V> it = objectMap.iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.utils.ObjectMap.Entry<K, V> next = it.next();
            put(next.key, next.value);
        }
    }

    public V remove(K k) {
        int hashCode = k.hashCode();
        int i = this.y & hashCode;
        if (k.equals(this.n[i])) {
            this.n[i] = null;
            V[] vArr = this.t;
            V v = vArr[i];
            vArr[i] = null;
            this.size--;
            return v;
        }
        int d = d(hashCode);
        if (k.equals(this.n[d])) {
            this.n[d] = null;
            V[] vArr2 = this.t;
            V v2 = vArr2[d];
            vArr2[d] = null;
            this.size--;
            return v2;
        }
        int e = e(hashCode);
        if (!k.equals(this.n[e])) {
            return j(k);
        }
        this.n[e] = null;
        V[] vArr3 = this.t;
        V v3 = vArr3[e];
        vArr3[e] = null;
        this.size--;
        return v3;
    }

    public void shrink(int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("maximumCapacity must be >= 0: " + i);
        }
        int i2 = this.size;
        if (i2 > i) {
            i = i2;
        }
        if (this.u <= i) {
            return;
        }
        l(com.badlogic.gdx.math.MathUtils.nextPowerOfTwo(i));
    }

    public java.lang.String toString() {
        return m(", ", true);
    }

    public java.lang.String toString(java.lang.String str) {
        return m(str, false);
    }

    public com.badlogic.gdx.utils.ObjectMap.Values<V> values() {
        if (this.E == null) {
            this.E = new com.badlogic.gdx.utils.ObjectMap.Values(this);
            this.F = new com.badlogic.gdx.utils.ObjectMap.Values(this);
        }
        com.badlogic.gdx.utils.ObjectMap.Values values = this.E;
        if (values.v) {
            this.F.reset();
            com.badlogic.gdx.utils.ObjectMap.Values<V> values2 = this.F;
            values2.v = true;
            this.E.v = false;
            return values2;
        }
        values.reset();
        com.badlogic.gdx.utils.ObjectMap.Values<V> values3 = this.E;
        values3.v = true;
        this.F.v = false;
        return values3;
    }
}
