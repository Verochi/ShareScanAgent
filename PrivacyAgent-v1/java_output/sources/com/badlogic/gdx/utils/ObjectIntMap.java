package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class ObjectIntMap<K> implements java.lang.Iterable<com.badlogic.gdx.utils.ObjectIntMap.Entry<K>> {
    public int A;
    public int B;
    public com.badlogic.gdx.utils.ObjectIntMap.Entries C;
    public com.badlogic.gdx.utils.ObjectIntMap.Entries D;
    public com.badlogic.gdx.utils.ObjectIntMap.Values E;
    public com.badlogic.gdx.utils.ObjectIntMap.Values F;
    public com.badlogic.gdx.utils.ObjectIntMap.Keys G;
    public com.badlogic.gdx.utils.ObjectIntMap.Keys H;
    public K[] n;
    public int size;
    public int[] t;
    public int u;
    public int v;
    public float w;
    public int x;
    public int y;
    public int z;

    public static class Entries<K> extends com.badlogic.gdx.utils.ObjectIntMap.MapIterator<K> implements java.lang.Iterable<com.badlogic.gdx.utils.ObjectIntMap.Entry<K>>, java.util.Iterator<com.badlogic.gdx.utils.ObjectIntMap.Entry<K>> {
        public com.badlogic.gdx.utils.ObjectIntMap.Entry<K> w;

        public Entries(com.badlogic.gdx.utils.ObjectIntMap<K> objectIntMap) {
            super(objectIntMap);
            this.w = new com.badlogic.gdx.utils.ObjectIntMap.Entry<>();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.v) {
                return this.hasNext;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public com.badlogic.gdx.utils.ObjectIntMap.Entries<K> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public com.badlogic.gdx.utils.ObjectIntMap.Entry<K> next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            com.badlogic.gdx.utils.ObjectIntMap<K> objectIntMap = this.n;
            K[] kArr = objectIntMap.n;
            com.badlogic.gdx.utils.ObjectIntMap.Entry<K> entry = this.w;
            int i = this.t;
            entry.key = kArr[i];
            entry.value = objectIntMap.t[i];
            this.u = i;
            a();
            return this.w;
        }

        @Override // com.badlogic.gdx.utils.ObjectIntMap.MapIterator, java.util.Iterator
        public void remove() {
            super.remove();
        }

        @Override // com.badlogic.gdx.utils.ObjectIntMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }
    }

    public static class Entry<K> {
        public K key;
        public int value;

        public java.lang.String toString() {
            return this.key + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + this.value;
        }
    }

    public static class Keys<K> extends com.badlogic.gdx.utils.ObjectIntMap.MapIterator<K> implements java.lang.Iterable<K>, java.util.Iterator<K> {
        public Keys(com.badlogic.gdx.utils.ObjectIntMap<K> objectIntMap) {
            super(objectIntMap);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.v) {
                return this.hasNext;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public com.badlogic.gdx.utils.ObjectIntMap.Keys<K> iterator() {
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

        @Override // com.badlogic.gdx.utils.ObjectIntMap.MapIterator, java.util.Iterator
        public void remove() {
            super.remove();
        }

        @Override // com.badlogic.gdx.utils.ObjectIntMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public com.badlogic.gdx.utils.Array<K> toArray() {
            com.badlogic.gdx.utils.Array<K> array = new com.badlogic.gdx.utils.Array<>(true, this.n.size);
            while (this.hasNext) {
                array.add(next());
            }
            return array;
        }

        public com.badlogic.gdx.utils.Array<K> toArray(com.badlogic.gdx.utils.Array<K> array) {
            while (this.hasNext) {
                array.add(next());
            }
            return array;
        }
    }

    public static class MapIterator<K> {
        public boolean hasNext;
        public final com.badlogic.gdx.utils.ObjectIntMap<K> n;
        public int t;
        public int u;
        public boolean v = true;

        public MapIterator(com.badlogic.gdx.utils.ObjectIntMap<K> objectIntMap) {
            this.n = objectIntMap;
            reset();
        }

        public void a() {
            int i;
            this.hasNext = false;
            com.badlogic.gdx.utils.ObjectIntMap<K> objectIntMap = this.n;
            K[] kArr = objectIntMap.n;
            int i2 = objectIntMap.u + objectIntMap.v;
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
            com.badlogic.gdx.utils.ObjectIntMap<K> objectIntMap = this.n;
            if (i >= objectIntMap.u) {
                objectIntMap.j(i);
                this.t = this.u - 1;
                a();
            } else {
                objectIntMap.n[i] = null;
            }
            this.u = -1;
            com.badlogic.gdx.utils.ObjectIntMap<K> objectIntMap2 = this.n;
            objectIntMap2.size--;
        }

        public void reset() {
            this.u = -1;
            this.t = -1;
            a();
        }
    }

    public static class Values extends com.badlogic.gdx.utils.ObjectIntMap.MapIterator<java.lang.Object> {
        public Values(com.badlogic.gdx.utils.ObjectIntMap<?> objectIntMap) {
            super(objectIntMap);
        }

        public boolean hasNext() {
            if (this.v) {
                return this.hasNext;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        public int next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            int[] iArr = this.n.t;
            int i = this.t;
            int i2 = iArr[i];
            this.u = i;
            a();
            return i2;
        }

        @Override // com.badlogic.gdx.utils.ObjectIntMap.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        @Override // com.badlogic.gdx.utils.ObjectIntMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public com.badlogic.gdx.utils.IntArray toArray() {
            com.badlogic.gdx.utils.IntArray intArray = new com.badlogic.gdx.utils.IntArray(true, this.n.size);
            while (this.hasNext) {
                intArray.add(next());
            }
            return intArray;
        }
    }

    public ObjectIntMap() {
        this(51, 0.8f);
    }

    public ObjectIntMap(int i) {
        this(i, 0.8f);
    }

    public ObjectIntMap(int i, float f) {
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
        this.t = new int[kArr.length];
    }

    public ObjectIntMap(com.badlogic.gdx.utils.ObjectIntMap<? extends K> objectIntMap) {
        this((int) java.lang.Math.floor(objectIntMap.u * objectIntMap.w), objectIntMap.w);
        this.v = objectIntMap.v;
        java.lang.Object[] objArr = objectIntMap.n;
        java.lang.System.arraycopy(objArr, 0, this.n, 0, objArr.length);
        int[] iArr = objectIntMap.t;
        java.lang.System.arraycopy(iArr, 0, this.t, 0, iArr.length);
        this.size = objectIntMap.size;
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

    public final int b(K k, int i, int i2) {
        K[] kArr = this.n;
        int i3 = this.u;
        int i4 = this.v + i3;
        while (i3 < i4) {
            if (k.equals(kArr[i3])) {
                int[] iArr = this.t;
                int i5 = iArr[i3];
                iArr[i3] = i2 + i5;
                return i5;
            }
            i3++;
        }
        put(k, i2 + i);
        return i;
    }

    public final int c(K k, int i) {
        K[] kArr = this.n;
        int i2 = this.u;
        int i3 = this.v + i2;
        while (i2 < i3) {
            if (k.equals(kArr[i2])) {
                return this.t[i2];
            }
            i2++;
        }
        return i;
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        K[] kArr = this.n;
        int i = this.u + this.v;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                this.size = 0;
                this.v = 0;
                return;
            } else {
                kArr[i2] = null;
                i = i2;
            }
        }
    }

    public void clear(int i) {
        if (this.u <= i) {
            clear();
        } else {
            this.size = 0;
            k(i);
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

    public boolean containsValue(int i) {
        K[] kArr = this.n;
        int[] iArr = this.t;
        int i2 = this.u + this.v;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return false;
            }
            if (kArr[i3] != null && iArr[i3] == i) {
                return true;
            }
            i2 = i3;
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
            k(com.badlogic.gdx.math.MathUtils.nextPowerOfTwo((int) java.lang.Math.ceil(r0 / this.w)));
        }
    }

    public com.badlogic.gdx.utils.ObjectIntMap.Entries<K> entries() {
        if (this.C == null) {
            this.C = new com.badlogic.gdx.utils.ObjectIntMap.Entries(this);
            this.D = new com.badlogic.gdx.utils.ObjectIntMap.Entries(this);
        }
        com.badlogic.gdx.utils.ObjectIntMap.Entries entries = this.C;
        if (entries.v) {
            this.D.reset();
            com.badlogic.gdx.utils.ObjectIntMap.Entries<K> entries2 = this.D;
            entries2.v = true;
            this.C.v = false;
            return entries2;
        }
        entries.reset();
        com.badlogic.gdx.utils.ObjectIntMap.Entries<K> entries3 = this.C;
        entries3.v = true;
        this.D.v = false;
        return entries3;
    }

    public boolean equals(java.lang.Object obj) {
        int i;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.badlogic.gdx.utils.ObjectIntMap)) {
            return false;
        }
        com.badlogic.gdx.utils.ObjectIntMap objectIntMap = (com.badlogic.gdx.utils.ObjectIntMap) obj;
        if (objectIntMap.size != this.size) {
            return false;
        }
        K[] kArr = this.n;
        int[] iArr = this.t;
        int i2 = this.u + this.v;
        for (int i3 = 0; i3 < i2; i3++) {
            K k = kArr[i3];
            if (k != null && (((i = objectIntMap.get(k, 0)) == 0 && !objectIntMap.containsKey(k)) || i != iArr[i3])) {
                return false;
            }
        }
        return true;
    }

    public final void f(K k, int i, int i2, K k2, int i3, K k3, int i4, K k4) {
        K[] kArr = this.n;
        int[] iArr = this.t;
        int i5 = this.y;
        int i6 = this.B;
        K k5 = k;
        int i7 = i;
        int i8 = i2;
        K k6 = k2;
        int i9 = i3;
        K k7 = k3;
        int i10 = i4;
        K k8 = k4;
        int i11 = 0;
        while (true) {
            int random = com.badlogic.gdx.math.MathUtils.random(2);
            if (random == 0) {
                int i12 = iArr[i8];
                kArr[i8] = k5;
                iArr[i8] = i7;
                k5 = k6;
                i7 = i12;
            } else if (random != 1) {
                int i13 = iArr[i10];
                kArr[i10] = k5;
                iArr[i10] = i7;
                i7 = i13;
                k5 = k8;
            } else {
                int i14 = iArr[i9];
                kArr[i9] = k5;
                iArr[i9] = i7;
                i7 = i14;
                k5 = k7;
            }
            int hashCode = k5.hashCode();
            int i15 = hashCode & i5;
            K k9 = kArr[i15];
            if (k9 == null) {
                kArr[i15] = k5;
                iArr[i15] = i7;
                int i16 = this.size;
                this.size = i16 + 1;
                if (i16 >= this.z) {
                    k(this.u << 1);
                    return;
                }
                return;
            }
            int d = d(hashCode);
            K k10 = kArr[d];
            if (k10 == null) {
                kArr[d] = k5;
                iArr[d] = i7;
                int i17 = this.size;
                this.size = i17 + 1;
                if (i17 >= this.z) {
                    k(this.u << 1);
                    return;
                }
                return;
            }
            int e = e(hashCode);
            k8 = kArr[e];
            if (k8 == null) {
                kArr[e] = k5;
                iArr[e] = i7;
                int i18 = this.size;
                this.size = i18 + 1;
                if (i18 >= this.z) {
                    k(this.u << 1);
                    return;
                }
                return;
            }
            i11++;
            if (i11 == i6) {
                h(k5, i7);
                return;
            }
            i10 = e;
            i8 = i15;
            k6 = k9;
            i9 = d;
            k7 = k10;
        }
    }

    public K findKey(int i) {
        K[] kArr = this.n;
        int[] iArr = this.t;
        int i2 = this.u + this.v;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return null;
            }
            K k = kArr[i3];
            if (k != null && iArr[i3] == i) {
                return k;
            }
            i2 = i3;
        }
    }

    public final void g(K k, int i) {
        int hashCode = k.hashCode();
        int i2 = hashCode & this.y;
        K[] kArr = this.n;
        K k2 = kArr[i2];
        if (k2 == null) {
            kArr[i2] = k;
            this.t[i2] = i;
            int i3 = this.size;
            this.size = i3 + 1;
            if (i3 >= this.z) {
                k(this.u << 1);
                return;
            }
            return;
        }
        int d = d(hashCode);
        K[] kArr2 = this.n;
        K k3 = kArr2[d];
        if (k3 == null) {
            kArr2[d] = k;
            this.t[d] = i;
            int i4 = this.size;
            this.size = i4 + 1;
            if (i4 >= this.z) {
                k(this.u << 1);
                return;
            }
            return;
        }
        int e = e(hashCode);
        K[] kArr3 = this.n;
        K k4 = kArr3[e];
        if (k4 != null) {
            f(k, i, i2, k2, d, k3, e, k4);
            return;
        }
        kArr3[e] = k;
        this.t[e] = i;
        int i5 = this.size;
        this.size = i5 + 1;
        if (i5 >= this.z) {
            k(this.u << 1);
        }
    }

    public int get(K k, int i) {
        int hashCode = k.hashCode();
        int i2 = this.y & hashCode;
        if (!k.equals(this.n[i2])) {
            i2 = d(hashCode);
            if (!k.equals(this.n[i2])) {
                i2 = e(hashCode);
                if (!k.equals(this.n[i2])) {
                    return c(k, i);
                }
            }
        }
        return this.t[i2];
    }

    public int getAndIncrement(K k, int i, int i2) {
        int hashCode = k.hashCode();
        int i3 = this.y & hashCode;
        if (!k.equals(this.n[i3])) {
            i3 = d(hashCode);
            if (!k.equals(this.n[i3])) {
                i3 = e(hashCode);
                if (!k.equals(this.n[i3])) {
                    return b(k, i, i2);
                }
            }
        }
        int[] iArr = this.t;
        int i4 = iArr[i3];
        iArr[i3] = i2 + i4;
        return i4;
    }

    public final void h(K k, int i) {
        int i2 = this.v;
        if (i2 == this.A) {
            k(this.u << 1);
            put(k, i);
            return;
        }
        int i3 = this.u + i2;
        this.n[i3] = k;
        this.t[i3] = i;
        this.v = i2 + 1;
        this.size++;
    }

    public int hashCode() {
        K[] kArr = this.n;
        int[] iArr = this.t;
        int i = this.u + this.v;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            K k = kArr[i3];
            if (k != null) {
                i2 = i2 + (k.hashCode() * 31) + iArr[i3];
            }
        }
        return i2;
    }

    public int i(K k, int i) {
        K[] kArr = this.n;
        int i2 = this.u;
        int i3 = this.v + i2;
        while (i2 < i3) {
            if (k.equals(kArr[i2])) {
                int i4 = this.t[i2];
                j(i2);
                this.size--;
                return i4;
            }
            i2++;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public com.badlogic.gdx.utils.ObjectIntMap.Entries<K> iterator() {
        return entries();
    }

    public void j(int i) {
        int i2 = this.v - 1;
        this.v = i2;
        int i3 = this.u + i2;
        if (i < i3) {
            K[] kArr = this.n;
            kArr[i] = kArr[i3];
            int[] iArr = this.t;
            iArr[i] = iArr[i3];
        }
    }

    public final void k(int i) {
        int i2 = this.u + this.v;
        this.u = i;
        this.z = (int) (i * this.w);
        this.y = i - 1;
        this.x = 31 - java.lang.Integer.numberOfTrailingZeros(i);
        double d = i;
        this.A = java.lang.Math.max(3, ((int) java.lang.Math.ceil(java.lang.Math.log(d))) * 2);
        this.B = java.lang.Math.max(java.lang.Math.min(i, 8), ((int) java.lang.Math.sqrt(d)) / 8);
        K[] kArr = this.n;
        int[] iArr = this.t;
        int i3 = this.A;
        this.n = (K[]) new java.lang.Object[i + i3];
        this.t = new int[i + i3];
        int i4 = this.size;
        this.size = 0;
        this.v = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                K k = kArr[i5];
                if (k != null) {
                    g(k, iArr[i5]);
                }
            }
        }
    }

    public com.badlogic.gdx.utils.ObjectIntMap.Keys<K> keys() {
        if (this.G == null) {
            this.G = new com.badlogic.gdx.utils.ObjectIntMap.Keys(this);
            this.H = new com.badlogic.gdx.utils.ObjectIntMap.Keys(this);
        }
        com.badlogic.gdx.utils.ObjectIntMap.Keys keys = this.G;
        if (keys.v) {
            this.H.reset();
            com.badlogic.gdx.utils.ObjectIntMap.Keys<K> keys2 = this.H;
            keys2.v = true;
            this.G.v = false;
            return keys2;
        }
        keys.reset();
        com.badlogic.gdx.utils.ObjectIntMap.Keys<K> keys3 = this.G;
        keys3.v = true;
        this.H.v = false;
        return keys3;
    }

    public void put(K k, int i) {
        if (k == null) {
            throw new java.lang.IllegalArgumentException("key cannot be null.");
        }
        java.lang.Object[] objArr = this.n;
        int hashCode = k.hashCode();
        int i2 = hashCode & this.y;
        K k2 = objArr[i2];
        if (k.equals(k2)) {
            this.t[i2] = i;
            return;
        }
        int d = d(hashCode);
        K k3 = objArr[d];
        if (k.equals(k3)) {
            this.t[d] = i;
            return;
        }
        int e = e(hashCode);
        K k4 = objArr[e];
        if (k.equals(k4)) {
            this.t[e] = i;
            return;
        }
        int i3 = this.u;
        int i4 = this.v + i3;
        while (i3 < i4) {
            if (k.equals(objArr[i3])) {
                this.t[i3] = i;
                return;
            }
            i3++;
        }
        if (k2 == null) {
            objArr[i2] = k;
            this.t[i2] = i;
            int i5 = this.size;
            this.size = i5 + 1;
            if (i5 >= this.z) {
                k(this.u << 1);
                return;
            }
            return;
        }
        if (k3 == null) {
            objArr[d] = k;
            this.t[d] = i;
            int i6 = this.size;
            this.size = i6 + 1;
            if (i6 >= this.z) {
                k(this.u << 1);
                return;
            }
            return;
        }
        if (k4 != null) {
            f(k, i, i2, k2, d, k3, e, k4);
            return;
        }
        objArr[e] = k;
        this.t[e] = i;
        int i7 = this.size;
        this.size = i7 + 1;
        if (i7 >= this.z) {
            k(this.u << 1);
        }
    }

    public void putAll(com.badlogic.gdx.utils.ObjectIntMap<K> objectIntMap) {
        com.badlogic.gdx.utils.ObjectIntMap.Entries<K> it = objectIntMap.entries().iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.utils.ObjectIntMap.Entry<K> next = it.next();
            put(next.key, next.value);
        }
    }

    public int remove(K k, int i) {
        int hashCode = k.hashCode();
        int i2 = this.y & hashCode;
        if (k.equals(this.n[i2])) {
            this.n[i2] = null;
            this.size--;
            return this.t[i2];
        }
        int d = d(hashCode);
        if (k.equals(this.n[d])) {
            this.n[d] = null;
            this.size--;
            return this.t[d];
        }
        int e = e(hashCode);
        if (!k.equals(this.n[e])) {
            return i(k, i);
        }
        this.n[e] = null;
        this.size--;
        return this.t[e];
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
        k(com.badlogic.gdx.math.MathUtils.nextPowerOfTwo(i));
    }

    public java.lang.String toString() {
        int i;
        if (this.size == 0) {
            return "{}";
        }
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append('{');
        K[] kArr = this.n;
        int[] iArr = this.t;
        int length = kArr.length;
        while (true) {
            i = length - 1;
            if (length > 0) {
                K k = kArr[i];
                if (k != null) {
                    stringBuilder.append(k);
                    stringBuilder.append(com.alipay.sdk.m.n.a.h);
                    stringBuilder.append(iArr[i]);
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
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
            K k2 = kArr[i2];
            if (k2 != null) {
                stringBuilder.append(", ");
                stringBuilder.append(k2);
                stringBuilder.append(com.alipay.sdk.m.n.a.h);
                stringBuilder.append(iArr[i2]);
            }
            i = i2;
        }
    }

    public com.badlogic.gdx.utils.ObjectIntMap.Values values() {
        if (this.E == null) {
            this.E = new com.badlogic.gdx.utils.ObjectIntMap.Values(this);
            this.F = new com.badlogic.gdx.utils.ObjectIntMap.Values(this);
        }
        com.badlogic.gdx.utils.ObjectIntMap.Values values = this.E;
        if (values.v) {
            this.F.reset();
            com.badlogic.gdx.utils.ObjectIntMap.Values values2 = this.F;
            values2.v = true;
            this.E.v = false;
            return values2;
        }
        values.reset();
        com.badlogic.gdx.utils.ObjectIntMap.Values values3 = this.E;
        values3.v = true;
        this.F.v = false;
        return values3;
    }
}
